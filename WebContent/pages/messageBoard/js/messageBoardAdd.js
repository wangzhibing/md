function checkForm(form){
    var title = $("#title").val();
    var content = $("#content").val();
	
	if(!$.trim(title)){
		alertMsg.error("标题不能为空");
		return false;
	}
	
	if(!$.trim(content)){
		alertMsg.error("内容不能为空");
		return false;
	}
	
	return validateCallback(form,navTabAjaxDone);
}