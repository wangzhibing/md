<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>智能中医服务平台</title>

<link href="<%=basePath%>dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath%>dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath%>dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=basePath%>dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>


<script src="<%=basePath%>dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<script src="<%=basePath%>dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/dwz.print.js" type="text/javascript"></script>

<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="<%=basePath%>dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>pages/login/js/login.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/symptomitem/js/symptomitem.js"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("<%=basePath%>dwz/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>


<h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if><c:if test="${sex=='2'}">女性</c:if> <c:if test="${isLogin=='0'}"><font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">切换</font></a>)</font></c:if>  至少4条,最多6条)</h2>
  

      <input type="hidden" name="sex" value="${sex}">
<div style="width: 100%;" >
	<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）：</span>
	<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
	
	<button id="buttonBtn" type="submit">提交</button>
</div>


<div class="pageContent">
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
		<div class="tabsContent" style="height:513px;">
			<div  class="pageFormContent" style="height:400px">
				<c:forEach var="item" items="${symptomValueListType1}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") / />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:400px">
			 	<c:forEach var="item" items="${symptomValueListType2}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}"  onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:400px">
				<c:forEach var="item" items="${symptomValueListType3}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:400px">
				<c:forEach var="item" items="${symptomValueListType4}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:400px">
				<c:forEach var="item" items="${symptomValueListType5}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:400px">
				<c:forEach var="item" items="${symptomValueListType6}" varStatus="s">
				    <label title="${item.remark}"><input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}") />${item.name}</label>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
