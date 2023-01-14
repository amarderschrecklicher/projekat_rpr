-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql7.freemysqlhosting.net
-- Generation Time: Jan 14, 2023 at 05:08 PM
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
(2, 'Doso Otiso', 5, '061444', 'Germany');

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
(23, 'djenka onka', '0611', 'onka@hotmail.com');

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
(10, 1, 1, 1, 3, 1, 120, 'Vogosca', 'Garden Home', 'Villa'),
(6, 0, 20, 7, 2, 1, 80, 'Vogosca, Bosna', 'Sunce', 'Hotel'),
(6, 0, 20, 8, 2, 1, 80, 'Vogosca, Bosna', 'Sunce', 'Hotel'),
(6, 0, 20, 9, 2, 1, 80, 'Vogosca, Bosna', 'Sunce', 'Hotel'),
(1, 0, 1, 10, 1, 1, 250, 'negjde, ovjde', 'nova', 'nova1'),
(1, 0, 1, 11, 1, 1, 250, 'negjde, ovjde', 'nova', 'nova1');

-- --------------------------------------------------------

--
-- Table structure for table `Reservations`
--

CREATE TABLE `Reservations` (
  `idReservationss` int(11) NOT NULL,
  `GuestID` int(11) NOT NULL,
  `PropertyID` int(11) NOT NULL,
  `ReservationDate` date NOT NULL,
  `DateIn` date NOT NULL,
  `DateOut` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Reservations`
--

INSERT INTO `Reservations` (`idReservationss`, `GuestID`, `PropertyID`, `ReservationDate`, `DateIn`, `DateOut`) VALUES
(3, 2, 1, '2023-01-01', '2023-01-07', '2023-01-14');

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
  ADD KEY `HostId` (`HostId`) USING BTREE;

--
-- Indexes for table `Reservations`
--
ALTER TABLE `Reservations`
  ADD PRIMARY KEY (`idReservationss`),
  ADD UNIQUE KEY `GuestID` (`GuestID`),
  ADD UNIQUE KEY `PropertyID` (`PropertyID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Guest`
--
ALTER TABLE `Guest`
  MODIFY `idGuest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Host`
--
ALTER TABLE `Host`
  MODIFY `idHost` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `Property`
--
ALTER TABLE `Property`
  MODIFY `PropertyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
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
  ADD CONSTRAINT `Reservations_ibfk_2` FOREIGN KEY (`PropertyID`) REFERENCES `Property` (`PropertyID`),
  ADD CONSTRAINT `Reservations_ibfk_1` FOREIGN KEY (`GuestID`) REFERENCES `Guest` (`idGuest`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
