package com.md.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.md.entity.Bw;

@Repository
public interface BwMapper {
	
	/**
	 * 获取病位信息
	 * @return
	 */
	public List<Bw> selectAllBwList();
	
}
