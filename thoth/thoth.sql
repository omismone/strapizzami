-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thoth`
--
CREATE DATABASE IF NOT EXISTS `thoth` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `thoth`;

-- --------------------------------------------------------

--
-- Struttura della tabella `bevanda`
--

DROP TABLE IF EXISTS `bevanda`;
CREATE TABLE IF NOT EXISTS `bevanda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(15) NOT NULL,
  `QUANTITA` int(11) NOT NULL COMMENT 'cl',
  `FORMATO` enum('Lattina','Bottiglia','Vetro','Brick') DEFAULT NULL COMMENT 'fomato: lattina, vetro, bottiglia o brick',
  `PREZZO` decimal(10,2) NOT NULL COMMENT 'euro',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `bevanda`
--

TRUNCATE TABLE `bevanda`;
--
-- Dump dei dati per la tabella `bevanda`
--

INSERT INTO `bevanda` (`ID`, `NOME`, `QUANTITA`, `FORMATO`, `PREZZO`) VALUES
(2, 'coca-cola', 33, 'lattina', '2.00'),
(3, 'fanta', 33, 'lattina', '2.00'),
(4, 'sprite', 33, 'lattina', '2.00'),
(5, 'the', 33, 'lattina', '2.00'),
(6, 'birra', 33, 'vetro', '3.00'),
(7, 'birra', 50, 'vetro', '3.50'),
(8, 'birra', 66, 'vetro', '3.50'),
(9, 'vino bianco', 100, 'vetro', '5.00'),
(10, 'vino rosso', 100, 'vetro', '5.00'),
(11, 'acqua naturale', 50, 'bottiglia', '1.00'),
(12, 'acqua gassata', 50, 'bottiglia', '1.00'),
(13, 'coca-cola', 100, 'bottiglia', '3.00'),
(14, 'fanta', 100, 'bottiglia', '3.00'),
(15, 'sprite', 100, 'bottiglia', '3.00'),
(16, 'the', 100, 'bottiglia', '3.00');

-- --------------------------------------------------------

--
-- Struttura della tabella `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `NOME` varchar(30) NOT NULL,
  `DESCRIZIONE` varchar(40) DEFAULT NULL,
  `IMPORTANZA` int(11) DEFAULT NULL COMMENT 'less is more important',
  PRIMARY KEY (`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `classe`
--

TRUNCATE TABLE `classe`;
--
-- Dump dei dati per la tabella `classe`
--

INSERT INTO `classe` (`NOME`, `DESCRIZIONE`, `IMPORTANZA`) VALUES
('friggitoria', null, 100),
('la pizza della settimana', 'disponibile fino a questa domenica!', 10),
('le pizze gourmet', null, 40),
('le pizze scelte da voi', null, 50),
('le speciali', 'base bianca solo mozzarella', 30),
('le tradizionali', null, 20);

-- --------------------------------------------------------

--
-- Struttura della tabella `formato`
--

DROP TABLE IF EXISTS `formato`;
CREATE TABLE IF NOT EXISTS `formato` (
  `NOME` varchar(30) NOT NULL,
  PRIMARY KEY (`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `formato`
--

TRUNCATE TABLE `formato`;
--
-- Dump dei dati per la tabella `formato`
--

INSERT INTO `formato` (`NOME`) VALUES
('baby'),
('family'),
('normal');

-- --------------------------------------------------------

--
-- Struttura della tabella `gestore`
--

DROP TABLE IF EXISTS `gestore`;
CREATE TABLE IF NOT EXISTS `gestore` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Svuota la tabella prima dell'inserimento `gestore`
--

TRUNCATE TABLE `gestore`;
-- --------------------------------------------------------

--
-- Struttura della tabella `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
CREATE TABLE IF NOT EXISTS `ingrediente` (
  `NOME` varchar(60) NOT NULL,
  `SURGELATO` tinyint(1) DEFAULT NULL COMMENT 'null -> false',
  `PREZZO` decimal(10,2) UNSIGNED DEFAULT NULL COMMENT 'null -> not addable',
  PRIMARY KEY (`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `ingrediente`
--

TRUNCATE TABLE `ingrediente`;
--
-- Dump dei dati per la tabella `ingrediente`
--

INSERT INTO `ingrediente` (`NOME`, `SURGELATO`, `PREZZO`) VALUES
('acciughe', 0, '1.00'),
('bacon', 0, '0.00'),
('basilico', 0, '0.00'),
('bresaola', 0, '2.00'),
('bufala', 0, '3.00'),
('burratina', 0, '3.00'),
('capperi', 0, '1.00'),
('carciofi', 0, '1.00'),
('cinque pezzi', 0, null),
('cipolla', 0, '1.00'),
('cipolla caramellata', 0, '1.00'),
('cipolla di tropea', 0, '1.00'),
('cipolline', 0, null),
('composto di cipolla rossa', 0, '1.00'),
('crema di aceto', 0, '1.00'),
('crema di fichi', 0, '1.00'),
('crema di noci', 0, '1.00'),
('crema di pistacchi', 0, '1.00'),
('crema di porcini', 0, '1.00'),
('crema di radicchio', 0, '1.00'),
('crema di zucca', 0, '1.00'),
('crescenza', 0, '1.00'),
('crudo di parma', 0, '2.00'),
('fagioli rossi', 0, '1.00'),
('filetti di sgombro', 0, '2.00'),
('filetti di tonno', 0, '2.00'),
('focaccia', 0, null),
('friarielli', 0, '1.00'),
('funghi', 0, '1.00'),
('gamberetti', 1, '3.00'),
('glassa di aceto', 0, '1.00'),
('grana', 0, '1.00'),
('granchio', 0, '2.00'),
('granella di pistacchi', 0, '1.00'),
('jalapenos', 0, '1.00'),
('mais', 0, '1.00'),
('melanzane', 0, '1.00'),
('misto mare', 1, null),
('mortadella', 0, '1.00'),
('mozzarella', 0, '1.00'),
('nduja', 0, '2.00'),
('olive', 0, '1.00'),
('olive taggiasche', 0, '2.00'),
('origano', 0, '0.00'),
('pancetta', 0, '1.00'),
('panna', 0, '2.00'),
('patate', 0, '1.00'),
('patatine', 1, '1.00'),
('pepe macinato', 0, '0.00'),
('peperoncino', 0, '1.00'),
('peperoni', 0, '1.00'),
('pesto a gocce', 0, '1.00'),
('philadelphia', 0, '1.00'),
('polpa di zucca', 0, '2.00'),
('pomodori secchi', 0, '2.00'),
('pomodorini freschi', 0, '1.00'),
('pomodoro', 0, '1.00'),
('porchetta', 0, '2.00'),
('porcini', 0, '3.00'),
('prosciutto cotto', 0, '1.00'),
('provola affumicata', 0, '1.00'),
('radicchio', 0, '1.00'),
('rosmarino', 0, '0.00'),
('rucola', 0, '1.00'),
('salame piccante', 0, '1.00'),
('salmone', 0, '3.00'),
('salmone a crudo', 0, '3.00'),
('salsa rosa', 0, '1.00'),
('salsa verde', 0, '1.00'),
('salsiccia', 0, '2.00'),
('salsiccia punta di coltello', 0, '2.00'),
('scaglie di grana', 0, '1.00'),
('scamorza', 0, '1.00'),
('sei pezzi', 0, null),
('speck', 0, '1.00'),
('spinaci', 0, '1.00'),
('squaquerone', 0, '3.00'),
('stracciatella', 0, '3.00'),
('taleggio', 0, '1.00'),
('tonno', 0, '1.00'),
('uovo', 0, '1.00'),
('wurstel', 0, '1.00'),
('zola', 0, '1.00'),
('zucchine grigliate', 0, '1.00');

-- --------------------------------------------------------

--
-- Struttura della tabella `ip`
--

DROP TABLE IF EXISTS `ip`;
CREATE TABLE IF NOT EXISTS `ip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `INGREDIENTE` varchar(60) NOT NULL COMMENT 'foreign key -> Ingrediente',
  `PIETANZA` varchar(30) NOT NULL COMMENT 'foreign key -> Pietanza',
  PRIMARY KEY (`ID`),
  KEY `IPI` (`INGREDIENTE`),
  KEY `IPP` (`PIETANZA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `ip`
--

TRUNCATE TABLE `ip`;
--
-- Dump dei dati per la tabella `ip`
--

INSERT INTO `ip` (`ID`, `INGREDIENTE`, `PIETANZA`) VALUES
(1, 'cinque pezzi', 'chele di granchio'),
(2, 'sei pezzi', 'olive all ascolana'),
(3, 'cinque pezzi', 'triangoli speck e patate'),
(4, 'cinque pezzi', 'red hot jalapenos');

-- --------------------------------------------------------

--
-- Struttura della tabella `pf`
--

DROP TABLE IF EXISTS `pf`;
CREATE TABLE IF NOT EXISTS `pf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PREZZO` decimal(10,2) DEFAULT NULL,
  `PIZZA` varchar(30) NOT NULL COMMENT 'foreign key -> Pizza',
  `FORMATO` varchar(30) NOT NULL COMMENT 'foreign key -> Formato',
  PRIMARY KEY (`ID`),
  KEY `PFP` (`PIZZA`),
  KEY `PFF` (`FORMATO`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `pf`
--

TRUNCATE TABLE `pf`;
--
-- Dump dei dati per la tabella `pf`
--

INSERT INTO `pf` (`ID`, `PREZZO`, `PIZZA`, `FORMATO`) VALUES
(1, '3.00', 'margherita', 'baby'),
(2, '5.00', 'margherita', 'normal'),
(3, '10.00', 'margherita', 'family'),
(4, '4.00', 'napoli', 'baby'),
(5, '6.00', 'napoli', 'normal'),
(6, '11.00', 'napoli', 'family'),
(7, '4.00', 'diavola', 'baby'),
(8, '6.00', 'diavola', 'normal'),
(9, '11.00', 'diavola', 'family'),
(10, '4.00', 'prosciutto', 'baby'),
(11, '6.00', 'prosciutto', 'normal'),
(12, '11.00', 'prosciutto', 'family'),
(13, '4.00', 'wurstel', 'baby'),
(14, '6.00', 'wurstel', 'normal'),
(15, '11.00', 'wurstel', 'family'),
(16, '5.00', 'patate e wurstel', 'baby'),
(17, '7.00', 'patate e wurstel', 'normal'),
(18, '12.00', 'patate e wurstel', 'family'),
(19, '5.00', 'peperonata', 'baby'),
(20, '7.00', 'peperonata', 'normal'),
(21, '12.00', 'peperonata', 'family'),
(22, '7.00', 'prosciutto e zola', 'baby'),
(23, '5.00', 'prosciutto e zola', 'normal'),
(24, '12.00', 'prosciutto e zola', 'family'),
(25, '5.00', 'tonno e cipolla', 'baby'),
(26, '7.00', 'tonno e cipolla', 'normal'),
(27, '12.00', 'tonno e cipolla', 'family'),
(28, '6.00', '4 formaggi', 'baby'),
(29, '8.00', '4 formaggi', 'normal'),
(30, '13.00', '4 formaggi', 'family'),
(31, '7.00', 'calzone', 'normal'),
(32, '5.50', 'pugliese', 'baby'),
(33, '7.50', 'pugliese', 'normal'),
(34, '12.50', 'pugliese', 'family'),
(35, '5.50', 'siciliana', 'baby'),
(36, '7.50', 'siciliana', 'normal'),
(37, '12.50', 'siciliana', 'family'),
(38, '6.50', 'bufala', 'baby'),
(39, '8.50', 'bufala', 'normal'),
(40, '13.50', 'bufala', 'family'),
(41, '6.00', 'panna e speck', 'baby'),
(42, '8.00', 'panna e speck', 'normal'),
(43, '13.00', 'panna e speck', 'family'),
(44, '6.00', '4 stagioni', 'baby'),
(45, '8.00', '4 stagioni', 'normal'),
(46, '13.00', '4 stagioni', 'family'),
(47, '6.00', 'bismarck', 'baby'),
(48, '8.00', 'bismarck', 'normal'),
(49, '13.00', 'bismarck', 'family'),
(50, '8.50', 'calzone farcito', 'normal'),
(51, '6.50', 'capricciosa', 'baby'),
(52, '8.50', 'capricciosa', 'normal'),
(53, '13.50', 'capricciosa', 'family'),
(54, '6.50', 'crudo', 'baby'),
(55, '8.50', 'crudo', 'normal'),
(56, '13.50', 'crudo', 'family'),
(57, '6.50', 'parmigiana', 'baby'),
(58, '8.50', 'parmigiana', 'normal'),
(59, '13.50', 'parmigiana', 'family'),
(60, '6.00', 'salsiccia e friarielli', 'baby'),
(61, '8.00', 'salsiccia e friarielli', 'normal'),
(62, '13.00', 'salsiccia e friarielli', 'family'),
(63, '6.50', 'vegetariana', 'baby'),
(64, '8.50', 'vegetariana', 'normal'),
(65, '13.50', 'vegetariana', 'family'),
(66, '7.00', 'alto adige', 'baby'),
(67, '9.00', 'alto adige', 'normal'),
(68, '14.00', 'alto adige', 'family'),
(69, '7.50', 'atomica', 'baby'),
(70, '9.50', 'atomica', 'normal'),
(71, '14.50', 'atomica', 'family'),
(72, '7.50', 'bresaola', 'baby'),
(73, '9.50', 'bresaola', 'normal'),
(74, '14.50', 'bresaola', 'family'),
(75, '8.50', 'salmonata', 'baby'),
(76, '10.50', 'salmonata', 'normal'),
(77, '15.50', 'salmonata', 'family'),
(78, '8.00', 'frutti di mare', 'baby'),
(79, '10.00', 'frutti di mare', 'normal'),
(80, '15.00', 'frutti di mare', 'family'),
(81, '9.00', 'ghiottosa', 'baby'),
(82, '11.00', 'ghiottosa', 'normal'),
(83, '16.00', 'ghiottosa', 'family'),
(84, '9.00', 'elite', 'baby'),
(85, '11.00', 'elite', 'normal'),
(86, '16.00', 'elite', 'family'),
(87, '9.00', 'regina', 'baby'),
(88, '11.00', 'regina', 'normal'),
(89, '16.00', 'regina', 'family'),
(90, '8.00', 'viziata', 'baby'),
(91, '10.00', 'viziata', 'normal'),
(92, '15.00', 'viziata', 'family'),
(93, '8.00', 'fantasia', 'baby'),
(94, '10.00', 'fantasia', 'normal'),
(95, '15.00', 'fantasia', 'family'),
(96, '8.00', 'viziosa', 'baby'),
(97, '10.00', 'viziosa', 'normal'),
(98, '15.00', 'viziosa', 'family'),
(99, '8.50', 'riccione', 'baby'),
(100, '10.50', 'riccione', 'normal'),
(101, '15.50', 'riccione', 'family'),
(102, '7.50', 'valtellina', 'baby'),
(103, '9.50', 'valtellina', 'normal'),
(104, '14.50', 'valtellina', 'family'),
(105, '8.00', 'gustosa', 'baby'),
(106, '10.00', 'gustosa', 'normal'),
(107, '15.00', 'gustosa', 'family'),
(108, '9.00', 'autunnale', 'baby'),
(109, '11.00', 'autunnale', 'normal'),
(110, '16.00', 'autunnale', 'family'),
(111, '8.00', 'marittima', 'baby'),
(112, '10.00', 'marittima', 'normal'),
(113, '15.00', 'marittima', 'family'),
(114, '7.00', 'gioiosa', 'baby'),
(115, '9.00', 'gioiosa', 'normal'),
(116, '14.00', 'gioiosa', 'family'),
(117, '8.50', 'a riccia', 'baby'),
(119, '15.50', 'a riccia', 'family'),
(120, '7.50', 'rustica', 'baby'),
(121, '9.50', 'rustica', 'normal'),
(122, '14.50', 'rustica', 'family'),
(123, '9.00', 'cremosa', 'baby'),
(124, '11.00', 'cremosa', 'normal'),
(125, '16.00', 'cremosa', 'family'),
(126, '6.00', 'messicana', 'baby'),
(127, '8.00', 'messicana', 'normal'),
(128, '13.00', 'messicana', 'family'),
(129, '6.00', 'halloween', 'baby'),
(130, '8.00', 'halloween', 'normal'),
(131, '13.00', 'halloween', 'family'),
(132, '7.00', 'calabria', 'baby'),
(133, '9.00', 'calabria', 'normal'),
(134, '14.00', 'calabria', 'family'),
(135, '7.50', 'montanara', 'baby'),
(136, '9.50', 'montanara', 'normal'),
(137, '14.50', 'montanara', 'family'),
(138, '7.50', 'sublime', 'baby'),
(139, '9.50', 'sublime', 'normal'),
(140, '14.50', 'sublime', 'family'),
(141, '8.50', 'formaggiosa', 'baby'),
(142, '10.50', 'formaggiosa', 'normal'),
(143, '15.50', 'formaggiosa', 'family'),
(144, '9.00', 'muscolosa', 'baby'),
(145, '11.00', 'muscolosa', 'normal'),
(146, '16.00', 'muscolosa', 'family'),
(147, '13.00', 'del porto', 'normal'),
(148, '18.00', 'del porto', 'family'),
(149, '13.00', 'gloriosa', 'normal'),
(150, '18.00', 'gloriosa', 'family'),
(151, '13.00', 'granellosa', 'normal'),
(152, '18.00', 'granellosa', 'family'),
(153, '13.00', 'contadina', 'normal'),
(154, '18.00', 'contadina', 'family'),
(155, '12.00', 'pirotecnica', 'normal'),
(156, '17.00', 'pirotecnica', 'family'),
(157, '13.00', 'ficata', 'normal'),
(158, '18.00', 'ficata', 'family'),
(159, '13.00', 'primavera', 'normal'),
(160, '18.00', 'primavera', 'family'),
(161, '13.00', 'golosa', 'normal'),
(162, '18.00', 'golosa', 'family'),
(163, '13.00', 'bruschettona', 'normal'),
(164, '18.00', 'bruschettona', 'family'),
(165, '13.00', 'del conte', 'normal'),
(166, '18.00', 'del conte', 'family'),
(167, '12.00', 'zombie', 'normal'),
(168, '17.00', 'zombie', 'family'),
(169, '12.00', 'adriatica', 'normal'),
(170, '17.00', 'adriatica', 'family');

-- --------------------------------------------------------

--
-- Struttura della tabella `pi`
--

DROP TABLE IF EXISTS `pi`;
CREATE TABLE IF NOT EXISTS `pi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PIZZA` varchar(30) NOT NULL COMMENT 'foreign key -> Pizza',
  `INGREDIENTE` varchar(60) NOT NULL COMMENT 'foreign key -> Ingrediente',
  PRIMARY KEY (`ID`),
  KEY `PIP` (`PIZZA`),
  KEY `PII` (`INGREDIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `pi`
--

TRUNCATE TABLE `pi`;
--
-- Dump dei dati per la tabella `pi`
--

INSERT INTO `pi` (`ID`, `PIZZA`, `INGREDIENTE`) VALUES
(1, 'margherita', 'pomodoro'),
(2, 'margherita', 'mozzarella'),
(3, 'napoli', 'pomodoro'),
(4, 'napoli', 'mozzarella'),
(5, 'napoli', 'acciughe'),
(6, 'napoli', 'origano'),
(7, 'diavola', 'pomodoro'),
(8, 'diavola', 'mozzarella'),
(9, 'diavola', 'salame piccante'),
(10, 'prosciutto', 'pomodoro'),
(11, 'prosciutto', 'mozzarella'),
(12, 'prosciutto', 'prosciutto cotto'),
(13, 'wurstel', 'pomodoro'),
(14, 'wurstel', 'mozzarella'),
(15, 'wurstel', 'wurstel'),
(16, 'patate e wurstel', 'pomodoro'),
(17, 'patate e wurstel', 'mozzarella'),
(18, 'patate e wurstel', 'patatine'),
(19, 'patate e wurstel', 'wurstel'),
(20, 'peperonata', 'pomodoro'),
(21, 'peperonata', 'mozzarella'),
(22, 'peperonata', 'peperoni'),
(23, 'peperonata', 'patatine'),
(24, 'prosciutto e zola', 'pomodoro'),
(25, 'prosciutto e zola', 'mozzarella'),
(26, 'prosciutto e zola', 'prosciutto cotto'),
(27, 'prosciutto e zola', 'zola'),
(28, 'tonno e cipolla', 'pomodoro'),
(29, 'tonno e cipolla', 'mozzarella'),
(30, 'tonno e cipolla', 'tonno'),
(31, 'tonno e cipolla', 'cipolla'),
(32, '4 formaggi', 'pomodoro'),
(33, '4 formaggi', 'mozzarella'),
(34, '4 formaggi', 'grana'),
(35, '4 formaggi', 'zola'),
(36, '4 formaggi', 'scamorza'),
(37, 'calzone', 'pomodoro'),
(38, 'calzone', 'mozzarella'),
(39, 'calzone', 'prosciutto cotto'),
(40, 'pugliese', 'pomodoro'),
(41, 'pugliese', 'mozzarella'),
(42, 'pugliese', 'cipolla'),
(43, 'pugliese', 'grana'),
(44, 'pugliese', 'origano'),
(45, 'siciliana', 'pomodoro'),
(46, 'siciliana', 'mozzarella'),
(47, 'siciliana', 'capperi'),
(48, 'siciliana', 'acciughe'),
(49, 'siciliana', 'olive'),
(50, 'siciliana', 'origano'),
(51, 'bufala', 'pomodoro'),
(52, 'bufala', 'bufala'),
(53, 'panna e speck', 'pomodoro'),
(54, 'panna e speck', 'mozzarella'),
(55, 'panna e speck', 'speck'),
(56, 'panna e speck', 'panna'),
(57, '4 stagioni', 'pomodoro'),
(58, '4 stagioni', 'mozzarella'),
(59, '4 stagioni', 'prosciutto cotto'),
(60, '4 stagioni', 'carciofi'),
(61, '4 stagioni', 'olive'),
(62, '4 stagioni', 'funghi'),
(63, 'bismarck', 'pomodoro'),
(64, 'bismarck', 'mozzarella'),
(65, 'bismarck', 'speck'),
(66, 'bismarck', 'wurstel'),
(67, 'bufala', 'basilico'),
(68, 'bismarck', 'uovo'),
(69, 'calzone farcito', 'pomodoro'),
(70, 'calzone farcito', 'mozzarella'),
(71, 'calzone farcito', 'prosciutto cotto'),
(72, 'calzone farcito', 'carciofi'),
(73, 'calzone farcito', 'olive'),
(74, 'calzone farcito', 'funghi'),
(75, 'capricciosa', 'pomodoro'),
(76, 'capricciosa', 'mozzarella'),
(77, 'capricciosa', 'olive'),
(78, 'capricciosa', 'funghi'),
(79, 'capricciosa', 'prosciutto cotto'),
(80, 'capricciosa', 'carciofi'),
(81, 'crudo', 'pomodoro'),
(82, 'crudo', 'mozzarella'),
(83, 'crudo', 'crudo di parma'),
(84, 'parmigiana', 'pomodoro'),
(85, 'parmigiana', 'mozzarella'),
(86, 'parmigiana', 'melanzane'),
(87, 'parmigiana', 'grana'),
(88, 'salsiccia e friarielli', 'pomodoro'),
(89, 'salsiccia e friarielli', 'mozzarella'),
(90, 'salsiccia e friarielli', 'salsiccia'),
(91, 'salsiccia e friarielli', 'friarielli'),
(92, 'vegetariana', 'pomodoro'),
(93, 'vegetariana', 'mozzarella'),
(94, 'vegetariana', 'melanzane'),
(95, 'vegetariana', 'peperoni'),
(96, 'vegetariana', 'zucchine grigliate'),
(97, 'alto adige', 'pomodoro'),
(98, 'alto adige', 'mozzarella'),
(99, 'alto adige', 'speck'),
(100, 'alto adige', 'radicchio'),
(101, 'alto adige', 'taleggio'),
(102, 'atomica', 'pomodoro'),
(103, 'atomica', 'mozzarella'),
(104, 'atomica', 'wurstel'),
(105, 'atomica', 'salame piccante'),
(106, 'atomica', 'mais'),
(107, 'atomica', 'jalapenos'),
(108, 'bresaola', 'pomodoro'),
(109, 'bresaola', 'mozzarella'),
(110, 'bresaola', 'bresaola'),
(111, 'bresaola', 'scaglie di grana'),
(112, 'bresaola', 'rucola'),
(113, 'salmonata', 'pomodoro'),
(114, 'salmonata', 'mozzarella'),
(115, 'salmonata', 'salmone'),
(116, 'salmonata', 'rucola'),
(117, 'salmonata', 'crescenza'),
(118, 'frutti di mare', 'pomodoro'),
(119, 'frutti di mare', 'mozzarella'),
(120, 'frutti di mare', 'misto mare'),
(121, 'ghiottosa', 'pomodoro'),
(122, 'ghiottosa', 'mozzarella'),
(123, 'ghiottosa', 'salmone'),
(124, 'ghiottosa', 'granchio'),
(125, 'ghiottosa', 'gamberetti'),
(126, 'elite', 'pomodoro'),
(127, 'elite', 'mozzarella'),
(128, 'elite', 'porcini'),
(129, 'elite', 'bresaola'),
(130, 'elite', 'radicchio'),
(131, 'regina', 'pomodoro'),
(132, 'regina', 'bufala'),
(133, 'regina', 'crudo di parma'),
(134, 'regina', 'porcini'),
(135, 'regina', 'pomodori secchi'),
(136, 'viziata', 'mozzarella'),
(137, 'viziata', 'polpa di zucca'),
(138, 'viziata', 'taleggio'),
(139, 'viziata', 'crudo di parma'),
(140, 'fantasia', 'pomodoro'),
(141, 'fantasia', 'mozzarella'),
(142, 'fantasia', 'stracciatella'),
(143, 'fantasia', 'crema di pistacchi'),
(144, 'fantasia', 'crema di zucca'),
(145, 'fantasia', 'basilico'),
(146, 'viziosa', 'focaccia'),
(147, 'viziosa', 'burratina'),
(148, 'viziosa', 'pesto a gocce'),
(149, 'viziosa', 'pomodorini freschi'),
(150, 'viziosa', 'basilico'),
(151, 'riccione', 'pomodoro'),
(152, 'riccione', 'mozzarella'),
(153, 'riccione', 'squaquerone'),
(154, 'riccione', 'crudo di parma'),
(155, 'riccione', 'rucola'),
(156, 'valtellina', 'pomodoro'),
(157, 'valtellina', 'mozzarella'),
(158, 'valtellina', 'bresaola'),
(159, 'valtellina', 'philadelphia'),
(160, 'valtellina', 'crema di aceto'),
(161, 'valtellina', 'pomodorini freschi'),
(162, 'gustosa', 'pomodoro'),
(163, 'gustosa', 'pancetta'),
(164, 'gustosa', 'gamberetti'),
(165, 'gustosa', 'bufala'),
(166, 'autunnale', 'pomodoro'),
(167, 'autunnale', 'mozzarella'),
(168, 'autunnale', 'porcini'),
(169, 'autunnale', 'taleggio'),
(170, 'autunnale', 'salsiccia'),
(171, 'marittima', 'pomodoro'),
(172, 'marittima', 'mozzarella'),
(173, 'marittima', 'filetti di sgombro'),
(174, 'marittima', 'pomodori secchi'),
(175, 'marittima', 'salsa verde'),
(176, 'gioiosa', 'pomodoro'),
(177, 'gioiosa', 'mozzarella'),
(178, 'gioiosa', 'gamberetti'),
(179, 'gioiosa', 'rucola'),
(180, 'gioiosa', 'salsa rosa'),
(181, 'a riccia', 'pomodoro'),
(182, 'a riccia', 'mozzarella'),
(183, 'a riccia', 'pomodori secchi'),
(184, 'a riccia', 'salsa verde'),
(185, 'rustica', 'pomodoro'),
(186, 'rustica', 'mozzarella'),
(187, 'rustica', 'pomodori secchi'),
(188, 'rustica', 'olive taggiasche'),
(189, 'rustica', 'crema di aceto'),
(190, 'rustica', 'cipolline'),
(191, 'cremosa', 'pomodoro'),
(192, 'cremosa', 'mozzarella'),
(193, 'cremosa', 'burratina'),
(194, 'cremosa', 'pomodorini freschi'),
(195, 'cremosa', 'basilico'),
(196, 'a riccia', 'porchetta'),
(197, 'messicana', 'mozzarella'),
(198, 'messicana', 'mais'),
(199, 'messicana', 'fagioli rossi'),
(200, 'messicana', 'cipolla di tropea'),
(201, 'messicana', 'peperoncino'),
(202, 'halloween', 'mozzarella'),
(203, 'halloween', 'crema di zucca'),
(204, 'halloween', 'zola'),
(205, 'halloween', 'basilico'),
(206, 'calabria', 'mozzarella'),
(207, 'calabria', 'nduja'),
(208, 'calabria', 'salsiccia'),
(209, 'calabria', 'olive'),
(210, 'calabria', 'cipolla di tropea'),
(211, 'montanara', 'mozzarella'),
(212, 'montanara', 'crema di noci'),
(213, 'montanara', 'speck'),
(214, 'montanara', 'taleggio'),
(215, 'sublime', 'mozzarella'),
(216, 'sublime', 'crema di pistacchi'),
(217, 'sublime', 'mortadella'),
(218, 'sublime', 'crescenza'),
(219, 'formaggiosa', 'mozzarella'),
(220, 'formaggiosa', 'zola'),
(221, 'formaggiosa', 'crescenza'),
(222, 'formaggiosa', 'taleggio'),
(223, 'formaggiosa', 'grana'),
(224, 'formaggiosa', 'provola affumicata'),
(225, 'muscolosa', 'mozzarella'),
(226, 'muscolosa', 'tonno'),
(227, 'muscolosa', 'spinaci'),
(228, 'muscolosa', 'bresaola'),
(229, 'muscolosa', 'crescenza'),
(230, 'muscolosa', 'crema di noci'),
(231, 'del porto', 'filetti di tonno'),
(232, 'del porto', 'bufala'),
(233, 'del porto', 'composto di cipolla rossa'),
(234, 'del porto', 'basilico'),
(235, 'gloriosa', 'crema di porcini'),
(236, 'gloriosa', 'rucola'),
(237, 'gloriosa', 'salmone a crudo'),
(238, 'gloriosa', 'crescenza'),
(239, 'gloriosa', 'olive taggiasche'),
(240, 'granellosa', 'crema di zucca'),
(241, 'granellosa', 'salsiccia'),
(242, 'granellosa', 'stracciatella'),
(243, 'contadina', 'provola affumicata'),
(244, 'contadina', 'salsiccia punta di coltello'),
(245, 'contadina', 'patate'),
(246, 'contadina', 'rosmarino'),
(247, 'pirotecnica', 'crema di zucca'),
(248, 'pirotecnica', 'cipolla caramellata'),
(249, 'pirotecnica', 'crema di radicchio'),
(250, 'pirotecnica', 'pomodorini freschi'),
(251, 'pirotecnica', 'olive taggiasche'),
(252, 'ficata', 'taleggio'),
(253, 'ficata', 'crudo di parma'),
(254, 'ficata', 'crudo di parma'),
(255, 'primavera', 'pomodorini freschi'),
(256, 'primavera', 'philadelphia'),
(257, 'primavera', 'crudo di parma'),
(258, 'primavera', 'rucola'),
(259, 'golosa', 'pomodoro'),
(260, 'golosa', 'zucchine grigliate'),
(261, 'golosa', 'gamberetti'),
(262, 'golosa', 'bufala'),
(263, 'golosa', 'crema di aceto'),
(264, 'bruschettona', 'olive taggiasche'),
(265, 'bruschettona', 'pomodorini freschi'),
(266, 'bruschettona', 'burratina'),
(267, 'bruschettona', 'basilico'),
(268, 'del conte', 'crema di radicchio'),
(269, 'del conte', 'pancetta'),
(270, 'del conte', 'porcini'),
(271, 'zombie', 'crema di zucca'),
(272, 'zombie', 'bacon'),
(273, 'zombie', 'bufala'),
(274, 'zombie', 'cipolla caramellata'),
(275, 'adriatica', 'pomodorini freschi'),
(276, 'adriatica', 'gamberetti'),
(277, 'adriatica', 'basilico'),
(278, 'adriatica', 'pesto a gocce'),
(280, 'granellosa', 'granella di pistacchi'),
(281, 'primavera', 'glassa di aceto'),
(282, 'del conte', 'pepe macinato'),
(283, 'ficata', 'crema di fichi'),
(284, 'frutti di mare', 'misto mare');

-- --------------------------------------------------------

--
-- Struttura della tabella `pietanza`
--

DROP TABLE IF EXISTS `pietanza`;
CREATE TABLE IF NOT EXISTS `pietanza` (
  `NOME` varchar(30) NOT NULL,
  `SURGELATO` tinyint(1) DEFAULT NULL COMMENT 'null -> false',
  `CLASSE` varchar(30) DEFAULT NULL,
  `PREZZO` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`NOME`),
  KEY `CP` (`CLASSE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `pietanza`
--

TRUNCATE TABLE `pietanza`;
--
-- Dump dei dati per la tabella `pietanza`
--

INSERT INTO `pietanza` (`NOME`, `SURGELATO`, `CLASSE`, `PREZZO`) VALUES
('anelli di cipolle', 1, 'friggitoria', '6.00'),
('anelli di totano', 1, 'friggitoria', '6.00'),
('chele di granchio', 1, 'friggitoria', '6.00'),
('mozzarelline', 1, 'friggitoria', '6.00'),
('olive all ascolana', 1, 'friggitoria', '6.00'),
('patatine', 1, 'friggitoria', '3.00'),
('red hot jalapenos', 1, 'friggitoria', '6.00'),
('triangoli speck e patate', 1, 'friggitoria', '6.00');

-- --------------------------------------------------------

--
-- Struttura della tabella `pizza`
--

DROP TABLE IF EXISTS `pizza`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `NOME` varchar(30) NOT NULL,
  `CLASSE` varchar(30) DEFAULT NULL COMMENT 'foreign key -> Classe',
  `VISIBILE` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`NOME`),
  KEY `PC` (`CLASSE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `pizza`
--

TRUNCATE TABLE `pizza`;
--
-- Dump dei dati per la tabella `pizza`
--

INSERT INTO `pizza` (`NOME`, `CLASSE`, `VISIBILE`) VALUES
('4 formaggi', 'le tradizionali', 1),
('4 stagioni', 'le tradizionali', 1),
('a riccia', 'le pizze scelte da voi', 1),
('adriatica', 'le pizze gourmet', 1),
('alto adige', 'le tradizionali', 1),
('atomica', 'le tradizionali', 1),
('autunnale', 'le pizze scelte da voi', 1),
('bismarck', 'le tradizionali', 1),
('bresaola', 'le tradizionali', 1),
('bruschettona', 'le pizze gourmet', 1),
('bufala', 'le tradizionali', 1),
('calabria', 'le speciali', 1),
('calzone', 'le tradizionali', 1),
('calzone farcito', 'le tradizionali', 1),
('capricciosa', 'le tradizionali', 1),
('contadina', 'le pizze gourmet', 1),
('cremosa', 'le pizze scelte da voi', 1),
('crudo', 'le tradizionali', 1),
('del conte', 'le pizze gourmet', 1),
('del porto', 'le pizze gourmet', 1),
('diavola', 'le tradizionali', 1),
('elite', 'le tradizionali', 1),
('fantasia', 'le pizze scelte da voi', 1),
('ficata', 'le pizze gourmet', 1),
('formaggiosa', 'le speciali', 1),
('frutti di mare', 'le tradizionali', 1),
('ghiottosa', 'le tradizionali', 1),
('gioiosa', 'le pizze scelte da voi', 1),
('gloriosa', 'le pizze gourmet', 1),
('golosa', 'le pizze gourmet', 1),
('granellosa', 'le pizze gourmet', 1),
('gustosa', 'le pizze scelte da voi', 1),
('halloween', 'le speciali', 1),
('margherita', 'le tradizionali', 1),
('marittima', 'le pizze scelte da voi', 1),
('messicana', 'le speciali', 1),
('montanara', 'le speciali', 1),
('muscolosa', 'le speciali', 1),
('napoli', 'le tradizionali', 1),
('panna e speck', 'le tradizionali', 1),
('parmigiana', 'le tradizionali', 1),
('patate e wurstel', 'le tradizionali', 1),
('peperonata', 'le tradizionali', 1),
('pirotecnica', 'le pizze gourmet', 1),
('primavera', 'le pizze gourmet', 1),
('prosciutto', 'le tradizionali', 1),
('prosciutto e zola', 'le tradizionali', 1),
('pugliese', 'le tradizionali', 1),
('regina', 'le tradizionali', 1),
('riccione', 'le pizze scelte da voi', 1),
('rustica', 'le pizze scelte da voi', 1),
('salmonata', 'le tradizionali', 1),
('salsiccia e friarielli', 'le tradizionali', 1),
('siciliana', 'le tradizionali', 1),
('sublime', 'le speciali', 1),
('tonno e cipolla', 'le tradizionali', 1),
('valtellina', 'le pizze scelte da voi', 1),
('vegetariana', 'le tradizionali', 1),
('viziata', 'le pizze scelte da voi', 1),
('viziosa', 'le pizze scelte da voi', 1),
('wurstel', 'le tradizionali', 1),
('zombie', 'le pizze gourmet', 1);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ip`
--
ALTER TABLE `ip`
  ADD CONSTRAINT `IPI` FOREIGN KEY (`INGREDIENTE`) REFERENCES `ingrediente` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IPP` FOREIGN KEY (`PIETANZA`) REFERENCES `pietanza` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `pf`
--
ALTER TABLE `pf`
  ADD CONSTRAINT `PFF` FOREIGN KEY (`FORMATO`) REFERENCES `formato` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PFP` FOREIGN KEY (`PIZZA`) REFERENCES `pizza` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `pi`
--
ALTER TABLE `pi`
  ADD CONSTRAINT `PII` FOREIGN KEY (`INGREDIENTE`) REFERENCES `ingrediente` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PIP` FOREIGN KEY (`PIZZA`) REFERENCES `pizza` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `pietanza`
--
ALTER TABLE `pietanza`
  ADD CONSTRAINT `CP` FOREIGN KEY (`CLASSE`) REFERENCES `classe` (`NOME`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `pizza`
--
ALTER TABLE `pizza`
  ADD CONSTRAINT `PC` FOREIGN KEY (`CLASSE`) REFERENCES `classe` (`NOME`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
