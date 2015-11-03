package com.md.common;

/**
 * 常量定义
 * @author owen
 */
public interface Constant {
	
	/** 症状条目数值  **/
	public static final String SYMPTOM_ITEM_VALUE_1 = "1";   //头面五官部
	public static final String SYMPTOM_ITEM_VALUE_2 = "2";   //胸胁腰腹部 
	public static final String SYMPTOM_ITEM_VALUE_3 = "3";   //汗二阴二便 
	public static final String SYMPTOM_ITEM_VALUE_4 = "4";   //手足关节部
	public static final String SYMPTOM_ITEM_VALUE_5 = "5";   //把二十一脉
	
	/** 症状等级  **/
	public static final String DIAGNOSE_DETAIL_LEVEL_1 = "1";   //主要等级
	public static final String DIAGNOSE_DETAIL_LEVEL_2 = "2";   //次要等级
	
	/** 客户信息 目前系统没用session 用户信息暂时先指定某一值*/
	public static final Long ANONYMITY_CUSTOMER_ID = -1L;  //匿名用户
	public static final String ANONYMITY_CUSTOMER_CUSTOMER_NAME = "匿名";
	
	/** 时间格式定义*/
	public static final String PATTERN_1 = "yyyy-MM-dd";
	public static final String PATTERN_2 = "yyyy-MM-dd hh:mm:ss";
	public static final String PATTERN_3 = "yyyyMMdd";
	public static final String PATTERN_4 = "yyyyMMddHHmmss";
	public static final String PATTERN_5 = "HHmmss";
	
	/** 查询间隔日期*/
	public static final int queryDate = 7;
	
	/** 主要症状目前统一用G代替*/
	public static final String MAIN_PRESCRIPTION_CODE = "G";
	
	/** 药材操作行为，目前有以下几种 **/
	public static final String DEDICINAL_ACTION_1 = "1";  //先煎
	public static final String DEDICINAL_ACTION_2 = "2";  //后下
	public static final String DEDICINAL_ACTION_3 = "3";  //冲服
	public static final String DEDICINAL_ACTION_4 = "4";  //生用
	public static final String DEDICINAL_ACTION_5 = "5";  //磨粉
	public static final String DEDICINAL_ACTION_6 = "6";  //烊化
	public static final String DEDICINAL_ACTION_7 = "7";  //打碎煎 
	public static final String DEDICINAL_ACTION_8 = "8";  //研末冲服
	public static final String DEDICINAL_ACTION_9 = "9";  //布包煎
	public static final String DEDICINAL_ACTION_10 = "10";  //炒黑
	public static final String DEDICINAL_ACTION_11 = "11";  //打碎先煎 
	public static final String DEDICINAL_ACTION_12 = "12";  //醋炒
	public static final String DEDICINAL_ACTION_13 = "13";  //水煎服
	public static final String DEDICINAL_ACTION_14 = "14";  //盐水炒
	public static final String DEDICINAL_ACTION_15 = "15";  //后溶于药汁
	/**  设置药材行为默认值*/
	public static final int DEDICINAL_VALUE = 10000;
	
	/** 表单异步请求返回状态值*/
	public static final String STATUSCODE_SUCCESS = "200";  //操作成功
	public static final String STATUSCODE_ERROR = "300";  //操作失败
	public static final String STATUSCODE_TIMEOUT = "301";  //会话超时
	
	/** 客户级别 */
	public static final String CUSTOMER_TYPE_1 = "1" ;//一级普通客户（普通客户）  --普通注册
	public static final String CUSTOMER_TYPE_2 = "2" ;//二级普通客户（普通客户）  --认证/缴费
	public static final String CUSTOMER_TYPE_3 = "3" ;//普通管理员（管理员）          --管理者
	public static final String CUSTOMER_TYPE_4 = "4" ;//高级管理员（管理员）          --管理者
	public static final String CUSTOMER_TYPE_9 = "9" ;//加盟从业者                             --加盟从业者
	public static final String CUSTOMER_TYPE_10 = "10" ;//医生级别                           --值班医生/本院医生
	
	/** 渠道类型 */
	public static final int CHANNEL_TYPE_1 = 1;  //PC端
	public static final int CHANNEL_TYPE_2 = 2;  //APP
	
	
	/** 男女性别*/
	public static final int SEX_1 = 1 ;//男
	public static final int SEX_2 = 2 ;//女
	
	/** 证件类型*/
	public static final String CART_TYPE_1 = "1"; //身份证
	
	/** 初诊/复诊*/
	public static final int IS_FIRST_DIAGNOSE_1 = 1 ;//初诊
	public static final int IS_FIRST_DIAGNOSE_2 = 2 ;//复诊
	
	/** 用户session会话ID*/
	public static final String SESSION_ID = "loginCustomer";
	
	/** 用户登录结果*/
	public static final String LOGIN_MSG_ERROR = "系统不存在此用户信息,请核实(用户名/密码)";
	public static final String LOGIN_MSG_ERROR_1 = "只能登录普通用户，请核实登录页面";
	public static final String LOGIN_MSG_ERROR_3 = "只能登录管理员用户，请核实登录页面";
	public static final String LOGIN_MSG_ERROR_4 = "动态密码验证失败";
	public static final String LOGIN_MSG_SUCCES = "登录成功";
	public static final String LOGOUT_MSG_SUCCES = "退出成功";
	public static final String EDIT_SUCCESS = "操作成功";  //操作成功
	
	public static final String APPLY_MANAGER_MSG_EXISTS = "系统已经正在审批处理";
	
	public static final String APPLIED_MANAGER_MSG = "不符合审批条件";
	public static final String APPLIED_LOWER_MANAGER_MSG = "不符合降级条件";
	public static final String ACTIVE_MANAGER_MSG = "不符合激活条件";
	
	public static final String MANAGEREXPERT_LOWER_MANAGER_MSG = "不符合降级条件";
	public static final String MANAGEREXPERT_UP_MANAGER_MSG = "不符合升级条件";
	
	/** 用户状态  暂时先不用
	 *  1:初始状态 
	 *  2:后台已开户(客户申请成功) 
	 *  3:后台已关联(超级管理员关联成功) 
	 *  4:后台已注册(扫描、客户进行扫描成功，这时已经为管理员) 
	 ***/
	public static final String CUSTOMER_STATUS_1 = "1";
	public static final String CUSTOMER_STATUS_2 = "2";
	public static final String CUSTOMER_STATUS_3 = "3";
	public static final String CUSTOMER_STATUS_4 = "4";
	
	
	/**
	 *  用户申请状态
	 *  1:初始状态  
	 *  2:已申请/待审批  
	 *  3：已审批
	 */
	public static final String APPLY_STATUS_1 = "1";
	public static final String APPLY_STATUS_2 = "2";
	public static final String APPLY_STATUS_3 = "3";
	
	
	/**
	 *  知晓修改状态
	 *  1:已知晓修改 
	 *  2:已修改
	 */
	public static final String KNOW_STATUS_1 = "1";
	public static final String KNOW_STATUS_2 = "2";
	
	/**
	 * 处理方向  1：普通用户升级申请
	 *       2：普通用户升级审批
	 *       3：普通用户升级拒绝
	 *       4：普通用户升级确认
	 *       5：VIP用户降级确认
	 *       6：普通管理员/医生降级确认
	 *       7：普通用户升级普通管理员确认
	 *       8：普通用户升级医生确认
	 */
	public static final String DEAL_ACTION_1 = "1";
	public static final String DEAL_ACTION_2 = "2";
	public static final String DEAL_ACTION_3 = "3";
	public static final String DEAL_ACTION_4 = "4";
	public static final String DEAL_ACTION_5 = "5";
	public static final String DEAL_ACTION_6 = "6";
	public static final String DEAL_ACTION_7 = "7";
	public static final String DEAL_ACTION_8 = "8";
		
	
	/**动态密码相关配置*/
	public static final String DYNAMIC_COMPANY_ID = "300019";  //企业编号
	public static final String DYNAMIC_COMPANY_KEY = "5ff77e63a14246a58ebb70dd8744c85d" ;//企业秘钥
	public static final String DYNAMIC_WSDL = "http://101.71.21.19:8080/dtlp/ws/service?wsdl"; //远程服务WSDL地址
	
	/**望闻问切(1,2,3,4)*/
	public static final int DIAGNOSTIC_LOOK = 1;
	public static final int DIAGNOSTIC_SMELL = 2;
	public static final int DIAGNOSTIC_ASK = 3;
	public static final int DIAGNOSTIC_PULSE = 4;
	
	/** 医生上下线*/
	public static final int ONLINE_YES = 1;
	public static final int ONLINE_NO = 2;
	
	/** 病例诊断是否已回复*/
	//public static final int EXPERT_REPLY_YES = 1;
	//public static final int EXPERT_REPLY_NO = 2;
	
	/** 1:未申请诊断  2：已申请诊断  3：专家已确诊*/ 
	public static final int APPLY_REPLY_STATUS_1 = 1;
	public static final int APPLY_REPLY_STATUS_2 = 2;
	public static final int APPLY_REPLY_STATUS_3 = 3;
	
	/** 1:未查看  2：已查看*/ 
	public static final int CUSTOMER_IS_LOOK_1 = 1 ;
	public static final int CUSTOMER_IS_LOOK_2 = 2 ;
	
}
