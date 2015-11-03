package com.md.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.Customer;
import com.md.entity.CustomerCount;

/**
 * 获取客户信息
 * @author wzb
 */
@Repository
public interface CustomerMapper {
	
	/**
	 * 往客户信息表插入数据
	 * @param customer
	 * @return
	 */
	public int insertCustomer(Customer customer);
	
	/**
	 * 修改客户信息
	 * @param customer
	 * @return
	 */
	public int updateCustomer(Customer customer);
	
	/**
	 * 删除客户信息
	 * @param customerId
	 * @return
	 */
	public void deleteCustomerById(Long customerId);
	
	/**
	 * 获取单个客户信息  用户数据管理(针对普通用户、VIP用户)
	 * @param customerId
	 * @return
	 */
	public Customer selectCustomerById(Long customerId);
	
	/**
	 * 获取客户信息 这里客户信息 用户数据管理(针对普通用户、VIP用户)
	 * @return
	 */
	public List<Customer> selectCustomerData(Map<String, Object> mapParams);
	
	/**
	 * 客户信息分页用的   对应selectCustomerData
	 * @param mapParams
	 * @return
	 */
	public Integer selectCustomerCount(Map<String, Object> mapParams);
	
	/**
	 * 获取客户信息 这里客户信息 用户数据管理(针对普通管理员、医生专家)
	 * @return
	 */
	public List<Customer> selectManagerExpertData(Map<String, Object> mapParams);
	
	/**
	 * 客户信息分页用的   对应selectManagerExpertData
	 * @param mapParams
	 * @return
	 */
	public Integer selectManagerExpertCount(Map<String, Object> mapParams);
	
	
	/**
	 * 获取专家，仅仅是病客的
	 * @return
	 */
	public List<Customer> selectExpertData(Map<String, Object> mapParams);
	
	/**
	 * 专家
	 * @param mapParams
	 * @return
	 */
	public Integer selectExpertCount(Map<String, Object> mapParams);
	
	
	/**
	 * 登录用户方法，验证用户信息存不存在
	 * @param customer
	 * @return
	 */
	public Customer selectCustomerByLoginNamePwd(Customer customer);
	
	/**
	 * 注册页面、修改页面输入用户名，验证系统是否存在此用户
	 * @param customer
	 * @return
	 */
	public Customer selectCustomerByLoginName(Customer customer);
	
	
	/*************获取汇总信息*****************/
	/**
	 * 获取注册人数：普通用户、VIP,医生
	 */
	public CustomerCount selectRegisterCount();
	
	
	/**
	 * 获取在线人数：普通用户、VIP,医生
	 */
	public CustomerCount selectOnLineCount();
	
	
	/**
	 * 获取客户信息   统计注册/在线数量
	 * @return
	 */
	public List<Customer> selectRegisterOnlineCustomerData(Map<String, Object> mapParams);
	
	/**
	 * 客户信息分页用的 统计/在线注册数量
	 * @param mapParams
	 * @return
	 */
	public Integer selectRegisterOnlineCustomerCount(Map<String, Object> mapParams);
	
	
}
