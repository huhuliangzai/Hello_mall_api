/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : hellomall

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 24/06/2023 16:04:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carousel_img
-- ----------------------------
DROP TABLE IF EXISTS `carousel_img`;
CREATE TABLE `carousel_img`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel_img
-- ----------------------------
INSERT INTO `carousel_img` VALUES (1, '1.jpg');
INSERT INTO `carousel_img` VALUES (2, '2.jpg');
INSERT INTO `carousel_img` VALUES (3, '3.jpg');
INSERT INTO `carousel_img` VALUES (4, '4.jpg');
INSERT INTO `carousel_img` VALUES (5, '5.jpg');
INSERT INTO `carousel_img` VALUES (6, '6.jpg');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `user_id` bigint NOT NULL COMMENT '用户ID，关联用户表',
  `carts_created_at` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '购物车创建时间',
  `carts_update_at` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '购物车更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1670685196201672707 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of carts
-- ----------------------------
INSERT INTO `carts` VALUES (1, 1, '2023-06-11 16:46:17', '2023-06-11 16:46:20');
INSERT INTO `carts` VALUES (1382209566523392, 1382209566490624, '2023-06-20 21:25:37', '2023-06-20 21:25:37');

-- ----------------------------
-- Table structure for carts_items
-- ----------------------------
DROP TABLE IF EXISTS `carts_items`;
CREATE TABLE `carts_items`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车商品ID',
  `cart_id` bigint NOT NULL COMMENT '购物车ID,关联购物车表',
  `product_id` bigint NOT NULL COMMENT '商品ID，关联商品表',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `Quantity` bigint NULL DEFAULT NULL COMMENT '商品数量',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品主图',
  `total` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1382332674138113 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carts_items
-- ----------------------------
INSERT INTO `carts_items` VALUES (1382209690427392, 1382209566523392, 27, '冷冻雪花肥牛', 59.00, 2, 'hot_push/1.jpg', 118.00);
INSERT INTO `carts_items` VALUES (1382332635561984, 1, 27, '冷冻雪花肥牛', 59.00, 1, 'hot_push/1.jpg', 59.00);

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '分类名称',
  `parent_id` int NULL DEFAULT NULL COMMENT '父分类ID，表示当前分类是哪个分类的子分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, '牛肉类', NULL);
INSERT INTO `categories` VALUES (2, '猪肉类', NULL);
INSERT INTO `categories` VALUES (3, '鸡肉类', NULL);
INSERT INTO `categories` VALUES (4, '热销', NULL);
INSERT INTO `categories` VALUES (5, '疯抢', NULL);
INSERT INTO `categories` VALUES (6, '热推', NULL);

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` bigint NOT NULL COMMENT '收藏id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for complaints
-- ----------------------------
DROP TABLE IF EXISTS `complaints`;
CREATE TABLE `complaints`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '投诉Id',
  `user_id` bigint NOT NULL COMMENT '投诉用户ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `complaint` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '投诉内容',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1382475981340673 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complaints
-- ----------------------------
INSERT INTO `complaints` VALUES (1, 1, '蔡老六', '太好吃啦', '1380000000');

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单详情ID',
  `order_id` bigint NOT NULL COMMENT '订单ID,关联订单表',
  `product_id` bigint NOT NULL COMMENT '商品ID，关联商品表',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品数量',
  `order_total` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '收货人',
  `shipping_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '收货地址',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '订单状态，1为已收货，2为配送中，3为待收货',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1382466125127686 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_details
-- ----------------------------
INSERT INTO `order_details` VALUES (1, 1, 1, 'M6级雪花牛排', 138.00, '1', 138.00, '蔡老六', '广东省中山市博爱七路25号中山职业技术学院', '1');
INSERT INTO `order_details` VALUES (2, 2, 2, 'M9原切雪花牛排', 356.00, '1', 356.00, '蔡老六', '广东省中山市博爱七路25号中山职业技术学院', '2');
INSERT INTO `order_details` VALUES (3, 3, 3, '原切雪花和牛牛肉粒', 358.00, '1', 358.00, '蔡老六', '广东省中山市博爱七路25号中山职业技术学院', '3');
INSERT INTO `order_details` VALUES (1382466125127685, 1382467863650304, 27, '冷冻雪花肥牛', 59.00, '1', 59.00, '谢靓仔', '广东惠州市惠城区', '3');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint NOT NULL COMMENT '用户ID,关联用户表',
  `orders_created_at` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `orders_updated_at` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1382467863650305 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, '2023-06-14 21:32:47', '2023-06-14 21:32:51');
INSERT INTO `orders` VALUES (2, 1, '2023-06-14 21:33:40', '2023-06-14 21:33:40');
INSERT INTO `orders` VALUES (3, 1, '2023-06-14 21:33:31', '2023-06-14 21:33:34');
INSERT INTO `orders` VALUES (1382467863650304, 1, '2023-06-24 13:00:41', '2023-06-24 13:00:41');

-- ----------------------------
-- Table structure for product_attributes
-- ----------------------------
DROP TABLE IF EXISTS `product_attributes`;
CREATE TABLE `product_attributes`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品属性id',
  `product_attribute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品属性名',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '属性值，例如300g',
  `product_id` int NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_attributes
-- ----------------------------

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品描述',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品库存数量',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '商品主图',
  `category_id` int NOT NULL COMMENT '商品分类ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (1, 'M6级雪花牛排', '高等极佳级的牛肉分切肌肉间脂肪含量达11%或以上，一般极佳级的牛肉分切肌肉间脂肪含量达9.5%至11% ，次等极佳级的牛肉分切肌肉间脂肪含量达8%至9.5%', 138.00, '500g', 'category_beef/1.jpg', 1);
INSERT INTO `products` VALUES (2, 'M9原切雪花牛排', '高等特选级的牛肉分切肌肉间脂肪含量达7%至8%，一般特选级的牛肉分切肌肉间脂肪含量达5%至6%，次等特选级的牛肉分切肌肉间脂肪含量达4%至5%', 356.00, '500g', 'category_beef/2.jpg', 1);
INSERT INTO `products` VALUES (3, '原切雪花和牛牛肉粒', '含有大量人体所需的脂肪酸，营养价值远远高于普通牛肉。 牛肉方块对切保证了纯厚的口感，也更加耐嚼。 牛肉粒鲜嫩多汁，补脾养胃', 358.00, '500g', 'category_beef/3.jpg', 1);
INSERT INTO `products` VALUES (4, '西冷原切雪花牛排', '当先原切西冷牛排原肉原切，鲜嫩多汁。 纯原切、0添加、非合成、雪花纹理，层次感丰富，轻轻咀嚼肉汁四溢', 288.00, '500g', 'category_beef/4.jpg', 1);
INSERT INTO `products` VALUES (5, 'M6眼肉牛排', '由于取自牛只最不经常活动的上腰部，运动量非常少，也就肉质鲜嫩，油花丰富。 不同于西冷的油花分布在边缘，眼肉的油花多而分布均匀，形成了漂亮的大理石纹，红白相间，成就了眼肉的超高颜值。 因此眼肉牛排被称为beauty steak——美人牛排', 210.00, '500g', 'category_beef/5.jpg', 1);
INSERT INTO `products` VALUES (6, '寿喜烧套餐', '寿喜烧发展至今，仍然分成关东风和关西风两大流派。但作为庶民料理，每家每户使用的食材、调味、甚至制作流程都有着千差万别。就是说，寿喜烧不像寿司、天妇罗、鳗鱼饭，并非很严肃的料理，在民间变化比较多', 168.00, '500g', 'category_beef/6.jpg', 1);
INSERT INTO `products` VALUES (7, '牛肉汉堡肉饼', '牛肉汉堡肉饼是一道简单的家常菜，主料是牛绞肉，鸡蛋，洋葱末，姜末，去边白吐司，牛奶，板油', 250.00, '904g', 'category_beef/hot_recommend/1.jpg', 4);
INSERT INTO `products` VALUES (8, '牛腱子肉原切', '牛四条腿大腿部分的肉。因为牛会经常活动，所以这一部分的肉肌肉纤维粗，带筋，少脂肪，有嚼劲', 77.00, '1.5kg', 'category_beef/hot_recommend/2.jpg', 4);
INSERT INTO `products` VALUES (9, '国产谷饲肥牛卷', '国内不可多得的西餐用肉食材。 活体重量可达650公斤以上，屠宰率高达55%以上，20%-30%的大型牧场出栏可达7-8百公斤，部分屠宰率高达60%', 158.00, '500g', 'category_beef/hot_recommend/3.jpg', 4);
INSERT INTO `products` VALUES (10, '新鲜大猪蹄', '猪蹄，是指猪的脚部（蹄）和小腿，在中国又叫元蹄。在华人世界中，猪蹄是经常被人食用的部位之一，有多种不同的烹调做法。猪蹄含有丰富的胶原蛋白质，脂肪含量也比肥肉低', 138.00, '2kg', 'category_pig/3.jpg', 2);
INSERT INTO `products` VALUES (11, '厚切猪排', '厚切猪排厚切猪排厚切猪排厚切猪排厚切猪排厚切猪排厚切猪排厚切猪排', 56.00, '500g', 'category_pig/2.jpg', 2);
INSERT INTO `products` VALUES (12, '猪廋肉', '猪瘦肉的营养非常全面，不仅为人类提供优质蛋白质和必需的脂肪酸，还提供钙、磷、铁、 硫胺素 、核黄素和尼克酸等营养元素。', 25.00, '500g', 'category_pig/1.jpg', 2);
INSERT INTO `products` VALUES (13, '原切猪排', '原切猪排原切猪排原切猪排原切猪排', 35.00, '500g', 'category_pig/4.jpg', 2);
INSERT INTO `products` VALUES (14, '白羽鸡胸肉', '富含人体必需的多种氨基酸，且利用率较高，是蛋白质的理想来源。 白羽肉鸡胸、腿肌肉发达，脂肪含量少，肉汁丰富，适用于油炸、烧烤，煎炸等鸡肉烹饪方法，是熟食、快餐企业的最好的选择', 65.00, '1kg', 'category_chicken/1.jpg', 3);
INSERT INTO `products` VALUES (15, '白羽鸡全腿', '白羽鸡全腿白羽鸡全腿白羽鸡全腿', 50.00, '500g', 'category_chicken/2.jpg', 3);
INSERT INTO `products` VALUES (16, '白羽鸡翅根', '白羽鸡翅根白羽鸡翅根白羽鸡翅根白羽鸡翅根', 55.00, '500g', 'category_chicken/3.jpg', 3);
INSERT INTO `products` VALUES (17, '白羽鸡中翅', '白羽鸡中翅白羽鸡中翅白羽鸡中翅白羽鸡中翅', 65.00, '500g', 'category_chicken/4.jpg', 3);
INSERT INTO `products` VALUES (18, '白羽鸡爪', '白羽鸡爪白羽鸡爪白羽鸡爪', 80.00, '750g', 'category_chicken/5.jpg', 3);
INSERT INTO `products` VALUES (19, '白羽鸡胗', '白羽鸡胗白羽鸡胗白羽鸡胗', 80.00, '500g', 'category_chicken/6.jpg', 3);
INSERT INTO `products` VALUES (20, '鸡腿肉丁', '鸡腿肉丁鸡腿肉丁鸡腿肉丁鸡腿肉丁鸡腿肉丁', 45.00, '500g', 'category_chicken/7.jpg', 3);
INSERT INTO `products` VALUES (21, '白羽鸡翅尖', '白羽鸡翅尖白羽鸡翅尖白羽鸡翅尖', 35.00, '500g', 'category_chicken/8.jpg', 3);
INSERT INTO `products` VALUES (22, '蒙古羊肉串30串', '烤羊肉串是新疆人喜爱的风味小吃，肉质鲜嫩，味咸辣，广受人们欢迎。烤羊肉要有专门设备，家庭中没有这种设备时，可油炸羊肉串，味道和烤的羊肉串一样。', 43.00, '30串', 'crazy_buy/1.jpg', 5);
INSERT INTO `products` VALUES (23, '骨肉相连', '骨肉相连在KFC是一款新口味的休闲产品，它是将新鲜的鸡腿肉加上鸡胸部的脆嫩软骨用特别的香辣调料腌制。一串上有多块软骨、多块鸡肉，滚揉后串上竹签，再用电脑控制的烘烤箱经过特殊工艺烤制而成。', 25.00, '400g', 'crazy_buy/2.jpg', 5);
INSERT INTO `products` VALUES (24, '谷饲原切牛舌', '一般 厚切都来自舌头的中后端 ，也就是透着粉色、嫩度较高的区域，通常会在肉上切一些刀口，使切口变嫩，如果有酱汁，味道也可以更好的渗入。', 320.00, '300g/袋', 'crazy_buy/3.jpg', 5);
INSERT INTO `products` VALUES (25, '牛外脊新鲜生牛肉串', '牛外脊/西冷（Striploin）是牛背后半部分一块肌肉的名字。它来自腰部，与肋眼位于同一肌肉群。', 45.00, '30串', 'crazy_buy/4.jpg', 5);
INSERT INTO `products` VALUES (26, '澳洲原切牛腱子肉', '腱子肉是膝关节往上大腿上的肉。 腱子肉是大腿上的肌肉，有肉膜包裹的，内藏筋，硬度适中，纹路规则，最适合卤味。', 380.00, '1kg', 'crazy_buy/5.jpg', 5);
INSERT INTO `products` VALUES (27, '冷冻雪花肥牛', '肥牛一词源于美国，后传入中国香港、日本都等地，90年代引入中国香港，后传入中国内陆。', 59.00, '500g', 'hot_push/1.jpg', 6);
INSERT INTO `products` VALUES (28, '手打虾滑', '主要材料有虾，辅料有肉、鱼类等。 虾滑的做法是把虾去壳，通过上千次的摔打，使肉具有粘性，让其保持原有的营养成分，又具有了爽脆的口感。', 66.00, '500g', 'hot_push/2.jpg', 6);
INSERT INTO `products` VALUES (29, '真鳕鱼段', '真鳕鱼是鳕形目鳕科鳕属的鳕鱼，也就是说，一般只有大西洋鳕鱼（Gadus morhua）、太平洋鳕鱼（Gadus macrocephalus）、格陵兰鳕鱼（Gadus ogac）属于真鳕鱼。', 108.00, '500g', 'hot_push/3.jpg', 6);

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户地址id',
  `user_id` bigint NOT NULL COMMENT '用户表的主键关联，表示该地址属于哪个用户',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '收件人姓名',
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '收件人电话号码',
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '收件人详细地址',
  `zip_code` int NULL DEFAULT NULL COMMENT '邮政编码',
  `is_default` int NOT NULL DEFAULT 1 COMMENT '默认为0,0为不是默认地址，1为默认地址',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '地址创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '地址最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1670618712850976771 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (1, 1, '蔡老六', '13800000000', '广东省中山市博爱七路25号中山职业技术学院', 528400, 1, '2023-06-05 10:59:27', '2023-06-05 10:59:31');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户电子邮件',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_phone` bigint NOT NULL COMMENT '用户电话号码',
  `user_habby` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户爱好',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户地址',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `created_at` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `updated_at` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1670685196201672706 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '蔡老六', '123456', '1234567@qq.com', '男', 13800000000, '打原神', '广东省中山市博爱七路25号', '1.jpg', '2023-06-23 23:05:48', '2023-06-24 14:22:45');
INSERT INTO `users` VALUES (1382209566490624, '谢靓仔', '123456', '1821995845@qq.cpm', '男', 17819506095, '敲代码', '广东省中山市博爱七路25号中山职业技术学院', 'xieliangzai.jpg', '2023-06-24 15:09:47', '2023-06-24 15:11:16');

SET FOREIGN_KEY_CHECKS = 1;
