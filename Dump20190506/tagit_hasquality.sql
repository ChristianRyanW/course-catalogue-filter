-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: tagit
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hasquality`
--

DROP TABLE IF EXISTS `hasquality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hasquality` (
  `course_subject` varchar(4) NOT NULL,
  `course_number` varchar(4) NOT NULL,
  `tag_name` varchar(50) NOT NULL,
  PRIMARY KEY (`course_subject`,`course_number`,`tag_name`),
  KEY `tag_name` (`tag_name`),
  CONSTRAINT `hasquality_ibfk_1` FOREIGN KEY (`course_subject`, `course_number`) REFERENCES `course` (`course_subject`, `course_number`),
  CONSTRAINT `hasquality_ibfk_2` FOREIGN KEY (`tag_name`) REFERENCES `tag` (`tag_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hasquality`
--

LOCK TABLES `hasquality` WRITE;
/*!40000 ALTER TABLE `hasquality` DISABLE KEYS */;
INSERT INTO `hasquality` VALUES ('CPSC','4377','AI'),('CPSC','4383','AI'),('CPSC','4388','AI'),('CPSC','4366','Animation'),('CPSC','3482','Architecture'),('CPSC','4381','Architecture'),('CPSC','4387','Architecture'),('CPSC','4389','Architecture'),('CPSC','3380','Assembly Language'),('CPSC','2377','C++'),('CPSC','2380','C++'),('CPSC','4366','C++'),('CPSC','4372','C++'),('CPSC','4373','C++'),('CPSC','4377','C++'),('CPSC','4383','C++'),('CPSC','4392','C++'),('CPSC','3380','Computer Systems'),('CPSC','3482','Computer Systems'),('CPSC','1105','CORE'),('CPSC','1175','CORE'),('CPSC','1310','CORE'),('CPSC','1375','CORE'),('CPSC','2376','CORE'),('CPSC','2380','CORE'),('CPSC','3482','CORE'),('CPSC','4373','CORE'),('CPSC','4392','CORE'),('CPSC','1310','CSS'),('CPSC','4392','CSS'),('CPSC','4375','Data Management'),('CPSC','4375','Data Storage'),('CPSC','4375','Database'),('CPSC','4389','Database'),('CPSC','4392','Database'),('CPSC','1310','Design'),('CPSC','4366','Design'),('CPSC','4367','Design'),('CPSC','4373','Design'),('CPSC','4377','Design'),('CPSC','4381','Design'),('CPSC','4384','Design'),('CPSC','4388','Design'),('CPSC','4389','Design'),('CPSC','4392','Design'),('CPSC','4389','E-Commerce'),('CPSC','1105','First Year'),('CPSC','2377','Games'),('CPSC','4377','Games'),('CPSC','1310','HTML'),('CPSC','4392','HTML'),('CPSC','1175','Intro'),('CPSC','1370','Intro'),('CPSC','2377','Intro'),('CPSC','2376','JAVA'),('CPSC','2380','JAVA'),('CPSC','4366','JAVA'),('CPSC','4372','JAVA'),('CPSC','4373','JAVA'),('CPSC','4377','JAVA'),('CPSC','4383','JAVA'),('CPSC','4389','JAVA'),('CPSC','4392','JAVA'),('CPSC','4383','Machine Learning'),('CPSC','4388','Machine Learning'),('CPSC','4367','Mobile'),('CPSC','4377','Multimedia'),('CPSC','4360','Networks'),('CPSC','4376','Networks'),('CPSC','4384','Networks'),('CPSC','4387','Networks'),('CPSC','4389','Networks'),('CPSC','1375','Object-Oriented'),('CPSC','2376','Object-Oriented'),('CPSC','2377','Object-Oriented'),('CPSC','4372','Object-Oriented'),('CPSC','4387','Object-Oriented'),('CPSC','1175','Programming'),('CPSC','1372','Programming'),('CPSC','1375','Programming'),('CPSC','2376','Programming'),('CPSC','2377','Programming'),('CPSC','2380','Programming'),('CPSC','2399','Programming'),('CPSC','3370','Programming'),('CPSC','3371','Programming'),('CPSC','3383','Programming'),('CPSC','4366','Programming'),('CPSC','4367','Programming'),('CPSC','4372','Programming'),('CPSC','4373','Programming'),('CPSC','4377','Programming'),('CPSC','4383','Programming'),('CPSC','4392','Programming'),('CPSC','1372','RPG'),('CPSC','4360','Security'),('CPSC','4375','Security'),('CPSC','4376','Security'),('CPSC','1372','Software'),('CPSC','1375','Software'),('CPSC','2380','Software'),('CPSC','4377','Software'),('CPSC','4383','Software'),('CPSC','4367','Software Engineering'),('CPSC','4373','Software Engineering'),('CPSC','4389','Software Engineering'),('CPSC','4392','Software Engineering'),('CPSC','4375','SQL'),('CPSC','4389','SQL'),('CPSC','4392','SQL'),('CPSC','1310','Web Design'),('CPSC','4373','Web Design'),('CPSC','4392','Web Design'),('CPSC','4371','Writing'),('CPSC','4392','Writing');
/*!40000 ALTER TABLE `hasquality` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-06 10:06:05
