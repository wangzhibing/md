<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript" src="<%=basePath%>pages/diagnose/js/diagnoseManagerList.js"></script>
<c:import url="../pager/pagerForm.jsp"></c:import>
  <style type="text/css">
     .css1 {background-color: #a0a0a0;}
     .css2 {background-color: #0aa099;}
  </style>

<div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
	<form method="post" rel="pagerForm" action="<%=basePath%>md/diagnose/queryDiagnoseManagerData.do" onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td align="right">
						诊断日期起：
						<input type="text" name="diagnose_date_start"  class="date" value="${diagnose.diagnose_date_start }" readonly="readonly" id="diagnose_date_start"/>
					</td>
					<td align="right">
						至：
						<input type="text" name="diagnose_date_end"   class="date"  value="${diagnose.diagnose_date_end }" readonly="readonly"  id="diagnose_date_end"/>
					</td>
					<td align="right">
						诊断医生：
						<input type="text" name="doctor_name" id="doctor_name"  value="${diagnose.doctor_name }"/>
					</td> 
				</tr>
				<tr>
					<td align="right">
						客户名称：
						<input type="text" name="customer_name" id="customer_name" value="${diagnose.customer_name }"/>
					</td>
					<td align="right">
						登录名：
						<input type="text" name="login_name" id="login_name" value="${diagnose.login_name }"/>
					</td>
					<td>
					 <div class="subBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit" name="search">检索</button></div></div></li>
							<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="exportDiagnoseData()" name="search">导出</button></div></div></li> 
						    
						</ul>
					</div>
				</td>
			</table>
			 
		</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40">序列</th>
				<th width="80">客户名称</th>
				<th width="80">客户登录名</th>
				<th width="80">诊断医生</th>
				<th width="130">诊断时间</th>
				<th width="100">申请诊断状态</th>
				<th width="80">诊断主要症状</th>
				<th width="220">诊断一般症状</th>
				<th width="100">诊断结果</th>
				<th width="200">处方</th>
				<th width="100">备注</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${diagnoseList}" varStatus="s">
		    <tr target="slt_objId" rel="${item.diagnse_result_id }" >
				<td>${s.index + 1}</td>
				<td>${item.customer_name}</td>
				<td>${item.login_name}</td>
				<td>${item.doctor_name}</td>
				<td>${item.diagnose_date}:${item.diagnose_time}</td>
				<td>
				  <c:if test="${item.apply_reply_status == '1'}">未申请专家确诊</c:if>
				  <c:if test="${item.apply_reply_status == '2'}">已申请专家确诊</c:if>
				  <c:if test="${item.apply_reply_status == '3'}">专家已确诊</c:if>
				
				</td>
				
				<td>${item.main_sysptom}</td>
				<td>${item.less_sysptom}</td>
				<td>${item.in_bw_first_name}${item.in_by_first_name}<c:if test="${item.in_by_second_name != ''}">且${item.in_by_second_name }</c:if></td>
				<td>${item.prescription2_medicinal}</td>
				<td>${item.remark1}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>

