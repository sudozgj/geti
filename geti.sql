/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : geti

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-03-06 18:38:21
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
  `output` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT '',
  `time` bigint(20) NOT NULL,
  `m_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interface
-- ----------------------------
INSERT INTO `interface` VALUES ('7', 'login', 'wef', 'sdfsf', 'ewf', '1488786941', '15');
INSERT INTO `interface` VALUES ('8', 'register', '1', '1', '1', '1488786985', '15');
INSERT INTO `interface` VALUES ('9', 'List', '1', '1', '1', '1488786994', '17');
INSERT INTO `interface` VALUES ('10', 'getLogList', '1', '1', '1', '1488787002', '18');
INSERT INTO `interface` VALUES ('11', 'mxr', 'd', 'd', 'd', '1488790618', '15');
INSERT INTO `interface` VALUES ('12', 'haha', '2', '3', '4', '1488792094', '19');
INSERT INTO `interface` VALUES ('13', 'getInterface', 'iName', '{\n   \"data\": {     \"id\": 10,     \"name\": \"getLogList\",     \"input\": \"1\",     \"output\": \"1\",     \"description\": \"1\",     \"time\": 1488787002,     \"mid\": 10008   }, \n  \"code\": 1,   \"msg\": \"获取接口信息成功\" }', '获取接口对象', '1488795000', '21');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('15', 'User', '');
INSERT INTO `module` VALUES ('17', 'List', 'ef');
INSERT INTO `module` VALUES ('18', 'Log', 'ef');
INSERT INTO `module` VALUES ('19', '哈哈', 'asdsad');
INSERT INTO `module` VALUES ('20', 'jack', 'ef');

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
