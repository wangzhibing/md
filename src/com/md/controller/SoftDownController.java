package com.md.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 软件下载
 * @author owen
 */
@Controller
@RequestMapping("/md/softDown")
public class SoftDownController extends BaseController{
	
	/**
	 * 软件下载跳转页面
	 * @return
	 */
	@RequestMapping(value = "/softDownForward")
	public String softDownForward(HttpServletRequest request,Model model){
		return "softDown/softDown";
	}

}
