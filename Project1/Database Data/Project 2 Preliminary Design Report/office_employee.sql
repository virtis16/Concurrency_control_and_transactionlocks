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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Fname` text,
  `Minit` text,
  `Lname` text,
  `Ssn` bigint(20) DEFAULT NULL,
  `Bdate` text,
  `Address` text,
  `Sex` text,
  `Salary` int(11) DEFAULT NULL,
  `Super_ssn` text,
  `Dno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('James','E','Borg',888665555,'10-NOV-1927','450 Stone,Houston,TX','M',55000,'null',1),('Franklin','T','Wong',333445555,'08-DEC-1945','638 Voss,Houston,TX','M',40000,'888665555',5),('Jennifer','S','Wallace',987654321,'20-JUN-1931','291 Berry,Bellaire,TX','F',43000,'888665555',4),('Jared','D','James',111111100,'10-OCT-1966','123 Peachtr,Atlanta,GA','M',85000,'null',6),('Alex','D','Freed',444444400,'09-OCT-1950','4333 Pillsbury,Milwaukee,WI','M',89000,'null',7),('John','C','James',555555500,'30-JUN-1975','766 Bloomington,Sacramento,CA','M',81000,'null',8),('John','B','Smith',123456789,'09-Jan-1955','731 Fondren,Houston,TX','M',30000,'333445555',5),('Alicia','J','Zelaya',999887777,'19-JUL-1958','3321 Castle,Spring,TX','F',25000,'987654321',4),('Ramesh','K','Narayan',666884444,'15-SEP-1952','971 Fire Oak,Humble,TX','M',38000,'333445555',5),('Joyce','A','English',453453453,'31-JUL-1962','5631 Rice Oak,Houston,TX','F',25000,'333445555',5),('Ahmad','V','Jabbar',987987987,'29-MAR-1959','980 Dallas,Houston,TX','M',25000,'987654321',4),('Jon','C','Jones',111111101,'14-NOV-1967','111 Allgood,Atlanta,GA','M',45000,'111111100',6),('Justin','null','Mark',111111102,'12-JAN-1966','2342 May,Atlanta,GA','M',40000,'111111100',6),('Brad','C','Knight',111111103,'13-FEB-1968','176 Main St.,Atlanta,GA','M',44000,'111111100',6),('Evan','E','Wallis',222222200,'16-JAN-1958','134 Pelham,Milwaukee,WI','M',92000,'null',7),('Josh','U','Zell',222222201,'22-MAY-1954','266 McGrady,Milwaukee,WI','M',56000,'222222200',7),('Andy','C','Vile',222222202,'21-JUN-1944','1967 Jordan,Milwaukee,WI','M',53000,'222222200',7),('Tom','G','Brand',222222203,'16-DEC-1966','112 Third St,Milwaukee,WI','M',62500,'222222200',7),('Jenny','F','Vos',222222204,'11-NOV-1967','263 Mayberry,Milwaukee,WI','F',61000,'222222201',7),('Chris','A','Carter',222222205,'21-MAR-1960','565 Jordan,Milwaukee,WI','F',43000,'222222201',7),('Kim','C','Grace',333333300,'23-OCT-1970','667 Mills Ave,Sacramento,CA','F',79000,'null',6),('Jeff','H','Chase',333333301,'07-JAN-1970','15 Bradbury,Sacramento,CA','M',44000,'333333300',6),('Bonnie','S','Bays',444444401,'19-JUN-1956','111 Hollow,Milwaukee,WI','F',70000,'444444400',7),('Alec','C','Best',444444402,'18-JUN-1966','233 Solid,Milwaukee,WI','M',60000,'444444400',7),('Sam','S','Snedden',444444403,'31-JUL-1977','97 Windy St,Milwaukee,WI','M',48000,'444444400',7),('Nandita','K','Ball',555555501,'16-APR-1969','222 Howard,Sacramento,CA','M',62000,'555555500',6),('Bob','B','Bender',666666600,'17-APR-1968','8794 Garfield,Chicago,IL','M',96000,'null',8),('Jill','J','Jarvis',666666601,'14-JAN-1966','6234 Lincoln,Chicago,IL','F',36000,'666666600',9),('Kate','W','King',666666602,'16-APR-1966','1976 Boone Trace,Chicago,IL','F',44000,'666666600',8),('Lyle','G','Leslie',666666603,'09-JUN-1963','417 Hancock Ave,Chicago,IL','M',41000,'666666601',8),('Billie','J','King',666666604,'01-JAN-1960','556 Washington,Chicago,IL','F',38000,'666666603',8),('Megan','G','Jones',254937381,'02-MAR-1961','528 Stone CT,Chicago,IL','F',62000,'666666600',8),('Jon','A','Kramer',666666605,'22-AUG-1964','1988 Windy Creek,Seattle,WA','M',41500,'666666603',8),('Ray','H','King',666666606,'16-AUG-1949','213 Delk Road,Seattle,WA','M',44500,'666666604',9),('Gerald','D','Small',666666607,'15-MAY-1962','122 Ball Street,Dallas,TX','M',29000,'666666602',8),('Arnold','A','Head',666666608,'19-MAY-1967','233 Spring St,Dallas,TX','M',33000,'666666602',8),('Helga','C','Pataki',666666609,'11-MAR-1969','101 Holyoke St,Dallas,TX','F',32000,'666666602',8),('Naveen','B','Drew',666666610,'23-MAY-1970','198 Elm St,Philadelphia,PA','M',34000,'666666607',8),('Carl','E','Reedy',666666611,'21-JUN-1977','213 Ball St,Philadelphia,PA','M',32000,'666666610',8),('Sammy','G','Hall',666666612,'11-JAN-1970','433 Main Street,Miami,FL','M',37000,'666666611',8),('Red','A','Bacher',666666613,'21-MAY-1980','196 Elm Street,Miami,FL','M',33500,'666666612',8),('Roy','C','Lewallen',999999999,'02-MAR-1977','14 Wynncrest Street,Dallas,TX','M',75500,'666666600',8),('John','T','Ed',222333444,'18-FEB-1981','4505 West St,Rochester,NY','M',30000,'555555501',6),('Jennifer','A','Joy',223344667,'19-MAY-1976','1204 Main St,Miami,FL','F',45000,'666666613',8),('Kim','G','Ted',444222666,'15-APR-1968','3648 Tree Cir,Austin,TX','M',50000,'999999999',9),('Juan','G','Linda',112244668,'23-JUN-1965','1210 Apple St,Austin,TX','F',55000,'null',9),('Jose','H','Barbara',343434344,'28-FEB-1955','905 East St,Kleen,TX','F',35000,'444444400',6),('willie','D','Mary',234234234,'20-DEC-1961','101 South St,Arlington,TX','F',12000,'112244668',9),('Erin','A','Maxfield',242535609,'22-DEC-1971','123 Copper St,Arlington,TX','F',72000,'555555500',8),('Johny','C','Smith',122344668,'26-JAN-1972','1221 Diploma Dr.,Arlington,TX','M',65000,'999999999',9),('Sunil','D','Gupta',110110110,'01-FEB-2001','4312 Bowen Rd,Arlington,TX','M',80000,'111111100',3),('Penny','G','Wolowitz',673466642,'21-JAN-1974','42 South Blvd,Miami,FL','F',17000,'222333444',6),('Michael','A','Morgan',636669233,'11-MAY-1984','26 Sunset Blvd,Miami,FL','M',73500,'666666612',5),('Sheldon','C','Cucuou',849934919,'22-MAR-1974','11 Hollywood Blvd,Dallas,TX','M',35500,'888665555',8),('Debra','T','Hall',202843824,'11-MAR-1983','45 NY St,Rochester,NY','F',30000,'555555501',6),('Jisha','A','Carpenter',292740167,'29-MAY-1985','194 Beachdr,Miami,FL','F',15000,'666666613',1),('Gregory','G','Laurie',444212096,'15-SEP-1969','78 Tree Cir,Houston,TX','M',90000,'444444400',7),('Lisa','G','House',101248268,'29-JUN-1975','12 Maple St,Austin,TX','F',85000,'null',7),('Leonard','H','Moody',349273344,'09-FEB-1973','908 Greek Row,Austin,TX','M',45000,'444444400',7),('Jake','D','Sheen',245239264,'25-DEC-1954','20 North Co,Arlington,TX','M',52000,'112244668',6),('Wilson','A','Holmes',242916639,'02-JUN-1971','21 South Co,Arlington,TX','M',72500,'555555500',4),('Cameron','D','Thirteen',111422203,'04-MAY-2001','22 Univ Blvd,Arlington,TX','F',80000,'987987987',4),('Joseph','K','Kirkish',913323708,'04-MAR-1996','22 UT Blvd,Austin,TX','M',95000,'null',7),('Andrea','M','Sondrini',614370310,'30-DEC-1996','1450 Worthington St,Houston,TX','F',65000,'444444401',5),('Cindy','K','Burklow',432765098,'23-FEB-1984','2015 Neil Ave,Miami,FL','F',45000,'444444402',6),('Zach','A','Geller',913353347,'15-AUG-1990','333 PikeWay,Seattle,WA','M',55000,'444444403',6),('Alex','C','Yu',1614905,'17-OCT-1980','626 Mary St,Dallas,TX','M',50000,'444444400',6),('Richard','T','Koelbel',214370999,'3-APR-1976','50 Elk St,Chicago,IL','M',85000,'999999999',4),('Christina','S','Hisel',241625699,'5-JUL-1986','37 Church Row,Rochester,NY','F',45000,'123456789',6),('Percy','M','Liang',398172999,'12-JUN-1991','14 Maple St,Austin,TX','M',55000,'null',9),('James','U','Miller',906218888,'27-MAY-1978','13 Fifth St,Seattle,WA','M',75000,'999999999',5);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-06 12:16:01
