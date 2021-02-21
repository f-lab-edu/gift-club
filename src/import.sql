CREATE SCHEMA `giftclub` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;




drop table   IF EXISTS user;
create table user(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(128),
name VARCHAR(128),
password VARCHAR(128),
birth VARCHAR(128),
phone_number VARCHAR(128),
INDEX (email)
);

drop table  IF EXISTS shop;
create table shop(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(128),
description VARCHAR(128),
INDEX (name)
);
drop table IF EXISTS product;
create table product(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
shop_id INTEGER ,
name VARCHAR(128),
price INTEGER,
discount INTEGER,
description VARCHAR(128),
INDEX (name),
FOREIGN KEY(shop_id)REFERENCES shop(id) on delete cascade
);

drop table  IF EXISTS address;
create table address(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
is_default_address boolean not null default 0,
address_name VARCHAR(128),
city_name VARCHAR(128),
city_country_name VARCHAR(128),
town_name VARCHAR(128),
road_name_code VARCHAR(128),
road_name VARCHAR(128),
zip_code VARCHAR(128),
detail_building_name VARCHAR(128),
INDEX (address_name),
shop_id INTEGER,
user_id INTEGER,
FOREIGN  KEY (shop_id) REFERENCES shop(id)  on delete cascade,
FOREIGN  KEY (user_id) REFERENCES user(id)  on delete cascade
);