package com.md.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.CustomerApplyinfo;

/**
 * 客户升级留痕信息
 * @author wzb
 */
@Repository
public interface CustomerApplyinfoMapper {

	public void insertCustomerApplyinfo(CustomerApplyinfo customerApplyinfo);
	
	public List<CustomerApplyinfo> selectCustomerApplyinfoData(Map<String, Object> mapParams);
	
	public Integer selectCustomerApplyinfoCount(Map<String, Object> mapParams);
	
}
