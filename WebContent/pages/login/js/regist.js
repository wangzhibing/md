var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子   
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];            // 身份证验证位值.10代表X   
   

/**  
 * 判断身份证号码为18位时最后的验证位是否正确  
 * @param a_idCard 身份证号码数组  
 * @return  
 */  
function isTrueValidateCodeBy18IdCard(a_idCard) {   
    var sum = 0;                             // 声明加权求和变量   
    if (a_idCard[17].toLowerCase() == 'x') {   
        a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作   
    }   
    for ( var i = 0; i < 17; i++) {   
        sum += Wi[i] * a_idCard[i];            // 加权求和   
    }   
    valCodePosition = sum % 11;                // 得到验证码所位置   
    if (a_idCard[17] == ValideCode[valCodePosition]) {   
        return true;   
    } else {   
        return false;   
    }   
} 

/**  
  * 验证18位数身份证号码中的生日是否是有效生日  
  * @param idCard 18位书身份证字符串  
  * @return  
  */  
function isValidityBrithBy18IdCard(idCard18){   
    var year =  idCard18.substring(6,10);   
    var month = idCard18.substring(10,12);   
    var day = idCard18.substring(12,14);   
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
    // 这里用getFullYear()获取年份，避免千年虫问题   
    if(temp_date.getFullYear()!=parseFloat(year)   
          ||temp_date.getMonth()!=parseFloat(month)-1   
          ||temp_date.getDate()!=parseFloat(day)){   
            return false;   
    }else{   
        return true;   
    }   
}   

  /**  
   * 验证15位数身份证号码中的生日是否是有效生日  
   * @param idCard15 15位书身份证字符串  
   * @return  
   */  
  function isValidityBrithBy15IdCard(idCard15){   
      var year =  idCard15.substring(6,8);   
      var month = idCard15.substring(8,10);   
      var day = idCard15.substring(10,12);   
      var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
      // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
      if(temp_date.getYear()!=parseFloat(year)   
              ||temp_date.getMonth()!=parseFloat(month)-1   
              ||temp_date.getDate()!=parseFloat(day)){   
                return false;   
        }else{   
            return true;   
        }   
  } 
  
/**
 * 去掉字符串头尾空格 
 */  
function trim(str) {   
    return str.replace(/(^\s*)|(\s*$)/g, "");   
} 


/**
 * 通过身份证输入完毕，自动填写出生日期
 */
function relBirth(){
	$("#birth").val('');
	var idCard = $("#card_no").val();
	if(!$.trim(idCard)){
		return;
	}
	
	idCard = trim(idCard.replace(/ /g, ""));  
	if (idCard.length == 18) {   
        var a_idCard = idCard.split("");               
        if(isValidityBrithBy18IdCard(idCard) && isTrueValidateCodeBy18IdCard(a_idCard)){   //进行18位身份证的基本验证和第18位的验证
            //截取设值
        	var year = idCard.substr(6,4);
        	var month = idCard.substr(10,2);
        	var date = idCard.substr(12,2);
        	$("#birth").val(year + '-' + month + '-' + date);
        }
        else{
        	return ;
        }
    }
	else{
		return; 
	}
}



/**
 * 身份证号码验证
 * @param idCard
 * @returns
 */
function IdCardValidate() { 
	var idCard = $("#card_no").val();
	if(!$.trim(idCard)){
		$("#card_no_tip").html("证件号码不能为空");
		$("#card_no").focus();
		return false;
	}
	
    idCard = trim(idCard.replace(/ /g, ""));               //去掉字符串头尾空格                     
//    if (idCard.length == 15) {   
//        if(isValidityBrithBy15IdCard(idCard)){
//        	 
//        }
//        else{
//        	$("#card_no_tip").html("格式不正确");
//        	$("#card_no").val('');
//    		$("#card_no").focus();
//            return false;  
//        }
//    } else 
    if (idCard.length == 18) {   
        var a_idCard = idCard.split("");                // 得到身份证数组   
        if(isValidityBrithBy18IdCard(idCard) && isTrueValidateCodeBy18IdCard(a_idCard)){   //进行18位身份证的基本验证和第18位的验证
           
        }else {
        	$("#card_no_tip").html("格式不正确");
        	$("#card_no").val('');
    		$("#card_no").focus();
            return false;   
        }   
    } else {   
    	$("#card_no_tip").html("格式输入错误，只能18位");
    	$("#card_no").val('');
		$("#card_no").focus();
        return false;   
    }
    $("#card_no_tip").html('');
    return true;
}


/**
 * 验证电话号码
 */
function validatemobile()
{
	var mobile = $("#tel").val();
	
	if(!$.trim(mobile)){
		$("#tel_tip").html("手机号码不能为空");
		$("#tel").focus();
		return false;
	}
	
    if(mobile.length!=11)
    {
        $("#tel_tip").html("格式输入错误，只能11位");
		$("#tel").focus();
        return false;
    }
    
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    //var mytell = /\d{3}-\d{8}|\d{4}-\d{7}/;
    if(!myreg.test(mobile) ){
        $("#tel_tip").html("请输入有效的电话号码");
		$("#tel").focus();
        return false;
    }
    $("#tel_tip").html('');
    return true;
}

/**
 * 登录名验证
 * @returns {Boolean}
 */
function checkLoginName(){
	var login_name = $("#login_name").val();
	
	if(!$.trim(login_name)){
		$("#login_name_tip").html("登录名不能为空");
		$("#login_name").focus();
		return false;
	}
	
	if(login_name.length > 20 ){
		$("#login_name_tip").html("输入格式不对，最长20位");
		$("#login_name").val('');
		$("#login_name").focus();
		return false;
	}
	
	var flag = false;
	$.ajax({
     	  type: "POST",
	      url:bathPath+"/md/customer/doCheckLoginName.do",
	      async: false,
	      data:{
	    	  login_name:login_name
	      },
	      dataType:"json",
	      success:function(data)
		  {
			  if(data.success ==true)
			  {
				  flag=true;
			  }
		  }
	 });
	
	 if(!flag){
	 	$("#login_name_tip").text("此登录名已经存在");
	 	$("#login_name").val('');
	 	$("#login_name").focus();
        return false;
     }
	
	$("#login_name_tip").html('');
	return true;
}

/**
 * 姓名验证
 * @returns {Boolean}
 */
function checkName(){
	var name = $("#name").val();
	
	if(!$.trim(name)){
		$("#name_tip").html("姓名不能为空");
		$("#name").focus();
		return false;
	}
	
	if(name.length > 20 ){
		$("#name_tip").html("输入格式不对，最长20位");
		$("#name").val('');
		$("#name").focus();
		return false;
	}
	
	$("#name_tip").html('');
	return true;
}

/**
 * 验证密码
 */
function checkLoginPwd(){
    var login_pwd = $("#login_pwd").val();
	
	if(!$.trim(login_pwd)){
		$("#login_pwd_tip").html("密码不能为空");
		$("#login_pwd").focus();
		return false;
	}
	
	if(login_pwd.length > 20){
		$("#login_pwd_tip").html("输入格式不对，最长20位");
		$("#login_pwd").focus();
		return false;
	}
	
	$("#login_pwd_tip").html('');
	return true;
}

/**
 * 验证确认密码
 */
function checkLoginPwd2(){
	var login_pwd = $("#login_pwd").val();
    var login_pwd2 = $("#login_pwd2").val();
	
	if(!$.trim(login_pwd2)){
		$("#login_pwd2_tip").html("确认密码不能为空");
		$("#login_pwd2").focus();
		return false;
	}
	
	if(login_pwd2.length > 20){
		$("#login_pwd2_tip").html("输入格式不对，最长20位");
		$("#login_pwd2").focus();
		return false;
	}
	
	if(login_pwd != login_pwd2){
		$("#login_pwd2_tip").html("密码与确认密码输入不一样");
		return false;
	}
	
	$("#login_pwd2_tip").html('');
	return true;
}

/**
 * 验证社保卡号
 */
function checkSocial_card_no(){
    var social_card_no = $("#social_card_no").val();
	
	if($.trim(social_card_no) && social_card_no.length > 20){
		$("#social_card_no_tip").html("输入格式不对，最长20位");
		$("#social_card_no").focus();
		return false;
	}
	$("#social_card_no_tip").html('');
	return  true;
}

/**
 * 验证地址
 */
function checkAddress(){
    var address = $("#address").val();
	
	if($.trim(address) && address.length > 40){
		$("#address_tip").html("输入格式不对，最长40位");
		$("#address").focus();
		return false;
	}
	$("#address_tip").html('');
	return true;
}

/**
 * 验证生日
 * @returns
 */
function checkBirth(){
	var birth = $("#birth").val();
	if(!$.trim(birth)){
		$("#birth_tip").html("出生日期不能为空");
		$("#birth").focus();
		return false;
	}
	$("#birth_tip").html('');
	return true;
}




/**
 * 表单验证
 */
function checkForm(){
	$("#login_name_tip").html('');
	$("#card_no_tip").html('');
	$("#name_tip").html('');
	$("#birth_tip").html('');
	$("#tel_tip").html('');
	$("#social_card_no_tip").html('');
	$("#login_pwd_tip").html('');
	$("#login_pwd2_tip").html('');
	$("#address_tip").html('');
	
	
	if(checkLoginName()){
		if(IdCardValidate()){
			if(checkName()){
				if(checkBirth()){
					if(validatemobile()){
						if(checkSocial_card_no()){
							if(checkLoginPwd()){
								if(checkLoginPwd2()){
									if(checkAddress()){
										return true;
									}
									else{
										return false;
									}
								}
								else{
									return false;
								}
							}
							else{
								return false;
							}
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	else{
		return false;
	}
}
	

	
//	&& IdCardValidate()
//	
//	&& checkName() 
//	
//	&& checkBirth()
//
//	&& validatemobile()
//	
//	&& checkSocial_card_no();
//	
//	&& checkLoginPwd();
//	
//	&& checkLoginPwd2();
//	
//	&& checkAddress();


