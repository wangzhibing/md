--新增留言板表--
DROP TABLE IF EXISTS `md_message_board`;
CREATE TABLE `md_message_board` (                              
    `id` bigint(20) NOT NULL AUTO_INCREMENT,  #留言流水号       
    `title` varchar(50) NOT NULL,      #标题         
    `content` varchar(300) NOT NULL,     #内容
    `time` varchar(14) NOT NULL,     #留言时间    
    `customer_id` varchar(20) NOT NULL,  #留言用户
    `status` char(1) not null default '1', # 1-正常、2-删除
    `filepath1` varchar(200),     #附件1  
    `filepath2` varchar(200),     #附件2     
    `remark` varchar(200),     #备注   
    PRIMARY KEY (`id`)                                   
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;