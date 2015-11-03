package com.md.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.md.entity.By;

@Repository
public interface ByMapper {
	
	/**
	 * 获取病位信息
	 * @return
	 */
	public List<By> selectAllByList();
	
}
