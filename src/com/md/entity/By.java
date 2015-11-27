package com.md.entity;

/**
 * 病因
 * 
 * @author owen
 */
public class By {
	//mmmmmmmmmm
	private Long id;// ` bigint(20) NOT NULL AUTO_INCREMENT, #病因编码
	
	private String type;// ` char(1) NOT NULL, #病因类型：1，内病因 2，外病因
	
	private String name;// ` varchar(50) NOT NULL, #病因名称
	
	private String code;// ` varchar(10) NOT NULL, #病因代码
	
	private String remark1;// ` varchar(50), #备注字段1
	
	private String remark2;// ` varchar(50), #备注字段2
	
	private String remark3;// ` varchar(50), #备注字段3

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

}
