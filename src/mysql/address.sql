/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : cms

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 02/09/2019 22:52:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '四川省', 0);
INSERT INTO `address` VALUES (2, '成都市', 1);
INSERT INTO `address` VALUES (3, '绵阳市', 1);
INSERT INTO `address` VALUES (4, '湖南省', 0);
INSERT INTO `address` VALUES (5, '长沙市', 4);

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address_id` int(11) NULL DEFAULT NULL,
  `jobnum` int(11) NULL DEFAULT NULL,
  `treatment` int(11) NULL DEFAULT NULL,
  `describes` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `requires` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `positiontype` bit(1) NULL DEFAULT NULL,
  `enabled` bit(1) NULL DEFAULT NULL,
  `inputdate` datetime(0) NULL DEFAULT NULL,
  `htmlurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (25, '1111111', 2, 1111111, 1111, '<p>yyyyyyyyyyyyyyy<br></p>', '<p>gggggggggggggggggggggggggggggg<br></p>', b'1', b'1', '2019-08-26 14:51:30', '/temp/63eb1013-0ad7-4eb8-811f-f78d6b12421e.html');
INSERT INTO `job` VALUES (26, '222222', 3, 2222, 2222, '<p>3222222222<br></p>', '<p>2222222222222222<br></p>', b'1', b'1', '2019-08-26 14:51:51', '/temp/bd9bb98a-03dd-4d5f-b354-d255c70144f4.html');
INSERT INTO `job` VALUES (27, '33333', 2, 3333333, 33333333, '<p>33333333<br></p>', '<p>33333333333333333333<br></p>', b'1', b'1', '2019-08-26 14:52:04', '/temp/188d4873-b953-411a-bdba-455c22398e5e.html');
INSERT INTO `job` VALUES (28, '44444', 2, 444, 4444444, '<p>444444444<br></p>', '<p>444444444444<br></p>', b'0', b'0', '2019-08-26 14:52:16', '/temp/70ca439a-9bf3-4634-810a-ce491f0e771a.html');
INSERT INTO `job` VALUES (29, '55555555', 3, 55555, 555555, '<p>55555555555<br></p>', '<p>555555555<br></p>', b'1', b'1', '2019-08-26 14:52:29', '/temp/f7f79914-1161-4100-95ae-4fbd9ff78402.html');
INSERT INTO `job` VALUES (30, 'gfdsg', 4, 4324, 54, '<p>yyyyyyyyyyyyyyyyyyyyyyyyyyy<br></p>', '<p>oooooooooooooooooooooooooooooooooooo<br></p>', b'1', b'1', '2019-08-27 00:57:03', '/temp/b8045ecd-0b8b-45ca-8656-9fb8faa0479d.html');
INSERT INTO `job` VALUES (31, 'llllllllllllllllllllllllllllllllllllllllllllllll', 1, 23, 11, '<p>mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm<br></p>', '<p>nnnnnnnnnnnnnnnnnnnnnnnnn<br></p>', b'1', b'1', '2019-08-29 01:23:49', '/temp/99caa7ce-5892-4d14-870e-cd9f9b011443.html');
INSERT INTO `job` VALUES (32, '9999999999999999999', 1, 444, 555, '<p>hh<br></p>', '<p>jj<br></p>', b'1', b'1', '2019-08-29 22:04:49', '/temp/17353a92-04ed-42cb-b01f-436bcae03492.html');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `storepath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isenabled` bit(1) NULL DEFAULT NULL,
  `inputdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (9, '/pics/a07f34e9-0f4f-451a-b82a-4f1713ac76ec.jpg', '<p>dfsfsdf<br></p>', b'1', '2019-07-14 23:48:20');
INSERT INTO `picture` VALUES (10, '/pics/456bcb88-f647-4545-a501-d55ecd15e5f8.jpg', '<p><br></p>', b'1', '2019-07-14 23:50:26');
INSERT INTO `picture` VALUES (11, '/pics/5ea15b32-05c0-4bfa-b3be-7135d89a518d.jpg', '<p>房贷首付<br></p>', b'1', '2019-07-14 23:50:41');
INSERT INTO `picture` VALUES (12, '/pics/00af9259-656c-4786-b9ff-053b395fab2b.jpg', '<p><br></p>', b'1', '2019-07-14 23:51:08');
INSERT INTO `picture` VALUES (13, '/pics/e1a8f640-ae15-4987-beb7-b0922b91041c.jpg', '<p>缩略图<br></p>', b'1', '2019-07-15 00:25:31');
INSERT INTO `picture` VALUES (14, '/pics/d1d0cea0-b123-4a8f-be0e-c64a193633e6.jpg', '<p>新一轮的测试1<br></p>', b'1', '2019-08-22 18:25:25');

SET FOREIGN_KEY_CHECKS = 1;
