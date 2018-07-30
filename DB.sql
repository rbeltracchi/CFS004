-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sidc_2
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `alergia`
--

DROP TABLE IF EXISTS `alergia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alergia` (
  `id_alergia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_alergia`),
  UNIQUE KEY `id_alergia` (`id_alergia`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alergia`
--

LOCK TABLES `alergia` WRITE;
/*!40000 ALTER TABLE `alergia` DISABLE KEYS */;
INSERT INTO `alergia` VALUES (46,'acaros'),(42,'mani'),(44,'nuez'),(45,'rinitis');
/*!40000 ALTER TABLE `alergia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antecedente`
--

DROP TABLE IF EXISTS `antecedente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedente` (
  `idAntecedente` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `matricula` int(11) DEFAULT NULL,
  `especialidad` varchar(45) DEFAULT NULL,
  `diagnostico` varchar(500) DEFAULT NULL,
  `idHistoriaClinica` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAntecedente`),
  KEY `FK_ANTECEDENTE` (`matricula`),
  KEY `idHistoriaClinica` (`idHistoriaClinica`),
  CONSTRAINT `FK_ANTECEDENTE` FOREIGN KEY (`matricula`) REFERENCES `medico` (`matricula`),
  CONSTRAINT `antecedente_ibfk_1` FOREIGN KEY (`idHistoriaClinica`) REFERENCES `historiaclinica` (`idHistoriaClinica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedente`
--

LOCK TABLES `antecedente` WRITE;
/*!40000 ALTER TABLE `antecedente` DISABLE KEYS */;
INSERT INTO `antecedente` VALUES (1,'2018-07-09',1,'kinesiología','esguince de rodilla',30911509),(2,'2016-06-01',1,'NEUROLOGIA','Esquisofrenia,bipolaridad,multiples personalidades a causa del Plan 111mil',30911509),(60,'2010-05-01',1,'CARDIOLOGIA','Aritmia,leve soplo',31236545);
/*!40000 ALTER TABLE `antecedente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historiaclinica`
--

DROP TABLE IF EXISTS `historiaclinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historiaclinica` (
  `idHistoriaClinica` int(11) NOT NULL,
  `grupo_sanguineo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idHistoriaClinica`),
  UNIQUE KEY `idHistoriaClinica` (`idHistoriaClinica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historiaclinica`
--

LOCK TABLES `historiaclinica` WRITE;
/*!40000 ALTER TABLE `historiaclinica` DISABLE KEYS */;
INSERT INTO `historiaclinica` VALUES (30911509,'A+'),(31236545,'0-');
/*!40000 ALTER TABLE `historiaclinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialdealergias`
--

DROP TABLE IF EXISTS `historialdealergias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialdealergias` (
  `idHistoriaClinica` int(11) NOT NULL,
  `id_alergia` int(11) NOT NULL,
  PRIMARY KEY (`idHistoriaClinica`,`id_alergia`),
  KEY `FK_HISTORIALDEALERGIAS_ALERGIA` (`id_alergia`),
  CONSTRAINT `FK_HISTORIALDEALERGIAS_ALERGIA` FOREIGN KEY (`id_alergia`) REFERENCES `alergia` (`id_alergia`),
  CONSTRAINT `FK_HISTORIALDEALERGIAS_HISTORIACLINICA` FOREIGN KEY (`idHistoriaClinica`) REFERENCES `historiaclinica` (`idHistoriaClinica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialdealergias`
--

LOCK TABLES `historialdealergias` WRITE;
/*!40000 ALTER TABLE `historialdealergias` DISABLE KEYS */;
INSERT INTO `historialdealergias` VALUES (30911509,45);
/*!40000 ALTER TABLE `historialdealergias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialdeantecedentes`
--

DROP TABLE IF EXISTS `historialdeantecedentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialdeantecedentes` (
  `idAntecedente` int(11) NOT NULL,
  `idHistoriaClinica` int(11) NOT NULL,
  PRIMARY KEY (`idAntecedente`,`idHistoriaClinica`),
  KEY `FK_HISTORIALDEANTECEDENTES_HISTORIACLINICA` (`idHistoriaClinica`),
  CONSTRAINT `FK_HISTORIALDEANTECEDENTES_ANTECEDENTE` FOREIGN KEY (`idAntecedente`) REFERENCES `antecedente` (`idAntecedente`),
  CONSTRAINT `FK_HISTORIALDEANTECEDENTES_HISTORIACLINICA` FOREIGN KEY (`idHistoriaClinica`) REFERENCES `historiaclinica` (`idHistoriaClinica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialdeantecedentes`
--

LOCK TABLES `historialdeantecedentes` WRITE;
/*!40000 ALTER TABLE `historialdeantecedentes` DISABLE KEYS */;
INSERT INTO `historialdeantecedentes` VALUES (1,30911509),(2,30911509);
/*!40000 ALTER TABLE `historialdeantecedentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `matricula` int(11) NOT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  `dniMedico` int(11) NOT NULL,
  `especialidad` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `FK_MEDICO` (`dniMedico`),
  CONSTRAINT `FK_MEDICO` FOREIGN KEY (`dniMedico`) REFERENCES `persona` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,'aaa',13130347,'kinesiología','Jazmin','Guerra'),(123456,'aaa',111,'cardiologia','Antonio','Barrientos'),(234567,'aaa',112,'cardiologia','Luis','Cicco'),(267893,'aaa',116,'oncologia','German','Poiman'),(567890,'aaa',113,'neurologia','Luis','Coppola'),(637891,'aaa',117,'pediatria','Jorge','Cabana'),(675412,'aaa',115,'oncologia','Omar','Ponce'),(775522,'aaa',118,'pediatria','Ricardo','Burstein'),(987654,'aaa',114,'neurologia','Pablo','Lolli');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `id_historiaClinica` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `calle` varchar(20) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `letra` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `id_historiaClinica` (`id_historiaClinica`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `FK_PERSONA_HISTORIACLINICA` FOREIGN KEY (`id_historiaClinica`) REFERENCES `historiaclinica` (`idHistoriaClinica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (111,'Antonio','Barrientos','1970-05-19','antbarrientos@gmail.com','4445590',NULL,'pass','Sarmiento',877,0,' '),(112,'Luis','Cicco','1979-05-18','lui.cicco@gmail.com','4657799',NULL,'pass','Chacabuco',340,0,' '),(113,'Luis','Coppola','1975-09-02','coppolui@gmail.com','4657799',NULL,'pass','Avellaneda',186,0,' '),(114,'Pablo','Lolli','1980-07-20','pablo.loli@gmail.com','4455667',NULL,'pass','Colon',1193,0,' '),(115,'Omar','Ponce','1976-01-14','ponceo@gmail.com','4449159',NULL,'pass','Bolivar',529,0,' '),(116,'German','Poiman','1978-01-11','poinmger@gmail.com','4494780',NULL,'pass','Belgrano',11,0,' '),(117,'Jorge','Cabana','1975-05-31','jcabanar@gmail.com','4445792',NULL,'pass','España',799,0,' '),(118,'Ricardo','Burstein','1974-08-21','rickyBurs@gmail.com','44310110',NULL,'pass','España',799,0,' '),(13130347,'jazmin','guerra',NULL,'llllllooooo','11111111',NULL,'pass','paz',120,1,'a'),(13457865,'mario','Cuevas','1974-07-04','maroCu@gmail.com','154606060',NULL,'pass','rodriguez',1450,0,' '),(22222222,'juan','gomex',NULL,'juag@gmail.com','33333333',NULL,'pass','paz',120,1,'a'),(30911509,'julian','herrera','1984-03-16','julianeherreraok@gmail.com','154608141',30911509,'root','constitucion',1457,1,'b'),(31236545,'Maria','Lopez','3885-08-02','asdasd1@gmail.com','213123',31236545,'pass','Maipu',789,1,'1'),(34111111,'Juan','Perez','3894-11-23','asdasd@gmail.com','12132312',NULL,'pass','moreno',1111,1,'1'),(36123123,'Lucas','Paredes','1980-11-10','qweqwe@gmail.com','213132123',NULL,'pass','asd',123,1,'2'),(301112244,'pablo','capella',NULL,'uni','445566',NULL,'abc','alem',60,1,'c');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sede` (
  `idSede` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `calle` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `letra` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`idSede`),
  UNIQUE KEY `idSede` (`idSede`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede`
--

LOCK TABLES `sede` WRITE;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` VALUES (1,'clinica modelo','4445792','clinicaModelo@gmail.com','Sarmiento',2,5,'e','abc'),(2,'maria Auxiliadora','4440133','nada','Loberia y Tacuari',0,0,'0','123'),(3,'ctro Barrio Selvetti','4422010','dirmedica@sisptandil.gob.ar','Caseros',1775,0,'0','abc'),(4,'CAP Lisandro de La Torre','4451685','dir.medica@sisptandil.gob.ar','jujuy',46,0,'0','abc'),(5,'Centro de Salud Las Tunitas','4422011','','Rossello',90,0,'0',''),(6,'CAP Metalurgico','4442011','null ','Muñoz y Cardiel',0,0,'0','');
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacuna`
--

DROP TABLE IF EXISTS `vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacuna` (
  `idVacuna` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `meses` int(11) DEFAULT NULL,
  `fechaVencimiento` date DEFAULT NULL,
  PRIMARY KEY (`idVacuna`),
  UNIQUE KEY `idVacuna` (`idVacuna`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacuna`
--

LOCK TABLES `vacuna` WRITE;
/*!40000 ALTER TABLE `vacuna` DISABLE KEYS */;
INSERT INTO `vacuna` VALUES (1,'Hepatitis B',0,'2018-12-01'),(2,'Tuberculosis BCG',0,'2019-01-01'),(3,'neumococo conjugada',3,'2019-01-01'),(4,'Poliomelitis',3,'2019-01-01'),(5,'Quinuple pentavalente',3,'2019-01-01'),(6,'Rotavirus',3,'2019-01-01'),(7,'Meningococo',3,'2019-01-01'),(8,'Neumococo conjugada 2da',4,'2019-01-01');
/*!40000 ALTER TABLE `vacuna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacunaporsede`
--

DROP TABLE IF EXISTS `vacunaporsede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacunaporsede` (
  `idVacuna` int(11) NOT NULL,
  `idSede` int(11) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVacuna`,`idSede`),
  KEY `FK_VACUNAPORSEDE_SEDE` (`idSede`),
  CONSTRAINT `FK_VACUNAPORSEDE_SEDE` FOREIGN KEY (`idSede`) REFERENCES `sede` (`idSede`),
  CONSTRAINT `FK_VACUNAPORSEDE_VACUNA` FOREIGN KEY (`idVacuna`) REFERENCES `vacuna` (`idVacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacunaporsede`
--

LOCK TABLES `vacunaporsede` WRITE;
/*!40000 ALTER TABLE `vacunaporsede` DISABLE KEYS */;
INSERT INTO `vacunaporsede` VALUES (1,1,100),(1,2,200),(2,1,200),(3,1,400);
/*!40000 ALTER TABLE `vacunaporsede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacunasaplicadas`
--

DROP TABLE IF EXISTS `vacunasaplicadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacunasaplicadas` (
  `idVacuna` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `fechaDeAplicacion` date NOT NULL,
  PRIMARY KEY (`idVacuna`,`dni`),
  KEY `FK_VACUNASAPLICADAS_PERSONA` (`dni`),
  CONSTRAINT `FK_VACUNASAPLICADAS_PERSONA` FOREIGN KEY (`dni`) REFERENCES `persona` (`dni`),
  CONSTRAINT `FK_VACUNASAPLICADAS_VACUNA` FOREIGN KEY (`idVacuna`) REFERENCES `vacuna` (`idVacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacunasaplicadas`
--

LOCK TABLES `vacunasaplicadas` WRITE;
/*!40000 ALTER TABLE `vacunasaplicadas` DISABLE KEYS */;
INSERT INTO `vacunasaplicadas` VALUES (1,30911509,'2018-11-08'),(2,30911509,'2018-11-08'),(3,30911509,'2018-11-08'),(5,30911509,'2018-07-01');
/*!40000 ALTER TABLE `vacunasaplicadas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-30 12:52:19