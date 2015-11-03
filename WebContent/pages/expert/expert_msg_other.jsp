<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<div class="pageContent">
<!--   本功能只为交费VIP用户提供服务，获取VIP用户的途径：
 1、	耆珍堂中医院用户
 2、XXXX养老中心用户
 3、认证/缴费用户
 
  医院/养老用户进入         前去缴费	 -->
  <div class="pageFormContent" layoutH="50">
    <dl class="nowrap">
			${expert_msg}
    </dl>
  
  </div>
	<div class="formBar">
	<ul>
		<li> 
			<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
		</li>
	</ul>
</div>
</div>
