-- ----------------------------
-- Table structure for `game`
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `player_one` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `player_two` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `project_id` bigint DEFAULT NULL COMMENT '比赛项目id',
  `type` tinyint DEFAULT NULL COMMENT '0：赛前 1：赛中 2：赛后',
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', '胡林浩', '张博', '1', '0', '2020-06-22 01:08:48', null);
INSERT INTO `game` VALUES ('2', '郭磊', '张博', '1', '0', '2020-06-22 01:14:26', null);
INSERT INTO `game` VALUES ('3', '锅炉王', '三巨头', '2', '0', '2020-06-22 22:07:43', null);
INSERT INTO `game` VALUES ('4', '打铁匠', '陌上花开', '2', '0', '2020-06-22 22:09:02', null);

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `plate_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL COMMENT '下注金额',
  `type` tinyint DEFAULT NULL COMMENT '0:未结算  1：已结算',
  `settlement_amount` decimal(10,0) DEFAULT NULL COMMENT '结算金额',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `plate`
-- ----------------------------
DROP TABLE IF EXISTS `plate`;
CREATE TABLE `plate` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `game_id` bigint DEFAULT NULL COMMENT '比赛id',
  `content` varchar(20) DEFAULT NULL COMMENT '盘口内容',
  `odds` decimal(10,2) DEFAULT NULL COMMENT '赔率',
  `type` tinyint DEFAULT NULL COMMENT '0:可下注 1:盘口过期 3：已赔付',
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `paid_time` datetime DEFAULT NULL COMMENT '赔付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='盘口';

-- ----------------------------
-- Records of plate
-- ----------------------------
INSERT INTO `plate` VALUES ('1', '1', '胜', '1.55', '0', '2020-06-22 22:38:28', null, null);
INSERT INTO `plate` VALUES ('2', '1', '败', '1.55', '0', '2020-06-22 22:38:31', null, null);
INSERT INTO `plate` VALUES ('3', '1', '0:3', '1.55', '0', '2020-06-22 22:38:35', null, null);
INSERT INTO `plate` VALUES ('4', '1', '1:3', '1.55', '0', '2020-06-22 22:38:39', null, null);
INSERT INTO `plate` VALUES ('5', '1', '2:3', '1.55', '0', '2020-06-22 22:38:42', null, null);
INSERT INTO `plate` VALUES ('6', '1', '3:0', '1.55', '0', '2020-06-22 22:38:44', null, null);
INSERT INTO `plate` VALUES ('7', '1', '3:1', '1.55', '0', '2020-06-22 22:38:49', null, null);
INSERT INTO `plate` VALUES ('8', '1', '3:2', '1.55', '0', '2020-06-22 22:38:51', null, null);
INSERT INTO `plate` VALUES ('9', '2', '胜', '1.55', '0', '2020-06-22 22:38:28', null, null);
INSERT INTO `plate` VALUES ('10', '2', '败', '1.55', '0', '2020-06-22 22:38:31', null, null);
INSERT INTO `plate` VALUES ('11', '2', '0:3', '1.55', '0', '2020-06-22 22:38:35', null, null);
INSERT INTO `plate` VALUES ('12', '2', '1:3', '1.55', '0', '2020-06-22 22:38:39', null, null);
INSERT INTO `plate` VALUES ('13', '2', '2:3', '1.55', '0', '2020-06-22 22:38:42', null, null);
INSERT INTO `plate` VALUES ('14', '2', '3:0', '1.55', '0', '2020-06-22 22:38:44', null, null);
INSERT INTO `plate` VALUES ('15', '2', '3:1', '1.55', '0', '2020-06-22 22:38:49', null, null);
INSERT INTO `plate` VALUES ('16', '2', '3:2', '1.55', '0', '2020-06-22 22:38:51', null, null);
INSERT INTO `plate` VALUES ('17', '3', '胜', '2.55', '0', '2020-06-22 22:43:56', null, null);
INSERT INTO `plate` VALUES ('18', '3', '败', '2.55', '0', '2020-06-22 22:44:14', null, null);
INSERT INTO `plate` VALUES ('19', '4', '胜', '2.66', '0', '2020-06-22 22:44:40', null, null);
INSERT INTO `plate` VALUES ('20', '4', '败', '2.66', '0', '2020-06-22 22:44:43', null, null);

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` tinyint DEFAULT NULL COMMENT '1：台球   2：篮球',
  `img` varchar(100) DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='比赛项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '台球', '1', null, '光信台球杯', '2020-06-22 01:06:41');
INSERT INTO `project` VALUES ('2', '篮球', '2', null, '光信篮球杯', '2020-06-22 01:06:53');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `wx_appid` varchar(100) DEFAULT NULL,
  `wx_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `glod` decimal(20,2) DEFAULT NULL COMMENT '现有金币',
  `pay_glod` decimal(20,2) DEFAULT NULL COMMENT '累计充值金币',
  `withdraw_glod` decimal(20,2) DEFAULT NULL COMMENT '累计提现金币',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
