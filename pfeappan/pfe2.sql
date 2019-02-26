-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2016 at 11:22 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pfe2`
--

-- --------------------------------------------------------

--
-- Table structure for table `artiste`
--

CREATE TABLE `artiste` (
  `artiste_id` int(20) NOT NULL,
  `artiste_name` varchar(30) DEFAULT NULL,
  `artiste_description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artiste`
--

INSERT INTO `artiste` (`artiste_id`, `artiste_name`, `artiste_description`) VALUES
(1, 'Nicolas Poussin', '\0(1594-1665) peintre'),
(2, 'Jacques Linard', '\0(1597-1645) peintre'),
(3, 'Louis Le Nain', '(après 1600-?) peintre'),
(4, 'Antoine Le Nain', '(avant 1600-?) peintre'),
(5, 'Claude Lorrain', '\0(1600-1682) peintre'),
(6, 'Jean Nicolle', '(1610-vers 1650) peintre'),
(7, 'Andre Le Notre', '\0(1613-1700) architecte paysagiste'),
(8, 'Claude Lefebvre', '\0(1637-1675), peintre et graveur'),
(9, 'Georges de La Tour', '\0(1593-1652) peintre'),
(10, 'Simon Vouet', '\0(1590-1649) peintre'),
(12, 'Edgar Degas', 'est un artiste peintre, graveur, sculpteur et photographe.'),
(13, 'Ahmed ', 'Artiste Marocain'),
(14, 'mounir', '\0tres connu '),
(15, 'Said mansouri', 'un artiste marocaine'),
(16, 'Amine saaidi', '\0tres connu au maroc'),
(17, 'kamal', '\0kamal nouveau artiste'),
(18, 'Samir', 'Artiste Marocain'),
(19, 'Sabir', 'Artiste Marocain');

-- --------------------------------------------------------

--
-- Table structure for table `cree`
--

CREATE TABLE `cree` (
  `oeuvre_id` int(20) NOT NULL,
  `artiste_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cree`
--

INSERT INTO `cree` (`oeuvre_id`, `artiste_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
  `media_ID` int(20) NOT NULL,
  `media_type` varchar(100) DEFAULT NULL,
  `url` varchar(500) NOT NULL,
  `oeuvre_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `media`
--

INSERT INTO `media` (`media_ID`, `media_type`, `url`, `oeuvre_id`) VALUES
(1, 'youtube', '8aNYMeXQa3o', 1),
(2, 'image', 'http://www.love-london-museums.com/images/egyptian-sculpture-british-museum.jpg', 1),
(3, 'mp3', 'http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3', 1),
(4, 'map', 'https://springfieldmuseums.org/wp-content/uploads/2015/09/dr-seuss-sculpture-garden-map.png', 1),
(5, 'image', 'http://s31.postimg.org/se2hqlqt7/image.png', 2),
(6, 'map', 'https://springfieldmuseums.org/wp-content/uploads/2015/09/dr-seuss-sculpture-garden-map.png', 2),
(7, 'mp3', 'http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3', 2),
(8, 'mp3', 'http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3', 3),
(9, 'youtube', '8aNYMeXQa3o', 2),
(10, 'youtube', '8aNYMeXQa3o', 3),
(11, 'map', 'https://springfieldmuseums.org/wp-content/uploads/2015/09/dr-seuss-sculpture-garden-map.png', 3),
(12, 'image', 'http://arasinisgluaire.ie/main/wp-content/uploads/2013/06/art-WORKSHOP.png', 3),
(13, 'image', 'http://s31.postimg.org/szo5k0mbf/image.png', 4),
(14, 'image', 'http://i626.photobucket.com/albums/tt345/LoVeLySwEeTyMe/misc/Art-Supplies.png', 5),
(15, 'map', 'https://springfieldmuseums.org/wp-content/uploads/2015/09/dr-seuss-sculpture-garden-map.png', 4),
(16, 'map', 'https://springfieldmuseums.org/wp-content/uploads/2015/09/dr-seuss-sculpture-garden-map.png', 5),
(17, 'mp3', 'http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3', 4),
(18, 'mp3', 'http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3', 5),
(19, 'youtube', '8aNYMeXQa3o', 4),
(20, 'youtube', '8aNYMeXQa3o', 5),
(21, 'image', 'http://static.casatv.ca/sites/all/files/stephanie-rivet.png', 6),
(22, 'mp3', 'http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3', 6),
(23, 'youtube', 'UjKlKzyQRgY', 6),
(24, 'map', 'https://springfieldmuseums.org/wp-content/uploads/2015/09/dr-seuss-sculpture-garden-map.png', 6),
(26, 'youtube', 'yVhSjdDYjgA', 5),
(28, 'youtube', 'yVhSjdDYjgA', 29);

-- --------------------------------------------------------

--
-- Table structure for table `musee`
--

CREATE TABLE `musee` (
  `musee_id` int(20) NOT NULL,
  `musee_name` varchar(20) DEFAULT NULL,
  `musee_adress` varchar(50) DEFAULT NULL,
  `musee_description_` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `musee`
--

INSERT INTO `musee` (`musee_id`, `musee_name`, `musee_adress`, `musee_description_`) VALUES
(1, 'museDupant', '16e Arrondissement, Paris, France', 'Musée du Louvre, 75001 Paris, France');

-- --------------------------------------------------------

--
-- Table structure for table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `oeuvre_id` int(20) NOT NULL,
  `code_qr` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `oeuvre_name` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `oeuvre_description` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `emplacement` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `musee_id` int(20) DEFAULT '1',
  `type_id` int(20) DEFAULT NULL,
  `artiste_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_520_ci;

--
-- Dumping data for table `oeuvre`
--

INSERT INTO `oeuvre` (`oeuvre_id`, `code_qr`, `oeuvre_name`, `oeuvre_description`, `emplacement`, `musee_id`, `type_id`, `artiste_id`) VALUES
(1, 'code001', 'Venus de Milo', 'sculpture grecque de la fin de l''époque hellénistique (vers 130-100 av. J.-C.) qui pourrait représenter la déesse Aphrodite (Vénus dans la mythologie romaine). ', 'a cote de', 1, 1, 1),
(2, 'code2', 'La Joconde', 'La Joconde, ou Portrait de Mona Lisa, est un tableau de l''artiste italien Léonard de Vinci, réalisé entre 1503 et 1506', 'a cote de', 1, 1, 2),
(3, 'code3', 'corbeau metal', 'Le corbeau est un élément saillant d''un mur, en architecture. En structure intérieure.', 'a cote de', 1, 2, 3),
(4, 'code4', 'Beaute de la nature', 'La nature est la reine de cette Terre et elle doit le rester le plus longtemps possible pour notre plus grand bonheur.', 'a cote de', 1, 1, 4),
(5, 'code5', 'Femmes à l''ombrelle', 'Femme à l''ombrelle tournée vers la gauche est un tableau du peintre français Claude Monet réalisée en 1886.', 'a cote de', 1, 1, 8),
(6, 'code6', 'tableau artistique', 'Un tableau est, dans le domaine des beaux-arts, un support de surface plane, constitué en différents matériaux', 'a cote de', 1, 1, 9),
(9, 'code 129', 'ouvre sample 2', 'ouvre v wjqj', 'ajd asjj', 1, 2, 2),
(10, 'code final', 'ouvre final', 'ouvre bla bla', 'bla vld', 1, 2, 2),
(13, 'codenv', 'oaskdsa ', 'dakoas', 'sdakoa', 1, 1, 2),
(27, 'ouvre test', 'ouvretets', 'ouvre de test', 'emp...', 1, 2, 17),
(29, 'codeqr111', 'ouvre111', 'ouvre de sabir', 'emp...', 1, 2, 19);

-- --------------------------------------------------------

--
-- Table structure for table `oeuvre_type`
--

CREATE TABLE `oeuvre_type` (
  `type_id` int(20) NOT NULL,
  `type_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oeuvre_type`
--

INSERT INTO `oeuvre_type` (`type_id`, `type_name`) VALUES
(1, 'peinture'),
(2, 'sculpture');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artiste`
--
ALTER TABLE `artiste`
  ADD PRIMARY KEY (`artiste_id`);

--
-- Indexes for table `cree`
--
ALTER TABLE `cree`
  ADD PRIMARY KEY (`oeuvre_id`,`artiste_id`),
  ADD KEY `FK_créer__artiste_id` (`artiste_id`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`media_ID`),
  ADD KEY `FK_media_œuvre_id` (`oeuvre_id`);

--
-- Indexes for table `musee`
--
ALTER TABLE `musee`
  ADD PRIMARY KEY (`musee_id`);

--
-- Indexes for table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD PRIMARY KEY (`oeuvre_id`),
  ADD KEY `FK_œuvre_musee_id` (`musee_id`),
  ADD KEY `FK_œuvre_type_id` (`type_id`),
  ADD KEY `fk_artiste` (`artiste_id`);

--
-- Indexes for table `oeuvre_type`
--
ALTER TABLE `oeuvre_type`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artiste`
--
ALTER TABLE `artiste`
  MODIFY `artiste_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `cree`
--
ALTER TABLE `cree`
  MODIFY `oeuvre_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `media_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `musee`
--
ALTER TABLE `musee`
  MODIFY `musee_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `oeuvre_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `oeuvre_type`
--
ALTER TABLE `oeuvre_type`
  MODIFY `type_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `cree`
--
ALTER TABLE `cree`
  ADD CONSTRAINT `FK_créer__artiste_id` FOREIGN KEY (`artiste_id`) REFERENCES `artiste` (`artiste_id`),
  ADD CONSTRAINT `FK_créer__œuvre_id` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`oeuvre_id`);

--
-- Constraints for table `media`
--
ALTER TABLE `media`
  ADD CONSTRAINT `FK_media_œuvre_id` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`oeuvre_id`);

--
-- Constraints for table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `FK_œuvre_musee_id` FOREIGN KEY (`musee_id`) REFERENCES `musee` (`musee_id`),
  ADD CONSTRAINT `FK_œuvre_type_id` FOREIGN KEY (`type_id`) REFERENCES `oeuvre_type` (`type_id`),
  ADD CONSTRAINT `fk_artiste` FOREIGN KEY (`artiste_id`) REFERENCES `artiste` (`artiste_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
