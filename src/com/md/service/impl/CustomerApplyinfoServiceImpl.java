package com.md.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.CustomerApplyinfo;
import com.md.mapper.CustomerApplyinfoMapper;
import com.md.service.CustomerApplyinfoService;

@Service
public class CustomerApplyinfoServiceImpl implements CustomerApplyinfoService {

	Logger logger = Logger.getLogger(CustomerApplyinfoServiceImpl.class);
	
	@Resource
	private CustomerApplyinfoMapper customerApplyinfoMapper;
	
	@Override
	public void addCustomerApplyinfo(CustomerApplyinfo customerApplyinfo) {
		customerApplyinfoMapper.insertCustomerApplyinfo(customerApplyinfo);
	}

	@Override
	public List<CustomerApplyinfo> queryCustomerApplyinfoData(
			Map<String, Object> mapParams) {
		return customerApplyinfoMapper.selectCustomerApplyinfoData(mapParams);
	}

	@Override
	public Integer queryCustomerApplyinfoCount(Map<String, Object> mapParams) {
		return customerApplyinfoMapper.selectCustomerApplyinfoCount(mapParams);
	}

}
