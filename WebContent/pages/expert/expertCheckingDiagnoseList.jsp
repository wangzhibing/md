<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>


<div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
	<form method="post" rel="pagerForm" action="<%=basePath%>md/expert/queryExpertCheckingDiagnoseData.do" onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td>
						诊断日期起：
						<input type="text" name="diagnose_date_start"  class="date" readonly="readonly" id="diagnose_date_start"/>
					</td>
					<td>
						至：
						<input type="text" name="diagnose_date_end"   class="date" readonly="readonly"  id="diagnose_date_end"/>
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
		
	<li hidden="hide" style="display: none;"><a class="icon" href="<%=basePath%>/md/symptomItemValue/doSymptomItemJspExpert.do?diagnoseResultId={slt_objId}&viewType=1"  target="navTab" rel="waitingDiagnoseRel" id="waitingDiagnoseRel_id" mask="true"><span>病例诊断详情</span></a></li>

	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="80">诊断病例号</th>
				<th width="80">客户名称</th>
				<th width="80">诊断时间</th>
				<th width="80">诊断主要症状</th>
				<th width="220">诊断一般症状</th>
				<th width="100">诊断结果</th>
				<th width="200">处方</th>
				<th width="100">备注</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${expertCheckingDiagnoseList}" varStatus="s">
			<tr  style="cursor: pointer;" target="slt_objId" rel="${item.diagnse_result_id }">
				<td>${item.id}</td>
				<td>${item.customer_name}</td>
				<td>${item.diagnose_date}</td>
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

<script type="text/javascript" >
function dbltable(target,rel){
	if( target == 'slt_objId'){
		var waitingDiagnoseRel_a = document.getElementById("waitingDiagnoseRel_id");
		waitingDiagnoseRel_a.click();
	}
}
</script>
