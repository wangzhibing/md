package com.md.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.BaseConditionVO;
import com.md.common.Constant;
import com.md.common.DateUtil;
import com.md.common.ResponseEnvelope;
import com.md.common.ResponseObj;
import com.md.entity.Customer;
import com.md.entity.MessageBoard;
import com.md.service.MessageBoardService;

/**
 * 留言板信息控制层
 * @author wzb
 */
@Controller
@RequestMapping("/md/messageBoard")
public class MessageBoardController extends BaseController{
	
	@Resource
	private MessageBoardService messageBoardService;
	
	/**
	 * 留言板页面跳转
	 * 获取留言板信息(分页)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/messageBoardForward")
	public String messageBoardForward(HttpServletRequest request,Model model,BaseConditionVO vo,MessageBoard messageBoard){
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		
		//开始查询日期  结束查询日期，都为空的情况下(页面从左边菜单栏点击进来)：
		if(StringUtils.isBlank(messageBoard.getTime_start()) && StringUtils.isBlank(messageBoard.getTime_end())){
			messageBoard.setTime_start(DateUtil.stringDateAdd(new Date(),Constant.queryDate));
			messageBoard.setTime_end(DateUtil.date2String(new Date(), Constant.PATTERN_3));
		}
		else{
			
			if(!StringUtils.isBlank(messageBoard.getTime_start())){
				messageBoard.setTime_start(DateUtil.dateFormatToStr2(messageBoard.getTime_start()));
			} 
			
			if(!StringUtils.isBlank(messageBoard.getTime_end())){
				messageBoard.setTime_end(DateUtil.dateFormatToStr2(messageBoard.getTime_end()));
			}
		}
		
		if(!StringUtils.isBlank(messageBoard.getQueryType()) && messageBoard.getQueryType().equals("1")){
			//当前登录用户的留言信息
			messageBoard.setCustomer_id(loginCustomer.getId());
		}
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("start", vo.getStartIndex());
		mapParmas.put("limit", vo.getPageSize());
		mapParmas.put("domain", messageBoard);
		
		List<MessageBoard> messageBoardList = messageBoardService.queryMessageBoardData(mapParmas);
		Integer totalCount = messageBoardService.queryMessageBoardCount(mapParmas);
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("messageBoardList", messageBoardList);
		model.addAttribute("loginCustomer", loginCustomer);
		model.addAttribute("messageBoard", messageBoard);
		
		return "messageBoard/messageBoardList";
	}
	
	
	/**
	 * 获取留言明细
	 * @param request
	 * @param model
	 * @param vo
	 * @param messageBoardId
	 * @return
	 */
	@RequestMapping(value = "/queryMessageBoardDetail")
	public String queryMessageBoardDetail(HttpServletRequest request,Model model,BaseConditionVO vo,String messageBoardId){
		MessageBoard messageBoard = messageBoardService.queryMessageBoardByPk(Long.parseLong(messageBoardId));
		model.addAttribute("messageBoard", messageBoard);
		return "messageBoard/messageBoardDetail";
	}
	
	
	/**
	 * 调整我要留言页面
	 * @return
	 */
	@RequestMapping(value = "/addMessageBoardJsp")
	public String addMessageBoardJsp(HttpServletRequest request,Model model){
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		String customer_name = "匿名";
		if(null != loginCustomer){
			customer_name = loginCustomer.getName();
		}
		model.addAttribute("customer_name", customer_name);
		return "messageBoard/messageBoardAdd";
	}
	
	
	/**
	 *  新增留言信息
	 * @param request
	 * @param model
	 * @param messageBoard
	 * @return
	 */
	@RequestMapping(value = "/addMessageBoard")
	@ResponseBody  
	public Object addMessageBoard(HttpServletRequest request,Model model,MessageBoard messageBoard){
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		if(null != loginCustomer){
			messageBoard.setCustomer_id(loginCustomer.getId());
		}
		else{
			messageBoard.setCustomer_id(Constant.ANONYMITY_CUSTOMER_ID);
		}
		
		messageBoard.setTime(DateUtil.date2String(new Date(), Constant.PATTERN_4));
		messageBoard.setStatus("1");
		messageBoardService.addMessageBoard(messageBoard);
		return new ResponseObj(Constant.STATUSCODE_SUCCESS, "留言成功", "hjm", "", "closeCurrent", "");
	}

	
	/**
	 *  新增留言信息
	 * @param request
	 * @param model
	 * @param messageBoard
	 * @return
	 */
	@RequestMapping(value = "/delMessageBoard")
	@ResponseBody  
	public Object delMessageBoard(HttpServletRequest request,Model model,String messageBoardId){
		messageBoardService.delMessageBoard(Long.parseLong(messageBoardId));
		return new ResponseObj(Constant.STATUSCODE_SUCCESS, "删除成功", "", "", "", "");
	}

}
