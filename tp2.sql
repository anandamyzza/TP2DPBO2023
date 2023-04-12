-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2023 at 04:58 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tp2`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `name`, `username`, `password`) VALUES
(1, 'Ananda Myzza', 'anandamyzza', 'cicalengka'),
(2, 'as', 'as', 'as');

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE `album` (
  `id_album` int(11) NOT NULL,
  `album_name` varchar(255) NOT NULL,
  `release_year` varchar(255) NOT NULL,
  `artist` int(11) NOT NULL,
  `cover` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`id_album`, `album_name`, `release_year`, `artist`, `cover`) VALUES
(1, 'MULTIVERSES', '2017', 1, 'Feast_-_Multiverses.jpeg'),
(2, 'Lelaku', '2015', 2, '1200x1200bf-60.jpg'),
(3, 'Beberapa Orang Memaafkan', '2018', 1, 'Beberapa_Orang_Memaafkan_Feast.jpg'),
(4, 'Ego & Fungsi Otak', '2018', 2, 'egofungsiotak.jfif'),
(5, 'Dunia Batas', '2012', 3, 'Duniabatas.jpg'),
(7, 'Efek Rumah Kaca', '2007', 4, 'no_cover.jpg'),
(8, 'Rimpang', '2023', 4, 'no_cover.jpg'),
(13, 'Kajian Senja', '2018', 4, 'no_cover.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `id_artist` int(11) NOT NULL,
  `artist_name` varchar(255) NOT NULL,
  `active_from` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `genre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`id_artist`, `artist_name`, `active_from`, `image`, `genre`) VALUES
(1, '.Feast', '2012', '029138800_1608130291-Photo_Profile_.Feast__2_.jpeg', 3),
(2, 'Fourtwnty', '2010', 'f697fd3a-b90a-4711-9ab0-36a979ba35c9_43.jpg', 1),
(3, 'Payun Teduh', '2007', 'ab6761610000e5ebfc58f42abb126bbe177239cf.jfif', 1),
(4, 'Efek Rumah Kaca', '2001', 'ab6761610000e5ebb345ac625dd036d8a8d085cd.jfif', 1),
(5, 'Stephen Sanchez', '2019', 'a0cdfddd286e7e609849f0df6e80a043.jpg', 1),
(7, 'BTS', '2017', 'no_image.png', 7),
(8, 'New Jeans', '2020', 'no_image.png', 1),
(11, 'anandamyzza', '2023', 'Feast_-_Multiverses.jpeg', 6);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id_genre` int(11) NOT NULL,
  `genre_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id_genre`, `genre_name`) VALUES
(1, 'POP'),
(2, 'HIP-HOP'),
(3, 'ROCK'),
(4, 'JAZZ'),
(5, 'CLASSIC'),
(6, 'INDIE'),
(7, 'EDM'),
(8, 'COUNTRY');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id_album`),
  ADD KEY `artist` (`artist`);

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id_artist`),
  ADD KEY `genre` (`genre`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id_genre`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `album`
--
ALTER TABLE `album`
  MODIFY `id_album` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `artist`
--
ALTER TABLE `artist`
  MODIFY `id_artist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `id_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`artist`) REFERENCES `artist` (`id_artist`);

--
-- Constraints for table `artist`
--
ALTER TABLE `artist`
  ADD CONSTRAINT `artist_ibfk_1` FOREIGN KEY (`genre`) REFERENCES `genre` (`id_genre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
