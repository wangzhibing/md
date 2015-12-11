package com.md.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.md.entity.DrugStore;

/**
 * 中成药库：目前只是查询
 * @author owen
 */
@Repository
public interface DrugStoreMapper {
	
	/**
	 *  获取所有中成药库信息
	 * @return
	 */
	public List<DrugStore> selectAllDrugStoreList();
	
}
