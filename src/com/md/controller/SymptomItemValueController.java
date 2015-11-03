package com.md.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.Constant;
import com.md.common.DateUtil;
import com.md.common.ResponseObj;
import com.md.entity.Customer;
import com.md.entity.Diagnose;
import com.md.entity.DiagnoseDetail;
import com.md.entity.DiagnoseResult;
import com.md.entity.SymptomItemValue;
import com.md.service.CustomerService;
import com.md.service.DiagnoseService;
import com.md.service.SymptomItemValueService;
import com.md.service.impl.PDFUtils;

/**
 * 
 * @author wzb
 */
@Controller
@RequestMapping("/md/symptomItemValue")
public class SymptomItemValueController extends BaseController{
	
	@Resource
	private SymptomItemValueService symptomItemValueService;
	
	@Resource
	private DiagnoseService diagnoseService;
	
	@Resource
	private CustomerService customerService;
	
	@Resource
	private PDFUtils pDFUtils;
	
	/**
	 * 跳转tab标签页面
	 */
	@RequestMapping(value = "/jspSymptomItemTab")
	public String jspSymptomItemTab(HttpServletRequest request,Model model,String id){
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		sex = request.getParameter("sex");
		if(StringUtils.isBlank(sex)){
			//传进来的sex如果为空，则代表，是第一次进来
			if(null == loginCustomer){
				sex = String.valueOf(Constant.SEX_1);
			}
			else{
				sex = loginCustomer.getSex().toString();
			}
		}
		
		SymptomItemValue symptomItemValue = new SymptomItemValue();
		symptomItemValue.setSex(Integer.parseInt(sex));
		List<SymptomItemValue> symptomItemValueList = symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		List<SymptomItemValue> symptomValueListType1 = new ArrayList<SymptomItemValue>();
		List<SymptomItemValue> symptomValueListType2 = new ArrayList<SymptomItemValue>();
		List<SymptomItemValue> symptomValueListType3 = new ArrayList<SymptomItemValue>();
		List<SymptomItemValue> symptomValueListType4 = new ArrayList<SymptomItemValue>();
		List<SymptomItemValue> symptomValueListType5 = new ArrayList<SymptomItemValue>();
		List<SymptomItemValue> symptomValueListType6 = new ArrayList<SymptomItemValue>();
		
		for(SymptomItemValue  siv:symptomItemValueList){
			switch (Integer.parseInt(siv.getType())) {
			case 1:
				symptomValueListType1.add(siv);
				break;
			case 2:
				symptomValueListType2.add(siv);			
				break;
			case 3:
				symptomValueListType3.add(siv);
				break;
			case 4:
				symptomValueListType4.add(siv);
				break;
			case 5:
				symptomValueListType5.add(siv);
				break;
			case 6:
				symptomValueListType6.add(siv);
				break;
			default:
				break;
			}
		}
		
		model.addAttribute("sex",sex);
		model.addAttribute("isLogin",isLogin);
		
		model.addAttribute("symptomValueListType1", symptomValueListType1);
		model.addAttribute("symptomValueListType2", symptomValueListType2);
		model.addAttribute("symptomValueListType3", symptomValueListType3);
		model.addAttribute("symptomValueListType4", symptomValueListType4);
		model.addAttribute("symptomValueListType5", symptomValueListType5);
		model.addAttribute("symptomValueListType6", symptomValueListType6);
		return "symptomitem/symptomitem_tab";
	}
	
	
	/**
	 * 获取美妹标签数据
	 * 跳转tab标签页面
	 */
	@RequestMapping(value = "/jspSymptomItemTabMeimei")
	public String jspSymptomItemTabMeimei(HttpServletRequest request,Model model,String id){
		//美妹标签数据，全是女性标签数据
		
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		
		SymptomItemValue symptomItemValue = new SymptomItemValue();
		symptomItemValue.setSex(Constant.SEX_2);
		symptomItemValue.setMeimei(Constant.DIAGNOSTIC_LOOK);
		List<SymptomItemValue> symptomItemValueListMeimei1= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setMeimei(Constant.DIAGNOSTIC_SMELL);
		List<SymptomItemValue> symptomItemValueListMeimei2= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setMeimei(Constant.DIAGNOSTIC_ASK);
		List<SymptomItemValue> symptomItemValueListMeimei3= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setMeimei(Constant.DIAGNOSTIC_PULSE);
		List<SymptomItemValue> symptomItemValueListMeimei4= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		
		//model.addAttribute("sex",sex);
		model.addAttribute("isLogin",isLogin);
		
		model.addAttribute("symptomItemValueListMeimei1", symptomItemValueListMeimei1);
		model.addAttribute("symptomItemValueListMeimei2", symptomItemValueListMeimei2);
		model.addAttribute("symptomItemValueListMeimei3", symptomItemValueListMeimei3);
		model.addAttribute("symptomItemValueListMeimei4", symptomItemValueListMeimei4);
		
		return "symptomitem/symptomitem_tab_meimei";
	}
	
	/**
	 * 获取小儿标签数据
	 * 跳转tab标签页面
	 */
	@RequestMapping(value = "/jspSymptomItemTabXiaoer")
	public String jspSymptomItemTabXiaoer(HttpServletRequest request,Model model,String id){
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		sex = request.getParameter("sex");
		if(StringUtils.isBlank(sex)){
			//传进来的sex如果为空，则代表，是第一次进来
			if(null == loginCustomer){
				sex = String.valueOf(Constant.SEX_1);
			}
			else{
				sex = loginCustomer.getSex().toString();
			}
		}
		
		SymptomItemValue symptomItemValue = new SymptomItemValue();
		symptomItemValue.setSex(Integer.parseInt(sex));
		symptomItemValue.setXiaoer(Constant.DIAGNOSTIC_LOOK);
		List<SymptomItemValue> symptomItemValueListXiaoer1= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setXiaoer(Constant.DIAGNOSTIC_SMELL);
		List<SymptomItemValue> symptomItemValueListXiaoer2= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setXiaoer(Constant.DIAGNOSTIC_ASK);
		List<SymptomItemValue> symptomItemValueListXiaoer3= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setXiaoer(Constant.DIAGNOSTIC_PULSE);
		List<SymptomItemValue> symptomItemValueListXiaoer4= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		
		model.addAttribute("sex",sex);
		model.addAttribute("isLogin",isLogin);
		
		model.addAttribute("symptomItemValueListXiaoer1", symptomItemValueListXiaoer1);
		model.addAttribute("symptomItemValueListXiaoer2", symptomItemValueListXiaoer2);
		model.addAttribute("symptomItemValueListXiaoer3", symptomItemValueListXiaoer3);
		model.addAttribute("symptomItemValueListXiaoer4", symptomItemValueListXiaoer4);
	
		return "symptomitem/symptomitem_tab_xiaoer";
	}
	
	
	/**
	 * 获取爸妈标签数据
	 * 跳转tab标签页面
	 */
	@RequestMapping(value = "/jspSymptomItemTabBama")
	public String jspSymptomItemTabBama(HttpServletRequest request,Model model,String id){
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);

		sex = request.getParameter("sex");
		if(StringUtils.isBlank(sex)){
			//传进来的sex如果为空，则代表，是第一次进来
			if(null == loginCustomer){
				sex = String.valueOf(Constant.SEX_1);
			}
			else{
				sex = loginCustomer.getSex().toString();
			}
		}
		
		SymptomItemValue symptomItemValue = new SymptomItemValue();
		symptomItemValue.setSex(Integer.parseInt(sex));
		symptomItemValue.setBama(Constant.DIAGNOSTIC_LOOK);
		List<SymptomItemValue> symptomItemValueListBama1= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setBama(Constant.DIAGNOSTIC_SMELL);
		List<SymptomItemValue> symptomItemValueListBama2= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setBama(Constant.DIAGNOSTIC_ASK);
		List<SymptomItemValue> symptomItemValueListBama3= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		symptomItemValue.setBama(Constant.DIAGNOSTIC_PULSE);
		List<SymptomItemValue> symptomItemValueListBama4= symptomItemValueService.querySymptomItemValueInfo(symptomItemValue);
		
		
		model.addAttribute("sex",sex);
		model.addAttribute("isLogin",isLogin);
		
		model.addAttribute("symptomItemValueListBama1", symptomItemValueListBama1);
		model.addAttribute("symptomItemValueListBama2", symptomItemValueListBama2);
		model.addAttribute("symptomItemValueListBama3", symptomItemValueListBama3);
		model.addAttribute("symptomItemValueListBama4", symptomItemValueListBama4);
		return "symptomitem/symptomitem_tab_bama";
	}
	
	/**
	 * 处理诊断业务信息
	 *      request : SpringMvc固定参数
	 *       model  : SpringMvc固定参数
	 * symptomItem  : 客户勾选的症状
	 * mainSymptom  : 客户勾选主要症状
	 */
	@RequestMapping(value = "/doSymptomItem")
	@ResponseBody  
	public Object doSymptomItem(HttpServletRequest request,Model model,String[] symptomItem,String mainSymptom,String sex){
		DiagnoseResult diagnoseResult = null;
		try {
			 HttpSession session =  request.getSession();
			 Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
			 diagnoseResult = diagnoseService.doDiagnose(symptomItem,mainSymptom,loginCustomer,sex);
			 String publishPath = request.getScheme() + "://" + request.getServerName()
					 +":" + request.getServerPort()+ request.getContextPath() + "/";
			 return new ResponseObj(Constant.STATUSCODE_SUCCESS, "操作成功", "hjm", "", "forward", publishPath+"md/symptomItemValue/doSymptomItemJsp.do?diagnoseResultId="+diagnoseResult.getId());
		} catch (Exception e) {
			 System.out.println(e.getMessage());
			 return new ResponseObj(Constant.STATUSCODE_ERROR, "操作失败", "hjm", "", "forward", "error.html");
		}
	}
	
	/**
	 * 时时诊断   跳转处方结果页面
	 * @param model
	 * @param request
	 * @param diagnoseResultId
	 * @return
	 */
	@RequestMapping(value = "/doSymptomItemJsp")
	public String doSymptomItemJsp(Model model,HttpServletRequest request,String diagnoseResultId){
		//诊断结果信息
		DiagnoseResult diagnoseResult = diagnoseService.queryDiagnoseResultSingle(Long.parseLong(diagnoseResultId));
		
		//诊断症状信息
		List<DiagnoseDetail> diagnoseDetailList = diagnoseService.queryDiagnoseDetailByDiagnoseId(diagnoseResult.getDiagnose_id());
		
		//获取客户信息，有可能是匿名用户
		Customer customer = customerService.queryCustomerById(diagnoseResult.getCustomer_id());
		
		//次要症状
		int sympLen = diagnoseDetailList.size();
		DiagnoseDetail dd = null;
		String lessSymptomValue = "";
		for(int i=0 ; i<sympLen;i++ ){
			dd = diagnoseDetailList.get(i);
			lessSymptomValue += dd.getSymptom_time_value_name() + ",";
		}
		
		if(!StringUtils.isBlank(lessSymptomValue)){
			lessSymptomValue.substring(0, lessSymptomValue.length()-1);
		}
		diagnoseResult.setLessSymptomValue(lessSymptomValue);
		diagnoseResult.setDiagnose_result_time(DateUtil.timeFormatToStr1(diagnoseResult.getDiagnose_result_time()));
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		//是否是查看诊断历史
		String viewType = request.getParameter("viewType");  //只有历史查看时，这参数才有值
		String jumpUrl = "symptomitem/symptomitem_result_common";
		
		//匿名、普通用户、历史浏览
		if(null == loginCustomer || 
		   Constant.CUSTOMER_TYPE_1.equals(loginCustomer.getCustomer_type()) || 
		   "1".equals(viewType)){
			jumpUrl = "symptomitem/symptomitem_result_common";
		}
		
		//认证/缴费用户
		if(null != loginCustomer && 
		   Constant.CUSTOMER_TYPE_2.equals(loginCustomer.getCustomer_type())){
			jumpUrl = "symptomitem/symptomitem_result_pay";
		}
		
		//普通管理员
		if(null != loginCustomer && 
		   Constant.CUSTOMER_TYPE_3.equals(loginCustomer.getCustomer_type())){
			jumpUrl = "symptomitem/symptomitem_result_common_manager";
		}
		
		//超级管理员
		if(null != loginCustomer && 
		   Constant.CUSTOMER_TYPE_4.equals(loginCustomer.getCustomer_type())){
			jumpUrl = "symptomitem/symptomitem_result_manager";
		}
		
		model.addAttribute("viewType", viewType);
		model.addAttribute("customer", customer);
		model.addAttribute("diagnoseResult", diagnoseResult);
		
		return jumpUrl;
	}
	
	
	
	/**
	 * 查看历史诊断信息   跳转处方结果页面
	 * @param model
	 * @param request
	 * @param diagnoseResultId
	 * @return
	 */
	@RequestMapping(value = "/doSymptomItemJspHis")
	public String doSymptomItemJspHis(Model model,HttpServletRequest request,String diagnoseResultId){
		//诊断结果信息
		DiagnoseResult diagnoseResult = diagnoseService.queryDiagnoseResultSingle(Long.parseLong(diagnoseResultId));
		
		//获取诊断信息
		Diagnose diagnose = diagnoseService.queryDiagnoseByPk(diagnoseResult.getDiagnose_id());
		
		//诊断症状信息
		List<DiagnoseDetail> diagnoseDetailList = diagnoseService.queryDiagnoseDetailByDiagnoseId(diagnoseResult.getDiagnose_id());
		
		//获取客户信息，有可能是匿名用户
		Customer customer = customerService.queryCustomerById(diagnoseResult.getCustomer_id());
		
		//次要症状
		int sympLen = diagnoseDetailList.size();
		DiagnoseDetail dd = null;
		String lessSymptomValue = "";
		for(int i=0 ; i<sympLen;i++ ){
			dd = diagnoseDetailList.get(i);
			lessSymptomValue += dd.getSymptom_time_value_name() + ",";
		}
		
		if(!StringUtils.isBlank(lessSymptomValue)){
			lessSymptomValue.substring(0, lessSymptomValue.length()-1);
		}
		diagnoseResult.setLessSymptomValue(lessSymptomValue);
		diagnoseResult.setDiagnose_result_time(DateUtil.timeFormatToStr1(diagnoseResult.getDiagnose_result_time()));
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		//是否是查看诊断历史
		String viewType = request.getParameter("viewType");  //只有历史查看时，这参数才有值
		String jumpUrl = "diagnose/diagnose_result_his_common";
		
		//匿名、普通用户、历史浏览
		if(null == loginCustomer || 
		   Constant.CUSTOMER_TYPE_1.equals(loginCustomer.getCustomer_type()) || 
		   "1".equals(viewType)){
			jumpUrl = "diagnose/diagnose_result_his_common";
		}
		
		//认证/缴费用户
		if(null != loginCustomer && 
		   Constant.CUSTOMER_TYPE_2.equals(loginCustomer.getCustomer_type())){
			jumpUrl = "diagnose/diagnose_result_his_pay";
		}
		
		//管理员
		if(null != loginCustomer && 
		   Constant.CUSTOMER_TYPE_3.equals(loginCustomer.getCustomer_type())){
			jumpUrl = "diagnose/diagnose_result_his_manager";
		}
		
		//更改已经查看
		Diagnose tempDiagnose = new Diagnose();
		tempDiagnose.setId(diagnoseResult.getDiagnose_id());
		tempDiagnose.setIs_look(Constant.CUSTOMER_IS_LOOK_2);
		diagnoseService.editDiagnose(tempDiagnose);
		
		//获取诊断医生的签名
		if(null != diagnose.getDoctor_id()){
			Customer docCustomer = customerService.queryCustomerById(diagnose.getDoctor_id());
			String doctor_sign_name = docCustomer.getDoctor_sign_name();
			model.addAttribute("doctor_sign_name", doctor_sign_name);
		}
		
		model.addAttribute("viewType", viewType);
		model.addAttribute("customer", customer);
		model.addAttribute("diagnoseResult", diagnoseResult);
		model.addAttribute("diagnose", diagnose);
		return jumpUrl;
	}
	
	
	/**
	 * 专家查看客户诊断信息
	 * @param model
	 * @param request
	 * @param diagnoseResultId
	 * @return
	 */
	@RequestMapping(value = "/doSymptomItemJspExpert")
	public String doSymptomItemJspExpert(Model model,HttpServletRequest request,String diagnoseResultId){
		//诊断结果信息
		DiagnoseResult diagnoseResult = diagnoseService.queryDiagnoseResultSingle(Long.parseLong(diagnoseResultId));
		
		Diagnose diagnose = diagnoseService.queryDiagnoseByPk(diagnoseResult.getDiagnose_id());
		
		//诊断症状信息
		List<DiagnoseDetail> diagnoseDetailList = diagnoseService.queryDiagnoseDetailByDiagnoseId(diagnoseResult.getDiagnose_id());
		
		//获取客户信息，有可能是匿名用户
		Customer customer = customerService.queryCustomerById(diagnoseResult.getCustomer_id());
		
		//次要症状
		int sympLen = diagnoseDetailList.size();
		DiagnoseDetail dd = null;
		String lessSymptomValue = "";
		for(int i=0 ; i<sympLen;i++ ){
			dd = diagnoseDetailList.get(i);
			lessSymptomValue += dd.getSymptom_time_value_name() + ",";
		}
		
		if(!StringUtils.isBlank(lessSymptomValue)){
			lessSymptomValue.substring(0, lessSymptomValue.length()-1);
		}
		diagnoseResult.setLessSymptomValue(lessSymptomValue);
		diagnoseResult.setDiagnose_result_time(DateUtil.timeFormatToStr1(diagnoseResult.getDiagnose_result_time()));
		
		//是否是查看诊断历史
		String jumpUrl = "expert/expert_result_pay";
		
		
		//获取诊断医生的签名
		if(null != diagnose.getDoctor_id()){
			Customer docCustomer = customerService.queryCustomerById(diagnose.getDoctor_id());
			String doctor_sign_name = docCustomer.getDoctor_sign_name();
			model.addAttribute("doctor_sign_name", doctor_sign_name);
		}
		
		model.addAttribute("customer", customer);
		model.addAttribute("diagnoseResult", diagnoseResult);
		model.addAttribute("diagnose", diagnose);
		
		return jumpUrl;
	}
	
	
	/**
	 * 专家查看客户诊断信息
	 * @param model
	 * @param request
	 * @param diagnoseResultId
	 * @return
	 */
	@RequestMapping(value = "/doSymptomItemJspExpertHis")
	public String doSymptomItemJspExpertHis(Model model,HttpServletRequest request,String diagnoseResultId){
		//诊断结果信息
		DiagnoseResult diagnoseResult = diagnoseService.queryDiagnoseResultSingle(Long.parseLong(diagnoseResultId));
		
		Diagnose diagnose = diagnoseService.queryDiagnoseByPk(diagnoseResult.getDiagnose_id());
		
		//诊断症状信息
		List<DiagnoseDetail> diagnoseDetailList = diagnoseService.queryDiagnoseDetailByDiagnoseId(diagnoseResult.getDiagnose_id());
		
		//获取客户信息，有可能是匿名用户
		Customer customer = customerService.queryCustomerById(diagnoseResult.getCustomer_id());
		
		//次要症状
		int sympLen = diagnoseDetailList.size();
		DiagnoseDetail dd = null;
		String lessSymptomValue = "";
		for(int i=0 ; i<sympLen;i++ ){
			dd = diagnoseDetailList.get(i);
			lessSymptomValue += dd.getSymptom_time_value_name() + ",";
		}
		
		if(!StringUtils.isBlank(lessSymptomValue)){
			lessSymptomValue.substring(0, lessSymptomValue.length()-1);
		}
		diagnoseResult.setLessSymptomValue(lessSymptomValue);
		diagnoseResult.setDiagnose_result_time(DateUtil.timeFormatToStr1(diagnoseResult.getDiagnose_result_time()));
		
		//是否是查看诊断历史
		String jumpUrl = "expert/expert_result_pay_his";
		
		//获取诊断医生的签名
		if(null != diagnose.getDoctor_id()){
			Customer docCustomer = customerService.queryCustomerById(diagnose.getDoctor_id());
			String doctor_sign_name = docCustomer.getDoctor_sign_name();
			model.addAttribute("doctor_sign_name", doctor_sign_name);
		}
		
		model.addAttribute("customer", customer);
		model.addAttribute("diagnoseResult", diagnoseResult);
		model.addAttribute("diagnose", diagnose);
		
		return jumpUrl;
	}
	
	
	/**
	 * 下载诊断结果信息
	 * @param model
	 * @param request
	 * @param diagnoseResultId
	 * @return
	 */
	@RequestMapping(value = "/doGenerateDoanLoadPdf")
	public void doGenerateDoanLoadPdf(Model model,HttpServletRequest request,HttpServletResponse response,String diagnoseResultId){
		//诊断结果信息
		DiagnoseResult diagnoseResult = diagnoseService.queryDiagnoseResultSingle(Long.parseLong(diagnoseResultId));
		
		//获取诊断信息
		Diagnose diagnose = diagnoseService.queryDiagnoseByPk(diagnoseResult.getDiagnose_id());
		
		//诊断症状信息
		List<DiagnoseDetail> diagnoseDetailList = diagnoseService.queryDiagnoseDetailByDiagnoseId(diagnoseResult.getDiagnose_id());
		
		//获取客户信息，有可能是匿名用户
		Customer customer = customerService.queryCustomerById(diagnoseResult.getCustomer_id());
		
		//次要症状
		int sympLen = diagnoseDetailList.size();
		DiagnoseDetail dd = null;
		String lessSymptomValue = "";
		for(int i=0 ; i<sympLen;i++ ){
			dd = diagnoseDetailList.get(i);
			lessSymptomValue += dd.getSymptom_time_value_name() + ",";
		}
		
		if(!StringUtils.isBlank(lessSymptomValue)){
			lessSymptomValue.substring(0, lessSymptomValue.length()-1);
		}
		diagnoseResult.setLessSymptomValue(lessSymptomValue);
		diagnoseResult.setDiagnose_result_time(DateUtil.timeFormatToStr1(diagnoseResult.getDiagnose_result_time()));
		
		//获取诊断医生的签名
		String doctor_sign_name = "";
		if(null != diagnose.getDoctor_id()){
			Customer docCustomer = customerService.queryCustomerById(diagnose.getDoctor_id());
			doctor_sign_name = docCustomer.getDoctor_sign_name();
		}
		
		String projectRootPath = request.getSession().getServletContext().getRealPath("/"); 
		
		//客户ID+“_”+诊断ID
		String pdfFileName = String.valueOf(customer.getId())+"_"+diagnose.getId();
		String generateFilePath = projectRootPath + "pdf\\" + pdfFileName+".pdf";
		
		try {
			File pdfFile = new File(generateFilePath);
			if(!pdfFile.exists()){
			   //不存在，则创建
				String docSignPath = projectRootPath + "images\\expert\\" + doctor_sign_name ;
				pDFUtils.writePdf(diagnoseResult ,customer,generateFilePath, docSignPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//下载pdf文件
		try {
		    response.setContentType("text/html;charset=UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	  
	        long fileLength = new File(generateFilePath).length();  
	  
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String((pdfFileName+".pdf").getBytes("utf-8"), "ISO8859-1"));  
	        response.setHeader("Content-Length", String.valueOf(fileLength));  
	  
	        bis = new BufferedInputStream(new FileInputStream(generateFilePath));  
	        bos = new BufferedOutputStream(response.getOutputStream());  
	        byte[] buff = new byte[2048];  
	        int bytesRead;  
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	            bos.write(buff, 0, bytesRead);  
	        }  
	        bis.close();  
	        bos.close();  
	    	
		} catch (Exception e) {
		}
	}
}
