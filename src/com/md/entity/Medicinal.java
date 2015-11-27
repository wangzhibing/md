package com.md.entity;

/**
 * 药材信息
 * @author owen
 */
public class Medicinal {
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT, #药材流水
	
	private String code; // varchar(20) not null, #药材代码
	
	private String name;// varchar(20) not null, #药材名称
	
	private String type;// varchar(8) not null default '1' , #药材种类
	
	private String function;// varchar(200) not null , #药材功能
	
	private String filepath1;// varchar(50) , #药材图片展示地址，图片存在项目filepath路径下
	
	private String filepath2;// varchar(50) , #药材图片展示地址，图片存在项目filepath路径下
	
	private String remark1;// varchar(50), #备注字段1
	
	private String remark2;// varchar(50), #备注字段2
	
	private String remark3;// varchar(50), #备注字段3
	
	private String smell;//性味
	
	private String main_cure;//主治
	
        // wangzhibing vvvvvv	

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}

	public String getMain_cure() {
		return main_cure;
	}

	public void setMain_cure(String main_cure) {
		this.main_cure = main_cure;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}


	public String getFilepath1() {
		return filepath1;
	}

	public void setFilepath1(String filepath1) {
		this.filepath1 = filepath1;
	}

	public String getFilepath2() {
		return filepath2;
	}

	public void setFilepath2(String filepath2) {
		this.filepath2 = filepath2;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
