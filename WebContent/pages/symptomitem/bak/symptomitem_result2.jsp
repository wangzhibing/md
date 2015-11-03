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
			<dl>
				<dt>姓名：</dt>
				<dt>XXX</dt>
			</dl>
			<dl>
				<dt>性别：</dt>
				<dt>男</dt>
			</dl>
			<dl>
				<dt>出生时间：</dt>
				<dt>1978-01-01</dt>
			</dl>
			<dl>
				<dt>出生地：</dt>
				<dt>重庆</dt>
			</dl>
			<dl>
				<dt>现住地：</dt>
				<dt>杭州</dt>
			</dl>
			<dl>
				<dt>身份证号码：</dt>
				<dt>XXXXXXXXXXXXXXX</dt>
			</dl>
			<dl>
				<dt>医保卡号：</dt>
				<dt>XXXXXXXXXXXX</dt>
			</dl>
			<dl>
				<dt>社保卡号：</dt>
				<dt>XXXXXXXX</dt>
			</dl>
			<dl>
				<dt>电话号码：</dt>
				<dt>1987654321</dt>
			</dl>
			<dl>
				<dt>本注册号码：</dt>
				<dt>4524254</dt>
			</dl>
			<dl>
				<dt>诊断结果：</dt>
				<dt>XXXXXXXX</dt>
			</dl>
			<dl>
				<dt>诊断流水ID：</dt>
				<dd>${diagnoseResult.diagnose_id }</dd>
			</dl>
			<dl>
				<dt>诊断结果时间：</dt>
				<dt>XXXXXXXXX</dt>
			</dl>
			
			<div class="divider"></div>
			<dl>
				<dt>内病位第一位（代码）：</dt>
				<dd>${diagnoseResult.in_bw_first_code }</dd>
			</dl>
			<dl>
				<dt>内病位第一位（中文名）：</dt>
				<dd>${diagnoseResult.in_bw_first_name }</dd>
			</dl>
			<dl>
				<dt>内病位第一位（数值）：</dt>
				<dd>${diagnoseResult.in_bw_first_value }</dd>
			</dl>
			<dl>
				<dt>内病位第二位（代码）：</dt>
				<dd>${diagnoseResult.in_bw_second_code }</dd>
			</dl>
			<dl>
				<dt>内病位第二位（中文名）：</dt>
				<dd>${diagnoseResult.in_bw_second_name }</dd>
			</dl>
			<dl>
				<dt>内病位第二位（数值）：</dt>
				<dd>${diagnoseResult.in_bw_second_value }</dd>
			</dl>
			<dl>
				<dt>内病因第一位（代码）：</dt>
				<dd>${diagnoseResult.in_by_first_code }</dd>
			</dl>
			<dl>
				<dt>内病因第一位（中文名）：</dt>
				<dd>${diagnoseResult.in_by_first_name }</dd>
			</dl>
			<dl>
				<dt>内病因第一位（数值）：</dt>
				<dd>${diagnoseResult.in_by_first_value }</dd>
			</dl>
			<dl>
				<dt>内病因第二位（代码）：</dt>
				<dd>${diagnoseResult.in_by_second_code }</dd>
			</dl>
			<dl>
				<dt>内病因第二位（中文名）：</dt>
				<dd>${diagnoseResult.in_by_second_name }</dd>
			</dl>
			<dl>
				<dt>内病因第二位（数值）：</dt>
				<dd>${diagnoseResult.in_by_second_value }</dd>
			</dl>
			
			<div class="divider"></div>
			<dl>
				<dt>外病位（代码）：</dt>
				<dd>${diagnoseResult.out_bw_code }</dd>
			</dl>
			<dl>
				<dt>外病位（中文名）：</dt>
				<dd>${diagnoseResult.out_bw_name }</dd>
			</dl>
			<dl>
				<dt>外病位（数值）：</dt>
				<dd>${diagnoseResult.out_bw_value }</dd>
			</dl>
			<dl>
				<dt>内病因（代码）：</dt>
				<dd>${diagnoseResult.out_by_code }</dd>
			</dl>
			<dl>
				<dt>内病因（中文名）：</dt>
				<dd>${diagnoseResult.out_by_name }</dd>
			</dl>
			<dl>
				<dt>内病因（数值）：</dt>
				<dd>${diagnoseResult.out_by_value }</dd>
			</dl>
			
			<div class="divider"></div>
			<dl>
				<dt>主要症状ID：</dt>
				<dd>${diagnoseResult.symptom_prescription_id }</dd>
			</dl>
			<dl>
				<dt>主要症状名称：</dt>
				<dd>${diagnoseResult.symptom_prescription_name }</dd>
			</dl>
			
			<div class="divider"></div>
			<dl>
				<dt>处方1（代码）：</dt>
				<dd>${diagnoseResult.prescription1_code }</dd>
			</dl>
			<dl>
				<dt>处方1（中文名）：</dt>
				<dd>${diagnoseResult.prescription1_name }</dd>
			</dl>
			<dl>
				<dt>处方1（对应药材）：</dt>
				<dd>${diagnoseResult.prescription1_medicinal }</dd>
			</dl>
			<dl>
				<dt>处方2（代码）：</dt>
				<dd>${diagnoseResult.prescription2_code }</dd>
			</dl>
			<dl>
				<dt>处方2（中文名）：</dt>
				<dd>${diagnoseResult.prescription2_name }</dd>
			</dl>
			<dl>
				<dt>处方2（对应药材）：</dt>
				<dd>${diagnoseResult.prescription2_medicinal }</dd>
			</dl>
			<dl>
				<dt>处方3（代码）：</dt>
				<dd>${diagnoseResult.prescription3_code }</dd>
			</dl>
			<dl>
				<dt>处方3（中文名）：</dt>
				<dd>${diagnoseResult.prescription3_name }</dd>
			</dl>
			<dl>
				<dt>处方3（对应药材）：</dt>
				<dd>${diagnoseResult.prescription3_medicinal }</dd>
			</dl>
			<dl>
				<dt>处方4（代码）：</dt>
				<dd>${diagnoseResult.prescription4_code }</dd>
			</dl>
			<dl>
				<dt>处方4（中文名）：</dt>
				<dd>${diagnoseResult.prescription4_name }</dd>
			</dl>
			<dl>
				<dt>处方4（对应药材）：</dt>
				<dd>${diagnoseResult.prescription4_medicinal }</dd>
			</dl>
			<dl>
				<dt>对应药材：</dt>
				<dd>${diagnoseResult.prescription_medicinal }</dd>
			</dl>
			<dl>
				<dt>备注字段1：</dt>
				<dd>${diagnoseResult.remark1 }</dd>
			</dl>
			<dl>
				<dt>备注字段2：</dt>
				<dd>${diagnoseResult.remark2 }</dd>
			</dl>
			<dl>
				<dt>备注字段3：</dt>
				<dd>${diagnoseResult.remark3 }</dd>
			</dl>
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
