package com.md.service;

import java.util.List;

import com.md.entity.SymptomItemValue;


/**
 * 症状条目数值表服务层
 * @author owen
 */
public interface SymptomItemValueService {
	
	/**
	 * 返回症状条目数值
	 * @return
	 */
	public List<SymptomItemValue> querySymptomItemValueInfo(SymptomItemValue siv);
	
	/**
	 * 通过勾选的症状条目信息数组
	 * @return
	 */
	public List<SymptomItemValue> querySymptomItemValueInfoByArray(String[] arrItems);
	
	/**
	 * @param SymptomItemValue
	 */
	public List<SymptomItemValue> queryAllSIV();
	
	/**
	 * @param siv_id
	 * @return
	 */
	public SymptomItemValue querySingleSIV(String siv_id);
	
	/**
	 * @param siv_id
	 * @return
	 */
	public String querySingleSIVName(String siv_id);
	
	/**
	 * 初始方法
	 */
	public void init();
}
