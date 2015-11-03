#客户表新增 客户申请状态   1:初始状态  2:已申请/待审批  3：已审批 ，原先的customer_status状态，先摒弃，暂时不用。
alter table md_customer add apply_status int default 1;

#新增升级留痕表  deal_action 1：普通用户升级申请  2：管理员升级审批 3：管理员升级拒绝 4：管理员升级确认 5：管理员降级确认
DROP TABLE IF EXISTS `md_customer_applyinfo`;
CREATE TABLE `md_customer_applyinfo` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT,  #主键   
    `customer_id` bigint(20),   #客户信息ID(customer表主键)
    `customer_name` varchar(50),   #客户信息ID(customer表主键)
    `manager_customer_id` bigint(20),   #客户信息ID(customer表主键)
    `manager_customer_name` varchar(50),   #客户信息ID(customer表主键)
    `deal_action` int,   #处理方向  
    `deal_status_before` int,   #处理前状态  
    `deal_status_after` int,   #处理后状态
    `deal_date` varchar(8),   #处理日期  
    `deal_time` varchar(6),   #处理时间 
    `remark` varchar(200),     #处理理由  
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
