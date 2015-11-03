package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.BasePrescriptionValue;
import com.md.mapper.BasePrescriptionValueMapper;
import com.md.service.BasePrescriptionService;

/**
 * 基本处方表（基础数据表）服务层
 * @author owen
 */
@Service
public class BasePrescriptionServiceImpl implements BasePrescriptionService {

	Logger logger = Logger.getLogger(BasePrescriptionServiceImpl.class);
	
	//存储症状处方数据
	private Map<Object, Object> BPVMap;
	
	@Resource
	private BasePrescriptionValueMapper basePrescriptionValueMapper;
	
	@Override
	@PostConstruct
	public void init(){
		List<BasePrescriptionValue> listBPV = this.queryAllBPV();
		if(listBPV != null && listBPV.size() > 0){
			BPVMap = new HashMap<Object, Object>();
			for(BasePrescriptionValue bpv : listBPV){
				BPVMap.put(bpv.getCode(), bpv);
			}
		}
	}
	
	@PreDestroy
	public void destory(){
	    System.out.println("正在执行销毁之前的destory方法");
	}

	@Override
	public List<BasePrescriptionValue> queryAllBPV() {
		return basePrescriptionValueMapper.selectBasePrescriptionValueInfo();
	}

	@Override
	public BasePrescriptionValue querySingleBPV(String bpv_code) {
		BasePrescriptionValue bpv = null;
		if(BPVMap != null && null != BPVMap.get(bpv_code)){
			bpv = (BasePrescriptionValue) BPVMap.get(bpv_code);
		}
		return bpv;
	}
	
	@Override
	public String querySingleBPVName(String bpv_code) {
		String bpvName = null;
		if(BPVMap != null && null != BPVMap.get(bpv_code)){
			BasePrescriptionValue spv = (BasePrescriptionValue) BPVMap.get(bpv_code);
			bpvName = spv.getName();
		}
		return bpvName;
	}
	
}
