package com.md.service.impl;

import javax.annotation.PostConstruct;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.md.common.Constant;
import com.md.service.DynamicPwdService;

@Service
public class DynamicPwdServiceImpl implements DynamicPwdService{
	
//	private final static JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
//	private final static Client client = factory.createClient("http://101.71.21.19:8080/dtlp/ws/service?wsdl");
//	private static Object[] res = null;
	static Logger logger = Logger.getLogger(DynamicPwdServiceImpl.class);
	
	private static JaxWsDynamicClientFactory factory = null;
	private static Client client = null;
	private static Object[] res = null;
	
	@Value("#{configProperties['isDynamic']}")  //本地控制
    private boolean isDynamic; //动态密码_企业编号、读取配置文件中isDynamic
	
//	static{
//		try {
//			if(isDynamic){
//				logger.info("系统初始化，连接后台wsdl开始。。。");
//				
//				factory = JaxWsDynamicClientFactory.newInstance();
//				client = factory.createClient(Constant.DYNAMIC_WSDL);
//				client.getOutInterceptors().add(new HeaderIntercepter());
//				logger.info("系统初始化，连接后台wsdl成功。。。");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.info("系统初始化，连接后台wsdl异常"+e.getMessage());
//			logger.info("系统初始化，连接后台wsdl异常{}",e);
//		}
//	}
	
	@PostConstruct
	public void init(){
		try {
			if(isDynamic){
				logger.info("系统初始化，连接后台wsdl开始。。。");
				
				factory = JaxWsDynamicClientFactory.newInstance();
				client = factory.createClient(Constant.DYNAMIC_WSDL);
				client.getOutInterceptors().add(new HeaderIntercepter());
				logger.info("系统初始化，连接后台wsdl成功。。。");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("系统初始化，连接后台wsdl异常"+e.getMessage());
			logger.info("系统初始化，连接后台wsdl异常{}",e);
		}
	}
	
	/**
	 * 后台指令连接(后台：令牌系统) 令牌接口处理
	 */
	public String authenticate(String actionValue){
		String value = "";
		try {
			res = client.invoke("process", actionValue);
			System.out.println((String)res[0]);
			return (String)res[0];
		} catch (Exception e) {
			logger.info("与后台指令连接失败",e);
			e.printStackTrace();
			return value;
		}
	}
}
