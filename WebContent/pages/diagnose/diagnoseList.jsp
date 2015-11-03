<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
  <style type="text/css">
     .css1 {background-color: #a0a0a0;}
     .css2 {background-color: #0aa099;}
  </style>

<div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
	<form method="post" rel="pagerForm" action="<%=basePath%>md/diagnose/queryDiagnoseData.do" onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
					<td>
						诊断日期起：
						<input type="text" name="diagnose_date_start" value="${diagnose.diagnose_date_start }"  class="date" readonly="readonly" id="diagnose_date_start"/>
					</td>
					<td>
						至：
						<input type="text" name="diagnose_date_end"  value="${diagnose.diagnose_date_end }"  class="date" readonly="readonly"  id="diagnose_date_end"/>
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
	<li hidden="hide" style="display: none;"><a class="icon" href="<%=basePath%>/md/symptomItemValue/doSymptomItemJspHis.do?diagnoseResultId={slt_objId}&viewType=1"  target="navTab" rel="diagnose_result_his_rel" id="diagnose_result_his_rel_id" mask="true"><span>历史诊断详情</span></a></li>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40">序列</th>
				<th width="80">客户名称</th>
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
		    <c:if test="${item.apply_reply_status == '3' &&  item.is_look =='1' }">
		    <tr style="cursor: pointer;background: blue;" target="slt_objId" rel="${item.diagnse_result_id }" >
				<td>${s.index + 1}</td>
				<td>${item.customer_name}</td>
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
		    </c:if>
		    
		   <c:if test="${item.apply_reply_status != '3' || item.is_look != '1'}">
		    <tr style="cursor: pointer;"  target="slt_objId" rel="${item.diagnse_result_id }" >
				<td>${s.index + 1}</td>
				<td>${item.customer_name}</td>
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
		    </c:if>
			
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>

<script type="text/javascript" >
function dbltable(target,rel){
	if( target == 'slt_objId'){
		var diagnose_result_his_rel_a = document.getElementById("diagnose_result_his_rel_id");
		diagnose_result_his_rel_a.click();
	}
}

 function mouseOver(obj){
    if(obj.className="css1")
       obj.className="css2";
 }
 
 //onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
 
 function mouseOut(obj){
    if(obj.className="css2")
       obj.className="css1";
 }
</script>
