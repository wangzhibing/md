package com.md.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.md.entity.SymptomItemValue;

/**
 * 症状条目数值表
 * @author owen
 */
@Repository
public interface SymptomItemValueMapper {
	
	/**
	 * 查询症状条目数值
	 * @return
	 */
	public List<SymptomItemValue> selectSymptomItemValueInfo(SymptomItemValue siv);
	
	/**
	 * 通过勾选的症状条目信息数组
	 * @param arrItems
	 * @return
	 */
	public List<SymptomItemValue> selectSymptomItemValueInfoByArray(String[] arrItems);
}
