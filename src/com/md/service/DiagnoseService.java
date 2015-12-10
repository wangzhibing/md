package com.md.service;

import java.util.List;
import java.util.Map;

import com.md.entity.Customer;
import com.md.entity.Diagnose;
import com.md.entity.DiagnoseDetail;
import com.md.entity.DiagnoseResult;



/**
 * 诊断处理业务层
 * @author owen
 */
public interface DiagnoseService {
	
	/**
	 * 获取诊断结果信息列表 ==>查单个
	 * @param id
	 * @return
	 */
	public DiagnoseResult queryDiagnoseResultSingle(Long id);
	
	/**
	 * 通过诊断ID获取诊断明细信息
	 * @param diagnose_id
	 * @return
	 */
	public List<DiagnoseDetail> queryDiagnoseDetailByDiagnoseId(Long diagnose_id);
	
	
	/**
	 * 获取诊断信息列表 把客户诊断信息一起显示出来
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> queryDiagnoseData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectDiagnoseList
	 * 获取诊断信息列表 把客户诊断信息一起显示出来
	 * @param mapParams
	 * @return
	 */
	public Integer queryDiagnoseCount(Map<String,Object> mapParams);
	
	/**
	 * 获取诊断信息
	 * @param id
	 * @return
	 */
	public Diagnose queryDiagnoseByPk(Long id);
	
	/**
	 * 修改诊断信息
	 * @param diagnose
	 */
	public void editDiagnose(Diagnose diagnose);
	
	/**
	 * 修改诊断结果信息 
	 * 场景1：病人修改主诉及病史
	 * 场景2：医生修改处方等信息
	 * 
	 * 参数：诊断ID  诊断结果ID 其中一个就行
	 * @param diagnoseResult
	 */
	public void editDiagnoseResult(DiagnoseResult diagnoseResult);
	
	/**
	 * 查看该专家有多少待确诊的诊断病例
	 * @param expert_customer_id
	 * @return
	 */
	public Integer queryCountWaitingExpert(Long expert_customer_id);
	

	/**
	 * 查看该专家有多少待确诊的诊断病例
	 * @param expert_customer_id
	 * @return
	 */
	public Integer queryCountWaitingLook(Long customer_id);
	
	
	/**
	 * 根据当前值班医生，获取该医生待确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> queryExpertCheckingDiagnoseData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectExpertCheckIngDiagnoseData
	 * 根据当前值班医生，获取该医生待确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public Integer queryExpertCheckingDiagnoseCount(Map<String,Object> mapParams);
	 
	/**
	 * 根据当前值班医生，获取该医生已确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> queryExpertCheckedDiagnoseData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectExpertCheckedDiagnoseData
	 * 根据当前值班医生，获取该医生已确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public Integer queryExpertCheckedDiagnoseCount(Map<String,Object> mapParams);
	
}
