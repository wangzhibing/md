
function exportDiagnoseData(){
	var Sys = {};
    var ua = navigator.userAgent.toLowerCase();
    if (window.ActiveXObject){
        Sys.ie = ua.match(/msie ([\d.]+)/)[1];
    }
    
	//是否是IE浏览器
    var isIe = 0;
	//以下进行测试
    if(Sys.ie){
    	isIe = 1;
    }
	
	var diagnose_date_start = $("#diagnose_date_start").val(); 
	var diagnose_date_end = $("#diagnose_date_end").val();
	var customer_name = $("#customer_name").val();
	var login_name = $("#login_name").val();
	var doctor_name = $("#doctor_name").val();
	location.href = bathPath+"/md/diagnose/exportDiagnoseData.do" +
			        "?diagnose_date_start="+diagnose_date_start+
	                "&diagnose_date_end="+diagnose_date_end+
	                "&customer_name="+customer_name+
	                "&login_name="+login_name +
	                "&doctor_name="+doctor_name+
	                "&isIe="+isIe;  
}


