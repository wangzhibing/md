<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<div class="pageContent">
<form method="post" rel="pagerForm" action="<%=basePath%>md/customerCount/queryRegisterOnlineCustomerInfo.do?customer_type=1&is_on_line=1"  onsubmit="return navTabSearch(this)">
</form>
	<table class="table" width="100%" layoutH="72">
		<thead>
			<tr>
				<th width="40"></th>
				<th width="80">客户编号</th>
				<th width="120">客户名称</th>
				<th width="120">客户登录名</th>
				<th width="100">客户级别</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${registerOnlineCustomerList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.login_name}</td>
				<%--<td>${item.customer_type}</td>
				    <td>${item.customer_status}</td> --%>
				<td>
				    <c:if test="${item.customer_type == '1'}">普通用户</c:if>
				    <c:if test="${item.customer_type == '2'}">VIP用户</c:if>
				    <c:if test="${item.customer_type == '10'}">医生</c:if></td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
