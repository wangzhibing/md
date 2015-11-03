<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<div class="pageContent">

		<table class="table">
			<thead>
			</thead>
		</table>
		
		<div class="pageFormContent" layoutH="76">
		    <dl class="nowrap">
				<dt style="text-align: right;">客户：</dt>
				<dd><input name="customer_name" style="width: 280px;" type="text" readonly="readonly" value="${messageBoard.customer_name }" /></dd>
			</dl>
		
			<dl class="nowrap">
				<dt style="text-align: right;">标题：</dt>
				<dd><input name="title" id="title" style="width: 280px;" type="text" readonly="readonly" value="${messageBoard.title }" /></dd>
			</dl>
			
			<dl class="nowrap">
				<dt style="text-align: right;">留言时间：</dt>
				<dd><input name="time" style="width: 280px;" type="text" readonly="readonly" value="${messageBoard.time }" /></dd>
			</dl>
			
			<dl class="nowrap">
				<dt style="text-align: right;">内容：</dt>
				<dd><textarea name="content" id="content"  class="editor" readonly="readonly" cols="84" rows="15">${messageBoard.content }</textarea></dd>
			</dl>
		</div>
		
</div>
