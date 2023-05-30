-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2023 a las 03:15:24
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso funcionarios`
--

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
('andres felipe santiago', 367889, 45678, '06/10/2004', 'carrera 22b #26-76', 'andres.santiago@hotmail.com', 'Fisioterapia'),
('camilo andres santiago ', 45678907, 43657687, '23/11/2009', 'carrera 22b #26-76', 'camilo@gmail.com', 'Nefrologia'),
('edwin junior santiago padilla', 30050061, 1001169217, '07/09/2003', 'carrera 42b #88-195', 'edwin.santiago@unisimon.edu.co', 'Cardiologia'),
('edwin santiago estrada', 30050061, 8649793, '21/09/1974', 'carrera 42b #88-195', 'edwincont@hotmail.com', 'Medicina General');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `Cedula` int(20) NOT NULL,
  `Dia` varchar(5) NOT NULL,
  `Mes` varchar(5) NOT NULL,
  `Año` varchar(5) NOT NULL,
  `Hora` varchar(6) NOT NULL,
  `Doctor` varchar(25) NOT NULL,
  `Area Medica` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`Cedula`, `Dia`, `Mes`, `Año`, `Hora`, `Doctor`, `Area Medica`) VALUES
(12, '1', '1', '1', '1', 'Dr Angel Castillo', 'Medicina General'),
(45, '45', '55', '66', '77', 'Dr Edwin Santiago', 'Odontologia'),
(74, '45', '55', '6644', '44', 'Dr Andres Santiago ', 'Odontologia'),
(1222, '144', '878', '6644', '5454', 'Dr Andres Santiago ', 'Citologia'),
(1001169217, '07', '06', '2023', '5:35', 'Dr Edwin Santiago', 'Medicina General');

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

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`Cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `Cedula` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1001169218;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
