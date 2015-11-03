package com.md.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.md.entity.SymptomPrescriptionValue;

/**
 * 症状处方表（基础数据表）
 * @author owen
 */
@Repository
public interface SymptomPrescriptionValueMapper {
	
	/**
	 * 症状处方表（基础数据表）
	 * @return
	 */
	public List<SymptomPrescriptionValue> selectSymptomPrescriptionValueInfo(String type);
	

}
