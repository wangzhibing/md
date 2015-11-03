<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ include file="/include.inc.jsp"%>

<%
    String msgState = request.getParameter("msgState");
%>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>智能中医服务平台</title>
    <meta charset="utf-8" />
    <meta http-equiv="pragma" content="no-cache" /> 
    <meta http-equiv="cache-control" content="no-cache" /> 
    <meta http-equiv="expires" content="0" />    
    
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="<%=basePath%>pages/login/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=basePath%>pages/login/css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <link href="<%=basePath%>pages/login/css/font-awesome.css" rel="stylesheet" />
    
    <link href="<%=basePath%>pages/login/css/adminia.css" rel="stylesheet" /> 
    <link href="<%=basePath%>pages/login/css/adminia-responsive.css" rel="stylesheet" /> 
    
    <link href="<%=basePath%>pages/login/css/pages/login.css" rel="stylesheet" /> 

 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="<%=basePath%>pages/login/js/login.js"></script>
  
  </head>
<body>
	
<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="<%=basePath%>md/customer/mainForward.do">智能中医服务平台</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					
					<li class="">
						
						<a href="<%=basePath%>md/customer/mainForward.do"><i class="icon-chevron-left"></i> 返回主页</a>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->


<div id="login-container">
	
	
	<div id="login-header">
		
		<h3>管理员登录</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix">
	
	<form action="<%=basePath%>md/customer/loginAdminIn.do" onsubmit="return loginAdminIn()" />
	
				<fieldset>
				    <div class="control-group"  style="color: red;font-weight: bold;" id="msg">
				      <%
				         if("1".equals(msgState)){
				        	 %>
				        	 用户登录时间过长，请重新登录
				        	 <%
				         }
				      %>
				      <c:if test="${msgState =='2' }">注册成功，请登录</c:if>
				    </div>
					<div class="control-group">
						<label class="control-label" for="login_name">登录名</label>
						<div class="controls">
							<input type="text" class="" id="login_name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="login_pwd">密码</label>
						<div class="controls">
							<input type="password" class="" id="login_pwd"  />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="login_dynamic_pwd">动态密码</label>
						<div class="controls">
							<input type="password" class="" id="login_dynamic_pwd"  />
						</div>
					</div>
				</fieldset>
				
				<div id="remember-me" class="pull-left">
				</div>
				
				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">
						登录
					</button>
				</div>
			</form>
			
		</div> <!-- /login-content -->
		
		
		<div id="login-extra">
			
			<p><a href="<%=basePath%>pages/login/login.jsp">普通用户登录</a>没有账号? <a href="<%=basePath%>pages/login/regist.jsp">注册</a>.或者以<a href="<%=basePath%>md/customer/mainForward.do">游客</a>身份登录</p>
			
			
		</div> <!-- /login-extra -->
	
</div> <!-- /login-wrapper -->

    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=basePath%>pages/login/js/jquery-1.7.2.min.js"></script>


<script src="<%=basePath%>pages/login/js/bootstrap.js"></script>

  </body>
</html>
