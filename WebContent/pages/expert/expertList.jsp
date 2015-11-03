<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
<script type="text/javascript" src="<%=basePath%>pages/expert/js/expertList.js"></script>

<div class="pageContent">
	<table class="table" width="100%"   layoutH="50">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">专家名称</th>
				<th width="120">是否在线</th>
				<th width="120"></th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${expertInfoList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.name}</td>
				<td><c:if test="${item.is_on_line==1}">线上</c:if><c:if test="${item.is_on_line != 1}">线下</c:if></td>
			    <td><a href="#" onclick="contactExpert(${diagnoseId },${item.id })"><font color="red">联系他(她)</font></a></td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
