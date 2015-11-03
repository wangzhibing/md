package com.md.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.md.common.BaseConditionVO;
import com.md.entity.Medicinal;
import com.md.service.MedicinalService;

@Controller
@RequestMapping("/md/medicinal")
public class MedicinalController extends BaseController{
	
	@Resource
	private MedicinalService medicinalService;
	
	/**
	 * 获取药材信息(分页)
	 * @param vo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryMedicinalData")
	public String queryMedicinalData(BaseConditionVO vo,Model model){
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("start", vo.getStartIndex());
		mapParmas.put("limit", vo.getPageSize());
		mapParmas.put("queryValue",vo.getQueryValue());
		
		List<Medicinal> medicinalList = medicinalService.queryMedicinalData(mapParmas);
		Integer totalCount = medicinalService.queryMedicinalCount(mapParmas);
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("medicinalList", medicinalList);
		return "medicinal/medicinalList";
	}
	
	
	/**
	 * 获取药材详细信息
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryMedicinalById")
	public String queryMedicinalById(Model model,String id){
		Medicinal medicinal  = medicinalService.queryMedicinalById(Long.parseLong(id));
		model.addAttribute("medicinal", medicinal);
		return "medicinal/medicinalDetail";
	}

}
