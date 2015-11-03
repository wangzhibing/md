package com.md.service;

import java.util.List;

import com.md.entity.BasePrescriptionValue;



/**
 * 基础处方表（基础数据表）
 * @author owen
 */
public interface BasePrescriptionService {
	
	/**
	 * @param symptomItem
	 */
	public List<BasePrescriptionValue> queryAllBPV();
	
	/**
	 * @param spv_id
	 * @return
	 */
	public BasePrescriptionValue querySingleBPV(String bpv_code);
	
	/**
	 * @param spv_id
	 * @return
	 */
	public String querySingleBPVName(String bpv_code);
	
	/**
	 * 初始方法
	 */
	public void init();
}
