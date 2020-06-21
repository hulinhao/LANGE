DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `player_one` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `player_two` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pro_id` bigint DEFAULT NULL COMMENT '椤圭洰id',
  `odds` decimal(10,2) DEFAULT NULL COMMENT '璧旂巼',
  `type` tinyint DEFAULT NULL COMMENT '0:鏈夋晥 1锛氭棤鏁?',
  `create_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', '胡林浩', '张博', '1', '1.88', '0', '2020-06-22 01:08:48', null);
INSERT INTO `game` VALUES ('2', '郭磊', '张博', '1', '1.26', '0', '2020-06-22 01:14:26', null);

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` tinyint DEFAULT NULL COMMENT '1：台球   2：篮球',
  `img` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='比赛项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '台球', '1', null, '2020-06-22 01:06:41');
INSERT INTO `project` VALUES ('2', '篮球', '2', null, '2020-06-22 01:06:53');
