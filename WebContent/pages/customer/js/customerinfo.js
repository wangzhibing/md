/**
 * 客户申请管理员
 * @param v
 */
function applyManager(v){
	$.ajax({
   	  type: "POST",
	      url:bathPath+"/md/customer/applyManagerCommon.do",
	      async: false,
	      data:{},
	      dataType:"json",
	      success:function(data)
		  {
			  if(data.success ==true)
			  {
				  //按钮隐藏
				  $("#applyManagerButton").hide();
				  //alert(data.message);
				  alertMsg.correct(data.message);
			  }
			  else{
				  //alert(data.message);
				  alertMsg.correct(data.message);
			  }
		  }
	 });
}


/**
 * 客户激活
 * @param v
 */
function activeManager(v){
	var activeManagerFn = function(){
		$.ajax({
		   	  type: "POST",
			      url:bathPath+"/md/customer/activeManager.do",
			      async: false,
			      data:{},
			      dataType:"json",
			      success:function(data)
				  {
					  if(data.success ==true)
					  {
						  alertMsg.correct(data.message);
						  setTimeout(forwardLoginAdmin,2000);
					  }
					  else{
						  alertMsg.correct(data.message);
					  }
				  }
			 });
		};
	alertMsg.confirm("确认激活吗？", {okCall: activeManagerFn});
}

/** 
 * 跳转到管理员登录页面
 */
function forwardLoginAdmin(){
	var jumpUrl = bathPath+"pages/login/loginAdmin.jsp";
 	window.location.href=jumpUrl;
}