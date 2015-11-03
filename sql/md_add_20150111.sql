#打增量版本
#1、症状条目数值表,添加3列，分别对应美妹懂中医、小儿王太医、爸妈治未病 1:望诊 2：闻诊 3：问诊 4：切诊
alter table md_symptom_item_value add meimei int ; 
alter table md_symptom_item_value add xiaoer int ;
alter table md_symptom_item_value add bama int;

#2、区分诊断渠道，PC终端(电脑)、移动终端(移动手机) 1:PC终端  2:移动终端
#   是否已回复：查看医生是否已经回复这病人诉求 1：已回复 非1：未回复
alter table md_diagnose add channel_type int not null default 1;

#3、区分客户表中医生级别时，其是否在线(系统)。1:在线 2:不在线  医生级别为 "10"
alter table md_customer add is_on_line int ;

#4、病人主诉、 病史两字段 病人得出诊断结果时，向医生描述的诉求及病史   report medical_history 
alter table md_diagnose_result add report varchar(400);
alter table md_diagnose_result add medical_history varchar(400);







