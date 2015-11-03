<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
<div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
	<form method="post" rel="pagerForm" action="<%=basePath%>md/customerApplyinfo/querycustomerApplyinfoData.do" onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td>
						升级操作日期起：
						<input type="text" name="deal_date_start"  value="${customerApplyinfo.deal_date_start }" class="date" readonly="readonly" id="deal_date_start"/>
					</td>
					<td>
						至：
						<input type="text" name="deal_date_end"  value="${customerApplyinfo.deal_date_end }" class="date" readonly="readonly"  id="deal_date_end"/>
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
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40">序列</th>
				<th width="130">升级用户</th>
				<th width="130">操作管理员</th>
				<th width="80">操作方向</th>
				<th width="80">操作前升级状态</th>
				<th width="80">操作后升级状态</th>
				<th width="80">操作时间</th>
				<th width="220">操作理由</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${customerApplyinfoList}" varStatus="s">
		   
		    
		    <tr style="cursor: pointer;"  target="slt_objId"  >
				<td>${s.index + 1}</td>
				<td>${item.customer_id}_${item.customer_name}</td>
				<td>${item.manager_customer_id}_${item.manager_customer_name}</td>
				<td>
				  <c:if test="${item.deal_action == '1'}">普通用户升级申请</c:if>
				  <c:if test="${item.deal_action == '2'}">普通用户升级审批</c:if>
				  <c:if test="${item.deal_action == '3'}">普通用户升级拒绝</c:if>
				  <c:if test="${item.deal_action == '4'}">普通用户升级确认</c:if>
				  <c:if test="${item.deal_action == '5'}">VIP用户降级确认</c:if>
				</td>
				<td>
				  <c:if test="${item.deal_status_before == '1'}">初始</c:if>
				  <c:if test="${item.deal_status_before == '2'}">待审批</c:if>
				  <c:if test="${item.deal_status_before == '3'}">已审批</c:if>
				</td>
				<td>
				  <c:if test="${item.deal_status_after == '1'}">初始</c:if>
				  <c:if test="${item.deal_status_after == '2'}">待审批</c:if>
				  <c:if test="${item.deal_status_after == '3'}">已审批</c:if>
				</td>
				
				<td>${item.deal_date}:${item.deal_time}</td>
				<td>${item.remark}</td>
			</tr>
			
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
