<%@ include file="/include.inc.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table class="table">
			<thead>
				<tr align="center"><th width="1580">中医系统的处方表格标准式样</th></tr>
			</thead>
		</table>
		<div class="pageFormContent" layoutH="76">
			<p>
				<label>姓名：</label>
				<label>XXX</label>
			</p>
			<p>
				<label>性别：</label>
				<label>男</label>
			</p>
			<p>
				<label>出生时间：</label>
				<label>1978-01-01</label>
			</p>
			<p>
				<label>出生地：</label>
				<label>重庆</label>
			</p>
			<p>
				<label>现住地：</label>
				<label>杭州</label>
			</p>
			<p>
				<label>身份证号码：</label>
				<label>XXXXXXXXXXXXXXX</label>
			</p>
			<p>
				<label>医保卡号：</label>
				<label>XXXXXXXXXXXX</label>
			</p>
			<p>
				<label>社保卡号：</label>
				<label>XXXXXXXX</label>
			</p>
			<p>
				<label>电话号码：</label>
				<label>1987654321</label>
			</p>
			<p>
				<label>本注册号码：</label>
				<label>4524254</label>
			</p>
			<p>
				<label>诊断结果：</label>
				<label>XXXXXXXX</label>
			</p>
			<p>
				<label>诊断流水ID：</label>
				<label>${diagnoseResult.diagnose_id }</label>
			</p>
			<p>
				<label>诊断结果时间：</label>
				<label>XXXXXXXXX</label>
			</p>
			
			<div class="divider"></div>
			<p>
				<label>内病位第一位（代码）：</label>
				<label>${diagnoseResult.in_bw_first_code }</label>
			</p>
			<p>
				<label>内病位第一位（中文名）：</label>
				<label>${diagnoseResult.in_bw_first_name }</label>
			</p>
			<p>
				<label>内病位第一位（数值）：</label>
				<label>${diagnoseResult.in_bw_first_value }</label>
			</p>
			<p>
				<label>内病位第二位（代码）：</label>
				<label>${diagnoseResult.in_bw_second_code }</label>
			</p>
			<p>
				<label>内病位第二位（中文名）：</label>
				<label>${diagnoseResult.in_bw_second_name }</label>
			</p>
			<p>
				<label>内病位第二位（数值）：</label>
				<label>${diagnoseResult.in_bw_second_value }</label>
			</p>
			<p>
				<label>内病因第一位（代码）：</label>
				<label>${diagnoseResult.in_by_first_code }</label>
			</p>
			<p>
				<label>内病因第一位（中文名）：</label>
				<label>${diagnoseResult.in_by_first_name }</label>
			</p>
			<p>
				<label>内病因第一位（数值）：</label>
				<label>${diagnoseResult.in_by_first_value }</label>
			</p>
			<p>
				<label>内病因第二位（代码）：</label>
				<label>${diagnoseResult.in_by_second_code }</label>
			</p>
			<p>
				<label>内病因第二位（中文名）：</label>
				<label>${diagnoseResult.in_by_second_name }</label>
			</p>
			<p>
				<label>内病因第二位（数值）：</label>
				<label>${diagnoseResult.in_by_second_value }</label>
			</p>
			
			<div class="divider"></div>
			<p>
				<label>外病位（代码）：</label>
				<label>${diagnoseResult.out_bw_code }</label>
			</p>
			<p>
				<label>外病位（中文名）：</label>
				<label>${diagnoseResult.out_bw_name }</label>
			</p>
			<p>
				<label>外病位（数值）：</label>
				<label>${diagnoseResult.out_bw_value }</label>
			</p>
			<p>
				<label>内病因（代码）：</label>
				<label>${diagnoseResult.out_by_code }</label>
			</p>
			<p>
				<label>内病因（中文名）：</label>
				<label>${diagnoseResult.out_by_name }</label>
			</p>
			<p>
				<label>内病因（数值）：</label>
				<label>${diagnoseResult.out_by_value }</label>
			</p>
			
			<div class="divider"></div>
			<p>
				<label>主要症状ID：</label>
				<label>${diagnoseResult.symptom_prescription_id }</label>
			</p>
			<p>
				<label>主要症状名称：</label>
				<label>${diagnoseResult.symptom_prescription_name }</label>
			</p>
			
			<div class="divider"></div>
			<p>
				<label>处方1（代码）：</label>
				<label>${diagnoseResult.prescription1_code }</label>
			</p>
			<p>
				<label>处方1（中文名）：</label>
				<label>${diagnoseResult.prescription1_name }</label>
			</p>
			<p>
				<label>处方1（对应药材）：</label>
				<label>${diagnoseResult.prescription1_medicinal }</label>
			</p>
			<p>
				<label>处方2（代码）：</label>
				<label>${diagnoseResult.prescription2_code }</label>
			</p>
			<p>
				<label>处方2（中文名）：</label>
				<label>${diagnoseResult.prescription2_name }</label>
			</p>
			<p>
				<label>处方2（对应药材）：</label>
				<label>${diagnoseResult.prescription2_medicinal }</label>
			</p>
			<p>
				<label>处方3（代码）：</label>
				<label>${diagnoseResult.prescription3_code }</label>
			</p>
			<p>
				<label>处方3（中文名）：</label>
				<label>${diagnoseResult.prescription3_name }</label>
			</p>
			<p>
				<label>处方3（对应药材）：</label>
				<label>${diagnoseResult.prescription3_medicinal }</label>
			</p>
			<p>
				<label>处方4（代码）：</label>
				<label>${diagnoseResult.prescription4_code }</label>
			</p>
			<p>
				<label>处方4（中文名）：</label>
				<label>${diagnoseResult.prescription4_name }</label>
			</p>
			<p>
				<label>处方4（对应药材）：</label>
				<label>${diagnoseResult.prescription4_medicinal }</label>
			</p>
			<p>
				<label>对应药材：</label>
				<label>${diagnoseResult.ac_medicinal }</label>
			</p>
			<p>
				<label>备注字段1：</label>
				<label>${diagnoseResult.remark1 }</label>
			</p>
			<p>
				<label>备注字段2：</label>
				<label>${diagnoseResult.remark2 }</label>
			</p>
			<p>
				<label>备注字段3：</label>
				<label>${diagnoseResult.remark3 }</label>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">打印</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
