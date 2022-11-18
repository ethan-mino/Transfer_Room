CREATE DATABASE transfer_dev;

use transfer_dev;

CREATE USER 'transfer_dev_user' identified by 'transfer_dev_user';
GRANT ALL PRIVILEGES ON transfer_dev.* to 'transfer_dev_user'@'%';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '유저 id',
    `user_name` VARCHAR(255) NOT NULL COMMENT '유저의 이름',
    `user_email` VARCHAR(255) NOT NULL COMMENT '유저의 이메일',
    `user_password` VARCHAR(255) NOT NULL COMMENT '유저의 암호회된 비밀번호',
    `user_address` VARCHAR(255) NOT NULL COMMENT '유저의 집 주소',
    CONSTRAINT `user_id_pk` PRIMARY KEY(user_id),
    CONSTRAINT `user_email_unique` UNIQUE(user_email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
     `role_id` INT NOT NULL AUTO_INCREMENT COMMENT 'role id',
     `user_id` INT NOT NULL COMMENT 'login id fk',
     `role_name` VARCHAR(255) NOT NULL COMMENT 'role 이름 ROLE_ 로 시작하는 값이어야 한다.',
     CONSTRAINT `role_id_pk` PRIMARY KEY(role_id),
     CONSTRAINT `user_role_unique` UNIQUE(`user_id`, `role_name`),
     CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;