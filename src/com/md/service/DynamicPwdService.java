package com.md.service;

/**
 * 动态密码
 * @author wzb
 */
public interface DynamicPwdService {
	
	/**
	 * 后台指令连接(后台：令牌系统) 令牌接口处理
	 */
	public String authenticate(String actionValue);

}
