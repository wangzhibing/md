package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.SymptomItemValue;
import com.md.mapper.SymptomItemValueMapper;
import com.md.service.SymptomItemValueService;

/**
 * 症状条目数值表服务层
 * @author owen
 */
@Service
public class SymptomItemValueServiceImpl implements SymptomItemValueService {

	Logger logger = Logger.getLogger(SymptomItemValueServiceImpl.class);
	
	@Resource
	private SymptomItemValueMapper symptomItemValueMapper;
	
	//存储条目值数据
	private Map<Long, SymptomItemValue> SIVMap;
	
	/**
	 * 返回症状条目数值
	 * @return
	 */
	@Override
	public List<SymptomItemValue> querySymptomItemValueInfo(SymptomItemValue siv){
		logger.info("获取症状条目数值信息。。。");
		return symptomItemValueMapper.selectSymptomItemValueInfo(siv);
	}
	
	/**
	 * 通过勾选的症状条目信息数组
	 * @return
	 */
	public List<SymptomItemValue> querySymptomItemValueInfoByArray(String[] arrItems){
		logger.info("获取症状条目数值信息，条目信息："+arrItems.toString());
		return symptomItemValueMapper.selectSymptomItemValueInfoByArray(arrItems);
	}
	
	/**
	 * @param SymptomItemValue
	 */
	public List<SymptomItemValue> queryAllSIV(){
		return symptomItemValueMapper.selectSymptomItemValueInfo(null);
	}
	
	/**
	 * @param siv_id
	 * @return
	 */
	public SymptomItemValue querySingleSIV(String siv_id){
		SymptomItemValue siv = null;
		if(SIVMap != null && null != SIVMap.get(Long.parseLong(siv_id))){
			siv = (SymptomItemValue) SIVMap.get(Long.parseLong(siv_id));
		}
		return siv;
	}
	
	/**
	 * @param siv_id
	 * @return
	 */
	public String querySingleSIVName(String siv_id){
		String sivName = null;
		if(SIVMap != null && null != SIVMap.get(Long.parseLong(siv_id))){
			SymptomItemValue siv = (SymptomItemValue) SIVMap.get(Long.parseLong(siv_id));
			sivName = siv.getName();
		}
		return sivName;
	}
	
	@Override
	@PostConstruct
	public void init(){
		List<SymptomItemValue> listSIV = this.queryAllSIV();
		if(listSIV != null && listSIV.size() > 0){
			SIVMap = new HashMap<Long, SymptomItemValue>();
			for(SymptomItemValue siv : listSIV){
				SIVMap.put(siv.getId(), siv);
			}
		}
	}

}
