-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: procject
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commentq`
--

DROP TABLE IF EXISTS `commentq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentq` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `postno` int(11) DEFAULT NULL,
  `userid` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`seq`),
  UNIQUE KEY `seq_UNIQUE` (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentq`
--

LOCK TABLES `commentq` WRITE;
/*!40000 ALTER TABLE `commentq` DISABLE KEYS */;
INSERT INTO `commentq` VALUES (4,29,'ad@naver.com','qq'),(8,27,'효나띵','22'),(19,23,'111','d'),(21,24,'111',''),(22,25,'111','');
/*!40000 ALTER TABLE `commentq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Counseling`
--

DROP TABLE IF EXISTS `Counseling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Counseling` (
  `cno` int(11) NOT NULL AUTO_INCREMENT,
  `cusername` varchar(20) DEFAULT NULL,
  `cuserid` varchar(45) DEFAULT NULL,
  `ctitle` varchar(20) DEFAULT NULL,
  `ccontent` text,
  `cdate` date DEFAULT NULL,
  `cviewcount` int(11) NOT NULL DEFAULT '0',
  `canswer` varchar(45) DEFAULT NULL,
  `canswerdate` date DEFAULT NULL,
  PRIMARY KEY (`cno`),
  UNIQUE KEY `cno_UNIQUE` (`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Counseling`
--

LOCK TABLES `Counseling` WRITE;
/*!40000 ALTER TABLE `Counseling` DISABLE KEYS */;
INSERT INTO `Counseling` VALUES (12,'dㄴㄹ','asd@naver.com',NULL,NULL,'2020-11-02',86,'하이',NULL),(22,'sdf','asd@naver.com',NULL,NULL,'2020-12-04',5,'하이2',NULL),(23,'sdf','asd@naver.com',NULL,NULL,'2020-12-05',48,'ㅇㅇㄴㄴㅇㄴㅇ',NULL),(24,'sdf','asd@naver.com',NULL,NULL,'2020-12-05',4,'ㄴㅁㄴㅁㄴ',NULL),(25,'df','asd@naver.com',NULL,NULL,'2020-12-05',0,NULL,NULL),(26,'f','asd@naver.com',NULL,NULL,'2020-12-05',0,NULL,NULL),(27,'fd','asd@naver.com',NULL,NULL,'2020-12-05',0,NULL,NULL),(28,'df','asd@naver.com',NULL,NULL,'2020-12-05',0,NULL,NULL),(29,'df','asd@naver.com',NULL,NULL,'2020-12-05',0,NULL,NULL),(30,'ㄴㅇㄴㄹ','asd@naver.com',NULL,NULL,'2020-12-05',1,NULL,NULL),(31,'ㄴㅇㄹㄻㄴㅇ','asd@naver.com',NULL,NULL,'2020-12-05',0,NULL,NULL),(32,NULL,'asd@naver.com',NULL,'dfdsf',NULL,1,'sddf','2020-12-05'),(33,'sdfdfdfff','asd@naver.com','sdf','dfsdf','2020-12-05',9,'sssssss','2020-12-05'),(34,NULL,'asd@naver.com',NULL,NULL,NULL,2,'sdff','2020-12-05'),(35,NULL,'asd@naver.com',NULL,NULL,NULL,0,'sddf','2020-12-05'),(36,NULL,'asd@naver.com',NULL,NULL,NULL,1,'sdfdfff','2020-12-05'),(37,NULL,'asd@naver.com',NULL,NULL,NULL,1,'dfsdf','2020-12-05'),(38,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(39,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(40,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(41,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(42,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(43,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(44,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(45,NULL,'asd@naver.com',NULL,NULL,NULL,0,NULL,'2020-12-05'),(46,'혀나띵','asd@naver.com',NULL,NULL,'2020-12-06',1,NULL,NULL),(47,'혀나띵','asd@naver.com',NULL,NULL,'2020-12-06',2,'그만!!! 집갈래!!',NULL),(48,'혀나띵','asd@naver.com','123','123','2020-12-06',1,'이거머야\r\n',NULL);
/*!40000 ALTER TABLE `Counseling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `dno` int(11) NOT NULL AUTO_INCREMENT,
  `duserno` int(11) DEFAULT '0',
  `dsubno` int(11) DEFAULT '0',
  `daddress1` varchar(45) DEFAULT '0',
  `daddress2` varchar(45) DEFAULT '0',
  `daddress3` varchar(45) DEFAULT '0',
  `duserid` varchar(45) DEFAULT '0',
  `dtel` varchar(45) DEFAULT '0',
  `dmsg` varchar(45) DEFAULT '0',
  `dusername` varchar(45) DEFAULT '0',
  PRIMARY KEY (`dno`),
  UNIQUE KEY `deliveryno_UNIQUE` (`dno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (1,0,313,'1','222','222','222','222','222','222'),(2,0,4,'2','2','2','2','0','0','0'),(3,0,4,'2','2','2','2','0',NULL,'0'),(4,0,4,'06027','ddddddd','dd','test@naver.com','0','0','0'),(5,0,4,'06302','서울 강남구 양재천로 163','dd','test09@naver.com','123','쩌ㅔ~네~','애정'),(6,0,4,'06237','서울 강남구 테헤란로20길 25','갤러리원','mg6613@naver.com','0','0','0'),(7,0,4,'07505','서울 강서구 대장로 39','123','t@naver.com','0','0','0'),(8,0,0,'06027','서울 강남구 압구정로 102','11','2@naver.com','0','0','0'),(9,0,0,'06027','서울 강남구 압구정로 102','111','n@naver.com','0','0','0'),(10,0,0,'06035','서울 강남구 가로수길 5','어딘가에 살아요','test@naver.com','0','0','0');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `nno` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(45) DEFAULT NULL,
  `ncontent` varchar(1000) DEFAULT NULL,
  `ninsertdate` date DEFAULT NULL,
  `nviewcount` int(11) DEFAULT '0',
  PRIMARY KEY (`nno`),
  UNIQUE KEY `nno_UNIQUE` (`nno`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'[공지] WHYN 서비스 오픈',' 안녕하세요, 당신의 퍼스널 와인 구독 서비스 WHYN의 관리자 입니다. \r\n \r\n \r\n  저희 WHYN을 방문해 주신 고객님들께 진심으로 감사 드리며 \r\n 2020년 12월08일 정식 오픈했음을 알려드립니다.\r\n \r\n  오픈초기라 오류 및 문제점이 많을거라 판단됩니다.\r\n 해당 불편사항에 대해서는 문의 게시판을 통해 알려주시면 이용에 불편함이 없도록 신속하게 조취를 취하도록 하겠습니다.\r\n \r\n 감사합니다.\r\n ','2020-12-07',8),(2,'[공지] 안내드립니다.',' 저희 WHYN은 와인구독 서비스로 운영중이기 때문에 19살 이하의 미성년자에게는 구독서비스가 불가능합니다. 이 점 참고바랍니다.\r\n  감사합니다.','2020-12-07',1),(3,'[배송공지] 배송일 공지',' 배송일은 처음 구독시 선택가능합니다. 매달 5일,10일, 15일로 나뉘어져있어, 편하신 날을 선택하면 그 날짜에 맞게 WHYN에서 배송 도와드립니다. \r\n  감사합니다.','2020-12-07',2),(4,'[이벤트] !! WHYN 만의 특별한 이벤트!!',' 코로나 사태로 심각한 이 시국에 밖에서 말고 집콕 하면서 저희 WHYN의 와인을 즐기고 있는걸 사진으로 후기 남겨 주시면 추첨을 통해 다음 회차 때 받으셨던 와인과는 다른 와인으로 한병 더 드립니다!\r\n \r\n 많은 참여 부탁드립니다. 감사합니다.','2020-12-07',1),(5,'[공지] 후기에 관해 안내드립니다.',' 저희는 구독신청 한 후, 결제가 되면서 고객님께 맞는 와인을 추천드리는 시스템입니다. 되도록이면 후기엔 어떤 와인을 받았는지에 대한 언급은 자중해 주시길 바랍니다. ','2020-12-07',0),(6,'[이벤트] !! 와인과 어울리는 안주 이벤트!! ',' 저희 WHYN에서 특별 이벤트를 준비했습니다!\r\n \r\n 저희 인스타그램에 있는 게시글을 리그램 해주시고 \r\n #WHYN #와인구독 #와인 #안주이벤트 #퍼스널와인 \r\n 을 해쉬태그 해주시면 추첨을 통해 와인과 어울리는 안주를 \r\n 보내드립니다!!\r\n \r\n 기간은 일주일간 진행되며 당첨자발표는 일주일 후 오후 6시에 진행될 예정입니다.\r\n \r\n 많은 관심 부탁드립니다~!감사합니다.','2020-12-07',1),(7,'[공지] 사이트 점검에 대해 안내드립니다.',' 오후 12시 부터 15시까지 진행될 사이트 점검에 대해 안내드립니다. \r\n \r\n  보다 더 나은 서비스를 위해  사이트 점검을 진행하게 되었습니다. 불편하시더라도 15시 이후에 사이트 방문 바랍니다.\r\n \r\n 감사합니다.','2020-12-07',0),(8,'[추천] 겨울에는 따뜻한 뱅쇼와 함께',' 겨울이 한발자국 다가왔습니다. 많이 추워진 날씨에 감기예방도 되고 맛도 있는 뱅쇼는 어떠신가요?\r\n \r\n  와인과 시나몬,과일,설탕 등을 넣고 끓여준 뒤 마시면 몸도 따뜻해지고 감기예방도 된답니다!\r\n \r\n 다들 겨울엔 추위에 떨지말고 뱅쇼와 함께 보내는게 어떨까요? \r\n \r\n 이상 WHYN에서 올립니다!','2020-12-07',0),(9,'[공지] 서비스관련 공지',' 구독해주신 후, 한달이상 구독서비스를 받으셨다면 따로 취소나 환불은 불가합니다. 참고부탁드립니다.','2020-12-07',0),(10,'[공지] 연휴 안내드립니다.',' 택배사의 연휴에 인해 약 일주일 동안은 배송이 미뤄질것으로 예상됩니다. 참고부탁드립니다.','2020-12-07',1),(11,'[이벤트] !!매장 방문시 오프너를 드립니다!!',' 저희 매장을 찾아주시는 모든 고객님들 15 분에 한하여 선착순으로 오프너를 선물로 드립니다!!\r\n \r\n \r\n \r\n *1인 1오프너 증정\r\n *소진시 이벤트 종료','2020-12-07',2);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productlist`
--

DROP TABLE IF EXISTS `productlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productlist` (
  `pno` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) DEFAULT NULL,
  `pcount` int(11) DEFAULT NULL,
  `pcountry` varchar(100) DEFAULT NULL,
  `pcolor` varchar(45) DEFAULT NULL,
  `ptext` varchar(1000) DEFAULT NULL,
  `pcontent` int(11) DEFAULT NULL,
  `pimage` varchar(100) DEFAULT NULL,
  `prealimage` varchar(100) DEFAULT NULL,
  `psno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pno`),
  UNIQUE KEY `pno_UNIQUE` (`pno`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productlist`
--

LOCK TABLES `productlist` WRITE;
/*!40000 ALTER TABLE `productlist` DISABLE KEYS */;
INSERT INTO `productlist` VALUES (1,'1959 Domaine de la Romanee-Conti Romanee Conti',1,'France','Red ','Romanee-Conti is the most famous vineyard in the world, and certainly the most celebrated in Burgundy. It is a 4.32-acre Grand Cru parcel owned exclusively by Domaine de la Romanee-Conti. The Grand Cru pinot noir produced from the vineyard is one of the world’s most acclaimed wines.',13,'Romanee.jpg','Romanee.jpg','1'),(2,'Domaine Georges Roumier Bonnes Mares Grand Cru 1999',1,'France','Red ','The nose is still showing incredibly ripe (but not roasted) intense blueberry, blackberry and cassis aromas with concentrated, powerful, intense and gorgeously sappy flavors that just explode on the palate supported by mouth coating tannins, exquisite balance and that certain \"presence\" that all great wines have.',13,'Domaine-Georges-Roumier-Bonnes-Mares-Grand-Cru-1999---Mag.jpg','Domaine-Georges-Roumier-Bonnes-Mares-Grand-Cru-1999---Mag6.jpg','1'),(3,'Domaine des Lambrays Clos des Lambrays Grand Cru 2014',1,'France','Red ','A notably spicy, fresh, cool and floral nose displays mostly red berry fruit scents that are trimmed in discreet earth notes.  There is excellent cut and definition to the nicely rich and attractively textured flavors that culminate in a presently austere finale though I doubt that austerity will persist. ',14,'Lambrays.jpg','Lambrays.jpg','1'),(4,'Domaine Serafin Pere & Fils Charmes Chambertin Grand Cru 2016',1,'France','Red ','Very deep ruby color. An exceptionally ripe nose features liqueur-like aromas of cassis, plum, spice and plenty of earth. There is superb richness to the broad-shouldered flavors that brim with sappy dry extract that imparts a wonderful velvety texture on the very backward and firmly structured finish',14,'Serafin2.jpg','Serafin2.jpg','1'),(5,'Domaine Rossignol Trapet Beaune Les Teurons Premier Cru 2017',23,'France','Red ','The 2017 Beaune Les Teurons 1er Cru has an open-knit,  charming bouquet brimming with red cherries, strawberry pastilles and  hints of fig jam. I appreciate the delineation and purity here. The  palate is medium-bodied with fresh ripe tannin, a fine line of acidity, ',12,'Rogssinal.jpg','Rogssinal.jpg','1'),(6,'Domaine Lignier Michelot Morey St Denis Faconnieres 2017',0,'France','Red ','The 2017 Morey-Saint-Denis Faconnières 1er Cru is tight and backward on  the surly nose, offering undergrowth, iris petal and seaweed scents. The  medium-bodied palate delivers fine-grained tannins, a citrus-fresh  start and impressive harmony and length. Great potential.',12,'Lignier.jpg','Lignier.jpg','1'),(7,'Maison Louis Jadot Clos de la Roche Grand Cru 2014',10,'France','Red ','There is ample wood and menthol present on the dark cherry, earth and saddle leather suffused nose where a very subtle hint of volatile acidity arises. I like the mouth feel to the medium-bodied and ultra-suave flavors thanks mostly to the notably fine-grained tannins, all wrapped in a very firm, serious, powerful and youthfully austere finish',12,'LouisJadot.jpg','LouisJadot.jpg','1'),(8,'Maison Olivier Bernstein Gevrey Chambertin Les Cazetiers Premier Cru 2012 ',7,'France','Red ','Bernstein\'s 2012 Gevrey-Chambertin Les Cazetiers is seriously rich, powerful and concentrated, with a core of intense fruit that is going to need time to fully blossom. Still, there is a purity to the Cazetiers that is impossible to miss. Sweet floral and spice notes flesh out on the voluptuous, textured finish. The Cazetiers is distinguished for its superb density and structure.',13,'MaisonOlivier.jpg','MaisonOlivier.jpg','1'),(9,'Domaine Comte Armand Pommard Clos des Epeneaux Premier Cru 2010',5,'USA','Red','Comte Armand’s 2010 Pommard Clos des Epeneaux kicks off the tasting in grand style. What can I say? The 2010 is a great example of the year. Layers of generous fruit are buffered by underlying veins of acidity and minerality in a wine that is already virtually impossible to resist. This is a fabulous showing from a wine that consistently overdelivers. Already, the room is buzzing.',14,'Armand.jpg','Armand.jpg','4'),(11,'Domaine Patrice Rion Chambolle Musigny Les Amoureuses Premier Cru 2015',2,'France','Red ','A deft application of wood sets off spice and floral-infused aromas of ultra-pure red berries along with Asian-style tea nuances. The classy and gorgeously intense flavors possess notably fine detail as well as a driving minerality while being supported by dense but fine-grained tannins on the gorgeously complex finale. This is a most impressive effort with superb underlying material.',13,'Patrice.jpg','Patrice.jpg','1'),(12,'Domaine Taupenot Merme Chambolle Musigny Combe d\'Orveau Premier Cru 2017',12,'France','Red ','Tasting note: A slightly riper, pure and airy nose offers up pretty red and dark raspberry aromas that are cut with hints of spice, rose petal and wood. The vibrant and wonderfully refined medium-bodied flavors exude an evident minerality on the chiseled, focused and lingering finish. This too needs to develop better depth but it should do so with a few years of cellaring.',13,'Tauqenot.jpg','Tauqenot.jpg','1'),(13,'Domaine Denis Mortet Gevrey Chambertin Premier Cru 2013',6,'France','Red ','There is a background touch of wood framing the wonderfully fresh nose that is comprised by notes of humus, earth and airy red berry fruit scents. There is fine volume to the very round and pliant middle weight flavors that also display an appealing stoniness on the seductively textured, balanced and saline-inflected finale. This is clean, sleek and persistent.',13,'Denis.jpg','Denis.jpg','1'),(14,'Lafleur 2004',6,'France','Red ','I absolutely adored the Château Lafleur 2004 when I first tasted it from barrel. Now with a decade on the clock, it is beginning to truly fulfil its promise as one of the wines of that vintage. It has a deep garnet hue. The nose demonstrates a sense of energy married with outstanding delineation: blackberry, blueberry and freshly shaved black truffle',13,'Lafleur.jpg','Lafleur.jpg','1'),(15,'DECLARATION',3,'USA','Red ','Color: Deep Dark Purple & Burgundy Red | Nose: Dark blueberry, juicy blackberry, traces of red currant | Palate: The palate is robust with flavors of dark blueberry, blackberry, traces of red currant and subtle sweet oak from the barrel. This wine is fruit forward, full-bodied and spreads richly across the palate with soft velvety tannins and a long-lasting finish.',15,'declaration.jpg','declaration.jpg','4'),(16,'ANONYMOUS',6,'USA','Red ','Inspired by the artist whose craft takes him under the blanket of darkness into the dark of night creating works only revealed when illuminated at sunrise. His style is unique and complex. His palette is colorful and bold. Many know his work but his true identity is concealed.',15,'anonymous.jpg','anonymous.jpg','4'),(17,'Domaine Henri Boillot Puligny Montrachet Clos de la Mouchere Premier Cru 2017',2,'France','White','A touch of mineral reduction can be found on the markedly floral-inflected nose of white peach, spice and discreet wood nuances. There is first-rate volume to the caressing yet powerful flavors that possess excellent mid-palate density before concluding in a highly energetic, complex and beautifully well-balanced finale.',11,'Boillot.jpg','Boillot.jpg','3'),(18,'Domaine Ponsot Morey St Denis Monts Luisants Premier Cru 2016',12,'France','White','A brooding and decidedly timid nose only grudgingly reveals its aromas of soft spice, petrol, matchstick and white-fleshed fruit. The agreeably textured and vibrant middle weight flavors possess evident minerality as well as excellent detail on the sleek and bone dry finish that is shaped by citrus-tinged acidity. ',12,'Ponsot.jpg','Ponsot.jpg','3'),(19,'Domaine William Fevre Chablis Les Preuses Grand Cru 2017',32,'France','White','An exotic, totally beguiling wine, the 2017 Chablis Les Preuses Grand Cru melds together rich fruit with saline, mineral-drenched intensity. White flowers, mint, white pepper and crushed rocks add tremendous lift to this striking, utterly captivating Chablis. A wine of superb classicism, the Preuses has it all. That\'s all there is to it.',12,'Ferve.jpg','Ferve.jpg','3'),(20,'Domaine Arnaud Ente Meursault 2017',18,'France','White','This is actually not aromatically dissimilar to the Bourgogne Chardonnay with perhaps a bit more overall layering. By contrast there is considerably better concentration to the more mineral-inflected medium-bodied flavors that offer both good richness and vibrancy, all wrapped in a dry, clean and focused finish. This is a very fine Meursault villages and worth considering.',12,'Arnaud.jpg','Arnaud.jpg','3'),(22,'Vallebelbo Moscato d\'Asti DOCG',12,'Italy','White','Browse through and learn what happened during different wine vintages. A useful resource for hunting down that rare bottle or a birthday-year wine for a loved one’s special day.',10,'Valledbelbo.webp','Valledbelbo.webp',NULL),(23,'Joseph Phelps Insignia 2016',6,'USA','Red ','The 2016 Insignia is fresh and focused on entry with expressive cocoa powder, graphite and earthy spices. Elegant and complex with a supple, creamy texture and bold tannins, this latest vintage offers luscious ripe plum and blackberry character with hints of roasted coffee and dark cherry throughout the palate to a long, velvety finish. \r\nBlend: 84% Cabernet Sauvignon, 10% Petit Verdot, 3% Malbec, 3% Cabernet Franc',14,'insi.webp','insi.webp','4'),(24,'2009 Alban Vineyards - Roussanne Estate',13,'USA','White','The 2009 Roussanne comes across as quite rich and textured, with plenty of overt fruit, but less aromatic complexity and overall minerality. The vintage was the third in a series of drought years and the low - perhaps excessively low - yields are felt in the weight of the wine. Anticipated maturity: 2012-2017. Antonio Galloni 8/2011\r\n\r\n',13,'Alban.html','Alban.html','5'),(25,'2009 Peter Michael Winery - La Carriere Chardonnay ',20,'USA','White','The 2009 Chardonnay La Carriere emerges from the glass with layers of mineral-infused fruit. There is a saline note woven throughout the fruit that adds considerable freshness, verve and cut. White flowers, lemon and spices frame the long finish. I very much like the energy here. Anticipated maturity: 2014-2021. - Robert Parker (2/2012)',13,'Michael.html','Michael.html','5'),(26,'2009 Kistler - Sonoma Coast Stone Flat Vineyard Chardonnay',12,'USA','White','Bright gold. Exotic, intensely perfumed aromas of poached pear, anise and chamomile, with a salty topnote. Mineral-accented orchard and citrus fruit flavors show impressive depth and precision, with vibrant ginger and floral qualities and a note of iodine adding to the impression of energy. Finishes extremely long, stony and chewy, leaving intense mineral and spice notes behind.- Stephen Tanzer (05/2012)',13,'Kistler.html','Kistler1.html','5'),(27,'2012 Tensley - Noir Syrah',24,'USA','Red ','The 2012 Syrah Noir, from a parcel within Colson Canyon, bursts from the glass with gorgeous aromatics, rich, layered fruit and exceptional overall balance. The 2012 is resonant, dark and voluptuous from the very first taste. Cloves, lavender, spices and black fruit inform a seamless finish built on pure fruit. This is another drop-dead gorgeous Syrah from Joey Tensley.- Antonio Galloni ',14,'Tensley.html','Tensley.html','4'),(28,'2012 Aubert',24,'USA','White','No tasting note for this wine. Mark Aubert is one of the contenders for California?s finest practitioner of Burgundian-styled, yet classic, California Chardonnays. His offerings are all made like grand cru Burgundies with full malolactic, the use of French oak and lees stirring,',13,'Aubert.html','Aubert.html','5'),(29,'2017 Baldassari Family Wines - Sonoma Coast Chardonnay',32,'USA','White','Barrel fermented, this impressively balanced, expressive wine shows lovely flavors of pear compote, ginger snap, lemon meringue and vanilla. Smooth and creamy, it has a lushness to the texture that doesn\'t overwhelm, offering a bite of welcome acidity as it finishes.-VB',13,'Baldassari.html','Baldassari.html','5'),(30,'2003 Bond - Melbury',3,'USA','Red ',' Winemaker Bob Levy compares the 2003 to the 2006 because of the wet winter and spring and the summer?s heat spikes. A brilliant effort from sedimentary soil with rocks over compacted clay, it is a gorgeous wine offering raspberry, black currant, spring flower and blueberry characteristics along with a dense purple color, a full-bodied, multilayered mouthfeel and sweet tannin.',15,'Bond.html','Bond.html','4'),(31,'1999 Dom Perignon - Champagne ',12,'France','Champagne','The 1999 Dom Perignon is a little flabbier than the 2000. Smoke, toastiness, tar and ripe fruit emerge from the glass in a generous, expansive style. The 1999 offers more body than the 2000 but the aromas and flavors are less well-articulated',12,'Dompe.html','Dompe.html','3'),(32,'NV AR Lenoble - Champagne Grand Cru Blanc De Blancs Cuvee Aventures',6,'France','Champagne','made from a blend of 2006 and 2002 wines; L 11 318 04 06 05): Light yellow-gold. Powerful aromas of nectarine, poached pear and lemon curd, with suave vanilla, butter and floral accents. Deeply pitched orchard and pit fruit flavors are given spine by tangy acidity and pick up spiciness and chalky minerality with air. Powerful yet lithe and precise, finishing with excellent clarity, length and lingering vanilla and brioche notes.-JR',12,'Lenoble.html','Lenoble.html','3'),(33,'2009 Lenoble, Ar - Champagne Cuvee Gentilhomme ',6,'France','Champagne','Well-spiced and creamy, with a mouthwatering mix of baked pineapple, apple blossom, black cherry and mandarin orange peel. Fine and balanced, offering hints of candied ginger, graphite and coconut on the fresh finish. Drink now through 2028. 916 cases made.-AN',13,'Lenoble2.html','Lenoble2.html','3'),(34,'2006 Billecart Salmon - Champagne Brut Cuvee Nicolas Francois',6,'France','Champagne','Created in 1964 as a tribute to the house?s founder, the youngest release is the 2006 Millésime Brut Cuvée Nicolas François, a blend of 60% Pinot Noir from premier and grand crus from the Montagne de Reims and the Grande Vallée de la Marne and 40% Chardonnay from the Côte des Blancs.',13,'Billecart.html','Billecart.html','3'),(35,'2003 Krug - Champagne Brut',12,'France','Champagne','Krug is one of Champagne\'s most prestigious houses and its wines are among the most collectible and expensive in Champagne.',12,'Krug.html','Krug.html','3');
/*!40000 ALTER TABLE `productlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rcomment`
--

DROP TABLE IF EXISTS `rcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rcomment` (
  `rcno` int(11) NOT NULL,
  `rcuserno` int(11) NOT NULL,
  `rcreviewno` int(11) NOT NULL,
  `rccomment` varchar(45) DEFAULT NULL,
  `rcinsertdate` date DEFAULT NULL,
  PRIMARY KEY (`rcno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rcomment`
--

LOCK TABLES `rcomment` WRITE;
/*!40000 ALTER TABLE `rcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `rcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomment`
--

DROP TABLE IF EXISTS `recomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recomment` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `pseq` int(11) DEFAULT NULL,
  `userid` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `postno` int(11) DEFAULT NULL,
  PRIMARY KEY (`seq`),
  UNIQUE KEY `seq_UNIQUE` (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomment`
--

LOCK TABLES `recomment` WRITE;
/*!40000 ALTER TABLE `recomment` DISABLE KEYS */;
INSERT INTO `recomment` VALUES (38,21,NULL,'ddddd',24),(39,21,NULL,'ddd',24),(40,21,NULL,'ss',24),(41,22,NULL,'dd',25),(42,22,NULL,'dd',25),(43,22,NULL,'dd',25),(44,22,NULL,'ss',25);
/*!40000 ALTER TABLE `recomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reno` int(11) NOT NULL AUTO_INCREMENT,
  `reuserid` varchar(20) NOT NULL,
  `retitle` varchar(45) NOT NULL,
  `recontent` text NOT NULL,
  `rescore` int(11) NOT NULL,
  `reinsertdate` date NOT NULL,
  `reimage` longblob,
  `reviewcount` int(11) NOT NULL DEFAULT '0',
  `rq1` varchar(45) DEFAULT NULL,
  `rq2` varchar(45) DEFAULT NULL,
  `rq3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reno`),
  UNIQUE KEY `reno_UNIQUE` (`reno`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (23,'asd@naver.com','1234214','123123',3,'2020-12-04',NULL,28,'soso','soso','bad'),(24,'asd@naver.com','후기 제목 ','1313',5,'2020-12-04',NULL,2,'soso','bad','soso'),(25,'asd@naver.com','131313','13131313',3,'2020-12-04',NULL,1,'soso','soso','soso'),(26,'asd@naver.com','후기 제목 ','ygug',2,'2020-12-04',NULL,1,'good','soso','soso'),(27,'asd@naver.com','제목입니다,','내용입니다',4,'2020-12-04',NULL,1,'괜찮아요','괜찮아요','늦게왔어요'),(28,'ㄴㅇㄹ','하이혀나띵','우리의 악덕사장',3,'2020-12-05',NULL,4,NULL,NULL,NULL),(29,'asd@naver.com','1111','13131313131',5,'2020-12-05',NULL,1,'괜찮아요','매우만족해요','제 날짜에 왔어요');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviewlike`
--

DROP TABLE IF EXISTS `reviewlike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviewlike` (
  `rlno` int(11) NOT NULL AUTO_INCREMENT,
  `rluserno` int(11) DEFAULT NULL,
  `rlboardno` int(11) DEFAULT NULL,
  `likecheck` int(11) DEFAULT NULL,
  PRIMARY KEY (`rlno`),
  UNIQUE KEY `rlno_UNIQUE` (`rlno`)
) ENGINE=InnoDB AUTO_INCREMENT=1193 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviewlike`
--

LOCK TABLES `reviewlike` WRITE;
/*!40000 ALTER TABLE `reviewlike` DISABLE KEYS */;
INSERT INTO `reviewlike` VALUES (1191,1,1,1),(1192,4,23,1);
/*!40000 ALTER TABLE `reviewlike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simplecon`
--

DROP TABLE IF EXISTS `simplecon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `simplecon` (
  `scno` int(11) NOT NULL AUTO_INCREMENT,
  `sctype` varchar(45) DEFAULT NULL,
  `scuserinfo` varchar(45) DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `sviewcount` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`scno`),
  UNIQUE KEY `scno_UNIQUE` (`scno`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simplecon`
--

LOCK TABLES `simplecon` WRITE;
/*!40000 ALTER TABLE `simplecon` DISABLE KEYS */;
INSERT INTO `simplecon` VALUES (1,'dd','dd','2020-12-04',3),(2,'kakao','ddd','2020-12-04',1),(3,'tel','1111','2020-12-04',1),(4,'tel','','2020-12-04',1),(5,'kakao','123123','2020-12-04',1),(6,'tel','123123','2020-12-04',1),(7,'kakao','','2020-12-04',1);
/*!40000 ALTER TABLE `simplecon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribe`
--

DROP TABLE IF EXISTS `subscribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscribe` (
  `ssubno` int(11) NOT NULL AUTO_INCREMENT,
  `speriod` varchar(45) NOT NULL,
  `sbottle` varchar(45) NOT NULL,
  `senddate` varchar(45) DEFAULT NULL,
  `sq1` varchar(5) DEFAULT NULL,
  `sq2` varchar(5) DEFAULT NULL,
  `sq3` varchar(5) DEFAULT NULL,
  `sq4` varchar(5) DEFAULT NULL,
  `sq5` varchar(5) DEFAULT NULL,
  `sq6` varchar(45) DEFAULT NULL,
  `sq7` varchar(45) DEFAULT NULL,
  `suserno` int(11) DEFAULT NULL,
  `sinsertdate` timestamp(1) NULL DEFAULT NULL,
  `sviewcount` int(11) DEFAULT NULL,
  `startdate` varchar(45) DEFAULT NULL,
  `enddate` varchar(45) DEFAULT NULL,
  `sprice` varchar(45) DEFAULT NULL,
  `sitem` varchar(45) DEFAULT NULL,
  `psitem` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ssubno`),
  UNIQUE KEY `ssubno_UNIQUE` (`ssubno`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribe`
--

LOCK TABLES `subscribe` WRITE;
/*!40000 ALTER TABLE `subscribe` DISABLE KEYS */;
INSERT INTO `subscribe` VALUES (97,'6개월','1병','매달5일','1','1','1','1','1','1','1',18,'2020-12-07 16:37:53.0',NULL,'2020년12월8일','2021년6월8일','120,000원','1','0'),(98,'6개월','1병','매달5일','1','1','1','1','1','1','1',18,'2020-12-07 17:21:39.0',NULL,'2020년12월8일','2021년6월8일','120,000원','1','0'),(99,'6개월','1병','매달5일','1','1','1','1','1','1','1',18,'2020-12-07 17:30:57.0',NULL,'2020년12월8일','2021년6월8일','120,000원','1','0'),(100,'6개월','1병','매달5일','1','1','1','1','1','1','1',21,'2020-12-08 03:02:23.0',NULL,'2020년12월8일','2021년6월8일','120,000원','1','0');
/*!40000 ALTER TABLE `subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `userno` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `userid` varchar(45) NOT NULL,
  `userpw` varchar(45) DEFAULT NULL,
  `usertel` varchar(45) DEFAULT NULL,
  `useraddress1` varchar(45) DEFAULT NULL,
  `useraddress2` varchar(45) DEFAULT NULL,
  `useraddress3` varchar(45) DEFAULT NULL,
  `usergender` varchar(10) DEFAULT NULL,
  `userjoindate` date DEFAULT NULL,
  `userbday` date DEFAULT NULL,
  `admincomment` text,
  `uviewcount` int(11) NOT NULL DEFAULT '0',
  `usersubscribe` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userno`),
  UNIQUE KEY `userno_UNIQUE` (`userno`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  UNIQUE KEY `usertel_UNIQUE` (`usertel`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'admin','admin','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(4,'혀나띵','asd@naver.com','1234','010-2262-3768','03145','서울 종로구 인사동길 55','ddddd','혀나는 혀나','2020-12-02','2020-11-11','sdsdfㅇㄴㄴㅇㄹ',4,1),(8,'효나띵','ad@naver.com','123',NULL,NULL,NULL,NULL,NULL,'2020-12-05',NULL,NULL,1,1),(15,'dfg','dsf','123',NULL,NULL,NULL,NULL,NULL,'2020-12-05',NULL,NULL,1,1),(16,'1234','test09@naver.com','1234','010-5545-2222','06302','서울 강남구 양재천로 163','dd','여자','2020-12-07','1991-01-01',NULL,1,1),(17,'asd','mg6613@naver.com','1234','010-8673-0811','06237','서울 강남구 테헤란로20길 25','갤러리원','남자','2020-12-07','1995-03-01',NULL,0,1),(18,'1234','t@naver.com','1234','010-4444-2222','07505','서울 강서구 대장로 39','123','여자','2020-12-07','1991-01-01',NULL,0,1),(19,'1234','y@naver.com','1234','010-8888-9999','08722','서울 관악구 당곡길 5','66','여자','2020-12-08','1994-01-01',NULL,0,0),(20,'1234','2@naver.com','1234','010-5555-2222','06027','서울 강남구 압구정로 102','11','여자','2020-12-08','1991-01-01',NULL,0,0),(21,'111','n@naver.com','1234','010-2222-2222','06027','서울 강남구 압구정로 102','111','남자','2020-12-08','1991-01-01',NULL,0,1);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 21:38:32
