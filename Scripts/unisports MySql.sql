-- MySQL Script generated by MySQL Workbench
-- Thu Oct  5 22:14:39 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema unisports
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema unisports
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `unisports` DEFAULT CHARACTER SET utf8 ;
USE `unisports` ;

-- -----------------------------------------------------
-- Table `unisports`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`User` (
  `Id` VARCHAR(36) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `ContactPhone` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `BornDate` DATE NULL,
  `Password` VARCHAR(45) NOT NULL,
  `OverallRate` DOUBLE NOT NULL,
  `ExcellentAverage` DOUBLE NOT NULL,
  `RegularAverage` DOUBLE NOT NULL,
  `BadAverage` DOUBLE NOT NULL,
  `NonAttendanceAverage` DOUBLE NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`Sport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`Sport` (
  `Id` VARCHAR(36) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Type` INT NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`Team` (
  `Id` VARCHAR(36) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Logo` VARCHAR(45) NULL,
  `Motto` VARCHAR(45) NULL,
  `Description` VARCHAR(250) NULL,
  `Sport_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Id`, `Sport_Id`),
  INDEX `fk_Team_Sport1_idx` (`Sport_Id` ASC),
  CONSTRAINT `fk_Team_Sport1`
    FOREIGN KEY (`Sport_Id`)
    REFERENCES `unisports`.`Sport` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`Event` (
  `Id` VARCHAR(36) NOT NULL,
  `Date` DATETIME NOT NULL,
  `Description` VARCHAR(250) NULL,
  `PositionX` DOUBLE NOT NULL,
  `PositionY` DOUBLE NOT NULL,
  `State` INT NOT NULL,
  `CreatedDate` DATETIME NULL,
  `CreatorUserId` VARCHAR(36) NOT NULL,
  `Sport_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Id`, `Sport_Id`),
  INDEX `fk_Event_Sport1_idx` (`Sport_Id` ASC),
  CONSTRAINT `fk_Event_Sport1`
    FOREIGN KEY (`Sport_Id`)
    REFERENCES `unisports`.`Sport` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`Users_has_Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`Users_has_Team` (
  `Users_Id` VARCHAR(36) NOT NULL,
  `Team_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Users_Id`, `Team_Id`),
  INDEX `fk_Users_has_Team_Team1_idx` (`Team_Id` ASC),
  INDEX `fk_Users_has_Team_Users_idx` (`Users_Id` ASC),
  CONSTRAINT `fk_Users_has_Team_Users`
    FOREIGN KEY (`Users_Id`)
    REFERENCES `unisports`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Team_Team1`
    FOREIGN KEY (`Team_Id`)
    REFERENCES `unisports`.`Team` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`Relationship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`Relationship` (
  `Id` VARCHAR(36) NOT NULL,
  `UserRelatedId` VARCHAR(36) NOT NULL,
  `State` INT NOT NULL,
  `ConfirmedDate` DATETIME NULL,
  `Users_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Users_Id`, `Id`),
  CONSTRAINT `fk_Relationship_Users1`
    FOREIGN KEY (`Users_Id`)
    REFERENCES `unisports`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`TeamInscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`TeamInscription` (
  `Id` VARCHAR(36) NOT NULL,
  `Points` INT NOT NULL,
  `Event_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Id`, `Event_Id`),
  INDEX `fk_TeamInscription_Event1_idx` (`Event_Id` ASC),
  CONSTRAINT `fk_TeamInscription_Event1`
    FOREIGN KEY (`Event_Id`)
    REFERENCES `unisports`.`Event` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`UserInscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`UserInscription` (
  `Id` VARCHAR(36) NOT NULL,
  `Confirmed` TINYINT(1) NOT NULL,
  `Users_Id` VARCHAR(36) NOT NULL,
  `TeamInscription_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Id`, `Users_Id`, `TeamInscription_Id`),
  INDEX `fk_UserInscription_Users1_idx` (`Users_Id` ASC),
  INDEX `fk_UserInscription_TeamInscription1_idx` (`TeamInscription_Id` ASC),
  CONSTRAINT `fk_UserInscription_Users1`
    FOREIGN KEY (`Users_Id`)
    REFERENCES `unisports`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserInscription_TeamInscription1`
    FOREIGN KEY (`TeamInscription_Id`)
    REFERENCES `unisports`.`TeamInscription` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unisports`.`Notifications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unisports`.`Notifications` (
  `Id` VARCHAR(36) NOT NULL,
  `Subject` VARCHAR(250) NOT NULL,
  `Type` INT NOT NULL,
  `User_Id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`Id`, `User_Id`),
  INDEX `fk_Notifications_User1_idx` (`User_Id` ASC),
  CONSTRAINT `fk_Notifications_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `unisports`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;