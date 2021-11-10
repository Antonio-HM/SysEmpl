/*
SQLyog Enterprise - MySQL GUI v8.05 
MySQL - 5.5.13 : Database - bdempleado
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdempleado` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `bdempleado`;

/*Table structure for table `tbdepartamento` */

DROP TABLE IF EXISTS `tbdepartamento`;

CREATE TABLE `tbdepartamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `idPais` int(11) NOT NULL,
  PRIMARY KEY (`idDepartamento`),
  KEY `FK_tbdepartamento_pais` (`idPais`),
  CONSTRAINT `FK_tbdepartamento_pais` FOREIGN KEY (`idPais`) REFERENCES `tbpais` (`idPais`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tbdepartamento` */

insert  into `tbdepartamento`(`idDepartamento`,`nombreDepartamento`,`idPais`) values (1,'AHUACHAPAN',1),(2,'SANTA ANA',1),(3,'SAN SALVADOR',1),(4,'ALTA VERAPAZ',2),(5,'PETEN',2),(6,'ZACAPA',2);

/*Table structure for table `tbempleado` */

DROP TABLE IF EXISTS `tbempleado`;

CREATE TABLE `tbempleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `idPais` int(11) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `idMunicipio` int(11) NOT NULL,
  `codigoArea` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `FK_tbempleado_pais` (`idPais`),
  KEY `FK_tbempleado_depto` (`idDepartamento`),
  KEY `FK_tbempleado_municipio` (`idMunicipio`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tbempleado` */

insert  into `tbempleado`(`idEmpleado`,`nombres`,`apellidos`,`direccion`,`idPais`,`idDepartamento`,`idMunicipio`,`codigoArea`,`telefono`) values (1,'SANDRA CAROLINA','MENENDEZ','COL. LAS FLORES N°2',1,2,6,'503','12132'),(3,'BLANCA ESTELA','GARCIA','COL. EL JUGUETE',1,1,1,'503','7465456'),(5,'VERONICA','VELAZQUEZ','AV. PONIENTE 2',2,4,10,'502','78789798'),(6,'OSCAR GUILLERMO','MARTINEZ','COL. LA GLORIA',1,1,2,'503','6546465'),(7,'MARIA','AGUILAR','AVE. N°2 CALLE DE ORO',2,5,15,'502','8789798');

/*Table structure for table `tbmunicipio` */

DROP TABLE IF EXISTS `tbmunicipio`;

CREATE TABLE `tbmunicipio` (
  `idMunicipio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMunicipio` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idMunicipio`),
  KEY `FK_tbmunicipio_depto` (`idDepartamento`),
  CONSTRAINT `FK_tbmunicipio_depto` FOREIGN KEY (`idDepartamento`) REFERENCES `tbdepartamento` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tbmunicipio` */

insert  into `tbmunicipio`(`idMunicipio`,`nombreMunicipio`,`idDepartamento`) values (1,'ATIQUIZAYA',1),(2,'APANECA',1),(3,'SAN LORENZO',1),(4,'METAPAN',2),(5,'TEXISTEPEQUE',2),(6,'COATEPEQUE',2),(7,'AGUILARES',3),(8,'SAN MARTIN',3),(9,'SAN MARCOS',3),(10,'COBAN',4),(11,'SAN PEDRO CARCHA',4),(12,'TACTIC',4),(13,'EL CHAL',5),(14,'FLORES',5),(15,'SAN ANDRES',5),(16,'CABAÑAS',6),(17,'HUALAN',6),(18,'LA UNION',6);

/*Table structure for table `tbpais` */

DROP TABLE IF EXISTS `tbpais`;

CREATE TABLE `tbpais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePais` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tbpais` */

insert  into `tbpais`(`idPais`,`nombrePais`) values (1,'EL SALVADOR'),(2,'GUATEMALA');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
