-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2021 at 10:59 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtaisan`
--

-- --------------------------------------------------------

--
-- Table structure for table `taisan`
--

CREATE TABLE `taisan` (
  `Ma` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Ten` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayNhap` datetime NOT NULL,
  `SoNamKhauHao` int(11) NOT NULL,
  `GiaTri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `taisan`
--

INSERT INTO `taisan` (`Ma`, `Ten`, `NgayNhap`, `SoNamKhauHao`, `GiaTri`) VALUES
('ts1', 'Máy khoan', '2021-07-22 10:48:04', 5, 10),
('ts2', 'Máy gặt', '2021-07-13 15:48:04', 4, 12),
('ts3', 'Máy hút bụi', '2021-07-13 14:53:36', 2, 5),
('ts4', 'Máy điều hòa', '2021-07-02 15:52:31', 7, 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `taisan`
--
ALTER TABLE `taisan`
  ADD PRIMARY KEY (`Ma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
