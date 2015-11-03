/*
 Navicat Premium Data Transfer

 Source Server         : owen_1
 Source Server Type    : MySQL
 Source Server Version : 50627
 Source Host           : localhost
 Source Database       : md

 Target Server Type    : MySQL
 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 10/17/2015 13:35:01 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `md_base_prescription_value`
-- ----------------------------
DROP TABLE IF EXISTS `md_base_prescription_value`;
CREATE TABLE `md_base_prescription_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value1` varchar(20) NOT NULL,
  `value2` varchar(20) DEFAULT NULL,
  `value3` varchar(20) DEFAULT NULL,
  `value4` varchar(20) DEFAULT NULL,
  `value5` varchar(20) DEFAULT NULL,
  `value6` varchar(20) DEFAULT NULL,
  `value7` varchar(20) DEFAULT NULL,
  `value8` varchar(20) DEFAULT NULL,
  `value9` varchar(20) DEFAULT NULL,
  `value10` varchar(20) DEFAULT NULL,
  `spec_value_1` varchar(20) DEFAULT NULL,
  `spec_value_1_action` varchar(2) DEFAULT NULL,
  `spec_value_1_remark` varchar(20) DEFAULT NULL,
  `spec_value_2` varchar(20) DEFAULT NULL,
  `spec_value_2_action` varchar(2) DEFAULT NULL,
  `spec_value_2_remark` varchar(20) DEFAULT NULL,
  `spec_value_3` varchar(20) DEFAULT NULL,
  `spec_value_3_action` varchar(2) DEFAULT NULL,
  `spec_value_3_remark` varchar(200) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_bw`
-- ----------------------------
DROP TABLE IF EXISTS `md_bw`;
CREATE TABLE `md_bw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(10) NOT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_by`
-- ----------------------------
DROP TABLE IF EXISTS `md_by`;
CREATE TABLE `md_by` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` char(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(10) NOT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_customer`
-- ----------------------------
DROP TABLE IF EXISTS `md_customer`;
CREATE TABLE `md_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(30) NOT NULL,
  `login_pwd` varchar(30) NOT NULL DEFAULT '888888',
  `card_type` char(1) NOT NULL DEFAULT '1',
  `card_no` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birth` varchar(8) NOT NULL,
  `sex` int(11) NOT NULL DEFAULT '1',
  `age` int(11) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `social_card_no` varchar(50) DEFAULT NULL,
  `create_time` varchar(14) DEFAULT NULL,
  `update_time` varchar(14) DEFAULT NULL,
  `customer_type` varchar(4) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  `remark4` varchar(200) DEFAULT NULL,
  `remark5` varchar(200) DEFAULT NULL,
  `remark6` varchar(200) DEFAULT NULL,
  `customer_status` int(11) NOT NULL DEFAULT '1',
  `apply_time` varchar(14) DEFAULT NULL,
  `applied_time` varchar(14) DEFAULT NULL,
  `is_on_line` int(11) DEFAULT NULL,
  `doctor_sign_name` varchar(50) DEFAULT 'doc1.jgp',
  `apply_status` int(11) DEFAULT '1',
  `know_status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `md_customer`
-- ----------------------------
BEGIN;
INSERT INTO `md_customer` VALUES ('-1', '匿名', '匿名', '1', '111111111111', '匿名', '1987', '1', '100', '13333333', null, null, null, null, '1', null, null, null, null, null, null, '1', null, null, null, 'doc1.jgp', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `md_customer_applyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `md_customer_applyinfo`;
CREATE TABLE `md_customer_applyinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `manager_customer_id` bigint(20) DEFAULT NULL,
  `manager_customer_name` varchar(50) DEFAULT NULL,
  `deal_action` int(11) DEFAULT NULL,
  `deal_status_before` int(11) DEFAULT NULL,
  `deal_status_after` int(11) DEFAULT NULL,
  `deal_date` varchar(8) DEFAULT NULL,
  `deal_time` varchar(6) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_diagnose`
-- ----------------------------
DROP TABLE IF EXISTS `md_diagnose`;
CREATE TABLE `md_diagnose` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `diagnose_date` varchar(8) DEFAULT NULL,
  `diagnose_time` varchar(6) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  `channel_type` int(11) NOT NULL DEFAULT '1',
  `reply_date` varchar(8) DEFAULT NULL,
  `reply_time` varchar(6) DEFAULT NULL,
  `apply_reply_status` int(11) NOT NULL DEFAULT '1',
  `is_look` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_diagnose_detail`
-- ----------------------------
DROP TABLE IF EXISTS `md_diagnose_detail`;
CREATE TABLE `md_diagnose_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diagnose_id` bigint(20) NOT NULL,
  `symptom_time_value_id` bigint(20) NOT NULL,
  `symptom_time_value_name` varchar(50) NOT NULL,
  `level` char(1) DEFAULT '2',
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_diagnose_result`
-- ----------------------------
DROP TABLE IF EXISTS `md_diagnose_result`;
CREATE TABLE `md_diagnose_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diagnose_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `diagnose_result_date` varchar(8) DEFAULT NULL,
  `diagnose_result_time` varchar(6) DEFAULT NULL,
  `in_bw_first_code` varchar(20) NOT NULL,
  `in_bw_first_name` varchar(20) NOT NULL,
  `in_bw_first_value` float DEFAULT NULL,
  `in_bw_second_code` varchar(20) DEFAULT NULL,
  `in_bw_second_name` varchar(20) DEFAULT NULL,
  `in_bw_second_value` float DEFAULT NULL,
  `in_by_first_code` varchar(20) NOT NULL,
  `in_by_first_name` varchar(20) NOT NULL,
  `in_by_first_value` float DEFAULT NULL,
  `in_by_second_code` varchar(20) DEFAULT NULL,
  `in_by_second_name` varchar(20) DEFAULT NULL,
  `in_by_second_value` float DEFAULT NULL,
  `out_bw_code` varchar(20) DEFAULT NULL,
  `out_bw_name` varchar(20) DEFAULT NULL,
  `out_bw_value` float DEFAULT NULL,
  `out_by_code` varchar(20) DEFAULT NULL,
  `out_by_name` varchar(20) DEFAULT NULL,
  `out_by_value` float DEFAULT NULL,
  `symptom_prescription_id` bigint(20) DEFAULT NULL,
  `symptom_prescription_name` varchar(50) DEFAULT NULL,
  `prescription1_code` varchar(200) DEFAULT NULL,
  `prescription1_name` varchar(200) DEFAULT NULL,
  `prescription1_medicinal` varchar(400) DEFAULT NULL,
  `prescription2_code` varchar(200) DEFAULT NULL,
  `prescription2_name` varchar(200) DEFAULT NULL,
  `prescription2_medicinal` varchar(400) DEFAULT NULL,
  `prescription3_code` varchar(200) DEFAULT NULL,
  `prescription3_name` varchar(200) DEFAULT NULL,
  `prescription3_medicinal` varchar(400) DEFAULT NULL,
  `prescription4_code` varchar(200) DEFAULT NULL,
  `prescription4_name` varchar(200) DEFAULT NULL,
  `prescription4_medicinal` varchar(400) DEFAULT NULL,
  `ac_medicinal` varchar(400) DEFAULT NULL,
  `ad_medicinal` varchar(400) DEFAULT NULL,
  `bc_medicinal` varchar(400) DEFAULT NULL,
  `bd_medicinal` varchar(400) DEFAULT NULL,
  `ef_medicinal` varchar(400) DEFAULT NULL,
  `g_medicinal` varchar(400) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  `sex` int(11) NOT NULL DEFAULT '1',
  `is_first_diagnose` int(11) NOT NULL DEFAULT '1',
  `report` varchar(400) DEFAULT NULL,
  `medical_history` varchar(400) DEFAULT NULL,
  `prescription5_code` varchar(200) DEFAULT NULL,
  `prescription5_name` varchar(200) DEFAULT NULL,
  `prescription5_medicinal` varchar(400) DEFAULT NULL,
  `prescription6_medicinal` varchar(400) DEFAULT NULL,
  `sick_name` varchar(50) DEFAULT NULL,
  `sick_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_medicinal`
-- ----------------------------
DROP TABLE IF EXISTS `md_medicinal`;
CREATE TABLE `md_medicinal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(50) NOT NULL,
  `function` varchar(200) NOT NULL,
  `filepath1` varchar(200) DEFAULT NULL,
  `filepath2` varchar(200) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  `smell` varchar(100) DEFAULT '性平，味苦、酸',
  `main_cure` varchar(100) DEFAULT '腰膝酸痛，筋骨无力，经闭癓瘕，肝阳眩晕',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_message_board`
-- ----------------------------
DROP TABLE IF EXISTS `md_message_board`;
CREATE TABLE `md_message_board` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` varchar(300) NOT NULL,
  `time` varchar(14) NOT NULL,
  `customer_id` varchar(20) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `filepath1` varchar(200) DEFAULT NULL,
  `filepath2` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_symptom_item_value`
-- ----------------------------
DROP TABLE IF EXISTS `md_symptom_item_value`;
CREATE TABLE `md_symptom_item_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` char(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value1` varchar(10) NOT NULL,
  `value2` varchar(10) DEFAULT NULL,
  `value3` varchar(10) DEFAULT NULL,
  `value4` varchar(10) DEFAULT NULL,
  `value5` varchar(10) DEFAULT NULL,
  `value6` varchar(10) DEFAULT NULL,
  `value7` varchar(10) DEFAULT NULL,
  `value8` varchar(10) DEFAULT NULL,
  `value9` varchar(10) DEFAULT NULL,
  `value10` varchar(10) DEFAULT NULL,
  `filepath` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  `sex` int(11) NOT NULL DEFAULT '1',
  `meimei` int(11) DEFAULT NULL,
  `xiaoer` int(11) DEFAULT NULL,
  `bama` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `md_symptom_item_value`
-- ----------------------------
BEGIN;
INSERT INTO `md_symptom_item_value` VALUES ('1', '1', '面色白', '', '', '', '', '', '', '', '', '', '', null, '面色白', null, null, null, '1', null, null, null), ('2', '1', '面色白带青', '', '', '', '', '', '', '', '', '', '', null, '面色白带青', null, null, null, '1', null, null, null), ('3', '1', '面色黄色鲜', '', '', '', '', '', '', '', '', '', '', null, '面色黄色鲜', null, null, null, '1', null, null, null), ('4', '1', '面色淡黄萎黄', '', '', '', '', '', '', '', '', '', '', null, '面色淡黄萎黄', null, null, null, '1', null, null, null), ('5', '1', '面色红如醉', '', '', '', '', '', '', '', '', '', '', null, '面色红如醉', null, null, null, '1', null, null, null), ('6', '1', '午后颧红', '', '', '', '', '', '', '', '', '', '', null, '午后颧红', null, null, null, '1', null, null, null), ('7', '1', '面嫩红带白如妆', '', '', '', '', '', '', '', '', '', '', null, '面嫩红带白如妆', null, null, null, '1', null, null, null), ('8', '1', '面色青带黑', '', '', '', '', '', '', '', '', '', '', null, '面色青带黑', null, null, null, '1', null, null, null), ('9', '1', '面色青带红', '', '', '', '', '', '', '', '', '', '', null, '面色青带红', null, null, null, '1', null, null, null), ('10', '1', '面青(唇、指甲青)', '', '', '', '', '', '', '', '', '', '', null, '面青(唇、指甲青)', null, null, null, '1', null, null, null), ('11', '1', '面色黑', '', '', '', '', '', '', '', '', '', '', null, '面色黑', null, null, null, '1', null, null, null), ('12', '1', '面色黑带淡黄', '', '', '', '', '', '', '', '', '', '', null, '面色黑带淡黄', null, null, null, '1', null, null, null), ('13', '1', '面色黑带深黄', '', '', '', '', '', '', '', '', '', '', null, '面色黑带深黄', null, null, null, '1', null, null, null), ('14', '1', '面色黑青暗淡', '', '', '', '', '', '', '', '', '', '', null, '面色黑青暗淡', null, null, null, '1', null, null, null), ('15', '1', '发落枯黄干（小儿发枯黄同）', '', '', '', '', '', '', '', '', '', '', null, '发落枯黄干（小儿发枯黄同）', null, null, null, '1', null, null, null), ('16', '1', '面色青带红', '', '', '', '', '', '', '', '', '', '', null, '面色青带红', null, null, null, '1', null, null, null), ('17', '1', '少年白发', '', '', '', '', '', '', '', '', '', '', null, '少年白发', null, null, null, '1', null, null, null), ('18', '2', '胁痛胁胀', '', '', '', '', '', '', '', '', '', '', null, '胁痛胁胀', null, null, null, '1', null, null, null), ('19', '2', '胸胁刺痛（胸痛、心前区隐痛）', '', '', '', '', '', '', '', '', '', '', null, '胸胁刺痛（胸痛、心前区隐痛）', null, null, null, '1', null, null, null), ('20', '2', '心前区绞痛', '', '', '', '', '', '', '', '', '', '', null, '心前区绞痛', null, null, null, '1', null, null, null), ('21', '2', '胸胁牵引痛（放射到右肩）', '', '', '', '', '', '', '', '', '', '', null, '胸胁牵引痛（放射到右肩）', null, null, null, '1', null, null, null), ('22', '2', '胸胁胀满闷', '', '', '', '', '', '', '', '', '', '', null, '胸胁胀满闷', null, null, null, '1', null, null, null), ('23', '2', '胸胁窒闷（气闷）', '', '', '', '', '', '', '', '', '', '', null, '胸胁窒闷（气闷）', null, null, null, '1', null, null, null), ('24', '2', '心跳过速', '', '', '', '', '', '', '', '', '', '', null, '心跳过速', null, null, null, '1', null, null, null), ('25', '2', '心慌（心悸）', '', '', '', '', '', '', '', '', '', '', null, '心慌（心悸）', null, null, null, '1', null, null, null), ('26', '2', '自觉闷乱不宁（心中懊侬）', '', '', '', '', '', '', '', '', '', '', null, '自觉闷乱不宁（心中懊侬）', null, null, null, '1', null, null, null), ('27', '2', '胸闷', '', '', '', '', '', '', '', '', '', '', null, '胸闷', null, null, null, '1', null, null, null), ('28', '2', '胸痞', '', '', '', '', '', '', '', '', '', '', null, '胸痞', null, null, null, '1', null, null, null), ('29', '3', '醒时出汗（自汗）', '', '', '', '', '', '', '', '', '', '', null, '醒时出汗（自汗）', null, null, null, '1', null, null, null), ('30', '3', '睡时出汗（盗汗）', '', '', '', '', '', '', '', '', '', '', null, '睡时出汗（盗汗）', null, null, null, '1', null, null, null), ('31', '3', '微汗', '', '', '', '', '', '', '', '', '', '', null, '微汗', null, null, null, '1', null, null, null), ('32', '3', '大汗（大汗不止）', '', '', '', '', '', '', '', '', '', '', null, '大汗（大汗不止）', null, null, null, '1', null, null, null), ('33', '3', '粘手汗（汗出如油）', '', '', '', '', '', '', '', '', '', '', null, '粘手汗（汗出如油）', null, null, null, '1', null, null, null), ('34', '3', '黄汗', '', '', '', '', '', '', '', '', '', '', null, '黄汗', null, null, null, '1', null, null, null), ('35', '3', '动则汗出', '', '', '', '', '', '', '', '', '', '', null, '动则汗出', null, null, null, '1', null, null, null), ('36', '3', '尿少而肿（小便闭）', '', '', '', '', '', '', '', '', '', '', null, '尿少而肿（小便闭）', null, null, null, '1', null, null, null), ('37', '4', '急惊风（手足抽搐、痉病）', '', '', '', '', '', '', '', '', '', '', null, '急惊风（手足抽搐、痉病）', null, null, null, '1', null, null, null), ('38', '4', '小儿慢惊风', '', '', '', '', '', '', '', '', '', '', null, '小儿慢惊风', null, null, null, '1', null, null, null), ('39', '4', '足未痿不能行（痿病）', '', '', '', '', '', '', '', '', '', '', null, '足未痿不能行（痿病）', null, null, null, '1', null, null, null), ('40', '4', '肉已痿不能行（痿病）', '', '', '', '', '', '', '', '', '', '', null, '肉已痿不能行（痿病）', null, null, null, '1', null, null, null), ('41', '4', '手足拘急（鸡爪风）', '', '', '', '', '', '', '', '', '', '', null, '手足拘急（鸡爪风）', null, null, null, '1', null, null, null), ('42', '4', '屈而不伸', '', '', '', '', '', '', '', '', '', '', null, '屈而不伸', null, null, null, '1', null, null, null), ('43', '4', '伸而不屈（四肢僵直）', '', '', '', '', '', '', '', '', '', '', null, '伸而不屈（四肢僵直）', null, null, null, '1', null, null, null), ('44', '4', '手足颤抖', '', '', '', '', '', '', '', '', '', '', null, '手足颤抖', null, null, null, '1', null, null, null), ('45', '4', '站坐不稳', '', '', '', '', '', '', '', '', '', '', null, '站坐不稳', null, null, null, '1', null, null, null), ('46', '5', '浮脉', '', '', '', '', '', '', '', '', '', '', null, '浮脉', null, null, null, '1', null, null, null), ('47', '5', '洪脉', '', '', '', '', '', '', '', '', '', '', null, '洪脉', null, null, null, '1', null, null, null), ('48', '5', '濡脉', '', '', '', '', '', '', '', '', '', '', null, '濡脉', null, null, null, '1', null, null, null), ('49', '5', '芤脉', '', '', '', '', '', '', '', '', '', '', null, '芤脉', null, null, null, '1', null, null, null), ('50', '5', '沉脉', '', '', '', '', '', '', '', '', '', '', null, '沉脉', null, null, null, '1', null, null, null), ('51', '5', '弱脉', '', '', '', '', '', '', '', '', '', '', null, '弱脉', null, null, null, '1', null, null, null), ('52', '5', '迟脉', '', '', '', '', '', '', '', '', '', '', null, '迟脉', null, null, null, '1', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `md_symptom_prescription_value`
-- ----------------------------
DROP TABLE IF EXISTS `md_symptom_prescription_value`;
CREATE TABLE `md_symptom_prescription_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` char(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value1` varchar(20) NOT NULL,
  `value2` varchar(20) DEFAULT NULL,
  `value3` varchar(20) DEFAULT NULL,
  `value4` varchar(20) DEFAULT NULL,
  `value5` varchar(20) DEFAULT NULL,
  `value6` varchar(20) DEFAULT NULL,
  `value7` varchar(20) DEFAULT NULL,
  `value8` varchar(20) DEFAULT NULL,
  `value9` varchar(20) DEFAULT NULL,
  `value10` varchar(20) DEFAULT NULL,
  `spec_value_1` varchar(20) DEFAULT NULL,
  `spec_value_1_action` varchar(2) DEFAULT NULL,
  `spec_value_1_remark` varchar(200) DEFAULT NULL,
  `spec_value_2` varchar(20) DEFAULT NULL,
  `spec_value_2_action` varchar(2) DEFAULT NULL,
  `spec_value_2_remark` varchar(200) DEFAULT NULL,
  `spec_value_3` varchar(20) DEFAULT NULL,
  `spec_value_3_action` varchar(2) DEFAULT NULL,
  `spec_value_3_remark` varchar(200) DEFAULT NULL,
  `remark1` varchar(200) DEFAULT NULL,
  `remark2` varchar(200) DEFAULT NULL,
  `remark3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
