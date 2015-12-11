package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.DrugStore;
import com.md.mapper.DrugStoreMapper;
import com.md.service.DrugStoreService;

/**
 * 中成药库服务层
 * @author owen
 */
@Service
public class DrugStoreServiceImpl implements DrugStoreService {

	Logger logger = Logger.getLogger(DrugStoreServiceImpl.class);
	
	private Map<String, DrugStore> drugStoreMap;
	
	@Resource
	private DrugStoreMapper drugStoreMapper;
	
	@Override
	@PostConstruct
	public void init(){
		this.packageDrugStoreMap();
	}

	
	@PreDestroy
	public void destory(){
	    System.out.println("正在执行销毁之前的destory方法");
	}

	
	/**
	 * 同queryAllDrugStoreList一样，一个返回list，一个返回map
	 * @return
	 */
	public Map<String, DrugStore> queryAllDrugStoreMap(){
		if(drugStoreMap == null || drugStoreMap.size() == 0){
			this.packageDrugStoreMap();
		}
		return drugStoreMap;
	}
	

	/**
	 * 获取所有中成药库信息
	 */
	@Override
	public List<DrugStore> queryAllDrugStoreList() {
		return drugStoreMapper.selectAllDrugStoreList();
	}
	
	/**
	 * 通过drug_store_code获取中成药库对象
	 * @param drug_store_code
	 * @return
	 */
	public DrugStore querySingleDrugStore(String drug_store_code){
		DrugStore drugStore = null;
		if(drugStoreMap != null ){
			drugStore = drugStoreMap.get(drug_store_code);
		}
		return drugStore;
	}
	
	/**
	 * 封装DrugStoreMap
	 */
	private void packageDrugStoreMap(){
		List<DrugStore> listDrugStore = this.queryAllDrugStoreList();
		if(listDrugStore != null && listDrugStore.size() > 0){
			drugStoreMap = new HashMap<String, DrugStore>();
			for(DrugStore drugStore : listDrugStore){
				drugStoreMap.put(drugStore.getDrug_code(), drugStore);
			}
		}
	}
	
}
