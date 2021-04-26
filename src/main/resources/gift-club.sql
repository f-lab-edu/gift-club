drop table   IF EXISTS member;
drop table   IF EXISTS store_category;
drop table   IF EXISTS store;

CREATE TABLE `member` (
 `member_id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY  UNIQUE,
  `member_name` varchar(20) NOT NULL,
  `member_email` varchar(255) UNIQUE NOT NULL,
  `member_password` varchar(255) NOT NULL,
  `member_birth` date NOT NULL,
  `member_type_id` int NOT NULL

);
CREATE TABLE `store_category` (
  `store_category_id` int NOT NULL AUTO_INCREMENT,
  `store_category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`store_category_id`)
);


CREATE TABLE `store` (
  `store_id` int NOT NULL AUTO_INCREMENT,
  `store_name` varchar(45) NOT NULL,
  `store_phone` varchar(45) NOT NULL,
  `store_introduce` varchar(255) NOT NULL,
  `store_category_id` int NOT NULL,
  `member_id` int NOT NULL,
  PRIMARY KEY (`store_id`),
  KEY `member_id` (`member_id`),
  KEY `store_category_id` (`store_category_id`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `store_ibfk_2` FOREIGN KEY (`store_category_id`) REFERENCES `store_category` (`store_category_id`)
);

CREATE TABLE `product` (
  `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY  UNIQUE,
  `name` varchar(20) NOT NULL,
  `price` INTEGER NOT NULL,
  `information` varchar(1000) NOT NULL,
  `store_id` INTEGER NOT NULL,
  `stock` INTEGER NOT NULL,
  FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
);

CREATE TABLE `giftCard` (
  `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
  `to_member_id` INTEGER PRIMARY KEY NOT NULL,
  `from_member_id` INTEGER PRIMARY KEY NOT NULL,
  `content` varchar(255) NOT NULL,
  `giftCard_status` varchar(45) NOT NULL,
  `product_id` INTEGER NOT NULL,
  `pay_id` INTEGER NOT NULL,
  FOREIGN KEY (`to_member_id`) REFERENCES `member` (`member_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);
