####################create table ##################
#病位表 (基础数据表)
DROP TABLE IF EXISTS `md_bw`;
CREATE TABLE `md_bw` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT,  #病位ID       
    `name` varchar(50) NOT NULL,      #病位名称         
    `code` varchar(10) NOT NULL,     #病位代码
    `remark1` varchar(200),     #备注字段1    
    `remark2` varchar(200),     #备注字段2    
    `remark3` varchar(200),     #备注字段3   
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#病因表 (基础数据表)
DROP TABLE IF EXISTS `md_by`;
CREATE TABLE `md_by` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #病因ID
    `type` char(1) NOT NULL,    #病因类型：1，内病因  2，外病因
    `name` varchar(50) NOT NULL,      #病因名称          
    `code` varchar(10) NOT NULL,     #病因代码
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3   
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#症状条目数值表 (基础数据表)
#value1...value10参与计算求最大值，remark内容进行追加
DROP TABLE IF EXISTS `md_symptom_item_value`;
CREATE TABLE `md_symptom_item_value` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #症状条目数值ID
    `type` char(1) NOT NULL,    #症状条目类型 1：头面五官部 2：胸胁腰腹部 3：汗二阴二便 4：手足关节部 5：把二十一脉
    `name` varchar(50) NOT NULL,  #症状条目名称    比如：面色白     
    `value1` varchar(10) NOT NULL,   #症状条目数值1 比如：F2ZJ=0.8 
    `value2` varchar(10) ,   #症状条目数值2 比如：F2ZJ=0.8 
    `value3` varchar(10) ,   #症状条目数值3 比如：F2ZJ=0.8 
    `value4` varchar(10) ,   #症状条目数值4 比如：F2ZJ=0.8 
    `value5` varchar(10) ,   #症状条目数值5 比如：F2ZJ=0.8 
    `value6` varchar(10) ,   #症状条目数值6 比如：F2ZJ=0.8 
    `value7` varchar(10) ,   #症状条目数值7 比如：F2ZJ=0.8 
    `value8` varchar(10) ,   #症状条目数值8 比如：F2ZJ=0.8 
    `value9` varchar(10) ,   #症状条目数值9 比如：F2ZJ=0.8 
    `value10` varchar(10) ,   #症状条目数值10 比如：F2ZJ=0.8 
    `filepath` varchar(200) ,   #症状条目图片展示地址，图片存在项目filepath路径下
    `remark` varchar(200),   #症状条目备注  带有括号的  （草乌头  吴茱萸等分 研末 蜜调 敷足心）
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  
  
#症状处方表 (基础数据表)
#value1...value10参与计算求最大值，remark内容进行追加
DROP TABLE IF EXISTS `md_symptom_prescription_value`;
CREATE TABLE `md_symptom_prescription_value` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #主要症状ID
    `type` char(1) NOT NULL,    #症状类型 1：头面五官部 2：胸胁腰腹部 3：汗二阴二便 4：手足关节部 5：把二十一脉
    `name` varchar(50) NOT NULL,  #症状名称    比如：面色白     
    `value1` varchar(20) NOT NULL,   #症状处方1 比如：黄连12g => hl=12  单位必须为g 
    `value2` varchar(20) ,   #症状处方2 比如：黄连12g => hl=12
    `value3` varchar(20) ,   #症状处方3 比如：黄连12g => hl=12
    `value4` varchar(20) ,   #症状处方4 比如：黄连12g => hl=12 
    `value5` varchar(20) ,   #症状处方5 比如：黄连12g => hl=12  
    `value6` varchar(20) ,   #症状处方6 比如：黄连12g => hl=12 
    `value7` varchar(20) ,   #症状处方7 比如：黄连12g => hl=12 
    `value8` varchar(20) ,   #症状处方8 比如：黄连12g => hl=12 
    `value9` varchar(20) ,   #症状处方9 比如：黄连12g => hl=12 
    `value10` varchar(20) ,  #症状处方10 比如：黄连12g => hl=12 
    `spec_value_1` varchar(20) ,     #特殊症状处方1 
    `spec_value_1_action` varchar(2) ,   #特殊症状处方1行为 
    `spec_value_1_remark` varchar(200) ,   #特殊症状处方1备注
    `spec_value_2` varchar(20) ,     #特殊症状处方2 
    `spec_value_2_action` varchar(2) ,   #特殊症状处方2行为 
    `spec_value_2_remark` varchar(200) ,   #特殊症状处方2备注
    `spec_value_3` varchar(20) ,     #特殊症状处方3 
    `spec_value_3_action` varchar(2) ,   #特殊症状处方3行为 
    `spec_value_3_remark` varchar(200) ,   #特殊症状处方3备注
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  
  
#基本处方表 (基础数据表)
DROP TABLE IF EXISTS `md_base_prescription_value`;
CREATE TABLE `md_base_prescription_value` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #基本处方ID
    `code` varchar(10) NOT NULL,     #基本处方代码    比如:A1X
    `name` varchar(50) NOT NULL,     #基本处方名称    比如：肾阴虚    
    `value1` varchar(20) NOT NULL,   #基本处方1 比如：黄连12g => hl=12   
    `value2` varchar(20) ,   #基本处方2 比如：黄连12g => hl=12
    `value3` varchar(20) ,   #基本处方3 比如：黄连12g => hl=12
    `value4` varchar(20) ,   #基本处方4 比如：黄连12g => hl=12 
    `value5` varchar(20) ,   #基本处方5 比如：黄连12g => hl=12  
    `value6` varchar(20) ,   #基本处方6 比如：黄连12g => hl=12 
    `value7` varchar(20) ,   #基本处方7 比如：黄连12g => hl=12 
    `value8` varchar(20) ,   #基本处方8 比如：黄连12g => hl=12 
    `value9` varchar(20) ,   #基本处方9 比如：黄连12g => hl=12 
    `value10` varchar(20) ,  #基本处方10 比如：黄连12g => hl=12 
    `spec_value_1` varchar(20) ,     #特殊基本处方1 
    `spec_value_1_action` varchar(2) ,   #特殊基本处方1行为 
    `spec_value_1_remark` varchar(20) ,   #特殊基本处方1备注
    `spec_value_2` varchar(20) ,     #特殊基本处方2 
    `spec_value_2_action` varchar(2) ,   #特殊基本处方2行为 
    `spec_value_2_remark` varchar(20) ,   #特殊基本处方2备注
    `spec_value_3` varchar(20) ,     #特殊基本处方3 
    `spec_value_3_action` varchar(2) ,   #特殊基本处方3行为 
    `spec_value_3_remark` varchar(200) ,   #特殊基本处方3备注
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;  
  
  
  
  
#客户信息表
DROP TABLE IF EXISTS `md_customer`;
CREATE TABLE `md_customer` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #客户ID
    `card_type` char(1) NOT NULL DEFAULT '1',   #证件类型，1-身份证
    `card_no` varchar(30) NOT NULL,   #证件号码
    `name` varchar(50) NOT NULL,    #客户名称
    `birth` varchar(8) NOT NULL,      #客户生日          
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
  
  
#客户诊断信息表
DROP TABLE IF EXISTS `md_diagnose`;
CREATE TABLE `md_diagnose` (                      
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #诊断流水ID
    `customer_id` bigint(20),   #客户信息ID(customer表主键)
    `doctor_id` bigint(20) DEFAULT NULL, #专家ID
    `diagnose_date` varchar(8),   #诊断日期  
    `diagnose_time` varchar(6),   #诊断时间  
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;
  
  
#客户诊断信明细表
DROP TABLE IF EXISTS `md_diagnose_detail`;
CREATE TABLE `md_diagnose_detail` (                      
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #诊断明细ID
    `diagnose_id` bigint(20) not null,  #客户诊断信息ID(md_diagnose表主键)
    `symptom_time_value_id`  bigint(20) not null,  #症状条目数值表ID(md_symptom_time_value主键)
    `symptom_time_value_name`  varchar(50) not null,  #症状条目数值表ID(md_symptom_time_value)
    `level` char(1) default '2', #1-主要症状、2-次要症状
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
  
  
#客户诊断结果表
DROP TABLE IF EXISTS `md_diagnose_result`;
CREATE TABLE `md_diagnose_result` (                      
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #诊断结果ID
    `diagnose_id` bigint(20) not null,  #客户诊断信息ID(md_diagnose表主键)
    `customer_id` bigint(20) not null,   #客户ID(customer表主键)
    `diagnose_result_date` varchar(8),   #诊断结果日期
    `diagnose_result_time` varchar(6),   #诊断结果时间
    `in_bw_first_code` varchar(20) NOT NULL, #内病位第一位(代码)
    `in_bw_first_name` varchar(20) NOT NULL, #内病位第一位(中文名)
	`in_bw_first_value` float ,  #内病位第一位值(数值)
    `in_bw_second_code` varchar(20) , #内病位第二位(代码)
    `in_bw_second_name` varchar(20) , #内病位第二位(中文名)
	`in_bw_second_value` float ,  #内病位第二位(数值)
	`in_by_first_code` varchar(20) NOT NULL,  #内病因第一位(代码)
	`in_by_first_name` varchar(20) NOT NULL,  #内病因第一位(中文名)
	`in_by_first_value` float ,   #内病因第一位(数值)
	`in_by_second_code` varchar(20),   #内病因第二位(代码)
	`in_by_second_name` varchar(20),   #内病因第二位(中文名)
	`in_by_second_value` float ,   #内病因第二位(数值)
	`out_bw_code` varchar(20) ,    #外病位(代码)
	`out_bw_name` varchar(20) ,    #外病位(中文名)
	`out_bw_value` float ,    #外病位(数值)
	`out_by_code` varchar(20),   #外病因(代码)
	`out_by_name` varchar(20),   #外病因(中文名)
	`out_by_value` float ,   #外病因(数值)
	`symptom_prescription_id` bigint(20) ,  #主要症状ID(md_symptom_prescription_value表主键)
	`symptom_prescription_name` varchar(50) ,  #主要症状名称
	`prescription1_code` varchar(200) DEFAULT NULL,   #处方1
	`prescription1_name` varchar(200) DEFAULT NULL,   #处方1
	`prescription1_medicinal` varchar(400) DEFAULT NULL,   #处方1、 对应药材
	`prescription2_code` varchar(200) DEFAULT NULL,    #处方2
	`prescription2_name` varchar(200) DEFAULT NULL,    #处方2
	`prescription2_medicinal` varchar(400) DEFAULT NULL,   #处方2、 对应药材
	`prescription3_code` varchar(200) DEFAULT NULL,   #处方3
	`prescription3_name` varchar(200) DEFAULT NULL,   #处方3
	`prescription3_medicinal` varchar(400) DEFAULT NULL,   #处方3、 对应药材
	`prescription4_code` varchar(200) DEFAULT NULL,   #处方4
	`prescription4_name` varchar(200) DEFAULT NULL,   #处方4
	`prescription4_medicinal` varchar(400) DEFAULT NULL,   #处方4、 对应药材
	`ac_medicinal` varchar(400) DEFAULT NULL,   #对应药材
	`ad_medicinal` varchar(400) DEFAULT NULL,   #对应药材
	`bc_medicinal` varchar(400) DEFAULT NULL,   #对应药材
	`bd_medicinal` varchar(400) DEFAULT NULL,   #对应药材
	`ef_medicinal` varchar(400) DEFAULT NULL,   #对应药材
	`g_medicinal` varchar(400) DEFAULT NULL,   #对应药材
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
  
#药材表
DROP TABLE IF EXISTS `md_medicinal`;
CREATE TABLE `md_medicinal` (                      
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #药材ID
    `code` varchar(10) NOT NULL, #药材代码
    `name` varchar(20) not null,  #药材名称
    `type` varchar(50) not null, #药材种类 统一用中文显示
    `function` varchar(200) not null , #药材功能
    `filepath1` varchar(200) ,   #药材图片展示地址，图片存在项目filepath路径下
    `filepath2` varchar(200) ,   #药材图片展示地址，图片存在项目filepath路径下
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
  
  
##############init data
insert  into `md_symptom_item_value`(`id`,`type`,`name`,`value1`,`value2`,`value3`,`value4`,`value5`,`value6`,`value7`,`value8`,`value9`,`value10`,`filepath`,`remark`,`remark1`,`remark2`,`remark3`) 
 values (1,'1','面色白','','','','','','','','','','',NULL,'面色白',NULL,NULL,NULL),
        (2,'1','面色白带青','','','','','','','','','','',NULL,'面色白带青',NULL,NULL,NULL),
        (3,'1','面色黄色鲜','','','','','','','','','','',NULL,'面色黄色鲜',NULL,NULL,NULL),
        (4,'1','面色淡黄萎黄','','','','','','','','','','',NULL,'面色淡黄萎黄',NULL,NULL,NULL),
        (5,'1','面色红如醉','','','','','','','','','','',NULL,'面色红如醉',NULL,NULL,NULL),
        (6,'1','午后颧红','','','','','','','','','','',NULL,'午后颧红',NULL,NULL,NULL),
        (7,'1','面嫩红带白如妆','','','','','','','','','','',NULL,'面嫩红带白如妆',NULL,NULL,NULL),
        (8,'1','面色青带黑','','','','','','','','','','',NULL,'面色青带黑',NULL,NULL,NULL),
        (9,'1','面色青带红','','','','','','','','','','',NULL,'面色青带红',NULL,NULL,NULL),
        (10,'1','面青(唇、指甲青)','','','','','','','','','','',NULL,'面青(唇、指甲青)',NULL,NULL,NULL),
        (11,'1','面色黑','','','','','','','','','','',NULL,'面色黑',NULL,NULL,NULL),
        (12,'1','面色黑带淡黄','','','','','','','','','','',NULL,'面色黑带淡黄',NULL,NULL,NULL),
        (13,'1','面色黑带深黄','','','','','','','','','','',NULL,'面色黑带深黄',NULL,NULL,NULL),
        (14,'1','面色黑青暗淡','','','','','','','','','','',NULL,'面色黑青暗淡',NULL,NULL,NULL),
        (15,'1','发落枯黄干（小儿发枯黄同）','','','','','','','','','','',NULL,'发落枯黄干（小儿发枯黄同）',NULL,NULL,NULL),
        (16,'1','面色青带红','','','','','','','','','','',NULL,'面色青带红',NULL,NULL,NULL),
        (17,'1','少年白发','','','','','','','','','','',NULL,'少年白发',NULL,NULL,NULL),
        (18,'2','胁痛胁胀','','','','','','','','','','',NULL,'胁痛胁胀',NULL,NULL,NULL),
        (19,'2','胸胁刺痛（胸痛、心前区隐痛）','','','','','','','','','','',NULL,'胸胁刺痛（胸痛、心前区隐痛）',NULL,NULL,NULL),
        (20,'2','心前区绞痛','','','','','','','','','','',NULL,'心前区绞痛',NULL,NULL,NULL),
        (21,'2','胸胁牵引痛（放射到右肩）','','','','','','','','','','',NULL,'胸胁牵引痛（放射到右肩）',NULL,NULL,NULL),
        (22,'2','胸胁胀满闷','','','','','','','','','','',NULL,'胸胁胀满闷',NULL,NULL,NULL),
        (23,'2','胸胁窒闷（气闷）','','','','','','','','','','',NULL,'胸胁窒闷（气闷）',NULL,NULL,NULL),
        (24,'2','心跳过速','','','','','','','','','','',NULL,'心跳过速',NULL,NULL,NULL),
        (25,'2','心慌（心悸）','','','','','','','','','','',NULL,'心慌（心悸）',NULL,NULL,NULL),
        (26,'2','自觉闷乱不宁（心中懊侬）','','','','','','','','','','',NULL,'自觉闷乱不宁（心中懊侬）',NULL,NULL,NULL),
        (27,'2','胸闷','','','','','','','','','','',NULL,'胸闷',NULL,NULL,NULL),
        (28,'2','胸痞','','','','','','','','','','',NULL,'胸痞',NULL,NULL,NULL),
        (29,'3','醒时出汗（自汗）','','','','','','','','','','',NULL,'醒时出汗（自汗）',NULL,NULL,NULL),
        (30,'3','睡时出汗（盗汗）','','','','','','','','','','',NULL,'睡时出汗（盗汗）',NULL,NULL,NULL),
        (31,'3','微汗','','','','','','','','','','',NULL,'微汗',NULL,NULL,NULL),
        (32,'3','大汗（大汗不止）','','','','','','','','','','',NULL,'大汗（大汗不止）',NULL,NULL,NULL),
        (33,'3','粘手汗（汗出如油）','','','','','','','','','','',NULL,'粘手汗（汗出如油）',NULL,NULL,NULL),
        (34,'3','黄汗','','','','','','','','','','',NULL,'黄汗',NULL,NULL,NULL),
        (35,'3','动则汗出','','','','','','','','','','',NULL,'动则汗出',NULL,NULL,NULL),
        (36,'3','尿少而肿（小便闭）','','','','','','','','','','',NULL,'尿少而肿（小便闭）',NULL,NULL,NULL),
        (37,'4','急惊风（手足抽搐、痉病）','','','','','','','','','','',NULL,'急惊风（手足抽搐、痉病）',NULL,NULL,NULL),
        (38,'4','小儿慢惊风','','','','','','','','','','',NULL,'小儿慢惊风',NULL,NULL,NULL),
        (39,'4','足未痿不能行（痿病）','','','','','','','','','','',NULL,'足未痿不能行（痿病）',NULL,NULL,NULL),
        (40,'4','肉已痿不能行（痿病）','','','','','','','','','','',NULL,'肉已痿不能行（痿病）',NULL,NULL,NULL),
        (41,'4','手足拘急（鸡爪风）','','','','','','','','','','',NULL,'手足拘急（鸡爪风）',NULL,NULL,NULL),
        (42,'4','屈而不伸','','','','','','','','','','',NULL,'屈而不伸',NULL,NULL,NULL),
        (43,'4','伸而不屈（四肢僵直）','','','','','','','','','','',NULL,'伸而不屈（四肢僵直）',NULL,NULL,NULL),
        (44,'4','手足颤抖','','','','','','','','','','',NULL,'手足颤抖',NULL,NULL,NULL),
        (45,'4','站坐不稳','','','','','','','','','','',NULL,'站坐不稳',NULL,NULL,NULL),
        (46,'5','浮脉','','','','','','','','','','',NULL,'浮脉',NULL,NULL,NULL),
        (47,'5','洪脉','','','','','','','','','','',NULL,'洪脉',NULL,NULL,NULL),
        (48,'5','濡脉','','','','','','','','','','',NULL,'濡脉',NULL,NULL,NULL),
        (49,'5','芤脉','','','','','','','','','','',NULL,'芤脉',NULL,NULL,NULL),
        (50,'5','沉脉','','','','','','','','','','',NULL,'沉脉',NULL,NULL,NULL),
        (51,'5','弱脉','','','','','','','','','','',NULL,'弱脉',NULL,NULL,NULL),
        (52,'5','迟脉','','','','','','','','','','',NULL,'迟脉',NULL,NULL,NULL);

