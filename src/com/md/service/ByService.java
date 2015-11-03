package com.md.service;

import java.util.List;

import com.md.entity.By;



/**
 * 病因业务层
 * @author owen
 */
public interface ByService {
	
	/**
	 * @param symptomItem
	 */
	public List<By> queryAllBy();
	
	/**
	 * @param by_code
	 * @return
	 */
	public By querySingleBy(String by_code);
	
	/**
	 * @param by_code
	 * @return
	 */
	public String querySingleByName(String by_code);
	
	/**
	 * 初始方法
	 */
	public void init();
}
