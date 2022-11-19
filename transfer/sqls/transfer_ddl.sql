-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema transfer_dev
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema transfer_dev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `transfer_dev` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

-- CREATE USER 'transfer_dev_user' identified by 'transfer_dev_user';
-- GRANT ALL PRIVILEGES ON transfer_dev.* to 'transfer_dev_user'@'%';

USE `transfer_dev` ;

-- -----------------------------------------------------
-- Table `transfer_dev`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(255) NOT NULL,
  `user_email` VARCHAR(255) NOT NULL,
  `user_password` VARCHAR(255) NOT NULL,
  `user_address` VARCHAR(255) NOT NULL,
  `user_create_time` TIMESTAMP NOT NULL,
  `user_update_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`user_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `fk_user_roles_roles1_idx` (`role_id` ASC) VISIBLE,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_user_roles_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `transfer_dev`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_roles_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `transfer_dev`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`notices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`notices` (
  `notice_no` INT NOT NULL AUTO_INCREMENT,
  `notice_title` VARCHAR(255) NOT NULL,
  `notice_content` TEXT NOT NULL,
  `notice_critical` INT NOT NULL,
  `notice_create_time` TIMESTAMP NOT NULL,
  `notice_update_time` TIMESTAMP NOT NULL,
  `notice_writer_id` INT NOT NULL,
  PRIMARY KEY (`notice_no`),
  INDEX `fk_notices_users1_idx` (`notice_writer_id` ASC) VISIBLE,
  CONSTRAINT `fk_notices_users1`
    FOREIGN KEY (`notice_writer_id`)
    REFERENCES `transfer_dev`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`community_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`community_categories` (
  `cc_id` INT NOT NULL AUTO_INCREMENT,
  `cc_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cc_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`community_boards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`community_boards` (
  `cb_no` INT NOT NULL AUTO_INCREMENT,
  `cb_title` VARCHAR(255) NOT NULL,
  `cb_content` TEXT NOT NULL,
  `cb_create_time` TIMESTAMP NOT NULL,
  `cb_update_time` TIMESTAMP NOT NULL,
  `cb_writer_id` INT NOT NULL,
  `cb_categories_id` INT NOT NULL,
  PRIMARY KEY (`cb_no`),
  INDEX `fk_community_boards_users_idx` (`cb_writer_id` ASC) VISIBLE,
  INDEX `fk_community_boards_community_categories1_idx` (`cb_categories_id` ASC) VISIBLE,
  CONSTRAINT `fk_community_boards_users`
    FOREIGN KEY (`cb_writer_id`)
    REFERENCES `transfer_dev`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_community_boards_community_categories1`
    FOREIGN KEY (`cb_categories_id`)
    REFERENCES `transfer_dev`.`community_categories` (`cc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`comments` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `comment_content` TEXT NOT NULL,
  `comment_create_time` TIMESTAMP NOT NULL,
  `comment_update_time` TIMESTAMP NOT NULL,
  `cb_no` INT NOT NULL,
  PRIMARY KEY (`comment_id`, `cb_no`),
  INDEX `fk_comments_community_boards1_idx` (`cb_no` ASC) VISIBLE,
  CONSTRAINT `fk_comments_community_boards1`
    FOREIGN KEY (`cb_no`)
    REFERENCES `transfer_dev`.`community_boards` (`cb_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`regions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`regions` (
  `dongCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL,
  `gugunName` VARCHAR(30) NULL,
  `dongName` VARCHAR(30) NULL,
  PRIMARY KEY (`dongCode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`transfer_boards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`transfer_boards` (
  `tb_id` INT NOT NULL AUTO_INCREMENT,
  `transfer_status` INT NOT NULL,
  `tb_title` VARCHAR(255) NOT NULL,
  `tb_content` TEXT NOT NULL,
  `tb_create_time` TIMESTAMP NOT NULL,
  `tb_update_time` TIMESTAMP NOT NULL,
  `room_latitude` DOUBLE NOT NULL,
  `room_longitude` DOUBLE NOT NULL,
  `room_address` VARCHAR(255) NOT NULL,
  `room_floor` INT NOT NULL,
  `room_type` VARCHAR(255) NOT NULL,
  `contract_type` VARCHAR(255) NOT NULL,
  `contract_end_time` DATE NOT NULL,
  `transferer_id` INT NOT NULL,
  `transferee_id` INT NULL,
  `dongCode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`tb_id`),
  INDEX `fk_transfer_boards_users1_idx` (`transferer_id` ASC) VISIBLE,
  INDEX `fk_transfer_boards_users2_idx` (`transferee_id` ASC) VISIBLE,
  INDEX `fk_transfer_boards_dongcode1_idx` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `fk_transfer_boards_users1`
    FOREIGN KEY (`transferer_id`)
    REFERENCES `transfer_dev`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transfer_boards_users2`
    FOREIGN KEY (`transferee_id`)
    REFERENCES `transfer_dev`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transfer_boards_dongcode1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `transfer_dev`.`regions` (`dongCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transfer_dev`.`files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transfer_dev`.`files` (
  `file_path` VARCHAR(500) NOT NULL,
  `file_content_type` VARCHAR(255) NOT NULL,
  `tb_id` INT NOT NULL AUTO_INCREMENT,
  `file_status` INT NOT NULL,
  PRIMARY KEY (`tb_id`),
  CONSTRAINT `fk_files_transfer_boards1`
    FOREIGN KEY (`tb_id`)
    REFERENCES `transfer_dev`.`transfer_boards` (`tb_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



USE `transfer_dev` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
