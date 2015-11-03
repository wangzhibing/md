<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='md/user/editUser.do?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="id" value="${user.id}"/>
	<div class="pageFormContent" layoutH="57">
		<p>
			<label>姓名: </label>
			<input type="text" name="name" class="required alphanumeric" minlength="6" maxlength="20" value="${user.name}"/>
		</p>
		<p>
			<label>电话: </label>
			<input type="text" name="phone" value="${user.phone}" class="required" maxlength="30"/>
		</p>
		<p>
			<label>地址: </label>
			<input type="text" name="address" value="${user.address}" maxlength="100"/>
		</p>
		<p>
			<label>账号: </label>
			<input type="text" name="accountNo" value="${user.accountNo}" maxlength="30"/>
		</p>
		<p>
			<label>说明: </label>
			<input type="text" name="rmk" value="${user.rmk}" maxlength="30"/>
		</p>

	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
