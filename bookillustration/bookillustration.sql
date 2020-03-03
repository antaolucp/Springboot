/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : bookillustration

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-02-25 12:44:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `atlas`
-- ----------------------------
DROP TABLE IF EXISTS `atlas`;
CREATE TABLE `atlas` (
  `atlas_id` int(11) NOT NULL AUTO_INCREMENT,
  `atlas_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `atlas_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `atlas_looknum` int(11) DEFAULT '0',
  `atlas_synopsis` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`atlas_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of atlas
-- ----------------------------
INSERT INTO `atlas` VALUES ('1', 'a', '1', '2020-01-24 12:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('2', 'b', '2', '2020-01-24 12:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('3', 'c', '3', '2020-01-24 12:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('4', 'd', '4', '2020-01-24 12:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('5', 'e', '5', '2020-01-24 12:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('6', 'f', '6', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('7', 'g', '7', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('8', 'h', '8', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('9', 'i', '9', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('10', 'j', '10', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('11', 'k', '11', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('12', 'l', '12', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('13', 'n', '13', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('14', 'm', '14', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('15', 'o', '15', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('16', 'p', '16', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('17', 'q', '17', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('18', 'r', '18', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('19', 's', '19', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('20', 't', '20', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('21', 'u', '21', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('22', 'v', '22', '2020-01-02 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('23', 'w', '23', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('24', 'x', '24', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('25', 'y', '25', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('26', 'z', '26', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('27', 'a1', '27', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('28', 'b1', '28', '2019-11-26 19:02:23', '0', '雷姆');
INSERT INTO `atlas` VALUES ('29', 'c1', '29', '2019-11-28 16:47:26', '0', '雷姆');
INSERT INTO `atlas` VALUES ('30', 'd1', '1', '2019-12-06 10:16:42', '2', '雷姆');
INSERT INTO `atlas` VALUES ('31', 'ajsdk', '2', '2020-02-11 22:54:06', '0', 'sd ');
INSERT INTO `atlas` VALUES ('32', '模拟', '2', '2020-02-11 23:30:28', '0', '123');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_cover` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_time` datetime DEFAULT NULL,
  `book_looknum` int(11) DEFAULT NULL,
  `book_good` int(11) DEFAULT NULL,
  `book_ synopsis` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`book_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '阴霾废土', '/novel/cover_6.jpg', '2019-11-28 08:52:23', '10', '5', '简介“蜂巢”为何人为制造的病毒灾难……接二连三的“极闪”现象又预示了什么？“凡世人所行之事，‘神’皆记录在案，‘天火', '1');
INSERT INTO `book` VALUES ('2', '苍与刃', '/novel/cover_6.jpg', '2019-11-20 08:53:52', '15', '1', '胸口好重，好疼••••••血的味道，到处都是••••••好孤独。什么都看不到，什么都听不到，什么都做不到。没有人来到这里', '2');
INSERT INTO `book` VALUES ('3', '讨厌的鬼灭之刃', '/novel/cover_6.jpg', '2019-10-09 08:53:59', '200', '50', '前几天同门生锈兔说的话。、你是最坏的人。所以，没有剑的才能。即使被你守护着我完全不高兴。”怎？这？买完东西回来后，回家之前说过的话。最坏的人？怎么了？数日后明白了的事,不过，我的妹妹弟子小梦被我弄坏了。被打了。好像是这么说的。没', '3');
INSERT INTO `book` VALUES ('4', '宇髓天元前世的记忆', '/novel/cover_6.jpg', '2019-11-08 08:54:05', '12', '2', '虽然很突然，但是大家相信前世吗？我相信。因为在我心中有前世的记忆，说起来会被认为是奇怪的家伙。但是事实也是没办法的。前世的我是狩猎鬼怪的队士。但并不是说很强，而是比一般稍微强一点的队员，绝对不弱。拿着被称为日轮刀的刀，如果接到任务的指令的话', '4');
INSERT INTO `book` VALUES ('5', '童磨和哥哥的狩猎故事', '/novel/cover_6.jpg', '2019-11-28 08:54:14', '36', '24', '简单来说，讲述的是一个童磨哥哥和童磨两个人一起猎鬼的故事。鬼杀队童磨先生，想看啊！！！增加哦哦哦哦！！以这样的想法写了。没有后悔。想继续写的东西有很多，现在请稍等。大概后天或者后天能做到……应该。含有剧透吗？也许', '5');

-- ----------------------------
-- Table structure for `chapter`
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `chapter_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `chapter_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `chapter` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`chapter_id`,`book_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('1', '1', '第一章：沉睡的鬼王', 'book/1/1/1.txt', '1');
INSERT INTO `chapter` VALUES ('1', '2', '第一章 阴霾废土', 'book/1/1/1.txt', '2');
INSERT INTO `chapter` VALUES ('1', '3', '不，为什么会被讨厌呢？', 'book/1/1/2.txt', '3');
INSERT INTO `chapter` VALUES ('1', '4', '宇髓天元前世的记忆。', 'book/1/1/1.txt', '4');
INSERT INTO `chapter` VALUES ('1', '5', '月牙上的剑士，今天开始狩猎鬼怪', 'book/1/1/1.txt', '5');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `comment_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `atlas_id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`,`user_id`,`atlas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2020-02-09 01:17:51', '1', '2', 'aaaaa');
INSERT INTO `comment` VALUES ('2', '2020-02-09 01:18:01', '2', '1', 'bbbbb');
INSERT INTO `comment` VALUES ('3', '2020-02-09 01:18:11', '3', '4', 'cccccc');

-- ----------------------------
-- Table structure for `fan`
-- ----------------------------
DROP TABLE IF EXISTS `fan`;
CREATE TABLE `fan` (
  `fan_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`fan_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of fan
-- ----------------------------
INSERT INTO `fan` VALUES ('1', '2');
INSERT INTO `fan` VALUES ('2', '3');
INSERT INTO `fan` VALUES ('3', '4');
INSERT INTO `fan` VALUES ('4', '5');
INSERT INTO `fan` VALUES ('5', '6');
INSERT INTO `fan` VALUES ('7', '8');
INSERT INTO `fan` VALUES ('8', '9');
INSERT INTO `fan` VALUES ('9', '10');
INSERT INTO `fan` VALUES ('10', '11');
INSERT INTO `fan` VALUES ('11', '12');
INSERT INTO `fan` VALUES ('12', '13');
INSERT INTO `fan` VALUES ('13', '14');
INSERT INTO `fan` VALUES ('14', '15');
INSERT INTO `fan` VALUES ('15', '16');
INSERT INTO `fan` VALUES ('16', '17');
INSERT INTO `fan` VALUES ('17', '18');
INSERT INTO `fan` VALUES ('18', '19');
INSERT INTO `fan` VALUES ('19', '20');
INSERT INTO `fan` VALUES ('20', '21');
INSERT INTO `fan` VALUES ('21', '22');
INSERT INTO `fan` VALUES ('22', '23');
INSERT INTO `fan` VALUES ('23', '24');
INSERT INTO `fan` VALUES ('24', '25');
INSERT INTO `fan` VALUES ('25', '26');
INSERT INTO `fan` VALUES ('26', '3');
INSERT INTO `fan` VALUES ('26', '27');
INSERT INTO `fan` VALUES ('27', '28');
INSERT INTO `fan` VALUES ('28', '1');
INSERT INTO `fan` VALUES ('28', '29');
INSERT INTO `fan` VALUES ('29', '1');
INSERT INTO `fan` VALUES ('29', '3');

-- ----------------------------
-- Table structure for `images`
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `atlas_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`image_id`,`atlas_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('1', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '1', '1');
INSERT INTO `images` VALUES ('2', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '2', '2');
INSERT INTO `images` VALUES ('3', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '3', '3');
INSERT INTO `images` VALUES ('4', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '4', '4');
INSERT INTO `images` VALUES ('5', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '5', '5');
INSERT INTO `images` VALUES ('6', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '6', '6');
INSERT INTO `images` VALUES ('7', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '7', '7');
INSERT INTO `images` VALUES ('8', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '8', '8');
INSERT INTO `images` VALUES ('9', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '9', '9');
INSERT INTO `images` VALUES ('10', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '10', '10');
INSERT INTO `images` VALUES ('11', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '11', '11');
INSERT INTO `images` VALUES ('12', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '12', '12');
INSERT INTO `images` VALUES ('13', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '13', '13');
INSERT INTO `images` VALUES ('14', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '14', '14');
INSERT INTO `images` VALUES ('15', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '15', '15');
INSERT INTO `images` VALUES ('16', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '16', '16');
INSERT INTO `images` VALUES ('17', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '17', '17');
INSERT INTO `images` VALUES ('18', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '18', '18');
INSERT INTO `images` VALUES ('19', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '19', '19');
INSERT INTO `images` VALUES ('20', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '20', '20');
INSERT INTO `images` VALUES ('21', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '21', '21');
INSERT INTO `images` VALUES ('22', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '22', '22');
INSERT INTO `images` VALUES ('23', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '23', '23');
INSERT INTO `images` VALUES ('24', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '24', '24');
INSERT INTO `images` VALUES ('25', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '25', '25');
INSERT INTO `images` VALUES ('26', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '26', '26');
INSERT INTO `images` VALUES ('27', '20190617/cx9AdzSy4tS5RzWyZ6uNG0nA6Zu0gyXAMFGA4K3w6.png', '27', '27');
INSERT INTO `images` VALUES ('28', '20190625/cdf5e49f1a84995ea52ba4fcde5d37b51.png', '28', '28');
INSERT INTO `images` VALUES ('29', '20190625/cdf5e49f1a84995ea52ba4fcde5d37b51.png', '1', '1');
INSERT INTO `images` VALUES ('30', '20190625/cdf5e49f1a84995ea52ba4fcde5d37b51.png', '2', '2');
INSERT INTO `images` VALUES ('31', '20190625/cdf5e49f1a84995ea52ba4fcde5d37b51.png', '3', '3');
INSERT INTO `images` VALUES ('32', '20190625/cdf5e49f1a84995ea52ba4fcde5d37b51.png', '4', '4');
INSERT INTO `images` VALUES ('33', '20190625/cdf5e49f1a84995ea52ba4fcde5d37b51.png', '29', '29');
INSERT INTO `images` VALUES ('34', '20190625/43ef4d1669aacb3eb0c3c7b30910f189_400_300.png', '1', '30');
INSERT INTO `images` VALUES ('35', 'pzhan/hua/31/1ed85ca85c2c5f83e78e657e199654ae_400_300.png', '2', '31');
INSERT INTO `images` VALUES ('36', 'pzhan/hua/31/1ea6a6ca1de6d5f87a1736a0ce7772ed_400_300.jpg', '2', '31');
INSERT INTO `images` VALUES ('37', 'pzhan/hua/31/78b90eb22af7f47ab04c3c4687ce1b24_400_300.jpg', '2', '31');
INSERT INTO `images` VALUES ('38', 'pzhan/hua/32/3fb0802f99ac9af207ba3fb3de8eb1ad_150_150.jpg', '2', '32');
INSERT INTO `images` VALUES ('39', 'pzhan/hua/32/5cca21d27f900bcd9992dd78bdedcdac_400_300.jpg', '2', '32');

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `label_num` int(11) unsigned zerofill DEFAULT '00000000000',
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', '黑', '00000000002');
INSERT INTO `label` VALUES ('2', '鬼灭之刃', '00000000003');
INSERT INTO `label` VALUES ('3', '八重樱', '00000000004');
INSERT INTO `label` VALUES ('4', '斯巴达', '00000000005');
INSERT INTO `label` VALUES ('5', '赛璐璐', '00000000006');
INSERT INTO `label` VALUES ('6', '明日方舟', '00000000007');
INSERT INTO `label` VALUES ('7', '文豪野犬', '00000000008');
INSERT INTO `label` VALUES ('8', '路', '00000000009');
INSERT INTO `label` VALUES ('9', '王者荣耀', '00000000001');
INSERT INTO `label` VALUES ('10', '英雄联盟', '00000000023');
INSERT INTO `label` VALUES ('11', '呼啦啦', '00000000123');
INSERT INTO `label` VALUES ('12', '战地五', '00000000213');
INSERT INTO `label` VALUES ('13', '死亡笔记', '00000000123');
INSERT INTO `label` VALUES ('14', '宝可梦', '00000012312');
INSERT INTO `label` VALUES ('15', '壁纸', '00000000312');
INSERT INTO `label` VALUES ('16', '风景', '00000000003');
INSERT INTO `label` VALUES ('17', 'happy', '00000000123');
INSERT INTO `label` VALUES ('18', 'Fate', '00000000123');
INSERT INTO `label` VALUES ('19', '插画', '00000000012');
INSERT INTO `label` VALUES ('20', '图书', '00000000003');
INSERT INTO `label` VALUES ('23', '213', '00000000123');

-- ----------------------------
-- Table structure for `likes`
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `atlas_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`atlas_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES ('1', '2');
INSERT INTO `likes` VALUES ('1', '3');
INSERT INTO `likes` VALUES ('2', '1');
INSERT INTO `likes` VALUES ('2', '3');
INSERT INTO `likes` VALUES ('3', '4');
INSERT INTO `likes` VALUES ('4', '5');
INSERT INTO `likes` VALUES ('5', '6');
INSERT INTO `likes` VALUES ('6', '7');
INSERT INTO `likes` VALUES ('7', '8');
INSERT INTO `likes` VALUES ('8', '9');
INSERT INTO `likes` VALUES ('9', '10');
INSERT INTO `likes` VALUES ('10', '11');
INSERT INTO `likes` VALUES ('11', '12');
INSERT INTO `likes` VALUES ('12', '13');
INSERT INTO `likes` VALUES ('13', '14');
INSERT INTO `likes` VALUES ('14', '15');
INSERT INTO `likes` VALUES ('15', '16');
INSERT INTO `likes` VALUES ('16', '17');
INSERT INTO `likes` VALUES ('17', '18');
INSERT INTO `likes` VALUES ('18', '19');
INSERT INTO `likes` VALUES ('19', '20');
INSERT INTO `likes` VALUES ('20', '21');
INSERT INTO `likes` VALUES ('21', '22');
INSERT INTO `likes` VALUES ('22', '23');
INSERT INTO `likes` VALUES ('23', '24');
INSERT INTO `likes` VALUES ('24', '25');
INSERT INTO `likes` VALUES ('25', '26');
INSERT INTO `likes` VALUES ('26', '27');
INSERT INTO `likes` VALUES ('27', '28');
INSERT INTO `likes` VALUES ('28', '29');
INSERT INTO `likes` VALUES ('29', '1');
INSERT INTO `likes` VALUES ('30', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_mail` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_area` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `user_synopsis` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_role` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_mail`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aaa', '377605526@qq.com', '$2a$10$BAiCHNNUZlMWMtWx6A2HQuutqlYTggK4HAqu94BVrtUAA.PgYMqFe', 'pzhan/u/1/431e91d6a8d37c8d2c90337b2e7943d7_150_150.jpg', '广东省 汕头市 ', '2019-12-05', '1234213', 'ROLE_USER');
INSERT INTO `user` VALUES ('2', 'aa', '850402824@qq.com', '$2a$10$NeNI1AiUFSXQ/nAOcad7Au/JpjRKvu06H4amg85gOwxhy6m4D7hfO', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-06', '123412', 'ROLE_USER');
INSERT INTO `user` VALUES ('3', 'a', '3', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '341234', 'ROLE_USER');
INSERT INTO `user` VALUES ('4', 'a', '4', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '234', 'ROLE_USER');
INSERT INTO `user` VALUES ('5', 'a', '5', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('6', 'a', '6', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '1234', 'ROLE_USER');
INSERT INTO `user` VALUES ('7', 'a', '72', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('8', 'a', '7', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '1', 'ROLE_USER');
INSERT INTO `user` VALUES ('9', 'a', '8', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '234', 'ROLE_USER');
INSERT INTO `user` VALUES ('10', 'aa', '9', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '1234', 'ROLE_USER');
INSERT INTO `user` VALUES ('11', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('12', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '123', 'ROLE_USER');
INSERT INTO `user` VALUES ('13', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('14', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '4', 'ROLE_USER');
INSERT INTO `user` VALUES ('15', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('16', 'aaa', '1111', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '1234', 'ROLE_USER');
INSERT INTO `user` VALUES ('17', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('18', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '12', 'ROLE_USER');
INSERT INTO `user` VALUES ('19', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('20', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('21', 'a', '11', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '34', 'ROLE_USER');
INSERT INTO `user` VALUES ('22', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('23', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-04', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('24', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '123', 'ROLE_USER');
INSERT INTO `user` VALUES ('25', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', null, 'ROLE_USER');
INSERT INTO `user` VALUES ('26', 'aa', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '4', 'ROLE_USER');
INSERT INTO `user` VALUES ('27', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '1234', 'ROLE_USER');
INSERT INTO `user` VALUES ('28', 'a', '1', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '124', 'ROLE_USER');
INSERT INTO `user` VALUES ('29', 'aaa', '2', '123456', '20190703/12ee047fd4289d24404491e39388af63_200_150.jpg', '汕头', '2019-12-03', '23', 'ROLE_USER');
INSERT INTO `user` VALUES ('35', 'aaaaa', '3776055226@qq.com', '$2a$10$z.qtLpilD1kOAtE0MjRjj.YfDE6pRsc1Ru.etiPwvGCq.55S3FaMu', 'pzhan/u/avatar_mingren.png', '湖北省 潜江市', '2020-02-08', '', 'ROLE_USER');
