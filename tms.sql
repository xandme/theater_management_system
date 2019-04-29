/*
 Navicat Premium Data Transfer

 Source Server         : wyl
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : tms

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 12/04/2019 16:04:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for child_goods_order
-- ----------------------------
DROP TABLE IF EXISTS `child_goods_order`;
CREATE TABLE `child_goods_order`  (
  `childGoodsOrderId` int(11) NOT NULL COMMENT '子订单编号',
  `goodsId` int(11) UNSIGNED NOT NULL COMMENT '卖品编号',
  `quantity` int(11) NOT NULL DEFAULT 1 COMMENT '商品数量',
  `priceSum` double(10, 2) NOT NULL COMMENT '价格求和',
  PRIMARY KEY (`childGoodsOrderId`) USING BTREE,
  INDEX `fk_goods`(`goodsId`) USING BTREE,
  CONSTRAINT `fk_goods` FOREIGN KEY (`goodsId`) REFERENCES `goods_info` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '存储卖品订单详细信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coupon_info
-- ----------------------------
DROP TABLE IF EXISTS `coupon_info`;
CREATE TABLE `coupon_info`  (
  `couponId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '优惠券信息',
  `couponTypeId` int(11) UNSIGNED NOT NULL COMMENT '优惠券类型编号',
  `userId` int(11) UNSIGNED NOT NULL COMMENT '用户编号',
  `receiveDate` date NULL DEFAULT NULL COMMENT '领取时间',
  `invalidDate` date NULL DEFAULT NULL COMMENT '失效时间',
  `couponStatus` tinyint(1) NOT NULL COMMENT '优惠券状态：未使用、已使用、已失效',
  PRIMARY KEY (`couponId`) USING BTREE,
  UNIQUE INDEX `unique_couponId`(`couponId`) USING BTREE,
  INDEX `fk_user_coupon`(`userId`) USING BTREE,
  INDEX `fk_couponType`(`couponTypeId`) USING BTREE,
  CONSTRAINT `fk_couponType` FOREIGN KEY (`couponTypeId`) REFERENCES `coupon_type` (`couponTypeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_coupon` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '优惠券信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coupon_type
-- ----------------------------
DROP TABLE IF EXISTS `coupon_type`;
CREATE TABLE `coupon_type`  (
  `couponTypeId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '优惠券类型',
  `commodityType` tinyint(1) NOT NULL COMMENT '优惠商品的类型：电影票、卖品',
  `couponDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '优惠券描述',
  `validityPeriod` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '优惠券有效期(单位：天)',
  PRIMARY KEY (`couponTypeId`) USING BTREE,
  UNIQUE INDEX `unique_couponTypeId`(`couponTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for film_arrangement
-- ----------------------------
DROP TABLE IF EXISTS `film_arrangement`;
CREATE TABLE `film_arrangement`  (
  `arrangementId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '影片排片表',
  `filmId` int(11) UNSIGNED NOT NULL COMMENT '影片编号',
  `filmHallNumber` int(11) UNSIGNED NOT NULL COMMENT '影厅编号',
  `date` date NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`arrangementId`) USING BTREE,
  INDEX `fk_film_arrangement`(`filmId`) USING BTREE,
  INDEX `fk_film_hall`(`filmHallNumber`) USING BTREE,
  CONSTRAINT `fk_film_arrangement` FOREIGN KEY (`filmId`) REFERENCES `film_info` (`filmId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_film_hall` FOREIGN KEY (`filmHallNumber`) REFERENCES `film_hall_info` (`filmHallNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for film_hall_info
-- ----------------------------
DROP TABLE IF EXISTS `film_hall_info`;
CREATE TABLE `film_hall_info`  (
  `filmHallNumber` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '影厅编号',
  `filmHallName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '影厅名称（1号厅、2号厅...）',
  `seatQuantity` int(1) NULL DEFAULT NULL COMMENT '座位数量',
  `theaterId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '影院编号',
  PRIMARY KEY (`filmHallNumber`) USING BTREE,
  INDEX `fk_theater_filmHall`(`theaterId`) USING BTREE,
  CONSTRAINT `fk_theater_filmHall` FOREIGN KEY (`theaterId`) REFERENCES `theater_info` (`theaterId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for film_info
-- ----------------------------
DROP TABLE IF EXISTS `film_info`;
CREATE TABLE `film_info`  (
  `filmId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '电影编号',
  `filmName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电影名称',
  `putOnDate` date NULL DEFAULT NULL COMMENT '上映时间',
  `putOffDate` date NULL DEFAULT NULL COMMENT '下映时间',
  `ticketPrice` double(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '票价',
  `filmType` int(2) NULL DEFAULT NULL COMMENT '如喜剧、悲剧、科幻、动画',
  `filmDuration` int(11) NULL DEFAULT NULL COMMENT '影片时长（单位：分钟）',
  `director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '导演',
  `mainActor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要演员',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '语言',
  `filmAvgScore` double(2, 2) NULL DEFAULT NULL COMMENT '影片平均打分',
  `filmStatus` tinyint(1) NULL DEFAULT NULL COMMENT '未上映、已上映、已下映',
  `isEnabled` tinyint(1) NULL DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`filmId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `goodsId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '卖品信息表',
  `theaterId` int(11) UNSIGNED NOT NULL COMMENT '影院编号',
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卖品名称',
  `goodsType` tinyint(1) NOT NULL COMMENT '套餐、小食、饮品、3D眼镜',
  `goodsDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卖品描述',
  `goodsPrice` double(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '卖品价格',
  `goodsPictureURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卖品图片url',
  PRIMARY KEY (`goodsId`) USING BTREE,
  UNIQUE INDEX `unique`(`goodsId`) USING BTREE,
  INDEX `fk_theaterId`(`theaterId`) USING BTREE,
  CONSTRAINT `fk_theaterId` FOREIGN KEY (`theaterId`) REFERENCES `theater_info` (`theaterId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_info
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info`  (
  `memberId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '会员信息表',
  `userId` int(11) UNSIGNED NOT NULL COMMENT '用户编号（未绑定用户时，绑定管理员用户）',
  `memberTypeId` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '会员类型编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `balance` double(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '余额',
  `totalRecharge` double(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '累计充值',
  `payPassword` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '000000' COMMENT '支付密码',
  `totalSave` double(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '累计节省',
  PRIMARY KEY (`memberId`) USING BTREE,
  UNIQUE INDEX `VipId_UNIQUE`(`memberId`) USING BTREE,
  INDEX `FK_user_member_idx`(`userId`) USING BTREE,
  INDEX `vipType_idx`(`memberTypeId`) USING BTREE,
  CONSTRAINT `FK_memInfo_memType` FOREIGN KEY (`memberTypeId`) REFERENCES `member_type` (`memberTypeId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_user_menber` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_type
-- ----------------------------
DROP TABLE IF EXISTS `member_type`;
CREATE TABLE `member_type`  (
  `memberTypeId` tinyint(1) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '会员类型表',
  `memberTypeName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员类型名称(黄金会员、白金会员、钻石会员)',
  `discount` double(10, 2) UNSIGNED NOT NULL COMMENT '折扣(9、8.5、8)',
  PRIMARY KEY (`memberTypeId`) USING BTREE,
  UNIQUE INDEX `typeId_UNIQUE`(`memberTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_type
-- ----------------------------
INSERT INTO `member_type` VALUES (1, '黄金会员', 0.90);
INSERT INTO `member_type` VALUES (2, '白金会员', 0.85);
INSERT INTO `member_type` VALUES (3, '钻石会员', 0.80);

-- ----------------------------
-- Table structure for seat_info
-- ----------------------------
DROP TABLE IF EXISTS `seat_info`;
CREATE TABLE `seat_info`  (
  `seatId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '座位编号',
  `filmHallNumber` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '影厅编号',
  `sequence` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '序号（相对于影厅中的序号）',
  `seatRow` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '行号',
  `seatColumn` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '列号',
  `isEnabled` tinyint(1) NULL DEFAULT NULL COMMENT '是否能用（损坏）',
  PRIMARY KEY (`seatId`) USING BTREE,
  INDEX `fk_filmHall_seat`(`filmHallNumber`) USING BTREE,
  CONSTRAINT `fk_filmHall_seat` FOREIGN KEY (`filmHallNumber`) REFERENCES `film_hall_info` (`filmHallNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '存储所有影院所有影厅的座位信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seat_selection_situation
-- ----------------------------
DROP TABLE IF EXISTS `seat_selection_situation`;
CREATE TABLE `seat_selection_situation`  (
  `seatSelectionId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '选座编号',
  `arrangementId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '排片编号',
  `filmOrderId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '订单编号',
  `seatStatus` tinyint(1) NOT NULL DEFAULT 0 COMMENT '可选、已售、不可选（损坏）',
  PRIMARY KEY (`seatSelectionId`) USING BTREE,
  INDEX `fk_arrangement`(`arrangementId`) USING BTREE,
  INDEX `fk_filmOrder`(`filmOrderId`) USING BTREE,
  CONSTRAINT `fk_arrangement` FOREIGN KEY (`arrangementId`) REFERENCES `film_arrangement` (`arrangementId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_filmOrder` FOREIGN KEY (`filmOrderId`) REFERENCES `user_film_order` (`filmOrderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for theater_info
-- ----------------------------
DROP TABLE IF EXISTS `theater_info`;
CREATE TABLE `theater_info`  (
  `theaterId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '影院编号',
  `theaterName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影院名称',
  `theaterAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '影院地址',
  `phoneNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `theaterDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '影院详情',
  PRIMARY KEY (`theaterId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '用户信息表',
  `nickname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别（女0男1）',
  `telephone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电话(登录名)',
  `loginPassword` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '123456' COMMENT '登录密码',
  `headPhotoURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `isMember` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否为会员',
  `integral` int(255) UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `userID_UNIQUE`(`userId`) USING BTREE,
  UNIQUE INDEX `userTel_UNIQUE`(`telephone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (00000000001, '默认用户', 1, '18983752579', '123456', NULL, '2019-04-07', 0, 0);

-- ----------------------------
-- Table structure for user_film_info
-- ----------------------------
DROP TABLE IF EXISTS `user_film_info`;
CREATE TABLE `user_film_info`  (
  `userFilmInfoId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '用户&影片—信息表',
  `userId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '用户编号',
  `filmId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '影片编号',
  `isWant` tinyint(1) NULL DEFAULT NULL COMMENT '是否想看',
  `isWatched` tinyint(1) NULL DEFAULT NULL COMMENT '是否看过',
  `filmReview` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '影评',
  `filmScore` double(2, 2) NULL DEFAULT NULL COMMENT '影片打分',
  PRIMARY KEY (`userFilmInfoId`) USING BTREE,
  INDEX `fk_user_film`(`userId`) USING BTREE,
  INDEX `fk_film_info`(`filmId`) USING BTREE,
  CONSTRAINT `fk_film_info` FOREIGN KEY (`filmId`) REFERENCES `film_info` (`filmId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_film` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_film_order
-- ----------------------------
DROP TABLE IF EXISTS `user_film_order`;
CREATE TABLE `user_film_order`  (
  `filmOrderId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '电影票订单信息表',
  `arrangementId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '排片编号',
  `userId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '用户 编号',
  `parentOrderId` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '子订单编号(储存同一张订单，多个座位号)',
  `seatId` int(11) NULL DEFAULT NULL COMMENT '座位编号',
  `orderStatus` tinyint(1) NOT NULL DEFAULT 0 COMMENT '未付款、已失效、已付款、已完成',
  `createdTime` timestamp(0) NOT NULL COMMENT '订单生成时间',
  PRIMARY KEY (`filmOrderId`) USING BTREE,
  INDEX `fk_user_filmOrder`(`userId`) USING BTREE,
  INDEX `fk_filmOrder_arrange`(`arrangementId`) USING BTREE,
  INDEX `fk_parentOrder`(`parentOrderId`) USING BTREE,
  CONSTRAINT `fk_filmOrder_arrange` FOREIGN KEY (`arrangementId`) REFERENCES `film_arrangement` (`arrangementId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_parentOrder` FOREIGN KEY (`parentOrderId`) REFERENCES `user_film_order` (`filmOrderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_filmOrder` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_goods_order
-- ----------------------------
DROP TABLE IF EXISTS `user_goods_order`;
CREATE TABLE `user_goods_order`  (
  `goodsOrderId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '卖品订单表',
  `userId` int(11) UNSIGNED NOT NULL COMMENT '用户编号',
  `childGoodsOrderId` int(10) UNSIGNED NOT NULL COMMENT '子订单编号（订单详情）',
  `couponId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '使用优惠券，可以为空，不作外键',
  `goodsOrderPrice` double(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '订单总价',
  `actualPayPrice` double(10, 2) NULL DEFAULT NULL COMMENT '实际支付价格',
  PRIMARY KEY (`goodsOrderId`) USING BTREE,
  INDEX `fk_user_goods`(`userId`) USING BTREE,
  CONSTRAINT `fk_user_goods` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_theater_info
-- ----------------------------
DROP TABLE IF EXISTS `user_theater_info`;
CREATE TABLE `user_theater_info`  (
  `userTheaterInfoId` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '用户&影院--信息表',
  `userId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '用户编号',
  `theaterId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '影院编号',
  `goToFrequency` int(11) NULL DEFAULT NULL COMMENT '去过次数',
  `isFavorites` tinyint(1) NULL DEFAULT NULL COMMENT '是否收藏',
  PRIMARY KEY (`userTheaterInfoId`) USING BTREE,
  INDEX `fk_user_theaterInfo`(`userId`) USING BTREE,
  INDEX `fk_theater_theaterInfo`(`theaterId`) USING BTREE,
  CONSTRAINT `fk_theater_theaterInfo` FOREIGN KEY (`theaterId`) REFERENCES `theater_info` (`theaterId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_theaterInfo` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
