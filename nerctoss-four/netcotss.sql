/*
Navicat MySQL Data Transfer

Source Server         : Student
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : netcotss

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-05-20 12:43:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL auto_increment,
  `account_name` varchar(20) collate utf8_bin default NULL,
  `account_idcard` varchar(30) collate utf8_bin default NULL,
  `account_gender` int(11) default NULL,
  `account_number` varchar(20) collate utf8_bin default NULL,
  `account_password` varchar(20) collate utf8_bin default NULL,
  `account_phone` varchar(20) collate utf8_bin default NULL,
  `account_address` varchar(30) collate utf8_bin default NULL,
  `account_qq` varchar(20) collate utf8_bin default NULL,
  `account_postcode` varchar(20) collate utf8_bin default NULL,
  `account_paymethod` varchar(20) collate utf8_bin default NULL,
  `account_state` varchar(20) collate utf8_bin default NULL,
  PRIMARY KEY  (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO account VALUES ('2', 'www', '520121199009019029', '0', '23423342', '123', '18993892839', '23人', '2343242', '242342', '支付', '开通');
INSERT INTO account VALUES ('4', '奶茶妹', '511622199210297332', '1', '122343232', '321313232', '18967898999', 'dada', '23234342', '323234', '财付通', '开通');
INSERT INTO account VALUES ('5', '行删', '511622199210297312', '1', '23242343', '2343243', '18232323223', 'fwdwq', '232323', '232332', '支付宝', '开通');

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `business_id` bigint(20) NOT NULL auto_increment,
  `business_password` varchar(20) collate utf8_bin default NULL,
  `business_number` varchar(20) collate utf8_bin default NULL,
  `business_serviceIp` varchar(46) collate utf8_bin default NULL,
  `business_state` varchar(20) collate utf8_bin default NULL,
  `fk_expense_id` bigint(20) default NULL,
  `fk_accort_id` bigint(20) default NULL,
  PRIMARY KEY  (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO business VALUES ('2', '123456', 'dsdasdsad', '133.233.445.333', '开通', '5', '2');
INSERT INTO business VALUES ('6', 'admins', '232332', '198.287.977.233', '开通', '2', '2');

-- ----------------------------
-- Table structure for `businessbill`
-- ----------------------------
DROP TABLE IF EXISTS `businessbill`;
CREATE TABLE `businessbill` (
  `businessbill_id` bigint(20) NOT NULL auto_increment,
  `businessbill_duration` int(11) default NULL,
  `businessbill_expense` double default NULL,
  `fk_totalbill_id` bigint(20) default NULL,
  `fk_business_id` bigint(20) default NULL,
  PRIMARY KEY  (`businessbill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of businessbill
-- ----------------------------
INSERT INTO businessbill VALUES ('1', '242', '24', '3', '2');
INSERT INTO businessbill VALUES ('2', '233', '434', '1', '2');
INSERT INTO businessbill VALUES ('3', '232', '323', '2', '2');
INSERT INTO businessbill VALUES ('4', '433', '376', '4', '3');

-- ----------------------------
-- Table structure for `dayaccount`
-- ----------------------------
DROP TABLE IF EXISTS `dayaccount`;
CREATE TABLE `dayaccount` (
  `dayaccount_id` bigint(20) NOT NULL auto_increment,
  `day` int(11) default NULL,
  `day_duration` int(11) default NULL,
  `fk_monthaccount_id` bigint(20) default NULL,
  PRIMARY KEY  (`dayaccount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dayaccount
-- ----------------------------
INSERT INTO dayaccount VALUES ('1', '6', '34', '2');
INSERT INTO dayaccount VALUES ('2', '4', '200', '1');
INSERT INTO dayaccount VALUES ('3', '6', '43', '1');

-- ----------------------------
-- Table structure for `expense`
-- ----------------------------
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense` (
  `expense_id` bigint(20) NOT NULL auto_increment,
  `expense_name` varchar(20) collate utf8_bin default NULL,
  `expense_duration` int(11) default NULL,
  `expense_price` double default NULL,
  `expense_introduce` varchar(100) collate utf8_bin default NULL,
  `expense_type` varchar(20) collate utf8_bin default NULL,
  `expense_unitprice` double default NULL,
  `expense_state` varchar(20) collate utf8_bin default NULL,
  PRIMARY KEY  (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of expense
-- ----------------------------
INSERT INTO expense VALUES ('2', 'btgrtrh', null, null, 'haha', '套餐', '232', '开通');
INSERT INTO expense VALUES ('5', 'eededcs', '232', '234', 'sddsc', '套餐', '2343', '开通');
INSERT INTO expense VALUES ('7', 'dasdsa', '23', '232', 'fdasdasssad', '套餐', '323', '开通');

-- ----------------------------
-- Table structure for `logging`
-- ----------------------------
DROP TABLE IF EXISTS `logging`;
CREATE TABLE `logging` (
  `logging_id` bigint(20) NOT NULL auto_increment,
  `logging_logintime` datetime default NULL,
  `logging_exittime` datetime default NULL,
  `fk_manager_id` bigint(20) default NULL,
  PRIMARY KEY  (`logging_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of logging
-- ----------------------------
INSERT INTO logging VALUES ('1', '2017-05-24 10:06:14', '2017-05-30 10:06:19', '1');

-- ----------------------------
-- Table structure for `monthaccount`
-- ----------------------------
DROP TABLE IF EXISTS `monthaccount`;
CREATE TABLE `monthaccount` (
  `monthaccount_id` bigint(20) NOT NULL auto_increment,
  `month` int(11) default NULL,
  `month_duration` int(11) default NULL,
  `fk_yearaccount_id` bigint(20) default NULL,
  PRIMARY KEY  (`monthaccount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of monthaccount
-- ----------------------------
INSERT INTO monthaccount VALUES ('1', '5', '243', '1');
INSERT INTO monthaccount VALUES ('2', '7', '34', '1');

-- ----------------------------
-- Table structure for `operateiog`
-- ----------------------------
DROP TABLE IF EXISTS `operateiog`;
CREATE TABLE `operateiog` (
  `operateIog_id` bigint(20) NOT NULL auto_increment,
  `operateIog_Content` varchar(120) collate utf8_bin default NULL,
  `operateIog_time` datetime default NULL,
  `fk_manager_id` bigint(20) default NULL,
  PRIMARY KEY  (`operateIog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of operateiog
-- ----------------------------
INSERT INTO operateiog VALUES ('1', 'wvdfvs', '2017-05-16 10:06:55', '1');

-- ----------------------------
-- Table structure for `server`
-- ----------------------------
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server` (
  `server_id` bigint(20) NOT NULL auto_increment,
  `server_expense` double default NULL,
  `server_ip` varchar(20) collate utf8_bin default NULL,
  `server_logintime` datetime default NULL,
  `server_exittime` datetime default NULL,
  `fk_expense_id` bigint(20) default NULL,
  `fk_business_id` bigint(20) default NULL,
  PRIMARY KEY  (`server_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of server
-- ----------------------------
INSERT INTO server VALUES ('1', '243', '24', '2017-05-17 09:53:59', '2017-05-19 09:54:03', '1', '2');
INSERT INTO server VALUES ('2', null, null, '2017-05-23 10:32:11', '2017-05-22 10:32:17', '2', '3');

-- ----------------------------
-- Table structure for `sys_account_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_role`;
CREATE TABLE `sys_account_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `fk_account_id` bigint(20) default NULL,
  `fk_role_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_account_role
-- ----------------------------
INSERT INTO sys_account_role VALUES ('1', '2', '1');
INSERT INTO sys_account_role VALUES ('2', '3', '1');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL auto_increment,
  `parent_id` bigint(20) default NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) default NULL COMMENT '菜单名称',
  `url` varchar(200) default NULL COMMENT '菜单URL',
  `perms` varchar(500) default NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) default NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) default NULL COMMENT '菜单图标',
  `order_num` int(11) default NULL COMMENT '排序',
  PRIMARY KEY  (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO sys_menu VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '1');
INSERT INTO sys_menu VALUES ('2', '1', '管理员列表', 'sys/user.html', null, '1', 'fa fa-user', '11');
INSERT INTO sys_menu VALUES ('3', '1', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '12');
INSERT INTO sys_menu VALUES ('4', '1', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '13');
INSERT INTO sys_menu VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '111');
INSERT INTO sys_menu VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '112');
INSERT INTO sys_menu VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '113');
INSERT INTO sys_menu VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '114');
INSERT INTO sys_menu VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '121');
INSERT INTO sys_menu VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '122');
INSERT INTO sys_menu VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '123');
INSERT INTO sys_menu VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '124');
INSERT INTO sys_menu VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '131');
INSERT INTO sys_menu VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '132');
INSERT INTO sys_menu VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '133');
INSERT INTO sys_menu VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '134');
INSERT INTO sys_menu VALUES ('27', '0', '用户管理系统', null, null, '0', null, '2');
INSERT INTO sys_menu VALUES ('28', '27', '账务账号管理', 'sys/account.html', null, '1', null, '21');
INSERT INTO sys_menu VALUES ('29', '27', '业务账号管理', 'sys/business.html', '', '1', null, '22');
INSERT INTO sys_menu VALUES ('30', '0', '费用系统', null, null, '0', null, '3');
INSERT INTO sys_menu VALUES ('31', '30', '资费管理系统', 'sys/NewExpense.html', null, '1', null, '31');
INSERT INTO sys_menu VALUES ('32', '30', '账单查询系统', 'sys/totalbill.html', null, '1', null, '32');
INSERT INTO sys_menu VALUES ('33', '30', '账务查询系统', 'sys/yearAccount.html', null, '1', null, '33');
INSERT INTO sys_menu VALUES ('34', '0', '前台日志系统', null, null, '0', null, '4');
INSERT INTO sys_menu VALUES ('35', '34', '登陆日志', 'sys/logging.html', null, '1', null, '41');
INSERT INTO sys_menu VALUES ('36', '34', '操作日志', 'sys/operatelog.html', null, '1', null, '42');
INSERT INTO sys_menu VALUES ('37', '0', '报表查询系统', null, null, '0', null, '5');
INSERT INTO sys_menu VALUES ('38', '37', '饼状报表', 'sys/PieChart.html', null, '1', null, '51');
INSERT INTO sys_menu VALUES ('39', '37', '线状图', 'sys/lineChart.html', null, '1', null, '52');
INSERT INTO sys_menu VALUES ('40', '0', '用户自服务', null, null, '0', null, '6');
INSERT INTO sys_menu VALUES ('41', '40', '自服务', 'sys/selfservice.html', null, '1', null, '61');
INSERT INTO sys_menu VALUES ('42', '0', 'test', null, null, '0', null, '7');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL auto_increment,
  `role_name` varchar(100) default NULL COMMENT '角色名称',
  `remark` varchar(100) default NULL COMMENT '备注',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role VALUES ('1', '超级管理员', '就是这么牛逼', '2017-02-09 17:37:48');
INSERT INTO sys_role VALUES ('2', 'hahaadmin', '系统租户管理员', '2017-02-09 17:37:41');
INSERT INTO sys_role VALUES ('3', '费用系统管理员', '管理资费', '2017-05-19 10:58:59');
INSERT INTO sys_role VALUES ('4', 'panshuai', 'dddd', '2017-05-19 13:25:45');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) default NULL COMMENT '角色ID',
  `menu_id` bigint(20) default NULL COMMENT '菜单ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO sys_role_menu VALUES ('30', '1', '1');
INSERT INTO sys_role_menu VALUES ('31', '1', '2');
INSERT INTO sys_role_menu VALUES ('32', '1', '15');
INSERT INTO sys_role_menu VALUES ('33', '1', '16');
INSERT INTO sys_role_menu VALUES ('34', '1', '17');
INSERT INTO sys_role_menu VALUES ('35', '1', '18');
INSERT INTO sys_role_menu VALUES ('36', '1', '3');
INSERT INTO sys_role_menu VALUES ('37', '1', '19');
INSERT INTO sys_role_menu VALUES ('38', '1', '20');
INSERT INTO sys_role_menu VALUES ('39', '1', '21');
INSERT INTO sys_role_menu VALUES ('40', '1', '22');
INSERT INTO sys_role_menu VALUES ('41', '1', '4');
INSERT INTO sys_role_menu VALUES ('42', '1', '23');
INSERT INTO sys_role_menu VALUES ('43', '1', '24');
INSERT INTO sys_role_menu VALUES ('44', '1', '25');
INSERT INTO sys_role_menu VALUES ('45', '1', '26');
INSERT INTO sys_role_menu VALUES ('50', '3', '30');
INSERT INTO sys_role_menu VALUES ('51', '3', '31');
INSERT INTO sys_role_menu VALUES ('52', '3', '32');
INSERT INTO sys_role_menu VALUES ('53', '3', '33');
INSERT INTO sys_role_menu VALUES ('54', '2', '1');
INSERT INTO sys_role_menu VALUES ('55', '2', '3');
INSERT INTO sys_role_menu VALUES ('56', '2', '19');
INSERT INTO sys_role_menu VALUES ('57', '2', '20');
INSERT INTO sys_role_menu VALUES ('58', '2', '21');
INSERT INTO sys_role_menu VALUES ('59', '2', '22');
INSERT INTO sys_role_menu VALUES ('60', '4', '1');
INSERT INTO sys_role_menu VALUES ('61', '4', '4');
INSERT INTO sys_role_menu VALUES ('62', '4', '23');
INSERT INTO sys_role_menu VALUES ('63', '4', '24');
INSERT INTO sys_role_menu VALUES ('64', '4', '25');
INSERT INTO sys_role_menu VALUES ('65', '4', '26');
INSERT INTO sys_role_menu VALUES ('66', '4', '30');
INSERT INTO sys_role_menu VALUES ('67', '4', '31');
INSERT INTO sys_role_menu VALUES ('68', '4', '32');
INSERT INTO sys_role_menu VALUES ('69', '4', '33');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL auto_increment,
  `cname` varchar(255) default NULL COMMENT '中文名',
  `ename` varchar(255) default NULL COMMENT '英文名',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) default NULL COMMENT '密码',
  `email` varchar(100) default NULL COMMENT '邮箱',
  `mobile` varchar(100) default NULL COMMENT '手机号',
  `status` tinyint(4) default NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime default NULL COMMENT '创建时间',
  `remarks` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES ('1', null, null, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'pan123@qq.com', '434354', '1', '2016-11-11 11:11:11', '系统管理员，用作系统管理可运维，及给成员分配菜单');
INSERT INTO sys_user VALUES ('2', null, null, '23434', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '23432@qq.com', '234323', '0', '2016-11-11 11:11:11', '系统超级管理员，用作保证系统功能完整性，及给Admin分配菜单');
INSERT INTO sys_user VALUES ('3', null, null, '234', '114bd151f8fb0c58642d2170da4ae7d7c57977260ac2cc8905306cab6b2acabc', '232324', '18683399338', '1', '2017-05-19 10:57:25', null);
INSERT INTO sys_user VALUES ('4', null, null, 'pan', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '173287@qq.com', '43545', '1', '2017-05-19 13:25:16', null);

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_id` bigint(20) default NULL COMMENT '用户ID',
  `role_id` bigint(20) default NULL COMMENT '角色ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role VALUES ('2', '2', '1');
INSERT INTO sys_user_role VALUES ('5', '1', '3');
INSERT INTO sys_user_role VALUES ('6', '3', '3');
INSERT INTO sys_user_role VALUES ('9', '4', '4');

-- ----------------------------
-- Table structure for `totalbill`
-- ----------------------------
DROP TABLE IF EXISTS `totalbill`;
CREATE TABLE `totalbill` (
  `totalbill_id` bigint(20) NOT NULL auto_increment,
  `totalbill_expense` double default NULL,
  `totalbill_month` varchar(20) collate utf8_bin default NULL,
  `totalbill_paymethod` varchar(20) collate utf8_bin default NULL,
  `totalbill_paystate` int(11) default NULL,
  `fk_account_id` bigint(20) default NULL,
  PRIMARY KEY  (`totalbill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of totalbill
-- ----------------------------
INSERT INTO totalbill VALUES ('1', '123', '2017-06', '支付宝', '1', '2');
INSERT INTO totalbill VALUES ('2', '325', '2017-03', '支付宝', '1', '2');
INSERT INTO totalbill VALUES ('3', '233', '2017-04', '支付宝', '0', '2');
INSERT INTO totalbill VALUES ('4', '343', '2017-05', '支付宝', '1', '2');
INSERT INTO totalbill VALUES ('5', '232', '2017-07', '财付通', '1', '2');

-- ----------------------------
-- Table structure for `yearacount`
-- ----------------------------
DROP TABLE IF EXISTS `yearacount`;
CREATE TABLE `yearacount` (
  `yearacount_id` bigint(20) NOT NULL auto_increment,
  `year` int(11) default NULL,
  `year_duration` int(11) default NULL,
  `fk_account_id` bigint(20) default NULL,
  `fk_business_id` bigint(20) default NULL,
  PRIMARY KEY  (`yearacount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of yearacount
-- ----------------------------
INSERT INTO yearacount VALUES ('1', '2017', '277', '2', '2');
