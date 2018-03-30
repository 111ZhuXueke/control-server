/*
Navicat MySQL Data Transfer

Source Server         : me
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : control

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2018-03-30 09:46:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `computer_id` int(11) NOT NULL,
  `application_name` varchar(50) NOT NULL,
  `application_url` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `isclose` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for computer
-- ----------------------------
DROP TABLE IF EXISTS `computer`;
CREATE TABLE `computer` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `mac` varchar(255) NOT NULL,
  `port` varchar(50) DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of computer
-- ----------------------------
INSERT INTO `computer` VALUES ('1', '11', '192.168.254.47', '2018-01-25 15:41:36', 'MTIzNDU2', '2018-01-25 15:41:36', 'MTExNTE2ODY2MDk2Njc3', '18888', '192.168.254.47');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `epassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zxk', '15603998400', '123456', '123456');
INSERT INTO `user` VALUES ('2', 'str', '15603998400', '123456', '123456');
INSERT INTO `user` VALUES ('3', 'qwe', '15603998400', '132456', '132456');
INSERT INTO `user` VALUES ('4', 'werew', '15603998400', '132456', '132456');
INSERT INTO `user` VALUES ('5', 'ssdfs', '15603998400', '132456', '132456');
INSERT INTO `user` VALUES ('6', 'sdfdsfsd', '15603998400', '1234526', '123456');
INSERT INTO `user` VALUES ('7', 'poi', '15603998400', '132456', '123456');
INSERT INTO `user` VALUES ('8', 'sdlfjs', '15603998400', '123456', '132456');
INSERT INTO `user` VALUES ('9', 'mysql', '46547', '123456', '13214564');
