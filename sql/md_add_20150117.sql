#1、诊断表，添加申请回复状态  是否已查看 1:未查看  2：已查看
alter table md_diagnose add apply_reply_status int not null default 1;
alter table md_diagnose add is_look int not null default 1;