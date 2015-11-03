#1、诊断结果表，加入处方5字段。
alter table md_diagnose_result add prescription5_code varchar(200);
alter table md_diagnose_result add prescription5_name varchar(200);
alter table md_diagnose_result add prescription5_medicinal varchar(400);

#2、修改客户类型长度
alter table md_customer modify customer_type varchar(4) null;

#3、诊断表，添加确诊日期时间
alter table md_diagnose add reply_date varchar(8);
alter table md_diagnose add reply_time varchar(6);

#4、诊断结果表，新增医生确诊处方
alter table md_diagnose_result add prescription6_medicinal varchar(400);
