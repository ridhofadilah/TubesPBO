-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2017 at 07:12 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Username` varchar(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Sec_Q` varchar(50) NOT NULL,
  `Answer` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Username`, `Name`, `Password`, `Sec_Q`, `Answer`) VALUES
('a', 'asd', 'as', 'Siapa nama ayahmu?', 'sas'),
('asd', 'adsa', 'asd', 'Siapa nama ayahmu?', 'asd'),
('hanif', 'hanif', '12345', 'Siapa nama ayahmu?', 'sahid'),
('hanif salafi', 'hanifsalafi', 'aewq', 'Siapa nama ayahmu?', 'sahid'),
('hanifsss', 'sds', '12', 'Siapa nama ayahmu?', 'sas'),
('sd', 'asd', 'das', 'Siapa nama ayahmu?', 'sad'),
('sss', 'sadss', 'sss', 'Siapa nama ayahmu?', 'sss');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `Id_Barang` varchar(10) NOT NULL,
  `Nama_Barang` varchar(30) NOT NULL,
  `Stok` int(5) NOT NULL,
  `Harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`Id_Barang`, `Nama_Barang`, `Stok`, `Harga`) VALUES
('100', 'baju renang', 1, 10000),
('1002', 'baju', 1122, 1111),
('1003', '1', 1, 1),
('1004', '213', 12, 12),
('1005', '21', 12, 12),
('1006', '12', 12, 1221),
('1007', '12', 12, 12),
('1008', '12', 2112, 12),
('1009', 'ewqae', 1, 1),
('1010', '11', 1, 1),
('1011', 'chitos', 5, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id_Pelanggan` varchar(10) NOT NULL,
  `Nama_Pelanggan` varchar(30) NOT NULL,
  `Jenis_Kelamin` varchar(10) NOT NULL,
  `Jumlah_Belanja` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id_Pelanggan`, `Nama_Pelanggan`, `Jenis_Kelamin`, `Jumlah_Belanja`) VALUES
('1000', 'hanif salafi', 'Laki-Laki', 10),
('1001', 'asd', 'Laki-Laki', 0),
('1002', '1222', 'Laki-Laki', 0),
('1003', 'hanifsa', 'Laki-Laki', 0),
('1004', 'dsa', 'Laki-Laki', 0),
('1005', 'asdasd', 'Laki-Laki', 0),
('1006', 'qweqw', 'Laki-Laki', 0),
('1007', 'qweqwe', 'Laki-Laki', 0),
('1008', '23232', 'Laki-Laki', 0),
('1009', '12312', 'Laki-Laki', 0),
('1010', '1231231', 'Laki-Laki', 0),
('1011', 'sadasd', 'Laki-Laki', 0),
('1012', '2122', 'Laki-Laki', 0),
('1013', 'sdasda', 'Laki-Laki', 0);

-- --------------------------------------------------------

--
-- Table structure for table `detiltransaksi`
--

CREATE TABLE `detiltransaksi` (
  `KodeTransaksi` varchar(10) NOT NULL,
  `Id_Barang` varchar(10) NOT NULL,
  `Nota` varchar(10) NOT NULL,
  `Jumlah` int(10) NOT NULL,
  `Total_Harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detiltransaksi`
--

INSERT INTO `detiltransaksi` (`KodeTransaksi`, `Id_Barang`, `Nota`, `Jumlah`, `Total_Harga`) VALUES
('1', '1011', '12248', 1, 10000),
('1111', '100', '12222', 2, 0),
('1112', '1004', '12222', 3, 0),
('1113', '1011', '12222', 4, 0),
('120', '100', '12287', 1, 10000),
('124', '1011', '12268', 1, 10000),
('155', '1011', '12272', 2, 20000),
('186', '1011', '12289', 5, 50000),
('201', '100', '12296', 3, 30000),
('260', '100', '12294', 6, 60000),
('262', '1011', '12258', 2, 20000),
('263', '1011', '12264', 1, 10000),
('275', '1011', '12254', 8, 80000),
('3', '1011', '12250', 1, 20000),
('316', '1011', '12280', 5, 50000),
('370', '1011', '12260', 2, 20000),
('379', '1011', '12259', 1, 10000),
('4', '1011', '12252', 2, 20000),
('407', '100', '12295', 4, 40000),
('412', '100', '12277', 2, 20000),
('437', '100', '12272', 2, 20000),
('439', '1011', '12263', 2, 20000),
('447', '1011', '12269', 1, 10000),
('449', '100', '12283', 3, 30000),
('510', '100', '12275', 3, 30000),
('526', '100', '12284', 2, 20000),
('527', '1011', '12273', 2, 20000),
('530', '1011', '12273', 8, 80000),
('581', '1011', '12255', 1, 10000),
('583', '1011', '12274', 2, 20000),
('60', '100', '12291', 8, 80000),
('601', '1011', '12294', 2, 20000),
('610', '1011', '12282', 2, 20000),
('612', '100', '12297', 3, 30000),
('618', '100', '12290', 4, 40000),
('620', '100', '12280', 3, 30000),
('63', '1011', '12261', 1, 10000),
('68', '1011', '12271', 1, 10000),
('687', '100', '12289', 2, 20000),
('699', '1011', '12276', 8, 80000),
('708', '1011', '12290', 2, 20000),
('716', '1011', '12266', 1, 10000),
('730', '100', '12276', 2, 20000),
('731', '1011', '12257', 2, 20000),
('781', '1011', '12267', 2, 20000),
('800', '100', '12293', 2, 20000),
('807', '1011', '12276', 3, 30000),
('833', '1011', '12292', 3, 30000),
('842', '1011', '12270', 3, 30000),
('885', '1011', '12262', 2, 20000),
('888', '1011', '12265', 1, 10000),
('892', '1011', '12281', 3, 30000),
('925', '100', '12292', 1, 10000),
('928', '100', '12278', 2, 20000),
('945', '100', '12286', 1, 10000),
('95', '1011', '12253', 1, 10000),
('956', '100', '12279', 2, 20000),
('962', '100', '12285', 1, 10000),
('987', '100', '12288', 1, 10000),
('997', '100', '12298', 3, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `Nota` varchar(10) NOT NULL,
  `Tanggal` date NOT NULL,
  `Id_Pelanggan` varchar(10) NOT NULL,
  `Total_Bayar` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`Nota`, `Tanggal`, `Id_Pelanggan`, `Total_Bayar`) VALUES
('12222', '2017-04-04', '1000', 4),
('12223', '2017-04-04', '1000', 7),
('12224', '2017-04-04', '1000', 4),
('12225', '2017-04-04', '1000', 5),
('12226', '2017-04-04', '1000', 7854),
('12227', '2017-03-03', '1000', 3366),
('12228', '2017-04-04', '1004', 6732),
('12229', '2017-04-04', '1004', 40000),
('12230', '2017-04-04', '1004', 20000),
('12231', '2017-04-04', '1004', 30000),
('12232', '2017-04-04', '1004', 50000),
('12233', '2017-04-04', '1004', 10000),
('12234', '2017-04-04', '1004', 20000),
('12235', '2017-04-04', '1004', 5),
('12236', '2017-04-04', '1004', 30000),
('12237', '2017-04-04', '1004', 4),
('12238', '2017-04-04', '1004', 20000),
('12239', '2017-04-04', '1004', 20000),
('12240', '2017-04-04', '1004', 3),
('12241', '2017-04-04', '1004', 20000),
('12242', '2017-10-10', '1003', 80000),
('12243', '2017-12-12', '1003', 20000),
('12244', '2017-03-03', '1003', 30000),
('12245', '2017-06-06', '1003', 0),
('12246', '2018-04-04', '1001', 0),
('12247', '2017-03-03', '1001', 0),
('12248', '2017-09-09', '1001', 0),
('12249', '2017-04-04', '1001', 0),
('12250', '2017-04-04', '1001', 0),
('12251', '2017-04-04', '1001', 0),
('12252', '2017-04-04', '1001', 0),
('12253', '2018-03-03', '1001', 0),
('12254', '2017-04-04', '1001', 0),
('12255', '2017-09-09', '1001', 0),
('12256', '2017-04-04', '1001', 0),
('12257', '2017-04-04', '1001', 0),
('12258', '2016-04-04', '1001', 0),
('12259', '2018-04-04', '1001', 0),
('12260', '2013-03-02', '1003', 0),
('12261', '2017-04-05', '1001', 0),
('12262', '2017-04-04', '1001', 0),
('12263', '2018-04-04', '1001', 0),
('12264', '2018-04-04', '1001', 0),
('12265', '2017-04-04', '1001', 0),
('12266', '2017-04-04', '1001', 0),
('12267', '2017-04-04', '1001', 0),
('12268', '2017-04-04', '1001', 0),
('12269', '2018-04-04', '1001', 0),
('12270', '2018-04-04', '1001', 0),
('12271', '2017-04-03', '1001', 0),
('12272', '2018-03-04', '1001', 4),
('12273', '2017-04-04', '1001', 40000),
('12274', '2014-04-04', '1001', 0),
('12275', '2019-02-02', '1001', 0),
('12276', '2019-03-03', '1001', 0),
('12277', '2017-04-04', '1001', 0),
('12278', '2013-03-03', '1001', 0),
('12279', '2019-02-02', '1001', 0),
('12280', '2011-03-03', '1001', 0),
('12281', '2019-02-02', '1001', 0),
('12282', '2017-04-04', '1001', 0),
('12283', '2019-09-09', '1001', 0),
('12284', '2012-02-02', '1001', 0),
('12285', '2012-09-09', '1001', 0),
('12286', '2018-03-03', '1001', 0),
('12287', '2019-09-09', '1001', 0),
('12288', '2018-09-09', '1001', 0),
('12289', '2019-09-09', '1001', 40000),
('12290', '2018-09-09', '1001', 60000),
('12291', '2019-02-02', '1001', 80000),
('12292', '2019-09-09', '1001', 40000),
('12293', '1222-00-00', '1001', 20000),
('12294', '2019-09-09', '1001', 80000),
('12295', '2019-09-09', '1001', 40000),
('12296', '2019-09-09', '1003', 30000),
('12297', '2019-09-09', '1001', 30000),
('12298', '2010-09-09', '1001', 30000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`Id_Barang`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id_Pelanggan`),
  ADD UNIQUE KEY `Nama` (`Nama_Pelanggan`);

--
-- Indexes for table `detiltransaksi`
--
ALTER TABLE `detiltransaksi`
  ADD PRIMARY KEY (`KodeTransaksi`),
  ADD KEY `Nota` (`Nota`),
  ADD KEY `Id_Barang` (`Id_Barang`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`Nota`),
  ADD KEY `Id_Pelanggan` (`Id_Pelanggan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detiltransaksi`
--
ALTER TABLE `detiltransaksi`
  ADD CONSTRAINT `detiltransaksi_ibfk_1` FOREIGN KEY (`Nota`) REFERENCES `transaksi` (`Nota`),
  ADD CONSTRAINT `detiltransaksi_ibfk_2` FOREIGN KEY (`Id_Barang`) REFERENCES `barang` (`Id_Barang`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`Id_Pelanggan`) REFERENCES `customer` (`Id_Pelanggan`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
