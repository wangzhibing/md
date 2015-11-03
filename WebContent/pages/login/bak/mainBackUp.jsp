<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<%@ include file="/include.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>智能中医服务平台</title>

<link href="<%=basePath%>dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath%>dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath%>dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=basePath%>dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->

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
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<ul class="nav">
				
				    <c:if test="${!empty loginCustomer}">
				      <li><font color='#FFFFFF'>欢迎${loginCustomer.name}(${loginCustomer.login_name}) </font></li>
				      <li><a href="javascript:void()" onclick="loginOut()">退出</a></li>
				    </c:if>
				    
				    <c:if test="${empty loginCustomer}">
				      <li><a href="<%=basePath%>pages/login/login.jsp" >登录</a></li>
				      <li><a href="<%=basePath%>pages/login/loginAdmin.jsp" >高级登录</a></li>
				      <li><a href="<%=basePath%>pages/login/regist.jsp" >注册</a></li>
				    </c:if>
				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>会员操作</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>症状选择</a>
								<ul>
									<li><a href="<%=basePath%>md/symptomItemValue/jspSymptomItemTab.do" target="navTab" rel='diagnoseRel'>智能中医</a></li>
									<c:if test="${!empty loginCustomer}">
									  <li><a href="<%=basePath%>md/diagnose/queryDiagnoseData.do" target="navTab" rel='diagnoseHistoryRel'>历史诊断结果查询</a></li>
									  <li><a href="<%=basePath%>md/customer/queryCustomerInfo.do" target="navTab" rel='customerlistRel'>个人信息维护</a></li>
									  <c:if test="${loginCustomer.customer_type =='3' }">
									     <li><a href="<%=basePath%>md/customer/queryApplyCustomerInfo.do" target="navTab" rel='applyCustomerlistRel'>申请管理员维护</a></li>
									  </c:if>
									</c:if>
									
									<li><a href="<%=basePath%>md/medicinal/queryMedicinalData.do" target="navTab" rel='medicinalListRel'>药材信息查询</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中医园地</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav1">知名中医</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav2">养生保健常识</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav3">养身保健品</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav4">中医文化</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav5">中医时讯</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav6">欢迎加盟</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav7">意见建议</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav8">软件下载</a></li>
									<li><a href="<%=basePath%>pages/system_edit.jsp" target="navTab" rel="userLiNav9">在线客户</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">公司主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">公司主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							 
							<div class="right"> 
								<p></p> 
							</div>
							<p><span>医药诊断平台</span></p>
							<p>From：智能中医服务平台</p>
						</div> 
						<div class="pageFormContent" layoutH="80" style="margin-right:230px"> 
							<h2>客户端下载地址:</h2>
							<div class="unit"></div>
							<div class="unit"></div>
							<div class="unit"></div>
							<div class="unit"></div>												
							<div class="divider"></div>
							<h2>需求和建议:</h2>
							<pre style="margin:5px;line-height:1.4em">
							 	有任何需求或建议请联系徐善利(先生)：15336259966
							</pre> 
							<div class="divider"></div>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>