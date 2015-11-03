#1、新增客户（医生）对应的医生签名，这块，后台管理员直接db维护  比如:王志兵   wzb.jpg
#   病人名称、病人年龄
alter table md_customer add doctor_sign_name varchar(50) default 'doc1.jgp';
alter table md_diagnose_result add sick_name varchar(50);
alter table md_diagnose_result add sick_age  int;


#2、