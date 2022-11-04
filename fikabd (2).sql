-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2022 at 03:27 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fikabd`
--

-- --------------------------------------------------------

--
-- Table structure for table `mesa`
--

CREATE TABLE `mesa` (
  `nro_mesa` int(11) NOT NULL,
  `cant_sillas` int(11) DEFAULT NULL,
  `fecha_disponible` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mesa`
--

INSERT INTO `mesa` (`nro_mesa`, `cant_sillas`, `fecha_disponible`) VALUES
(1, 3, '2022-10-16'),
(2, 2, '2022-11-19'),
(3, 4, '2022-11-02'),
(4, 5, '2022-10-19');

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `CATEGORIA` varchar(30) DEFAULT NULL,
  `DESCRIPCION_PRODUCTO` varchar(50) DEFAULT NULL,
  `PRECIO_VTA` int(11) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  `FOTO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`ID`, `NOMBRE`, `CATEGORIA`, `DESCRIPCION_PRODUCTO`, `PRECIO_VTA`, `STOCK`, `FOTO`) VALUES
(1, 'cafe americano', 'bebidas', 'Cafe expresso tradicional americano', 340, 10, 'coffe.png'),
(2, 'avocado toast', 'comida', 'delicioso tostado', 500, 16, 'avocado toast.png'),
(3, 'licuado de arandanos', 'bebidas', 'delisioso licuado', 300, 9, 'licuado arandanos.png'),
(4, 'te frio', 'bebidas', 'delisioso te', 200, 18, 'tefrio.png'),
(5, 'biscochuelo Limon', 'comida', 'Lorem ipsum dolor sit amet cu, nvallis phasellus n', 250, 7, 'biscochueloLimon.png'),
(6, 'cookie chocolate', 'comida', 'si bla convallis phasellus nec mi sagittis arcu', 120, 15, 'cookieChocolate.png'),
(7, 'tarta frutal', 'comida', 'et facilisi blandit pulvinar suscipit, convallis p', 200, 5, 'tartafrutal.png'),
(8, 'torta maldita', 'comida', ' et facil casa papel csa dasd css convallis phasel', 280, 12, 'Torta Maldita.png');

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE `reserva` (
  `nro_reserva` int(11) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`nro_reserva`, `fecha_reserva`, `estado`) VALUES
(1, '2022-10-16', 'ocupado');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`nro_mesa`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`nro_reserva`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `nro_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`nro_reserva`) REFERENCES `mesa` (`nro_mesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
