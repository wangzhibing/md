package com.md.entity;

/**
 * 客户升级留痕
 * 
 * @author owen
 * 
 */
public class CustomerApplyinfo {

	private Long id;// 主键

	private Long customer_id;// 客户信息ID(customer表主键)

	private String customer_name;

	private String manager_customer_name;

	private Long manager_customer_id;// 客户信息ID(customer表主键)

	private String deal_status_before;// 处理前状态

	private String deal_status_after;// 处理后状态

	private String deal_date;// 处理日期

	private String deal_time;// 处理时间

	private String remark;// 处理理由

	private String remark1;// 备注字段1

	private String remark2;// 备注字段2

	private String deal_action;

	/*** 扩展字段 **/
	private String deal_date_start;

	private String deal_date_end;

	public String getDeal_date_start() {
		return deal_date_start;
	}

	public void setDeal_date_start(String deal_date_start) {
		this.deal_date_start = deal_date_start;
	}

	public String getDeal_date_end() {
		return deal_date_end;
	}

	public void setDeal_date_end(String deal_date_end) {
		this.deal_date_end = deal_date_end;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeal_action() {
		return deal_action;
	}

	public void setDeal_action(String deal_action) {
		this.deal_action = deal_action;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getManager_customer_id() {
		return manager_customer_id;
	}

	public void setManager_customer_id(Long manager_customer_id) {
		this.manager_customer_id = manager_customer_id;
	}

	public String getDeal_status_before() {
		return deal_status_before;
	}

	public void setDeal_status_before(String deal_status_before) {
		this.deal_status_before = deal_status_before;
	}

	public String getDeal_status_after() {
		return deal_status_after;
	}

	public void setDeal_status_after(String deal_status_after) {
		this.deal_status_after = deal_status_after;
	}

	public String getDeal_date() {
		return deal_date;
	}

	public void setDeal_date(String deal_date) {
		this.deal_date = deal_date;
	}

	public String getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(String deal_time) {
		this.deal_time = deal_time;
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

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getManager_customer_name() {
		return manager_customer_name;
	}

	public void setManager_customer_name(String manager_customer_name) {
		this.manager_customer_name = manager_customer_name;
	}

}
