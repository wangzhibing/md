package com.md.entity;

import com.md.common.Constant;

/**
 * 客户诊断信明细表
 * 
 * @author owen
 */
public class DiagnoseDetail {

	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT, #诊断明细ID

	private Long diagnose_id;// bigint(20) not null, #客户诊断信息ID(md_diagnose表主键)

	private Long symptom_time_value_id;// bigint(20) not null,
										// #症状条目数值表ID(md_symptom_time_value主键)
	private String symptom_time_value_name ;//症状名称

	private String level; // 症状等级 1-主要症状 2-次要症状

	private String remark1;// varchar(50), #备注字段1

	private String remark2;// varchar(50), #备注字段2

	private String remark3;// varchar(50), #备注字段3

	public DiagnoseDetail() {
	};

	public DiagnoseDetail(Long diagnose_id, Long symptom_time_value_id,String symptom_time_value_name) {
		this.diagnose_id = diagnose_id;
		this.symptom_time_value_id = symptom_time_value_id;
		this.symptom_time_value_name = symptom_time_value_name;
		this.level = Constant.DIAGNOSE_DETAIL_LEVEL_2;
	};
	
	public DiagnoseDetail(Long diagnose_id, Long symptom_time_value_id,String symptom_time_value_name,String level) {
		this.diagnose_id = diagnose_id;
		this.symptom_time_value_id = symptom_time_value_id;
		this.symptom_time_value_name = symptom_time_value_name;
		this.level = level;
	};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDiagnose_id() {
		return diagnose_id;
	}

	public void setDiagnose_id(Long diagnose_id) {
		this.diagnose_id = diagnose_id;
	}

	public Long getSymptom_time_value_id() {
		return symptom_time_value_id;
	}

	public void setSymptom_time_value_id(Long symptom_time_value_id) {
		this.symptom_time_value_id = symptom_time_value_id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getSymptom_time_value_name() {
		return symptom_time_value_name;
	}

	public void setSymptom_time_value_name(String symptom_time_value_name) {
		this.symptom_time_value_name = symptom_time_value_name;
	}

}
