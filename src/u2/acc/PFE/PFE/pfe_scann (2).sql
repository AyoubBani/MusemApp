-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 09 Mai 2016 à 22:48
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pfe_scann`
--

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

CREATE TABLE `artiste` (
  `artiste_id` int(20) NOT NULL,
  `artiste_name` varchar(30) DEFAULT NULL,
  `artiste_description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `artiste`
--

INSERT INTO `artiste` (`artiste_id`, `artiste_name`, `artiste_description`) VALUES
(2, 'Nicolas Poussin ', '(1594-1665) peintre'),
(3, 'Jacques Linard', ' (1597-1645) peintre'),
(4, 'Louis Le Nain ', '(après 1600-?) peintre'),
(5, 'Antoine Le Nain', ' (avant 1600-?) peintre'),
(6, 'Claude Lorrain ', '(1600-1682) peintre'),
(7, 'Jean Nicolle ', '(1610-vers 1650) peintre'),
(8, 'Andre Le Notre ', '(1613-1700) architecte paysagiste'),
(9, 'Claude Lefebvre', ' (1637-1675), peintre et graveur '),
(10, 'Georges de La Tour ', '(1593-1652) peintre '),
(11, 'Simon Vouet', '(1590-1649) peintre ;');

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE `media` (
  `media_ID` int(20) NOT NULL,
  `imgUrl` varchar(300) DEFAULT NULL,
  `videoUrl` varchar(100) NOT NULL,
  `mp3Url` varchar(100) NOT NULL,
  `mapUrl` varchar(100) NOT NULL,
  `oeuvre_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `media`
--

INSERT INTO `media` (`media_ID`, `imgUrl`, `videoUrl`, `mp3Url`, `mapUrl`, `oeuvre_id`) VALUES
(1, 'http://www.art-fortiori.fr/wpimages/wp1fbd60fb_06.png', 'UjKlKzyQRgY', 'http://www.mfiles.co.uk/mp3-downloads/frederic-chopin-piano-sonata-2-op35-3-funeral-march.mp3', 'http://www.destination360.com/europe/france/paris/images/musee-d-orsay-floorplan-map.jpg', 1),
(2, 'http://s31.postimg.org/se2hqlqt7/image.png', '8aNYMeXQa3o', 'http://www.mfiles.co.uk/mp3-downloads/edvard-grieg-peer-gynt1-morning-mood.mp3', 'http://www.vacationinparis.com/upload/home_page/1396467248103_paris.gif', 2),
(3, 'http://arasinisgluaire.ie/main/wp-content/uploads/2013/06/art-WORKSHOP.png', '', '', '', 3),
(4, 'http://s31.postimg.org/szo5k0mbf/image.png', '', '', '', 4),
(5, 'http://i626.photobucket.com/albums/tt345/LoVeLySwEeTyMe/misc/Art-Supplies.png', '', '', '', 5),
(6, 'http://s24.postimg.org/5jf7lubrp/cor.png', '', '', '', 6),
(7, 'http://www.art-fortiori.fr/wpimages/wp404a6c3e_06.png', '', '', '', 7),
(8, 'http://static.casatv.ca/sites/all/files/stephanie-rivet.png', 'UjKlKzyQRgY', 'http://www.mfiles.co.uk/mp3-downloads/frederic-chopin-piano-sonata-2-op35-3-funeral-march.mp3', 'http://www.destination360.com/europe/france/paris/images/musee-d-orsay-floorplan-map.jpg', 8);

-- --------------------------------------------------------

--
-- Structure de la table `musee`
--

CREATE TABLE `musee` (
  `musee_id` int(20) NOT NULL,
  `musee_name` varchar(20) DEFAULT NULL,
  `musee_description_` varchar(500) DEFAULT NULL,
  `emplacement_musee` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `musee`
--

INSERT INTO `musee` (`musee_id`, `musee_name`, `musee_description_`, `emplacement_musee`) VALUES
(1, 'musee du louvre', 'Le musée du Louvre est un musée d''art et d''antiquités situé au centre de Paris dans le palais du Louvre. C''est l''un des plus grands musées du monde, et le plus grand de Paris, par sa surface d''exposition de 60 600 m27, et ses collections qui comprennent près de 460 000 œuvres', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `oeuvre_id` int(20) NOT NULL,
  `code_qr` varchar(100) DEFAULT NULL,
  `oeuvre_name` varchar(20) DEFAULT NULL,
  `oeuvre_description` varchar(500) DEFAULT NULL,
  `emplacement` longblob,
  `musee_id` int(20) DEFAULT NULL,
  `type_id` int(20) DEFAULT NULL,
  `artiste_id` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `oeuvre`
--

INSERT INTO `oeuvre` (`oeuvre_id`, `code_qr`, `oeuvre_name`, `oeuvre_description`, `emplacement`, `musee_id`, `type_id`, `artiste_id`) VALUES
(1, 'code1', 'Ginevra de Benci', 'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhtttttttttttttttttttttttttttttttttttttttttt', NULL, 1, 1, 2),
(2, 'code2', 'La Joconde ', 'bvhhdgdterzyyzggttsrsfhjj', NULL, 1, 1, 3),
(3, 'code3', 'corbeau metal', 'jhhhhhhhhhhhhhjvjhkkkkkkkkkk', NULL, 1, 2, 4),
(4, 'code4', 'Beaute de la nature', 'jhgkgjhjjh', NULL, 1, 1, 5),
(5, 'code5', ' Femmes a l ombrell', 'jfkdqqqqqqqqqqqqqqqqqqqq', NULL, 1, 1, 8),
(6, 'code6', 'Nuit Etoilee', NULL, NULL, 1, 1, 6),
(7, 'code7', ' espoir', 'jkkkkkkkkkkkkkkkk', NULL, 1, 1, 5),
(8, 'code8', 'tableau artistique', 'llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll', NULL, 1, 1, 9);

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_type`
--

CREATE TABLE `oeuvre_type` (
  `type_id` int(20) NOT NULL,
  `type_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `oeuvre_type`
--

INSERT INTO `oeuvre_type` (`type_id`, `type_name`) VALUES
(1, 'peinture'),
(2, 'sculpture ');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `artiste`
--
ALTER TABLE `artiste`
  ADD PRIMARY KEY (`artiste_id`);

--
-- Index pour la table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`media_ID`),
  ADD KEY `FK_media_oeuvre_id` (`oeuvre_id`);

--
-- Index pour la table `musee`
--
ALTER TABLE `musee`
  ADD PRIMARY KEY (`musee_id`);

--
-- Index pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD PRIMARY KEY (`oeuvre_id`),
  ADD KEY `FK_oeuvre_musee_id` (`musee_id`),
  ADD KEY `FK_oeuvre_type_id` (`type_id`),
  ADD KEY `FK_oeuvre_artiste_id` (`artiste_id`);

--
-- Index pour la table `oeuvre_type`
--
ALTER TABLE `oeuvre_type`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `artiste`
--
ALTER TABLE `artiste`
  MODIFY `artiste_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
  MODIFY `media_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `musee`
--
ALTER TABLE `musee`
  MODIFY `musee_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `oeuvre_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `oeuvre_type`
--
ALTER TABLE `oeuvre_type`
  MODIFY `type_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `media`
--
ALTER TABLE `media`
  ADD CONSTRAINT `FK_media_oeuvre_id` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`oeuvre_id`);

--
-- Contraintes pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `FK_oeuvre_artiste_id` FOREIGN KEY (`artiste_id`) REFERENCES `artiste` (`artiste_id`),
  ADD CONSTRAINT `FK_oeuvre_musee_id` FOREIGN KEY (`musee_id`) REFERENCES `musee` (`musee_id`),
  ADD CONSTRAINT `FK_oeuvre_type_id` FOREIGN KEY (`type_id`) REFERENCES `oeuvre_type` (`type_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
