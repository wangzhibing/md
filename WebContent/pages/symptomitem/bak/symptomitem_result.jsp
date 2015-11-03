<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">结果输出</th></tr>
			</thead>
		</table>
		<div class="pageFormContent" layoutH="76">
			<dl >
				<dt>诊断时间：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd>
			</dl>
			<dl >
				<dt>初诊/复诊：</dt>
				<dd><c:if test="${diagnoseResult.is_first_diagnose =='1'}">初诊</c:if> <c:if test="${diagnoseResult.is_first_diagnose =='2'}">复诊</c:if></dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${customer.name }" /></dd>
			</dl>
			<dl>
				<dt>性别：</dt>
				<dd><input readonly="true" name="field5" type="text" value="<c:if test="${diagnoseResult.sex=='1'}">男性</c:if><c:if test="${diagnoseResult.sex=='2'}">女性</c:if>" /></dd>
			</dl>
			<dl>
				<dt>出生日期：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd>
			</dl>
			<dl class="nowrap">
				<dt>主诉：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3"></textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>病史与检查：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3"></textarea></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>症状（望闻问切）：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="1">${diagnoseResult.lessSymptomValue }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>主要症状：</dt>
				<dt><input readonly="true" name="field5" type="text" value="${diagnoseResult.symptom_prescription_name }" /></dt>
			</dl>
			<dl>
				<dt>自诊结果：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_bw_first_code },${diagnoseResult.in_bw_first_name },${diagnoseResult.in_bw_first_value }"/></dd>
			</dl>
			<dl>
				<dt>内病位第二位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_bw_second_code },${diagnoseResult.in_bw_second_name },${diagnoseResult.in_bw_second_value }"/></dd>
			</dl>
			<dl>
				<dt>内病因第一位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_by_first_code },${diagnoseResult.in_by_first_name },${diagnoseResult.in_by_first_value }"/></dd>
			</dl>
			<dl>
				<dt>内病因第二位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_by_second_code },${diagnoseResult.in_by_second_name },${diagnoseResult.in_by_second_value }"/></dd>
			</dl>
			<dl>
				<dt>（外）病位：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.out_bw_code },${diagnoseResult.out_bw_name },${diagnoseResult.out_bw_value }" /></dd>
			</dl>
			<dl>
				<dt>（外）病因：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.out_by_code },${diagnoseResult.out_by_name },${diagnoseResult.out_by_value }" /></dd>
			</dl>
			
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>处方1：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription1_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>处方2：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription2_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>处方3：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription3_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>处方4：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription4_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>AC：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.ac_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>AD：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.ad_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>BC：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.bc_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>BD：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.bd_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>EF：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.ef_medicinal }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>G：</dt>
				<dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.g_medicinal }</textarea></dd>
			</dl>
			
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">打印</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
