package com.md.entity;

/**
 * 户诊断信息表
 * 
 * @author owen
 */
public class Diagnose {
        //wanglei cccccccc
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT, #诊断流水号

	private Long customer_id;// bigint(20), #客户信息ID(customer表主键)

	private Long doctor_id;// bigint(20), #专家ID(customer表主键)

	private String diagnose_date;// varchar(8), #诊断日期

	private String diagnose_time;// varchar(6), #诊断时间
//wangzhibing cccc
	private String remark1;// varchar(50), #备注字段1

	private String remark2;// varchar(50), #备注字段2

	private String remark3;// varchar(50), #备注字段3

	private Integer channel_type; // 渠道类型 1：PC 2：APP

	private Integer apply_reply_status; // 1:未申请诊断 2：已申请诊断 3：专家已确诊

	private String reply_date;// varchar(8), #诊断日期

	private String reply_time;// varchar(6), #诊断时间

	private Integer is_look; // 1：未查看 2：已查看

	/*** 扩展属性 **/
	private String doctor_name; // 医生名称

	private String login_name; // 登录名

	private String customer_name; // 客户名称

	private String main_sysptom; // 主要症状

	private String less_sysptom; // 次要症状

	private String diagnose_date_start;

	private String diagnose_date_end;

	private String diagnse_result_id;

	private String prescription2_medicinal;

	private String in_bw_first_name;
	private String in_by_first_name;
	private String in_by_second_name;

	public String getPrescription2_medicinal() {
		return prescription2_medicinal;
	}

	public void setPrescription2_medicinal(String prescription2_medicinal) {
		this.prescription2_medicinal = prescription2_medicinal;
	}

	public String getIn_bw_first_name() {
		return in_bw_first_name;
	}

	public void setIn_bw_first_name(String in_bw_first_name) {
		this.in_bw_first_name = in_bw_first_name;
	}

	public String getIn_by_first_name() {
		return in_by_first_name;
	}

	public void setIn_by_first_name(String in_by_first_name) {
		this.in_by_first_name = in_by_first_name;
	}

	public String getIn_by_second_name() {
		return in_by_second_name;
	}

	public void setIn_by_second_name(String in_by_second_name) {
		this.in_by_second_name = in_by_second_name;
	}

	public Diagnose() {
	}

	/**
	 * 定义构造方法,对象初始化
	 * 
	 * @param customer_id
	 * @param diagnose_date
	 */
	public Diagnose(Long customer_id, String diagnose_date, String diagnose_time) {
		this.customer_id = customer_id;
		this.diagnose_date = diagnose_date;
		this.diagnose_time = diagnose_time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDiagnose_date() {
		return diagnose_date;
	}

	public void setDiagnose_date(String diagnose_date) {
		this.diagnose_date = diagnose_date;
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

	public String getDiagnose_time() {
		return diagnose_time;
	}

	public void setDiagnose_time(String diagnose_time) {
		this.diagnose_time = diagnose_time;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getMain_sysptom() {
		return main_sysptom;
	}

	public void setMain_sysptom(String main_sysptom) {
		this.main_sysptom = main_sysptom;
	}

	public String getLess_sysptom() {
		return less_sysptom;
	}

	public void setLess_sysptom(String less_sysptom) {
		this.less_sysptom = less_sysptom;
	}

	public String getDiagnose_date_start() {
		return diagnose_date_start;
	}

	public void setDiagnose_date_start(String diagnose_date_start) {
		this.diagnose_date_start = diagnose_date_start;
	}

	public String getDiagnose_date_end() {
		return diagnose_date_end;
	}

	public void setDiagnose_date_end(String diagnose_date_end) {
		this.diagnose_date_end = diagnose_date_end;
	}

	public String getDiagnse_result_id() {
		return diagnse_result_id;
	}

	public void setDiagnse_result_id(String diagnse_result_id) {
		this.diagnse_result_id = diagnse_result_id;
	}

	public Integer getChannel_type() {
		return channel_type;
	}

	public void setChannel_type(Integer channel_type) {
		this.channel_type = channel_type;
	}

	public String getReply_date() {
		return reply_date;
	}

	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply_time() {
		return reply_time;
	}

	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}

	public Integer getApply_reply_status() {
		return apply_reply_status;
	}

	public void setApply_reply_status(Integer apply_reply_status) {
		this.apply_reply_status = apply_reply_status;
	}

	public Integer getIs_look() {
		return is_look;
	}

	public void setIs_look(Integer is_look) {
		this.is_look = is_look;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

}
