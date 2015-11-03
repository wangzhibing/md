<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<title>无标题文档</title> 
<style> 
/* .JS_ad{width:100px; height:90px; border:1px solid #000; position:absolute; bottom:0px; right:10px; display:none;} 
.JS_ad a{ position:absolute; top:8px; right:8px; font-size:18px; text-decoration:none; color:#903;}  */

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

/* .JS_ad a{ position:absolute; top:8px; right:8px; font-size:18px; text-decoration:none; color:#903;} */ 


</style> 
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>  -->
<script src="<%=basePath%>dwz/js/jquery-1.7.2.js" type="text/javascript"></script>    
</head> 
 
<body> 
    <div class="JS_ad"> 
        <h1 align="left"><a href='javascript:void(0)' id="close">×</a>bbbbbb</h1><p>
                        你好，你有7个待确诊请求
    </div> 
</body>
</html>

<script type="text/javascript" >
$(function(){ 
    setTimeout(function(){ 
        $(".JS_ad").slideDown();     
    },1000); 
    
    $("#close").click(function(){ 
        $(".JS_ad").slideUp();   
    });   
}); 
</script>
