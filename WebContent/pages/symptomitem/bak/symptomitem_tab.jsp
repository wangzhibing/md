<%@ include file="/include.inc.jsp"%>
<%@ include file="../../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript" src="<%=basePath%>pages/symptomitem/js/symptomitem.js"></script>
<h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if><c:if test="${sex=='2'}">女性</c:if> <c:if test="${isLogin=='0'}"><font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">切换</font></a>)</font></c:if>  至少4条,最多6条)</h2>
  
<%-- 
action="md/symptomItemValue/doSymptomItem.do"
<form method="post" action="<%=basePath%>pages/symptomitem/symptomitem_result.jsp"  target="navTab"> --%>
<form action="<%=basePath%>md/symptomItemValue/doSymptomItem.do" 
      target="navTab"  class="pageForm required-validate"
      onsubmit="return validateCallback(this,navTabAjaxDone);">
      <input type="hidden" name="sex" value="${sex}">
<div style="width: 100%;" >
	<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）：</span>
	<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
	
	<button id="buttonBtn" type="submit">提交</button>
</div>



	<div class="tabs" currentIndex="0" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>面眼鼻舌苔</span></a></li>
					<li><a href="javascript:;"><span>神态咳热头晕痛</span></a></li>
					<li><a href="javascript:;"><span>胸胁腰腹部</span></a></li>
					<li><a href="javascript:;"><span>汗二阴二便</span></a></li>
					<li><a href="javascript:;"><span>手足关节部</span></a></li>
					<li><a href="javascript:;"><span>把二十一脉</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent" layoutH="122">
			<div  class="pageFormContent" >
				<c:forEach var="item" items="${symptomValueListType1}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") / />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" >
			 	<c:forEach var="item" items="${symptomValueListType2}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}"  onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent">
				<c:forEach var="item" items="${symptomValueListType3}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" >
				<c:forEach var="item" items="${symptomValueListType4}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" >
				<c:forEach var="item" items="${symptomValueListType5}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" >
				<c:forEach var="item" items="${symptomValueListType6}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
		</div>
	</div>
</form>
