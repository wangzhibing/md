package com.md.entity;

/**
 * 客户信息实体
 * 
 * @author owen
 */
public class Customer {
	private Long id;// bigint(330) NOT NULL AUTO_INCREMENT,

	private String card_type;// varchar(2) NOT NULL DEFAULT '1',

	private String card_no;// varchar(30) NOT NULL,

	private String name;// archar(50) NOT NULL,

	private String birth;// archar(8) NOT NULL,

	private Integer age;// int(11) DEFAULT NULL,

	private Integer sex;// int(1) default :1-男，2-女

	private String tel;// varchar(20) DEFAULT NULL,

	private String address;// varchar(50) DEFAULT NULL,

	private String social_card_no;// varchar(50) DEFAULT NULL,

	private String create_time;

	private String update_time;

	private String customer_type; // 客户类型 1:非管理员，病客，2：管理员信息，

	private String remark1;// varchar(50) DEFAULT NULL,

	private String remark2;// varchar(50) DEFAULT NULL,

	private String remark3;// varchar(50) DEFAULT NULL,

	private String remark4;// varchar(50) DEFAULT NULL,

	private String remark5;// varchar(50) DEFAULT NULL,

	private String remark6;// varchar(50) DEFAULT NULL,

	/** 
	 * 暂时不用  TODO
	 * 1:初始状态 2:后台已开户(客户申请成功) 3:后台已关联(超级管理员关联成功) 4:后台已注册(扫描、客户进行扫描成功，这时已经为管理员)
	 */
	private String customer_status;

	/**
	 * 1:初始状态   2:已申请/待审批  3：已审批
	 */
	private String apply_status;

	private String apply_time;

	private String applied_time;

	private String login_name;

	private String login_pwd;

	private Integer is_on_line; // 是否在线 1：在 2：不在

	private String doctor_sign_name; // 医生会签名字 wzb.jpg xsl.jpg
	
	private String know_status;  //客户修改状态   1:已知晓修改  2:已修改  默认1

	/** 扩展字段 **/
	private String login_dynamic_pwd;

	private Integer waitingExpert; // 医生待确诊数量

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
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

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSocial_card_no() {
		return social_card_no;
	}

	public void setSocial_card_no(String social_card_no) {
		this.social_card_no = social_card_no;
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

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public String getLogin_dynamic_pwd() {
		return login_dynamic_pwd;
	}

	public void setLogin_dynamic_pwd(String login_dynamic_pwd) {
		this.login_dynamic_pwd = login_dynamic_pwd;
	}

	public String getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}

	public String getApply_time() {
		return apply_time;
	}

	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}

	public String getApplied_time() {
		return applied_time;
	}

	public void setApplied_time(String applied_time) {
		this.applied_time = applied_time;
	}

	public Integer getIs_on_line() {
		return is_on_line;
	}

	public void setIs_on_line(Integer is_on_line) {
		this.is_on_line = is_on_line;
	}

	public Integer getWaitingExpert() {
		return waitingExpert;
	}

	public void setWaitingExpert(Integer waitingExpert) {
		this.waitingExpert = waitingExpert;
	}

	public String getDoctor_sign_name() {
		return doctor_sign_name;
	}

	public void setDoctor_sign_name(String doctor_sign_name) {
		this.doctor_sign_name = doctor_sign_name;
	}

	public String getApply_status() {
		return apply_status;
	}

	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}

	public String getKnow_status() {
		return know_status;
	}

	public void setKnow_status(String know_status) {
		this.know_status = know_status;
	}

}
