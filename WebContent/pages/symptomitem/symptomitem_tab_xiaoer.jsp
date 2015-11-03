<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="<%=basePath%>pages/login/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>pages/login/js/bootstrap-popover.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/login/js/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/symptomitem/js/symptomitem.js"></script>
<h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
                                    <c:if test="${sex=='2'}">女性</c:if> 
                                    <font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftXiaoerSex(${sex})"><font color="red" size="12">病人性别切换</font></a>)</font>
                                                                         至少4条,最多20条) 请选择症状后，点击“自助诊断”按钮   <a href="<%=basePath%>md/help/helpForward.do" target="navTab" rel="helpRel"><font color="blue">使用帮助</font></a></h2>
                                                                         
<%-- <h2 class="contentTitle" >请选择症状条目(<c:if test="${sex=='1'}">男性</c:if>
                                    <c:if test="${sex=='2'}">女性</c:if> 
                                    <c:if test="${isLogin=='0'}"><font color="red" size="12">(<a href="javascript:void(0)" onclick="shiftSex(${sex})"><font color="red" size="12">切换</font></a>)</font>
                                        </c:if>  
                                                                         至少4条,最多6条)</h2> --%>
  
<form action="<%=basePath%>md/symptomItemValue/doSymptomItem.do" 
      target="navTab"  class="pageForm required-validate"
      onsubmit="return validateCallback(this,navTabAjaxDone);">
      <input type="hidden" name="sex" value="${sex}">
<div style="width: 100%;" >
	<span  id="symptomItemValueSpan">&nbsp;您选择的症状如下是（可勾选一主症状）：<button id="buttonBtn" type="submit">自助诊断</button></span>
	<div style="margin-top: 5px;margin-left: 20px;" id="radioDiv"></div>
	
</div>

<div class="pageContent">
	<div class="tabs" currentIndex="0" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>望诊</span></a></li>
					<li><a href="javascript:;"><span>闻诊</span></a></li>
					<li><a href="javascript:;"><span>问诊</span></a></li>
					<li><a href="javascript:;"><span>切诊</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent" layoutH="102">
			<div  class="pageFormContent" style="height:90%">
				<c:forEach var="item" items="${symptomItemValueListXiaoer1}" varStatus="s">
				    <label>
				    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
				    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}"  data-toggle="popover" >${item.name}</a>
				    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
								<c:if test="${item.filepath != ''}">
								<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
								</c:if>
						</div>
				    </label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:90%">
			 	<c:forEach var="item" items="${symptomItemValueListXiaoer2}" varStatus="s">
				    <label>
				    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
				    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}"  data-toggle="popover" >${item.name}</a>
				    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
								<c:if test="${item.filepath != ''}">
								<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
								</c:if>
						</div>
				    </label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:90%">
				<c:forEach var="item" items="${symptomItemValueListXiaoer3}" varStatus="s">
				    <label>
				    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
				    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}"  data-toggle="popover" >${item.name}</a>
				    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
								<c:if test="${item.filepath != ''}">
								<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
								</c:if>
						</div>
				    </label>
				</c:forEach>
			</div>
			<div  class="pageFormContent" style="height:90%">
				<c:forEach var="item" items="${symptomItemValueListXiaoer4}" varStatus="s">
				    <label>
				    	<input type="checkbox" name="symptomItem" value="${item.id}" displayname="${item.name}" onclick=symptomitem.check(this,"${item.name}")  />
				    	<a id="${item.id}_a" onmouseover="show(this,${item.id})" onmouseout="hide(${item.id})" rel="popover" data-content="${item.remark}"  data-toggle="popover" >${item.name}</a>
				    	<div id="${item.id}" style="VISIBILITY:hidden;Z-INDEX:100;POSITION:absolute" onmouseover="show(i)" onmouseout="hide()">
								<c:if test="${item.filepath != ''}">
								<img src="<%=basePath%>images/item/${item.filepath }" width="120px"></img>
								</c:if>
						</div>
				    </label>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</form>

<script type="text/javascript" >
$(function (){ 
	$("[data-toggle='popover']").popover();
});
</script>
