<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<script type="text/javascript" src="<%=basePath%>pages/messageBoard/js/messageBoardAdd.js"></script>
<div class="pageContent">

	<form method="post" action="<%=basePath%>md/messageBoard/addMessageBoard.do" class="pageForm required-validate" onsubmit="return checkForm(this);">
		<table class="table">
			<thead>
			</thead>
		</table>
		
		<div class="pageFormContent" layoutH="76">
		    <dl class="nowrap">
				<dt style="text-align: right;">客户：</dt>
				<dd><input name="customer_name" style="width: 280px;" type="text" readonly="readonly" value="${customer_name }" /></dd>
			</dl>
		
			<dl class="nowrap">
				<dt style="text-align: right;">标题：</dt>
				<dd><input name="title" id="title" style="width: 280px;" type="text" value="" /></dd>
			</dl>
			
			<dl class="nowrap">
				<dt style="text-align: right;">内容：</dt>
				<dd><textarea name="content" id="content" class="editor"  cols="84" rows="15" ></textarea></dd>
			</dl>
		</div>
		
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
