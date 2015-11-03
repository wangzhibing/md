package com.md.entity;

import org.apache.commons.lang.StringUtils;

/**
 * 基础处方表（基础数据表）
 * 
 * @author owen
 */
public class BasePrescriptionValue {

	private Long id; // 基础处方数值编码

	private String code; //A1X、A1XA3X

	private String name; // 基础处方名称 比如：面色白

	private String value1; // 基础处方数值1 比如：比如：hl=12

	private String value2; // 基础处方数值2 比如：F2ZJ=0.8

	private String value3; // 基础处方数值3 比如：F2ZJ=0.8

	private String value4; // 基础处方数值4 比如：F2ZJ=0.8

	private String value5; // 基础处方数值5 比如：F2ZJ=0.8

	private String value6; // 基础处方数值6 比如：F2ZJ=0.8

	private String value7; // 基础处方数值7 比如：F2ZJ=0.8

	private String value8; // 基础处方数值8 比如：F2ZJ=0.8

	private String value9; // 基础处方数值9 比如：F2ZJ=0.8

	private String value10; // 基础处方数值10 比如：F2ZJ=0.8

	private String spec_value_1; // 特殊症状处方1

	private String spec_value_1_action; // #特殊基础处方1行为

	private String spec_value_1_remark; // #特殊基础处方1备注

	private String spec_value_2; // #特殊基础处方2

	private String spec_value_2_action; // #特殊基础处方2行为

	private String spec_value_2_remark; // #特殊基础处方2备注

	private String spec_value_3; // #特殊基础处方3

	private String spec_value_3_action; // #特殊基础处方3行为

	private String spec_value_3_remark; // #特殊基础处方3备注

	private String remark1; // 备注字段1

	private String remark2; // 备注字段2

	private String remark3; // 备注字段3

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}

	public String getValue6() {
		return value6;
	}

	public void setValue6(String value6) {
		this.value6 = value6;
	}

	public String getValue7() {
		return value7;
	}

	public void setValue7(String value7) {
		this.value7 = value7;
	}

	public String getValue8() {
		return value8;
	}

	public void setValue8(String value8) {
		this.value8 = value8;
	}

	public String getValue9() {
		return value9;
	}

	public void setValue9(String value9) {
		this.value9 = value9;
	}

	public String getValue10() {
		return value10;
	}

	public void setValue10(String value10) {
		this.value10 = value10;
	}

	public String getSpec_value_1() {
		return spec_value_1;
	}

	public void setSpec_value_1(String spec_value_1) {
		this.spec_value_1 = spec_value_1;
	}

	public String getSpec_value_1_action() {
		return spec_value_1_action;
	}

	public void setSpec_value_1_action(String spec_value_1_action) {
		this.spec_value_1_action = spec_value_1_action;
	}

	public String getSpec_value_1_remark() {
		return spec_value_1_remark;
	}

	public void setSpec_value_1_remark(String spec_value_1_remark) {
		this.spec_value_1_remark = spec_value_1_remark;
	}

	public String getSpec_value_2() {
		return spec_value_2;
	}

	public void setSpec_value_2(String spec_value_2) {
		this.spec_value_2 = spec_value_2;
	}

	public String getSpec_value_2_action() {
		return spec_value_2_action;
	}

	public void setSpec_value_2_action(String spec_value_2_action) {
		this.spec_value_2_action = spec_value_2_action;
	}

	public String getSpec_value_2_remark() {
		return spec_value_2_remark;
	}

	public void setSpec_value_2_remark(String spec_value_2_remark) {
		this.spec_value_2_remark = spec_value_2_remark;
	}

	public String getSpec_value_3() {
		return spec_value_3;
	}

	public void setSpec_value_3(String spec_value_3) {
		this.spec_value_3 = spec_value_3;
	}

	public String getSpec_value_3_action() {
		return spec_value_3_action;
	}

	public void setSpec_value_3_action(String spec_value_3_action) {
		this.spec_value_3_action = spec_value_3_action;
	}

	public String getSpec_value_3_remark() {
		return spec_value_3_remark;
	}

	public void setSpec_value_3_remark(String spec_value_3_remark) {
		this.spec_value_3_remark = spec_value_3_remark;
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
	
	@Override
	public String toString(){
		String str = "";
		if(!StringUtils.isBlank(this.value1)){
			str += this.value1 + ",";		
		}
		if(!StringUtils.isBlank(this.value2)){
			str += this.value2 + ",";		
		}
		if(!StringUtils.isBlank(this.value3)){
			str += this.value3 + ",";		
		}
		if(!StringUtils.isBlank(this.value4)){
			str += this.value4 + ",";		
		}
		if(!StringUtils.isBlank(this.value5)){
			str += this.value5 + ",";		
		}
		if(!StringUtils.isBlank(this.value6)){
			str += this.value6 + ",";		
		}
		if(!StringUtils.isBlank(this.value7)){
			str += this.value7 + ",";		
		}
		if(!StringUtils.isBlank(this.value8)){
			str += this.value8 + ",";		
		}
		if(!StringUtils.isBlank(this.value9)){
			str += this.value9 + ",";		
		}
		if(!StringUtils.isBlank(this.value10)){
			str += this.value10 + ",";		
		}
		if(!StringUtils.isBlank(this.spec_value_1_remark)){
			str += this.spec_value_1_remark + ",";	
		}
		if(!StringUtils.isBlank(this.spec_value_2_remark)){
			str += this.spec_value_2_remark + ",";	
		}
		if(!StringUtils.isBlank(this.spec_value_3_remark)){
			str += this.spec_value_3_remark + ",";	
		}
		
		if(!StringUtils.isBlank(str)){
			str = str.substring(0, str.length()-1);
		}
		
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		BasePrescriptionValue sb = (BasePrescriptionValue) obj;
		return sb.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + id.hashCode();
		return result;
	}

}