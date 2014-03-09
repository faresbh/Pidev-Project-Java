/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.28 : Database - abtractteam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`abtractteam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `abtractteam`;

/*Table structure for table `bonplans` */

DROP TABLE IF EXISTS `bonplans`;

CREATE TABLE `bonplans` (
  `idBonPlan` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `type` enum('Plat Special','Soirée Orientale','Soirée Western','Halloween','Hadhra','Happy Hour','Black And White') DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idBonPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bonplans` */

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `mdp` varchar(200) DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `idPosition` int(11) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `idPosition` (`idPosition`),
  CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`idPosition`) REFERENCES `positiongeo` (`id_geo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `clients` */

/*Table structure for table `commentaires` */

DROP TABLE IF EXISTS `commentaires`;

CREATE TABLE `commentaires` (
  `idCommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(1000) DEFAULT NULL,
  `idPlat` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `idResto` int(11) DEFAULT NULL,
  `idBonPlan` float DEFAULT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `idClient` (`idClient`),
  KEY `idPlat` (`idPlat`),
  KEY `idResto` (`idResto`),
  CONSTRAINT `commentaires_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `commentaires_ibfk_2` FOREIGN KEY (`idPlat`) REFERENCES `plats` (`id`),
  CONSTRAINT `commentaires_ibfk_3` FOREIGN KEY (`idResto`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `commentaires` */

/*Table structure for table `factures` */

DROP TABLE IF EXISTS `factures`;

CREATE TABLE `factures` (
  `idFacture` int(11) NOT NULL AUTO_INCREMENT,
  `somme` double DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idFacture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `factures` */

/*Table structure for table `ingredients` */

DROP TABLE IF EXISTS `ingredients`;

CREATE TABLE `ingredients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(40) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `idPlat` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ingredients` */

/*Table structure for table `livraisons` */

DROP TABLE IF EXISTS `livraisons`;

CREATE TABLE `livraisons` (
  `idLivraison` int(11) NOT NULL AUTO_INCREMENT,
  `dateLivraison` date DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `idFacture` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `idResto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLivraison`),
  UNIQUE KEY `idFacture` (`idFacture`),
  KEY `idClient` (`idClient`),
  KEY `idResto` (`idResto`),
  CONSTRAINT `aaaa` FOREIGN KEY (`idFacture`) REFERENCES `factures` (`idFacture`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `livraisons_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `livraisons_ibfk_2` FOREIGN KEY (`idResto`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `livraisons` */

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(40) NOT NULL,
  `idRestaurant` int(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idRestaurant` (`idRestaurant`),
  CONSTRAINT `menus_ibfk_1` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `menus` */

/*Table structure for table `photos` */

DROP TABLE IF EXISTS `photos`;

CREATE TABLE `photos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) NOT NULL,
  `description` varchar(200) NOT NULL,
  `id_resto` int(11) DEFAULT NULL,
  `idBonPlan` int(11) DEFAULT NULL,
  `idPlat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_resto` (`id_resto`),
  KEY `idBonPlan` (`idBonPlan`),
  KEY `FK_photos` (`idPlat`),
  CONSTRAINT `FK_photos` FOREIGN KEY (`idPlat`) REFERENCES `plats` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `photos_ibfk_1` FOREIGN KEY (`id_resto`) REFERENCES `restaurants` (`id`),
  CONSTRAINT `photos_ibfk_2` FOREIGN KEY (`idBonPlan`) REFERENCES `bonplans` (`idBonPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `photos` */

/*Table structure for table `platingredient` */

DROP TABLE IF EXISTS `platingredient`;

CREATE TABLE `platingredient` (
  `idPlat` int(40) NOT NULL,
  `idIngredient` int(40) NOT NULL,
  PRIMARY KEY (`idPlat`,`idIngredient`),
  KEY `idIngredient` (`idIngredient`),
  CONSTRAINT `platingredient_ibfk_1` FOREIGN KEY (`idPlat`) REFERENCES `plats` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `platingredient_ibfk_2` FOREIGN KEY (`idIngredient`) REFERENCES `ingredients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `platingredient` */

/*Table structure for table `plats` */

DROP TABLE IF EXISTS `plats`;

CREATE TABLE `plats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `prix` double NOT NULL,
  `note` double DEFAULT NULL,
  `idMenus` int(11) DEFAULT NULL,
  `idReservation` int(11) DEFAULT NULL,
  `idLivraison` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idMenus` (`idMenus`),
  CONSTRAINT `plats_ibfk_1` FOREIGN KEY (`idMenus`) REFERENCES `menus` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `plats` */

/*Table structure for table `positiongeo` */

DROP TABLE IF EXISTS `positiongeo`;

CREATE TABLE `positiongeo` (
  `id_geo` int(11) NOT NULL AUTO_INCREMENT,
  `abs` double NOT NULL,
  `ord` double NOT NULL,
  PRIMARY KEY (`id_geo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `positiongeo` */

insert  into `positiongeo`(`id_geo`,`abs`,`ord`) values (1,63.23362741232568,-50.2734375),(2,53.27835301753182,-6.1083984375),(3,53.27835301753182,-6.1083984375),(4,53.73571574532637,5.16357421875),(5,51.227527905265006,2.109375);

/*Table structure for table `reservations` */

DROP TABLE IF EXISTS `reservations`;

CREATE TABLE `reservations` (
  `idReservation` int(11) NOT NULL AUTO_INCREMENT,
  `choix` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `idFacture` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `idResto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReservation`),
  UNIQUE KEY `idFacture` (`idFacture`),
  KEY `idClient` (`idClient`),
  KEY `idResto` (`idResto`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`idResto`) REFERENCES `restaurants` (`id`),
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`idFacture`) REFERENCES `factures` (`idFacture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reservations` */

/*Table structure for table `restaurants` */

DROP TABLE IF EXISTS `restaurants`;

CREATE TABLE `restaurants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `nbrTable` int(4) NOT NULL,
  `specialite` enum('Fast Food','Salon de thé','Resaturant') DEFAULT NULL,
  `id_geo` int(11) DEFAULT NULL,
  `id_restaurateur` int(11) DEFAULT NULL,
  `note` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_geo` (`id_geo`),
  KEY `id_restaurateur` (`id_restaurateur`),
  CONSTRAINT `restaurants_ibfk_1` FOREIGN KEY (`id_restaurateur`) REFERENCES `restaurateurs` (`id`),
  CONSTRAINT `restaurants_ibfk_2` FOREIGN KEY (`id_geo`) REFERENCES `positiongeo` (`id_geo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `restaurants` */

insert  into `restaurants`(`id`,`nom`,`adresse`,`nbrTable`,`specialite`,`id_geo`,`id_restaurateur`,`note`) values (1,'sss','zz',7,'Fast Food',NULL,1,NULL),(2,'sss','zz',7,'Resaturant',NULL,1,NULL),(3,'fff','zz',1,'Fast Food',4,1,NULL),(4,'fares','ss',20,'Fast Food',5,1,NULL);

/*Table structure for table `restaurateurs` */

DROP TABLE IF EXISTS `restaurateurs`;

CREATE TABLE `restaurateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `mdp` varchar(1000) NOT NULL,
  `adresse` varchar(80) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `restaurateurs` */

insert  into `restaurateurs`(`id`,`nom`,`prenom`,`mail`,`mdp`,`adresse`,`tel`) values (1,'testTahtouh','test','test','0000','hhhh','0000');

/*Table structure for table `tables` */

DROP TABLE IF EXISTS `tables`;

CREATE TABLE `tables` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `idRestaurant` int(11) NOT NULL,
  `etat` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idRestaurant` (`idRestaurant`),
  CONSTRAINT `tables_ibfk_1` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tables` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
