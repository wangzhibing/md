package com.md.service;

import java.util.List;

import com.md.entity.Bw;



/**
 * 病位业务层
 * @author owen
 */
public interface BwService {
	
	/**
	 * @param symptomItem
	 */
	public List<Bw> queryAllBw();
	
	/**
	 * @param bw_code
	 * @return
	 */
	public Bw querySingleBw(String bw_code);
	
	/**
	 * @param bw_code
	 * @return
	 */
	public String querySingleBwName(String bw_code);
	
	/**
	 * 初始方法
	 */
	public void init();
}
