package com.md.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.md.entity.Diagnose;
import com.md.entity.DiagnoseDetail;
import com.md.entity.DiagnoseResult;
import com.md.mapper.DiagnoseMapper;
import com.md.service.DiagnoseService;

/**
 * 症状条目数值表服务层
 * @author owen
 */
@Service
@Transactional  
public class DiagnoseServiceImpl implements DiagnoseService {

	Logger logger = Logger.getLogger(DiagnoseServiceImpl.class);
	
	@Resource
	private DiagnoseMapper diagnoseMapper;
	
	/**
	 * 获取诊断结果信息列表 ==>查单个
	 * @param id
	 * @return
	 */
	public DiagnoseResult queryDiagnoseResultSingle(Long id){
		return diagnoseMapper.selectDiagnoseResultSingle(id);
	}
	
	/**
	 * 通过诊断ID获取诊断明细信息
	 * @param diagnose_id
	 * @return
	 */
	public List<DiagnoseDetail> queryDiagnoseDetailByDiagnoseId(Long diagnose_id){
		Map<String, Object> mapParams = new HashMap<String,Object>();
		DiagnoseDetail domain = new DiagnoseDetail();
		domain.setDiagnose_id(diagnose_id);
		mapParams.put("domain", domain);
		return diagnoseMapper.selectDiagnoseDetailData(mapParams);
	}
	
	
	/**
	 * 获取诊断信息列表 把客户诊断信息一起显示出来
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> queryDiagnoseData(Map<String,Object> mapParams){
		return diagnoseMapper.selectDiagnoseData(mapParams);
	}
	
	/**
	 * 对应selectDiagnoseList
	 * 获取诊断信息列表 把客户诊断信息一起显示出来
	 * @param mapParams
	 * @return
	 */
	public Integer queryDiagnoseCount(Map<String,Object> mapParams){
		return diagnoseMapper.selectDiagnoseCount(mapParams);
	}
	
	/**
	 * 获取诊断信息
	 * @param id
	 * @return
	 */
	public Diagnose queryDiagnoseByPk(Long id){
		return diagnoseMapper.selectDiagnoseByPk(id);
	}
	
	
	/**
	 * 修改诊断信息
	 * @param diagnose
	 */
	public void editDiagnose(Diagnose diagnose){
		diagnoseMapper.updateDiagnose(diagnose);
	}
	
	
	/**
	 * 修改诊断结果信息 
	 * 场景1：病人修改主诉及病史
	 * 场景2：医生修改处方等信息
	 * 
	 * 参数：诊断ID  诊断结果ID 其中一个就行
	 * @param diagnoseResult
	 */
	public void editDiagnoseResult(DiagnoseResult diagnoseResult){
		diagnoseMapper.updateDiagnoseResult(diagnoseResult);
	}
	
	/**
	 * 查看该专家有多少待确诊的诊断病例
	 * @param expert_customer_id
	 * @return
	 */
	public Integer queryCountWaitingExpert(Long expert_customer_id){
		return diagnoseMapper.selectCountWaitingExpert(expert_customer_id);
	}
	
	/**
	 * 查看客户有多少诊断结果未查看
	 * @param expert_customer_id
	 * @return
	 */
	public Integer queryCountWaitingLook(Long customer_id){
		return diagnoseMapper.selectCountWaitingLook(customer_id);
	}
	
	/**
	 * 根据当前值班医生，获取该医生待确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> queryExpertCheckingDiagnoseData(Map<String,Object> mapParams){
		return diagnoseMapper.selectExpertCheckingDiagnoseData(mapParams);
	}
	
	/**
	 * 对应selectExpertCheckIngDiagnoseData
	 * 根据当前值班医生，获取该医生待确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public Integer queryExpertCheckingDiagnoseCount(Map<String,Object> mapParams){
		return diagnoseMapper.selectExpertCheckingDiagnoseCount(mapParams);
	}
	 
	/**
	 * 根据当前值班医生，获取该医生已确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> queryExpertCheckedDiagnoseData(Map<String,Object> mapParams){
		return diagnoseMapper.selectExpertCheckedDiagnoseData(mapParams);
	}
	
	/**
	 * 对应selectExpertCheckedDiagnoseData
	 * 根据当前值班医生，获取该医生已确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public Integer queryExpertCheckedDiagnoseCount(Map<String,Object> mapParams){
		return diagnoseMapper.selectExpertCheckedDiagnoseCount(mapParams);
	}
}
