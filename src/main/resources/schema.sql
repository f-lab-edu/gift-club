drop table   IF EXISTS Member;
create table Member(
member_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY  UNIQUE,
member_email VARCHAR(255) NOT NULL UNIQUE,
member_name VARCHAR(255) NOT NULL,
member_password VARCHAR(255) NOT NULL,
member_birth Date,
INDEX (member_email)
);
