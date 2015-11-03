package com.md.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.md.common.BaseConditionVO;
import com.md.entity.User;
import com.md.service.UserService;

@Controller
@RequestMapping("/md/user")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(HttpServletRequest request, User user){
		try {
			userService.addUser(user);
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/delUser")
	public Object delUser(HttpServletRequest request, String id){
		try {
			userService.delUser(id);
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/editUser")
	public Object editUser(HttpServletRequest request,  User user){
		try {
			userService.editUser(user);
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/queryUserListInfoPage")
	public String queryUserListInfoPage(BaseConditionVO vo, User user,Model model){
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("start", vo.getStartIndex());
		mapParmas.put("limit", vo.getPageSize());
		mapParmas.put("domain",user);
		
		List<User> userList = userService.queryUserInfo(mapParmas);
		Integer totalCount = userService.queryUserInfoCount(mapParmas);
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("userList", userList);
		return "userinfo/userListPage";
	}
	
	@RequestMapping(value = "/jspAddUser")
	public String pageAddUser(){
		return "userinfo/addUser";
	}
	
	@RequestMapping(value = "/jspEditUser")
	public String jspEditUser(Model model,String id){
		User user = userService.queryUserById(id);
		model.addAttribute("user", user);
		return "userinfo/editUser";
	}
	
	@RequestMapping(value = "/queryUserListInfo")
	public String queryUserListInfo(User user,Model model){
		
		Map<String, Object> mapParmas = new HashMap<String,Object>();
		mapParmas.put("domain",user);
		
		List<User> userList = userService.queryUserInfo(mapParmas);
		
		model.addAttribute("userList", userList);
		return "userinfo/userList";
	}
}
