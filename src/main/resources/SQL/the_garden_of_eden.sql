/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.54-root
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 192.168.1.54:3306
 Source Schema         : the_garden_of_eden

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 29/09/2019 17:52:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for online_app
-- ----------------------------
DROP TABLE IF EXISTS `online_app`;
CREATE TABLE `online_app`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '申请人姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '申请人手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '申请人邮箱',
  `date` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上线日期',
  `time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上线时间',
  `version` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '上线版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for online_need
-- ----------------------------
DROP TABLE IF EXISTS `online_need`;
CREATE TABLE `online_need`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '需求名称',
  `type` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0 需求 1 BUG 2 优化',
  `execute_permission` tinyint(4) NOT NULL DEFAULT 0 COMMENT '执行权限文件',
  `app_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'online_app表主键id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for online_need_detail
-- ----------------------------
DROP TABLE IF EXISTS `online_need_detail`;
CREATE TABLE `online_need_detail`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能名',
  `project_branch` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '分支名',
  `user_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '负责人',
  `new_project` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为新增 0 否 1 是',
  `last_version` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '上次上线版本',
  `type` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '类型 0 前端 1后台 2 测试',
  `need_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'online_need表主键id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for online_need_remark
-- ----------------------------
DROP TABLE IF EXISTS `online_need_remark`;
CREATE TABLE `online_need_remark`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '备注',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '类型 0 SQL  1 其他备注',
  `need_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'online_need表主键id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
