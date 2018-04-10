/*
Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-29 16:07:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lib_admin
-- ----------------------------
DROP TABLE IF EXISTS `lib_admin`;
CREATE TABLE `lib_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickName` varchar(255) NOT NULL COMMENT '昵称',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_admin
-- ----------------------------
INSERT INTO `lib_admin` VALUES ('1', 'admin', 'E65F00D5351D96B1B27C2047580169BF', '乱世枭雄', '2017-06-22 10:16:47', '2017-06-22 10:16:51');
INSERT INTO `lib_admin` VALUES ('2', 'lql', 'E65F00D5351D96B1B27C2047580169BF', '林秋亮', '2017-06-29 10:01:14', '2017-06-29 10:01:18');
INSERT INTO `lib_admin` VALUES ('3', 'yl', 'E65F00D5351D96B1B27C2047580169BF', '杨丽', '2017-06-29 10:02:39', '2017-06-29 10:02:43');
INSERT INTO `lib_admin` VALUES ('4', 'wyt', 'E65F00D5351D96B1B27C2047580169BF', '吴钰婷', '2017-06-29 10:03:36', '2017-06-29 10:03:39');

-- ----------------------------
-- Table structure for lib_book
-- ----------------------------
DROP TABLE IF EXISTS `lib_book`;
CREATE TABLE `lib_book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号,主键,自增长',
  `bookName` varchar(255) NOT NULL COMMENT '书名',
  `author` varchar(255) NOT NULL COMMENT '作者',
  `publisher` varchar(255) NOT NULL COMMENT '出版商',
  `pubilshdata` datetime NOT NULL COMMENT '出版日期',
  `buydata` datetime NOT NULL COMMENT '购书日期',
  `price` decimal(6,2) NOT NULL COMMENT '单价',
  `stocknum` int(11) NOT NULL COMMENT '该本书当前库存总数(不包括已经借出去的)',
  `categoryId` int(11) NOT NULL COMMENT '外键,分类ID',
  `description` tinytext COMMENT '描述 备注',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_book
-- ----------------------------
INSERT INTO `lib_book` VALUES ('1', '深入理解java虚拟机', '耿浩', '机械工业出版社', '2017-06-21 00:00:00', '2017-06-25 15:39:50', '38.00', '1', '1', 'java');
INSERT INTO `lib_book` VALUES ('2', 'C++编程理念', '张文斌', '人民邮电出版社', '2017-01-17 11:23:02', '2017-06-24 11:23:09', '26.00', '3', '1', 'C++');
INSERT INTO `lib_book` VALUES ('3', '中华上下五千年', '李军', '机械工业出版社', '2015-06-24 11:24:09', '2017-06-14 11:24:18', '26.50', '3', '2', '历史的眼泪');
INSERT INTO `lib_book` VALUES ('4', '精通Http协议', 'Craig Walls', '机械工业出版社', '2017-06-06 00:00:00', '2017-06-08 11:27:14', '28.50', '1', '4', '网络服务');
INSERT INTO `lib_book` VALUES ('5', 'Spring In Action 4.0', '耿渊', '清华大学出版社', '2017-06-04 11:28:33', '2017-06-07 11:28:37', '48.00', '4', '1', 'spring ');
INSERT INTO `lib_book` VALUES ('6', '英语四级全解读', '孙向阳', '机械工业出版社', '2017-05-29 00:00:00', '2017-06-26 21:24:46', '26.50', '4', '8', '英语四级的辅助教材');
INSERT INTO `lib_book` VALUES ('7', '勇伟的日常生活', '林秋亮', '亮哥出版社', '2017-06-14 00:00:00', '2017-06-29 10:06:20', '100.00', '4', '9', '广东省噶多久啊飒飒个');
INSERT INTO `lib_book` VALUES ('9', '操作系统', '里弗斯', '北京出版社', '2017-06-01 00:00:00', '2017-06-29 10:09:26', '23.00', '10', '4', '皇帝月号v都i俄方');
INSERT INTO `lib_book` VALUES ('10', '逗比秋亮', '吴钰婷', '吴氏出版社', '2017-06-06 00:00:00', '2017-06-29 10:33:48', '188.00', '1', '9', '秋亮日常');

-- ----------------------------
-- Table structure for lib_borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `lib_borrowinfo`;
CREATE TABLE `lib_borrowinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增长',
  `userId` int(11) NOT NULL COMMENT '逻辑外键,关联用户表',
  `bookId` int(11) NOT NULL,
  `borrow_time` datetime NOT NULL,
  `return_time` datetime NOT NULL,
  `isRenew` char(1) NOT NULL COMMENT 'Y-可续借;O-欠费不可以;N-续借过一次的不可以;最多为可续借一次,O状态可以转为Y状态,N状态不可以转为Y状态',
  `isReturned` char(1) NOT NULL COMMENT 'Y-已归还;N-未归还',
  `overdueFine` decimal(12,2) NOT NULL COMMENT '罚金,2位小数',
  `isovertime` char(1) NOT NULL COMMENT '是否超期,Y-已超期,需要罚款 N-未超期',
  `fineStatus` char(1) NOT NULL COMMENT '罚金状态,Y-已缴纳 N-未缴纳  O-无需缴纳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_borrowinfo
-- ----------------------------
INSERT INTO `lib_borrowinfo` VALUES ('2', '1', '6', '2017-06-27 18:28:56', '2017-07-27 18:28:56', 'Y', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('3', '1', '1', '2017-06-27 21:37:36', '2017-07-27 21:37:36', 'Y', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('4', '1', '6', '2017-06-27 23:30:06', '2017-07-27 23:30:06', 'Y', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('5', '1', '3', '2017-06-28 11:03:05', '2017-07-28 11:03:05', 'Y', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('6', '1', '1', '2017-06-28 21:32:31', '2017-08-28 21:32:31', 'N', 'N', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('7', '1', '3', '2017-06-28 22:04:42', '2017-07-28 22:04:42', 'Y', 'N', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('8', '8', '2', '2017-06-29 09:56:01', '2017-07-29 09:56:01', 'Y', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('9', '10', '6', '2017-06-29 09:57:41', '2017-07-29 09:57:41', 'Y', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('10', '8', '1', '2017-06-29 10:01:07', '2017-08-29 10:01:07', 'N', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('11', '12', '6', '2017-06-29 10:02:19', '2017-08-29 10:02:19', 'N', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('12', '12', '6', '2017-06-29 10:02:27', '2017-08-29 10:02:27', 'N', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('13', '12', '6', '2017-06-29 10:02:30', '2017-08-29 10:02:30', 'N', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('14', '12', '6', '2017-06-29 10:02:32', '2017-08-29 10:02:32', 'N', 'Y', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('15', '10', '4', '2017-06-29 10:17:29', '2017-07-29 10:17:29', 'Y', 'N', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('16', '1', '1', '2017-06-29 12:40:38', '2017-08-29 12:40:38', 'N', 'N', '0.00', 'N', 'O');
INSERT INTO `lib_borrowinfo` VALUES ('17', '15', '1', '2017-06-29 15:52:39', '2017-07-29 15:52:39', 'Y', 'N', '0.00', 'N', 'O');

-- ----------------------------
-- Table structure for lib_calssinfo
-- ----------------------------
DROP TABLE IF EXISTS `lib_calssinfo`;
CREATE TABLE `lib_calssinfo` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(40) NOT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_calssinfo
-- ----------------------------
INSERT INTO `lib_calssinfo` VALUES ('1', '计算机科学与技术');
INSERT INTO `lib_calssinfo` VALUES ('2', '软件工程');
INSERT INTO `lib_calssinfo` VALUES ('3', '网络工程');
INSERT INTO `lib_calssinfo` VALUES ('4', '土木工程');

-- ----------------------------
-- Table structure for lib_category
-- ----------------------------
DROP TABLE IF EXISTS `lib_category`;
CREATE TABLE `lib_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(40) NOT NULL COMMENT '分类名',
  `inventory` bigint(20) NOT NULL COMMENT '该类图书总库存量',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_category
-- ----------------------------
INSERT INTO `lib_category` VALUES ('1', '编程语言', '11');
INSERT INTO `lib_category` VALUES ('2', '历史', '4');
INSERT INTO `lib_category` VALUES ('3', '机械', '0');
INSERT INTO `lib_category` VALUES ('4', '网络', '12');
INSERT INTO `lib_category` VALUES ('5', '化学', '0');
INSERT INTO `lib_category` VALUES ('7', '经济', '0');
INSERT INTO `lib_category` VALUES ('8', '外语', '4');
INSERT INTO `lib_category` VALUES ('9', '德玛西亚', '5');

-- ----------------------------
-- Table structure for lib_deptment
-- ----------------------------
DROP TABLE IF EXISTS `lib_deptment`;
CREATE TABLE `lib_deptment` (
  `deptId` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(50) NOT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_deptment
-- ----------------------------

-- ----------------------------
-- Table structure for lib_inventory
-- ----------------------------
DROP TABLE IF EXISTS `lib_inventory`;
CREATE TABLE `lib_inventory` (
  `id` int(11) NOT NULL,
  `totalNum` bigint(20) NOT NULL COMMENT '馆藏数',
  `totalCategory` int(6) NOT NULL COMMENT '库存分类总数',
  `cur_inventory` bigint(20) NOT NULL COMMENT '当前在库图书',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lib_inventory
-- ----------------------------
INSERT INTO `lib_inventory` VALUES ('1', '36', '9', '31');

-- ----------------------------
-- Table structure for lib_user
-- ----------------------------
DROP TABLE IF EXISTS `lib_user`;
CREATE TABLE `lib_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号,主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `classname` varchar(40) NOT NULL COMMENT '班级',
  `department` varchar(40) NOT NULL COMMENT '院系',
  `can_borrow_num` int(4) NOT NULL,
  `fine` decimal(12,2) NOT NULL COMMENT '罚 金,默认0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `balance` decimal(12,2) NOT NULL COMMENT '余额,2位小数',
  `status` char(1) NOT NULL COMMENT '用户状态,Y-正常;N-冻结',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lib_user
-- ----------------------------
INSERT INTO `lib_user` VALUES ('1', 'jack', 'E65F00D5351D96B1B27C2047580169BF', '计算机科学与技术1401', '信息科学与工程学院', '3', '0.00', '2017-06-21 21:17:21', '2017-06-21 21:17:24', '70.00', 'Y');
INSERT INTO `lib_user` VALUES ('2', 'xiaowei', 'E65F00D5351D96B1B27C2047580169BF', '计算机科学与技术1403', '信息科学与工程学院', '6', '0.00', '2017-06-21 23:21:42', '2017-06-21 23:21:42', '0.00', 'Y');
INSERT INTO `lib_user` VALUES ('3', 'lucy', 'E65F00D5351D96B1B27C2047580169BF', '计算机科学与技术1402', '信息科学与工程学院', '6', '0.00', '2017-06-21 23:27:13', '2017-06-21 23:27:13', '0.00', 'Y');
INSERT INTO `lib_user` VALUES ('4', 'rose', 'E65F00D5351D96B1B27C2047580169BF', '网络工程1402', '信息科学与工程学院', '6', '0.00', '2017-06-21 23:51:38', '2017-06-21 23:51:38', '0.00', 'Y');
INSERT INTO `lib_user` VALUES ('5', 'xiaomei', 'E65F00D5351D96B1B27C2047580169BF', '-1', '-1', '6', '0.00', '2017-06-21 23:54:25', '2017-06-21 23:54:25', '0.00', 'N');
INSERT INTO `lib_user` VALUES ('6', 'peter', 'E65F00D5351D96B1B27C2047580169BF', '-1', '-1', '6', '0.00', '2017-06-22 00:30:47', '2017-06-22 00:30:47', '0.00', 'N');
INSERT INTO `lib_user` VALUES ('7', 'lala', 'E65F00D5351D96B1B27C2047580169BF', '计算机科学与技术', '信息科学与工程学院', '6', '0.00', '2017-06-26 23:23:52', '2017-06-26 23:23:52', '0.00', 'Y');
INSERT INTO `lib_user` VALUES ('10', '3141911103', 'E65F00D5351D96B1B27C2047580169BF', '计算机', '计算机系', '5', '0.00', '2017-06-29 09:54:58', '2017-06-29 09:54:58', '100.00', 'Y');
INSERT INTO `lib_user` VALUES ('13', '吴钰婷婷', '617D41B3AB24FE2FEEAC55EDA41BEC31', '计算机科学与技术', '信系技术与科学', '6', '0.00', '2017-06-29 10:23:22', '2017-06-29 10:23:22', '0.00', 'Y');
INSERT INTO `lib_user` VALUES ('14', '3141911110', '0A41F3EAEB1F77DD8DB0E7BD84A04A48', '计算机科学与技术', '信系技术与科学', '6', '0.00', '2017-06-29 10:36:34', '2017-06-29 10:36:34', '0.00', 'Y');
