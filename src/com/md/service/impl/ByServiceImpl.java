package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.By;
import com.md.mapper.ByMapper;
import com.md.service.ByService;

/**
 * 症状条目数值表服务层
 * @author owen
 */
@Service
public class ByServiceImpl implements ByService {

	Logger logger = Logger.getLogger(ByServiceImpl.class);
	
	private Map<Object, Object> ByMap;
	
	@Resource
	private ByMapper byMapper;
	
	@Override
	@PostConstruct
	public void init(){
		List<By> listBy = this.queryAllBy();
		if(listBy != null && listBy.size() > 0){
			ByMap = new HashMap<Object, Object>();
			for(By By : listBy){
				ByMap.put(By.getCode(), By);
			}
		}
	}
	
	/**
	 * @param By_code
	 * @return
	 */
	public By querySingleBy(String by_code){
		By By = null;
		if(ByMap != null && null != ByMap.get(by_code)){
			By = (By) ByMap.get(by_code);
		}
		return By;
	}
	
	/**
	 * @param By_code
	 * @return
	 */
	public String querySingleByName(String by_code){
		String by_name = "";
		if(ByMap != null && null != ByMap.get(by_code)){
			By By = (By) ByMap.get(by_code);
			by_name = By.getName();
		}
		return by_name;
	}

	@Override
	public List<By> queryAllBy() {
		return byMapper.selectAllByList();
	}
	
	@PreDestroy
	public void destory(){
	    System.out.println("正在执行销毁之前的destory方法");
	}
	
}
