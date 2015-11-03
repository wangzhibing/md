package com.md.service;

import java.util.List;
import java.util.Map;

import com.md.entity.Customer;
import com.md.entity.CustomerCount;

/**
 * 用户信息注册
 * @author owen
 */
public interface CustomerService {
	
	/**
	 * 新增客户信息
	 * @param customer
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * 修改客户信息
	 * @param customer
	 */
	public void editCustomer(Customer customer);
	
	/**
	 * 删除客户信息
	 * @param customerId
	 * @return
	 */
	public void delCustomerById(Long customerId);
	
	/**
	 * 新增客户信息  -- 带业务色彩
	 * @param customer
	 */
	public void addCustomerService(Customer customer);
	
	/**
	 * 修改客户信息  -- 带业务色彩
	 * @param customer
	 */
	public void editCustomerService(Customer customer);
	
	
	/**
	 * 获取客户信息分页(针对普通用户、VIP用户)
	 * @param mapParams
	 * @return
	 */
	public List<Customer> queryCustomerData(Map<String, Object> mapParams);
	
	/**
	 * 获取客户信息分页(针对普通用户、VIP用户)
	 * @param mapParams
	 * @return
	 */
	public Integer queryCustomerCount(Map<String, Object> mapParams);
	
	
	/**
	 * 获取客户信息分页(针对普通管理员、医生专家)
	 * @param mapParams
	 * @return
	 */
	public List<Customer> queryManagerExpertData(Map<String, Object> mapParams);
	
	/**
	 * 获取客户信息分页(针对普通管理员、医生专家)
	 * @param mapParams
	 * @return
	 */
	public Integer queryManagerExpertCount(Map<String, Object> mapParams);
	
	
	/**
	 * 专家信息
	 * @param mapParams
	 * @return
	 */
	public List<Customer> queryExpertData(Map<String, Object> mapParams);
	
	/**
	 * 专家信息
	 * @param mapParams
	 * @return
	 */
	public Integer queryExpertCount(Map<String, Object> mapParams);
	
	/**
	 * 获取单个客户信息
	 * @param customerId
	 * @return
	 */
	public Customer queryCustomerById(Long customerId);
	
	/**
	 * 登录用户方法，验证用户信息存不存在
	 * @param customer
	 * @return
	 */
	public Customer queryCustomerByLoginNamePwd(Customer customer);
	
	/**
	 * 注册页面、修改页面输入用户名，验证系统是否存在此用户
	 * 修改：登录名、id必输
	 * 注册：登录名必输
	 * @param customer
	 * @return
	 */
	public Customer queryCustomerByLoginName(Customer customer);
	
	
	/**
	 * 获取注册人数：普通用户、VIP,医生
	 */
	public CustomerCount queryRegisterCount();
	
	/**
	 * 获取在线人数：普通用户、VIP,医生
	 */
	public CustomerCount queryOnLineCount();
	
	
	/**
	 * 获取客户信息   统计注册/在线数量
	 * @return
	 */
	public List<Customer> queryRegisterOnlineCustomerData(Map<String, Object> mapParams);
	
	/**
	 * 客户信息分页用的 统计/在线注册数量
	 * @param mapParams
	 * @return
	 */
	public Integer queryRegisterOnlineCustomerCount(Map<String, Object> mapParams);

}
