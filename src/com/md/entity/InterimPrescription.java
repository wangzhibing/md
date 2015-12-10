package com.md.entity;

/**
 * 临时药方实体
 * 
 * @author owen
 */
public class InterimPrescription {

	private Long id;

	/** 临时药方code **/
	private String prescription_interim_code;

	/** 临时药方名称 **/
	private String prescripdion_interim_name;

	/** 临时药方处方 **/
	private String prescription_interim_medicinal;

	/*** 临时药方对应的中药成品 */
	private String drug_store_id;

	/** 备注字段1 */
	private String remark1;

	/** 备注字段2 */
	private String remark2;

	/** 备注字段3 */
	private String remark3;

	/** 备注字段4 */
	private String remark4;

	/** 备注字段5 */
	private String remark5;

	/** 备注字段6 */
	private String remark6;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrescription_interim_code() {
		return prescription_interim_code;
	}

	public void setPrescription_interim_code(String prescription_interim_code) {
		this.prescription_interim_code = prescription_interim_code;
	}

	public String getPrescripdion_interim_name() {
		return prescripdion_interim_name;
	}

	public void setPrescripdion_interim_name(String prescripdion_interim_name) {
		this.prescripdion_interim_name = prescripdion_interim_name;
	}

	public String getPrescription_interim_medicinal() {
		return prescription_interim_medicinal;
	}

	public void setPrescription_interim_medicinal(
			String prescription_interim_medicinal) {
		this.prescription_interim_medicinal = prescription_interim_medicinal;
	}

	public String getDrug_store_id() {
		return drug_store_id;
	}

	public void setDrug_store_id(String drug_store_id) {
		this.drug_store_id = drug_store_id;
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

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark5() {
		return remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark6() {
		return remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

}
