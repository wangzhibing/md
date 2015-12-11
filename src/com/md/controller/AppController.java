package com.md.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.entity.DiagnoseResult;
import com.md.service.DiagnoseCoreService;

/**
 * 对外暴露接口, app／web
 * @author owen
 *
 */
@Controller
@RequestMapping("/md/app")
public class AppController extends BaseController{
	
	@Resource
	private DiagnoseCoreService diagnoseCoreService;
	
	/**
	 * 处理诊断业务信息
	 *      request : SpringMvc固定参数
	 *       model  : SpringMvc固定参数
	 * symptomItem  : 客户勾选的症状
	 * mainSymptom  : 客户勾选主要症状
	 * wholeAppID   : 全局流水
	 */
	@RequestMapping(value = "/doSymptomItem")
	@ResponseBody  
	public Object doSymptomItem(HttpServletRequest request,Model model,String[] symptomItem,String mainSymptom,String wholeAppID){
		DiagnoseResult diagnoseResult = null;
		try {
			 diagnoseResult = diagnoseCoreService.doDiagnoseByApp(symptomItem, mainSymptom);
			 diagnoseResult.setWholeAppID(wholeAppID);
			 return diagnoseResult;
		} catch (Exception e) {
			 System.out.println(e.getMessage());
			 diagnoseResult = new DiagnoseResult();
			 diagnoseResult.setWholeAppID(wholeAppID);
			 return diagnoseResult;
		}
	}
	
	
	
}
