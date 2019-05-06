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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_email` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password_hash` varchar(166) DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('bebutler1@ualr.edu','Brock B Baller','10e75cbce8cdcd0d4b37fdbed3bb740',NULL),('fake5@noneya.com','','year3000',_binary '\0'),('HASHHASH_Test@test.com','','1000:71333bcf341a6b02fa3665069771b3bb:1113dc57438f1a67ca6fa0a88f86712a4e384ad203db80e29d4a3bb9ddf474336a85029aa0ec23b9ad1affa9325fad214fd56e794e6e1678e172355c9decb2b0',_binary '\0'),('NewUserMay4@test.com','','1000:6a5fd6308b159fbbbf402fb8444a41f1:0e6f5780381a457eaeb1e98cdadce15ebe713eae28c5e175957e745f453ae2528447df74aa0bb6a33971863998c9ac4571270300caebad162724e766c1b9239b',_binary '\0'),('novarSQL@test.com','novarSQL','someEasyPassword',_binary '\0'),('regTest@test.com','regTest','passpass321',_binary '\0'),('rweeks2010@hotmail.com','Ryan W','34819d7beeabb9260a5c854bc85b3e44',_binary ''),('tag_admin@gmail.com','','1000:e41f58538d05bdf3edd7833fef8b1ac5:36622f95318f5828af37fb8805ce549c470c298c91586ad4dffa3fd20b7f869c1d1832e0de7182b8c4649d7ae007dd1ef4082444e6e3d937b9bb252ea2bb1955',_binary ''),('test1@test.com','','1000:dec6ef6163c93b4da4a45c3451a22342:912c433b1ee1431d4a582d6f8bb5a8084905e377eb220c8bd181c875a053f324baf38300b52827df739603ec73b361d959545bef76df63d72b7ee1a0098ca0b4',_binary '\0'),('testemail@test.com','testuser','password123',NULL),('testemail@testmail.com','TestDummy','482c811da5d5b4bc6d497ffa98491e38',NULL),('testemail@ualr.edu','','1000:00fb852279a818d8c09ed51ead349f96:40997566e6affc5b44ef6c440b866f5fa4eff9f9f94110b50bacc361f7f3b4c7c4f2ba2869e31f5f4b97b486052a875e37576f3f6752631189092153fac83fb3',_binary '\0'),('txsuid@ualr.edu','','1234',_binary '\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-06 10:06:03
