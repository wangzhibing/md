package com.md.entity;

/**
 * 留言板实体bean
 * 
 * @author wzb
 */
public class MessageBoard {

	private Long id;// #留言流水号

	private String title;// , #标题

	private String content;// #内容

	private String time;// #留言时间

	private Long customer_id;// #留言用户

	private String status;// # 1-正常、2-删除

	private String filepath1;// #附件1

	private String filepath2;// #附件2

	private String remark;// #备注

	/**
	 * 扩展属性
	 */
	private String customer_name;

	private String time_start;

	private String time_end;
	
	private String queryType; 

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}
