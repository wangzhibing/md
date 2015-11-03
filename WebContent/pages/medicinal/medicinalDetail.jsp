<%@ page pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>

<div class="pageContent" layoutH="22">
<%-- 	<div
		style="width: 48%; border: 0px; margin: 5px; float: left; min-height: 100px">
		<img alt="ssss" src="./${medicinal.filepath1 }">
	</div>

	<div
		style="width: 48%; border: 0px; margin: 5px; float: left; min-height: 100px">
		<div style="padding: 5px; margin: 5px">
			<label>药材简写： </label> <label>${medicinal.code }</label>
		</div>
		<div style="padding: 5px; margin: 5px">
			<label>药材名称： </label> <label>${medicinal.name }</label>
		</div>
		<div style="padding: 5px; margin: 5px">
			<label>药材类型： </label> <label>${medicinal.type }</label>
		</div>
		<div style="padding: 5px; margin: 5px">
			<label>药材功能： </label> 
			<span style="line-height: 19px;">${medicinal.function }</span>
		</div>
	</div> --%>
	
	<table border="0">
			<tr>
				<td rowspan="4" width="30%" align="cneter"><img height="300px" src="<%=basePath%>/images/business/medicine/${medicinal.filepath1 }"></td>
				<td width="7%" >药材简写：</td>
				<td width="33%">${medicinal.code }</td>
			</tr>
			<tr>
				<td>药材名称：</td>
				<td>${medicinal.name }</td>
			</tr>
			<tr>
				<td>药材类型：</td>
				<td>${medicinal.type }</td>
			</tr>
			<tr>
				<td valign="top"><span style="line-height: 19px;">药材功能：</span></td>
				<td valign="top"><span style="line-height: 19px;">${medicinal.function }</span></td>
			</tr>
	</table>

</div>
