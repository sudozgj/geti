/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : geti

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-03-13 18:10:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `interface`
-- ----------------------------
DROP TABLE IF EXISTS `interface`;
CREATE TABLE `interface` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `input` varchar(255) DEFAULT '',
  `output` varchar(10000) NOT NULL,
  `description` varchar(255) DEFAULT '',
  `time` bigint(20) NOT NULL,
  `m_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interface
-- ----------------------------
INSERT INTO `interface` VALUES ('18', 'getServerInfo', ' 无', '[\n    {\n        \"cpu_num\": \"2\",\n        \"mem_total\": \"3.7543\",\n        \"cpu_percent\": \"21.1703\",\n        \"user_login\": \"0\",\n        \"net_i\": \"1073.8203\",\n        \"disk_total\": \"454.4951\",\n        \"cpu_load_5min\": \"0.29\",\n        \"disk_free\": \"285.7523\",\n        \"mem_used\": \"2.0375\",\n        \"runtime\": \"2526591\",\n        \"net\": \"2061.2609\",\n        \"cpu_load_15min\": \"0.34\",\n        \"mem_pused\": \"49.0445\",\n        \"net_o\": \"1018.4984\",\n        \"mem_free\": \"1.8427\",\n        \"ip\": \"192.168.1.117\",\n        \"disk_pused\": \"33.7595\",\n        \"mac_address\": \"[eth0] b8:ae:ed:bd:2b:0a\",\n        \"disk_used\": \"145.6339\",\n        \"cpu_load_1min\": \"0.26\",\n        \"proc_num\": \"178\"\n    }\n]', '获取服务器全部信息', '1488954686', '28');
INSERT INTO `interface` VALUES ('19', 'login', '{username:xxx,password:xxx}', '[\n    {\n        \"cpu  _num\": \"2\",\n        \"mem_total\": \"3.7543\",\n        \"cpu_percent\": \"21.1703\",\n        \"user_login\": \"0\",\n        \"net_i\": \"1073.8203\",\n        \"disk_total\": \"454.4951\",\n        \"cpu_load_5min\": \"0.29\",\n        \"disk_free\": \"285.7523\",\n        \"mem_used\": \"2.0375\",\n        \"runtime\": \"2526591\",\n        \"net\": \"2061.2609\",\n        \"cpu_load_15min\": \"0.34\",\n        \"mem_pused\": \"49.0445\",\n        \"net_o\": \"1018.4984\",\n        \"mem_free\": \"1.8427\",\n        \"ip\": \"192.168.1.117\",\n        \"disk_pused\": \"33.7595\",\n        \"mac_address\": \"[eth0] b8:ae:ed:bd:2b:0a\",\n        \"disk_used\": \"145.6339\",\n        \"cpu_load_1min\": \"0.26\",\n        \"proc_num\": \"178\"\n    }\n]', '登录接口', '1488955040', '29');
INSERT INTO `interface` VALUES ('20', 'getURList', 'username,password', '[\n    {\n        \"id\": \"1\",\n        \"username\": \"admin\",\n        \"name\": \"张三\",\n        \"role\": \"超级管理员\"\n    },\n    {\n        \"id\": \"2\",\n        \"username\": \"zgj\",\n        \"name\": \"李四\",\n        \"role\": \"角色0002\"\n    },\n    {\n        \"id\": \"3\",\n        \"username\": \"mxr\",\n        \"name\": \"mxr\",\n        \"role\": \"\"\n    },\n    {\n        \"id\": \"140\",\n        \"username\": \"z\",\n        \"name\": \"小明\",\n        \"role\": \"小兵\"\n    },\n    {\n        \"id\": \"141\",\n        \"username\": \"g\",\n        \"name\": \"王五\",\n        \"role\": \"营长\"\n    }\n]', '获取用户角色关联信息列表', '1488954578', '30');
INSERT INTO `interface` VALUES ('28', 'test01', '2', 'sdf\nrgregr', '43 322 3', '1489392151', '31');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('28', '网络主机模块', '网络主机的相关CPU，内存，磁盘，网络参数信息');
INSERT INTO `module` VALUES ('29', '用户管理模块', '用户');
INSERT INTO `module` VALUES ('30', '权限管理模块', '权限管理模块，...');
INSERT INTO `module` VALUES ('31', 'Test', '测试模块');
INSERT INTO `module` VALUES ('32', 'Test2', '测试模块2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ack` tinyint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '1');

-- ----------------------------
-- View structure for `v_i_m`
-- ----------------------------
DROP VIEW IF EXISTS `v_i_m`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_i_m` AS select `i`.`id` AS `id`,`i`.`name` AS `name`,`i`.`input` AS `input`,`i`.`output` AS `output`,`i`.`description` AS `description`,date_format(from_unixtime(`i`.`time`),'%Y-%m-%d %H:%i:%S') AS `time`,`i`.`m_id` AS `m_id`,`m`.`name` AS `mName`,`m`.`description` AS `mDescription` from (`interface` `i` join `module` `m`) where (`i`.`m_id` = `m`.`id`);
