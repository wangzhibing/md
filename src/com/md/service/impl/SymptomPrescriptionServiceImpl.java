package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.SymptomPrescriptionValue;
import com.md.mapper.SymptomPrescriptionValueMapper;
import com.md.service.SymptomPrescriptionService;

/**
 * 症状处方表（基础数据表）服务层
 * @author owen
 */
@Service
public class SymptomPrescriptionServiceImpl implements SymptomPrescriptionService {

	Logger logger = Logger.getLogger(SymptomPrescriptionServiceImpl.class);
	
	//存储症状处方数据
	private Map<Long, SymptomPrescriptionValue> SPVMap;
	
	@Resource
	private SymptomPrescriptionValueMapper symptomPrescriptionValueMapper;
	
	@Override
	@PostConstruct
	public void init(){
		List<SymptomPrescriptionValue> listSPV = this.queryAllSPV();
		if(listSPV != null && listSPV.size() > 0){
			SPVMap = new HashMap<Long, SymptomPrescriptionValue>();
			for(SymptomPrescriptionValue spv : listSPV){
				SPVMap.put(spv.getId(), spv);
			}
		}
	}
	
	@PreDestroy
	public void destory(){
	    System.out.println("正在执行销毁之前的destory方法");
	}

	@Override
	public List<SymptomPrescriptionValue> queryAllSPV() {
		return symptomPrescriptionValueMapper.selectSymptomPrescriptionValueInfo(null);
	}

	@Override
	public SymptomPrescriptionValue querySingleSPV(String spv_id) {
		SymptomPrescriptionValue spv = null;
		if(SPVMap != null && null != SPVMap.get(Long.parseLong(spv_id))){
			spv = (SymptomPrescriptionValue) SPVMap.get(Long.parseLong(spv_id));
		}
		return spv;
	}

	@Override
	public String querySingleSPVName(String spv_id) {
		String spvName = null;
		if(SPVMap != null && null != SPVMap.get(spv_id)){
			SymptomPrescriptionValue spv = (SymptomPrescriptionValue) SPVMap.get(spv_id);
			spvName = spv.getName();
		}
		return spvName;
	}
	
}
