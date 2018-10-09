CREATE DATABASE  IF NOT EXISTS `office` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `office`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: office
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `works_on`
--

DROP TABLE IF EXISTS `works_on`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `works_on` (
  `Essn` bigint(20) DEFAULT NULL,
  `Pno` int(11) DEFAULT NULL,
  `Hours` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works_on`
--

LOCK TABLES `works_on` WRITE;
/*!40000 ALTER TABLE `works_on` DISABLE KEYS */;
INSERT INTO `works_on` VALUES (123456789,1,32.5),(123456789,2,7.5),(666884444,3,40),(453453453,1,20),(453453453,2,20),(333445555,2,10),(333445555,3,10),(333445555,10,10),(333445555,20,10),(242535609,70,20),(242535609,62,20),(999887777,30,30),(999887777,10,10),(987987987,10,35),(987987987,30,5),(987654321,30,20),(987654321,20,15),(888665555,20,5),(111111100,61,40),(111111101,61,40),(111111102,61,40),(111111103,61,40),(222222200,62,40),(222222201,62,48),(222222202,62,40),(222222203,62,40),(222222204,62,40),(222222205,62,40),(333333300,63,40),(333333301,63,46),(444444400,91,40),(444444401,91,40),(444444402,91,40),(444444403,91,40),(555555500,92,40),(555555501,92,44),(666666601,91,40),(666666603,91,40),(666666604,91,40),(666666605,92,40),(666666606,91,40),(666666607,61,40),(666666608,62,40),(666666609,63,40),(666666610,61,40),(666666611,61,40),(666666612,61,40),(666666613,61,30),(666666613,62,10),(666666613,63,10),(999999999,1,2),(999999999,2,2),(999999999,3,4),(999999999,10,4),(999999999,20,4),(999999999,30,4),(999999999,61,4),(999999999,62,4),(999999999,63,4),(999999999,70,2),(999999999,91,2),(999999999,92,1),(999999999,95,3),(254937381,70,40),(222333444,91,10),(223344667,63,20),(444222666,62,25),(112244668,95,40),(343434344,63,40),(234234234,95,35),(913323708,92,33),(636669233,4,11),(614370310,3,45),(849934919,95,23),(432765098,63,25),(444212096,63,25),(913353347,22,30),(292740167,1,25),(202843824,11,20),(673466642,22,4),(101248268,29,10),(245239264,11,25),(242916639,4,5),(906218888,29,15),(1614905,13,18),(245239264,10,25),(349273344,29,15),(242916639,11,20),(214370999,10,35),(111422203,4,45),(398172999,70,10),(241625699,61,4),(122344668,3,10),(122344668,20,10),(122344668,30,25);
/*!40000 ALTER TABLE `works_on` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-06 12:16:02