-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 24, 2015 at 04:31 PM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `crossoverfed`
--

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `ordernum` int(11) NOT NULL,
  `dateoforder` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ordernum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ordernum`, `dateoforder`, `name`, `value`) VALUES
(1, '2015-03-12', 'Oswaldo', '12000'),
(2, '2015-06-23', 'Mao', '10000'),
(3, '2015-07-13', 'Test', '1000'),
(4, '2015-06-14', 'Angeline', '1500'),
(5, '2015-07-18', 'Angeline', '6000'),
(6, '2015-05-12', 'Gerardo', '5000'),
(7, '2015-07-18', 'Gerardo', '2000'),
(8, '2015-03-12', 'Nikki', '2000');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `sessionId` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `pass`, `sessionId`, `uname`) VALUES
('1', 'Oswaldo', 'AF59A88FC2F796C9F22C0D5D0F93B9DE', 'Oswaldo'),
('2', 'Mao', '', 'Mao'),
('3', 'Angeline', '8787FC46AE15A82E6354577DB56C4CC1', 'Angeline'),
('4', 'Gerardo', '', 'Gerardo'),
('5', 'Niki', '', 'Niki'),
('6', 'Test', '', 'Test');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
