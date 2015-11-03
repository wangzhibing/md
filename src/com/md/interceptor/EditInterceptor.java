package com.md.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.md.common.Constant;
import com.md.entity.Customer;
import com.md.service.CustomerService;

/**
 * 管理员修改拦截
 * 
 * 如果管理员修改了用户的信息， 则对在线的用户进行拦截，提示其重新登录
 * @author wzb
 */
public class EditInterceptor implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object arg0, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg0, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg0) throws Exception {
		
			String requestUri = request.getRequestURI();
			if(requestUri.indexOf("md/customer/queryCountWaitingLook") != -1 || 
			   requestUri.indexOf("md/expert/queryWaitingDiagnose") != -1){
                return true;
			}
			
			//需要拦截的
			HttpSession session =  request.getSession();
			Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
			if(null != loginCustomer){
				WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
				CustomerService customerService = (CustomerService) context.getBean("customerServiceImpl");
				Customer customer = customerService.queryCustomerById(loginCustomer.getId());
				if((customer.getCustomer_type().equals(Constant.CUSTOMER_TYPE_1) || 
					customer.getCustomer_type().equals(Constant.CUSTOMER_TYPE_2) ) &&
					customer.getKnow_status().equals(Constant.KNOW_STATUS_2)){
					customer.setKnow_status(Constant.KNOW_STATUS_1);
					customerService.editCustomer(customer);

					String publishPath = request.getScheme() + "://" + request.getServerName()
							 +":" + request.getServerPort()+ request.getContextPath() + "/";
					response.sendRedirect(publishPath+"pages/login/forword_session_edit.jsp"); // 返回提示页面 
					return false;
				}
			}
		
		return true;
	}
	
}
