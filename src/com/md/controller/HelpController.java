package com.md.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用帮助
 * @author owen
 *
 */
@Controller
@RequestMapping("/md/help")
public class HelpController extends BaseController{
	
	/**
	 * 使用帮助页面
	 * @return
	 */
	@RequestMapping(value = "/helpForward")
	public String helpForward(HttpServletRequest request,Model model){
		return "help/help";
	}
}
