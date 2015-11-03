#客户表新增 客户修改状态   1:已知晓修改  2:已修改  默认1
alter table md_customer add know_status int default 1;