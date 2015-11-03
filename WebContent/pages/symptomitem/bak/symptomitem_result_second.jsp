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
				<dt style="text-align: right;">诊断时间：</dt>
				<%-- <dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd> --%>
				<dd>${diagnoseResult.diagnose_result_date }&nbsp;${diagnoseResult.diagnose_result_time }</dd>
			</dl>
			<dl >
				<dt style="text-align: right;">初诊/复诊：</dt>
				<dd><c:if test="${diagnoseResult.is_first_diagnose =='1'}">初诊</c:if> <c:if test="${diagnoseResult.is_first_diagnose =='2'}">复诊</c:if></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">姓名：</dt>
				<%-- <dd><input readonly="true" name="field5" type="text" value="${customer.name }" /></dd> --%>
				<dd>${customer.name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">性别：</dt>
				<%-- <dd><input readonly="true" name="field5" type="text" value="<c:if test="${diagnoseResult.sex=='1'}">男性</c:if><c:if test="${diagnoseResult.sex=='2'}">女性</c:if>" /></dd> --%>
			    <dd><c:if test="${diagnoseResult.sex=='1'}">男性</c:if><c:if test="${diagnoseResult.sex=='2'}">女性</c:if></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">出生日期：</dt>
				<%-- <dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.diagnose_result_date }" /></dd> --%>
				<dd>${diagnoseResult.diagnose_result_date }</dd>
			</dl>
			
			<dl class="nowrap">
				<dt style="text-align: right;">主诉：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3">${diagnoseResult.report }</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">病史与检查：</dt>
				<dd><textarea name="textarea4" cols="80" rows="3">${diagnoseResult.medical_history }</textarea></dd>
			</dl>
			
			<div class="divider"></div>
			<dl class="nowrap">
				<dt style="text-align: right;">症状（望闻问切）：</dt>
				<%-- <dd><textarea name="textarea4" readonly="true" cols="80" rows="1">${diagnoseResult.lessSymptomValue }</textarea></dd> --%>
				<dd>${diagnoseResult.lessSymptomValue } </dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">主要症状：</dt>
				<%-- <dt><input readonly="true" name="field5" type="text" value="${diagnoseResult.symptom_prescription_name }" /></dt> --%>
				<dt>${diagnoseResult.symptom_prescription_name }</dt>
			</dl>
			
			<%-- <dl class="nowrap">
				<dt style="text-align: right;">中医自诊结果：</dt>
				<dd><input readonly="true" name="field5" type="text" value="${diagnoseResult.in_bw_first_code },${diagnoseResult.in_bw_first_name },${diagnoseResult.in_bw_first_value }"/></dd>
			    <dd>${diagnoseResult.in_bw_first_name }${diagnoseResult.in_by_first_name }且${diagnoseResult.in_by_second_name }</dd>
			    <dd>${diagnoseResult.in_bw_first_name }${diagnoseResult.in_by_first_name }<c:if test="${diagnoseResult.in_by_second_name != ''}">且${diagnoseResult.in_by_second_name }</c:if></dd>
			</dl> --%>
			
			<dl>
				<dt style="text-align: right;">内病位第一位：</dt>
				<dd>${diagnoseResult.in_bw_first_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">内病位第二位：</dt>
				<dd>${diagnoseResult.in_bw_second_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">内病因第一位：</dt>
				<dd>${diagnoseResult.in_by_first_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">内病因第二位：</dt>
				<dd>${diagnoseResult.in_by_second_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">（外）病位：</dt>
				<dd>${diagnoseResult.out_bw_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">（外）病因：</dt>
				<dd>${diagnoseResult.out_by_name }</dd>
			</dl>
			
			
			<div class="divider"></div>
			<dl class="nowrap">
				<dt style="text-align: right;">处方：</dt>
				<%-- <dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription2_medicinal }</textarea></dd> --%>
				<dd>${diagnoseResult.prescription2_medicinal } </dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">&nbsp;</dt>
				<dd style="color: red;">（用法及禁忌：3剂， 每日1剂 ，中火水煎 ，温服， 忌食生冷腥辣油腻） </dd>
			</dl>
			
					
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li>
				    <div class="buttonActive"><div class="buttonContent"><button type="button">专家确诊</button></div></div></li>
				<!-- <li><div class="buttonActive"><div class="buttonContent"><button type="submit">打印</button></div></div></li> -->
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
