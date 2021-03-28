CREATE TABLE `member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(20) NOT NULL,
  `member_email` varchar(255) UNIQUE NOT NULL,
  `member_password` varchar(255) NOT NULL,
  `member_birth` date NOT NULL,
  `member_type_id` int NOT NULL,
  PRIMARY KEY (`member_id`),
  KEY `member_ibfk_1` (`member_type_id`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`member_type_id`) REFERENCES `member_type` (`member_type_id`)
);

CREATE TABLE `member_type` (
  `member_type_id` int NOT NULL AUTO_INCREMENT,
  `member_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`member_type_id`)
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

CREATE TABLE `store_category` (
  `store_category_id` int NOT NULL AUTO_INCREMENT,
  `store_category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`store_category_id`)
);
