/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : geti

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-03-07 15:51:07
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
  `output` varchar(1000) NOT NULL,
  `description` varchar(255) DEFAULT '',
  `time` bigint(20) NOT NULL,
  `m_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interface
-- ----------------------------
INSERT INTO `interface` VALUES ('18', 'getServerInfo', ' ', '[{\"cpu_num\": \"2\",\"mem_total\": \"3.7543\",\"cpu_percent\": \"21.1703\",\"user_login\": \"0\",\"net_i\": \"1073.8203\",\"disk_total\": \"454.4951\",\"cpu_load_5min\": \"0.29\",\"disk_free\": \"285.7523\",\"mem_used\": \"2.0375\",\"runtime\": \"2526591\",\"net\": \"2061.2609\",\"cpu_load_15min\": \"0.34\",\"mem_pused\": \"49.0445\",\"net_o\": \"1018.4984\",\"mem_free\": \"1.8427\",\"ip\": \"192.168.1.117\",\"disk_pused\": \"33.7595\",\"mac_address\": \"[eth0] b8:ae:ed:bd:2b:0a\",\"disk_used\": \"145.6339\",\"cpu_load_1min\": \"0.26\",\"proc_num\": \"178\"}]', '获取服务器全部信息', '1488869951', '28');
INSERT INTO `interface` VALUES ('19', 'login', '{username:xxx,password:xxx}', '[\n    {\n        \"cpu_num\": \"2\",\n        \"mem_total\": \"3.7543\",\n        \"cpu_percent\": \"21.1703\",\n        \"user_login\": \"0\",\n        \"net_i\": \"1073.8203\",\n        \"disk_total\": \"454.4951\",\n        \"cpu_load_5min\": \"0.29\",\n        \"disk_free\": \"285.7523\",\n        \"mem_used\": \"2.0375\",\n        \"runtime\": \"2526591\",\n        \"net\": \"2061.2609\",\n        \"cpu_load_15min\": \"0.34\",\n        \"mem_pused\": \"49.0445\",\n        \"net_o\": \"1018.4984\",\n        \"mem_free\": \"1.8427\",\n        \"ip\": \"192.168.1.117\",\n        \"disk_pused\": \"33.7595\",\n        \"mac_address\": \"[eth0] b8:ae:ed:bd:2b:0a\",\n        \"disk_used\": \"145.6339\",\n        \"cpu_load_1min\": \"0.26\",\n        \"proc_num\": \"178\"\n    }\n]', '阿斯达', '1488872474', '29');
INSERT INTO `interface` VALUES ('20', 'getURList', 'username,password', '[\n{\n\"id\": \"1\",\n\"username\": \"admin\",\n\"name\": \"张三\",\n\"role\": \"超级管理员\"\n},\n{\n\"id\": \"2\",\n\"username\": \"zgj\",\n\"name\": \"李四\",\n\"role\": \"角色0002\"\n},\n{\n\"id\": \"3\",\n\"username\": \"mxr\",\n\"name\": \"mxr\",\n\"role\": \"\"\n},\n{\n\"id\": \"140\",\n\"username\": \"z\",\n\"name\": \"小明\",\n\"role\": \"小兵\"\n},\n{\n\"id\": \"141\",\n\"username\": \"g\",\n\"name\": \"王五\",\n\"role\": \"营长\"\n}\n]', '获取用户角色关联信息列表', '1488872437', '30');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('28', '网络主机模块', '网络主机的相关CPU，内存，磁盘，网络参数信息');
INSERT INTO `module` VALUES ('29', '用户管理模块', '用户');
INSERT INTO `module` VALUES ('30', '权限管理模块', '权限管理模块，...');
INSERT INTO `module` VALUES ('31', '小龙模块', '111');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '',
  `t` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 's', '');
INSERT INTO `test` VALUES ('2', 's', 'erer');
INSERT INTO `test` VALUES ('3', 's', 'erer');

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
