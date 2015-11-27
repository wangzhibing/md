package com.md.entity;

/**
 * 病位实体
 * @author owen
 */
public class Bw {
        //bwbwbwbwbwbwbwbwbbwbbbw	
	private Long id;// ` bigint(20) NOT NULL AUTO_INCREMENT, #病位编码
	
	private String name;// ` varchar(50) NOT NULL, #病位名称
//ccccc	
	private String code;// ` varchar(10) NOT NULL, #病位代码
	
	private String remark1;// ` varchar(50), #备注字段1
	
	private String remark2;// ` varchar(50), #备注字段2
	
	private String remark3;// ` varchar(50), #备注字段3

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
