/**
 * 纯 JavaScript, jquery工具集
 */
if (typeof expert == 'undefined') {
	expert = function() {
	};
}

/**
 * 病人联系诊断医生
 * @param diagnoseId
 * @param expertCustomerId
 */
function contactExpert(diagnoseId,expertCustomerId){
	$.ajax({
	   	  type: "POST",
		      url:bathPath+"/md/expert/contactExpertCustomer.do",
		      async: false,
		      data:{
		    	  'diagnoseId':diagnoseId,
		    	  'expertCustomerId':expertCustomerId
		      },
		      dataType:"json",
		      success:function(data)
			  {
		    	  //$.pdialog.close("expert_medicinal_rel");
		    	  $.pdialog.closeCurrent(); //关闭当前活动层。 
				  if(data.success ==true)
				  {
					  alertMsg.correct(data.message);
				  }
				  else{
					  alertMsg.error(data.message);
				  }
			  }
		 });
}


