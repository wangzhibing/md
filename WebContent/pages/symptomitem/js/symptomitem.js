/**
 * 纯 JavaScript, jquery工具集
 */
if (typeof symptomitem == 'undefined') {
	symptomitem = function() {
	};
}


function show(o,divid) {
	var m = document.getElementById(divid);
	
	var MouseX=event.x; 
	var MouseY=event.y;
	//alert('getL(o):'+getL(o)+',getT(o):'+getT(o)+',o.offsetHeight：'+o.offsetHeight);
	/*m.style.pixelLeft = getL(o);
	m.style.pixelTop = getT(o) + o.offsetHeight;*/
	/*m.style.left = getL(o);
	m.style.top = (getT(o) + o.offsetHeight);*/
	
	//m.offsetLeft = getL(o);
	//m.offsetTop = getT(o) + o.offsetHeight ;
	//alert('m.style.pixelLef:'+m.style.pixelLeft +',m.style.pixelTop:'+m.style.pixelTop);
	
	m.style.visibility = '';
	$("#"+a_id).popover();
}

function hide(divid) {
	document.getElementById(divid).style.visibility = 'hidden';
}

function getL(e) {
	var l = e.offsetLeft;
	while (e = e.offsetParent) {
		l += e.offsetLeft;
	}
	return l;
}

function getT(e) {
	var t = e.offsetTop;
	while (e = e.offsetParent) {
		t += e.offsetTop;
	}
	return t;
}



/**
 * 公共方法：针对查询页面，具有时间查询字段。 PS:查询页面，必须有id为startDate，endDate的文本域
 */
symptomitem.check = function(obj,name){
	
	var symptomItemValueShow = "" ;
	var symptomItemId = ""  ;
	
	var arrObj = $("input[name='symptomItem']:checked");
	if(arrObj.length >20){
		alertMsg.error('最多只能选择20项');
		obj.checked = false;
		return;
	}
	
	var radioItem = "";
	
	arrObj.each(function(){
		var me = $(this);
		symptomItemId = symptomItemId + "," + me.attr('value');
		symptomItemValueShow = symptomItemValueShow + "," + me.attr('displayname');
		radioItem += '<input type="radio" name="mainSymptom" value="'+me.attr('value')+'">'+me.attr('displayname')+'';
		radioItem += '&nbsp;&nbsp;&nbsp;&nbsp;';
	});
	
	var radioDiv = document.getElementById("radioDiv");
	radioDiv.innerHTML=radioItem;
};


$("#buttonBtn").on('click',function(){
	var arrObj = $("input[name='symptomItem']:checked");
	if(arrObj.length < 4){
		alertMsg.error('至少选择4项');
		return false;
	}
});


function seashowtip(tips,flag,iwidth){  
	var my_tips = document.getElementById("mytips");
	if(flag){  
	      my_tips.innerHTML=tips;  
	      my_tips.style.width=iwidth; 
	      my_tips.style.left=event.clientX+10+document.body.scrollLeft;  
	      my_tips.style.top=event.clientY+10+document.body.scrollTop;  
	      my_tips.style.display="";  
	}  
	else{  
	      my_tips.style.display="none";  
	}  
}  


function shiftSex(sex){
	if(sex == 1){
		sex = 2 ;
	}
	else{
		sex = 1;
	}
	var url = bathPath+"md/symptomItemValue/jspSymptomItemTab.do?sex="+sex;
	navTab.reload(url);
}


function shiftXiaoerSex(sex){
	if(sex == 1){
		sex = 2 ;
	}
	else{
		sex = 1;
	}
	var url = bathPath+"md/symptomItemValue/jspSymptomItemTabXiaoer.do?sex="+sex;
	navTab.reload(url);
}

function shiftBamaSex(sex){
	if(sex == 1){
		sex = 2 ;
	}
	else{
		sex = 1;
	}
	var url = bathPath+"md/symptomItemValue/jspSymptomItemTabBama.do?sex="+sex;
	navTab.reload(url);
}

//专家确诊
function valid_expert_medicinal_common(diagnoseId){
	
	//验证主诉和病症为必输
	var report = $("#report").val();
	var medical_history = $("#medical_history").val();
	var sick_name = $("#sick_name").val();
	var sick_age = $("#sick_age").val();
	
	if(sick_name.length > 10){
		alertMsg.error('病人姓名输入过长');
		return;
	}
	
	if (isNaN(sick_age)){
		alertMsg.error('病人年龄必须是数字');
		return ;
	}
	
	
	if( sick_age != '' && (sick_age >150 || sick_age <=0)){
		alertMsg.error('病人年龄必须在0-150之间');
		return ;
	}
	
	if(report.length > 150){
		alertMsg.error('主诉输入过长');
		return;
	}
	
	if(medical_history.length > 150){
		alertMsg.error('病史输入过长');
		return;
	}
	
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
	
	var link_a = document.getElementById("expertDiagnoiseId_common");
	var tmpLink = link_a.href;
	link_a.href = tmpLink + "&report="+report+"&medical_history="+medical_history+"&sick_name="+sick_name+"&sick_age="+sick_age+"&isIe="+isIe;
	link_a.click();
	$("#expertDiagnoiseId_common").attr("href",tmpLink);
}

function valid_expert_medicinal_pay(diagnoseId){

	//验证主诉和病症为必输
	var report = $("#report").val();
	var medical_history = $("#medical_history").val();
	var sick_name = $("#sick_name").val();
	var sick_age = $("#sick_age").val();
	
	if(sick_name.length > 10){
		alertMsg.error('病人姓名输入过长');
		return;
	}
	
	if (isNaN(sick_age)){
		alertMsg.error('病人年龄必须是数字');
		return ;
	}
	
	
	if( sick_age != '' && (sick_age >150 || sick_age <=0)){
		alertMsg.error('病人年龄必须在0-150之间');
		return ;
	}
	
	if(report.length > 150){
		alertMsg.error('主诉输入过长');
		return;
	}
	
	if(medical_history.length > 150){
		alertMsg.error('病史输入过长');
		return;
	}
	
	var Sys = {};
    var ua = navigator.userAgent.toLowerCase();
    if (window.ActiveXObject){
        Sys.ie = ua.match(/msie ([\d.]+)/)[1];
    }
//    else if (document.getBoxObjectFor){
//        Sys.firefox = ua.match(/firefox\/([\d.]+)/)[1];
//    }
//    else if (window.MessageEvent && !document.getBoxObjectFor){
//        Sys.chrome = ua.match(/chrome\/([\d.]+)/)[1];
//    }
//    else if (window.opera){
//        Sys.opera = ua.match(/opera.([\d.]+)/)[1];
//    }
//    else if (window.openDatabase){
//        Sys.safari = ua.match(/version\/([\d.]+)/)[1];
//    }
	
    //是否是IE浏览器
    var isIe = 0;
	//以下进行测试
    if(Sys.ie){
    	isIe = 1;
    }
	
	//report = EncodeUtf8(report);
	//medical_history = encodeURIComponent(medical_history);
	
	//alert('report:'+report+'。medical_history:'+medical_history+'。sick_name:'+sick_name);
	var link_a = document.getElementById("expertDiagnoiseId_pay");
	var tmpLink = link_a.href;
	link_a.href = tmpLink + "&report="+report+"&medical_history="+medical_history+"&sick_name="+sick_name+"&sick_age="+sick_age+"&isIe="+isIe;
	link_a.click();
	$("#expertDiagnoiseId_pay").attr("href",tmpLink);
}

function valid_expert_medicinal_manager(diagnoseId){
	//验证主诉和病症为必输
	var report = $("#report").val();
	var medical_history = $("#medical_history").val();
	var sick_name = $("#sick_name").val();
	var sick_age = $("#sick_age").val();
	
	if(sick_name.length > 10){
		alertMsg.error('病人姓名输入过长');
		return;
	}
	
	if (isNaN(sick_age)){
		alertMsg.error('病人年龄必须是数字');
		return ;
	}
	
	
	if( sick_age != '' && (sick_age >150 || sick_age <=0)){
		alertMsg.error('病人年龄必须在0-150之间');
		return ;
	}
	
	if(report.length > 150){
		alertMsg.error('主诉输入过长');
		return;
	}
	
	if(medical_history.length > 150){
		alertMsg.error('病史输入过长');
		return;
	}
	
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
	
	var link_a = document.getElementById("expertDiagnoiseId_manager");
	var tmpLink = link_a.href;
	link_a.href = tmpLink + "&report="+report+"&medical_history="+medical_history+"&sick_name="+sick_name+"&sick_age="+sick_age+"&isIe="+isIe;
	link_a.click();
	$("#expertDiagnoiseId_manager").attr("href",tmpLink);
}


//<div id=mytips style="background-color:#ffffff;
//	  width:121;height:16;border:1px solid gray;display:none;
//	  filter: progid:DXImageTransform.Microsoft.Shadow(color=#999999,direction=135,strength=3); 
//	  left:0; top:5">
//</div> 
//id="${item.id}" onmousemove=seashowtip(this.id,1,150) onmouseout=seashowtip(this.id,0,150) 



//if(obj.checked == true){
//	if(!symptomItemValueShow && !symptomItemId){
//		$("#symptomItemValueShow").val(name);
//		$("#symptomItemId").val(obj.value);
//	}
//	else{
//		symptomItemValueShow = symptomItemValueShow + ','+name;
//		symptomItemId = symptomItemId +','+obj.value;
//		$("#symptomItemValueShow").val(symptomItemValueShow);
//		$("#symptomItemId").val(symptomItemId);
//	}
//}
//else{
//	var arrId = symptomItemId.split(',');
//	var arrShow = symptomItemValueShow.split(',');
//	if(arrId.length > 1){
//		symptomItemId = "";
//		symptomItemValueShow = "";
//		for(var i=0;i<arrId.length;i++){
//			if(arrId[i] != obj.value ) {
//				symptomItemId = symptomItemId + "," + arrId[i];
//				symptomItemValueShow = symptomItemValueShow + "," + arrShow[i];
//			}
//		}
//		
//		symptomItemId = symptomItemId.substr(1,symptomItemId.length);
//		symptomItemValueShow = symptomItemValueShow.substr(1,symptomItemValueShow.length);
//		$("#symptomItemValueShow").val(symptomItemValueShow);
//		$("#symptomItemId").val(symptomItemId);
//	}
//	else{
//		$("#symptomItemValueShow").val("");
//		$("#symptomItemId").val("");
//	}
//}


//symptomitem.check = function(obj,name){
//	
//	var symptomItemValueShow = "" ;
//	var symptomItemId = ""  ;
//	
//	var arrObj = $("input[name='symptomItem']:checked");
//	if(arrObj.length >6){
//		alert('最多只能选择6项');
//		obj.checked = false;
//		return;
//	}
//	
//	arrObj.each(function(){
//		var me = $(this);
//		symptomItemId = symptomItemId + "," + me.attr('value');
//		symptomItemValueShow = symptomItemValueShow + "," + me.attr('displayname');
//	});
//	
//	symptomItemId = symptomItemId.substr(1,symptomItemId.length);
//	symptomItemValueShow = symptomItemValueShow.substr(1,symptomItemValueShow.length);
//	$("#symptomItemValueShow").html(symptomItemValueShow);
//	$("#symptomItemId").val(symptomItemId);
//};





function EncodeUtf8(s1)
{
      var s = escape(s1);
      var sa = s.split("%");
      var retV ="";
      if(sa[0] != "")
      {
         retV = sa[0];
      }
      for(var i = 1; i < sa.length; i ++)
      {
           if(sa[i].substring(0,1) == "u")
           {
               retV += Hex2Utf8(Str2Hex(sa[i].substring(1,5)));
             
           }
           else retV += "%" + sa[i];
      }
    
      return retV;
}

function Str2Hex(s)
{
      var c = "";
      var n;
      var ss = "0123456789ABCDEF";
      var digS = "";
      for(var i = 0; i < s.length; i ++)
      {
         c = s.charAt(i);
         n = ss.indexOf(c);
         digS += Dec2Dig(eval(n));
         
      }
      //return value;
      return digS;
}
function Dec2Dig(n1)
{
      var s = "";
      var n2 = 0;
      for(var i = 0; i < 4; i++)
      {
         n2 = Math.pow(2,3 - i);
         if(n1 >= n2)
         {
            s += '1';
            n1 = n1 - n2;
          }
         else
          s += '0';
        
      }
      return s;
    
}
function Dig2Dec(s)
{
      var retV = 0;
      if(s.length == 4)
      {
          for(var i = 0; i < 4; i ++)
          {
              retV += eval(s.charAt(i)) * Math.pow(2, 3 - i);
          }
          return retV;
      }
      return -1;
}
function Hex2Utf8(s)
{
     var retS = "";
     var tempS = "";
     var ss = "";
     if(s.length == 16)
     {
         tempS = "1110" + s.substring(0, 4);
         tempS += "10" + s.substring(4, 10);
         tempS += "10" + s.substring(10,16);
         var sss = "0123456789ABCDEF";
         for(var i = 0; i < 3; i ++)
         {
            retS += "%";
            ss = tempS.substring(i * 8, (eval(i)+1)*8);
          
          
          
            retS += sss.charAt(Dig2Dec(ss.substring(0,4)));
            retS += sss.charAt(Dig2Dec(ss.substring(4,8)));
         }
         return retS;
     }
     return "";
}

