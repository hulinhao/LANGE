
CREATE TABLE `bills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plate_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL COMMENT '下注金额',
  `type` tinyint(4) DEFAULT NULL COMMENT '0:等待接单 1:未结算  2：已结算 3:已赔付',
  `settlement_amount` decimal(10,2) DEFAULT NULL COMMENT '结算金额',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES ('239', '1', '26', '100.00', '0', null, '2020-07-01 13:59:35', null);
INSERT INTO `bills` VALUES ('240', '136', '26', '100.00', '0', null, '2020-07-01 14:00:33', null);
INSERT INTO `bills` VALUES ('241', '138', '30', '12.00', '0', null, '2020-07-01 14:11:56', null);
INSERT INTO `bills` VALUES ('242', '138', '32', '20.00', '0', null, '2020-07-01 14:49:38', null);
INSERT INTO `bills` VALUES ('243', '146', '32', '20.00', '0', null, '2020-07-01 14:51:25', null);

-- ----------------------------
-- Table structure for `forecast`
-- ----------------------------
DROP TABLE IF EXISTS `forecast`;
CREATE TABLE `forecast` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `relate` tinyint(4) DEFAULT NULL COMMENT '1：关联比赛 2:关联项目   ',
  `type` tinyint(4) DEFAULT NULL COMMENT '1:单盘  2：多盘',
  `content` varchar(255) DEFAULT NULL COMMENT '预测内容',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='比赛预测表';

-- ----------------------------
-- Records of forecast
-- ----------------------------
INSERT INTO `forecast` VALUES ('1', '1', '1', '1', '2', '胜出者', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('2', '1', '1', '1', '1', '0：3', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('3', '1', '1', '1', '1', '1：3', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('4', '1', '1', '1', '1', '2：3', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('5', '1', '1', '1', '1', '3：0', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('6', '1', '1', '1', '1', '3：1', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('7', '1', '1', '1', '1', '3：2', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('8', null, '1', '2', '2', '冠军', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('9', null, '2', '2', '2', '冠军', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('10', null, '1', '2', '2', 'A组冠军', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('11', null, '1', '2', '2', 'B组冠军', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('12', '2', '1', '1', '1', '0：3', '2020-07-01 10:22:25');
INSERT INTO `forecast` VALUES ('13', '2', '1', '1', '1', '1：3', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('14', '2', '1', '1', '1', '2：3', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('15', '2', '1', '1', '1', '3：0', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('16', '2', '1', '1', '1', '3：1', '2020-06-25 22:02:57');
INSERT INTO `forecast` VALUES ('17', '2', '1', '1', '1', '3：2', '2020-06-25 22:02:57');

-- ----------------------------
-- Table structure for `game`
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `player_one` varchar(20) DEFAULT NULL,
  `player_two` varchar(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL COMMENT '比赛项目id',
  `type` tinyint(4) DEFAULT NULL COMMENT '0：赛前 1：赛中 2：赛后',
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='赛程表';

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', '胡林浩', '张博', '1', '0', '2020-06-22 01:08:48', null);
INSERT INTO `game` VALUES ('2', '郭磊', '卢总', '1', '0', '2020-06-22 01:14:26', null);
INSERT INTO `game` VALUES ('3', '锅炉王', '三巨头', '2', '0', '2020-06-22 22:07:43', null);
INSERT INTO `game` VALUES ('4', '打铁匠', '发球机器', '2', '0', '2020-06-22 22:09:02', null);
INSERT INTO `game` VALUES ('7', '锅炉王', '发球机器', '2', '0', '2020-06-24 17:26:33', null);

-- ----------------------------
-- Table structure for `plate`
-- ----------------------------
DROP TABLE IF EXISTS `plate`;
CREATE TABLE `plate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `forecast_id` bigint(20) DEFAULT NULL COMMENT '预测结果表id',
  `content` varchar(20) DEFAULT NULL COMMENT '盘口内容',
  `odds` decimal(10,2) DEFAULT NULL COMMENT '赔率',
  `status` tinyint(4) DEFAULT NULL COMMENT '0:可下注 1:盘口过期 3：已赔付',
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `paid_time` datetime DEFAULT NULL COMMENT '赔付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COMMENT='盘口表';

-- ----------------------------
-- Records of plate
-- ----------------------------
INSERT INTO `plate` VALUES ('1', '9', '锅炉王', '0.00', '0', '2020-06-25 22:10:36', null, null);
INSERT INTO `plate` VALUES ('2', '9', '发球机器', '0.00', '0', '2020-06-29 23:58:04', null, null);
INSERT INTO `plate` VALUES ('3', '7', '3：2', '0.00', '1', '2020-06-30 00:03:56', '2020-07-01 14:12:14', null);
INSERT INTO `plate` VALUES ('4', '10', '田虎', '0.00', '0', '2020-06-30 00:21:06', null, null);
INSERT INTO `plate` VALUES ('5', '9', '打铁匠', '0.00', '0', '2020-06-30 00:28:43', null, null);
INSERT INTO `plate` VALUES ('6', '10', '丁林浩', '0.00', '0', '2020-06-30 00:36:54', null, null);
INSERT INTO `plate` VALUES ('7', '5', '3：0', '0.00', '1', '2020-06-30 00:49:42', '2020-07-01 14:12:03', null);
INSERT INTO `plate` VALUES ('9', '2', '0：3', '0.00', '1', '2020-06-30 00:59:51', '2020-07-01 14:11:25', null);
INSERT INTO `plate` VALUES ('10', '1', '胡林浩', '0.00', '1', '2020-06-30 01:04:33', '2020-07-01 14:11:39', null);
INSERT INTO `plate` VALUES ('11', '8', '张博', '0.00', '1', '2020-06-30 01:12:37', '2020-07-01 14:51:56', null);
INSERT INTO `plate` VALUES ('12', '8', '卢总', '0.00', '0', '2020-06-30 01:12:47', null, null);
INSERT INTO `plate` VALUES ('13', '3', '1：3', '0.00', '1', '2020-06-30 01:12:59', '2020-07-01 14:11:50', null);
INSERT INTO `plate` VALUES ('14', '4', '2：3', '0.00', '1', '2020-06-30 01:13:14', '2020-07-01 14:11:55', null);
INSERT INTO `plate` VALUES ('15', '9', '三巨头', '0.00', '0', '2020-06-30 02:04:26', null, null);
INSERT INTO `plate` VALUES ('16', '8', '王亚楠', '0.00', '1', '2020-06-30 02:06:09', '2020-07-01 14:52:21', null);
INSERT INTO `plate` VALUES ('17', '1', '张博', '0.00', '1', '2020-06-30 23:53:45', '2020-07-01 14:11:33', null);
INSERT INTO `plate` VALUES ('129', '11', '卢总', '0.00', '0', '2020-07-01 10:18:26', null, null);
INSERT INTO `plate` VALUES ('130', '11', '郭磊', '0.00', '0', '2020-07-01 10:18:55', null, null);
INSERT INTO `plate` VALUES ('131', '6', '3：1', '0.00', '1', '2020-07-01 10:24:33', '2020-07-01 14:12:09', null);
INSERT INTO `plate` VALUES ('132', '12', '0：3', '0.00', '0', '2020-07-01 10:24:33', null, null);
INSERT INTO `plate` VALUES ('133', '13', '1：3', '0.00', '0', '2020-07-01 10:24:33', null, null);
INSERT INTO `plate` VALUES ('134', '14', '0：3', '0.00', '0', '2020-07-01 10:24:33', null, null);
INSERT INTO `plate` VALUES ('135', '15', '3：0', '0.00', '0', '2020-07-01 10:24:33', null, null);
INSERT INTO `plate` VALUES ('136', '16', '3：1', '0.00', '0', '2020-07-01 10:24:33', null, null);
INSERT INTO `plate` VALUES ('137', '17', '3：2', '0.00', '0', '2020-07-01 10:24:33', null, null);
INSERT INTO `plate` VALUES ('138', '2', '0：3', '0.10', '1', '2020-07-01 14:11:25', '2020-07-01 14:50:36', null);
INSERT INTO `plate` VALUES ('139', '1', '张博', '0.20', '0', '2020-07-01 14:11:33', null, null);
INSERT INTO `plate` VALUES ('140', '1', '胡林浩', '0.30', '0', '2020-07-01 14:11:39', null, null);
INSERT INTO `plate` VALUES ('141', '3', '1：3', '0.40', '0', '2020-07-01 14:11:50', null, null);
INSERT INTO `plate` VALUES ('142', '4', '2：3', '0.50', '0', '2020-07-01 14:11:55', null, null);
INSERT INTO `plate` VALUES ('143', '5', '3：0', '0.60', '0', '2020-07-01 14:12:03', null, null);
INSERT INTO `plate` VALUES ('144', '6', '3：1', '0.70', '0', '2020-07-01 14:12:09', null, null);
INSERT INTO `plate` VALUES ('145', '7', '3：2', '0.80', '0', '2020-07-01 14:12:14', null, null);
INSERT INTO `plate` VALUES ('146', '2', '0：3', '0.50', '0', '2020-07-01 14:50:36', null, null);
INSERT INTO `plate` VALUES ('147', '8', '张博', '1.00', '0', '2020-07-01 14:51:56', null, null);
INSERT INTO `plate` VALUES ('148', '8', '王亚楠', '1.00', '0', '2020-07-01 14:52:21', null, null);

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '1：台球   2：篮球',
  `img` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0:进行中  1:完结',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='比赛项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '第一届“光信数科杯”台球争霸赛', '1', 'taiqiu.png', '响应号召，积极参与到体育赛事中，锻炼身体', '0', '2020-06-22 01:06:41');
INSERT INTO `project` VALUES ('2', '第一届“光信数科杯”篮球争霸赛', '2', 'lanqiu.png', '友谊第一，比赛第二。', '0', '2020-06-22 01:06:53');
INSERT INTO `project` VALUES ('4', '第一届“光信数科杯”街机争霸赛', '3', 'jieji.png', '强身健体，报效祖国', '0', null);
INSERT INTO `project` VALUES ('5', '第一届“光信数科杯”羽毛球争霸赛', '4', 'yumaoqiu.png', '拼搏，努力，奋斗', '0', '2020-06-24 09:58:39');
INSERT INTO `project` VALUES ('6', '第一届“光信数科杯”乒乓球争霸赛', '5', 'pinpangqiu.png', '用小球带动大球', '0', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wx_openid` varchar(100) DEFAULT NULL,
  `wx_name` varchar(50) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '微信图片地址',
  `name` varchar(50) DEFAULT NULL,
  `gold` decimal(20,2) DEFAULT NULL COMMENT '现有金币',
  `pay_gold` decimal(20,2) DEFAULT NULL COMMENT '累计充值金币',
  `withdraw_gold` decimal(20,2) DEFAULT NULL COMMENT '累计提现金币',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:客户 1:管理赛程  2:管理赔率，金币',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('21', 'oG9Hi5M07wW5LgU75cRr8k_gZOU0', '慢慢。', 'https://wx.qlogo.cn/mmopen/vi_32/unp45De2IPJaO73JaWtew19l7JY4Nz0s4tCokMbniajicsJNv6dyLFZqZ1gfKA6XHca2u4q0W3fG697zPlWo1cew/132', '胡林浩', '0.00', '0.00', '0.00', '2', '2020-06-30 23:48:13', '2020-07-01 00:22:16');
INSERT INTO `user` VALUES ('26', 'oG9Hi5GwsdepOJKwef8fItB8hhyQ', 'Andy 卢', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoM6TLuZibpunsXrjLIejHtWnCDUCEkCU1Moybibib7UBqLYIGvTAjquQMqlaywpXN2y5EudQpvLorWg/132', '老卢', '-200.00', '0.00', '0.00', '0', '2020-07-01 13:59:10', '2020-07-01 14:00:33');
INSERT INTO `user` VALUES ('27', 'oG9Hi5AOAUP_7illWGTtdwKQ-bYM', '九局下半', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLNmoxytQfu8QKQ0vHvPA8w2QGAic6121TdhianZFtRP1Gn3iaCEamgia9Q7ickP0adRSRUS6ahib3gm34g/132', '张博', '0.00', '0.00', '0.00', '0', '2020-07-01 14:06:12', null);
INSERT INTO `user` VALUES ('28', 'oG9Hi5Gq9AOhWn8RRFahU3ZLy91Q', 'Fighting ', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI173mkvqqWbqVcQj8gEZlnmz9sloyx05dHxB8MA8ibClSYWMic4FEyqCID9Q5hrMGpCDRX5XRVUJlA/132', '王闯', '0.00', '0.00', '0.00', '0', '2020-07-01 14:06:33', null);
INSERT INTO `user` VALUES ('29', 'oG9Hi5FgD2BzFeqc-wZ-DhC8s6Dg', '嘿人太黑', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJroWicJMYQNEibuhjGddia8IDKIHbUcmic4BWIsySCEMDs2enDVdKSdLuWbj20QU8feWz6ibNYv4mk4Wg/132', '程盼', '0.00', '0.00', '0.00', '0', '2020-07-01 14:08:08', null);
INSERT INTO `user` VALUES ('30', 'oG9Hi5CX2wDBG8t1a_FoInnGoCAo', 'HuanFan', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ervF9yGOtSibIYIOw5jelDuEgt7FSZGP6OHkco5xDU6lSWKicsSgWIrIfl0qcljQIyyGTrRkz6xvmeg/132', '范声焕', '-12.00', '0.00', '0.00', '0', '2020-07-01 14:10:20', '2020-07-01 14:11:56');
INSERT INTO `user` VALUES ('31', 'oG9Hi5N7AhQ8VXdxMgMyVr6HReRM', '旺仔', 'https://wx.qlogo.cn/mmopen/vi_32/CQYFzLfawOM35d2wkkZeibGibofCMC89s3ibHGxeb4zlNKfMK3tggWnlRU7yCNyiaL3sq2nvxzw3BmynSO2JiajdhpQ/132', '潘旺', '0.00', '0.00', '0.00', '0', '2020-07-01 14:12:56', null);
INSERT INTO `user` VALUES ('32', 'oG9Hi5OvdoktkwzXuiB4P7YLLtM0', '青豆', 'https://wx.qlogo.cn/mmopen/vi_32/icBuNQhEy1W2kaiaWhcuQOK7e5FYbTicg2Lniciar4icMZeia1CLUcmcxjq4m5e69rLDXPVcyu0T7jxOBJHKopc2Zhasw/132', null, '-40.00', '0.00', '0.00', '0', '2020-07-01 14:49:10', '2020-07-01 14:51:25');
