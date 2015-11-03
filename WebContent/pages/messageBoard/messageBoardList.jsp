<%@ include file="/include.inc.jsp"%>
<%@ include file="../login/head.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:import url="../pager/pagerForm.jsp"></c:import>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>


<div class="pageHeader">
<%-- action="<c:url value='<%=basePath%>md/medicinal/queryMedicinalData.do'/>" --%>
	<form method="post" rel="pagerForm" action="<%=basePath%>md/messageBoard/messageBoardForward.do" onsubmit="return navTabSearch(this)"> 
		<div class="searchBar"> 
			<table class="searchContent" >
				<tr>
				    <td>
						标题：
						<input type="text" name="title"  <%-- value="${messageBoard.title }" --%> id="queryValue"/>
					</td>
					<td>
						留言日期起：
						<input type="text" name="time_start" <%--  value="${messageBoard.time_start }" --%> class="date" readonly="readonly" id="startDate"/>
					</td>
					<td>
						至：
						<input type="text" name="time_end"  <%-- value="${messageBoard.time_end } --%> class="date" readonly="readonly"  id="endDate"/>
					</td>
				
				    <c:if test="${!empty loginCustomer}">
					<td>
						<select name="queryType" class="required combox">
							<option value="1">本人留言</option>
							<option value="2" selected>所有留言</option>
						</select>
					</td>
					</c:if>
					
					<td>
					<div class="subBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit" name="search">检索</button></div></div></li> 
						</ul>
					</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="<%=basePath%>md/messageBoard/queryMessageBoardDetail.do?messageBoardId={slt_objId}" target="navTab" rel="messageBoardDetailRel" mask="true"><span>留言详情</span></a></li>
		    <li><a class="icon" href="<%=basePath%>md/messageBoard/addMessageBoardJsp.do"  target="navTab" rel="messageBoardAddRel" mask="true"><span>我要留言</span></a></li>
		    <c:if test="${!empty loginCustomer && loginCustomer.customer_type=='3'}">
		        <li><a class="delete" href="<%=basePath%>md/messageBoard/delMessageBoard.do?messageBoardId={slt_objId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			</c:if>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="40"></th>
				<th width="120">标题</th>
				<th width="80">留言用户</th>
				<th width="100">留言时间</th>
				<th width="320">留言内容</th>
			</tr>
		</thead>
		<tbody>
			
		<c:forEach var="item" items="${messageBoardList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.title}</td>
				<td>${item.customer_name}</td>
				<td>${item.time}</td>
				<td>${item.content}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	<c:import url="../pager/panelBar.jsp"></c:import>
</div>
<script>
 
 $(document).ready(function(){
	 common.queryDate();

});
</script>
