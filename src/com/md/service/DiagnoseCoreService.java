package com.md.service;

import com.md.entity.Customer;
import com.md.entity.DiagnoseResult;



/**
 * 诊断处理业务层
 * @author owen
 */
public interface DiagnoseCoreService {
	
	/**
	 * 页面端(管理段)进入
	 * 处理诊断业务信息（页面进入）
	 * @param symptomItem
	 */
	public DiagnoseResult doDiagnose(String[] symptomItems,String mainSymptom,Customer loginCustomer,String sex)  throws Exception;
	
	
	/**
	 * app端访问数据(主要传入症状信息、主症状)
	 * @param symptomItems
	 * @param mainSymptom
	 * @return
	 * @throws Exception
	 */
	public DiagnoseResult doDiagnoseByApp(String[] symptomItems,String mainSymptom)  throws Exception; 
	
	
}
