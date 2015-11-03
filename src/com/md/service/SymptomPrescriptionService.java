package com.md.service;

import java.util.List;

import com.md.entity.SymptomPrescriptionValue;



/**
 * 症状处方表（基础数据表）
 * @author owen
 */
public interface SymptomPrescriptionService {
	
	/**
	 * @param symptomItem
	 */
	public List<SymptomPrescriptionValue> queryAllSPV();
	
	/**
	 * @param spv_id
	 * @return
	 */
	public SymptomPrescriptionValue querySingleSPV(String spv_id);
	
	/**
	 * @param spv_id
	 * @return
	 */
	public String querySingleSPVName(String spv_id);
	
	/**
	 * 初始方法
	 */
	public void init();
}
