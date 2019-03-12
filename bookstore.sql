-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hostiteľ: 127.0.0.1
-- Čas generovania: Út 12.Mar 2019, 19:39
-- Verzia serveru: 10.1.28-MariaDB
-- Verzia PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáza: `bookstore`
--

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `author`
--

CREATE TABLE `author` (
  `idauthor` int(11) NOT NULL,
  `firstname` varchar(25) COLLATE utf8_slovak_ci NOT NULL,
  `lastname` varchar(25) COLLATE utf8_slovak_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;

--
-- Sťahujem dáta pre tabuľku `author`
--

INSERT INTO `author` (`idauthor`, `firstname`, `lastname`) VALUES
(1, 'Jan', 'Botto'),
(2, 'Wiliam', 'Shakespeare'),
(3, 'Herbert', 'Schildt');

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `book`
--

CREATE TABLE `book` (
  `idbook` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_slovak_ci NOT NULL,
  `isbn` varchar(20) COLLATE utf8_slovak_ci NOT NULL,
  `idauthor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;

--
-- Sťahujem dáta pre tabuľku `book`
--

INSERT INTO `book` (`idbook`, `title`, `isbn`, `idauthor`) VALUES
(1, 'Smrt Jánošíkova', '12345678998', 1),
(2, 'Žltá Lalija', '9780132764094', 1),
(3, 'Cachtická pani', '456123789123', 1),
(6, 'Romeo a Júlia', '805510901X', 2),
(7, 'Hamlet', '8055113327', 2),
(8, 'Richard III.', '9788055159454', 2),
(9, 'Macbeth', '9780007350988', 2),
(10, 'Java: The Complete Reference (10th Edition)\r\n', '1259589331', 3),
(11, 'Java 8', '9788025146651', 3);

--
-- Kľúče pre exportované tabuľky
--

--
-- Indexy pre tabuľku `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`idauthor`),
  ADD UNIQUE KEY `idauthor_UNIQUE` (`idauthor`);

--
-- Indexy pre tabuľku `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`idbook`),
  ADD UNIQUE KEY `idbook_UNIQUE` (`idbook`),
  ADD KEY `fk_book_author_idx` (`idauthor`);

--
-- AUTO_INCREMENT pre exportované tabuľky
--

--
-- AUTO_INCREMENT pre tabuľku `author`
--
ALTER TABLE `author`
  MODIFY `idauthor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pre tabuľku `book`
--
ALTER TABLE `book`
  MODIFY `idbook` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Obmedzenie pre exportované tabuľky
--

--
-- Obmedzenie pre tabuľku `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `fk_book_author` FOREIGN KEY (`idauthor`) REFERENCES `author` (`idauthor`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
