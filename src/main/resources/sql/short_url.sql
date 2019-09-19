SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for url_info
-- ----------------------------
DROP TABLE IF EXISTS `url_info`;
CREATE TABLE `url_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(255) NOT NULL DEFAULT '' COMMENT '原始网址',
  `short_url` varchar(255) NOT NULL DEFAULT '' COMMENT '短连接名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除： 0 未删除 1 已经删除',
  `c_t` int(11) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `u_t` int(11) NOT NULL DEFAULT 0 COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of url_info
-- ----------------------------
INSERT INTO `url_info` VALUES ('1', 'http://blog.collmall.com', 'sgkYFd8NdggI18gAhkIt8IBNFJN9', '0', '0', '0');
INSERT INTO `url_info` VALUES ('2', 'http://www.dogedoge.com', 'RlUh44oZdg8MRpgcYtY5oAd0sMxp', '0', '1568906467', '1568906467');
