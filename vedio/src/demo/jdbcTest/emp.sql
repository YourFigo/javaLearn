/*
 Navicat Premium Data Transfer

 Source Server         : MysqlConnect
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : db4

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 15/09/2019 18:13:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(11) NOT NULL,
  `ename` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `job_id` int(11) NULL DEFAULT NULL,
  `mgr` int(11) NULL DEFAULT NULL,
  `joindate` date NULL DEFAULT NULL,
  `salary` decimal(7, 2) NULL DEFAULT NULL,
  `bonus` decimal(7, 2) NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `emp_jobid_ref_job_id_fk`(`job_id`) USING BTREE,
  INDEX `emp_deptid_ref_dept_id_fk`(`dept_id`) USING BTREE,
  CONSTRAINT `emp_deptid_ref_dept_id_fk` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `emp_jobid_ref_job_id_fk` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1001, '孙悟空', 4, 1004, '2000-12-17', 8000.00, NULL, 20);
INSERT INTO `emp` VALUES (1002, '卢俊义', 3, 1006, '2001-02-20', 16000.00, 3000.00, 30);
INSERT INTO `emp` VALUES (1003, '林冲', 3, 1006, '2001-02-22', 12500.00, 5000.00, 30);
INSERT INTO `emp` VALUES (1004, '唐僧', 2, 1009, '2001-04-02', 29750.00, NULL, 20);
INSERT INTO `emp` VALUES (1005, '李逵', 4, 1006, '2001-09-28', 12500.00, 14000.00, 30);
INSERT INTO `emp` VALUES (1006, '宋江', 2, 1009, '2001-05-01', 28500.00, NULL, 30);
INSERT INTO `emp` VALUES (1007, '刘备', 2, 1009, '2001-09-01', 24500.00, NULL, 10);
INSERT INTO `emp` VALUES (1008, '猪八戒', 4, 1004, '2007-04-19', 30000.00, NULL, 20);
INSERT INTO `emp` VALUES (1009, '罗贯中', 1, NULL, '2001-11-17', 50000.00, NULL, 10);
INSERT INTO `emp` VALUES (1010, '吴用', 3, 1006, '2001-09-08', 15000.00, 0.00, 30);
INSERT INTO `emp` VALUES (1011, '沙僧', 4, 1004, '2007-05-23', 11000.00, NULL, 20);
INSERT INTO `emp` VALUES (1012, '李逵', 4, 1006, '2001-12-03', 9500.00, NULL, 30);
INSERT INTO `emp` VALUES (1013, '小白龙', 4, 1004, '2001-12-03', 30000.00, NULL, 20);
INSERT INTO `emp` VALUES (1014, '关羽', 4, 1007, '2002-01-23', 13000.00, NULL, 10);

SET FOREIGN_KEY_CHECKS = 1;
