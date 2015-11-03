<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../login/head.jsp" %>
<script type="text/javascript" src="<%=basePath%>pages/customer/js/customerinfo.js"></script>
<div class="pageContent">
	<form method="post" action="<%=basePath%>md/customer/editCustomer.do" class="pageForm required-validate" onsubmit="return validateCallback(this);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">个人信息维护</th></tr>
			</thead>
		</table>
		
		<div class="pageFormContent" layoutH="76">
			<dl>
				<dt style="text-align: right;">姓名：</dt>
				<dd><input name="name" type="text" value="${loginCustomer.name}" readonly="readonly" /></dd>
				<input name="id" type="hidden" value="${loginCustomer.id}" />
			</dl>
			<dl>
				<dt style="text-align: right;">性别：</dt>
				<dd><input name="sexValue" type="text" readonly="readonly"  value="<c:if test="${loginCustomer.sex=='1'}">男性</c:if><c:if test="${sex=='2'}">女性</c:if>"/></dd>
			    <input name="sex" type="hidden"  value="${loginCustomer.sex}" />
			</dl>
			<dl>
				<dt style="text-align: right;">证件类型：</dt>
				<dd style="text-align: right;"><input type="text" readonly="readonly" value="身份证"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">证件号码：</dt>
				<dd><input name="card_no" type="text"  readonly="readonly" value="${loginCustomer.card_no}" /></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">出生年份：</dt>
				<dd><input type="text" name="birth" readonly="readonly" value="${loginCustomer.birth}"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">电话：</dt>
				<dd><input name="tel" type="text" value="${loginCustomer.tel}" /></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">用户名：</dt>
				<dd><input name="login_name" type="text" readonly="readonly" value="${loginCustomer.login_name}"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">医保卡号：</dt>
				<dd><input name="social_card_no" type="text" value="${loginCustomer.social_card_no}"/></dd>
			</dl>
			<dl>
				<dt style="text-align: right;">密码：</dt>
				<dd><input name="login_pwd" type="text" value="${loginCustomer.login_pwd}"/></dd>
			</dl>
			
			<%-- 动态密码验证
			<c:if test="${loginCustomer.customer_type =='1'}">
			<dl>
				<dt style="text-align: right;">升级状态：</dt>
				<c:if test="${loginCustomer.customer_status=='1' }">
				<dd><input name="customer_status" type="text" value="初始" readonly="readonly" /></dd>
				</c:if>
				<c:if test="${loginCustomer.customer_status=='2' }">
				<dd><input name="customer_status" type="text" value="待审批" readonly="readonly" /></dd>
				</c:if>
				<c:if test="${loginCustomer.customer_status=='3' }">
				<dd><input name="customer_status" type="text" value="待激活" readonly="readonly" /></dd>
				</c:if>
			</dl>
			</c:if> --%>
			
			
			<c:if test="${loginCustomer.customer_type =='1'}">
			<dl>
				<dt style="text-align: right;">升级状态：</dt>
				<c:if test="${loginCustomer.apply_status=='1' }">
				<dd><input name="customer_status" type="text" value="初始" readonly="readonly" /></dd>
				</c:if>
				<c:if test="${loginCustomer.apply_status=='2' }">
				<dd><input name="customer_status" type="text" value="待审批" readonly="readonly" /></dd>
				</c:if>
				<c:if test="${loginCustomer.apply_status=='3' }">
				<dd><input name="customer_status" type="text" value="已审批" readonly="readonly" /></dd>
				</c:if>
			</dl>
			</c:if>
			
			<dl class="nowrap">
				<dt style="text-align: right;">备注：</dt>
				<%-- <dd><input name="remark1" type="text" value="${loginCustomer.remark1}" /></dd> --%>
				<dd><textarea name="remark1"  cols="84" rows="2" >${loginCustomer.remark1}</textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt style="text-align: right;">地址：</dt>
				<dd><textarea name="address"  cols="84" rows="2" >${loginCustomer.address}</textarea></dd>
			</dl>
			
			<c:if test="${loginCustomer.customer_type =='1'}">
			<!-- <dl class="nowrap">
				<dt style="text-align: right;color: red;font-weight: bold;">用户升级流程：</dt>

				<dd><textarea name="address"  cols="84" rows="11" readonly="readonly" >1、手机移动终端输入“http://101.71.21.19:81/DTES”，进行下载并安装软件。
2、申请状态由“初始”=》“待审批”：个人信息维护页面，点击“申请升级”。
3、申请状态由“待审批”=》“待激活”：系统管理员对普通用户进行“系统关联(开户)”。
4、申请状态由“待激活”=》“升级成功”:
  4.1、客户登录“http://101.71.21.19:8080/dtlp/reg.jsp”（PC终端）。
  4.2、输入“企业”，“用户名”，“令牌激活码”，勾选“基于事件”及扫描二维码。
  4.3、企业（300019），用户名（用户登录名），令牌激活码（登录密码），详情电话咨询。
  4.4、点击“下一步”进行扫描。（手机移动终端扫描，根据提示操作）。
  4.5、扫描成功后，再点击“确认激活”。
  4.6、回到智能诊断系统，进入个人信息维护页面，点击“确认激活”。</textarea></dd>
			</dl> -->
			</c:if>
		</div>
		
		
		<div class="formBar">
			<ul>
				<%--  动态密码验证
				<c:if test="${loginCustomer.customer_status=='1' && loginCustomer.customer_type =='1'}">
					<li id="applyManagerButton"><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="applyManager(${loginCustomer.id})">申请升级</button></div></div></li>
				</c:if>
				<c:if test="${loginCustomer.customer_status=='3' && loginCustomer.customer_type =='1'}">
					<li id="applyManagerButton"><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="activeManager(${loginCustomer.id})">确认激活</button></div></div></li>
				</c:if> 
				--%>
				
				<c:if test="${loginCustomer.apply_status=='1' && loginCustomer.customer_type =='1'}">
					<li id="applyManagerButton"><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="applyManager(${loginCustomer.id})">升级为vip用户</button></div></div></li>
				</c:if>

				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
