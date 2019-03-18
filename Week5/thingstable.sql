-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Mar 17, 2019 at 9:12 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `beautifulthings`
--

-- --------------------------------------------------------

--
-- Table structure for table `thingstable`
--

CREATE TABLE `thingstable` (
  `id` int(11) NOT NULL,
  `thing_title` varchar(50) NOT NULL,
  `thing_description` text NOT NULL,
  `thing_value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thingstable`
--

INSERT INTO `thingstable` (`id`, `thing_title`, `thing_description`, `thing_value`) VALUES
(1, 'flowers', 'flowers in the spring time make me happy', 9),
(2, 'choclate', 'who wouldn\'t love a chocolate bar?', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `thingstable`
--
ALTER TABLE `thingstable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thingstable`
--
ALTER TABLE `thingstable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
