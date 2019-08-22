/*
SQLyog Community v11.31 (32 bit)
MySQL - 5.7.19-log : Database - javacb10
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javacb10` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */;

USE `javacb10`;

/*Table structure for table `donhang` */

DROP TABLE IF EXISTS `donhang`;

CREATE TABLE `donhang` (
  `madh` int(12) NOT NULL AUTO_INCREMENT,
  `ngaytao` date NOT NULL,
  `diachi` varchar(500) COLLATE utf8_vietnamese_ci NOT NULL,
  `dienthoai` char(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `tongtien` int(12) DEFAULT NULL,
  `makh` int(12) DEFAULT NULL,
  PRIMARY KEY (`madh`),
  KEY `donhang_khachhang` (`makh`),
  CONSTRAINT `donhang_khachhang` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Data for the table `donhang` */

insert  into `donhang`(`madh`,`ngaytao`,`diachi`,`dienthoai`,`tongtien`,`makh`) values (1,'2019-08-08','Hoàng Đạo Thúy - Thanh Xuâ - Hà Nội','0123654789',1500000,1),(2,'2019-08-08','Hoàng Đạo Thúy - Thanh Xuâ - Hà Nội','0258741369',3500000,2);

/*Table structure for table `khachhang` */

DROP TABLE IF EXISTS `khachhang`;

CREATE TABLE `khachhang` (
  `makh` int(12) NOT NULL AUTO_INCREMENT,
  `hoten` char(200) COLLATE utf8_vietnamese_ci NOT NULL,
  `tendangnhap` char(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `matkhau` char(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `diachi` varchar(500) CHARACTER SET utf8 DEFAULT 'Không có thông tin',
  `dienthoai` char(10) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`makh`),
  UNIQUE KEY `tendangnhap` (`tendangnhap`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Data for the table `khachhang` */

insert  into `khachhang`(`makh`,`hoten`,`tendangnhap`,`matkhau`,`diachi`,`dienthoai`) values (1,'Nguyễn Văn C','khachang1','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Không có thông tin','0123456789'),(2,'Nguyễn Văn D','khachang2','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Không có thông tin','0123456789'),(3,'Trần Văn E','khachang3','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Không có thông tin','0123456789'),(4,'Nguyen Van F','fnv','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Ha NOi','1235486971');

/*Table structure for table `loaisanpham` */

DROP TABLE IF EXISTS `loaisanpham`;

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenloan` varchar(500) COLLATE utf8_vietnamese_ci NOT NULL,
  `ghichu` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Data for the table `loaisanpham` */

insert  into `loaisanpham`(`id`,`tenloan`,`ghichu`) values (1,'iphone',NULL),(2,'samsung',NULL),(3,'sony',NULL),(4,'nokia',NULL),(5,'ipad',NULL),(6,'tablet',NULL);

/*Table structure for table `nhanvien` */

DROP TABLE IF EXISTS `nhanvien`;

CREATE TABLE `nhanvien` (
  `manv` int(12) NOT NULL AUTO_INCREMENT,
  `hoten` char(200) COLLATE utf8_vietnamese_ci NOT NULL,
  `tendangnhap` char(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `matkhau` char(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `diachi` varchar(500) CHARACTER SET utf8 DEFAULT 'Không có thông tin',
  `dienthoai` char(10) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`manv`),
  UNIQUE KEY `tendangnhap` (`tendangnhap`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Data for the table `nhanvien` */

insert  into `nhanvien`(`manv`,`hoten`,`tendangnhap`,`matkhau`,`diachi`,`dienthoai`) values (1,'Nguyễn Văn A','admin','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Không có thông tin','0123456789'),(2,'Nguyễn Văn B','manager','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Không có thông tin','0123456789'),(3,'Nguyen Van F','fnv','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','Ha NOi','1235486971');

/*Table structure for table `sanpham` */

DROP TABLE IF EXISTS `sanpham`;

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loai` int(11) NOT NULL,
  `ten` varchar(500) COLLATE utf8_vietnamese_ci NOT NULL,
  `gianhapve` int(11) NOT NULL DEFAULT '0',
  `giabanra` int(11) NOT NULL DEFAULT '0',
  `giamgia` int(11) DEFAULT '0',
  `anh` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `gioithieu` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `hangsanxua` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sanpham_ibfk_1` (`loai`),
  CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`loai`) REFERENCES `loaisanpham` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Data for the table `sanpham` */

insert  into `sanpham`(`id`,`loai`,`ten`,`gianhapve`,`giabanra`,`giamgia`,`anh`,`gioithieu`,`hangsanxua`) values (1,2,'Nokia',100000,200,20,'anhgiay','moi','moi'),(2,2,'Samsung',2000000,20000,10,'anhgiay','moi','moi'),(3,2,'Huawei',3000000,30000,50,'anhgiay','moi','moi'),(4,2,'Iphone',4000000,40000,21,'anhgiay','moi','moi'),(5,2,'Bphone',5000000,50000,53,'anhgiay','moi','moi');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
