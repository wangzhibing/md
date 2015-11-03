<%@page import="com.md.entity.User"%>
<%@ include file="/include.inc.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>


<form method="post" rel="pagerForm" action="<c:url value='md/user/queryUserListInfoPage.do'/>" onsubmit="return navTabSearch(this)">
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="userNav" href="md/user/jspAddUser.do"><span>添加</span></a></li>
			<li><a class="delete" href="md/user/delUser.do?id={slt_objId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" target="navTab" rel="userNav" href="md/user/jspEditUser.do?id={slt_objId}"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80"></th>
				<th width="120">客户号</th>
				<th width="120">客户名称</th>
				<th width="120">电话</th>
				<th width="120">地址</th>
				<th width="120">账号</th>
				<th width="120">备注</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${userList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.phone}</td>
				<td>${item.address}</td>
				<td>${item.accountNo}</td>
				<td>${item.rmk}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
