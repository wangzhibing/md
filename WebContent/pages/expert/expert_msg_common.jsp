<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<div class="pageContent">
<!--   本功能只为交费VIP用户提供服务，获取VIP用户的途径：
 1、	耆珍堂中医院用户
 2、XXXX养老中心用户
 3、认证/缴费用户
 
  医院/养老用户进入         前去缴费	 -->
  <div class="pageFormContent" layoutH="50">
    <dl class="nowrap">
			本功能只为交费VIP用户提供服务，获取VIP用户的途径：	
  </dl>
  <dl class="nowrap">
			1、	耆珍堂中医院用户	
  </dl>
  <dl class="nowrap">
			2、XXXX养老中心用户
  </dl>
  <dl class="nowrap">
			3、认证/缴费用户
  </dl>
  
  <dl class="nowrap">
  <dt style="text-align: right;color: blue;font-weight: bold;"><a href="#"><font color="blue">医院/养老用户进入</font></a></dt>
  <dt style="text-align: right;color: blue;font-weight: bold;"><a href="#"><font color="blue">前去缴费</font></a></dt>
  </dl>
  </div>
	<div class="formBar">
	<ul>
		<c:if test="${isLogin =='1' && loginCustomer.apply_status =='1' }">
	    <li> 
			<div class="button"><div class="buttonContent"><button type="button" class="close" onclick="applyManagerPay(${loginCustomer.id })">升级为vip用户</button></div></div>
		</li>
		</c:if>
		<li> 
			<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
		</li>
	</ul>
</div>
</div>

<script type="text/javascript">
function applyManagerPay(v){
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
				  //$("#applyManagerButton").hide();
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
</script>
