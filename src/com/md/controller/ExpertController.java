package com.md.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.BaseConditionVO;
import com.md.common.Constant;
import com.md.common.DateUtil;
import com.md.common.ResponseEnvelope;
import com.md.common.ResponseObj;
import com.md.entity.Customer;
import com.md.entity.Diagnose;
import com.md.entity.DiagnoseResult;
import com.md.service.CustomerService;
import com.md.service.DiagnoseService;

/***
 * 针对专家的操作控制器
 * @author owen
 *
 */
@Controller
@RequestMapping("/md/expert")
public class ExpertController extends BaseController{
	
	@Resource
	private CustomerService customerService;
	
	@Resource
	private DiagnoseService diagnoseService;
	
	/**
	 * 显示在线医生信息
	 * 1、显示医生信息之前，先把病人主诉及病史记录进去
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryExpertInfoList")
	public String queryExpertInfoList(BaseConditionVO vo,HttpServletRequest request,Model model,
			Long diagnoseId,String report,String medical_history,String sick_name,Integer sick_age,Integer isIe){
		
		String forward = "expert/expertList";
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		//sick_name = java.net.URLDecoder.decode(sick_name,"utf-8");
		
		if(null == loginCustomer){
			forward =  "expert/expert_msg_common";
			model.addAttribute("isLogin", "0");  //没登录
		}
		else if( Constant.CUSTOMER_TYPE_1.equals(loginCustomer.getCustomer_type()) ){
			//普通用户:需提示其缴费，然后才能用此功能
			forward =  "expert/expert_msg_common";
			model.addAttribute("isLogin", "1"); //已登录
			model.addAttribute("loginCustomer", loginCustomer);
		}
		else if( Constant.CUSTOMER_TYPE_2.equals(loginCustomer.getCustomer_type()) ){
			Diagnose diagnose = diagnoseService.queryDiagnoseByPk(diagnoseId);
			if(diagnose.getCustomer_id().compareTo(loginCustomer.getId()) != 0){
				model.addAttribute("expert_msg", "诊断客户与当前登录用户不一致");
				forward =  "expert/expert_msg_other";
			}
			else{
				if(null != diagnose.getDoctor_id()){
					model.addAttribute("expert_msg", "诊断客户已经联系医生(此次诊断)");
					forward =  "expert/expert_msg_other";
				}
				else{
					//1、更改诊断申请回复状态
					Diagnose tempDiagnose = new Diagnose();
					tempDiagnose.setId(diagnoseId);
					tempDiagnose.setApply_reply_status(Constant.APPLY_REPLY_STATUS_2);  //客户已申请
					diagnoseService.editDiagnose(tempDiagnose);
					
					//2、把病人主诉及病史记录进去
					DiagnoseResult dr = new DiagnoseResult();
					if(!StringUtils.isBlank(report) || !StringUtils.isBlank(medical_history)){
						dr.setDiagnose_id(diagnoseId);
						try {
							//ajax请求过来的数据，出现乱码
							String uniCode = "UTF-8";
							if(isIe == 1){
								uniCode = "GBK";
							}
							dr.setReport(new String(report.getBytes("ISO8859-1"), uniCode));
							dr.setMedical_history(new String(medical_history.getBytes("ISO8859-1"), uniCode)); 
							dr.setSick_name(new String(sick_name.getBytes("ISO8859-1"), uniCode));
							dr.setSick_age(sick_age);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						diagnoseService.editDiagnoseResult(dr);
					}
					
					//认证/缴费用户
					Map<String, Object> mapParmas = new HashMap<String,Object>();
					
					mapParmas.put("start", vo.getStartIndex());
					mapParmas.put("limit", vo.getPageSize());
					
					Customer domain = new Customer();
					domain.setCustomer_type(Constant.CUSTOMER_TYPE_10);
					mapParmas.put("domain", domain);
					
					List<Customer> expertInfoList = customerService.queryExpertData(mapParmas);
					Integer totalCount = customerService.queryExpertCount(mapParmas);
					vo.setTotalCount(totalCount);
					
					model.addAttribute("diagnoseId", diagnoseId);
					model.addAttribute("vo", vo);
					model.addAttribute("totalCount", totalCount);
					model.addAttribute("pageSize", vo.getPageSize());
					model.addAttribute("expertInfoList", expertInfoList);
				}
			}
		}
		else{
			model.addAttribute("expert_msg", "只有普通用户等才能进入");
			forward =  "expert/expert_msg_other";
		}
		
		return forward;
	}
	
	/**
	 * 联系医生
	 * @return
	 */
	@RequestMapping(value = "/contactExpertCustomer")
	@ResponseBody 
	public Object contactExpertCustomer(HttpServletRequest request,Model model,Long diagnoseId,Long expertCustomerId){
		String msg = "";
		boolean success = true;
		ResponseEnvelope<Object> re = new ResponseEnvelope<Object>(); 
		try {
			HttpSession session =  request.getSession();
			Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
			Diagnose diagnose = diagnoseService.queryDiagnoseByPk(diagnoseId);
			if(diagnose.getCustomer_id().compareTo(loginCustomer.getId()) != 0){
				//诊断信息用户与当前session用户不一致时，是不能进行诊断的
				msg = "诊断客户与当前登录用户不一致";
				success = false;
			}
			else{
				//把诊断信息与诊断医生关联起来
				diagnose.setDoctor_id(expertCustomerId);
				diagnoseService.editDiagnose(diagnose);
				msg = "联系成功，24小时内请查看本人诊断历史信息" ;
			}
			re.setSuccess(success);
			re.setMessage(msg);
		} catch (Exception e) {
			re.setSuccess(false);
			re.setMessage("联系医生失败");
		}
	    return re;
	}
	
	
	/**
	 *  医生诊断
	 * @return
	 */
	@RequestMapping(value = "/expertCheck2")
	@ResponseBody 
	public Object expertCheck2(HttpServletRequest request,Model model,Long diagnoseId,String prescription6_medicinal){
		boolean success = true;
		ResponseEnvelope<Object> re = new ResponseEnvelope<Object>(); 
		try {
			//1、更改处方结果，医生确认后的处方
			DiagnoseResult dr = new DiagnoseResult();
			dr.setDiagnose_id(diagnoseId);
			dr.setPrescription6_medicinal(prescription6_medicinal);
			diagnoseService.editDiagnoseResult(dr);
			
			//2、更改处方表，已确诊，已回复等
			Diagnose diagnose = new Diagnose();
			diagnose.setId(diagnoseId);
			diagnose.setApply_reply_status(Constant.APPLY_REPLY_STATUS_3);//专家已回复
			String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
			String currenyDate_date = currenyDate.substring(0, 8);
			String currenyDate_time = currenyDate.substring(8, currenyDate.length());
			diagnose.setReply_date(currenyDate_date);
			diagnose.setReply_time(currenyDate_time);
			diagnoseService.editDiagnose(diagnose);
			

			re.setSuccess(success);
			re.setMessage("医生确诊成功");
		} catch (Exception e) {
			//return new ResponseObj(Constant.STATUSCODE_SUCCESS, "确诊失败", "waitingDiagnoseRel", "waitingDiagnoseRel", "forward", publishPath+"md/expert/queryExpertCheckingDiagnoseData.do");
			re.setSuccess(false);
			re.setMessage("医生确诊失败");
		}
	    return re;
	}
	
	
	
	/**
	 *  医生诊断
	 * @return
	 */
	@RequestMapping(value = "/expertCheck")
	@ResponseBody 
	public Object expertCheck(HttpServletRequest request,Model model,Long diagnoseId,String prescription6_medicinal){
		boolean success = true;
		String publishPath = request.getScheme() + "://" + request.getServerName()
				 +":" + request.getServerPort()+ request.getContextPath() + "/";
		//ResponseEnvelope<Object> re = new ResponseEnvelope<Object>(); 
		try {
			//1、更改处方结果，医生确认后的处方
			DiagnoseResult dr = new DiagnoseResult();
			dr.setDiagnose_id(diagnoseId);
			dr.setPrescription6_medicinal(prescription6_medicinal);
			diagnoseService.editDiagnoseResult(dr);
			
			//2、更改处方表，已确诊，已回复等
			Diagnose diagnose = new Diagnose();
			diagnose.setId(diagnoseId);
			diagnose.setApply_reply_status(Constant.APPLY_REPLY_STATUS_3);//专家已回复
			String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
			String currenyDate_date = currenyDate.substring(0, 8);
			String currenyDate_time = currenyDate.substring(8, currenyDate.length());
			diagnose.setReply_date(currenyDate_date);
			diagnose.setReply_time(currenyDate_time);
			diagnose.setIs_look(Constant.CUSTOMER_IS_LOOK_1);
			diagnoseService.editDiagnose(diagnose);
			
			 return new ResponseObj(Constant.STATUSCODE_SUCCESS, "确诊成功", "waitingDiagnoseRel", "waitingDiagnoseRel", "forward", publishPath+"md/expert/queryExpertCheckingDiagnoseData.do");

			//re.setSuccess(success);
			//re.setMessage("医生确诊成功");
		} catch (Exception e) {
			return new ResponseObj(Constant.STATUSCODE_SUCCESS, "确诊失败", "waitingDiagnoseRel", "waitingDiagnoseRel", "forward", publishPath+"md/expert/queryExpertCheckingDiagnoseData.do");
			//re.setSuccess(false);
			//re.setMessage("医生确诊失败");
		}
	    //return re;
	}
	
	/**
	 * 没隔一段时间，验证登入用户是否是医生，且看他未诊断的信息
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/queryWaitingDiagnose")
	@ResponseBody  
	public Object queryWaitingDiagnose(HttpServletRequest request,Model model){
		HttpSession session =  request.getSession();
		ResponseEnvelope<Object> re = new ResponseEnvelope<Object>(false, "不做处理");;
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		if(null != loginCustomer && Constant.CUSTOMER_TYPE_10.equals(loginCustomer.getCustomer_type()) ){
			int waitingCount = diagnoseService.queryCountWaitingExpert(loginCustomer.getId());
			if(waitingCount > 0){
				re.setSuccess(true);
				re.setMessage(loginCustomer.getName()+"大夫,您有"+waitingCount+"份诊断病例需确诊，请进入<<病例管理>>查看");
			}
			re.setData(String.valueOf(waitingCount));
		}
		return re;
	}
	
	/**
	 * 获取该医生待确诊的信息
	 * @param request
	 * @param vo
	 * @param model
	 * @param diagnose
	 * @return
	 */
	@RequestMapping(value = "/queryExpertCheckingDiagnoseData")
	public String queryExpertCheckingDiagnoseData(HttpServletRequest request,BaseConditionVO vo,Model model,Diagnose diagnose){
		
		if(!StringUtils.isBlank(diagnose.getDiagnose_date_start()) &&
		   diagnose.getDiagnose_date_start().length() == 10	){
			diagnose.setDiagnose_date_start(DateUtil.dateFormatToStr2(diagnose.getDiagnose_date_start()));
		}
		
		if(!StringUtils.isBlank(diagnose.getDiagnose_date_end()) &&
		   diagnose.getDiagnose_date_end().length() == 10	){
			diagnose.setDiagnose_date_end(DateUtil.dateFormatToStr2(diagnose.getDiagnose_date_end()));
		}
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		diagnose.setDoctor_id(loginCustomer.getId());
		
		Map<String, Object> mapParams = new HashMap<String,Object>();
		mapParams.put("start", vo.getStartIndex());
		mapParams.put("limit", vo.getPageSize());
		mapParams.put("domain",diagnose);
		
		List<Diagnose> expertCheckingDiagnoseList = diagnoseService.queryExpertCheckingDiagnoseData(mapParams);
		Integer totalCount = diagnoseService.queryExpertCheckingDiagnoseCount(mapParams);
		
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("expertCheckingDiagnoseList", expertCheckingDiagnoseList);
		return "expert/expertCheckingDiagnoseList";
	}
	
	
	/**
	 * 获取该医生已确诊的信息
	 * @param request
	 * @param vo
	 * @param model
	 * @param diagnose
	 * @return
	 */
	@RequestMapping(value = "/queryExpertCheckedDiagnoseData")
	public String queryExpertCheckedDiagnoseData(HttpServletRequest request,BaseConditionVO vo,Model model,Diagnose diagnose){
		
		if(!StringUtils.isBlank(diagnose.getDiagnose_date_start()) &&
		   diagnose.getDiagnose_date_start().length() == 10	){
			diagnose.setDiagnose_date_start(DateUtil.dateFormatToStr2(diagnose.getDiagnose_date_start()));
		}
		
		if(!StringUtils.isBlank(diagnose.getDiagnose_date_end()) &&
		   diagnose.getDiagnose_date_end().length() == 10	){
			diagnose.setDiagnose_date_end(DateUtil.dateFormatToStr2(diagnose.getDiagnose_date_end()));
		}
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		diagnose.setDoctor_id(loginCustomer.getId());
		
		Map<String, Object> mapParams = new HashMap<String,Object>();
		mapParams.put("start", vo.getStartIndex());
		mapParams.put("limit", vo.getPageSize());
		mapParams.put("domain",diagnose);
		
		List<Diagnose> expertCheckedDiagnoseList = diagnoseService.queryExpertCheckedDiagnoseData(mapParams);
		Integer totalCount = diagnoseService.queryExpertCheckedDiagnoseCount(mapParams);
		
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("expertCheckedDiagnoseList", expertCheckedDiagnoseList);
		return "expert/expertCheckedDiagnoseList";
	}
	
}
