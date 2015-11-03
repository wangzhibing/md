#药材表新增 性味、功能、主治三个字段
alter table md_medicinal add smell varchar(100) default '性平，味苦、酸';
alter table md_medicinal add main_cure varchar(100) default '腰膝酸痛，筋骨无力，经闭癓瘕，肝阳眩晕';