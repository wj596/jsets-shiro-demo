-- ----------------------------
-- jsets-shiro-demo
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `CODE` varchar(20) DEFAULT NULL COMMENT '编码',
  `NAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父资源编码',
  `URL` varchar(255) DEFAULT NULL COMMENT '访问地址',
  `TYPE` smallint(1) DEFAULT NULL COMMENT '类型 1:菜单 2:按钮',
  `STATUS` smallint(1) DEFAULT '1' COMMENT '状态   1:正常、9：删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `t_resource` VALUES ('001', 'ARTICLE_LIST', '文章列表', null, '/article/list', '1', '1');
INSERT INTO `t_resource` VALUES ('001001', 'ARTICLE_ADD', '添加文章', null, '/article/add', '2', '1');
INSERT INTO `t_resource` VALUES ('001002', 'ARTICLE_DELETE', '删除文章', null, '/article/delete', '2', '1');
INSERT INTO `t_resource` VALUES ('001003', 'ARTICLE_UPDATE', '修改文章', null, '/article/update', '2', '1');
INSERT INTO `t_resource` VALUES ('002', 'USER_MAGE', '用户管理', null, '/user/**', '1', '1');
INSERT INTO `t_resource` VALUES ('003', 'ROLE_MAGE', '角色管理', null, '/role/**', '1', '1');
INSERT INTO `t_resource` VALUES ('004', 'RESOURCE_MAGE', '资源管理', null, '/resource/**', '1', '1');
INSERT INTO `t_resource` VALUES ('005', 'ONLINES', '在线用户', null, '/onlines/**', '1', '1');



DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `CODE` varchar(20) NOT NULL COMMENT '名称',
  `NAME` varchar(255) DEFAULT NULL COMMENT '描述',
  `STATUS` smallint(1) DEFAULT '1' COMMENT '状态   1:正常、9：删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `t_role` VALUES ('role_admin', '系统管理员角色', '1');
INSERT INTO `t_role` VALUES ('role_editor', '小辑角色', '1');
INSERT INTO `t_role` VALUES ('role_chief', '主编角色', '1');
INSERT INTO `t_role` VALUES ('role_guest', '访客角色', '1');



DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource` (
  `ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  `RESOURCE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `t_role_resource` VALUES ('04c8cf295d43409aa5e2b9588f46c757', 'role_chief', '001');
INSERT INTO `t_role_resource` VALUES ('196aab914f1048aeb0035e6f7ac1f0ce', 'role_editor', '001001');
INSERT INTO `t_role_resource` VALUES ('4f724ce66fab4345bbaa0a4ca8cee880', 'role_editor', '001');
INSERT INTO `t_role_resource` VALUES ('50b15ddf0a644ba99fd9141c5f7b6819', 'role_admin', '002');
INSERT INTO `t_role_resource` VALUES ('57890ecad7cd41ed96bee3baadb437f3', 'role_chief', '001003');
INSERT INTO `t_role_resource` VALUES ('5d8ca701d25a487b8f3261edb4b7e960', 'role_admin', '003');
INSERT INTO `t_role_resource` VALUES ('6fa0882f72ef4ae08bd61e21aa3fc5c6', 'role_admin', '001');
INSERT INTO `t_role_resource` VALUES ('720ddf52923c49398348eaddca08e182', 'role_admin', '004');
INSERT INTO `t_role_resource` VALUES ('772e6810fea440d29d575e9de9c8f084', 'role_chief', '001002');
INSERT INTO `t_role_resource` VALUES ('f11fb3be7b6744a9bd91f7142a593a6b', 'role_chief', '001001');
INSERT INTO `t_role_resource` VALUES ('f96611e1c89b49bfa68f5efc176a4bb2', 'role_admin', '005');



DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `ACCOUNT` varchar(20) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) NOT NULL COMMENT '密码',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `SEX` smallint(1) DEFAULT NULL COMMENT '性别',
  `PHONE` varchar(13) DEFAULT NULL COMMENT '电话',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `STATUS` smallint(1) DEFAULT '1' COMMENT '状态   1:正常、9：删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `t_user` VALUES ('3a50b501dbf24f7aa2a538ffc3752b1d', 'editor', '2bf376c56d7d8c740519c06522272a54', '小编', null, null, null, '2017-12-15 11:48:45', 'test', '1');
INSERT INTO `t_user` VALUES ('5202f5a818654d3c81228a17ed8ed7e5', 'admin', '2bf376c56d7d8c740519c06522272a54', '管理员', null, null, null, '2017-12-15 11:47:47', 'test', '1');
INSERT INTO `t_user` VALUES ('c008503beffe45ca99305da65bca77ef', 'chief', '2bf376c56d7d8c740519c06522272a54', '主编', null, null, null, '2017-12-15 11:49:05', 'test', '1');
INSERT INTO `t_user` VALUES ('dbec2a5f301b44b0b6f2f07105846aad', 'guest', '2bf376c56d7d8c740519c06522272a54', '访客', null, null, null, '2017-12-15 11:48:15', 'test', '1');



DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `t_user_role` VALUES ('0120120b5d3d43d78c126b030636e6c1', 'c008503beffe45ca99305da65bca77ef', 'role_chief');
INSERT INTO `t_user_role` VALUES ('1ea1ba41242a4eefaa531d1988d2c1b9', '3a50b501dbf24f7aa2a538ffc3752b1d', 'role_editor');
INSERT INTO `t_user_role` VALUES ('44a3e156f54c40a2af00c96447debf34', 'c008503beffe45ca99305da65bca77ef', 'role_admin');
INSERT INTO `t_user_role` VALUES ('9f6e799b797f40bc8a0d3cf817d8d686', 'dbec2a5f301b44b0b6f2f07105846aad', 'role_admin');
INSERT INTO `t_user_role` VALUES ('f332fffd357542da983b0645f113767a', '5202f5a818654d3c81228a17ed8ed7e5', 'role_admin');



DROP TABLE IF EXISTS `t_user_test`;
CREATE TABLE `t_user_test` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `ACCOUNT` varchar(20) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) NOT NULL COMMENT '密码',
  `T_NAME` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `SEX` smallint(1) DEFAULT NULL COMMENT '性别',
  `PHONE` varchar(13) DEFAULT NULL COMMENT '电话',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `STATUS` smallint(1) DEFAULT '1' COMMENT '状态   1:正常、9：删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `t_user_test` VALUES ('52a37e337f164ac79572501192fc1580', 'test', '123456', '测试账号', '1', null, null, null, null, '1');
INSERT INTO `t_user_test` VALUES ('671a1573b6f941dbbf7957e947399b85', 'test2', '456789', '测试账号2', '1', null, null, null, null, '1');
INSERT INTO `t_user_test` VALUES ('8f05babe850d4f8bb6783a0e2fc8b61a', 'test2', '123456', '测试账号2', '1', null, null, null, null, '1');
INSERT INTO `t_user_test` VALUES ('abe417d297aa46f58667855b6a7b3f83', 'test', '123456', '测试账号', '1', null, null, null, null, '1');
INSERT INTO `t_user_test` VALUES ('d33d6818c2164f8186667dc5cbb0c51d', 'test', '123456', '测试账号', '1', null, null, null, null, '1');
INSERT INTO `t_user_test` VALUES ('f9f55d8e23014ac38fd87e20bd8e2041', 'test', '123456', '测试账号', '1', null, null, null, null, '1');