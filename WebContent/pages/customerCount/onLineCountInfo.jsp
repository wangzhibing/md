<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<script type="text/javascript" src="<%=basePath%>pages/customer/js/customerinfo.js"></script>
<div class="pageContent">
	<form method="post" action="<%=basePath%>md/customer/editCustomer.do" class="pageForm required-validate" onsubmit="return validateCallback(this);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">在线客户量</th></tr>
			</thead>
		</table>
		
		<div class="pageFormContent" layoutH="76">
		   
		   <table align="center">
		   
		      <%-- <tr>
		         <td><dt style="text-align: right;">匿名用户在线数量：</dt></td>
		         <td><dd>${customerCount.onLineAnonymousCount }</dd></td>
		      </tr> --%>
		      <tr>
		         <td><dt style="text-align: right;">普通用户在线数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=1&is_on_line=1" 
		                    target="navTab" rel='onLineCommonRel' title="普通用户在线数量">
					<font color="blue">${customerCount.onLineCommonCount }</font></a></dd></td>
		      </tr>
		      <tr>
		         <td><dt style="text-align: right;">VIP用户在线数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=2&is_on_line=1" 
		         			target="navTab" rel='onLineVipRel' title="VIP用户在线数量">
					<font color="blue">${customerCount.onLineVipCount }</font></a></dd></td>
		      </tr>
		      <tr>
		         <td><dt style="text-align: right;">医生在线数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=10&is_on_line=1" 
		         			target="navTab" rel='onLineExpertRel' title="医生在线数量">
					<font color="blue">${customerCount.onLineExpertCount }</font></a></dd></td>
		      </tr>
		      <tr>
		         <td><dt style="text-align: right;">管理员在线数量：</dt></td>
		         <td><dd><a href="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=3&is_on_line=1" 
		         			target="navTab" rel='onLineManagerRel' title="医生在线数量">
					<font color="blue">${customerCount.onLineManagerCount }</font></a></dd></td>
		      </tr>
		      <tr height="15">
		      </tr>
		      <tr>
		         <td><dt style="text-align: right;">在线用户合计：</dt></td>
		         <td><dd>
					<font color="blue">${customerCount.onLineCount }</font></dd>
				</td>
		      </tr>
		   </table>
		</div>
		
	</form>
</div>
