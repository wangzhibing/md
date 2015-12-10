package com.md.entity;

/**
 * 客户诊断结果表
 * 
 * @author owen
 */
public class DiagnoseResult {

	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT, #诊断结果ID

	private Long diagnose_id;// bigint(20) not null, #客户诊断信息ID(md_diagnose表主键)

	private Long customer_id;// bigint(20) not null, #客户信息ID(customer表主键)

	private String diagnose_result_date;// varchar(14), #诊断结果时间

	private String diagnose_result_time;// varchar

	private String in_bw_first_code;// varchar(20) not null, #内病位第一位

	private String in_bw_first_name;// varchar(20) not null, #内病位第一位

	private Float in_bw_first_value;

	private String in_bw_second_code;// varchar(20) not null, #内病位第二位

	private String in_bw_second_name;// varchar(20) not null, #内病位第二位

	private Float in_bw_second_value;

	private String in_by_first_code;// varchar(20) not null, #内病因第一位

	private String in_by_first_name;// varchar(20) not null, #内病因第一位

	private Float in_by_first_value;

	private String in_by_second_code;// varchar(20) not null, #内病因第二位

	private String in_by_second_name;// varchar(20) not null, #内病因第二位

	private Float in_by_second_value;

	private String out_bw_code;// varchar(20) not null, #外病位

	private String out_bw_name;// varchar(20) not null, #外病位

	private Float out_bw_value;

	private String out_by_code;// varchar(20) not null, #外病因

	private String out_by_name;// varchar(20) not null, #外病因

	private Float out_by_value;

	private Long symptom_prescription_id; // 主要症状ID

	private String symptom_prescription_name; // 主要症状名称

	private String prescription1_code;// varchar(200), #处方1

	private String prescription1_name;// varchar(200), #处方1

	private String prescription1_medicinal;// varchar(200), #处方1(对用药材)

	private String prescription2_code;// varchar(200), #处方2

	private String prescription2_name;// varchar(200), #处方2

	private String prescription2_medicinal;// varchar(200), #处方2(对用药材)

	private String prescription3_code;// varchar(200), #处方3

	private String prescription3_name;// varchar(200), #处方3

	private String prescription3_medicinal;// varchar(200), #处方3(对用药材)

	private String prescription4_code;// varchar(200), #处方4

	private String prescription4_name;// varchar(200), #处方4

	private String prescription4_medicinal;// varchar(200), #处方4(对用药材)

	private String prescription5_code;// varchar(200), #处方5

	private String prescription5_name;// varchar(200), #处方5

	private String prescription5_medicinal;// varchar(200), #处方5(对用药材)

	private String prescription6_medicinal;// 医生确诊处方信息

	private String ac_medicinal;

	private String ad_medicinal;

	private String bc_medicinal;

	private String bd_medicinal;

	private String ef_medicinal;

	private String g_medicinal;

	private String remark1;// varchar(50), #备注字段1

	private String remark2;// varchar(50), #备注字段2

	private String remark3;// varchar(50), #备注字段3

	private Integer sex;

	private Integer is_first_diagnose; // 是否初诊

	private String report; // 主诉

	private String medical_history; // 病史

	private String sick_name; // 病人名称

	private Integer sick_age; // 病人年龄

	// 扩展属性
	private String lessSymptomValue; // 次要症状

	/** 临时处方 **/
	private String prescription_interim_code;// #临时处方

	private String prescription_interim_name;// #临时处方

	private String prescription_interim_medicinal;// #临时处方(对用药材)

	private String prescription_interim_medicinal_origin; // 临时药方，不带单位

	public Integer getIs_first_diagnose() {
		return is_first_diagnose;
	}

	public void setIs_first_diagnose(Integer is_first_diagnose) {
		this.is_first_diagnose = is_first_diagnose;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

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

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getDiagnose_result_date() {
		return diagnose_result_date;
	}

	public void setDiagnose_result_date(String diagnose_result_date) {
		this.diagnose_result_date = diagnose_result_date;
	}

	public String getIn_bw_first_code() {
		return in_bw_first_code;
	}

	public void setIn_bw_first_code(String in_bw_first_code) {
		this.in_bw_first_code = in_bw_first_code;
	}

	public String getIn_bw_first_name() {
		return in_bw_first_name;
	}

	public void setIn_bw_first_name(String in_bw_first_name) {
		this.in_bw_first_name = in_bw_first_name;
	}

	public Float getIn_bw_first_value() {
		return in_bw_first_value;
	}

	public void setIn_bw_first_value(Float in_bw_first_value) {
		this.in_bw_first_value = in_bw_first_value;
	}

	public String getIn_bw_second_code() {
		return in_bw_second_code;
	}

	public void setIn_bw_second_code(String in_bw_second_code) {
		this.in_bw_second_code = in_bw_second_code;
	}

	public String getIn_bw_second_name() {
		return in_bw_second_name;
	}

	public void setIn_bw_second_name(String in_bw_second_name) {
		this.in_bw_second_name = in_bw_second_name;
	}

	public Float getIn_bw_second_value() {
		return in_bw_second_value;
	}

	public void setIn_bw_second_value(Float in_bw_second_value) {
		this.in_bw_second_value = in_bw_second_value;
	}

	public String getIn_by_first_code() {
		return in_by_first_code;
	}

	public void setIn_by_first_code(String in_by_first_code) {
		this.in_by_first_code = in_by_first_code;
	}

	public String getIn_by_first_name() {
		return in_by_first_name;
	}

	public void setIn_by_first_name(String in_by_first_name) {
		this.in_by_first_name = in_by_first_name;
	}

	public Float getIn_by_first_value() {
		return in_by_first_value;
	}

	public void setIn_by_first_value(Float in_by_first_value) {
		this.in_by_first_value = in_by_first_value;
	}

	public String getIn_by_second_code() {
		return in_by_second_code;
	}

	public void setIn_by_second_code(String in_by_second_code) {
		this.in_by_second_code = in_by_second_code;
	}

	public String getIn_by_second_name() {
		return in_by_second_name;
	}

	public void setIn_by_second_name(String in_by_second_name) {
		this.in_by_second_name = in_by_second_name;
	}

	public Float getIn_by_second_value() {
		return in_by_second_value;
	}

	public void setIn_by_second_value(Float in_by_second_value) {
		this.in_by_second_value = in_by_second_value;
	}

	public String getOut_bw_code() {
		return out_bw_code;
	}

	public void setOut_bw_code(String out_bw_code) {
		this.out_bw_code = out_bw_code;
	}

	public String getOut_bw_name() {
		return out_bw_name;
	}

	public void setOut_bw_name(String out_bw_name) {
		this.out_bw_name = out_bw_name;
	}

	public Float getOut_bw_value() {
		return out_bw_value;
	}

	public void setOut_bw_value(Float out_bw_value) {
		this.out_bw_value = out_bw_value;
	}

	public String getOut_by_code() {
		return out_by_code;
	}

	public void setOut_by_code(String out_by_code) {
		this.out_by_code = out_by_code;
	}

	public String getOut_by_name() {
		return out_by_name;
	}

	public void setOut_by_name(String out_by_name) {
		this.out_by_name = out_by_name;
	}

	public Float getOut_by_value() {
		return out_by_value;
	}

	public void setOut_by_value(Float out_by_value) {
		this.out_by_value = out_by_value;
	}

	public String getPrescription1_code() {
		return prescription1_code;
	}

	public void setPrescription1_code(String prescription1_code) {
		this.prescription1_code = prescription1_code;
	}

	public String getPrescription1_name() {
		return prescription1_name;
	}

	public void setPrescription1_name(String prescription1_name) {
		this.prescription1_name = prescription1_name;
	}

	public String getPrescription1_medicinal() {
		return prescription1_medicinal;
	}

	public void setPrescription1_medicinal(String prescription1_medicinal) {
		this.prescription1_medicinal = prescription1_medicinal;
	}

	public String getPrescription2_code() {
		return prescription2_code;
	}

	public void setPrescription2_code(String prescription2_code) {
		this.prescription2_code = prescription2_code;
	}

	public String getPrescription2_name() {
		return prescription2_name;
	}

	public void setPrescription2_name(String prescription2_name) {
		this.prescription2_name = prescription2_name;
	}

	public String getPrescription2_medicinal() {
		return prescription2_medicinal;
	}

	public void setPrescription2_medicinal(String prescription2_medicinal) {
		this.prescription2_medicinal = prescription2_medicinal;
	}

	public String getPrescription3_code() {
		return prescription3_code;
	}

	public void setPrescription3_code(String prescription3_code) {
		this.prescription3_code = prescription3_code;
	}

	public String getPrescription3_name() {
		return prescription3_name;
	}

	public void setPrescription3_name(String prescription3_name) {
		this.prescription3_name = prescription3_name;
	}

	public String getPrescription3_medicinal() {
		return prescription3_medicinal;
	}

	public void setPrescription3_medicinal(String prescription3_medicinal) {
		this.prescription3_medicinal = prescription3_medicinal;
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

	public Long getSymptom_prescription_id() {
		return symptom_prescription_id;
	}

	public void setSymptom_prescription_id(Long symptom_prescription_id) {
		this.symptom_prescription_id = symptom_prescription_id;
	}

	public String getSymptom_prescription_name() {
		return symptom_prescription_name;
	}

	public void setSymptom_prescription_name(String symptom_prescription_name) {
		this.symptom_prescription_name = symptom_prescription_name;
	}

	public String getPrescription4_code() {
		return prescription4_code;
	}

	public void setPrescription4_code(String prescription4_code) {
		this.prescription4_code = prescription4_code;
	}

	public String getPrescription4_name() {
		return prescription4_name;
	}

	public void setPrescription4_name(String prescription4_name) {
		this.prescription4_name = prescription4_name;
	}

	public String getPrescription4_medicinal() {
		return prescription4_medicinal;
	}

	public void setPrescription4_medicinal(String prescription4_medicinal) {
		this.prescription4_medicinal = prescription4_medicinal;
	}

	public String getAc_medicinal() {
		return ac_medicinal;
	}

	public void setAc_medicinal(String ac_medicinal) {
		this.ac_medicinal = ac_medicinal;
	}

	public String getAd_medicinal() {
		return ad_medicinal;
	}

	public void setAd_medicinal(String ad_medicinal) {
		this.ad_medicinal = ad_medicinal;
	}

	public String getBc_medicinal() {
		return bc_medicinal;
	}

	public void setBc_medicinal(String bc_medicinal) {
		this.bc_medicinal = bc_medicinal;
	}

	public String getBd_medicinal() {
		return bd_medicinal;
	}

	public void setBd_medicinal(String bd_medicinal) {
		this.bd_medicinal = bd_medicinal;
	}

	public String getEf_medicinal() {
		return ef_medicinal;
	}

	public void setEf_medicinal(String ef_medicinal) {
		this.ef_medicinal = ef_medicinal;
	}

	public String getG_medicinal() {
		return g_medicinal;
	}

	public void setG_medicinal(String g_medicinal) {
		this.g_medicinal = g_medicinal;
	}

	public String getDiagnose_result_time() {
		return diagnose_result_time;
	}

	public void setDiagnose_result_time(String diagnose_result_time) {
		this.diagnose_result_time = diagnose_result_time;
	}

	public String getLessSymptomValue() {
		return lessSymptomValue;
	}

	public void setLessSymptomValue(String lessSymptomValue) {
		this.lessSymptomValue = lessSymptomValue;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getMedical_history() {
		return medical_history;
	}

	public void setMedical_history(String medical_history) {
		this.medical_history = medical_history;
	}

	public String getPrescription5_code() {
		return prescription5_code;
	}

	public void setPrescription5_code(String prescription5_code) {
		this.prescription5_code = prescription5_code;
	}

	public String getPrescription5_name() {
		return prescription5_name;
	}

	public void setPrescription5_name(String prescription5_name) {
		this.prescription5_name = prescription5_name;
	}

	public String getPrescription5_medicinal() {
		return prescription5_medicinal;
	}

	public void setPrescription5_medicinal(String prescription5_medicinal) {
		this.prescription5_medicinal = prescription5_medicinal;
	}

	public String getPrescription6_medicinal() {
		return prescription6_medicinal;
	}

	public void setPrescription6_medicinal(String prescription6_medicinal) {
		this.prescription6_medicinal = prescription6_medicinal;
	}

	public String getSick_name() {
		return sick_name;
	}

	public void setSick_name(String sick_name) {
		this.sick_name = sick_name;
	}

	public Integer getSick_age() {
		return sick_age;
	}

	public void setSick_age(Integer sick_age) {
		this.sick_age = sick_age;
	}

	public String getPrescription_interim_code() {
		return prescription_interim_code;
	}

	public void setPrescription_interim_code(String prescription_interim_code) {
		this.prescription_interim_code = prescription_interim_code;
	}

	public String getPrescription_interim_name() {
		return prescription_interim_name;
	}

	public void setPrescription_interim_name(String prescription_interim_name) {
		this.prescription_interim_name = prescription_interim_name;
	}

	public String getPrescription_interim_medicinal() {
		return prescription_interim_medicinal;
	}

	public void setPrescription_interim_medicinal(
			String prescription_interim_medicinal) {
		this.prescription_interim_medicinal = prescription_interim_medicinal;
	}

	public String getPrescription_interim_medicinal_origin() {
		return prescription_interim_medicinal_origin;
	}

	public void setPrescription_interim_medicinal_origin(
			String prescription_interim_medicinal_origin) {
		this.prescription_interim_medicinal_origin = prescription_interim_medicinal_origin;
	}

}
