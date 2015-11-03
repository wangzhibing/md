function checkUserName()
{
	var userName = $("#login_name").val();
	if(userName == ""){
		$("#msg").text("登录名不能为空");
		$("#login_name").focus();
		return;
	}else{
		$("#msg").text("");
	}
}

function checkPwd()
{
	var pwd = $("#login_pwd").val();
	if(pwd == ""){
		$("#login_pwd").focus();
		$("#msg").text("密码不能为空");
		return;
	}else{
		$("#msg").text("");
	}
}

// function checkForm()
//  {
//      var flag = checkUserName();
//      if(flag){
//    	 var flag = checkPwd();
//    	 if(flag){
//    	 	return true;
//    	 }else{
//    	 	return false;
//    	 }
//      }else{	
//		 return false;
//      }
//  }



/**
 * 用户登录
 * @returns {Boolean}
 */
function loginIn()
{
	var userName = $("#login_name").val();
	if(userName == ""){
		$("#msg").text("登录名不能为空");
		$("#login_name").focus();
		return false;
	}
	$("#msg").text("");
	
	var pwd = $("#login_pwd").val();
	if(pwd == ""){
		$("#login_pwd").focus();
		$("#msg").text("密码不能为空");
		return false;
	}
	$("#msg").text("");
	
	var login_name = $("#login_name").val();
	var login_pwd = $("#login_pwd").val();
	 $.ajax({
			 type: "POST",
		      url: bathPath+"md/customer/loginIn.do",
			 data: {
				 		"login_name":login_name,
				 		"login_pwd":login_pwd
				   },
		 dataType: "json",
	        async: false,
	      success: function(data){
			 	if(data.success == false )
			 	{
			 		//onLoginError(data.message);
			 		$("#login_name").val('');
			 		$("#login_pwd").val('');
			 		$("#msg").text(data.message);
			 		return;
			 	}
			 	
			 	var jumpUrl = data.url;
			 	if(jumpUrl == null){
			 		jumpUrl = bathPath+"md/customer/mainForward.do";
			 	}
			 	window.location.href=jumpUrl;
		  }
	 });
	return false;
}


/**
 * 管理员用户登录
 * @returns {Boolean}
 */
function loginAdminIn()
{
	var userName = $("#login_name").val();
	if(userName == ""){
		$("#msg").text("登录名不能为空");
		$("#login_name").focus();
		return false;
	}
	$("#msg").text("");
	
	var pwd = $("#login_pwd").val();
	if(pwd == ""){
		$("#login_pwd").focus();
		$("#msg").text("密码不能为空");
		return false;
	}
	$("#msg").text("");
	
	var dynamic_pwd = $("#login_dynamic_pwd").val();
	if(dynamic_pwd == ""){
		$("#login_dynamic_pwd").focus();
		$("#msg").text("动态密码不能为空");
		return false;
	}
	
	if(dynamic_pwd.length != 8){
		$("#login_dynamic_pwd").focus();
		$("#msg").text("动态密码必须为8位");
		return false;
	}
	
	$("#msg").text("");
	
	var login_name = $("#login_name").val();
	var login_pwd = $("#login_pwd").val();
	var login_dynamic_pwd = $("#login_dynamic_pwd").val();
	 $.ajax({
			 type: "POST",
		      url: bathPath+"md/customer/loginAdminIn.do",
			 data: {
				 		"login_name":login_name,
				 		"login_pwd":login_pwd,
				 		"login_dynamic_pwd":login_dynamic_pwd
				   },
		 dataType: "json",
	        async: false,
	      success: function(data){
			 	if(data.success == false )
			 	{
			 		//onLoginError(data.message);
			 		$("#login_name").val('');
			 		$("#login_pwd").val('');
			 		$("#login_dynamic_pwd").val('');
			 		$("#msg").text(data.message);
			 		return;
			 	}
			 	
			 	var jumpUrl = data.url;
			 	if(jumpUrl == null){
			 		jumpUrl = bathPath+"md/customer/mainForward.do";
			 	}
			 	window.location.href=jumpUrl;
		  }
	 });
	return false;
}


/**
 * 用户退出
 */
function loginOut()
{
	 $.ajax({
			 type: "POST",
		      url: bathPath+"md/customer/loginOut.do",
		 dataType: "json",
	        async: false,
	      success: function(data){
			 	var jumpUrl = data.url;
			 	if(jumpUrl == null){
			 		jumpUrl = bathPath+"pages/login/login.jsp";
			 	}
			 	window.location.href=jumpUrl;
		  }
	 });
}

/**
 * 切换诊断主题
 */
function changeMd(val)
{
	var headTitle = "智&nbsp;&nbsp;能&nbsp;&nbsp;中&nbsp;&nbsp;医";
	var main_id = "智能中医";
	switch(val)
	{
		case 1:
			headTitle = "智&nbsp;&nbsp;能&nbsp;&nbsp;中&nbsp;&nbsp;医";
			main_id = "智能中医";
		    break;
		case 2:
			headTitle = "女&nbsp;&nbsp;士&nbsp;&nbsp;专&nbsp;&nbsp;科";
			main_id = "女士专科";
		    break;
		case 3:
			headTitle = "小&nbsp;&nbsp;儿&nbsp;&nbsp;专&nbsp;&nbsp;科";
			main_id = "小儿专科";
			break;
		case 4:
			headTitle = "亚&nbsp;&nbsp;健&nbsp;&nbsp;康&nbsp;&nbsp;专&nbsp;&nbsp;科";
			main_id = "亚健康专科";
		    break;
		default:
	}
	
	 $("#headTitle").html(headTitle);
	 $("#main_id").html(main_id);
}
