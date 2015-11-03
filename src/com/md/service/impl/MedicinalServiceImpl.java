package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.common.Constant;
import com.md.entity.Medicinal;
import com.md.mapper.MedicinalMapper;
import com.md.service.MedicinalService;
/**
 * 药材表 
 * @author owen
 */
@Service
public class MedicinalServiceImpl implements MedicinalService {
	
	Logger logger = Logger.getLogger(MedicinalServiceImpl.class);
	
	//存储症状处方数据
	private Map<String, Medicinal> medicinalMap;
	
	//存储药材行为数据
	private Map<String, String> actionMap;
	
	@Resource
	private MedicinalMapper medicinalMapper;
	

	@Override
	public List<Medicinal> queryAllMedicinal() {
		return medicinalMapper.selectMedicinalInfo();
	}

	@Override
	public Medicinal querySingleMedicinal(String m_code) {
		Medicinal med = null;
		if(medicinalMap != null && null != medicinalMap.get(m_code)){
			med = (Medicinal) medicinalMap.get(m_code);
		}
		return med;
	}

	@Override
	public String querySingleMedicinalName(String m_code) {
		String medName = null;
		if(medicinalMap != null && null != medicinalMap.get(m_code)){
			Medicinal med = (Medicinal) medicinalMap.get(m_code);
			medName = med.getName();
		}
		if(StringUtils.isBlank(medName)){
			medName = m_code;
		}
		return medName;
	}
	
	/**
	 * 获取药材行为名称
	 */
	public String queryMedicinalActionName(String actionValue){
		String actionContent = actionMap.get(actionValue);
		if(StringUtils.isBlank(actionContent)){
			actionContent = "未知";
		}
		return actionContent;
	}

	@Override
	@PostConstruct
	public void init(){
		List<Medicinal> listMedicinal = this.queryAllMedicinal();
		if(listMedicinal != null && listMedicinal.size() > 0){
			medicinalMap = new HashMap<String, Medicinal>();
			for(Medicinal med : listMedicinal){
				medicinalMap.put(med.getCode(), med);
			}
		}
		
		actionMap = new HashMap<String, String>();
		actionMap.put(Constant.DEDICINAL_ACTION_1, "先煎");
		actionMap.put(Constant.DEDICINAL_ACTION_2, "后下");
		actionMap.put(Constant.DEDICINAL_ACTION_3, "冲服");
		actionMap.put(Constant.DEDICINAL_ACTION_4, "生用");
		actionMap.put(Constant.DEDICINAL_ACTION_5, "磨粉");
		actionMap.put(Constant.DEDICINAL_ACTION_6, "烊化");
		actionMap.put(Constant.DEDICINAL_ACTION_7, "打碎煎");
		actionMap.put(Constant.DEDICINAL_ACTION_8, "研末冲服");
		actionMap.put(Constant.DEDICINAL_ACTION_9, "布包煎");
		actionMap.put(Constant.DEDICINAL_ACTION_10, "炒黑");
		actionMap.put(Constant.DEDICINAL_ACTION_11, "打碎先煎 ");	
		actionMap.put(Constant.DEDICINAL_ACTION_12, "醋炒");
		actionMap.put(Constant.DEDICINAL_ACTION_13, "水煎服");
		actionMap.put(Constant.DEDICINAL_ACTION_14, "盐水炒");
		actionMap.put(Constant.DEDICINAL_ACTION_15, "后溶于药汁");
	}
	
	
	/**
	 * 获取药材信息分页
	 * @param mapParams
	 * @return
	 */
	public List<Medicinal> queryMedicinalData(Map<String, Object> mapParams){
		return medicinalMapper.selectMedicinalData(mapParams);
	}
	
	/**
	 * 获取药材信息分页
	 * @param mapParams
	 * @return
	 */
	public Integer queryMedicinalCount(Map<String, Object> mapParams){
		return medicinalMapper.selectMedicinalCount(mapParams);
	}
	
	/**
	 * 获取单个药材信息
	 * @param medicinalId
	 * @return
	 */
	public Medicinal queryMedicinalById(Long medicinalId){
		return medicinalMapper.selectMedicinalById(medicinalId);
	}

}
