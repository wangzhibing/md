package com.md.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.Diagnose;
import com.md.entity.DiagnoseDetail;
import com.md.entity.DiagnoseResult;

/**
 * 户诊断信息Mapper接口
 * @author owen
 *
 */
@Repository
public interface DiagnoseMapper {
	
	/**
	 * 新增诊断信息
	 * @param diagnose
	 */
	public void insertDiagnose(Diagnose diagnose);
	
	/**
	 * 新增诊断明细信息（批量插入，一个这段信息，对应多笔诊断明细信息）
	 * @param diagnose
	 */
	public void insertDiagnoseDetail(List<DiagnoseDetail> diagnoseDetailList);
	
	/**
	 * 新增诊断结果信息
	 * @param diagnose
	 */
	public void insertDiagnoseResult(DiagnoseResult diagnoseResult);
	
	/**
	 * 1、客户选择诊断医生时更新,
	 * 2、医生回复之后亦可更新
	 */
	public void updateDiagnose(Diagnose diagnose);
	
	/**
	 * 修改诊断结果信息 有病人自己诉求、也有医生看过之后的稍微修改
	 * 这方法不轻易去操作
	 * @param diagnoseResult
	 * 可以根据diagnoseId,也可以更具id来处理
	 */
	public void updateDiagnoseResult(DiagnoseResult diagnoseResult);
	
	/**
	 * 获取诊断信息列表 把客户诊断信息一起显示出来
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> selectDiagnoseData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectDiagnoseList
	 * 获取诊断信息列表 把客户诊断信息一起显示出来
	 * @param mapParams
	 * @return
	 */
	public Integer selectDiagnoseCount(Map<String,Object> mapParams);
	
	/**
	 * 获取诊断症状明细信息列表
	 * @param mapParams
	 * @return
	 */
	public List<DiagnoseDetail> selectDiagnoseDetailData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectDiagnoseDetailList
	 * @param mapParams
	 * @return
	 */
	public Integer selectDiagnoseDetailCount(Map<String,Object> mapParams);
	
	/**
	 * 获取诊断结果信息列表
	 * @param mapParams
	 * @return
	 */
	public List<DiagnoseResult> selectDiagnoseResultData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectDiagnoseResultList
	 * @param mapParams
	 * @return
	 */
	public Integer selectDiagnoseResultCount(Map<String,Object> mapParams);
	
	/**
	 * 获取诊断结果信息列表 ==>查单个
	 * @param mapParams
	 * @return
	 */
	public DiagnoseResult selectDiagnoseResultSingle(Long id);
	
	/**
	 * 获取诊断信息
	 * @param mapParams
	 * @return
	 */
	public Diagnose selectDiagnoseByPk(Long id);
	
	/**
	 * 查看该专家有多少待确诊的诊断病例
	 * @param expert_customer_id
	 * @return
	 */
	public Integer selectCountWaitingExpert(Long expert_customer_id);
	
	/**
	 * 查看客户有多少诊断结果未查看
	 * @param expert_customer_id
	 * @return
	 */
	public Integer selectCountWaitingLook(Long customer_id);
	
	
	/**
	 * 根据当前值班医生，获取该医生待确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> selectExpertCheckingDiagnoseData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectExpertCheckIngDiagnoseData
	 * 根据当前值班医生，获取该医生待确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public Integer selectExpertCheckingDiagnoseCount(Map<String,Object> mapParams);
	 
	/**
	 * 根据当前值班医生，获取该医生已确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public List<Diagnose> selectExpertCheckedDiagnoseData(Map<String,Object> mapParams);
	
	/**
	 * 对应selectExpertCheckedDiagnoseData
	 * 根据当前值班医生，获取该医生已确诊的病例信息
	 * @param mapParams
	 * @return
	 */
	public Integer selectExpertCheckedDiagnoseCount(Map<String,Object> mapParams);

	
	
	
}
