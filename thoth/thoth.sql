-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ago 29, 2022 alle 01:57
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
(2, 'Coca-Cola', 33, 'Lattina', '2.00'),
(3, 'Fanta', 33, 'Lattina', '2.00'),
(4, 'Sprite', 33, 'Lattina', '2.00'),
(5, 'The', 33, 'Lattina', '2.00'),
(6, 'Birra', 33, 'Vetro', '3.00'),
(7, 'Birra', 50, 'Vetro', '3.50'),
(8, 'Birra', 66, 'Vetro', '3.50'),
(9, 'Vino Bianco', 100, 'Vetro', '5.00'),
(10, 'Vino Rosso', 100, 'Vetro', '5.00'),
(11, 'Acqua Naturale', 50, 'Bottiglia', '1.00'),
(12, 'Acqua Gassata', 50, 'Bottiglia', '1.00'),
(13, 'Coca-Cola', 100, 'Bottiglia', '3.00'),
(14, 'Fanta', 100, 'Bottiglia', '3.00'),
(15, 'Sprite', 100, 'Bottiglia', '3.00'),
(16, 'The', 100, 'Bottiglia', '3.00');

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
('Friggitoria', NULL, 100),
('La Pizza della Settimana', 'disponibile fino a questa domenica!', 10),
('Le Pizze Gourmet', NULL, 40),
('Le Pizze Scelte Da Voi', NULL, 50),
('Le Speciali', 'base bianca solo mozzarella', 30),
('Le Tradizionali', NULL, 20);

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
('Baby'),
('Family'),
('Normal');

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
('Acciughe', 0, '1.00'),
('Bacon', 0, '0.00'),
('Basilico', 0, '0.00'),
('Bresaola', 0, '2.00'),
('Bufala', 0, '3.00'),
('Burratina', 0, '3.00'),
('Capperi', 0, '1.00'),
('Carciofi', 0, '1.00'),
('Cinque Pezzi', 0, NULL),
('Cipolla', 0, '1.00'),
('Cipolla caramellata', 0, '1.00'),
('Cipolla di tropea', 0, '1.00'),
('Cipolline', 0, NULL),
('Composto di cipolla rossa', 0, '1.00'),
('Crema di aceto', 0, '1.00'),
('Crema di fichi', 0, '1.00'),
('Crema di noci', 0, '1.00'),
('Crema di pistacchi', 0, '1.00'),
('Crema di porcini', 0, '1.00'),
('Crema di radicchio', 0, '1.00'),
('Crema di zucca', 0, '1.00'),
('Crescenza', 0, '1.00'),
('Crudo di Parma', 0, '2.00'),
('Fagioli rossi', 0, '1.00'),
('Filetti di sgombro', 0, '2.00'),
('Filetti di tonno', 0, '2.00'),
('Focaccia', 0, NULL),
('Friarielli', 0, '1.00'),
('Funghi', 0, '1.00'),
('Gamberetti', 1, '3.00'),
('Glassa di aceto', 0, '1.00'),
('Grana', 0, '1.00'),
('Granchio', 0, '2.00'),
('Granella di pistacchi', 0, '1.00'),
('Jalapenos', 0, '1.00'),
('Mais', 0, '1.00'),
('Melanzane', 0, '1.00'),
('Misto mare', 1, NULL),
('Mortadella', 0, '1.00'),
('Mozzarella', 0, '1.00'),
('Nduja', 0, '2.00'),
('Olive', 0, '1.00'),
('Olive taggiasche', 0, '2.00'),
('Origano', 0, '0.00'),
('Pancetta', 0, '1.00'),
('Panna', 0, '2.00'),
('Patate', 0, '1.00'),
('Patatine', 1, '1.00'),
('Pepe macinato', 0, '0.00'),
('Peperoncino', 0, '1.00'),
('Peperoni', 0, '1.00'),
('Pesto a gocce', 0, '1.00'),
('Philadelphia', 0, '1.00'),
('Polpa di zucca', 0, '2.00'),
('Pomodori secchi', 0, '2.00'),
('Pomodorini freschi', 0, '1.00'),
('Pomodoro', 0, '1.00'),
('Porchetta', 0, '2.00'),
('Porcini', 0, '3.00'),
('Prosciutto cotto', 0, '1.00'),
('Provola affumicata', 0, '1.00'),
('Radicchio', 0, '1.00'),
('Rosmarino', 0, '0.00'),
('Rucola', 0, '1.00'),
('Salame piccante', 0, '1.00'),
('Salmone', 0, '3.00'),
('Salmone a crudo', 0, '3.00'),
('Salsa rosa', 0, '1.00'),
('Salsa verde', 0, '1.00'),
('Salsiccia', 0, '2.00'),
('Salsiccia punta di coltello', 0, '2.00'),
('Scaglie di Grana', 0, '1.00'),
('Scamorza', 0, '1.00'),
('Sei Pezzi', 0, NULL),
('Speck', 0, '1.00'),
('Spinaci', 0, '1.00'),
('Squaquerone', 0, '3.00'),
('Stracciatella', 0, '3.00'),
('Taleggio', 0, '1.00'),
('Tonno', 0, '1.00'),
('Uovo', 0, '1.00'),
('Wurstel', 0, '1.00'),
('Zola', 0, '1.00'),
('Zucchine grigliate', 0, '1.00');

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
(1, 'Cinque Pezzi', 'Chele di Granchio'),
(2, 'Sei Pezzi', 'Olive all Ascolana'),
(3, 'Cinque Pezzi', 'Triangoli Speck e Patate'),
(4, 'Cinque Pezzi', 'Red Hot Jalapenos');

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
(1, '3.00', 'Margherita', 'Baby'),
(2, '5.00', 'Margherita', 'Normal'),
(3, '10.00', 'Margherita', 'Family'),
(4, '4.00', 'Napoli', 'Baby'),
(5, '6.00', 'Napoli', 'Normal'),
(6, '11.00', 'Napoli', 'Family'),
(7, '4.00', 'Diavola', 'Baby'),
(8, '6.00', 'Diavola', 'Normal'),
(9, '11.00', 'Diavola', 'Family'),
(10, '4.00', 'Prosciutto', 'Baby'),
(11, '6.00', 'Prosciutto', 'Normal'),
(12, '11.00', 'Prosciutto', 'Family'),
(13, '4.00', 'Wurstel', 'Baby'),
(14, '6.00', 'Wurstel', 'Normal'),
(15, '11.00', 'Wurstel', 'Family'),
(16, '5.00', 'Patate e Wurstel', 'Baby'),
(17, '7.00', 'Patate e Wurstel', 'Normal'),
(18, '12.00', 'Patate e Wurstel', 'Family'),
(19, '5.00', 'Peperonata', 'Baby'),
(20, '7.00', 'Peperonata', 'Normal'),
(21, '12.00', 'Peperonata', 'Family'),
(22, '7.00', 'Prosciutto e Zola', 'Baby'),
(23, '5.00', 'Prosciutto e Zola', 'Normal'),
(24, '12.00', 'Prosciutto e Zola', 'Family'),
(25, '5.00', 'Tonno e Cipolla', 'Baby'),
(26, '7.00', 'Tonno e Cipolla', 'Normal'),
(27, '12.00', 'Tonno e Cipolla', 'Family'),
(28, '6.00', '4 Formaggi', 'Baby'),
(29, '8.00', '4 Formaggi', 'Normal'),
(30, '13.00', '4 Formaggi', 'Family'),
(31, '7.00', 'Calzone', 'Normal'),
(32, '5.50', 'Pugliese', 'Baby'),
(33, '7.50', 'Pugliese', 'Normal'),
(34, '12.50', 'Pugliese', 'Family'),
(35, '5.50', 'Siciliana', 'Baby'),
(36, '7.50', 'Siciliana', 'Normal'),
(37, '12.50', 'Siciliana', 'Family'),
(38, '6.50', 'Bufala', 'Baby'),
(39, '8.50', 'Bufala', 'Normal'),
(40, '13.50', 'Bufala', 'Family'),
(41, '6.00', 'Panna e Speck', 'Baby'),
(42, '8.00', 'Panna e Speck', 'Normal'),
(43, '13.00', 'Panna e Speck', 'Family'),
(44, '6.00', '4 Stagioni', 'Baby'),
(45, '8.00', '4 Stagioni', 'Normal'),
(46, '13.00', '4 Stagioni', 'Family'),
(47, '6.00', 'Bismarck', 'Baby'),
(48, '8.00', 'Bismarck', 'Normal'),
(49, '13.00', 'Bismarck', 'Family'),
(50, '8.50', 'Calzone Farcito', 'Normal'),
(51, '6.50', 'Capricciosa', 'Baby'),
(52, '8.50', 'Capricciosa', 'Normal'),
(53, '13.50', 'Capricciosa', 'Family'),
(54, '6.50', 'Crudo', 'Baby'),
(55, '8.50', 'Crudo', 'Normal'),
(56, '13.50', 'Crudo', 'Family'),
(57, '6.50', 'Parmigiana', 'Baby'),
(58, '8.50', 'Parmigiana', 'Normal'),
(59, '13.50', 'Parmigiana', 'Family'),
(60, '6.00', 'Salsiccia e Friarielli', 'Baby'),
(61, '8.00', 'Salsiccia e Friarielli', 'Normal'),
(62, '13.00', 'Salsiccia e Friarielli', 'Family'),
(63, '6.50', 'Vegetariana', 'Baby'),
(64, '8.50', 'Vegetariana', 'Normal'),
(65, '13.50', 'Vegetariana', 'Family'),
(66, '7.00', 'Alto Adige', 'Baby'),
(67, '9.00', 'Alto Adige', 'Normal'),
(68, '14.00', 'Alto Adige', 'Family'),
(69, '7.50', 'Atomica', 'Baby'),
(70, '9.50', 'Atomica', 'Normal'),
(71, '14.50', 'Atomica', 'Family'),
(72, '7.50', 'Bresaola', 'Baby'),
(73, '9.50', 'Bresaola', 'Normal'),
(74, '14.50', 'Bresaola', 'Family'),
(75, '8.50', 'Salmonata', 'Baby'),
(76, '10.50', 'Salmonata', 'Normal'),
(77, '15.50', 'Salmonata', 'Family'),
(78, '8.00', 'Frutti di mare', 'Baby'),
(79, '10.00', 'Frutti di mare', 'Normal'),
(80, '15.00', 'Frutti di mare', 'Family'),
(81, '9.00', 'Ghiottosa', 'Baby'),
(82, '11.00', 'Ghiottosa', 'Normal'),
(83, '16.00', 'Ghiottosa', 'Family'),
(84, '9.00', 'Elite', 'Baby'),
(85, '11.00', 'Elite', 'Normal'),
(86, '16.00', 'Elite', 'Family'),
(87, '9.00', 'Regina', 'Baby'),
(88, '11.00', 'Regina', 'Normal'),
(89, '16.00', 'Regina', 'Family'),
(90, '8.00', 'Viziata', 'Baby'),
(91, '10.00', 'Viziata', 'Normal'),
(92, '15.00', 'Viziata', 'Family'),
(93, '8.00', 'Fantasia', 'Baby'),
(94, '10.00', 'Fantasia', 'Normal'),
(95, '15.00', 'Fantasia', 'Family'),
(96, '8.00', 'Viziosa', 'Baby'),
(97, '10.00', 'Viziosa', 'Normal'),
(98, '15.00', 'Viziosa', 'Family'),
(99, '8.50', 'Riccione', 'Baby'),
(100, '10.50', 'Riccione', 'Normal'),
(101, '15.50', 'Riccione', 'Family'),
(102, '7.50', 'Valtellina', 'Baby'),
(103, '9.50', 'Valtellina', 'Normal'),
(104, '14.50', 'Valtellina', 'Family'),
(105, '8.00', 'Gustosa', 'Baby'),
(106, '10.00', 'Gustosa', 'Normal'),
(107, '15.00', 'Gustosa', 'Family'),
(108, '9.00', 'Autunnale', 'Baby'),
(109, '11.00', 'Autunnale', 'Normal'),
(110, '16.00', 'Autunnale', 'Family'),
(111, '8.00', 'Marittima', 'Baby'),
(112, '10.00', 'Marittima', 'Normal'),
(113, '15.00', 'Marittima', 'Family'),
(114, '7.00', 'Gioiosa', 'Baby'),
(115, '9.00', 'Gioiosa', 'Normal'),
(116, '14.00', 'Gioiosa', 'Family'),
(117, '8.50', 'A riccia', 'Baby'),
(118, '10.50', 'Atomica', 'Normal'),
(119, '15.50', 'A riccia', 'Family'),
(120, '7.50', 'Rustica', 'Baby'),
(121, '9.50', 'Rustica', 'Normal'),
(122, '14.50', 'Rustica', 'Family'),
(123, '9.00', 'Cremosa', 'Baby'),
(124, '11.00', 'Cremosa', 'Normal'),
(125, '16.00', 'Cremosa', 'Family'),
(126, '6.00', 'Messicana', 'Baby'),
(127, '8.00', 'Messicana', 'Normal'),
(128, '13.00', 'Messicana', 'Family'),
(129, '6.00', 'Halloween', 'Baby'),
(130, '8.00', 'Halloween', 'Normal'),
(131, '13.00', 'Halloween', 'Family'),
(132, '7.00', 'Calabria', 'Baby'),
(133, '9.00', 'Calabria', 'Normal'),
(134, '14.00', 'Calabria', 'Family'),
(135, '7.50', 'Montanara', 'Baby'),
(136, '9.50', 'Montanara', 'Normal'),
(137, '14.50', 'Montanara', 'Family'),
(138, '7.50', 'Sublime', 'Baby'),
(139, '9.50', 'Sublime', 'Normal'),
(140, '14.50', 'Sublime', 'Family'),
(141, '8.50', 'Formaggiosa', 'Baby'),
(142, '10.50', 'Formaggiosa', 'Normal'),
(143, '15.50', 'Formaggiosa', 'Family'),
(144, '9.00', 'Muscolosa', 'Baby'),
(145, '11.00', 'Muscolosa', 'Normal'),
(146, '16.00', 'Muscolosa', 'Family'),
(147, '13.00', 'Del porto', 'Normal'),
(148, '18.00', 'Del porto', 'Family'),
(149, '13.00', 'Gloriosa', 'Normal'),
(150, '18.00', 'Gloriosa', 'Family'),
(151, '13.00', 'Granellosa', 'Normal'),
(152, '18.00', 'Granellosa', 'Family'),
(153, '13.00', 'Contadina', 'Normal'),
(154, '18.00', 'Contadina', 'Family'),
(155, '12.00', 'Pirotecnica', 'Normal'),
(156, '17.00', 'Pirotecnica', 'Family'),
(157, '13.00', 'Ficata', 'Normal'),
(158, '18.00', 'Ficata', 'Family'),
(159, '13.00', 'Primavera', 'Normal'),
(160, '18.00', 'Primavera', 'Family'),
(161, '13.00', 'Golosa', 'Normal'),
(162, '18.00', 'Golosa', 'Family'),
(163, '13.00', 'Bruschettona', 'Normal'),
(164, '18.00', 'Bruschettona', 'Family'),
(165, '13.00', 'Del conte', 'Normal'),
(166, '18.00', 'Del conte', 'Family'),
(167, '12.00', 'Zombie', 'Normal'),
(168, '17.00', 'Zombie', 'Family'),
(169, '12.00', 'Adriatica', 'Normal'),
(170, '17.00', 'Adriatica', 'Family');

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
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=utf8;

--
-- Svuota la tabella prima dell'inserimento `pi`
--

TRUNCATE TABLE `pi`;
--
-- Dump dei dati per la tabella `pi`
--

INSERT INTO `pi` (`ID`, `PIZZA`, `INGREDIENTE`) VALUES
(1, 'Margherita', 'Pomodoro'),
(2, 'Margherita', 'Mozzarella'),
(3, 'Napoli', 'Pomodoro'),
(4, 'Napoli', 'Mozzarella'),
(5, 'Napoli', 'Acciughe'),
(6, 'Napoli', 'Origano'),
(7, 'Diavola', 'Pomodoro'),
(8, 'Diavola', 'Mozzarella'),
(9, 'Diavola', 'Salame piccante'),
(10, 'Prosciutto', 'Pomodoro'),
(11, 'Prosciutto', 'Mozzarella'),
(12, 'Prosciutto', 'Prosciutto cotto'),
(13, 'Wurstel', 'Pomodoro'),
(14, 'Wurstel', 'Mozzarella'),
(15, 'Wurstel', 'Wurstel'),
(16, 'Patate e Wurstel', 'Pomodoro'),
(17, 'Patate e Wurstel', 'Mozzarella'),
(18, 'Patate e Wurstel', 'Patatine'),
(19, 'Patate e Wurstel', 'Wurstel'),
(20, 'Peperonata', 'Pomodoro'),
(21, 'Peperonata', 'Mozzarella'),
(22, 'Peperonata', 'Peperoni'),
(23, 'Peperonata', 'Patatine'),
(24, 'Prosciutto e Zola', 'Pomodoro'),
(25, 'Prosciutto e Zola', 'Mozzarella'),
(26, 'Prosciutto e Zola', 'Prosciutto cotto'),
(27, 'Prosciutto e Zola', 'Zola'),
(28, 'Tonno e Cipolla', 'Pomodoro'),
(29, 'Tonno e Cipolla', 'Mozzarella'),
(30, 'Tonno e Cipolla', 'Tonno'),
(31, 'Tonno e Cipolla', 'Cipolla'),
(32, '4 Formaggi', 'Pomodoro'),
(33, '4 Formaggi', 'Mozzarella'),
(34, '4 Formaggi', 'Grana'),
(35, '4 Formaggi', 'Zola'),
(36, '4 Formaggi', 'Scamorza'),
(37, 'Calzone', 'Pomodoro'),
(38, 'Calzone', 'Mozzarella'),
(39, 'Calzone', 'Prosciutto cotto'),
(40, 'Pugliese', 'Pomodoro'),
(41, 'Pugliese', 'Mozzarella'),
(42, 'Pugliese', 'Cipolla'),
(43, 'Pugliese', 'Grana'),
(44, 'Pugliese', 'Origano'),
(45, 'Siciliana', 'Pomodoro'),
(46, 'Siciliana', 'Mozzarella'),
(47, 'Siciliana', 'Capperi'),
(48, 'Siciliana', 'Acciughe'),
(49, 'Siciliana', 'Olive'),
(50, 'Siciliana', 'Origano'),
(51, 'Bufala', 'Pomodoro'),
(52, 'Bufala', 'Bufala'),
(53, 'Panna e Speck', 'Pomodoro'),
(54, 'Panna e Speck', 'Mozzarella'),
(55, 'Panna e Speck', 'Speck'),
(56, 'Panna e Speck', 'Panna'),
(57, '4 Stagioni', 'Pomodoro'),
(58, '4 Stagioni', 'Mozzarella'),
(59, '4 Stagioni', 'Prosciutto cotto'),
(60, '4 Stagioni', 'Carciofi'),
(61, '4 Stagioni', 'Olive'),
(62, '4 Stagioni', 'Funghi'),
(63, 'Bismarck', 'Pomodoro'),
(64, 'Bismarck', 'Mozzarella'),
(65, 'Bismarck', 'Speck'),
(66, 'Bismarck', 'Wurstel'),
(67, 'Bufala', 'Basilico'),
(68, 'Bismarck', 'Uovo'),
(69, 'Calzone Farcito', 'Pomodoro'),
(70, 'Calzone Farcito', 'Mozzarella'),
(71, 'Calzone Farcito', 'Prosciutto cotto'),
(72, 'Calzone Farcito', 'Carciofi'),
(73, 'Calzone Farcito', 'Olive'),
(74, 'Calzone Farcito', 'Funghi'),
(75, 'Capricciosa', 'Pomodoro'),
(76, 'Capricciosa', 'Mozzarella'),
(77, 'Capricciosa', 'Olive'),
(78, 'Capricciosa', 'Funghi'),
(79, 'Capricciosa', 'Prosciutto cotto'),
(80, 'Capricciosa', 'Carciofi'),
(81, 'Crudo', 'Pomodoro'),
(82, 'Crudo', 'Mozzarella'),
(83, 'Crudo', 'Crudo di Parma'),
(84, 'Parmigiana', 'Pomodoro'),
(85, 'Parmigiana', 'Mozzarella'),
(86, 'Parmigiana', 'Melanzane'),
(87, 'Parmigiana', 'Grana'),
(88, 'Salsiccia e Friarielli', 'Pomodoro'),
(89, 'Salsiccia e Friarielli', 'Mozzarella'),
(90, 'Salsiccia e Friarielli', 'Salsiccia'),
(91, 'Salsiccia e Friarielli', 'Friarielli'),
(92, 'Vegetariana', 'Pomodoro'),
(93, 'Vegetariana', 'Mozzarella'),
(94, 'Vegetariana', 'Melanzane'),
(95, 'Vegetariana', 'Peperoni'),
(96, 'Vegetariana', 'Zucchine grigliate'),
(97, 'Alto Adige', 'Pomodoro'),
(98, 'Alto Adige', 'Mozzarella'),
(99, 'Alto Adige', 'Speck'),
(100, 'Alto Adige', 'Radicchio'),
(101, 'Alto Adige', 'Taleggio'),
(102, 'Atomica', 'Pomodoro'),
(103, 'Atomica', 'Mozzarella'),
(104, 'Atomica', 'Wurstel'),
(105, 'Atomica', 'Salame piccante'),
(106, 'Atomica', 'Mais'),
(107, 'Atomica', 'Jalapenos'),
(108, 'Bresaola', 'Pomodoro'),
(109, 'Bresaola', 'Mozzarella'),
(110, 'Bresaola', 'Bresaola'),
(111, 'Bresaola', 'Scaglie di Grana'),
(112, 'Bresaola', 'Rucola'),
(113, 'Salmonata', 'Pomodoro'),
(114, 'Salmonata', 'Mozzarella'),
(115, 'Salmonata', 'Salmone'),
(116, 'Salmonata', 'Rucola'),
(117, 'Salmonata', 'Crescenza'),
(118, 'Frutti di mare', 'Pomodoro'),
(119, 'Frutti di mare', 'Mozzarella'),
(120, 'Frutti di mare', 'Misto mare'),
(121, 'Ghiottosa', 'Pomodoro'),
(122, 'Ghiottosa', 'Mozzarella'),
(123, 'Ghiottosa', 'Salmone'),
(124, 'Ghiottosa', 'Granchio'),
(125, 'Ghiottosa', 'Gamberetti'),
(126, 'Elite', 'Pomodoro'),
(127, 'Elite', 'Mozzarella'),
(128, 'Elite', 'Porcini'),
(129, 'Elite', 'Bresaola'),
(130, 'Elite', 'Radicchio'),
(131, 'Regina', 'Pomodoro'),
(132, 'Regina', 'Bufala'),
(133, 'Regina', 'Crudo di Parma'),
(134, 'Regina', 'Porcini'),
(135, 'Regina', 'Pomodori secchi'),
(136, 'Viziata', 'Mozzarella'),
(137, 'Viziata', 'Polpa di zucca'),
(138, 'Viziata', 'Taleggio'),
(139, 'Viziata', 'Crudo di Parma'),
(140, 'Fantasia', 'Pomodoro'),
(141, 'Fantasia', 'Mozzarella'),
(142, 'Fantasia', 'Stracciatella'),
(143, 'Fantasia', 'Crema di pistacchi'),
(144, 'Fantasia', 'Crema di zucca'),
(145, 'Fantasia', 'Basilico'),
(146, 'Viziosa', 'Focaccia'),
(147, 'Viziosa', 'Burratina'),
(148, 'Viziosa', 'Pesto a gocce'),
(149, 'Viziosa', 'Pomodorini freschi'),
(150, 'Viziosa', 'Basilico'),
(151, 'Riccione', 'Pomodoro'),
(152, 'Riccione', 'Mozzarella'),
(153, 'Riccione', 'Squaquerone'),
(154, 'Riccione', 'Crudo di Parma'),
(155, 'Riccione', 'Rucola'),
(156, 'Valtellina', 'Pomodoro'),
(157, 'Valtellina', 'Mozzarella'),
(158, 'Valtellina', 'Bresaola'),
(159, 'Valtellina', 'Philadelphia'),
(160, 'Valtellina', 'Crema di aceto'),
(161, 'Valtellina', 'Pomodorini freschi'),
(162, 'Gustosa', 'Pomodoro'),
(163, 'Gustosa', 'Pancetta'),
(164, 'Gustosa', 'Gamberetti'),
(165, 'Gustosa', 'Bufala'),
(166, 'Autunnale', 'Pomodoro'),
(167, 'Autunnale', 'Mozzarella'),
(168, 'Autunnale', 'Porcini'),
(169, 'Autunnale', 'Taleggio'),
(170, 'Autunnale', 'Salsiccia'),
(171, 'Marittima', 'Pomodoro'),
(172, 'Marittima', 'Mozzarella'),
(173, 'Marittima', 'Filetti di sgombro'),
(174, 'Marittima', 'Pomodori secchi'),
(175, 'Marittima', 'Salsa verde'),
(176, 'Gioiosa', 'Pomodoro'),
(177, 'Gioiosa', 'Mozzarella'),
(178, 'Gioiosa', 'Gamberetti'),
(179, 'Gioiosa', 'Rucola'),
(180, 'Gioiosa', 'Salsa rosa'),
(181, 'A riccia', 'Pomodoro'),
(182, 'A riccia', 'Mozzarella'),
(183, 'A riccia', 'Pomodori secchi'),
(184, 'A riccia', 'Salsa verde'),
(185, 'Rustica', 'Pomodoro'),
(186, 'Rustica', 'Mozzarella'),
(187, 'Rustica', 'Pomodori secchi'),
(188, 'Rustica', 'Olive taggiasche'),
(189, 'Rustica', 'Crema di aceto'),
(190, 'Rustica', 'Cipolline'),
(191, 'Cremosa', 'Pomodoro'),
(192, 'Cremosa', 'Mozzarella'),
(193, 'Cremosa', 'Burratina'),
(194, 'Cremosa', 'Pomodorini freschi'),
(195, 'Cremosa', 'Basilico'),
(196, 'A riccia', 'Porchetta'),
(197, 'Messicana', 'Mozzarella'),
(198, 'Messicana', 'Mais'),
(199, 'Messicana', 'Fagioli rossi'),
(200, 'Messicana', 'Cipolla di tropea'),
(201, 'Messicana', 'Peperoncino'),
(202, 'Halloween', 'Mozzarella'),
(203, 'Halloween', 'Crema di zucca'),
(204, 'Halloween', 'Zola'),
(205, 'Halloween', 'Basilico'),
(206, 'Calabria', 'Mozzarella'),
(207, 'Calabria', 'Nduja'),
(208, 'Calabria', 'Salsiccia'),
(209, 'Calabria', 'Olive'),
(210, 'Calabria', 'Cipolla di tropea'),
(211, 'Montanara', 'Mozzarella'),
(212, 'Montanara', 'Crema di noci'),
(213, 'Montanara', 'Speck'),
(214, 'Montanara', 'Taleggio'),
(215, 'Sublime', 'Mozzarella'),
(216, 'Sublime', 'Crema di pistacchi'),
(217, 'Sublime', 'Mortadella'),
(218, 'Sublime', 'Crescenza'),
(219, 'Formaggiosa', 'Mozzarella'),
(220, 'Formaggiosa', 'Zola'),
(221, 'Formaggiosa', 'Crescenza'),
(222, 'Formaggiosa', 'Taleggio'),
(223, 'Formaggiosa', 'Grana'),
(224, 'Formaggiosa', 'Provola affumicata'),
(225, 'Muscolosa', 'Mozzarella'),
(226, 'Muscolosa', 'Tonno'),
(227, 'Muscolosa', 'Spinaci'),
(228, 'Muscolosa', 'Bresaola'),
(229, 'Muscolosa', 'Crescenza'),
(230, 'Muscolosa', 'Crema di noci'),
(231, 'Del porto', 'Filetti di tonno'),
(232, 'Del porto', 'Bufala'),
(233, 'Del porto', 'Composto di cipolla rossa'),
(234, 'Del porto', 'Basilico'),
(235, 'Gloriosa', 'Crema di porcini'),
(236, 'Gloriosa', 'Rucola'),
(237, 'Gloriosa', 'Salmone a crudo'),
(238, 'Gloriosa', 'Crescenza'),
(239, 'Gloriosa', 'Olive taggiasche'),
(240, 'Granellosa', 'Crema di zucca'),
(241, 'Granellosa', 'Salsiccia'),
(242, 'Granellosa', 'Stracciatella'),
(243, 'Contadina', 'Provola affumicata'),
(244, 'Contadina', 'Salsiccia punta di coltello'),
(245, 'Contadina', 'Patate'),
(246, 'Contadina', 'Rosmarino'),
(247, 'Pirotecnica', 'Crema di zucca'),
(248, 'Pirotecnica', 'Cipolla caramellata'),
(249, 'Pirotecnica', 'Crema di radicchio'),
(250, 'Pirotecnica', 'Pomodorini freschi'),
(251, 'Pirotecnica', 'Olive taggiasche'),
(252, 'Ficata', 'Taleggio'),
(253, 'Ficata', 'Crudo di Parma'),
(254, 'Ficata', 'Crudo di Parma'),
(255, 'Primavera', 'Pomodorini freschi'),
(256, 'Primavera', 'Philadelphia'),
(257, 'Primavera', 'Crudo di Parma'),
(258, 'Primavera', 'Rucola'),
(259, 'Golosa', 'Pomodoro'),
(260, 'Golosa', 'Zucchine grigliate'),
(261, 'Golosa', 'Gamberetti'),
(262, 'Golosa', 'Bufala'),
(263, 'Golosa', 'Crema di aceto'),
(264, 'Bruschettona', 'Olive taggiasche'),
(265, 'Bruschettona', 'Pomodorini freschi'),
(266, 'Bruschettona', 'Burratina'),
(267, 'Bruschettona', 'Basilico'),
(268, 'Del conte', 'Crema di radicchio'),
(269, 'Del conte', 'Pancetta'),
(270, 'Del conte', 'Porcini'),
(271, 'Zombie', 'Crema di zucca'),
(272, 'Zombie', 'Bacon'),
(273, 'Zombie', 'Bufala'),
(274, 'Zombie', 'Cipolla caramellata'),
(275, 'Adriatica', 'Pomodorini freschi'),
(276, 'Adriatica', 'Gamberetti'),
(277, 'Adriatica', 'Basilico'),
(278, 'Adriatica', 'Pesto a gocce'),
(280, 'Granellosa', 'Granella di pistacchi'),
(281, 'Primavera', 'Glassa di aceto'),
(282, 'Del conte', 'Pepe macinato'),
(283, 'Ficata', 'Crema di fichi');

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
('Anelli di Cipolle', 1, 'Friggitoria', '6.00'),
('Anelli di Totano', 1, 'Friggitoria', '6.00'),
('Chele di Granchio', 1, 'Friggitoria', '6.00'),
('Mozzarelline', 1, 'Friggitoria', '6.00'),
('Olive all Ascolana', 1, 'Friggitoria', '6.00'),
('Patatine', 1, 'Friggitoria', '3.00'),
('Red Hot Jalapenos', 1, 'Friggitoria', '6.00'),
('Triangoli Speck e Patate', 1, 'Friggitoria', '6.00');

-- --------------------------------------------------------

--
-- Struttura della tabella `pizza`
--

DROP TABLE IF EXISTS `pizza`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `NOME` varchar(30) NOT NULL,
  `CLASSE` varchar(30) DEFAULT NULL COMMENT 'foreign key -> Classe',
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

INSERT INTO `pizza` (`NOME`, `CLASSE`) VALUES
('Adriatica', 'Le Pizze Gourmet'),
('Bruschettona', 'Le Pizze Gourmet'),
('Contadina', 'Le Pizze Gourmet'),
('Del conte', 'Le Pizze Gourmet'),
('Del porto', 'Le Pizze Gourmet'),
('Ficata', 'Le Pizze Gourmet'),
('Gloriosa', 'Le Pizze Gourmet'),
('Golosa', 'Le Pizze Gourmet'),
('Granellosa', 'Le Pizze Gourmet'),
('Pirotecnica', 'Le Pizze Gourmet'),
('Primavera', 'Le Pizze Gourmet'),
('Zombie', 'Le Pizze Gourmet'),
('A riccia', 'Le Pizze Scelte Da Voi'),
('Autunnale', 'Le Pizze Scelte Da Voi'),
('Cremosa', 'Le Pizze Scelte Da Voi'),
('Fantasia', 'Le Pizze Scelte Da Voi'),
('Gioiosa', 'Le Pizze Scelte Da Voi'),
('Gustosa', 'Le Pizze Scelte Da Voi'),
('Marittima', 'Le Pizze Scelte Da Voi'),
('Riccione', 'Le Pizze Scelte Da Voi'),
('Rustica', 'Le Pizze Scelte Da Voi'),
('Valtellina', 'Le Pizze Scelte Da Voi'),
('Viziata', 'Le Pizze Scelte Da Voi'),
('Viziosa', 'Le Pizze Scelte Da Voi'),
('Calabria', 'Le Speciali'),
('Formaggiosa', 'Le Speciali'),
('Halloween', 'Le Speciali'),
('Messicana', 'Le Speciali'),
('Montanara', 'Le Speciali'),
('Muscolosa', 'Le Speciali'),
('Sublime', 'Le Speciali'),
('4 Formaggi', 'Le Tradizionali'),
('4 Stagioni', 'Le Tradizionali'),
('Alto Adige', 'Le Tradizionali'),
('Atomica', 'Le Tradizionali'),
('Bismarck', 'Le Tradizionali'),
('Bresaola', 'Le Tradizionali'),
('Bufala', 'Le Tradizionali'),
('Calzone', 'Le Tradizionali'),
('Calzone Farcito', 'Le Tradizionali'),
('Capricciosa', 'Le Tradizionali'),
('Crudo', 'Le Tradizionali'),
('Diavola', 'Le Tradizionali'),
('Elite', 'Le Tradizionali'),
('Frutti di mare', 'Le Tradizionali'),
('Ghiottosa', 'Le Tradizionali'),
('Margherita', 'Le Tradizionali'),
('Napoli', 'Le Tradizionali'),
('Panna e Speck', 'Le Tradizionali'),
('Parmigiana', 'Le Tradizionali'),
('Patate e Wurstel', 'Le Tradizionali'),
('Peperonata', 'Le Tradizionali'),
('Prosciutto', 'Le Tradizionali'),
('Prosciutto e Zola', 'Le Tradizionali'),
('Pugliese', 'Le Tradizionali'),
('Regina', 'Le Tradizionali'),
('Salmonata', 'Le Tradizionali'),
('Salsiccia e Friarielli', 'Le Tradizionali'),
('Siciliana', 'Le Tradizionali'),
('Tonno e Cipolla', 'Le Tradizionali'),
('Vegetariana', 'Le Tradizionali'),
('Wurstel', 'Le Tradizionali');

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
