<%-- <jsp:forward page="login.jsp"></jsp:forward> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<script src="<%=basePath%>dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<%-- <head>
<meta http-equiv="refresh" content="0;url=<%=basePath%>pages/login/login.jsp?msgState=3">
</head> --%>
<!-- <body>会话失效，跳转登录页面...</body> -->
<a id="forword_session_edit_id" href="<%=basePath%>pages/login/login.jsp?msgState=3" hidden="true">跳转中...</a>

<script type="text/javascript" >
$(function(){ 
	var forword_session_edit_id_a = document.getElementById("forword_session_edit_id");
	forword_session_edit_id.click();
});
</script>