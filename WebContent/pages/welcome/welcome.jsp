<%@ page language="java"  pageEncoding="utf-8"%>
<%@ include file="../login/head.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" /> 
<script type="text/javascript" src="<%=basePath%>pages/welcome/js/jquery1.4.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/welcome/js/bioV4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/welcome/js/jquery.lazyload.mini.js"></script>
<title>智能中医服务平台</title>
<meta name="Keywords" content="智能中医服务平台"/>
<meta name="Description" content="智能中医服务平台"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>pages/welcome/style/basic.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>pages/welcome/style/xmdata.css"/>
<script type="text/javascript" src="<%=basePath%>pages/welcome/js/function.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/welcome/js/xmdata.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js?v=20130220"></script>
<script type="text/javascript">
DD_belatedPNG.fix('img,.ie6png');
</script>
<![endif]--> 

</head>
<body>
	<script type="text/javascript" src="<%=basePath%>pages/welcome/js/borsertocss.js"> </script><!-- 判断在IE9以下浏览器中根据像素的不同而设置的样式 -->	
    
    
    <!--头部代码开始-->
     <div class="navbar navbar-fixed-top" style="_position: relative;_z-index: 10000;">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<ul class="nav" id="navID">
						
            <li class=""><a href="#"><b>智能中医服务平台</b></a></li>

             
                       
					</ul>
				</div><!--/.nav-collapse -->
				<ul class="nav pull-right login-none nav-tips">
		<li class="ie6png divider-vertical" style="_width: 30px;_height: 40px;_background: url(<%=basePath%>pages/welcome/images/icons.png) no-repeat 10px -106px;"><a class="dropdown-toggle clearfix" href="/login.html?url=aHR0cDovL3d3dy5iaW9kaXNjb3Zlci5jb20vbmV3cy5odG1sP3BhZ2U9Mg%3D%3D" style="padding: 7px 5px;"><img class="logo-before pull-left" src="<%=basePath%>pages/welcome/images/avatar-icon.png" /></a></li>
	</ul>
<div class="popup-div tips-div" style="position: absolute;z-index: 10000001;display: none;"></div>
<script type="text/javascript">
var tip_show = 1;
//头部下拉
var timer1 = "";
$('#dropdownID-0').hover(function(){
	var obj = $(this);
	if(timer1)
	{
		clearTimeout(timer1);
	}
	timer1 = setTimeout(function(){
		obj.find('.dropdown-menu').show();
		tip_show = 0;
		$(".tips-div").hide();
		obj.find('.other-icon').css({"background":"#2E2E2E"});
	}, 500);
},function(){
	var obj = $(this);
	if(timer1)
	{
		clearTimeout(timer1);
	}
	timer1 = setTimeout(function(){
		obj.find('.dropdown-menu').hide();
		$(".tips-div").hide();
		tip_show = 1;
		getTips();
		obj.find('.other-icon').css({"background":"none"});
	}, 500);
});

var timer2 = "";
$('#dropdownID-1').hover(function(){
	var obj = $(this);
	if(timer2)
	{
		clearTimeout(timer2);
	}
	timer2 = setTimeout(function(){
		obj.find('.dropdown-menu').show();
		tip_show = 0;
		$(".tips-div").hide();
		obj.find('.other-icon').css({"background":"#2E2E2E"});
	}, 500);
},function(){
	var obj = $(this);
	if(timer2)
	{
		clearTimeout(timer2);
	}
	timer2 = setTimeout(function(){
		obj.find('.dropdown-menu').hide();
		tip_show = 1;
		getTips();
		$(".tips-div").hide();
		obj.find('.other-icon').css({"background":"none"});
	}, 500);
});
</script>				

<ul class="nav pull-right pl-20 myul">
    <li class=""><a href="register.html">注册</a></li>
    <li class="l10"><a href="login.html">登录</a></li>
</ul>
			</div>
		</div>
	</div>


<script type="text/javascript">
	$(function(){
		var Interval_control = '';
		var current_index = 0;
		show_pic_ad = function(index){
			$(".top-ad .pull-left").each(function(i){
				$(this).hide();
				if(i == index){
					$(this).show(); 
				}
			});
		};
		show_point_ad = function(index){
			$(".top-ad .slides-ad-point a").each(function(i){
				if($(this).hasClass("icon-css-on")){
					$(this).removeClass("icon-css-on");
					$(this).addClass("icon-css");
				}
				if(i == index){
					if($(this).hasClass("icon-css")){
						$(this).removeClass("icon-css");
					}
					$(this).addClass("icon-css-on");
				}
			});
		};
		slides = function(){
			$(".slides-ad-point a").each(function(index){
				$(this).click(function(){
					current_index = index;
					show_point_ad(index);
					show_pic_ad(current_index);
				});
			});
		};
		slides();
		Interval_control = setInterval(function(){
			show_point_ad(current_index);
			show_pic_ad(current_index);
			if (current_index == ($(".slides-icon-ad a").length - 1)){
				current_index = -1;
			}
			current_index ++;
		},5000);//设置自动切换函数
		//当触发mouseenter事件时，取消正在执行的自动切换方法，触发mouseouter事件时重新设置自动切换
		$(".top-ad .pull-left").mouseenter(function() {
			clearInterval(Interval_control);//停止自动切换
		}).mouseleave(function(){
			Interval_control = setInterval(function(){
				show_point_ad(current_index);
				show_pic_ad(current_index);
				if (current_index == ($(".top-ad .pull-left").length - 1)){
					current_index = -1;
				}
				current_index ++;
			},5000);//设置自动切换函数
		});
	});
</script>    
    
    
    
    <!--头部代码结束-->
    
    
    
    
    


	<div class="hr tp-div-nexthr" style="margin-top: 0;margin-bottom: 0;padding: 0;"></div>
	<div class="container pb-15">
	<!-- Example row of columns -->
	<div class="row">
		<div class="span12">
       
       <!--搜索-->
       
 
									
          <!--搜索结束--> 
  <!-- <div class="mmdata">欢迎<a href="">提交新项目</a>,让产品快速打响知名度,赢得投资人青睐</div>-->        
          
  <div class="mylistshow b-20  t-20" id="mmlistshow">
  <div class="downjiao"><img src="<%=basePath%>pages/welcome/images/downjiao.jpg" alt="hide" /></div>  
  <dl class="mydllist">
  <dd>关注领域：</dd>    
  <dd class="selected"><span class="ml"></span><span class="mm"><a href="">全部</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养老</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养生</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">健康</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">生活</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">医疗</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">中医</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">生活</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">友情</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养老院</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养生会所</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">茶品人生</a></span><span class="mr"></span></dd>
    <dd><span class="ml"></span><span class="mm"><a href="">养老</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养生</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">健康</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">生活</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">医疗</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">中医</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">生活</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">友情</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养老院</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">养生会所</a></span><span class="mr"></span></dd>
  <dd><span class="ml"></span><span class="mm"><a href="">茶品人生</a></span><span class="mr"></span></dd>
  </dl>
 
  </div>
         
            
 <!--列表开始-->     
                         
   <!--第一个    左对齐      pull-left-->                                  
  <div class="label-div b-20 border-all pb-10 pt-5 pull-left" style="width:47%; width:47% \9; position: relative; padding-left: 0; height:auto;">
  
   <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
			<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
             <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="智能诊断" target="_blank" href="<%=basePath%>md/customer/mainForward.do">智能诊断</a>
        </h1>
	    <p class="t-1 mt1">1、智能诊断</p>
	    <p class="t-1 mt1">2、医药查询</p>
	    <p class="t-1 mt1">3、中医天地</p>
	    <p class="t-1 mt1">4、养生保健常识</p>
      <p class="t-1 mt1">5、知名中医</p>    
      <div class="clearfix" style="height:auto;margin-top:0px;">
			
       <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第一个结束-->      
    
   <!--第二个       右对齐    pull-right-->                                  
 <div class="label-div b-20 border-all pb-10 pt-5 pull-right" style="width:47%; width:47% \9; position: relative; padding-left: 0;">
    <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
			<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
             <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md1.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>
      <div class="clearfix" style="height:auto;margin-top:0px;">
			    
      <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第二个结束-->     
    
    
     <!--第三个    左对齐      pull-left-->                                  
  <div class="label-div b-20 border-all pb-10 pt-5 pull-left" style="width:47%; width:47% \9; position: relative; padding-left: 0; height:auto;">
  
   <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
			<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
             <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md2.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>    
      <div class="clearfix" style="height:auto;margin-top:0px;">
			
       <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第三个结束-->      
    
   <!--第皿个       右对齐    pull-right-->                                  
 <div class="label-div b-20 border-all pb-10 pt-5 pull-right" style="width:47%; width:47% \9; position: relative; padding-left: 0;">
   <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
						<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
                        <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md3.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>    
      <div class="clearfix" style="height:auto;margin-top:0px;">
			
       <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第皿个结束--> 
    
    
    
   <div class="label-div b-20 border-all pb-10 pt-5 pull-left" style="width:47%; width:47% \9; position: relative; padding-left: 0; height:auto;">
  
   <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
			<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
             <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md5.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>    
      <div class="clearfix" style="height:auto;margin-top:0px;">
			
       <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第一个结束-->      
    
   <!--第二个       右对齐    pull-right-->                                  
 <div class="label-div b-20 border-all pb-10 pt-5 pull-right" style="width:47%; width:47% \9; position: relative; padding-left: 0;">
    <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
			<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
             <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md8.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>
      <div class="clearfix" style="height:auto;margin-top:0px;">
			    
      <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第二个结束-->     
    
    
     <!--第三个    左对齐      pull-left-->                                  
  <div class="label-div b-20 border-all pb-10 pt-5 pull-left" style="width:47%; width:47% \9; position: relative; padding-left: 0; height:auto;">
  
   <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
			<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
             <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md4.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>    
      <div class="clearfix" style="height:auto;margin-top:0px;">
			
       <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第三个结束-->      
    
   <!--第皿个       右对齐    pull-right-->                                  
 <div class="label-div b-20 border-all pb-10 pt-5 pull-right" style="width:47%; width:47% \9; position: relative; padding-left: 0;">
   <div class="clearfix pt-3">
		  <div class="index-news-img spanm3 pull-left pt-5">
						<a href="javascript:;" title="标题标题标题" target="_blank" rel="bookmark">
                        <img class="lazyloadimg" alt="标题标题标题标题标题标题" src="<%=basePath%>pages/welcome/images/md7.jpg"/></a>
		 </div>
         
         
  	<div class="offset3 intro mmwidth">
		<h1>
        <a title="中医咨询" target="_blank" href="javascript:;">中医咨询</a>
        </h1>
	    <p class="t-1 mt1">1、当归的作用</p>
	    <p class="t-1 mt1">2、茯苓的食法</p>
	    <p class="t-1 mt1">3、罂粟也是药材</p>
	    <p class="t-1 mt1">4、腊八粥做法</p>
      <p class="t-1 mt1">5、莲子羹做法</p>    
      <div class="clearfix" style="height:auto;margin-top:0px;">
			
       <div class="">
			<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="0人关注	0人分享	3人评论" data-id="104417" data-type="news">3人</a>
			<a class="read-btn ie6png" href="javascript:void(0);" title="277次阅读">277次</a>
		 </div>
         
	</div>
 
    </div>
  
    </div>
   
     
</div>
    <!--第皿个结束--> 
 
    
  <!--列表结束-->         


		</div>
        
      
      <!--右侧代码-->  
       <div class="span4">
			
        
            
            <div class="label-div t-20 border-all">
				<div class="l-15">
               		 <h3 class="label-title border-b b-15 small clearfix" style="padding-bottom: 14px;">关注养生</h3>
                </div>
				<div class="label-main tody-hot l-15" >
					<ul>
					  <li><a href="">茶饮料PK现沏茶 谁更好？</a></li>
            <li><a href="">盛夏养心练太极</a></li>
            <li><a href="">夏天大家究竟应该吃什么？</a></li>
            <li><a href="">夏季吃水果有没有什么禁忌？</a></li>
            <li><a href="">秋天易干 该如何预防</a></li>
            <li><a href="">传统养生观：春夏养阳 秋冬养阴</a></li>
            <li><a href="">冬季中医养生注意事项</a></li>
					</ul>
				</div>
			</div>
            
            
            
             <div class="label-div t-20 border-all">
				<div class="l-15">
               		 <h3 class="label-title border-b b-15 small clearfix" style="padding-bottom: 14px;">今日药材知识</h3>
                </div>
				<div class="label-main tody-hot l-15" >
					<ul>
					  <li><a href="">莲子 最典型的“夏日食品”</a></li>
                      <li><a href="">枸杞 补益精诸不足。。。</a></li>
                      <li><a href="">红枣 红枣味甘性温。。。</a></li>
                      <li><a href="">萝卜 冬吃萝卜夏吃姜</a></li>
                      <li><a href="">山药 多食山药“聪耳明目”</a></li>
                      <li><a href="">葛根 幽冥葛粉、葛麻藤</a></li>
                      <li><a href="">当归 性温 味甘辛 无毒</a></li>
					</ul>
				</div>
			</div>
            
            
            
             <div class="label-div t-20 border-all">
				<div class="l-15">
               		 <h3 class="label-title border-b b-15 small clearfix" style="padding-bottom: 14px;">专家建议</h3>
                </div>
				<div class="label-main tody-hot l-15" >
					<ul>
					  <li><a href="">徐善利专家建议冬天刚到注意保暖</a></li>
			            <li><a href="">方涛专家建议提防病毒入侵</a></li>
			            <li><a href="">曹工建议做好冬天大补</a></li>
			            <li><a href="">徐善利专家建议冬天刚到注意保暖</a></li>
			            <li><a href="">方涛专家建议提防病毒入侵</a></li>
			            <li><a href="">曹工建议做好冬天大补</a></li>
			            <li><a href="">徐善利专家建议冬天刚到注意保暖</a></li>

					</ul>
				</div>
			</div>
            
          
             
            
	 
            
		</div>
	</div>
</div>

<!--右侧代码结束-->


<!-- /container -->

  <div class="container">
 
 	<div class="hr"></div>
    
    </div>
  
<!-- /container -->

</div>
    
 
<div class="footer">
		 

			<div class="clearfix" style="background:#EDEDED;">
				
                <!--<p class="fc999 pull-left footer-info">Copyright © 2013 生物探索网站<span class="l-20">苏ICP备11025281号</span></p>-->
				
                <ul class="about-ul">
					<li>客服电话 15336529966 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></li>
					<li><span>|</span></li>
					<li><a title="广告投放" href="javascript:;" class="fc666" target="_blank">广告投放</a></li>
					<li><span>|</span></li>
					<li><a title="企业服务" href="javascript:;" class="fc666" target="_blank">企业服务</a></li>
					<li><span>|</span></li>
					<li><a title="公司博客" href="javascript:;" class="fc666" target="_blank" >公司博客</a></li>
					<li><span>|</span></li>
					<li><a title="加入我们" href="javascript:;" class="fc666" target="_blank">加入我们</a></li>
					<li><span>|</span></li>
					<li><a title="服务协议" href="javascript:;" class="fc666" target="_blank">服务协议</a></li>
					<li><span>|</span></li>
                     <li id="zk_btn" class="ie6png down-class">
                   	 <a title="友情链接" href="javascript:void(0);" class="fc666">友情链接</a>
                    </li>
				    <div class="clear"></div>
				</ul>
			</div>
    
    <div class="friend-link border-all t-20 b-20">
		<ul class="clearfix">
		
	</ul>
</div>
  <script type="text/javascript">
	$(document).ready(function(){
		var flag = 0;
		$(".friend-link").hide();
		//Down
		$("#zk_btn").click(function(){
			if(flag == 0){
				$(".friend-link").slideDown(400); 
				$(this).removeClass('down-class');
				$(this).addClass('up-class');
				$("html,body").animate({scrollTop:($(".friend-link").offset().top+2000)},600);
				flag = 1;
			}else{
				$(".friend-link").slideUp(400);  
				$(this).removeClass('up-class');
				$(this).addClass('down-class'); 
				flag = 0;
			}
		});
	});
</script>
<p>Copyright ©2013　　备8888888888号</p>
    
		</div> 










<script type="text/javascript">
//回到顶部
backToTop('body');
</script>
</body>
</html>