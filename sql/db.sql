/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : xzdb

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 14/06/2019 16:46:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for managesystem
-- ----------------------------
DROP TABLE IF EXISTS `managesystem`;
CREATE TABLE `managesystem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of managesystem
-- ----------------------------
INSERT INTO `managesystem` VALUES (1, '系统');

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform
-- ----------------------------
INSERT INTO `platform` VALUES (1, '平台1', 1);
INSERT INTO `platform` VALUES (2, '平台2', 1);
INSERT INTO `platform` VALUES (3, '平台3', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'user3', 'test', 3);
INSERT INTO `user` VALUES (5, 'user5', '1233', 3);
INSERT INTO `user` VALUES (8, 'herb', '1233', 1);
INSERT INTO `user` VALUES (10, 'user10', '1233', 1);
INSERT INTO `user` VALUES (11, 'herb', '1233', 1);
INSERT INTO `user` VALUES (12, 'fhb', '8888', 2);
INSERT INTO `user` VALUES (15, 'platform3user', '123456', 3);
INSERT INTO `user` VALUES (19, 'test', '123', 1);
INSERT INTO `user` VALUES (20, 'test', 'test', 2);
INSERT INTO `user` VALUES (21, 'test', 'test', 2);
INSERT INTO `user` VALUES (33, 'user33', 'test', 1);
INSERT INTO `user` VALUES (34, 'user34', 'test', 1);

SET FOREIGN_KEY_CHECKS = 1;
