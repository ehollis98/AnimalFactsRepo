-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: AnimalFacts
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `animal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'Shrimp'),(2,'Snail'),(3,'Koala'),(4,'Slugs'),(5,'Elephants'),(6,'Rhino'),(7,'Frog'),(8,'Sloth'),(9,'Penguin'),(10,'Cow'),(11,'Bat'),(12,'Giraffe'),(13,'Kangaroo'),(14,'Ostrich'),(15,'Orangutans'),(16,'Gorilla'),(17,'Deer'),(18,'Lion'),(19,'Dog'),(20,'Turtle'),(21,'Pig'),(22,'Spider'),(23,'Snake'),(24,'Moose'),(25,'Bird'),(26,'Lemurs'),(27,'Ants'),(28,'Fish'),(29,'Fox'),(30,'Alligator'),(31,'Turkey'),(32,'Fly'),(33,'Wolf'),(34,'Scorpion'),(35,'Flamingo'),(36,'Animal'),(37,'Owl'),(38,'Anteater'),(39,'Whale');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facts`
--

DROP TABLE IF EXISTS `facts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fact` varchar(255) DEFAULT NULL,
  `animalId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `animalId` (`animalId`),
  CONSTRAINT `facts_ibfk_1` FOREIGN KEY (`animalId`) REFERENCES `animal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facts`
--

LOCK TABLES `facts` WRITE;
/*!40000 ALTER TABLE `facts` DISABLE KEYS */;
INSERT INTO `facts` VALUES (1,'The heart of a shrimp is located in its head!',1),(2,'A snail can sleep for three years!',2),(3,'The fingerprints of a koala are so indistinguishable from humans that they have on occasion been confused at a crime scene!',3),(4,'Slugs have four noses!',4),(5,'Elephants are the only animal that can not jump!',5),(6,'A rhinoceros\' horn is made of hair!',6),(7,'It is possible to hypnotize a frog by placing it on its back and gently stroking its stomach!',7),(8,'It takes a sloth two weeks to digest its food!',8),(9,'Nearly threee percent of the ice in Antarctic glaciers is penguin urine!',9),(10,'A cow gives nearly 200,000 glasses of milk in a lifetime!',10),(11,'Bats always turn left when leaving a cave!',11),(12,'Giraffes have no vocal chords!',12),(13,'Kangaroos can\'t fart!',13),(14,'An ostrich\'s eye is bigger than its brain!',14),(15,'Around 50 percent of orangutans have fractured bones, due to falling out of trees on a regular basis!',15),(16,'Frogs cannot vomit. If one absolutely has to, then it will vomit its entire stomach!',7),(17,'gorillas can cath human colds and other illnesses!',16),(18,'A newborn Chinese water deer is so small it can almost be help in the palm of a hand!',17),(19,'Ostriches can run faster than horses, and the males can roar like a lion!',14),(20,'A lion in the wild usually makes no more than twent kills a year!',18),(21,'The female lion does ninety percent of the hunting!',18),(22,'The world\'s smallest dog was a Yorkshire Terrier, which weighed just four ounces!',19),(23,'Turtles, water snakes, crocodiles, alligators, dolphins, whales, and other water going creatures will drown if kept underwater too long!',20),(24,'Almost half the pigs in the world are kept by farmer\'s in China!',21),(25,'On average, dogs have better eyesight than humans, although not as colorful!',19),(26,'Deer have no gall bladders!',17),(27,'There is an average of 50,000 spiders per acre in green areas!',22),(28,'Snakes are carnivores, which mean they only eat animals, often small ones such as insects, birds, frogs, and other small mammals!',23),(29,'In Alaska it is illegal to whisper in someone\'s ear while they are moose hunting!',24),(30,'The bat is the only mammal that can fly!',11),(31,'The leg bones of a bat are so thin that out of the 1,200 species of bats, only two can walk on the ground. These are the Vampire bat and the Burrowing bat!',11),(32,'Some male songbirds sing more than 2,000 tinmes each day!',25),(33,'The only mammals to undergo menopause are elephants, humpback whales and human females!',5),(34,'Blue-eyed lemurs are one of two (non-human) primates to have truly blue eyes!',26),(35,'A tarantula spider can survive for more than two years without food!',22),(36,'For every human in the world there are one million ants!',27),(37,'If you lift a kangaroo\'s tail off the ground it can\'t hop. They use their tails for balance!',13),(39,'If you keep a goldfish in a dark room, it will become pale!',28),(40,'Cows can sleep standing up, but they can only dream lying down!',10),(41,'The sentence \'The quick brown fox jumps over a lazy dog\' uses every letter of the alphabet!',29),(42,'The average fox weighs fourteen pounds!',29),(43,'The scientific name of the red fox is Vulpes vulpes!',29),(44,'Alligators can live up to 100 years!',30),(45,'A single elephant tooth can weigh as much a nine pounds!',5),(46,'the turkey is one of the most famous birds in North America!',31),(47,'A housefly hums in the key of F!',32),(48,'During World War II , Americans tried to train bats to drop bombs!',11),(49,'Canis lupis lupus is the scientific name for a grey wolf!',33),(50,'To escape the grip of a crocodile\'s jaw, push you thumb into its eyeballs, it will instantly let you go!',30),(51,'It is much easier for dogs to learn spoken commands if they are given in conjunction with hand signal or gestures!',19),(52,'Even a small amount of alcohol placed on a scorpion will make it go crazy and sting itself to death!',34),(53,'Male deer are called \'bucks,\' females are called \'does!\'',17),(54,'The flamingo can only eat when its head is upside down!',35),(55,'Animals generate 30 times more waste than humans which is 1.4 billion tons every year!',36),(56,'Ants never sleep, nor do they have lungs!',27),(57,'A group of owls is called a parliament!',37),(58,'Just one cow gives off enough harmful methane gas in a single day to fill around 400 liter bottles!',10),(59,'Apple and pear seeds contain arsenic, which may be deadly to dogs!',19),(60,'Cows have one large stomach that is divided into four compartments to go through the different stages of digestion!',10),(61,'An anteater is nearly 6 feet long, yet its mouth is only a inch wide!',38),(62,'The blue whale weighs as much as thirty elephants and is as long as three Greyhound buses!',39);
/*!40000 ALTER TABLE `facts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-07 16:02:56
