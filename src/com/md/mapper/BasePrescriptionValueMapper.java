package com.md.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.md.entity.BasePrescriptionValue;

/**
 * 基础处方表（基础数据表）
 * @author owen
 */
@Repository
public interface BasePrescriptionValueMapper {
	
	/**
	 * 基础处方表（基础数据表）
	 * @return
	 */
	public List<BasePrescriptionValue> selectBasePrescriptionValueInfo();
}
