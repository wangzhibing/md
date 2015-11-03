<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
				<dd>${diagnoseResult.diagnose_result_date }&nbsp;${diagnoseResult.diagnose_result_time }</dd>
			</dl>
			<dl >
				<dt style="text-align: right;">初诊/复诊：</dt>
				<dd><c:if test="${diagnoseResult.is_first_diagnose =='1'}">初诊</c:if> <c:if test="${diagnoseResult.is_first_diagnose =='2'}">复诊</c:if></dd>
			</dl>
			
			
			<dl>
				<dt style="text-align: right;">登录人姓名：</dt>
				<dd>${customer.name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">病人姓名：</dt>
			    <dd><dd><input name="sick_name" id="sick_name" type="text"  /></dd></dd>
			</dl>
			
			
			<dl>
				<dt style="text-align: right;">病人性别：</dt>
			    <dd><c:if test="${diagnoseResult.sex=='1'}">男性</c:if><c:if test="${diagnoseResult.sex=='2'}">女性</c:if></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">病人年龄：</dt>
				<dd><input name="sick_age" id="sick_age" type="text"  /></dd>
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
				<dt style="text-align: right;">输入的症状：</dt>
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
				<dt style="text-align: right;">（内）病位：</dt>
				<dd>${diagnoseResult.in_bw_first_name }，${diagnoseResult.in_bw_second_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">（外）病位：</dt>
				<dd>${diagnoseResult.out_bw_name }</dd>
			</dl>
			
			<dl>
				<dt style="text-align: right;">（内）病因：</dt>
				<dd>${diagnoseResult.in_by_first_name }，${diagnoseResult.in_by_second_name }</dd>
			</dl>
			<dl>
				<dt style="text-align: right;">（外）病因：</dt>
				<dd>${diagnoseResult.out_by_name }</dd>
			</dl>
			
		<%-- 	<dl>
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
			</dl> --%>
			
			<div class="divider"></div>
			<%-- <dl class="nowrap">
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
			</dl> --%>
			<dl class="nowrap">
				<dt style="text-align: right;">处方：</dt>
				<dd>${diagnoseResult.prescription5_medicinal }</dd>
				<%-- <dd><textarea name="textarea4" readonly="true" cols="80" rows="2">${diagnoseResult.prescription5_medicinal }</textarea></dd> --%>
			</dl>
			
			<dl class="nowrap">
				<dt style="text-align: right;">&nbsp;</dt>
				<dd style="color: red; font-weight: bold;">（用法及禁忌：3剂， 每日1剂 ，中火水煎 ，温服， 忌食生冷腥辣油腻） </dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">&nbsp;</dt>
				<dd style="color: red; font-weight: bold;">鉴于您选择的症状准确度和既往病史等因素，本结果仅供参考，要得到更准确的诊断及处方，最好填写好主诉和病史，请医生确认</dd>
			</dl>
					
		</div>
		<div class="formBar">
			<ul style="float:none;margin-left: 120px;">
				<li hidden="hide" style="display: none;"><a class="button" id="expertDiagnoiseId_pay" href="<%=basePath%>md/expert/queryExpertInfoList.do?diagnoseId=${diagnoseResult.diagnose_id }"  target="dialog" rel="expert_medicinal_rel" width="380" height="320" mask="true" title="专家确诊"><span>专家确诊</span></a></li>				<!-- <li><div class="buttonActive"><div class="buttonContent"><button type="submit">打印</button></div></div></li> -->
				<li><a class="button" onclick=valid_expert_medicinal_pay(${diagnoseResult.diagnose_id });
			          title="专家确诊"><span>专家确诊</span></a></li>
			</ul>
		</div>
	</form>
</div>
