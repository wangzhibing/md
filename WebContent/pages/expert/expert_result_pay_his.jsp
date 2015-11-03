<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>pages/expert/js/expert_result_pay.js"></script>

<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">结果输出</th></tr>
			</thead>
		</table>
		<div class="pageFormContent" layoutH="76">
			
			 <table>
			    <tr height="30">
	               <td><dt style="text-align: right;">诊断时间：</dt></td>	  
	               <td><dd>${diagnoseResult.diagnose_result_date }&nbsp;${diagnoseResult.diagnose_result_time }</dd></td>
	               <td><dt style="text-align: right;">初诊/复诊：</dt></td>
	               <td><dd><c:if test="${diagnoseResult.is_first_diagnose =='1'}">初诊</c:if> 
	                	   <c:if test="${diagnoseResult.is_first_diagnose =='2'}">复诊</c:if></dd></td>  
			    </tr>
			    
			    <tr height="30">
			       <td><dt style="text-align: right;">登录人姓名：</dt></td>
			       <td><dd>${customer.name }</dd></td>
			       <td><dt style="text-align: right;">病人姓名：</dt></td>
			       <td><dd>${diagnoseResult.sick_name }</dd></td>
			    </tr>
			    
			     <tr height="30">
			       <td><dt style="text-align: right;">病人性别：</dt></td>
			       <td><dd><c:if test="${diagnoseResult.sex=='1'}">男性</c:if><c:if test="${diagnoseResult.sex=='2'}">女性</c:if></dd></td>
			       <td><dt style="text-align: right;">病人年龄：</dt></td>
			       <td><dd>${diagnoseResult.sick_age }</dd></td>
			    </tr>
			    
			     <tr height="60">
			       <td valign="top"><dt style="text-align: right;" >主诉：</dt></td>
				   <td colspan="3"><dd><textarea name="textarea4" cols="77" rows="3" maxlength="150" id="report">${diagnoseResult.report }</textarea></dd></td>
			    </tr>
			    
			    <tr height="60">
					<td valign="top"><dt style="text-align: right;">病史与检查：</dt></td>
				    <td colspan="3"><dd><textarea name="textarea4" cols="77" rows="3" maxlength="150" id="medical_history">${diagnoseResult.medical_history }</textarea></dd></td>
			    </tr> 
			    
			    <tr height="30">
					<td><dt style="text-align: right;">输入的症状：</dt></td>
					<td colspan="3">${diagnoseResult.lessSymptomValue } </td>
			    </tr>
			    
			    <tr height="30">
					<td><dt style="text-align: right;">主要症状：</dt></td>
					<td colspan="3">${diagnoseResult.symptom_prescription_name }</td>
			    </tr> 
			    
			    <tr height="30">
					<td><dt style="text-align: right;">（内）病位：</dt></td>
					<td><dd>${diagnoseResult.in_bw_first_name }，${diagnoseResult.in_bw_second_name }</dd></td>
					<td colspan="2" align="left">（外）病位：${diagnoseResult.out_bw_name }</td>
				</tr>
			
				<tr height="30">
					<td><dt style="text-align: right;">（内）病因：</dt></td>
					<td><dd>${diagnoseResult.in_by_first_name }，${diagnoseResult.in_by_second_name }</dd></td>
					<td colspan="2" align="left">（外）病因：${diagnoseResult.out_by_name }</td>
				</tr>  
				
				<tr height="30">
				    <td><dt style="text-align: right;">原始处方：</dt></td>
					<td colspan="3">${diagnoseResult.prescription5_medicinal }</td>
			    </tr>
			    
			    <tr height="30">
				    <td><dt style="text-align: right;">医生确诊处方：</dt></td>
					<td colspan="3">${diagnoseResult.prescription6_medicinal }</td>
			    </tr>
			    
			    <tr height="30">
				    <td><dt style="text-align: right;">医生签名：</dt></td>
					<td colspan="3"><img src="<%=basePath%>images/expert/${doctor_sign_name }" /></td>
			    </tr>
			    
			    <tr height="30">
				    <td><dt style="text-align: right;">&nbsp;</dt></td>
					<td colspan="3" style="color: red; font-weight: bold;">（用法及禁忌：3剂， 每日1剂 ，中火水煎 ，温服， 忌食生冷腥辣油腻） </td>
			    </tr>
		    </table>
			
			
		</div>
		
	</form>
</div>
