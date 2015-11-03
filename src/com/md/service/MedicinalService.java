package com.md.service;

import java.util.List;
import java.util.Map;

import com.md.entity.Medicinal;



/**
 * 药材信息表
 * @author wzb
 */
public interface MedicinalService {
	
	/**
	 * @param Medicinal
	 */
	public List<Medicinal> queryAllMedicinal();
	
	/**
	 * @param m_code
	 * @return
	 */
	public Medicinal querySingleMedicinal(String m_code);
	
	/**
	 * @param m_code
	 * @return
	 */
	public String querySingleMedicinalName(String m_code);
	
	/**
	 * @param actionValue
	 * @return
	 */
	public String queryMedicinalActionName(String actionValue);
	
	/**
	 * 初始方法
	 */
	public void init();
	
	/**
	 * 获取药材信息分页
	 * @param mapParams
	 * @return
	 */
	public List<Medicinal> queryMedicinalData(Map<String, Object> mapParams);
	
	/**
	 * 获取药材信息分页
	 * @param mapParams
	 * @return
	 */
	public Integer queryMedicinalCount(Map<String, Object> mapParams);
	
	/**
	 * 获取单个药材信息
	 * @param medicinalId
	 * @return
	 */
	public Medicinal queryMedicinalById(Long medicinalId);
}
