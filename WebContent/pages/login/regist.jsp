<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title>User Account - Bootstrap Admin</title>
<meta http-equiv="pragma" content="no-cache" /> 
<meta http-equiv="cache-control" content="no-cache" /> 
<meta http-equiv="expires" content="0" />   
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />

<link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />

<link href="./css/font-awesome.css" rel="stylesheet" />

<link href="./css/adminia.css" rel="stylesheet" />
<link href="./css/adminia-responsive.css" rel="stylesheet" />

<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="./css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<link href="./css/pages/plans.css" rel="stylesheet" />


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



</head>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="<%=basePath%>md/customer/mainForward.do">智能中医服务平台</a>

				<div class="nav-collapse">

					<ul class="nav pull-right">

						<li class=""><p> 有账号? <a href="<%=basePath%>pages/login/login.jsp">登录</a></p></li>
					</ul>

				</div>
				<!-- /nav-collapse -->

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->




	<div id="content">

		<div class="container">

			<div class="row">

				<div class="span9">

					<div class="widget">

						<div class="widget-header">
							<h3>请填写注册信息</h3>
						</div>
						<!-- /widget-header -->

						<div class="widget-content">
							<div class="tabbable">
								<div class="tab-content">
									<form id="form" class="form-horizontal" method="post"
									      action="<%=basePath %>/md/customer/registCustomer.do" 
									      onsubmit="return checkForm();" >
										<div class="control-group">
											<label class="control-label" for="login_name"><font color="red">*</font>用户名</label>
											<div class="controls">
												<input type="text" class="form-control" id="login_name" name="login_name"  value="" />
												 &nbsp;&nbsp;&nbsp;&nbsp;
												 <span id="login_name_tip" style="color: red"></span>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="card_type"><font color="red">*</font>证件类型</label>
											<div class="controls">
												<input type="text" class="form-control" id="card_type" readonly="readonly" value="身份证" />
												&nbsp;&nbsp;&nbsp;&nbsp;
												 <span id="card_type_tip" style="color: red"></span>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="card_no"><font color="red">*</font>证件号码</label>
											<div class="controls">
												<input type="text" class="form-control" id="card_no" name="card_no"  onblur="relBirth()" value="" />
												 &nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="card_no_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->
										
										<div class="control-group">
											<label class="control-label" for="name"><font color="red">*</font>姓名</label>
											<div class="controls">
												<input type="text" class="form-control" id="name" name="name" value="" />
													 &nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="name_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->
										
										<div class="control-group">
											<label class="control-label" for="sex"><font color="red">*</font>性别</label>
											<div class="controls">
						                        <label class="radio-inline">
						                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" checked="checked" value="1" />
						                           		 男&nbsp;&nbsp;&nbsp;&nbsp;
						                            <input type="radio" name="sex"  value="2" />
						                         	   女 </label>
						                    </div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->
										
										<div class="control-group">
											<label class="control-label" for="birth">出生日期</label>
											<div class="controls">
												<input type="text" class="form-control" id="birth" name="birth" readonly="readonly"  />
												&nbsp;&nbsp;&nbsp;&nbsp;
												 <span id="birth_tip" style="color: red"></span>
											</div>
										</div>
										
										<!-- <div class="form-group">
							                <label class="control-label"><font color="red">*</font>出生时间</label>
							                <div class="controls date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="birth" data-link-format="yyyy-mm-dd">
							                    <input type="text"  value="1980-01-01"  readonly="readonly" />
							                    &nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="birth_tip" style="color: red"></span>
												<span class="add-on"><i class="icon-th"></i></span>
							                </div>
											<input type="hidden" id="birth" name="birth" value="1980-01-01" /><br/>
							            </div> -->
            
										<div class="control-group">
											<label class="control-label" for="tel"><font color="red">*</font>电话</label>
											<div class="controls">
												<input type="text" class="form-control" id="tel" name="tel"  value="" />
												&nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="tel_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->
										
										<div class="control-group">
											<label class="control-label" for="social_card_no">医保卡号</label>
											<div class="controls">
												<input type="text" class="form-control" id="social_card_no" name="social_card_no" value="" />
											    &nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="social_card_no_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->

										<div class="control-group">
											<label class="control-label" for="login_pwd"><font color="red">*</font>密码</label>
											<div class="controls">
												<input type="password" class="form-control" id="login_pwd" name="login_pwd"  value="" />
												&nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="login_pwd_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->


										<div class="control-group">
											<label class="control-label" for="login_pwd2"><font color="red">*</font>确认密码</label>
											<div class="controls">
												<input type="password" class="form-control" id="login_pwd2" name="login_pwd2"    value="" />
											    &nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="login_pwd2_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->
										
										<div class="control-group">
											<label class="control-label" for="address">地址</label>
											<div class="controls">
												<input type="text" class="form-control" id="address" name="address" value=""  style="width:400px;" />
											     &nbsp;&nbsp;&nbsp;&nbsp;
													 <span id="address_tip" style="color: red"></span>
											</div>
											<!-- /controls -->
										</div>
										<!-- /control-group -->
										
										<br />
										<div class="form-actions">
											<button type="submit" class="btn btn-primary">确定</button>
											<button type="reset" class="btn">取消</button>
										</div>
										<!-- /form-actions -->
									</form>
								</div>
							</div>
						</div>
						<!-- /widget-content -->
					</div>
					<!-- /widget -->
				</div>
				<!-- /span9 -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /content -->


	<!-- <div id="footer">

		<div class="container">
			<hr />
			<p>&copy; 2014 XXX.</p>
		</div>
		/container

	</div> -->
	<!-- /footer -->


	<!-- Le javascript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	
<script type="text/javascript">
if(!Array.indexOf){
    Array.prototype.indexOf = function(obj){              
        for(var i=0; i<this.length; i++){
            if(this[i]==obj){
                return i;
            }
        }
        return -1;
    }
}
</script>
	<script src="./js/jquery-1.7.2.min.js"></script>
	<script src="./js/bootstrap.js"></script>
	
	
<script type="text/javascript" src="./js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script src="./js/regist.js"></script>

<script type="text/javascript">
	$('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
</script>

</body>
</html>
