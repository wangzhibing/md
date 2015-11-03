package com.md.thread;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.common.Constant;
import com.md.entity.Customer;
import com.md.service.CustomerService;

/**
 * 页面窗口关闭等，触发
 * @author owen
 *
 */
@Service
public class WindowCloseThread implements Runnable{
	
	Logger logger = Logger.getLogger(WindowCloseThread.class);
	
	/**
	 * 用户ID_first
	 * 用户ID_second
	 */
	private Map<String, Date> customerSessionMap;
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private CustomerService customerService;
	
	//@PostConstruct
	public void init(){
		customerSessionMap = new Hashtable<String, Date>();
		HttpSession session = request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		if(null != loginCustomer){
			customerSessionMap.put(String.valueOf(loginCustomer.getId())+"_first", new Date());
		}
		
		new Thread(this).start();
	}

	/**
	 * 后台时时提示消息时触发
	 * 此时客户已经登录过，则secondKey是有值的
	 * 更新用户最优访问时间
	 * @param customer
	 */
	public void updateCustomerSessionMap(Customer customer){
		logger.info("后台ajax请求。。。");
		String firstKey = customer.getId()+"_first";
		String secondKey = customer.getId()+"_secondKey";
		Date secondObj = customerSessionMap.get(secondKey);
		
		//把上一次啊登录的时间(最后一次,second) 设值到，firstKey
		customerSessionMap.put(firstKey, secondObj);
		customerSessionMap.put(secondKey, new Date());
	}
	
	/**
	 * 用户登录时插入
	 */
	public void addCustomerSessionMap(Customer customer){
		logger.info("用户登录。。。");
		String firstKey = customer.getId()+"_first";
		String secondKey = customer.getId()+"_secondKey";
		
		//因是插入，则把原先有的会话清空掉
		customerSessionMap.remove(firstKey);
		customerSessionMap.remove(secondKey);
		
		//再插入现在的登录的时间
		customerSessionMap.put(secondKey, new Date());
	}
	
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(5000);//睡眠5妙
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
			
			HttpSession session = request.getSession();
			Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
			if(null != loginCustomer){
				String secondKey = loginCustomer.getId()+"_secondKey";
				Date lastRequestDate = customerSessionMap.get(secondKey);
				long diff = new Date().getTime() - lastRequestDate.getTime();
				if(diff > 6000){
					//大于1分半时间就确定，页面请求中断，可看做页面崩溃
					//更改其状态(下线)、清空该session
					Customer tempCustomer = new Customer();
					tempCustomer.setId(loginCustomer.getId());
					tempCustomer.setIs_on_line(Constant.ONLINE_NO);
					customerService.editCustomer(tempCustomer);
					session.removeAttribute(Constant.SESSION_ID);
				}
			}
		}
	}
}
