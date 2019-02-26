-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 20 Juin 2016 à 18:16
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pfe3`
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
(11, 'Simon Vouet', '(1590-1649) peintre ;'),
(16, 'Louis Ritman', 'American Oil Painting Signed'),
(18, '	 Francisco de Goya', 'Date	 1800 Technique	 Huile sur toile');

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE `media` (
  `media_ID` int(20) NOT NULL,
  `media_type` varchar(100) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `oeuvre_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `media`
--

INSERT INTO `media` (`media_ID`, `media_type`, `url`, `oeuvre_id`) VALUES
(1, 'image', 'http://s28.postimg.org/9t0feafvh/ima4.jpg', 1),
(2, 'image', 'http://www.parischerie.com/wp-content/uploads/2014/06/1-Louvre-Museum-Paris-Mona-Lisa-La-Joconde-%E6%B3%95%E8%AF%AD-468x705.jpg', 2),
(3, 'image', 'http://i2.cdscdn.com/pdt2/6/5/4/1/300x300/bon3760226841654/rw/tableau-deco-porte-marocaine.jpg', 3),
(4, 'image', 'http://s31.postimg.org/szo5k0mbf/image.png', 4),
(5, 'image', 'http://s16.postimg.org/tunjw0h6t/ima9.jpg', 5),
(6, 'image', 'http://s24.postimg.org/5jf7lubrp/cor.png', 6),
(7, 'image', 'http://www.demenagement-ravarino.com/images/demenagement-tableau-nice-objet-art-peinture-06.png', 7),
(8, 'image', 'http://static.casatv.ca/sites/all/files/stephanie-rivet.png', 8),
(9, 'image', 'http://images.huffingtonpost.com/2012-11-02-matissevolc3a9musc3a9ekunsthalrotterdampaysbas.png', 9),
(11, 'youtube', 'xARUfC-im_I', 1),
(12, 'map', 'http://www.vacationinparis.com/upload/home_page/1396467248103_paris.gif', 1),
(13, 'mp3', 'http://www.mfiles.co.uk/mp3-downloads/scott-joplin-peacherine-rag.mp3', 1),
(14, 'youtube', 'xARUfC-im_I', 2),
(15, 'mp3', 'http://www.mfiles.co.uk/mp3-downloads/i-vow-to-thee-my-country.mp3', 2),
(16, 'map', 'http://www.destination360.com/europe/france/paris/images/musee-d-orsay-floorplan-map.jpg', 2),
(17, 'mp3', 'http://www.mfiles.co.uk/mp3-downloads/oh-perfect-love.mp3', 3),
(18, 'mp3', 'http://www.mfiles.co.uk/mp3-downloads/leaning-on-the-everlasting-arms.mp3', 4);

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
  `oeuvre_description` longtext,
  `emplacement` longblob,
  `musee_id` int(20) DEFAULT NULL,
  `type_id` int(20) DEFAULT NULL,
  `artiste_id` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `oeuvre`
--

INSERT INTO `oeuvre` (`oeuvre_id`, `code_qr`, `oeuvre_name`, `oeuvre_description`, `emplacement`, `musee_id`, `type_id`, `artiste_id`) VALUES
(1, 'code 1', 'Ginevra de Benci', 'La peinture a été proposée comme tableau de Leonard par Waagen en 1866 et approuvé par Bode. Malgré certaines réticences au début du xxe siècle les critiques éminents acceptent l''attribution.', NULL, 1, 1, 2),
(2, 'code 2', 'La Joconde ', 'Attribution à Léonard,La Joconde est devenue un tableau éminemment célèbre car, depuis sa réalisation, nombre d''artistes l''ont prise comme référence. À l''époque romantique, les artistes ont été fascinés par ce tableau et ont contribué à développer le mythe qui l''entoure, en faisant de ce tableau l’une des œuvres d''art les plus célèbres du monde, ', NULL, 1, 1, 3),
(3, 'code 3', 'corbeau metal', 'jhhhhhhhhhhhhhjvjhkkkkkkkkkk', NULL, 1, 2, 4),
(4, 'code 4', 'Beaute de la nature', 'jhgkgjhjjh', NULL, 1, 1, 5),
(5, 'code 5', ' Femmes a l ombrell', 'jfkdqqqqqqqqqqqqqqqqqqqq', NULL, 1, 1, 8),
(6, 'code 6', 'Nuit Etoilee', NULL, NULL, 1, 1, 6),
(7, 'code 7', ' espoir', 'jkkkkkkkkkkkkkkkk', NULL, 1, 1, 5),
(8, 'code 8', 'tableau artistique', 'jhgjkhgjdfkgh', NULL, 1, 1, 9),
(9, 'code 9', 'Pommes et oranges', 'dfjsdfjdfjshdj', NULL, 1, 1, 11);

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
  MODIFY `artiste_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
  MODIFY `media_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
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
