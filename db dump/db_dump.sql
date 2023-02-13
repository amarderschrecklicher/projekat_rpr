-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql7.freemysqlhosting.net
-- Generation Time: Feb 13, 2023 at 07:18 AM
-- Server version: 5.5.62-0ubuntu0.14.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql7583417`
--
CREATE DATABASE IF NOT EXISTS `sql7583417` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sql7583417`;

-- --------------------------------------------------------

--
-- Table structure for table `Guest`
--

CREATE TABLE `Guest` (
  `idGuest` int(11) NOT NULL,
  `GuestName` varchar(45) NOT NULL,
  `NumberOfGuests` int(11) NOT NULL,
  `GuestNumber` varchar(45) NOT NULL,
  `GuestCountry` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Guest`
--

INSERT INTO `Guest` (`idGuest`, `GuestName`, `NumberOfGuests`, `GuestNumber`, `GuestCountry`) VALUES
(0, 'available', 0, '0', 'o'),
(3, 'Stefan', 12, '0617777', 'Serbia');

-- --------------------------------------------------------

--
-- Table structure for table `Host`
--

CREATE TABLE `Host` (
  `idHost` int(11) NOT NULL,
  `HostName` varchar(50) NOT NULL,
  `HostNumber` varchar(10) NOT NULL,
  `Mail` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Host`
--

INSERT INTO `Host` (`idHost`, `HostName`, `HostNumber`, `Mail`) VALUES
(1, 'Amar Tahirovic', '0613333', 'amar@gmail.com'),
(4, 'eman mane', '061555', 'emanmane@hotmail.com'),
(5, 'benjo  njobe', '061222', 'benjonjobe@gmail.com'),
(7, 'dalila lila', '061777', 'dalila@gmai.com'),
(11, 'medin dinme', '061999', 'medin@gmail.com'),
(15, 'p t', '06', 'p@gmail.com'),
(20, 'andrew tate', 't8', 't8@gmail.com'),
(21, 'novi nov', '060', 'novi@gmail.com'),
(22, 'ada dzanko', '06999', 'ada@gmail.com'),
(23, 'djenka onka', '0611', 'onka@hotmail.com'),
(24, ' ', '', ''),
(25, 'Niko Nikic', '0617777', 'nikok@gmail.com'),
(26, 'Niko Nikic', '0618888', 'nikok@gmail.com'),
(27, 'Niko Nikic', '0619999', 'nikok@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `Property`
--

CREATE TABLE `Property` (
  `Capacity` int(11) NOT NULL,
  `Heating_AC` tinyint(4) NOT NULL,
  `HostId` int(11) NOT NULL,
  `PropertyID` int(11) NOT NULL,
  `NmbOfBathrooms` int(11) NOT NULL,
  `NmbOfKitchens` int(11) NOT NULL,
  `PricePerNight` double NOT NULL,
  `PropertyLocation` varchar(255) NOT NULL,
  `PropertyName` varchar(45) NOT NULL,
  `PropertyType` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Property`
--

INSERT INTO `Property` (`Capacity`, `Heating_AC`, `HostId`, `PropertyID`, `NmbOfBathrooms`, `NmbOfKitchens`, `PricePerNight`, `PropertyLocation`, `PropertyName`, `PropertyType`) VALUES
(1, 0, 20, 3, 1, 1, 325, 'rffsa, cs', 'hljeb', 'opa'),
(1, 0, 20, 5, 1, 1, 132, 'jjd, rrr', 'halooo', 'brat moj'),
(1, 0, 20, 6, 1, 1, 123, 'aa, dda', 'aa', 'dsadd'),
(1, 0, 1, 14, 1, 1, 150, 'Sarajevo, BiH', 'Garden', 'House'),
(5, 0, 1, 15, 2, 1, 70, 'Mostar, Bih', 'Sun', 'Apartment'),
(10, 1, 1, 16, 2, 2, 200, 'Ilidza, BiH', 'PoolVilla', 'Villa'),
(2, 0, 27, 17, 1, 1, 50, 'Bihac, Bih', 'Novi', 'Apartment'),
(5, 0, 1, 18, 2, 2, 210, 'Miami, Florida', 'New', 'House'),
(1, 0, 20, 19, 1, 1, 2, 'as, ss', 'ds', 'asdaaa'),
(1, 0, 20, 20, 1, 1, 21, 'ad, aa', 'eas', 'ads'),
(1, 0, 20, 21, 1, 1, 21, 'ae, asd', 'dsdc', 'asda'),
(1, 0, 20, 22, 1, 1, 2, 'c, a', 'dsp', 'aa'),
(1, 0, 20, 23, 1, 1, 2, 'v, c', 'vv', 'c'),
(1, 0, 20, 24, 1, 1, 2, 'c, d', 'a', 'b'),
(1, 0, 20, 25, 1, 1, 2, 'as, d', 'sas', 'as');

-- --------------------------------------------------------

--
-- Table structure for table `Reservations`
--

CREATE TABLE `Reservations` (
  `idReservations` int(11) NOT NULL,
  `DateIn` date NOT NULL,
  `DateOut` date NOT NULL,
  `GuestID` int(11) NOT NULL,
  `PropertyID` int(11) NOT NULL,
  `ReservationDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Reservations`
--

INSERT INTO `Reservations` (`idReservations`, `DateIn`, `DateOut`, `GuestID`, `PropertyID`, `ReservationDate`) VALUES
(3, '2023-02-21', '2023-02-28', 3, 3, '2023-02-12'),
(6, '2023-03-15', '2023-03-22', 3, 3, '2023-02-12'),
(8, '2023-02-22', '2023-03-08', 0, 15, '2023-02-13'),
(9, '2023-02-22', '2023-03-02', 0, 16, '2023-02-13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Guest`
--
ALTER TABLE `Guest`
  ADD PRIMARY KEY (`idGuest`);

--
-- Indexes for table `Host`
--
ALTER TABLE `Host`
  ADD PRIMARY KEY (`idHost`);

--
-- Indexes for table `Property`
--
ALTER TABLE `Property`
  ADD PRIMARY KEY (`PropertyID`) USING BTREE,
  ADD UNIQUE KEY `PropertyLocation_UNIQUE` (`PropertyLocation`),
  ADD KEY `HostId` (`HostId`) USING BTREE;

--
-- Indexes for table `Reservations`
--
ALTER TABLE `Reservations`
  ADD PRIMARY KEY (`idReservations`),
  ADD KEY `GuestID` (`GuestID`) USING BTREE,
  ADD KEY `PropertyID` (`PropertyID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Guest`
--
ALTER TABLE `Guest`
  MODIFY `idGuest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Host`
--
ALTER TABLE `Host`
  MODIFY `idHost` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `Property`
--
ALTER TABLE `Property`
  MODIFY `PropertyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `Reservations`
--
ALTER TABLE `Reservations`
  MODIFY `idReservations` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Property`
--
ALTER TABLE `Property`
  ADD CONSTRAINT `Property_ibfk_1` FOREIGN KEY (`HostId`) REFERENCES `Host` (`idHost`);

--
-- Constraints for table `Reservations`
--
ALTER TABLE `Reservations`
  ADD CONSTRAINT `Reservations_ibfk_1` FOREIGN KEY (`GuestID`) REFERENCES `Guest` (`idGuest`),
  ADD CONSTRAINT `Reservations_ibfk_2` FOREIGN KEY (`PropertyID`) REFERENCES `Property` (`PropertyID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
