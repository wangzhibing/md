package com.md.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.md.common.Constant;
import com.md.entity.Customer;
import com.md.service.CustomerService;

public class SessionListener implements HttpSessionListener {

	//@Resource
	//private CustomerService customerService;
	
	//public ApplicationContext context = null;
	
	/**
	 * session创建时触发
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		Customer loginCustoemr =  (Customer) session.getAttribute("Constant.SESSION_ID");
		System.out.println("*********************sessionCreated**********************");
		//content.getBean(arg0)
		
		//记录当前问人数
		ServletContext ctx = event.getSession().getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(1);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count + 1);
		}
		ctx.setAttribute("numSessions", numSessions);
		System.out.println("xxxxxxx");
	}

	/**
	 * session销毁时触发
	 * 针对用户非正常关闭
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		HttpSession session = event.getSession();
		Customer loginCustoemr =  (Customer) session.getAttribute(Constant.SESSION_ID);
		if(null != loginCustoemr){
			Customer tempCustomer = new Customer();
			tempCustomer.setId(loginCustoemr.getId());
			tempCustomer.setIs_on_line(Constant.ONLINE_NO);
			System.out.println("*********************sessionDestroyed**********************");
			
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
			/*context = new ClassPathXmlApplicationContext(
					"classpath*:/conf/spring/spring_common.xml");*/
			CustomerService customerService = (CustomerService) context.getBean("customerServiceImpl");
			customerService.editCustomer(tempCustomer);
			session.removeAttribute(Constant.SESSION_ID);
		}
		
		ServletContext ctx = event.getSession().getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(0);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count - 1);
		}
		ctx.setAttribute("numSessions", numSessions);
		
		
		/*String publishPath = request.getScheme() + "://" + request.getServerName()
				 +":" + request.getServerPort()+ request.getContextPath() + "/";
		response.sendRedirect(publishPath+"pages/login/forword_session.jsp"); // 返回提示页面 
*/
		
		

	}

}
