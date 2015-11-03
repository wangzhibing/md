package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.Bw;
import com.md.mapper.BwMapper;
import com.md.service.BwService;

/**
 * 症状条目数值表服务层
 * @author owen
 */
@Service
public class BwServiceImpl implements BwService {

	Logger logger = Logger.getLogger(BwServiceImpl.class);
	
	private Map<Object, Object> bwMap;
	
	@Resource
	private BwMapper bwMapper;
	
	@Override
	@PostConstruct
	public void init(){
		List<Bw> listBw = this.queryAllBw();
		if(listBw != null && listBw.size() > 0){
			bwMap = new HashMap<Object, Object>();
			for(Bw bw : listBw){
				bwMap.put(bw.getCode(), bw);
			}
		}
	}
	
	/**
	 * @param bw_code
	 * @return
	 */
	public Bw querySingleBw(String bw_code){
		Bw bw = null;
		if(bwMap != null && null != bwMap.get(bw_code)){
			bw = (Bw) bwMap.get(bw_code);
		}
		return bw;
	}
	
	/**
	 * @param bw_code
	 * @return
	 */
	public String querySingleBwName(String bw_code){
		String bw_name = "";
		if(bwMap != null && null != bwMap.get(bw_code)){
			Bw bw = (Bw) bwMap.get(bw_code);
			bw_name = bw.getName();
		}
		return bw_name;
	}

	@Override
	public List<Bw> queryAllBw() {
		return bwMapper.selectAllBwList();
	}
	
	@PreDestroy
	public void destory(){
	    System.out.println("正在执行销毁之前的destory方法");
	}
}
