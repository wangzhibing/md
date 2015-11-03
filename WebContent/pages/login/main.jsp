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


<style> 
.JS_ad{
    position: absolute; 
	right: 0px; 
	bottom: 0px; 
	height: 110px; 
	width: 180px; 
	border: 1px solid #CCCCCC; 
	background-color: #eeeeee; 
	padding: 1px; 
	overflow: hidden; 
	display: none; 
	font-size: 12px; 
	z-index: 10; 
} 

.JS_ad p
{ 
	padding: 6px; 
}

.JS_ad h1,.detail h1
{ 
	font-size: 14px; 
	height: 25px; 
	line-height: 25px; 
	background-color: #0066CC; 
	color: #FFFFFF; 
	padding: 0px 3px 0px 3px; 
	filter: Alpha(Opacity=100); 
	margin:0;
} 

.JS_ad h1 a, detail h1 a 
{ 
	float: right; 
	text-decoration: none; 
	color: #FFFFFF; 
} 




.JS_customer{
    position: absolute; 
	right: 0px; 
	bottom: 0px; 
	height: 110px; 
	width: 180px; 
	border: 1px solid #CCCCCC; 
	background-color: #eeeeee; 
	padding: 1px; 
	overflow: hidden; 
	display: none; 
	font-size: 12px; 
	z-index: 10; 
} 

.JS_customer p
{ 
	padding: 6px; 
}

.JS_customer h1,.detail h1
{ 
	font-size: 14px; 
	height: 25px; 
	line-height: 25px; 
	background-color: #0066CC; 
	color: #FFFFFF; 
	padding: 0px 3px 0px 3px; 
	filter: Alpha(Opacity=100); 
	margin:0;
} 

.JS_customer h1 a, detail h1 a 
{ 
	float: right; 
	text-decoration: none; 
	color: #FFFFFF; 
} 

</style> 

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
<link href="<%=basePath%>pages/login/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>pages/login/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/login/js/bootstrap-popover.js"></script>
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
	
	$("#buttonBtn").on('click',function(){
		var arrObj = $("input[name='symptomItem']:checked");
		if(arrObj.length < 4){
			alertMsg.error('至少选择4项');
			return false;
		}
	});

});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<%-- <div id="header" style="background: url('<%=basePath%>images/img30.png');"> --%>
		
		<div id="header" style="background: #990000;" >
		
		 <%-- <div style="background: url('<%=basePath%>images/img30.png'); width: 940px; height:44px;size: 16;" align="right"> --%>
		
			<!-- <div class="headerNav"> -->
			
			<!-- 华文新魏\华文行楷\方正舒体 -->
			
			    <h1 style="font-family:'华文行楷';font-weight: normal;margin-left: 500px;margin-top: 10px;font-size: 30px;color: silver;" id="headTitle"> ${headTitle } </h1>
				<ul class="nav" style="margin-top: 22px;">
				    <li><a href="http://101.71.21.17:8080/mdHome/home/index.jsp" >返回首页</a></li>
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
				
				<!-- <ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="red"><div>红色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul> -->
				
			<!-- </div> -->
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
							
							<li><a>特色诊疗</a>
								<ul>
								    <li><a id="intelligent" href="<%=basePath%>md/symptomItemValue/jspSymptomItemTab.do" onclick="changeMd(1);" target="navTab" rel='main'>智能中医</a></li>
									<li><a id="sister" href="<%=basePath%>md/symptomItemValue/jspSymptomItemTabMeimei.do" onclick="changeMd(2);" target="navTab" rel='main'>女士专科</a></li>
									<li><a id="litterBoy" href="<%=basePath%>md/symptomItemValue/jspSymptomItemTabXiaoer.do" onclick="changeMd(3);" target="navTab" rel='main'>小儿专科</a></li>
									<li><a id="parents" href="<%=basePath%>md/symptomItemValue/jspSymptomItemTabBama.do" onclick="changeMd(4);" target="navTab" rel='main'>亚健康专科</a></li>
								</ul>
							</li>
							
							
							<%-- <li><a>网上太医院</a>
								<ul>
									<li><a href="<%=basePath%>md/medicinal/queryMedicinalData.do" target="navTab" rel='medicinalListRel'>关注养生</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中药材</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中医时迅</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">古今中医</a></li>
								</ul>
							</li> --%>
							
							<c:if test="${!empty loginCustomer && loginCustomer.customer_type !='10'}">
							<li><a>会员管理</a>
								<ul>
							  		<li><a href="<%=basePath%>md/customer/queryCustomerInfo.do" target="navTab" rel='customerlistRel'>个人信息维护</a></li>
									<li><a href="<%=basePath%>md/diagnose/queryDiagnoseData.do" target="navTab" rel='diagnoseHistoryRel'>历史诊断查询</a></li>
									<c:if test="${loginCustomer.customer_type =='3' || loginCustomer.customer_type =='4' }">
									<li><a href="<%=basePath%>md/customer/queryApplyCustomerInfo.do" target="navTab" rel='applyCustomerlistRel'>用户数据管理</a></li>
									<li><a href="<%=basePath%>md/customerApplyinfo/querycustomerApplyinfoData.do" target="navTab" rel='customerApplyinfolistRel'>用户数据变更查询</a></li>
									<li><a href="<%=basePath%>md/diagnose/queryDiagnoseManagerData.do" target="navTab" rel='customerDiagnoseinfolistRel'>用户诊断信息查询</a></li>
									</c:if>	
									<c:if test="${loginCustomer.customer_type =='4' }">
									<li><a href="<%=basePath%>md/customer/queryManagerExpertInfo.do" target="navTab" rel='managerExpertinfolistRel'>管理员/医生信息管理</a></li>
									</c:if>								
								</ul>
							</li>
							</c:if>
							
							<c:if test="${!empty loginCustomer && loginCustomer.customer_type =='3'}">
							<li><a>后台统计</a>
								<ul>
							  		<li><a href="<%=basePath%>md/customerCount/queryOnlineCountInfo.do" target="navTab" rel='onlineCountRel'>在线用户统计</a></li>
									<li><a href="<%=basePath%>md/customerCount/queryRegisterCountInfo.do" target="navTab" rel='registerCountRel'>注册用户统计</a></li>
								</ul>
							</li>
							</c:if>
							
							<c:if test="${!empty loginCustomer}">
							<c:if test="${loginCustomer.customer_type =='10' }"> 
							<li><a>病例管理</a>
							    <ul>
							       <li><a href="<%=basePath%>md/expert/queryExpertCheckingDiagnoseData.do" target="navTab" rel="waitingDiagnoseRel" title="待确诊诊断病例"><span id="waitingDiagnoseRelSpanId">待确诊诊断病例(${loginCustomer.waitingExpert })</span></a></li>
							       <li><a href="<%=basePath%>md/expert/queryExpertCheckedDiagnoseData.do" target="navTab" rel="downDiagnoseRel">已确诊诊断病例</a></li>
							    </ul>
							</li>
							</c:if>
							</c:if>
							<%-- <li><a href="<%=basePath%>md/medicinal/queryMedicinalData.do" target="navTab" rel='medicinalListRel'>中药材常识</a></li> --%>
							
							<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">留言板</a></li>
							
							<li><a href="<%=basePath%>md/softDown/softDownForward.do" target="navTab" rel="softDownRel">软件下载</a></li>
							
							<li><a href="<%=basePath%>md/help/helpForward.do" target="navTab" rel="helpRel">使用帮助</a></li>
							
							<%-- <li><a>留言板</a>
								<ul>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中医园地</a></li>
								</ul>
							</li>
							<li><a>软件下载</a>
								<ul>
									<li><a href="<%=basePath%>md/medicinal/queryMedicinalData.do" target="navTab" rel='medicinalListRel'>药材信息查询</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中医园地</a></li>
								</ul>
							</li>
							<li><a>使用帮助</a>
								<ul>
									<li><a href="<%=basePath%>md/medicinal/queryMedicinalData.do" target="navTab" rel='medicinalListRel'>药材信息查询</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中医园地</a></li>
								</ul>
							</li>
							<li><a>QQ客服</a>
								<ul>
									<li><a href="<%=basePath%>md/medicinal/queryMedicinalData.do" target="navTab" rel='medicinalListRel'>药材信息查询</a></li>
									<li><a href="<%=basePath%>md/messageBoard/messageBoardForward.do" target="navTab" rel="messageBoardListRel">中医园地</a></li>
								</ul>
							</li> --%>
							
							
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
							<li tabid="main" class="main"><a href="javascript:;"><span id="main_id">${displayMainName }</span></a></li>
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
					
					
					
					
					
					<c:if test="${mdType=='1'}">
					
					
					<h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
                                    <c:if test="${sex=='2'}">女性</c:if> 
                                    <font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">病人性别切换</font></a>)</font>
                                                                         至少4条,最多20条) 请选择症状后，点击“自助诊断”按钮   <a href="<%=basePath%>md/help/helpForward.do" target="navTab" rel="helpRel"><font color="blue">使用帮助</font></a></h2>
                                                                         
							<%-- <h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if><c:if test="${sex=='2'}">女性</c:if> <c:if test="${isLogin=='0'}"><font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">切换</font></a>)</font></c:if>  至少4条,最多6条)</h2> --%>
  
								<form action="<%=basePath%>md/symptomItemValue/doSymptomItem.do" 
								      target="navTab"  class="pageForm required-validate"
								      onsubmit="return validateCallback(this,navTabAjaxDone);">
								      <input type="hidden" name="sex" value="${sex}">
								<div style="width: 100%;" >
									<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）：  <button id="buttonBtn" type="submit">自助诊断</button></span>
									<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
									
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
										<div class="tabsContent"  layoutH="102">
											<div  class="pageFormContent" style="height:90%">
												<c:forEach var="item" items="${symptomValueListType1}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	   rel="popover" data-content="${item.remark}" data-toggle="popover" >${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
												</c:forEach>
											</div>
											<div  class="pageFormContent" style="height:90%">
											 	<c:forEach var="item" items="${symptomValueListType2}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}" data-toggle="popover" >${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
												</c:forEach>
											</div>
											<div  class="pageFormContent" style="height:90%">
												<c:forEach var="item" items="${symptomValueListType3}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}" data-toggle="popover" >${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
												</c:forEach>
											</div>
											<div  class="pageFormContent" style="height:90%">
												<c:forEach var="item" items="${symptomValueListType4}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
												</c:forEach>
											</div>
											<div  class="pageFormContent" style="height:90%">
												<c:forEach var="item" items="${symptomValueListType5}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
												</c:forEach>
											</div>
											<div  class="pageFormContent" style="height:90%">
												<c:forEach var="item" items="${symptomValueListType6}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
								</form>

					</c:if>
					
					<c:if test="${mdType=='2'}">
					<h2 class="contentTitle" >请选择症状条目(至少4条,最多20条) 请选择症状后，点击“自助诊断”按钮   <a href="<%=basePath%>md/help/helpForward.do" target="navTab" rel="helpRel"><font color="blue">使用帮助</font></a></h2>
						<form action="<%=basePath%>md/symptomItemValue/doSymptomItem.do" 
							      target="navTab"  class="pageForm required-validate"
							      onsubmit="return validateCallback(this,navTabAjaxDone);">
							      <%-- <input type="hidden" name="sex" value="${sex}"> --%>
							<div style="width: 100%;" >
								<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）： <button id="buttonBtn" type="submit">自助诊断</button></span>
								<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
								
							</div>
							
							<div class="pageContent">
								<div class="tabs" currentIndex="0" eventType="click">
									<div class="tabsHeader">
										<div class="tabsHeaderContent">
											<ul>
												<li><a href="javascript:;"><span>望诊</span></a></li>
												<li><a href="javascript:;"><span>闻诊</span></a></li>
												<li><a href="javascript:;"><span>问诊</span></a></li>
												<li><a href="javascript:;"><span>切诊</span></a></li>
											</ul>
										</div>
									</div>
									<div class="tabsContent" layoutH="102">
										<div  class="pageFormContent" style="height:90%">
											<c:forEach var="item" items="${symptomItemValueListMeimei1}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
				    	 rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
										<div  class="pageFormContent" style="height:90%">
										 	<c:forEach var="item" items="${symptomItemValueListMeimei2}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
				    	 									rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
										<div  class="pageFormContent" style="height:90%">
											<c:forEach var="item" items="${symptomItemValueListMeimei3}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
															<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
																			    	 rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
										<div  class="pageFormContent" style="height:90%">
											<c:forEach var="item" items="${symptomItemValueListMeimei4}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
				    	 rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
							</form>
					
					</c:if>
					
					
					
					<c:if test="${mdType=='3'}">
					
					             <h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
                                    <c:if test="${sex=='2'}">女性</c:if> 
                                    <font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftXiaoerSex(${sex})"><font color="red" size="12">病人性别切换</font></a>)</font>
							                                                                         至少4条,最多20条) 请选择症状后，点击“自助诊断”按钮   <a href="<%=basePath%>md/help/helpForward.do" target="navTab" rel="helpRel"><font color="blue">使用帮助</font></a></h2>
							                                                                         
							<%-- <h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
							                                    <c:if test="${sex=='2'}">女性</c:if> 
							                                    <c:if test="${isLogin=='0'}"><font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">切换</font></a>)</font>
							                                        </c:if>  
							                                                                         至少4条,最多6条)</h2> --%>
							  
							<form action="<%=basePath%>md/symptomItemValue/doSymptomItem.do" 
							      target="navTab"  class="pageForm required-validate"
							      onsubmit="return validateCallback(this,navTabAjaxDone);">
							      <input type="hidden" name="sex" value="${sex}">
							<div style="width: 100%;" >
								<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）： <button id="buttonBtn" type="submit">自助诊断</button></span>
								<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
								
							</div>
							
							<div class="pageContent">
								<div class="tabs" currentIndex="0" eventType="click">
									<div class="tabsHeader">
										<div class="tabsHeaderContent">
											<ul>
												<li><a href="javascript:;"><span>望诊</span></a></li>
												<li><a href="javascript:;"><span>闻诊</span></a></li>
												<li><a href="javascript:;"><span>问诊</span></a></li>
												<li><a href="javascript:;"><span>切诊</span></a></li>
											</ul>
										</div>
									</div>
									<div class="tabsContent" layoutH="102">
										<div  class="pageFormContent" style="height:90%">
											<c:forEach var="item" items="${symptomItemValueListXiaoer1}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
										<div  class="pageFormContent" style="height:90%">
										 	<c:forEach var="item" items="${symptomItemValueListXiaoer2}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})"
												    	 rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
										<div  class="pageFormContent" style="height:90%">
											<c:forEach var="item" items="${symptomItemValueListXiaoer3}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
										<div  class="pageFormContent" style="height:90%">
											<c:forEach var="item" items="${symptomItemValueListXiaoer4}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})"
												    	 rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
							</form>

					</c:if>
					
					<c:if test="${mdType=='4'}">
						<h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
                                    <c:if test="${sex=='2'}">女性</c:if> 
                                    <font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftBamaSex(${sex})"><font color="red" size="12">病人性别切换</font></a>)</font>
						                                                                         至少4条,最多20条) 请选择症状后，点击“自助诊断”按钮   <a href="<%=basePath%>md/help/helpForward.do" target="navTab" rel="helpRel"><font color="blue">使用帮助</font></a></h2>
						                                                                         
						<%-- <h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
						                                    <c:if test="${sex=='2'}">女性</c:if> 
						                                    <c:if test="${isLogin=='0'}"><font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">切换</font></a>)</font>
						                                        </c:if>  
						                                                                         至少4条,最多6条)</h2> --%>
						  
						<form action="<%=basePath%>md/symptomItemValue/doSymptomItem.do" 
						      target="navTab"  class="pageForm required-validate"
						      onsubmit="return validateCallback(this,navTabAjaxDone);">
						      <input type="hidden" name="sex" value="${sex}">
						<div style="width: 100%;" >
							<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）： <button id="buttonBtn" type="submit">自助诊断</button></span>
							<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
							
						</div>
						
						<div class="pageContent">
							<div class="tabs" currentIndex="0" eventType="click">
								<div class="tabsHeader">
									<div class="tabsHeaderContent">
										<ul>
											<li><a href="javascript:;"><span>望诊</span></a></li>
											<li><a href="javascript:;"><span>闻诊</span></a></li>
											<li><a href="javascript:;"><span>问诊</span></a></li>
											<li><a href="javascript:;"><span>切诊</span></a></li>
										</ul>
									</div>
								</div>
								<div class="tabsContent" layoutH="102">
									<div  class="pageFormContent" style="height:90%">
										<c:forEach var="item" items="${symptomItemValueListBama1}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
										</c:forEach>
									</div>
									<div  class="pageFormContent" style="height:90%">
									 	<c:forEach var="item" items="${symptomItemValueListBama2}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
										</c:forEach>
									</div>
									<div  class="pageFormContent" style="height:90%">
										<c:forEach var="item" items="${symptomItemValueListBama3}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
										</c:forEach>
									</div>
									<div  class="pageFormContent" style="height:90%">
										<c:forEach var="item" items="${symptomItemValueListBama4}" varStatus="s">
												    <label>
												    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
												    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" 
												    	rel="popover" data-content="${item.remark}" data-toggle="popover">${item.name}</a>
												    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
																<c:if test="${item.filepath != ''}">
																<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
																</c:if>
														</div>
												    </label>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						</form>
						
					</c:if>

							
						
						
						
						
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="JS_ad"> 
        <h1 align="left"><a href='javascript:void(0)' id="close" style="font-size: 30px;font-weight: normal;">×</a>消息提示</h1><p>
        <p>
        <a href="<%=basePath%>md/expert/queryExpertCheckingDiagnoseData.do" 
            onclick=closeJS_ad()
            target="navTab" rel="waitingDiagnoseRel" title="待确诊诊断病例">
        	<span id="waiting_experet_id" style="font-weight: bold; line-height: 2; font-size: 15"></span></a>                
    </div> 
    
    
    <div class="JS_customer"> 
        <h1 align="left"><a href='javascript:void(0)' id="closeCustomer" style="font-size: 30px;font-weight: normal;">×</a>消息提示</h1><p>
        <p>
        <a href="<%=basePath%>md/diagnose/queryDiagnoseData.do" 
        	onclick=closeJS_customer()
            target="navTab" rel="diagnoseHistoryRel" title="历史诊断查询">
        	<span id="waiting_customer_id" style="font-weight: bold; line-height: 2; font-size: 15"></span></a>                
    </div> 
	
</body>
</html>


<script type="text/javascript" >
$(function(){ 
	
	setInterval(function(){
		
	   //专家查看待诊断信息
	   $.ajax({
		   	  type: "POST",
			      url:bathPath+"/md/expert/queryWaitingDiagnose.do",
			      data:{},
			      dataType:"json",
			      success:function(data)
				  {
					  if(data.success ==true)
					  {
						 // 待确诊诊断病例(${loginCustomer.waitingExpert })
						  $("#waiting_experet_id").html(data.message);
						  $(".JS_ad").slideDown(); 
					  }
					  
					  $("#waitingDiagnoseRelSpanId").html("待确诊诊断病例("+data.data+")");
				  }
			 });
	   
	   
	   //客户查看未诊断结果信息
	   $.ajax({
		   	  type: "POST",
			      url:bathPath+"/md/customer/queryCountWaitingLook.do",
			      data:{},
			      dataType:"json",
			      success:function(data)
				  {
					  if(data.success ==true)
					  {
						  $("#waiting_customer_id").html(data.message);
						  $(".JS_customer").slideDown(); 
					  }
				  }
			 });
	   
	},60000); 
	
    $("#close").click(function(){ 
        $(".JS_ad").slideUp();   
    }); 
    
    $("#closeCustomer").click(function(){ 
        $(".JS_customer").slideUp();   
    });  
});

/**关闭医生提示边框*/
function closeJS_ad(){
	 $(".JS_ad").slideUp();   
}

/**关闭医生提示边框*/
function closeJS_customer(){
	 $(".JS_customer").slideUp();   
}

$(function (){ 
	$("[data-toggle='popover']").popover();
});
</script>


