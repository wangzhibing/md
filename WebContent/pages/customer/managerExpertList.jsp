<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
<div class="pageContent">
    <div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
<form method="post" rel="pagerForm" action="<%=basePath%>md/customer/queryManagerExpertInfo.do"  onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td align="right">
						管理员/医生名称：
					</td>
					<td align="left">
						<input type="text" name="name"  value="${customer.name }" id="name"/>
					</td>
					
					<td align="right">
						客户类型：
						</td>
					<td align="left">
						<select name="customer_type" class="required combox" >
						    <c:if test="${customer.customer_type =='3' }">
						        <option value="" >全部</option>
								<option value="3" selected>普通管理员</option>
								<option value="10" >医生专家</option>
						    </c:if>
						    
						    <c:if test="${customer.customer_type =='10' }">
						        <option value="" >全部</option>
								<option value="3" >普通管理员</option>
								<option value="10" selected>医生专家</option>
						    </c:if>
						    
						    <c:if test="${customer.customer_type == null || customer.customer_type == '' }">
						        <option value="" selected>全部</option>
								<option value="3" >普通管理员</option>
								<option value="10" >医生专家</option>
						    </c:if>
							
						</select>
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
	<div class="panelBar">
		<ul class="toolBar">
			<%--  动态密码验证
			<li><a class="add" href="<%=basePath%>md/customer/appliedManager.do?customerId={slt_objId}" target="ajaxTodo" title="确定要关联吗?"><span>关联令牌</span></a></li>
		    <li><a class="delete" href="<%=basePath%>md/customer/deleteApplyManager.do?customerId={slt_objId}"  target="ajaxTodo" title="确定要删除吗?" ><span>拒绝审批</span></a></li>
		    --%>
		    <li><a class="add" href="<%=basePath%>md/customer/lowerManagerExpert.do?customerId={slt_objId}" target="ajaxTodo" title="确定要降级吗?"><span>降级</span></a></li>		    
 			<li><a class="delete" href="<%=basePath%>md/customer/deleteCustomer.do?customerId={slt_objId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40"></th>
				<th width="80">管理员/医生编号</th>
				<th width="120">管理员/医生名称</th>
				<th width="120">管理员/医生登录名</th>
				<th width="100">管理员/医生类别</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${managerExpertList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.login_name}</td>
				<td>
				    <c:if test="${item.customer_type == '3'}">普通管理员</c:if>
				    <c:if test="${item.customer_type == '10'}">医生</c:if></td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
