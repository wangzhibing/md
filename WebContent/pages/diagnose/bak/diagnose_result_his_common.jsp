<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=basePath%>pages/symptomitem/js/symptomitem.js"></script>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">结果输出</th></tr>
			</thead>
		</table>
		<div class="pageFormContent" layoutH="76">
			<dl >
				<dt style="text-align: right;">诊断时间：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd>
			</dl>
			<dl >
				<dt style="text-align: right;">初诊/复诊：</dt>
				<dd><c:if test="${diagnoseResult.is_first_diagnose =='1'}">初诊</c:if> <c:if test="${diagnoseResult.is_first_diagnose =='2'}">复诊</c:if></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">姓名：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${customer.name }" /></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">性别：</dt>
				<dd><input readonly="true" name="field5" type="text" value="<c:if test="${diagnoseResult.sex=='1'}">男性</c:if><c:if test="${diagnoseResult.sex=='2'}">女性</c:if>" /></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">出生日期：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">主诉：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3" id="report">${diagnoseResult.report }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">病史与检查：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3"  id="medical_history">${diagnoseResult.medical_history }</textarea></dd>
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
			<dl>
				<dt style="text-align: right;">自诊结果：</dt>
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
				<dt style="text-align: right;">&nbsp;</dt>
				<dd style="color: red; font-weight: bold;">（用法及禁忌：3剂， 每日1剂 ，中火水煎 ，温服， 忌食生冷腥辣油腻） </dd>
			</dl>
			
		</div>
	</form>
</div>
