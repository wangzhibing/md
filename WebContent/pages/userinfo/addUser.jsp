<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='md/user/addUser.do?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>姓名: </label>
			<input type="text" name="name" class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>
		<p>
			<label>电话: </label>
			<input type="text" name="phone" class="required" maxlength="30"/>
		</p>
		<p>
			<label>地址: </label>
			<input type="text" name="address" maxlength="100"/>
		</p>
		<p>
			<label>账号: </label>
			<input type="text" name="accountNo" maxlength="30"/>
		</p>
		<p>
			<label>说明: </label>
			<input type="text" name="rmk" maxlength="30"/>
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
