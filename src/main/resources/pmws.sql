/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.42-community : Database - pmws
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pmws` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pmws`;

/*Table structure for table `app_links` */

DROP TABLE IF EXISTS `app_links`;

CREATE TABLE `app_links` (
  `link_id` int(10) NOT NULL,
  `link_name` varchar(20) NOT NULL,
  `url` varchar(30) NOT NULL,
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `app_links` */

insert  into `app_links`(`link_id`,`link_name`,`url`,`status`) values (1,'users','admin/users','T'),(2,'products','admin/products','T'),(3,'promotions','admin/promotions','T'),(4,'Promotion_Search','admin/search_promotion','T');

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `status` varchar(1) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `category` varchar(1) DEFAULT NULL,
  `quantity` int(100) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `products` */

insert  into `products`(`product_id`,`product_name`,`price`,`status`,`created_date`,`category`,`quantity`) values (1,'moto g',10000,'T','2017-07-31 11:20:30','L',10),(3,'Dell',20000,'T',NULL,'M',6),(4,'sony mobilew',20000,'T',NULL,'M',13),(7,'accer',50000,'T',NULL,'L',9),(8,'mi3',5000,'T','2017-08-01 12:03:20','M',0),(11,'applie i7',300000,'T','2017-08-01 20:15:50','L',9),(12,'Lenovo k4',155000,'T','2017-08-01 23:11:09','M',11);

/*Table structure for table `promotions` */

DROP TABLE IF EXISTS `promotions`;

CREATE TABLE `promotions` (
  `promotion_Id` int(10) NOT NULL AUTO_INCREMENT,
  `product_Id` int(10) NOT NULL,
  `discount` double DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `review_status` varchar(2) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`promotion_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `promotions` */

insert  into `promotions`(`promotion_Id`,`product_Id`,`discount`,`startDate`,`endDate`,`review_status`,`status`) values (11,4,10,'2017-08-01','2017-08-10','N','T'),(12,1,10,'2017-08-03','2017-08-05','N','T'),(15,3,15,'2017-08-10','2017-08-12','N','T'),(21,11,19,'2017-08-14','2017-08-18','N','T');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(2000) NOT NULL,
  `status` varchar(1) NOT NULL,
  `roles` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_password`,`status`,`roles`) values (1,'guru','guru123','T','A'),(6,'prasanna','prasanna123','T','S'),(7,'kiran','kiran123','T','R'),(9,'raghu','raghu','T','A,S'),(10,'ram','ram123','T','S,R'),(46,'prakash','prakash123','T','A,S,R'),(48,'rajuuu','djfhgdfhhdf','T','S,R'),(49,'yogeeta','yogeeta123','T','S'),(51,'Sczsdvdfgvdf','zsdgzfgdfzg','T','R'),(53,'krishana','krishna123','T','R');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
