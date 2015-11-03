package com.md.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.md.common.BaseConditionVO;
import com.md.common.Constant;
import com.md.entity.Customer;
import com.md.entity.CustomerCount;
import com.md.service.CustomerService;

/**
 * 后台统计
 * @author wzb
 *
 */
@Controller
@RequestMapping("/md/customerCount")
public class CustomerCountController  extends BaseController{
	
	@Resource
	private CustomerService customerService;

	/**
	 * 统计在线人数
	 *   匿名用户、普通用户、vip用户在线数、值班医生
	 * @param request
	 * @param vo
	 * @param model
	 * @param customerApplyinfo
	 * @return
	 */
	@RequestMapping(value = "/queryOnlineCountInfo")
	public String queryOnlineCountInfo(HttpServletRequest request,BaseConditionVO vo,Model model){
		CustomerCount customerCount = customerService.queryOnLineCount();
		
		ServletContext ctx = request.getSession().getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = 0;
		}
		
		else{
			//匿名数=当前在线人数 - 在线普通用户 -在线VIP用户 -在线管理员  - 在线专家
			int onLineAnonymousCount = numSessions - customerCount.getOnLineExpertCount() - 
					                   customerCount.getOnLineCommonCount() -customerCount.getOnLineVipCount() -
					                   customerCount.getOnLineManagerCount();
			customerCount.setOnLineAnonymousCount(onLineAnonymousCount);
		}
		
		customerCount.setOnLineCount(numSessions);
		
		model.addAttribute("customerCount", customerCount);
		return "customerCount/onLineCountInfo";
	}
	
	/**
	 * 统计注册人数
	 *    普通用户数、vip用户数、值班医生用户数
	 * @param request
	 * @param vo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryRegisterCountInfo")
	public String queryRegisterCountInfo(HttpServletRequest request,BaseConditionVO vo,Model model){
		CustomerCount customerCount = customerService.queryRegisterCount();
		model.addAttribute("customerCount", customerCount);
		return "customerCount/registerCountInfo";
	}
	
	/**
	 * 获取用户信息，针对统计
	 */
	@RequestMapping(value = "/queryRegisterOnlineCustomerInfo")
	public String queryRegisterOnlineCustomerInfo(HttpServletRequest request,Model model,BaseConditionVO vo,Customer customer){
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("start", vo.getStartIndex());
		mapParmas.put("limit", vo.getPageSize());
		
		mapParmas.put("domain", customer);
		
		List<Customer> registerOnlineCustomerList = customerService.queryRegisterOnlineCustomerData(mapParmas);
		Integer totalCount = customerService.queryRegisterOnlineCustomerCount(mapParmas);
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("registerOnlineCustomerList", registerOnlineCustomerList);
		
		String pageUrl = "customerCount/registerCommon";
		if(null != customer.getIs_on_line() && customer.getIs_on_line() == Constant.ONLINE_YES){
			//在线用户
			switch (Integer.parseInt(customer.getCustomer_type())) {
			case 1:
				pageUrl = "customerCount/onLineCommon";
				break;
			case 2:
				pageUrl = "customerCount/onLineVip";			
				break;
			case 3:
				pageUrl = "customerCount/onLineExpert";
				break;
			default:
				break;
			}
		}
		else{
			//注册用户
			switch (Integer.parseInt(customer.getCustomer_type())) {
			case 1:
				pageUrl = "customerCount/registerCommon";
				break;
			case 2:
				pageUrl = "customerCount/registerVip";			
				break;
			case 3:
				pageUrl = "customerCount/registerExpert";
				break;
			default:
				break;
			}
		}
		
		return pageUrl;
	}
	
}
