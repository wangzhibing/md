package com.md.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.Customer;
import com.md.entity.CustomerCount;
import com.md.mapper.CustomerMapper;
import com.md.service.CustomerService;

/**
 * 客户信息服务层处理
 * @author wzb
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	@Resource
	private CustomerMapper customerMapper;
	
	/**
	 * 新增客户信息处理，一些业务逻辑验证都可以写在此处
	 */
	@Override
	public void addCustomer(Customer customer) {
		customerMapper.insertCustomer(customer);
	}

	/**
	 * 修改客户信息
	 */
	@Override
	public void editCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}
	
	/**
	 * 删除客户信息
	 * @param customerId
	 * @return
	 */
	public void delCustomerById(Long customerId){
		customerMapper.deleteCustomerById(customerId);
	}
	
	/**
	 * 新增客户信息处理，一些业务逻辑验证都可以写在此处   业务色彩
	 */
	@Override
	public void addCustomerService(Customer customer) {
		logger.info("用户注册信息开始。。。");
		
		//1、先判断客户信息系统是否存在，主要验证 身份证证件、身份证号码,做为查询条件
		//TODO
		
		customerMapper.insertCustomer(customer);
	}

	/**
	 * 修改客户信息  -- 业务色彩
	 */
	@Override
	public void editCustomerService(Customer customer) {
		logger.info("用户维护信息开始。。。");
		//1、先判断客户信息系统是否存在，主要验证 身份证证件、身份证号码,做为查询条件
		//TODO
		customerMapper.updateCustomer(customer);
	}

	

	/**
	 * 获取客户信息列表
	 * 针对普通用户、VIP用户
	 */
	@Override
	public List<Customer> queryCustomerData(Map<String, Object> mapParams) {
		return customerMapper.selectCustomerData(mapParams);
	}

	/**
	 * 获取客户信息数，与queryCustomerData对应
	 * 针对普通用户、VIP用户
	 */
	@Override
	public Integer queryCustomerCount(Map<String, Object> mapParams) {
		return customerMapper.selectCustomerCount(mapParams);
	}
	
	
	/**
	 * 获取客户信息分页(针对普通管理员、医生专家)
	 * @param mapParams
	 * @return
	 */
	public List<Customer> queryManagerExpertData(Map<String, Object> mapParams){
		return customerMapper.selectManagerExpertData(mapParams);
	}
	
	/**
	 * 获取客户信息分页(针对普通管理员、医生专家)
	 * @param mapParams
	 * @return
	 */
	public Integer queryManagerExpertCount(Map<String, Object> mapParams){
		return customerMapper.selectManagerExpertCount(mapParams);
	}
	
	
	/**
	 * 专家信息
	 * @param mapParams
	 * @return
	 */
	public List<Customer> queryExpertData(Map<String, Object> mapParams){
		return customerMapper.selectExpertData(mapParams);
	}
	
	/**
	 * 专家信息
	 * @param mapParams
	 * @return
	 */
	public Integer queryExpertCount(Map<String, Object> mapParams){
		return customerMapper.selectExpertCount(mapParams);
	}

	/**
	 * 获取单个客户信息,回显作用
	 */
	@Override
	public Customer queryCustomerById(Long customerId) {
		return customerMapper.selectCustomerById(customerId);
	}
	
	/**
	 * 登录用户方法，验证用户信息存不存在
	 * @param customer
	 * @return
	 */
	public Customer queryCustomerByLoginNamePwd(Customer customer){
		return customerMapper.selectCustomerByLoginNamePwd(customer);
	}

	/**
	 * 登录用户方法，验证用户信息存不存在
	 * @param customer
	 * @return
	 */
	public Customer queryCustomerByLoginName(Customer customer){
		return customerMapper.selectCustomerByLoginName(customer);
	}
	
	/**
	 * 获取注册人数：普通用户、VIP,医生
	 */
	public CustomerCount queryRegisterCount(){
		return customerMapper.selectRegisterCount();
	}
	
	/**
	 * 获取在线人数：普通用户、VIP,医生
	 */
	public CustomerCount queryOnLineCount(){
		return customerMapper.selectOnLineCount();
	}
	
	/**
	 * 获取客户信息   统计注册/在线数量
	 * @return
	 */
	public List<Customer> queryRegisterOnlineCustomerData(Map<String, Object> mapParams){
		return customerMapper.selectRegisterOnlineCustomerData(mapParams);
	}
	
	/**
	 * 客户信息分页用的 统计/在线注册数量
	 * @param mapParams
	 * @return
	 */
	public Integer queryRegisterOnlineCustomerCount(Map<String, Object> mapParams){
		return customerMapper.selectRegisterOnlineCustomerCount(mapParams);
	}
	
}
