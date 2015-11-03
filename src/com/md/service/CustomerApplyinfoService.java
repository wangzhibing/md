package com.md.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.CustomerApplyinfo;

/**
 * 客户升级留痕信息
 * @author wzb
 */
@Repository
public interface CustomerApplyinfoService {

	public void addCustomerApplyinfo(CustomerApplyinfo customerApplyinfo);
	
	public List<CustomerApplyinfo> queryCustomerApplyinfoData(Map<String, Object> mapParams);
	
	public Integer queryCustomerApplyinfoCount(Map<String, Object> mapParams);
	
}
