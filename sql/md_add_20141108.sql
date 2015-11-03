#打增量版本
#客户表中添加客户状态字段,customer_state 1:初始状态 2:后台已开户(客户申请成功) 3:后台已关联(超级管理员关联成功) 4:后台已注册(扫描、客户进行扫描成功，这时已经为管理员)
alter table md_customer add customer_status int not null default 1; 
alter table md_customer add apply_time varchar(14);
alter table md_customer add applied_time varchar(14);