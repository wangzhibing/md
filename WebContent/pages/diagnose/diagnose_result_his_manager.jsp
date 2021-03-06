<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=basePath%>pages/symptomitem/js/symptomitem.js"></script>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">中医系统的处方表格标准式样</th></tr>
			</thead>
		</table>
		<div class="pageFormContent" layoutH="76">
			
			<dl class="nowrap">
				<dt style="text-align: right;">诊断时间：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">主诉：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3" id="report">${diagnoseResult.report }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">病史与检查：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3" id="medical_history">${diagnoseResult.medical_history }</textarea></dd>
			</dl>
			
			<div class="divider"></div>
			<dl class="nowrap">
				<dt style="text-align: right;">症状（望闻问切）：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="1">${diagnoseResult.lessSymptomValue }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">主要症状：</dt>
				<dt><input readonly="true" name="field5" type="text" value="${diagnoseResult.symptom_prescription_name }" /></dt>
			</dl>
			
			<div class="divider"></div>
			<dl>
				<dt style="text-align: right;">内病位第一位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_bw_first_code },${diagnoseResult.in_bw_first_name },${diagnoseResult.in_bw_first_value }"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">内病位第二位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_bw_second_code },${diagnoseResult.in_bw_second_name },${diagnoseResult.in_bw_second_value }"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">内病因第一位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_by_first_code },${diagnoseResult.in_by_first_name },${diagnoseResult.in_by_first_value }"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">内病因第二位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_by_second_code },${diagnoseResult.in_by_second_name },${diagnoseResult.in_by_second_value }"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">（外）病位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.out_bw_code },${diagnoseResult.out_bw_name },${diagnoseResult.out_bw_value }" /></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">（外）病因：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.out_by_code },${diagnoseResult.out_by_name },${diagnoseResult.out_by_value }" /></dd>
			</dl>
			
			<div class="divider"></div>
			<dl class="nowrap">
				<dt style="text-align: right;">处方1：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription1_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">处方2：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription2_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">处方3：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription3_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">处方4：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription4_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">处方5：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription5_medicinal }</textarea></dd>
			</dl>
			
			<c:if test="${diagnose.apply_reply_status =='3'}">
			
			<dl class="nowrap">
				<dt style="text-align: right;">医生确诊处方：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription6_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">医生签名：</dt>
				<dd><img src="<%=basePath%>images/expert/${doctor_sign_name }" /></dd>
			</dl>
			</c:if> 
			
			<dl class="nowrap">
				<dt style="text-align: right;">&nbsp;</dt>
				<dd style="color: red;">（用法及禁忌：3剂， 每日1剂 ，中火水煎 ，温服， 忌食生冷腥辣油腻） </dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">AC：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.ac_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">AD：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.ad_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">BC：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.bc_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">BD：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.bd_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">EF：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.ef_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">G：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.g_medicinal }</textarea></dd>
			</dl>
			
		</div>
		
	</form>
</div>
