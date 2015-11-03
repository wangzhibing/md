package com.md.util;

import java.util.Map;

import org.springframework.web.context.request.NativeWebRequest;

public class WebUtils {
	/**
	 * Gets the Map of HttpSession values when in a servlet environment or a generic session map otherwise.
	 * 
	 * @returnthe Map of HttpSession values when in a servlet environment or a generic session map otherwise.
	 */
//	public static Map<String, Object> getSessionMap() {
//		//NativeWebRequest
//		//return actiongetContext().getSession();
//	}

//	public static HttpServletRequest getRequest() {
//		
//		return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//	}
//
//	public static HttpServletResponse getResponse() {
//		return (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
//	}
//
//	@Deprecated
//	public static HttpSession getSession() {
//		return (HttpSession) ActionContext.getContext().get(ServletActionContext.SESSION);
//	}
}
