package com.md.entity;

/**
 * 中成药库实体
 * 
 * @author owen
 */
public class DrugStore {

	private Long id;

	/*** 内科中成药name */
	private String drug_name;

	/*** 内科中成药code */
	private String drug_code;

	/** 药物成分 */
	private String drug_medicinal;

	/** 功效 */
	private String drug_func;

	/** 作用 */
	private String drug_area;

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

	public String getDrug_name() {
		return drug_name;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public String getDrug_code() {
		return drug_code;
	}

	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	public String getDrug_medicinal() {
		return drug_medicinal;
	}

	public void setDrug_medicinal(String drug_medicinal) {
		this.drug_medicinal = drug_medicinal;
	}

	public String getDrug_func() {
		return drug_func;
	}

	public void setDrug_func(String drug_func) {
		this.drug_func = drug_func;
	}

	public String getDrug_area() {
		return drug_area;
	}

	public void setDrug_area(String drug_area) {
		this.drug_area = drug_area;
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
