// 对Date的扩展，将 Date 转化为指定格式的String   
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
// 例子：   
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.Format = function(fmt)   { //author: meizz   
  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
  }; 
  
  if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  }
  
  for(var k in o){   
      if(new RegExp("("+ k +")").test(fmt)){   
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
      }
  }
  return fmt;   
};  


Date.prototype.addDays = function(d)
{
    this.setDate(this.getDate() + d);
};

Date.prototype.addWeeks = function(w)
{
    this.addDays(w * 7);
};

Date.prototype.addMonths= function(m)
{
    var d = this.getDate();
    this.setMonth(this.getMonth() + m);
    if (this.getDate() < d)
        this.setDate(0);
};

Date.prototype.addYears = function(y)
{
    var m = this.getMonth();
    this.setFullYear(this.getFullYear() + y);
    if (m < this.getMonth())
     {
        this.setDate(0);
     }
};


/**
 * 纯 JavaScript, jquery工具集
 */
if (typeof common == 'undefined') {
	common = function() {
	};
}

/**
 * 公共方法：针对查询页面，具有时间查询字段。 PS:查询页面，必须有id为startDate，endDate的文本域
 * 7天没周期,查最近一周的范围期间
 */
common.queryDate = function() {
	$("#endDate").val(new Date().Format("yyyy-MM-dd"));
	var startDate = new Date();
	startDate.addDays(-7);
	$("#startDate").val(startDate.Format("yyyy-MM-dd"));
};


/**
 * 校验起始时间是否符合规则
 * 1.开始时间必须小于结束时间
 * PS:查询页面，必须有id为startDate，endDate的文本域
 */
common.checkDateLocal =  function(){
	var startDate = $("#startDate").val().replace(/\-/g,"/");
	var endDate =$("#endDate").val().replace(/\-/g,"/");
	if(startDate!=""&&endDate!=""){
		if(startDate>endDate){
			alertMsg.error("起始时间必须早于结束时间");
			return false;
		}
	}
	return true;
};
