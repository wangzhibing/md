package com.md.entity;

/**
 * 症状条目数值表
 * 
 * @author owen
 */
public class SymptomItemValue {

	private Long id; // 症状条目数值编码

	private String type; // 症状条目类型 1：头面五官部 2：胸胁腰腹部 3：汗二阴二便 4：手足关节部 5：把二十一脉

	private String name; // 症状条目名称 比如：面色白

	private String value1; // 症状条目数值1 比如：F2ZJ=0.8

	private String value2; // 症状条目数值2 比如：F2ZJ=0.8

	private String value3; // 症状条目数值3 比如：F2ZJ=0.8

	private String value4; // 症状条目数值4 比如：F2ZJ=0.8

	private String value5; // 症状条目数值5 比如：F2ZJ=0.8

	private String value6; // 症状条目数值6 比如：F2ZJ=0.8

	private String value7; // 症状条目数值7 比如：F2ZJ=0.8

	private String value8; // 症状条目数值8 比如：F2ZJ=0.8

	private String value9; // 症状条目数值9 比如：F2ZJ=0.8

	private String value10; // 症状条目数值10 比如：F2ZJ=0.8

	private String filepath; // 症状条目图片展示地址，图片存在项目filepath路径下

	private String remark; // 备注，症状的描述。

	private String remark1; // 备注字段1

	private String remark2; // 备注字段2

	private String remark3; // 备注字段3

	private Integer sex;  //1：男  2：女   3：男女皆可
	
	private Integer meimei; //1:望  2：闻   3：问   4：切
	
	private Integer xiaoer; //1:望  2：闻   3：问   4：切
	
	private Integer bama; //1:望  2：闻   3：问   4：切

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

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getMeimei() {
		return meimei;
	}

	public void setMeimei(Integer meimei) {
		this.meimei = meimei;
	}

	public Integer getXiaoer() {
		return xiaoer;
	}

	public void setXiaoer(Integer xiaoer) {
		this.xiaoer = xiaoer;
	}

	public Integer getBama() {
		return bama;
	}

	public void setBama(Integer bama) {
		this.bama = bama;
	}

	@Override
	public boolean equals(Object obj) {
		SymptomItemValue sb = (SymptomItemValue) obj;
		return sb.getId().equals(this.getId());
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + id.hashCode();
		return result;
	}

}