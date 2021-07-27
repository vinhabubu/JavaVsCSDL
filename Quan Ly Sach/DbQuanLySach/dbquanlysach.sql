-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2021 at 07:46 AM
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
-- Database: `dbquanlysach`
--

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNhaXuatBan` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenNhaXuatBan` text COLLATE utf8_vietnamese_ci NOT NULL,
  `DiaChi` text COLLATE utf8_vietnamese_ci NOT NULL,
  `SoDienThoai` text COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNhaXuatBan`, `TenNhaXuatBan`, `DiaChi`, `SoDienThoai`) VALUES
('nxb1', 'Kim Đồng', 'Hà Nội', '0972123456'),
('nxb11', ' Đại học Quốc gia thành phố Hồ Chí Minh', 'Hồ Chí Minh', '0989127456'),
('nxb12', 'Đại học Huế', 'Huế', '0972190456'),
('nxb13', ' Đại học Thái Nguyên', 'Thái Nguyên', '0972123886'),
('nxb14', 'Hà Nội', 'Hà Nội', '0989333456'),
('nxb15', 'Sài Gòn', 'Hồ Chí Minh', '0976123456'),
('nxb16', 'Abubu', 'Hà Nội', '0983123456'),
('nxb2', 'Chính trị Quốc gia', 'Hải Phòng', '0972126456'),
('nxb3', 'Thanh niên', 'Nam Định', '0989123456'),
('nxb4', 'Lao động', 'Ninh Bình', '0972128456'),
('nxb5', 'Công an nhân dân', 'Hà Nội', '0972128477'),
('nxb6', 'Khoa học xã hội', 'Hải Dương', '0972773456'),
('nxb7', 'Khoa học và kỹ thuật', 'Hồ Chí Minh', '0989166456'),
('nxb8', 'Khoa học tự nhiên và Công nghệ', 'Đà Nẵng', '0990123456'),
('nxb9', 'Thể dục thể thao', 'Huế', '0972125556');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenSach` text COLLATE utf8_vietnamese_ci NOT NULL,
  `MaNhaXuatBan` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `SoTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `MaNhaXuatBan`, `SoTrang`) VALUES
('s1', 'Tôi tài giỏi, bạn cũng thế ', ' nxb1', 120),
('s10', ' Đọc vị bất kì ai – Để không bị lừa dối và lợi dụng', 'nxb6', 550),
('s11', 'Cuộc đời của Pi ', 'nxb5', 780),
('s12', 'Những Người Đàn Ông Không Có Đàn Bà', 'nxb4', 920),
('s13', 'Cuốn sách tâm lý học tình yêu', 'nxb3', 570),
('s14', 'Đàn ông đến từ sao Hỏa – Đàn bà đến từ sao Kim', 'nxb2', 880),
('s2', 'Đắc nhân tâm', 'nxb14', 140),
('s3', ' Tội ác và trừng phạt', 'nxb13', 120),
('s4', 'Nhà giả kim ', 'nxb12', 200),
('s5', ' Bắt trẻ đồng xanh ', 'nxb11', 150),
('s6', 'Xách ba lô lên và đi', 'nxb10', 400),
('s7', 'Cứ đi rồi sẽ đến', 'nxb9', 300),
('s8', '7 thói quen để thành đạt', 'nxb8', 1023),
('s9', 'Thép đã tôi thế đấy', 'nxb7', 479);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`MaNhaXuatBan`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
