package com.md.service;

import java.util.List;
import java.util.Map;

import com.md.entity.DrugStore;



/**
 * 中医药库业务层
 * @author owen
 */
public interface DrugStoreService {
	
	/**
	 * @param symptomItem
	 */
	public List<DrugStore> queryAllDrugStoreList();
	
	/**
	 * 同queryAllDrugStoreList一样，一个返回list，一个返回map
	 * @return
	 */
	public Map<String, DrugStore> queryAllDrugStoreMap();
	
	/**
	 * 通过drug_store_code获取中成药库对象
	 * @param drug_store_code
	 * @return
	 */
	public DrugStore querySingleDrugStore(String drug_store_code);
	
	/**
	 * 初始方法
	 */
	public void init();
}
