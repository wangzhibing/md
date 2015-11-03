package com.md.service.impl;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


public class Main {

	private final static JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
	private final static Client client = factory.createClient("http://101.71.21.19:8080/dtlp/ws/service?wsdl");
	private static Object[] res = null;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			client.getOutInterceptors().add(new HeaderIntercepter());
			
			/** 
			 * 创建企业
			 * 由于企业还未被创建，因此不存在企业密钥
			 * 为安全性考虑，需使用管理员提供的临时企业编号及密钥
			 * 一般管理员需要在系统中先创建一个临时企业
			 * 在客户调用完毕并记录下密钥后，删除临时企业
			 */
			/*res = client.invoke("process", "{action:'createEnterprise',param:{eid:'0002',ename:'WS创建企业'}}");
			System.out.println((String)res[0]);*/
			
			/** 变更企业信息 **/
			/*res = client.invoke("process", "{action:'modifyEnterprise',param:{eid:'0002',ename:'WS创建企业',max:'',expire:''}}");
			System.out.println((String)res[0]);*/
			
			/** 查询企业信息 **/
			/*res = client.invoke("process", "{action:'enterpriseInfo',param:{eid:'0001'}}");
			System.out.println((String)res[0]);*/
			
			/** 创建用户 **/
			/*res = client.invoke("process", "{action:'createUser',param:{eid:'300019',uid:'wzbhjm',pwd:'1234'}}");
			System.out.println((String)res[0]);*/
			
			/** 变更用户密码 **/
//			res = client.invoke("process", "{action:'changePwd',param:{eid:'0001',uid:'wzbhjm',pwd:'xxxxx'}}");
//			System.out.println((String)res[0]);
			
			/** 关联令牌 **/
			/*res = client.invoke("process", "{action:'associate',param:{eid:'300019',uid:'wzbhjm'}}");
			System.out.println((String)res[0]);
			*/
			/** 获取令牌状态 **/
			/*res = client.invoke("process", "{action:'tokenStatus',param:{eid:'0001',uid:'wzbhjm'}}");
			System.out.println((String)res[0]);*/
			
			/** 锁/解令牌 **/
			/*res = client.invoke("process", "{action:'tokenLock',param:{eid:'0002',uid:'test',lock:'false'}}");
			System.out.println((String)res[0]);*/
			
			/** 注销令牌 **/
			/*res = client.invoke("process", "{action:'unregister',param:{eid:'0002',uid:'test'}}");
			System.out.println((String)res[0]);*/
			
			/** 重置令牌 **/
			/*res = client.invoke("process", "{action:'resetToken',param:{tid:'011603621c66a1e9a5408e94b02662f6'}}");
			System.out.println((String)res[0]);*/
			
			/** 取消关联 **/
			/*res = client.invoke("process", "{action:'removeAssociation',param:{eid:'0002',uid:'test'}}");
			System.out.println((String)res[0]);*/
			
			/** 删除用户 **/
//			res = client.invoke("process", "{action:'delUser',param:{eid:'0001',uid:'hjm'}}");
//			System.out.println((String)res[0]);
//			
			/** 删除企业 **/
			/*res = client.invoke("process", "{action:'delEnterprise',param:{eid:'0002'}}");
			System.out.println((String)res[0]);*/
			
			/** 认证日志 **/
			/*res = client.invoke("process", "{action:'authLog',param:{}}");
			System.out.println((String)res[0]);*/
			
			/** 认证 **/
			res = client.invoke("process", "{action:'authenticate',param:{eid:'300019',uid:'wzbhjm',otp:'38228077',otp2:''}}");
			System.out.println((String)res[0]);
			
			
			System.out.println("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
