<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>


<div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
	<form method="post" rel="pagerForm" action="<%=basePath%>md/medicinal/queryMedicinalData.do" onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td>
						查询关键字：
						<input type="text" name="queryValue"  value="${vo.queryValue}" id="queryValue"/>
					</td>
					<td>
					<div class="subBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit" name="search">检索</button></div></div></li> 
						</ul>
					</div>
				</td>
				</tr>
			</table>
			 
		</div>
	</form>
</div>
<div class="pageContent">
	<%-- <div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="<%=basePath%>md/medicinal/queryMedicinalById.do?id={slt_objId}" target="dialog" rel="dlg_page11" mask="true"><span>药材详情</span></a></li>
		</ul>
	</div> --%>
	
	<li hidden="hide" style="display: none;">
		<a class="icon" href="<%=basePath%>md/medicinal/queryMedicinalById.do?id={slt_objId}" 
			target="dialog" rel="medicinalDetailRel" id="medicinalDetailRel_id" mask="true"><span>药材详情</span></a></li>	
	</li>
	
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40"></th>
				<th width="60">药材简写</th>
				<th width="60">药材名称</th>
				<th width="60">药材类型</th>
				<th width="120">性味</th>
				<th width="120">药材功能</th>
				<th width="120">主治</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${medicinalList}" varStatus="s">
			<tr target="slt_objId" style="cursor: pointer;" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.code}</td>
				<td>${item.name}</td>
				<td>${item.type}</td>
				<td>${item.smell}</td>
				<td>${item.function}</td>
				<td>${item.main_cure}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
<script type="text/javascript" >
function dbltable(target,rel){
	if( target == 'slt_objId'){
		var medicinalDetailRel_a = document.getElementById("medicinalDetailRel_id");
		medicinalDetailRel_a.click();
	}
}
</script>