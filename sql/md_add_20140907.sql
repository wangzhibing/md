--打增量版本
--症状表中添加性别字段,sex:1-男，2-女
alter table md_symptom_item_value add sex int not null default 1; 

--症状结果表中添加性别字段,sex:1-男，2-女 ,针对匿名用户，存储其性别
alter table md_diagnose_result add sex int not null default 1; 
--症状结果表中添加是否初诊字段,is_first_diagnose:1-初诊，2-复诊 ,针对匿名用户，存储其性别
alter table md_diagnose_result add is_first_diagnose int not null default 1; 


--客户表中添加 1:性别字段,sex:1-男，2-女   2:登录名称  3:登录密码
--客户信息表
DROP TABLE IF EXISTS `md_customer`;
CREATE TABLE `md_customer` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #客户ID
    `login_name`  varchar(30) not null,
    `login_pwd`  varchar(30) not null default '888888',
    `card_type` char(1) NOT NULL DEFAULT '1',   #证件类型，1-身份证
    `card_no` varchar(30) NOT NULL,   #证件号码
    `name` varchar(50) NOT NULL,    #客户名称
    `birth` varchar(8) NOT NULL,      #客户生日  
    `sex` int not null default 1,
    `age` int ,     #客户年龄
    `tel` varchar(20),     #联系电话   
    `address` varchar(200),     #居住地址   
    `social_card_no` varchar(50),     #社保卡号  
    `create_time` varchar(14) DEFAULT NULL, #创建时间
    `update_time` varchar(14) DEFAULT NULL, #修改时间  
    `customer_type` char(1) DEFAULT 1,  #1-普通客户
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    `remark4` varchar(200),     #备注字段4   
    `remark5` varchar(200),     #备注字段5   
    `remark6` varchar(200),     #备注字段6 
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;
  
  --系统初始添加一匿名用户信息、初始化数据，
  insert into `md_customer` (`id`, `login_name`, `login_pwd`, `card_type`, `card_no`, `name`, `birth`, `sex`, `age`, `tel`, `address`, `social_card_no`, `create_time`, `update_time`, `customer_type`, `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `remark6`) values('-1','匿名','匿名','1','111111111111','匿名','1987','1','100','13333333',NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL);

