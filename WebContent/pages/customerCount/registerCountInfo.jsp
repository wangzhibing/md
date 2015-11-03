<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<script type="text/javascript" src="<%=basePath%>pages/customer/js/customerinfo.js"></script>
<div class="pageContent">
	<form method="post" action="<%=basePath%>md/customer/editCustomer.do" class="pageForm required-validate" onsubmit="return validateCallback(this);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">注册客户量</th></tr>
			</thead>
		</table>
		
		<div class="pageFormContent" layoutH="76">
		   
		   <table align="center">
		      <tr>
		         <td><dt style="text-align: right;">普通用户注册数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=1" 
		                    target="navTab" rel='registerCommonRel' title="普通用户注册数量">
					<font color="blue">${customerCount.registerCommonCount }</font></a></dd></td>
		      </tr>
		      <tr>
		         <td><dt style="text-align: right;">VIP用户注册数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=2" 
		         			target="navTab" rel='registerVipRel' title="VIP用户注册数量">
					<font color="blue">${customerCount.registerVipCount }</font></a></dd></td>
		      </tr>
		      <tr>
		         <td><dt style="text-align: right;">医生注册数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=10" 
		         			target="navTab" rel='registerExpertRel' title="医生注册数量">
					<font color="blue">${customerCount.registerExpertCount }</font></a></dd></td>
		      </tr>
		   </table>
		</div>
		
	</form>
</div>
