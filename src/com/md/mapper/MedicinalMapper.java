package com.md.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.Medicinal;

/**
 * 药材信息表
 * @author wzb
 */
@Repository
public interface MedicinalMapper {
	
	/**
	 * 基础处方表（基础数据表）查询所有的药材信息，主要放入缓存当中，数据初始化
	 * @return
	 */
	public List<Medicinal> selectMedicinalInfo();
	
	/**
	 * 基础处方表（基础数据表）分页(获取数据)
	 * @return
	 */
	public List<Medicinal> selectMedicinalData(Map mapParams);
	
	/**
	 * 基础处方表（基础数据表）分页(获取条数)
	 * @return
	 */
	public Integer selectMedicinalCount(Map<String, Object> mapParams);
	
	/**
	 * 获取单个药材
	 * @return
	 */
	public Medicinal selectMedicinalById(Long medicinalId);
	
}
