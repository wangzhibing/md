
/**
 * 医生诊断
 * @param diagnoseId
 * @param expertCustomerId
 */
function expertCheck(diagnoseId){
	var prescription6_medicinal = $("#prescription6_medicinal").val();
	$.ajax({
	   	  type: "POST",
		      url:bathPath+"/md/expert/expertCheck.do",
		      async: false,
		      data:{
		    	  'diagnoseId':diagnoseId,
		    	  'prescription6_medicinal':prescription6_medicinal
		      },
		      dataType:"json",
		      success: navTabAjaxDone,// || DWZ.ajaxDone,
			  error: DWZ.ajaxError
		  /*    success:function(data)
			  {
				  if(data.success ==true)
				  {
					  alertMsg.correct(data.message);
				  }
				  else{
					  alertMsg.error(data.message);
				  }
				  //var url = bathPath + "md/expert/queryExpertCheckingDiagnoseData.do";
				 // navTab.reload(url);
			  }*/
		 });
}


