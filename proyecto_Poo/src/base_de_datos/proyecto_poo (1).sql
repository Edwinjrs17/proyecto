-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2023 a las 22:42:58
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_poo`
--
CREATE DATABASE IF NOT EXISTS `proyecto_poo` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `proyecto_poo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso funcionarios`
--

DROP TABLE IF EXISTS `ingreso funcionarios`;
CREATE TABLE `ingreso funcionarios` (
  `nombre` varchar(100) NOT NULL,
  `celular` int(100) NOT NULL,
  `cedula` int(100) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ingreso funcionarios`
--

INSERT INTO `ingreso funcionarios` (`nombre`, `celular`, `cedula`, `cargo`, `fecha`, `correo`, `contraseña`) VALUES
('camilo andres santiago', 30050061, 8640793, 'Medico', '23/11/2009', 'gubhknjl@hotmail.com', 'vhgbjkl'),
('edwin santiago padilla', 3196583, 1001169217, 'Administrativo', '07/09/2003', 'edwinsant@email.com', 'junior2003');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso pacientes`
--

DROP TABLE IF EXISTS `ingreso pacientes`;
CREATE TABLE `ingreso pacientes` (
  `nombre` varchar(100) NOT NULL,
  `celular` bigint(20) NOT NULL,
  `cedula` int(11) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `control` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ingreso pacientes`
--

INSERT INTO `ingreso pacientes` (`nombre`, `celular`, `cedula`, `fecha`, `direccion`, `correo`, `control`) VALUES
('camilo andres santiago padilla', 30050061, 1001169217, '07/09/2003', 'carrera 42b #88-195', 'edwin.santiago@unisimon.edu.co', 'Medicina General'),
('edwin junior santiago padilla', 30050061, 1001169217, '07/09/2003', 'carrera 42b #88-195', 'edwin.santiago@unisimon.edu.co', 'Medicina General');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ingreso funcionarios`
--
ALTER TABLE `ingreso funcionarios`
  ADD PRIMARY KEY (`nombre`,`celular`,`cedula`,`cargo`,`fecha`,`correo`,`contraseña`);

--
-- Indices de la tabla `ingreso pacientes`
--
ALTER TABLE `ingreso pacientes`
  ADD PRIMARY KEY (`nombre`,`celular`,`cedula`,`fecha`,`direccion`,`correo`,`control`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
