package com.md.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.md.common.Constant;
import com.md.entity.Customer;

/**
 * 登录拦截器
 * @author wzb
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	private String[] interceptorRequestUrl;

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
		boolean isInterceptor = false;
		String requestUri = request.getRequestURI();
		for(String reqPath : interceptorRequestUrl){
			if(requestUri.indexOf(reqPath) != -1){
				isInterceptor = true;
                break; 
			}
		}
		
		if(isInterceptor){
			//针对特殊请求路径
			//留言板页面查询
			if(requestUri.indexOf("md/messageBoard/messageBoardForward") != -1){
				String querytype = request.getParameter("queryType");
				if(StringUtils.isBlank(querytype)){
					return true;
				}
			}
			
			//留言板页面新增
			if(requestUri.indexOf("md/messageBoard/addMessageBoard") != -1){
				String customer_name = request.getParameter("customer_name");
				if(StringUtils.isBlank(customer_name) || Constant.ANONYMITY_CUSTOMER_CUSTOMER_NAME.equals(customer_name)){
					return true;
				}
			}
			
			//需要拦截的
			HttpSession session =  request.getSession();
			Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
			if(null == loginCustomer){
				String publishPath = request.getScheme() + "://" + request.getServerName()
						 +":" + request.getServerPort()+ request.getContextPath() + "/";
				response.sendRedirect(publishPath+"pages/login/forword_session.jsp"); // 返回提示页面 
				return false;
			}
		}
		
		return true;
	}
	
	public String[] getInterceptorRequestUrl() {
		return interceptorRequestUrl;
	}

	public void setInterceptorRequestUrl(String[] interceptorRequestUrl) {
		this.interceptorRequestUrl = interceptorRequestUrl;
	} 
}
