package com.md.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.Constant;
import com.md.common.ResponseObj;
import com.md.entity.Customer;
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
	 */
	@RequestMapping(value = "/doSymptomItem")
	@ResponseBody  
	public Object doSymptomItem(HttpServletRequest request,Model model,String[] symptomItem,String mainSymptom){
		DiagnoseResult diagnoseResult = null;
		try {
			 diagnoseResult = diagnoseCoreService.doDiagnoseByApp(symptomItem, mainSymptom);
			 return null;
		} catch (Exception e) {
			 System.out.println(e.getMessage());
			 return null;
		}
	}
	
	
	
}
