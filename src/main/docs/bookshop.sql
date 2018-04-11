/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-11 09:11:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bs_admin
-- ----------------------------
DROP TABLE IF EXISTS `bs_admin`;
CREATE TABLE `bs_admin` (
  `id` int(20) NOT NULL COMMENT '库存编号',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickName` varchar(255) NOT NULL COMMENT '昵称',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `admin_id_unique` (`username`) USING BTREE,
  KEY `admin_key` (`username`,`password`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_admin
-- ----------------------------
INSERT INTO `bs_admin` VALUES ('1', 'lql', 'C9188E49F774883922596F6E3CD0C492', '林秋亮', '2018-03-18 10:01:14', '2018-03-18 10:01:18');

-- ----------------------------
-- Table structure for bs_book
-- ----------------------------
DROP TABLE IF EXISTS `bs_book`;
CREATE TABLE `bs_book` (
  `bookIsbn` varchar(60) NOT NULL COMMENT '图书编号,主键,自增长',
  `bookName` varchar(50) NOT NULL COMMENT '书名',
  `author` varchar(20) NOT NULL COMMENT '作者',
  `publisher` varchar(100) NOT NULL COMMENT '出版商',
  `pubilshdata` datetime NOT NULL COMMENT '出版日期',
  `price` decimal(6,2) NOT NULL COMMENT '单价',
  `stocknum` int(11) NOT NULL COMMENT '库存量',
  `categoryId` int(11) NOT NULL COMMENT '外键,分类ID',
  `description` tinytext COMMENT '描述 备注',
  `img` varchar(100) DEFAULT '',
  PRIMARY KEY (`bookIsbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_book
-- ----------------------------
INSERT INTO `bs_book` VALUES ('1214124124122', '人物自传', '刘小小', '六六出版社', '2018-04-04 00:00:00', '19.10', '2', '4', '各种人物各种扯11', '');
INSERT INTO `bs_book` VALUES ('1325457676782', '深入理解java虚拟机', '耿浩', '机械工业出版社', '2014-03-06 00:00:00', '24.00', '1', '1', 'java', '');
INSERT INTO `bs_book` VALUES ('2134124512311', '深入理解JavaScript', '邱勇伟', '清华大学出版社', '2018-03-06 00:00:00', '25.00', '10', '1', '理解JavaScript好教材', '');
INSERT INTO `bs_book` VALUES ('2432543263634', 'C++编程理念', '张文斌', '人民邮电出版社34', '2014-03-05 00:00:00', '26.00', '3', '1', 'C++', '');
INSERT INTO `bs_book` VALUES ('3213213125429', '操作系统', '里弗斯', '北京出版社', '2014-03-19 00:00:00', '23.00', '10', '4', '操作系统的相关信息', '');
INSERT INTO `bs_book` VALUES ('3214312532541', '中华上下五千年', '李军', '机械工业出版社', '2014-03-14 11:24:18', '26.50', '2', '2', '历史的眼泪', '');
INSERT INTO `bs_book` VALUES ('4413252362342', '精通Http协议', 'Craig Walls', '机械工业出版社', '2014-03-08 11:27:14', '28.50', '1', '4', '网络服务', '');
INSERT INTO `bs_book` VALUES ('6124123532554', '英语四级全解读', '孙向阳', '机械工业出版社', '2014-03-26 21:24:46', '26.50', '4', '8', '英语四级的辅助教材', '');
INSERT INTO `bs_book` VALUES ('7213213213213', '标准日本语学习', '张敏', '人民教育出版社', '2014-03-29 10:03:20', '50.00', '4', '9', '日本语言的基本学习教材', '');
INSERT INTO `bs_book` VALUES ('9837306011248', '龙族', '江南', '长江出版社', '2016-02-02 00:00:00', '59.60', '100', '3', '讲述一个小男孩成长为强者的故事', '');

-- ----------------------------
-- Table structure for bs_category
-- ----------------------------
DROP TABLE IF EXISTS `bs_category`;
CREATE TABLE `bs_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(40) NOT NULL COMMENT '分类名',
  `inventory` bigint(20) NOT NULL COMMENT '该类图书总库存量',
  `salesVolume` bigint(20) NOT NULL COMMENT '该类图书总销售量',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_category
-- ----------------------------
INSERT INTO `bs_category` VALUES ('1', '教材', '1', '1');
INSERT INTO `bs_category` VALUES ('2', '外语', '1', '2');
INSERT INTO `bs_category` VALUES ('3', '小说', '101', '0');
INSERT INTO `bs_category` VALUES ('4', '文学', '1', '0');
INSERT INTO `bs_category` VALUES ('5', '历史', '2', '0');
INSERT INTO `bs_category` VALUES ('7', '生活', '1', '0');
INSERT INTO `bs_category` VALUES ('8', '科技', '1', '0');
INSERT INTO `bs_category` VALUES ('9', '玄幻', '1', '3');
INSERT INTO `bs_category` VALUES ('10', '经济', '0', '0');
INSERT INTO `bs_category` VALUES ('13', '恐怖', '0', '0');

-- ----------------------------
-- Table structure for bs_order
-- ----------------------------
DROP TABLE IF EXISTS `bs_order`;
CREATE TABLE `bs_order` (
  `orderId` varchar(60) NOT NULL COMMENT '订单编号',
  `userName` varchar(20) NOT NULL COMMENT '购买者账号',
  `bookName` varchar(60) NOT NULL,
  `buyData` datetime NOT NULL,
  `buyNumber` int(8) NOT NULL COMMENT '购买数量',
  `buyPrice` decimal(12,2) NOT NULL COMMENT '总金额',
  `buyAddress` varchar(50) NOT NULL COMMENT '收获地址',
  `status` int(2) NOT NULL COMMENT '状态,0-未支付；1-已支付；2-已取消；3-已发货；4-已收货',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_order
-- ----------------------------
INSERT INTO `bs_order` VALUES ('1231231234124513412', '林秋亮', '人物自传', '2017-06-28 22:04:42', '2', '86.00', '福建省泉州市xxxxx', '2');
INSERT INTO `bs_order` VALUES ('1241242356346345564', '林秋亮', '中华上下五千年', '2017-06-27 23:30:06', '1', '166.00', '福建省泉州市xxxxx', '2');
INSERT INTO `bs_order` VALUES ('2131245134321432425', '林秋亮', '中华上下五千年', '2017-06-28 11:03:05', '1', '36.00', '福建省莆田市xxxxx', '2');
INSERT INTO `bs_order` VALUES ('2341565677787876867', '林秋亮', '操作系统', '2017-06-27 18:28:56', '1', '66.00', '福建省泉州市xxxxx', '2');
INSERT INTO `bs_order` VALUES ('3125432645875656668', '林秋亮', '标准日本语学习', '2017-06-29 09:56:01', '2', '99.00', '福建省莆田市xxxxx', '2');
INSERT INTO `bs_order` VALUES ('3542342342342354235', '林秋亮', '中华上下五千年', '2017-06-27 21:37:36', '1', '66.00', '福建省泉州市xxxxx', '1');
INSERT INTO `bs_order` VALUES ('4124123412341241246', '胡一菲', '人物自传', '2017-06-28 21:32:31', '2', '22.00', '福建省莆田市xxxxx', '4');

-- ----------------------------
-- Table structure for bs_shopcart
-- ----------------------------
DROP TABLE IF EXISTS `bs_shopcart`;
CREATE TABLE `bs_shopcart` (
  `scid` int(4) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `username` varchar(50) NOT NULL,
  `bookName` varchar(60) NOT NULL,
  `bookNum` int(8) NOT NULL COMMENT '昵称',
  `bookPrice` decimal(6,2) NOT NULL,
  `totalPrice` decimal(12,2) NOT NULL,
  PRIMARY KEY (`scid`),
  UNIQUE KEY `shopcart_id_unique` (`scid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_shopcart
-- ----------------------------
INSERT INTO `bs_shopcart` VALUES ('1', '林秋亮', '人物自传', '2', '22.00', '222.00');
INSERT INTO `bs_shopcart` VALUES ('3', '林秋亮', 'C++编程理念', '2', '222.00', '22222.00');
INSERT INTO `bs_shopcart` VALUES ('7', '林秋亮', '深入理解JavaScript', '3', '25.00', '75.00');

-- ----------------------------
-- Table structure for bs_stock
-- ----------------------------
DROP TABLE IF EXISTS `bs_stock`;
CREATE TABLE `bs_stock` (
  `stockId` int(11) NOT NULL,
  `stockNum` bigint(20) NOT NULL COMMENT '馆藏数',
  `totalCategory` int(6) NOT NULL COMMENT '库存分类总数',
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_stock
-- ----------------------------
INSERT INTO `bs_stock` VALUES ('1', '145', '10');

-- ----------------------------
-- Table structure for bs_user
-- ----------------------------
DROP TABLE IF EXISTS `bs_user`;
CREATE TABLE `bs_user` (
  `userId` varchar(40) NOT NULL COMMENT '用户账号',
  `logPassword` varchar(40) NOT NULL COMMENT '登陆密码',
  `payPassword` varchar(40) NOT NULL COMMENT '支付密码',
  `userName` varchar(20) NOT NULL COMMENT '用户姓名',
  `sex` varchar(4) NOT NULL COMMENT '用户性别：0-女；1-男',
  `livePlace` varchar(40) NOT NULL COMMENT '居住地',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `balance` decimal(12,2) NOT NULL COMMENT '余额,2位小数',
  `status` char(1) NOT NULL COMMENT '用户状态：N-非会员；Y-会员',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`) USING BTREE,
  KEY `user_key` (`userName`,`logPassword`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_user
-- ----------------------------
INSERT INTO `bs_user` VALUES ('11226534665', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '张伟', '男', '福建省泉州市xxxxx', '2018-03-15 23:21:42', '2018-03-15 23:21:42', '0.00', 'N');
INSERT INTO `bs_user` VALUES ('12314235436', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '林婉瑜', '女', '福建省福州市xxxxx', '2018-03-26 23:23:52', '2018-03-26 23:23:52', '0.00', 'N');
INSERT INTO `bs_user` VALUES ('12345678901', 'C9188E49F774883922596F6E3CD0C492', 'C9188E49F774883922596F6E3CD0C492', '林秋亮', '女', '福建省莆田市仙游县', '2018-03-29 09:54:58', '2018-03-29 09:54:58', '3067.00', 'N');
INSERT INTO `bs_user` VALUES ('12356598789', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '胡一菲', '女', '福建省厦门市xxxxx', '2018-03-15 23:51:38', '2018-03-15 23:51:38', '0.00', 'Y');
INSERT INTO `bs_user` VALUES ('12412334443', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '曾小贤', '男', '福建省福州市xxxxx', '2018-03-15 23:27:13', '2018-03-15 23:27:13', '0.00', 'N');
INSERT INTO `bs_user` VALUES ('12412431233', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '关谷神奇', '男', '福建省漳州市xxxxx', '2018-03-22 00:30:47', '2018-03-22 00:30:47', '0.00', 'N');
INSERT INTO `bs_user` VALUES ('12431412412', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '吕子乔', '男', '福建省莆田市xxxxx', '2018-03-15 23:54:25', '2018-03-15 23:54:25', '0.00', 'Y');
INSERT INTO `bs_user` VALUES ('13659780897', '617D41B3AB24FE2FEEAC55EDA41BEC31', 'E65F00D5351D96B1B27C2047580169BF', '陆展博', '男', '福建省厦门市xxxxx', '2018-03-29 10:23:22', '2018-03-29 10:23:22', '0.00', 'N');
INSERT INTO `bs_user` VALUES ('16400811966', '032F3875548F3FF92406A444387DD8C3', 'C9188E49F774883922596F6E3CD0C492', '哇哈哈', '女', '福建省厦门', '2018-03-31 19:53:17', '2018-03-31 19:53:17', '0.00', 'Y');
INSERT INTO `bs_user` VALUES ('18234782163', 'E65F00D5351D96B1B27C2047580169BF', 'E65F00D5351D96B1B27C2047580169BF', '林伟', '男', '福建省厦门市xxxxx', '2018-03-15 21:17:21', '2018-03-15 21:17:24', '70.00', 'N');
INSERT INTO `bs_user` VALUES ('18245937698', '0A41F3EAEB1F77DD8DB0E7BD84A04A48', 'E65F00D5351D96B1B27C2047580169BF', '陈美嘉', '女', '福建省泉州市xxxxx', '2018-03-29 10:36:34', '2018-03-29 10:36:34', '0.00', 'Y');
INSERT INTO `bs_user` VALUES ('87642941654', '032F3875548F3FF92406A444387DD8C3', 'C9188E49F774883922596F6E3CD0C492', '胡适', '男', '福建省仙游县', '2018-03-31 18:41:08', '2018-03-31 18:41:08', '0.00', 'N');
