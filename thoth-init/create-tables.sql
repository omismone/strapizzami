-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Creato il: Ago 22, 2022
-- Versione del server: 5.5.62-0ubuntu0.14.04.1
-- Versione PHP: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `THOTH`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Bevanda`
--

USE THOTH;

CREATE TABLE `Bevanda` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(15) NOT NULL,
  `QUANTITA` int(11) NOT NULL COMMENT 'cl',
  `FORMATO` enum('Lattina','Bottiglia','Vetro','Brick') DEFAULT NULL COMMENT 'fomato: lattina, vetro, bottiglia o brick',
  `PREZZO` decimal(10,2) NOT NULL COMMENT 'euro'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `Bevanda`
--

INSERT INTO `Bevanda` (`ID`, `NOME`, `QUANTITA`, `FORMATO`, `PREZZO`) VALUES
(2, 'Coca-Cola', 33, 'Lattina', '2.00'),
(3, 'Fanta', 33, 'Lattina', '2.00'),
(4, 'Sprite', 33, 'Lattina', '2.00'),
(5, 'The', 33, 'Lattina', '2.00'),
(6, 'Birra', 33, 'Vetro', '2.50'),
(7, 'Birra', 50, 'Vetro', '3.00'),
(8, 'Birra', 66, 'Vetro', '3.00'),
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
-- Struttura della tabella `Classe`
--

CREATE TABLE `Classe` (
  `NOME` varchar(30) NOT NULL,
  `DESCRIZIONE` varchar(40) DEFAULT NULL,
  `IMPORTANZA` int(11) DEFAULT NULL COMMENT 'less is more important'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `Classe`
--

INSERT INTO `Classe` (`NOME`, `DESCRIZIONE`, `IMPORTANZA`) VALUES
('Friggitoria', NULL, 100),
('La Pizza della Settimana', NULL, 10),
('Le Pizze Gourmet', NULL, 40),
('Le Pizze Scelte Da Voi', NULL, 50),
('Le Speciali', 'base bianca solo mozzarella', 30),
('Le Tradizionali', NULL, 20);

-- --------------------------------------------------------

--
-- Struttura della tabella `Formato`
--

CREATE TABLE `Formato` (
  `NOME` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `Formato`
--

INSERT INTO `Formato` (`NOME`) VALUES
('Baby'),
('Family'),
('Normal');

-- --------------------------------------------------------

--
-- Struttura della tabella `Ingrediente`
--

CREATE TABLE `Ingrediente` (
  `NOME` varchar(30) NOT NULL,
  `SURGELATO` tinyint(1) DEFAULT NULL COMMENT 'null -> false',
  `PREZZO` decimal(10,2) UNSIGNED DEFAULT NULL COMMENT 'null -> not addable'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `Ingrediente`
--

INSERT INTO `Ingrediente` (`NOME`, `SURGELATO`, `PREZZO`) VALUES
('Acciughe', 0, '1.00'),
('Cinque Pezzi', 0, NULL),
('Mozzarella', 0, '1.00'),
('Origano', 0, '1.00'),
('Pomodoro', 0, '1.00'),
('Sei Pezzi', 0, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `IP`
--

CREATE TABLE `IP` (
  `ID` int(11) NOT NULL,
  `INGREDIENTE` varchar(30) NOT NULL COMMENT 'foreign key -> Ingrediente',
  `PIETANZA` varchar(30) NOT NULL COMMENT 'foreign key -> Pietanza'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `IP`
--

INSERT INTO `IP` (`ID`, `INGREDIENTE`, `PIETANZA`) VALUES
(1, 'Cinque Pezzi', 'Chele di Granchio'),
(2, 'Sei Pezzi', 'Olive all\' Ascolana'),
(3, 'Cinque Pezzi', 'Triangoli Speck e Patate'),
(4, 'Cinque Pezzi', 'Red Hot Jalapenos');

-- --------------------------------------------------------

--
-- Struttura della tabella `PF`
--

CREATE TABLE `PF` (
  `ID` int(11) NOT NULL,
  `PREZZO` decimal(10,2) DEFAULT NULL,
  `PIZZA` varchar(30) NOT NULL COMMENT 'foreign key -> Pizza',
  `FORMATO` varchar(30) NOT NULL COMMENT 'foreign key -> Formato'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `PF`
--

INSERT INTO `PF` (`ID`, `PREZZO`, `PIZZA`, `FORMATO`) VALUES
(1, '3.00', 'Margherita', 'Baby'),
(2, '4.00', 'Margherita', 'Normal'),
(3, '8.00', 'Margherita', 'Family'),
(4, '3.00', 'Napoli', 'Baby'),
(5, '4.50', 'Napoli', 'Normal'),
(6, '8.50', 'Napoli', 'Family');

-- --------------------------------------------------------

--
-- Struttura della tabella `PI`
--

CREATE TABLE `PI` (
  `ID` int(11) NOT NULL,
  `PIZZA` varchar(30) NOT NULL COMMENT 'foreign key -> Pizza',
  `INGREDIENTE` varchar(30) NOT NULL COMMENT 'foreign key -> Ingrediente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `PI`
--

INSERT INTO `PI` (`ID`, `PIZZA`, `INGREDIENTE`) VALUES
(1, 'Margherita', 'Pomodoro'),
(2, 'Margherita', 'Mozzarella'),
(3, 'Napoli', 'Pomodoro'),
(4, 'Napoli', 'Mozzarella'),
(5, 'Napoli', 'Acciughe'),
(6, 'Napoli', 'Origano');

-- --------------------------------------------------------

--
-- Struttura della tabella `Pietanza`
--

CREATE TABLE `Pietanza` (
  `NOME` varchar(30) NOT NULL,
  `SURGELATO` tinyint(1) DEFAULT NULL COMMENT 'null -> false',
  `CLASSE` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `Pietanza`
--

INSERT INTO `Pietanza` (`NOME`, `SURGELATO`, `CLASSE`) VALUES
('Anelli di Cipolle', 1, 'Friggitoria'),
('Anelli di Totano', 1, 'Friggitoria'),
('Chele di Granchio', 1, 'Friggitoria'),
('Mozzarelline', 1, 'Friggitoria'),
('Olive all\' Ascolana', 1, 'Friggitoria'),
('Patatine', 1, 'Friggitoria'),
('Red Hot Jalapenos', 1, 'Friggitoria'),
('Triangoli Speck e Patate', 1, 'Friggitoria');

-- --------------------------------------------------------

--
-- Struttura della tabella `Pizza`
--

CREATE TABLE `Pizza` (
  `NOME` varchar(30) NOT NULL,
  `CLASSE` varchar(30) DEFAULT NULL COMMENT 'foreign key -> Classe'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `Pizza`
--

INSERT INTO `Pizza` (`NOME`, `CLASSE`) VALUES
('Margherita', 'Le Tradizionali'),
('Napoli', 'Le Tradizionali');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Bevanda`
--
ALTER TABLE `Bevanda`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`NOME`);

--
-- Indici per le tabelle `Formato`
--
ALTER TABLE `Formato`
  ADD PRIMARY KEY (`NOME`);

--
-- Indici per le tabelle `Ingrediente`
--
ALTER TABLE `Ingrediente`
  ADD PRIMARY KEY (`NOME`);

--
-- Indici per le tabelle `IP`
--
ALTER TABLE `IP`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IPI` (`INGREDIENTE`),
  ADD KEY `IPP` (`PIETANZA`);

--
-- Indici per le tabelle `PF`
--
ALTER TABLE `PF`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PFP` (`PIZZA`),
  ADD KEY `PFF` (`FORMATO`);

--
-- Indici per le tabelle `PI`
--
ALTER TABLE `PI`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PIP` (`PIZZA`),
  ADD KEY `PII` (`INGREDIENTE`);

--
-- Indici per le tabelle `Pietanza`
--
ALTER TABLE `Pietanza`
  ADD PRIMARY KEY (`NOME`),
  ADD KEY `CP` (`CLASSE`);

--
-- Indici per le tabelle `Pizza`
--
ALTER TABLE `Pizza`
  ADD PRIMARY KEY (`NOME`),
  ADD KEY `PC` (`CLASSE`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Bevanda`
--
ALTER TABLE `Bevanda`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT per la tabella `IP`
--
ALTER TABLE `IP`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `PF`
--
ALTER TABLE `PF`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `PI`
--
ALTER TABLE `PI`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `IP`
--
ALTER TABLE `IP`
  ADD CONSTRAINT `IPP` FOREIGN KEY (`PIETANZA`) REFERENCES `Pietanza` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IPI` FOREIGN KEY (`INGREDIENTE`) REFERENCES `Ingrediente` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `PF`
--
ALTER TABLE `PF`
  ADD CONSTRAINT `PFF` FOREIGN KEY (`FORMATO`) REFERENCES `Formato` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PFP` FOREIGN KEY (`PIZZA`) REFERENCES `Pizza` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `PI`
--
ALTER TABLE `PI`
  ADD CONSTRAINT `PII` FOREIGN KEY (`INGREDIENTE`) REFERENCES `Ingrediente` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PIP` FOREIGN KEY (`PIZZA`) REFERENCES `Pizza` (`NOME`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `Pietanza`
--
ALTER TABLE `Pietanza`
  ADD CONSTRAINT `CP` FOREIGN KEY (`CLASSE`) REFERENCES `Classe` (`NOME`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `Pizza`
--
ALTER TABLE `Pizza`
  ADD CONSTRAINT `PC` FOREIGN KEY (`CLASSE`) REFERENCES `Classe` (`NOME`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
