package com.md.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
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
import com.md.entity.CustomerApplyinfo;
import com.md.entity.SymptomItemValue;
import com.md.service.CustomerApplyinfoService;
import com.md.service.CustomerService;
import com.md.service.DiagnoseService;
import com.md.service.DynamicPwdService;
import com.md.service.SymptomItemValueService;
import com.md.thread.WindowCloseThread;
import com.md.util.XMLParse;

@Controller
@RequestMapping("/md/customer")
public class CustomerController extends BaseController{
	
	@Resource
	private CustomerService customerService;
	
	@Resource
	private CustomerApplyinfoService customerApplyinfoService;
	
	@Resource
	private DynamicPwdService dynamicPwdService; 
	
	@Resource
	private SymptomItemValueService symptomItemValueService;
	
	@Resource
	private DiagnoseService diagnoseService;
	
	@Resource
	private WindowCloseThread windowCloseThread;
	
	@Value("#{configProperties['isDynamicLogin']}")
	private boolean isDynamicLogin; //动态密码_企业编号、读取配置文件中dynamic_id
	
	/**
	 * 普通用户名登录(一级普通)
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/loginIn")
	@ResponseBody  
	public Object loginIn(HttpServletRequest request,Model model,Customer customer){
		ResponseEnvelope<Object> re = null;
		//根据customer中，登录名、登录密码不能为空，前台验证。
		Customer loginCustoemr = customerService.queryCustomerByLoginNamePwd(customer);
		if(null == loginCustoemr){
			re = new ResponseEnvelope<Object>(false,Constant.LOGIN_MSG_ERROR );
		}
		else if(!(Constant.CUSTOMER_TYPE_1.equals(loginCustoemr.getCustomer_type()) || 
				  Constant.CUSTOMER_TYPE_2.equals(loginCustoemr.getCustomer_type()) )){
			//目前  客户类型1、客户类型2是普通登录的
			re = new ResponseEnvelope<Object>(false,Constant.LOGIN_MSG_ERROR_1 );
		}
		else{
			//修改登录时间
			String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
			loginCustoemr.setUpdate_time(currenyDate);
			loginCustoemr.setIs_on_line(Constant.ONLINE_YES);
			loginCustoemr.setKnow_status(Constant.KNOW_STATUS_1);
			customerService.editCustomer(loginCustoemr);
			HttpSession session =  request.getSession();
			session.setAttribute(Constant.SESSION_ID, loginCustoemr);
			
			//windowCloseThread.addCustomerSessionMap(loginCustoemr);
			
			re = new ResponseEnvelope<Object>(true,Constant.LOGIN_MSG_SUCCES );
			String publishPath = request.getScheme() + "://" + request.getServerName()
					 +":" + request.getServerPort()+ request.getContextPath() + "/";
			re.setUrl(publishPath+"/md/customer/mainForward.do");
		}
		return re;
	}
	
	/**
	 * 管理员登录(普通管理员、高级管理员)
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/loginAdminIn")
	@ResponseBody  
	public Object loginAdminIn(HttpServletRequest request,Model model,Customer customer){
		ResponseEnvelope<Object> re = null;
		//根据customer中，登录名、登录密码不能为空，前台验证。
		Customer loginCustoemr = customerService.queryCustomerByLoginNamePwd(customer);
		if(null == loginCustoemr){
			re = new ResponseEnvelope<Object>(false,Constant.LOGIN_MSG_ERROR );
		}
		else if(Constant.CUSTOMER_TYPE_1.equals(loginCustoemr.getCustomer_type()) ||
				Constant.CUSTOMER_TYPE_2.equals(loginCustoemr.getCustomer_type()) ){
			re = new ResponseEnvelope<Object>(false,Constant.LOGIN_MSG_ERROR_3 );
		}
		else{
			/*if(Constant.CUSTOMER_TYPE_10.equals(loginCustoemr.getCustomer_type())){
				//如果是专家/值班医生时，则更新其在线状态。
				loginCustoemr.setIs_on_line(Constant.ONLINE_YES);
			}*/
			
			loginCustoemr.setIs_on_line(Constant.ONLINE_YES);
			loginCustoemr.setKnow_status(Constant.KNOW_STATUS_1);
			
			if(isDynamicLogin == false){
				String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
				loginCustoemr.setUpdate_time(currenyDate);
				customerService.editCustomer(loginCustoemr);
				HttpSession session =  request.getSession();
				session.setAttribute(Constant.SESSION_ID, loginCustoemr);
				
				//windowCloseThread.addCustomerSessionMap(loginCustoemr);
				
				re = new ResponseEnvelope<Object>(true,Constant.LOGIN_MSG_SUCCES );
				String publishPath = request.getScheme() + "://" + request.getServerName()
						 +":" + request.getServerPort()+ request.getContextPath() + "/";
				re.setUrl(publishPath+"/md/customer/mainForward.do");
			}
			else{
				String actionValue = "{action:'authenticate',param:{eid:'"+ Constant.DYNAMIC_COMPANY_ID +"',uid:'"+customer.getLogin_name()+"',otp:'"+customer.getLogin_dynamic_pwd()+"',otp2:''}}";
				String responseValue = dynamicPwdService.authenticate(actionValue);
				String responseResult = XMLParse.getResponseResult(responseValue);
				if("0".equals(responseResult)){
					//修改登录时间
					String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
					loginCustoemr.setUpdate_time(currenyDate);
					customerService.editCustomer(customer);
					HttpSession session =  request.getSession();
					session.setAttribute(Constant.SESSION_ID, loginCustoemr);
					
					//windowCloseThread.addCustomerSessionMap(loginCustoemr);
					
					re = new ResponseEnvelope<Object>(true,Constant.LOGIN_MSG_SUCCES );
					String publishPath = request.getScheme() + "://" + request.getServerName()
							 +":" + request.getServerPort()+ request.getContextPath() + "/";
					re.setUrl(publishPath+"/md/customer/mainForward.do");

				}
				else{
					switch (Integer.parseInt(responseResult)) {
					case 1:
						re = new ResponseEnvelope<Object>(false,"重发OTP" );
						break;
					case 2:
						re = new ResponseEnvelope<Object>(false,"认证失败");				
					    break;
					case -1:
						re = new ResponseEnvelope<Object>(false,"用户不存在");
						break;
					case -2:
						re = new ResponseEnvelope<Object>(false,"用户未关联令牌");
						break;
					case -3:
						re = new ResponseEnvelope<Object>(false,"用户未注册");
						break;
					case -4:
						re = new ResponseEnvelope<Object>(false,"令牌已锁");
						break;
					default:
						break;
					}
				}
			}
		}
		return re;
	}
	
	/**
	 * 普通客户申请管理员
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/applyManager")
	@ResponseBody  
	public Object applyManager(HttpServletRequest request,Model model){
		ResponseEnvelope<Object> re = null;
		String msg = "申请管理员成功";
		
		//因为用户是在登录后才看到这页面，所有session中一定有用户
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		
		//客户审批状态验证
		if(!Constant.CUSTOMER_STATUS_1.equals(loginCustomer.getCustomer_status())){
			re = new ResponseEnvelope<Object>(false,Constant.APPLY_MANAGER_MSG_EXISTS );
			return re;
		}
		
		//进行后台开户处理
		String actionValue = "{action:'createUser',param:{eid:'"+ Constant.DYNAMIC_COMPANY_ID +"',uid:'"+loginCustomer.getLogin_name()+"',pwd:'"+loginCustomer.getLogin_pwd()+"'}}";
		String responseValue = dynamicPwdService.authenticate(actionValue);
		String responseResult = XMLParse.getResponseResult(responseValue);
		if("0".equals(responseResult)){
			//创建成功
			String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
			loginCustomer.setCustomer_status(Constant.CUSTOMER_STATUS_2);
			loginCustomer.setApply_time(currenyDate);
			
			Customer tempCustomer = new Customer();
			tempCustomer.setCustomer_status(Constant.CUSTOMER_STATUS_2);
			tempCustomer.setApply_time(currenyDate);
			tempCustomer.setId(loginCustomer.getId());
			customerService.editCustomer(tempCustomer);
			
			session.setAttribute(Constant.SESSION_ID, loginCustomer);
			re = new ResponseEnvelope<Object>(true,msg);
		}
		else{
			switch (Integer.parseInt(responseResult)) {
			case 1:
				msg = "此用户已经申请成功，不需再申请，请等候";
				break;
			case -1:
				msg = "企业编号已存在，请核实";
				break;
			default:
				break;
			}
			re = new ResponseEnvelope<Object>(false,msg);
		}
		return re;
	}
	
	
	/**
	 * 普通激活申请管理员
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/activeManager")
	@ResponseBody  
	public Object activeManager(HttpServletRequest request,Model model){
		ResponseEnvelope<Object> re = null;
		String msg = "激活成功";
		
		//因为用户是在登录后才看到这页面，所有session中一定有用户
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		
		if(!Constant.CUSTOMER_STATUS_3.equals(loginCustomer.getCustomer_status())){
			re = new ResponseEnvelope<Object>(false,Constant.ACTIVE_MANAGER_MSG );
			return re;
		}
		
		//变更激活状态
		Customer tempCustomer = new Customer();
		tempCustomer.setCustomer_status(Constant.CUSTOMER_STATUS_4);
		tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_2);
		tempCustomer.setId(loginCustomer.getId());
		customerService.editCustomer(tempCustomer);
		//清除session，让其重新登录（管理员登录）
		session.removeAttribute(Constant.SESSION_ID);
		re = new ResponseEnvelope<Object>(true,msg);
		return re;
	}
	
	
	/**
	 * 超级管理员进行审批(关联令牌)
	 * 普通客户申请管理员
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/appliedManager")
	@ResponseBody  
	public Object appliedManager(HttpServletRequest request,Model model,Long customerId){
		//ResponseEnvelope<Object> re = null;
		ResponseObj ro = null;//new ResponseObj("200", msg, null, null, null, null);
		String msg = "审批(关联)成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		
		//客户审批状态验证
		if(null == customer || !Constant.CUSTOMER_STATUS_2.equals(customer.getCustomer_status())){
			ro = new ResponseObj("200", Constant.APPLIED_MANAGER_MSG, null, null, null, null);
			return ro;
		}
		
		//进行后台关联处理
		String actionValue = "{action:'associate',param:{eid:'"+ Constant.DYNAMIC_COMPANY_ID +"',uid:'"+customer.getLogin_name()+"',pwd:'"+customer.getLogin_pwd()+"'}}";
		String responseValue = dynamicPwdService.authenticate(actionValue);
		String responseResult = XMLParse.getResponseResult(responseValue);
		if("0".equals(responseResult)){
			//关联成功
			String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
			
			Customer tempCustomer = new Customer();
			tempCustomer.setCustomer_status(Constant.CUSTOMER_STATUS_3);
			//tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_2);
			tempCustomer.setApplied_time(currenyDate);
			tempCustomer.setId(customer.getId());
			customerService.editCustomer(tempCustomer);
		}
		else{
			switch (Integer.parseInt(responseResult)) {
			case 1:
				msg = "此用户不存在，关联失败";
				break;
			case 2:
				msg = "用户已关联令牌";
				break;
			case 3:
				msg = "无令牌可用";
				break;
			default:
				break;
			}
		}
		ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	/**
	 * 超级管理员进行拒绝审批(对这已开户的用户，不进行关联且删除该用户)
	 * 普通客户申请管理员
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/deleteApplyManager")
	@ResponseBody  
	public Object deleteApplyManager(HttpServletRequest request,Model model,Long customerId){
		String msg = "删除成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		//进行后台关联处理
		String actionValue = "{action:'delUser',param:{eid:'"+ Constant.DYNAMIC_COMPANY_ID +"',uid:'"+customer.getLogin_name()+"'}}";
		String responseValue = dynamicPwdService.authenticate(actionValue);
		String responseResult = XMLParse.getResponseResult(responseValue);
		if("0".equals(responseResult)){
			//删除成功
			Customer tempCustomer = new Customer();
			tempCustomer.setCustomer_status(Constant.CUSTOMER_STATUS_1);
			tempCustomer.setId(customer.getId());
			customerService.editCustomer(tempCustomer);
		}
		else{
			msg = "该用户不存在，请核实";
		}
		ResponseObj ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	
	/**
	 * 用户退出
	 */
	@RequestMapping(value = "/loginOut")
	@ResponseBody  
	public Object loginOut(HttpServletRequest request,Model model,Customer customer){
		ResponseEnvelope<Object> re = null;
		//修改登录时间
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		if(null != loginCustomer){
			session.removeAttribute(Constant.SESSION_ID);
			//session.invalidate();
		}
		
		/*if(Constant.CUSTOMER_TYPE_10.equals(loginCustomer.getCustomer_type())){
			//如果是专家/值班医生时，则更新其在线状态。 退出时，其状态为下线状态
			loginCustomer.setIs_on_line(Constant.ONLINE_NO);
			customerService.editCustomer(loginCustomer);
		}*/
		
		//不管什么用户，退出时，都要更改在线状态
		Customer tempCustomer = new Customer();
		tempCustomer.setId(loginCustomer.getId());
		tempCustomer.setIs_on_line(Constant.ONLINE_NO);
		customerService.editCustomer(tempCustomer);
		
		re = new ResponseEnvelope<Object>(true,Constant.LOGOUT_MSG_SUCCES );
		String publishPath = request.getScheme() + "://" + request.getServerName()
				 +":" + request.getServerPort()+ request.getContextPath() + "/";
		re.setUrl(publishPath+"pages/login/login.jsp");
		return re;
	}
	
	
	/**
	 * 主页面跳转
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mainForward")
	public String mainForward(HttpServletRequest request,Model model,String mdType){
		
		//1、用户信息
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		
		if(null != loginCustomer && Constant.CUSTOMER_TYPE_10.equals(loginCustomer.getCustomer_type())){
			//如果是医生、值班医生类型情况下，得把该医生，诊断的人数得找出来
			int waitingCount = diagnoseService.queryCountWaitingExpert(loginCustomer.getId());
			loginCustomer.setWaitingExpert(waitingCount);
		}
		
		model.addAttribute("loginCustomer", loginCustomer);
		
		//2、智能中医(1)、妹妹(2)、小儿(3)、爸妈(4)。这里根据传进的参数来设置，到底是获取智能中医、妹妹、小儿、爸妈等信息
		if(StringUtils.isBlank(mdType)){
			mdType = "1";
		}
		
		String headTitle  = "智&nbsp;&nbsp;能&nbsp;&nbsp;中&nbsp;&nbsp;医";
		String displayMainName = "智能中医";
		
		switch (Integer.valueOf(mdType)) {
			case 1:
				this.queryZhiNengZhenDuan(request,model,loginCustomer);
				break;
			case 2:
				this.queryMeimei(request, model, loginCustomer);
				headTitle = "女&nbsp;&nbsp;士&nbsp;&nbsp;专&nbsp;&nbsp;科";
				displayMainName = "女士专科";
				break;
			case 3:
				this.queryXiaoer(request, model, loginCustomer);
				headTitle = "小&nbsp;&nbsp;儿&nbsp;&nbsp;专&nbsp;&nbsp;科";
				displayMainName = "小儿专科";
				break;
			case 4:
				this.queryBama(request, model, loginCustomer);
				headTitle = "亚&nbsp;&nbsp;健&nbsp;&nbsp;康&nbsp;&nbsp;专&nbsp;&nbsp;科";
				displayMainName = "亚健康专科";
				break;
		default:
			break;
		}
		
		model.addAttribute("headTitle",headTitle);
		model.addAttribute("displayMainName",displayMainName);
		model.addAttribute("mdType",mdType);
		return "login/main";
	}
	
	
	/**
	 * 主页面跳转
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcomeForward")
	public String welcomeForward(HttpServletRequest request,Model model){
		return "welcome/welcome";
	}
	

	/**
	 * 获取用户信息
	 */
	@RequestMapping(value = "/queryCustomerInfo")
	public String queryCustomerInfo(HttpServletRequest request,Model model,String id){
		//这里获取session用户信息。
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		
		model.addAttribute("loginCustomer", loginCustomer);
		return "customer/customerinfo";
	}
		
	
	/**
	 * 用户信息修改
	 */
	@RequestMapping(value = "/editCustomer")
	@ResponseBody  
	public Object editCustomer(HttpServletRequest request,Model model,Customer customer){
		ResponseObj ro = null;
		try {
			customerService.editCustomer(customer);
			HttpSession session =  request.getSession();
			session.setAttribute(Constant.SESSION_ID, customer);
			ro = new ResponseObj(Constant.STATUSCODE_SUCCESS, "用户信息维护成功", null, null, null, null);
		} catch (Exception e) {
			return new ResponseObj(Constant.STATUSCODE_ERROR, "用户信息维护失败", null, null, null, null);
		}
		return ro;
	}	
	
	/**
	 * 用户注册
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/registCustomer")
	public String registCustomer(HttpServletRequest request,Model model,Customer customer){
		//注册用户默认就是普通用户
		customer.setBirth(DateUtil.dateFormatToStr2(customer.getBirth()));
		customer.setCard_type(Constant.CART_TYPE_1);
		customer.setCustomer_type(Constant.CUSTOMER_TYPE_1);
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		customer.setCreate_time(DateUtil.currentTimestamp2String(currenyDate));
		customerService.addCustomer(customer);
		//用户注册完，直接跳转登录页面
		model.addAttribute("msgState", "2"); //代表是客户注册成功跳转至登录页面
		return "login/login";
	}	
	
	/**
	 * 验证登录名,系统中是否存在
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/doCheckLoginName")
	@ResponseBody  
	public Object doCheckLoginName(HttpServletRequest request,Model model,Customer customer){
		ResponseEnvelope<Object> re = null;
		Customer custoemr = customerService.queryCustomerByLoginName(customer);
		if(null == custoemr){
			re = new ResponseEnvelope<Object>(true,"系统中不存在此登录名，可以注册" );
		}
		else{
			re = new ResponseEnvelope<Object>(false,"系统中存在此登录名，不可以注册" );
		}
		return re;
	}
	
	
	/**
	 * 获取申请管理员客户信息   
	 * 针对 普通用户、VIP用户信息
	 */
	@RequestMapping(value = "/queryApplyCustomerInfo")
	public String queryApplyCustomerInfo(HttpServletRequest request,Model model,BaseConditionVO vo,Customer customer){
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("start", vo.getStartIndex());
		mapParmas.put("limit", vo.getPageSize());
		
		//customer.setCustomer_type(Constant.CUSTOMER_TYPE_1);
		//customer.setCustomer_status(Constant.CUSTOMER_STATUS_2);
		mapParmas.put("domain", customer);
		
		List<Customer> applyCustomerList = customerService.queryCustomerData(mapParmas);
		Integer totalCount = customerService.queryCustomerCount(mapParmas);
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("applyCustomerList", applyCustomerList);
		model.addAttribute("customer", customer);
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		model.addAttribute("loginCustomer", loginCustomer);
		
		return "customer/applyCustomerList";
	}
	
	/**
	 * 获取申请管理员客户信息   
	 * 针对 普通管理员、医生专家信息 
	 */
	@RequestMapping(value = "/queryManagerExpertInfo")
	public String queryManagerExpertInfo(HttpServletRequest request,Model model,BaseConditionVO vo,Customer customer){
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("start", vo.getStartIndex());
		mapParmas.put("limit", vo.getPageSize());
		
		mapParmas.put("domain", customer);
		
		List<Customer> managerExpertList = customerService.queryManagerExpertData(mapParmas);
		Integer totalCount = customerService.queryManagerExpertCount(mapParmas);
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("managerExpertList", managerExpertList);
		model.addAttribute("customer", customer);
		
		return "customer/managerExpertList";
	}
	
	
	/**
	 * 获取智能诊断信息(所有的)
	 * @param request
	 * @param model
	 * @param loginCustomer
	 */
	private void queryZhiNengZhenDuan(HttpServletRequest request,Model model,Customer loginCustomer){
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
				String sex = "";
				String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
				//HttpSession session =  request.getSession();
				//Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
//				if(null == loginCustomer){
//					//匿名登录 如果seesion用户为空，那就是默认匿名用户信息，匿名用户信息一开始默认为男性，
//					sex = request.getParameter("sex");
//					if(StringUtils.isBlank(sex)){
//						sex = String.valueOf(Constant.SEX_1);
//					}
//				}
//				else{
//					isLogin = "1";
//					sex = loginCustomer.getSex().toString();
//				}
				
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
				
	}
	
	
	/**
	 * 获取智能诊断信息(小儿)
	 * @param request
	 * @param model
	 * @param loginCustomer
	 */
	private void queryXiaoer(HttpServletRequest request,Model model,Customer loginCustomer){
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		//HttpSession session =  request.getSession();
		//Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
//						if(null == loginCustomer){
//							//匿名登录 如果seesion用户为空，那就是默认匿名用户信息，匿名用户信息一开始默认为男性，
//							sex = request.getParameter("sex");
//							if(StringUtils.isBlank(sex)){
//								sex = String.valueOf(Constant.SEX_1);
//							}
//						}
//						else{
//							isLogin = "1";
//							sex = loginCustomer.getSex().toString();
//						}
		
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
	}
	
	
	/**
	 * 获取智能诊断信息(妹妹)
	 * @param request
	 * @param model
	 * @param loginCustomer
	 */
	private void queryMeimei(HttpServletRequest request,Model model,Customer loginCustomer){
		//美妹标签数据，全是女性标签数据
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		//HttpSession session =  request.getSession();
		//Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		/*if(null == loginCustomer){
			//匿名登录 如果seesion用户为空，那就是默认匿名用户信息，匿名用户信息一开始默认为男性，
			sex = request.getParameter("sex");
			if(StringUtils.isBlank(sex)){
				sex = String.valueOf(Constant.SEX_1);
			}
		}
		else{
			isLogin = "1";
			sex = loginCustomer.getSex().toString();
		}*/
		
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
	}
	
	
	/**
	 * 获取智能诊断信息(爸妈)
	 * @param request
	 * @param model
	 * @param loginCustomer
	 */
	private void queryBama(HttpServletRequest request,Model model,Customer loginCustomer){
		//这里获取session用户信息,如果有用户登录，则根据登录的用户信息，来判断用户性别，来显示不同的数据。
		String sex = "";
		String isLogin = "0";  //0:客户未登录,匿名登录  1:客户登录
		//HttpSession session =  request.getSession();
		//Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
//						if(null == loginCustomer){
//							//匿名登录 如果seesion用户为空，那就是默认匿名用户信息，匿名用户信息一开始默认为男性，
//							sex = request.getParameter("sex");
//							if(StringUtils.isBlank(sex)){
//								sex = String.valueOf(Constant.SEX_1);
//							}
//						}
//						else{
//							isLogin = "1";
//							sex = loginCustomer.getSex().toString();
//						}
		
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
	}
	
	
	/**
	 * 检查该用户有没有登录
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/doCheckIsLogin")
	@ResponseBody  
	public Object doCheckIsLogin(HttpServletRequest request,Model model,Customer customer){
		ResponseEnvelope<Object> re = new ResponseEnvelope<Object>(false, "");
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		if(null == loginCustomer){
			re.setSuccess(true);
			re.setMessage("请先登录");
		}
		return re;
	}
	

	/**
	 * 查看客户有多少诊断结果未查看
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/queryCountWaitingLook")
	@ResponseBody  
	public Object queryCountWaitingLook(HttpServletRequest request,Model model){
		HttpSession session =  request.getSession();
		ResponseEnvelope<Object> re = new ResponseEnvelope<Object>(false, "不做处理");;
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		if(null != loginCustomer){
			//windowCloseThread.updateCustomerSessionMap(loginCustomer);
			if(!Constant.CUSTOMER_TYPE_10.equals(loginCustomer.getCustomer_type()) ){
				int waitingCount = diagnoseService.queryCountWaitingLook(loginCustomer.getId());
				if(waitingCount > 0){
					re.setSuccess(true);
					re.setMessage(loginCustomer.getName()+",您有"+waitingCount+"份诊断结果需查看，请进入<<历史诊断查询>>查看");
				}
			}
		}
		
		return re;
	}
	
	
	
	
	/*****************************普工升级，无需动态密码验证**********************/
	
	/**
	 * 普通客户申请管理员  --普通用户操作功能
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/applyManagerCommon")
	@ResponseBody  
	public Object applyManagerCommon(HttpServletRequest request,Model model){
		ResponseEnvelope<Object> re = null;
		String msg = "申请vip用户成功，请等待审批";
		
		//因为用户是在登录后才看到这页面，所有session中一定有用户
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		
		//客户审批状态验证
		if(!Constant.APPLY_STATUS_1.equals(loginCustomer.getApply_status()) || 
		   !Constant.CUSTOMER_TYPE_1.equals(loginCustomer.getCustomer_type())){
			re = new ResponseEnvelope<Object>(false,Constant.APPLY_MANAGER_MSG_EXISTS );
			return re;
		}
		
		//状态直接更改为2：待审批
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		loginCustomer.setApply_status(Constant.APPLY_STATUS_2);
		loginCustomer.setApply_time(currenyDate);
		
		Customer tempCustomer = new Customer();
		tempCustomer.setApply_status(Constant.APPLY_STATUS_2);
		tempCustomer.setApply_time(currenyDate);
		tempCustomer.setId(loginCustomer.getId());
		customerService.editCustomer(tempCustomer);
		
		CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
		customerApplyinfo.setCustomer_id(loginCustomer.getId());
		customerApplyinfo.setCustomer_name(loginCustomer.getName());
		customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_1);
		customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_1);
		customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_2);
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		customerApplyinfo.setDeal_date(currenyDate_date);
		customerApplyinfo.setDeal_time(currenyDate_time);
		customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		
		session.setAttribute(Constant.SESSION_ID, loginCustomer);
		re = new ResponseEnvelope<Object>(true,msg);
		return re;
	}
	
	/**
	 * 普通客户申请管理员（普通管理员升级）  --管理员操作功能
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/appliedManagerCommon")
	@ResponseBody  
	public Object appliedManagerCommon(HttpServletRequest request,Model model,Long customerId){
		ResponseObj ro = null;//new ResponseObj("200", msg, null, null, null, null);
		String msg = "审批/升级成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		
		//客户审批状态验证
		if(null == customer || Constant.APPLY_STATUS_3.equals(customer.getApply_status()) ||
		   !Constant.CUSTOMER_TYPE_1.equals(customer.getCustomer_type())){
			ro = new ResponseObj("200", Constant.APPLIED_MANAGER_MSG, null, null, null, null);
			return ro;
		}
	
		//关联成功
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		
		Customer tempCustomer = new Customer();
		tempCustomer.setApply_status(Constant.APPLY_STATUS_3);
		tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_2);
		tempCustomer.setKnow_status(Constant.KNOW_STATUS_2);
		tempCustomer.setApplied_time(currenyDate);
		tempCustomer.setId(customer.getId());
		customerService.editCustomer(tempCustomer);
		
		
		CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
		customerApplyinfo.setCustomer_id(customer.getId());
		customerApplyinfo.setCustomer_name(customer.getName());
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		customerApplyinfo.setManager_customer_id(loginCustomer.getId());
		customerApplyinfo.setManager_customer_name(loginCustomer.getName());
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		customerApplyinfo.setDeal_date(currenyDate_date);
		customerApplyinfo.setDeal_time(currenyDate_time);
		
		if(Constant.APPLY_STATUS_1.equals(customer.getApply_status())){
			customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_4);
			customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_1);
		}
		else {
			customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_2);
			customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_2);
		}
		customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_3);
		customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		
		ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	/**
	 * 降级处理
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/lowerAppliedApplyManagerCommon")
	@ResponseBody  
	public Object lowerAppliedApplyManagerCommon(HttpServletRequest request,Model model,Long customerId){
		ResponseObj ro = null;//new ResponseObj("200", msg, null, null, null, null);
		String msg = "降级成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		
		//客户审批状态验证
		if(null == customer || !Constant.CUSTOMER_TYPE_2.equals(customer.getCustomer_type())){
			ro = new ResponseObj("200", Constant.APPLIED_LOWER_MANAGER_MSG, null, null, null, null);
			return ro;
		}
	
		//关联成功
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		
		Customer tempCustomer = new Customer();
		tempCustomer.setApply_status(Constant.APPLY_STATUS_1);
		tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_1);
		tempCustomer.setKnow_status(Constant.KNOW_STATUS_2);
		tempCustomer.setApplied_time(currenyDate);
		tempCustomer.setId(customer.getId());
		customerService.editCustomer(tempCustomer);
		
		
		CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
		customerApplyinfo.setCustomer_id(customer.getId());
		customerApplyinfo.setCustomer_name(customer.getName());
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		customerApplyinfo.setManager_customer_id(loginCustomer.getId());
		customerApplyinfo.setManager_customer_name(loginCustomer.getName());
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		customerApplyinfo.setDeal_date(currenyDate_date);
		customerApplyinfo.setDeal_time(currenyDate_time);
		customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_5);
		customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_3);
		customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_1);
		customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		
		ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	/**
	 * 超级管理员进行拒绝审批(对这已开户的用户，不进行关联且删除该用户)
	 * 普通客户申请管理员
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/refuseApplyManagerCommon")
	@ResponseBody  
	public Object refuseApplyManagerCommon(HttpServletRequest request,Model model,Long customerId){
		String msg = "拒绝成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		//删除成功
		if(customer.getApply_status().equals(Constant.APPLY_STATUS_2) &&
		   customer.getCustomer_type().equals(Constant.CUSTOMER_TYPE_1)){
			Customer tempCustomer = new Customer();
			tempCustomer.setApply_status(Constant.APPLY_STATUS_1);
			tempCustomer.setKnow_status(Constant.KNOW_STATUS_2);
			tempCustomer.setId(customer.getId());
			customerService.editCustomer(tempCustomer);
			
			String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
			CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
			customerApplyinfo.setCustomer_id(customer.getId());
			customerApplyinfo.setCustomer_name(customer.getName());
			
			HttpSession session =  request.getSession();
			Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
			customerApplyinfo.setManager_customer_id(loginCustomer.getId());
			customerApplyinfo.setManager_customer_name(loginCustomer.getName());
			String currenyDate_date = currenyDate.substring(0, 8);
			String currenyDate_time = currenyDate.substring(8, currenyDate.length());
			customerApplyinfo.setDeal_date(currenyDate_date);
			customerApplyinfo.setDeal_time(currenyDate_time);
			customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_3);
			customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_2);
			customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_1);
			customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		}
		else{
			msg = "该用户未申请升级，拒绝无效";
		}
	
		ResponseObj ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	/*******************超级管理员处理权限****************/
	/**
	 * 普通管理员、医生专家     直接  降级为普通用户
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/lowerManagerExpert")
	@ResponseBody  
	public Object lowerManagerExpert(HttpServletRequest request,Model model,Long customerId){
		ResponseObj ro = null;//new ResponseObj("200", msg, null, null, null, null);
		String msg = "降级成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		
		//客户审批状态验证
		if(null == customer || !(Constant.CUSTOMER_TYPE_3.equals(customer.getCustomer_type()) ||
				                 Constant.CUSTOMER_TYPE_10.equals(customer.getCustomer_type())) ){
			ro = new ResponseObj("200", Constant.MANAGEREXPERT_LOWER_MANAGER_MSG, null, null, null, null);
			return ro;
		}
	
		//关联成功
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		
		Customer tempCustomer = new Customer();
		tempCustomer.setApply_status(Constant.APPLY_STATUS_1);
		tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_1);
		tempCustomer.setKnow_status(Constant.KNOW_STATUS_2);
		tempCustomer.setApplied_time(currenyDate);
		tempCustomer.setId(customer.getId());
		customerService.editCustomer(tempCustomer);
		
		
		CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
		customerApplyinfo.setCustomer_id(customer.getId());
		customerApplyinfo.setCustomer_name(customer.getName());
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		customerApplyinfo.setManager_customer_id(loginCustomer.getId());
		customerApplyinfo.setManager_customer_name(loginCustomer.getName());
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		customerApplyinfo.setDeal_date(currenyDate_date);
		customerApplyinfo.setDeal_time(currenyDate_time);
		customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_6);
		//customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_3);
		customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_1);
		customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		
		ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	/**
	 * 删除用户  目前针对超级管理员  删除普通管理员/医生
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/deleteCustomer")
	@ResponseBody  
	public Object deleteCustomer(HttpServletRequest request,Model model,Long customerId){
		String msg = "删除成功";
		//Customer customer = customerService.queryCustomerById(customerId);
		customerService.delCustomerById(customerId);
		ResponseObj ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	/**
	 * 把普通用户升级到管理员
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/upManager")
	@ResponseBody  
	public Object upManager(HttpServletRequest request,Model model,Long customerId){
		ResponseObj ro = null;//new ResponseObj("200", msg, null, null, null, null);
		String msg = "升级管理员成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		
		//客户审批状态验证
		if(null == customer ||
		   !Constant.CUSTOMER_TYPE_1.equals(customer.getCustomer_type())){
			ro = new ResponseObj("200", Constant.MANAGEREXPERT_UP_MANAGER_MSG, null, null, null, null);
			return ro;
		}
	
		//关联成功
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		
		Customer tempCustomer = new Customer();
		//tempCustomer.setApply_status(Constant.APPLY_STATUS_3);
		tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_3);
		tempCustomer.setKnow_status(Constant.KNOW_STATUS_2);
		tempCustomer.setApplied_time(currenyDate);
		tempCustomer.setId(customer.getId());
		customerService.editCustomer(tempCustomer);
		
		
		CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
		customerApplyinfo.setCustomer_id(customer.getId());
		customerApplyinfo.setCustomer_name(customer.getName());
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		customerApplyinfo.setManager_customer_id(loginCustomer.getId());
		customerApplyinfo.setManager_customer_name(loginCustomer.getName());
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		customerApplyinfo.setDeal_date(currenyDate_date);
		customerApplyinfo.setDeal_time(currenyDate_time);
		
		customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_7);
		//customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_1);
		//customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_3);
		customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		
		ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
	/**
	 * 普通用户 升级为医生
	 * @param request
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/upExpert")
	@ResponseBody  
	public Object upExpert(HttpServletRequest request,Model model,Long customerId){
		ResponseObj ro = null;//new ResponseObj("200", msg, null, null, null, null);
		String msg = "升级医生成功";
		
		Customer customer = customerService.queryCustomerById(customerId);
		
		//客户审批状态验证
		if(null == customer ||
		   !Constant.CUSTOMER_TYPE_1.equals(customer.getCustomer_type())){
			ro = new ResponseObj("200", Constant.MANAGEREXPERT_UP_MANAGER_MSG, null, null, null, null);
			return ro;
		}
	
		//关联成功
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		
		Customer tempCustomer = new Customer();
		//tempCustomer.setApply_status(Constant.APPLY_STATUS_3);
		tempCustomer.setCustomer_type(Constant.CUSTOMER_TYPE_10);
		tempCustomer.setKnow_status(Constant.KNOW_STATUS_2);
		tempCustomer.setApplied_time(currenyDate);
		tempCustomer.setId(customer.getId());
		customerService.editCustomer(tempCustomer);
		
		
		CustomerApplyinfo customerApplyinfo = new CustomerApplyinfo();
		customerApplyinfo.setCustomer_id(customer.getId());
		customerApplyinfo.setCustomer_name(customer.getName());
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		customerApplyinfo.setManager_customer_id(loginCustomer.getId());
		customerApplyinfo.setManager_customer_name(loginCustomer.getName());
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		customerApplyinfo.setDeal_date(currenyDate_date);
		customerApplyinfo.setDeal_time(currenyDate_time);
		
		customerApplyinfo.setDeal_action(Constant.DEAL_ACTION_8);
		//customerApplyinfo.setDeal_status_before(Constant.APPLY_STATUS_1);
		//customerApplyinfo.setDeal_status_after(Constant.APPLY_STATUS_3);
		customerApplyinfoService.addCustomerApplyinfo(customerApplyinfo);
		
		ro = new ResponseObj("200", msg, null, null, null, null);
		return ro;
	}
	
	
}
