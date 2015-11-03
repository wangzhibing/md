<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
<div class="pageContent">
    <div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
<form method="post" rel="pagerForm" action="<%=basePath%>md/customer/queryApplyCustomerInfo.do"  onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td align="right">
						客户名称：
					</td>
					<td align="left">
						<input type="text" name="name"  value="${customer.name }" id="name"/>
					</td>
					
					<td align="right">
						客户类型：
						</td>
					<td align="left">
						<select name="customer_type" class="required combox">
						    <c:if test="${customer.customer_type =='1' }">
						        <option value="" >全部</option>
								<option value="1" selected >普通用户</option>
								<option value="2">VIP用户</option>
						    </c:if>
						    
						     <c:if test="${customer.customer_type =='2' }">
						        <option value="" >全部</option>
								<option value="1">普通用户</option>
								<option value="2" selected >VIP用户</option>
						    </c:if>
						    
						    <c:if test="${customer.customer_type == null || customer.customer_type == '' }">
						        <option value="" selected>全部</option>
								<option value="1" >普通用户</option>
								<option value="2">VIP用户</option>
						    </c:if>
						</select>
					</td>
					<td align="right">
						升级申请状态：
						</td>
					<td align="left">
						<select name="apply_status" class="required combox">
							 <c:if test="${customer.apply_status =='1' }">
						        <option value="" >全部</option>
								<option value="1" selected  >初始</option>
								<option value="2">待审批</option>
								<option value="3">已审批</option>
						    </c:if>
						    
						     <c:if test="${customer.apply_status =='2' }">
						        <option value="" >全部</option>
								<option value="1">初始</option>
								<option value="2" selected >待审批</option>
								<option value="3">已审批</option>
						    </c:if>
						    
						    <c:if test="${customer.apply_status =='3' }">
						        <option value="" >全部</option>
								<option value="1">初始</option>
								<option value="2">待审批</option>
								<option value="3" selected>已审批</option>
						    </c:if>
						    
						    <c:if test="${customer.apply_status == null || customer.apply_status == '' }">
						        <option value="" selected>全部</option>
								<option value="1">初始</option>
								<option value="2">待审批</option>
								<option value="3">已审批</option>
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
 			<li><a class="add" href="<%=basePath%>md/customer/appliedManagerCommon.do?customerId={slt_objId}" target="ajaxTodo" title="确定要审批/升级吗?"><span>确认审批/升级</span></a></li>
		    <li><a class="delete" href="<%=basePath%>md/customer/refuseApplyManagerCommon.do?customerId={slt_objId}"  target="ajaxTodo" title="确定要拒绝审批吗?" ><span>拒绝审批</span></a></li>
		    <li><a class="delete" href="<%=basePath%>md/customer/lowerAppliedApplyManagerCommon.do?customerId={slt_objId}"  target="ajaxTodo" title="确定要降级吗?" ><span>确认降级</span></a></li>
		
			<c:if test="${loginCustomer.customer_type == '4'}"> 
		    <li><a class="add" href="<%=basePath%>md/customer/upManager.do?customerId={slt_objId}"  target="ajaxTodo" title="确定要升级普通管理员吗?" ><span>升级普通管理员</span></a></li>
		    <li><a class="add" href="<%=basePath%>md/customer/upExpert.do?customerId={slt_objId}"  target="ajaxTodo" title="确定要升医生吗?" ><span>升级医生</span></a></li>
			</c:if>
		
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40"></th>
				<th width="80">客户编号</th>
				<th width="120">客户名称</th>
				<th width="120">客户登录名</th>
				<th width="100">客户级别</th>
				<th width="100">申请状态</th>
				<th width="100">申请时间</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${applyCustomerList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.login_name}</td>
				<%--<td>${item.customer_type}</td>
				    <td>${item.customer_status}</td> --%>
				<td>
				    <c:if test="${item.customer_type == '1'}">普通用户</c:if>
				    <c:if test="${item.customer_type == '2'}">VIP用户</c:if></td>
				<td>
					<c:if test="${item.apply_status == '1'}">初始</c:if>
				    <c:if test="${item.apply_status == '2'}">待审批</c:if>
				    <c:if test="${item.apply_status == '3'}">已审批</c:if>
				</td>
				<td>${item.apply_time}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
