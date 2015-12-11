DROP TABLE IF EXISTS `md_drug_store`;
# 中药成品
CREATE TABLE `md_drug_store` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #ID
    `drug_name`  varchar(100) not null,  #内科中成药name
	`drug_code`  varchar(100) not null,  #内科中成药code
    `drug_medicinal`  varchar(500) not null , #药物成分
    `drug_func` varchar(200) NOT NULL ,   #功效
    `drug_area` varchar(30) NOT NULL,   #作用
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    `remark4` varchar(200),     #备注字段4   
    `remark5` varchar(200),     #备注字段5   
    `remark6` varchar(200),     #备注字段6 
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `md_interim_prescription`;
# 临时药方
CREATE TABLE `md_interim_prescription` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT, #ID
    `prescription_interim_code`  varchar(100) not null,  #interim_code
    `prescripdion_interim_name`  varchar(500) not null , #interim_name
    `prescription_interim_medicinal` varchar(200) NOT NULL ,   #interim_medicinal
    `drug_store_id` varchar(100) NOT NULL,   #临时药方对应的中药成品
    `remark1` varchar(200),     #备注字段1   
    `remark2` varchar(200),     #备注字段2   
    `remark3` varchar(200),     #备注字段3  
    `remark4` varchar(200),     #备注字段4   
    `remark5` varchar(200),     #备注字段5   
    `remark6` varchar(200),     #备注字段6 
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;
  