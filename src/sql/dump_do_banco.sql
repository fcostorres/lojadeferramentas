-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18-Jul-2019 às 15:40
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "-03:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lojadeferramentas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `customer`
--

CREATE TABLE `customer` (
  `customerId` varchar(12) NOT NULL,
  `customerName` varchar(60) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `address` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `customer`
--

INSERT INTO `customer` (`customerId`, `customerName`, `phoneNumber`, `address`) VALUES
('c001', 'Marcos', '01010101011010', 'Cedro'),
('c002', 'Marcelo', '0202022222222', 'Cedro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `employee`
--

CREATE TABLE `employee` (
  `employeeId` varchar(12) NOT NULL,
  `employeeName` varchar(50) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `role` varchar(8) NOT NULL,
  `salary` double(8,2) NOT NULL,
  `userId` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `employee`
--

INSERT INTO `employee` (`employeeId`, `employeeName`, `phoneNumber`, `role`, `salary`, `userId`) VALUES
('e001', 'Samuel', '033333333333', 'Gerente', 12000.00, '00000'),
('e002', 'José Olinda', '88992794594', 'Vendedor', 1500.00, '00000');

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(32) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `removed` timestamp NULL DEFAULT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`userId`, `password`, `created`, `removed`, `status`) VALUES
('e001', '202cb962ac59075b964b07152d234b70', '2019-07-18 13:08:09', NULL, 1),
('e002', '202cb962ac59075b964b07152d234b70', '2019-07-18 13:08:09', NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `product`
--

CREATE TABLE `product` (
  `productId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `productName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `product`
--

INSERT INTO `product` (`productId`, `productName`, `price`, `quantity`) VALUES
(00001, 'Alicate', 30.00, 8),
(00002, 'Martelo', 12.00, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `purchaseinfo`
--

CREATE TABLE `purchaseinfo` (
  `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `userId` varchar(12) NOT NULL,
  `customerId` varchar(12) NOT NULL,
  `productId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `cost` double(12,2) UNSIGNED NOT NULL,
  `amount` int(8) UNSIGNED NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `ùserId_2` (`userId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD PRIMARY KEY (`purchaseId`),
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `userId_2` (`userId`),
  ADD KEY `customerId` (`customerId`),
  ADD KEY `productId` (`productId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  MODIFY `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD CONSTRAINT `purchaseinfo_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `login` (`userId`),
  ADD CONSTRAINT `purchaseinfo_ibfk_2` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`),
  ADD CONSTRAINT `purchaseinfo_ibfk_3` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
