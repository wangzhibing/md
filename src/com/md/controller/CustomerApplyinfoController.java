package com.md.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.md.common.BaseConditionVO;
import com.md.common.Constant;
import com.md.common.DateUtil;
import com.md.entity.Customer;
import com.md.entity.CustomerApplyinfo;
import com.md.service.CustomerApplyinfoService;

@Controller
@RequestMapping("/md/customerApplyinfo")
public class CustomerApplyinfoController extends BaseController{
	
	@Resource
	private CustomerApplyinfoService customerApplyinfoService;
	

	@RequestMapping(value = "/querycustomerApplyinfoData")
	public String querycustomerApplyinfoData(HttpServletRequest request,BaseConditionVO vo,Model model,CustomerApplyinfo customerApplyinfo){
		
		
		String deal_date_start = customerApplyinfo.getDeal_date_start();
		String deal_date_end = customerApplyinfo.getDeal_date_end();
		
		if(!StringUtils.isBlank(deal_date_start) &&
			deal_date_start.length() == 10){
			customerApplyinfo.setDeal_date_start(DateUtil.dateFormatToStr2(deal_date_start));
		}
		
		if(!StringUtils.isBlank(deal_date_end) &&
				deal_date_end.length() == 10){
				customerApplyinfo.setDeal_date_end(DateUtil.dateFormatToStr2(deal_date_end));
		}
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		customerApplyinfo.setManager_customer_id(loginCustomer.getId());
		
		Map<String, Object> mapParams = new HashMap<String,Object>();
		mapParams.put("start", vo.getStartIndex());
		mapParams.put("limit", vo.getPageSize());
		mapParams.put("domain",customerApplyinfo);
		
		List<CustomerApplyinfo> customerApplyinfoList = customerApplyinfoService.queryCustomerApplyinfoData(mapParams);
		Integer totalCount = customerApplyinfoService.queryCustomerApplyinfoCount(mapParams);
		
		vo.setTotalCount(totalCount);
		
		customerApplyinfo.setDeal_date_start(deal_date_start);
		customerApplyinfo.setDeal_date_end(deal_date_end);
		
		model.addAttribute("customerApplyinfo", customerApplyinfo);
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("customerApplyinfoList", customerApplyinfoList);
		return "customer/customerApplyinfoList";
	}
	
}
