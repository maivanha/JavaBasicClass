/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.19-log : Database - java13
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`java13` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `java13`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `orderId` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  KEY `od_order` (`orderId`),
  KEY `od_product` (`productId`),
  CONSTRAINT `od_order` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `od_product` FOREIGN KEY (`productId`) REFERENCES `production` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderdetail` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personId` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `orderDate` datetime NOT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `totalPrice` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `person_order` (`personId`),
  CONSTRAINT `person_order` FOREIGN KEY (`personId`) REFERENCES `persons` (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`personId`,`phone`,`address`,`orderDate`,`releaseDate`,`description`,`totalPrice`) values (1,1,'1201548694','Địa chỉ nhận hàng','2020-04-22 20:22:26',NULL,'Mô tả yêu cầu của khách hàng',0),(2,2,'3201546984','Đại chỉ nhận hàng ','2020-04-22 20:23:12',NULL,NULL,0);

/*Table structure for table `persons` */

DROP TABLE IF EXISTS `persons`;

CREATE TABLE `persons` (
  `personId` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `persons` */

insert  into `persons`(`personId`,`lastName`,`firstName`,`address`,`city`,`username`,`password`,`phone`) values (1,'Nguyễn Văn','A','Đường Giải Phóng','Hà Nội','admin','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','01234567890'),(2,'Nguyễn Văn','B','Đường Giải Phóng','Hưng Yên','productOwner','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','1254369770'),(3,'Nguyễn Văn','C','Đường Giải Phóng','Hà Nội','contentManager','481f6cc0511143ccdd7e2d1b1b94faf0a700a8b49cd13922a70b5ae28acaa8c5','01234557890'),(4,'Trần Văn','C','Đường Giải Phóng','Hải Phòng','newsManager','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','36521478902'),(5,'Lê Văn','E',NULL,'Thanh Hóa','user1','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','02153647819'),(6,'Hoàng Văn','G','Ba Đình','Hà Nội','userName2','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','0125412036'),(9,'Bùi Văn','G','Ba Đình','Hà Nội','userName3','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','0125412036'),(10,'LASTNAME TESST','TEST 01','Äá»a chá»','HÃÂ  NÃ¡Â»Âi','test','15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225','01235468790'),(11,'LASTNAME-TEST','FIRSTNAME-TEST','Hà Nội','Hà Nội','test02','15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225','01235468790');

/*Table structure for table `production` */

DROP TABLE IF EXISTS `production`;

CREATE TABLE `production` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(1000) NOT NULL,
  `price` int(11) NOT NULL DEFAULT '0',
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prodcut_category` (`categoryId`),
  CONSTRAINT `prodcut_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `production` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
