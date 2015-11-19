-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-11-2015 a las 06:56:55
-- Versión del servidor: 5.6.11
-- Versión de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gruposinvestigacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `idarticulo` int(11) NOT NULL,
  `anio_publicacion` date NOT NULL,
  `nombre_articulo` varchar(45) NOT NULL,
  `revista_idrevista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `ideditorial` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estdo_investigador`
--

CREATE TABLE `estdo_investigador` (
  `idestdo_Investigador` int(11) NOT NULL,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `idevento` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `lugar_realizacion` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `caracter` varchar(45) NOT NULL,
  `tipo_evento_idtipo_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formacion_academica`
--

CREATE TABLE `formacion_academica` (
  `idformacion_academica` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `anio_inicio` date NOT NULL,
  `anio_finalizacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `group_`
--

CREATE TABLE `group_` (
  `groupId` varchar(100) NOT NULL,
  `userId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `group_`
--

INSERT INTO `group_` (`groupId`, `userId`) VALUES
('admin', 'andresm'),
('investigador', 'andresm'),
('investigador', 'carmenh'),
('investigador', 'fernandat'),
('investigador', 'jhonm'),
('investigador', 'juanc'),
('investigador', 'julianr');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos_investigacion`
--

CREATE TABLE `grupos_investigacion` (
  `idgrupos_investigacion` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `linea_investigacion` varchar(45) NOT NULL,
  `tipo_categoria_idtipo_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `grupos_investigacion`
--

INSERT INTO `grupos_investigacion` (`idgrupos_investigacion`, `nombre`, `linea_investigacion`, `tipo_categoria_idtipo_categoria`) VALUES
(1, 'IngSoft', 'Desarrollo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigador`
--

CREATE TABLE `investigador` (
  `cedula` int(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `estdo_investigador_idestdo_Investigador` int(11) NOT NULL,
  `formacion_academica_idformacion_academica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigador_has_articulo`
--

CREATE TABLE `investigador_has_articulo` (
  `investigador_cedula` int(11) NOT NULL,
  `articulo_idarticulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigador_has_grupos_investigacion`
--

CREATE TABLE `investigador_has_grupos_investigacion` (
  `investigador_cedula` int(11) NOT NULL,
  `grupos_investigacion_idgrupos_investigacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idlibros` int(11) NOT NULL,
  `anio_publicacion` date NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `editorial_ideditorial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_has_investigador`
--

CREATE TABLE `libro_has_investigador` (
  `libro_idlibros` int(11) NOT NULL,
  `investigador_cedula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ponencias`
--

CREATE TABLE `ponencias` (
  `idponencias` int(11) NOT NULL,
  `fecha_realizado` date NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `evento_idevento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ponencias_has_investigador`
--

CREATE TABLE `ponencias_has_investigador` (
  `ponencias_idponencias` int(11) NOT NULL,
  `investigador_cedula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revista`
--

CREATE TABLE `revista` (
  `idrevista` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `indexada` enum('SI','NO') NOT NULL,
  `categorizacion` enum('NO CATEGORIZADA','C','B','A','A1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_categoria`
--

CREATE TABLE `tipo_categoria` (
  `idtipo_categoria` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_categoria`
--

INSERT INTO `tipo_categoria` (`idtipo_categoria`, `nombre`, `descripcion`) VALUES
(1, 'A1', '12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_evento`
--

CREATE TABLE `tipo_evento` (
  `idtipo_evento` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_`
--

CREATE TABLE `user_` (
  `userId` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user_`
--

INSERT INTO `user_` (`userId`, `password`) VALUES
('andresm', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('carmenh', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('fernandat', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('jhonm', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('juanc', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('julianr', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`idarticulo`),
  ADD KEY `fk_articulo_revista1_idx` (`revista_idrevista`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`ideditorial`);

--
-- Indices de la tabla `estdo_investigador`
--
ALTER TABLE `estdo_investigador`
  ADD PRIMARY KEY (`idestdo_Investigador`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`idevento`),
  ADD KEY `fk_evento_tipo_evento_idx` (`tipo_evento_idtipo_evento`);

--
-- Indices de la tabla `formacion_academica`
--
ALTER TABLE `formacion_academica`
  ADD PRIMARY KEY (`idformacion_academica`);

--
-- Indices de la tabla `group_`
--
ALTER TABLE `group_`
  ADD PRIMARY KEY (`groupId`,`userId`);

--
-- Indices de la tabla `grupos_investigacion`
--
ALTER TABLE `grupos_investigacion`
  ADD PRIMARY KEY (`idgrupos_investigacion`),
  ADD KEY `fk_grupos_investigacion_tipo_categoria1_idx` (`tipo_categoria_idtipo_categoria`);

--
-- Indices de la tabla `investigador`
--
ALTER TABLE `investigador`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `fk_investigador_estdo_investigador1_idx` (`estdo_investigador_idestdo_Investigador`),
  ADD KEY `fk_investigador_formacion_academica1_idx` (`formacion_academica_idformacion_academica`);

--
-- Indices de la tabla `investigador_has_articulo`
--
ALTER TABLE `investigador_has_articulo`
  ADD PRIMARY KEY (`investigador_cedula`,`articulo_idarticulo`),
  ADD KEY `fk_investigador_has_articulo_articulo1_idx` (`articulo_idarticulo`),
  ADD KEY `fk_investigador_has_articulo_investigador1_idx` (`investigador_cedula`);

--
-- Indices de la tabla `investigador_has_grupos_investigacion`
--
ALTER TABLE `investigador_has_grupos_investigacion`
  ADD PRIMARY KEY (`investigador_cedula`,`grupos_investigacion_idgrupos_investigacion`),
  ADD KEY `fk_investigador_has_grupos_investigacion_grupos_investigaci_idx` (`grupos_investigacion_idgrupos_investigacion`),
  ADD KEY `fk_investigador_has_grupos_investigacion_investigador1_idx` (`investigador_cedula`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idlibros`),
  ADD KEY `fk_libro_editorial1_idx` (`editorial_ideditorial`);

--
-- Indices de la tabla `libro_has_investigador`
--
ALTER TABLE `libro_has_investigador`
  ADD PRIMARY KEY (`libro_idlibros`,`investigador_cedula`),
  ADD KEY `fk_libro_has_investigador_investigador1_idx` (`investigador_cedula`),
  ADD KEY `fk_libro_has_investigador_libro1_idx` (`libro_idlibros`);

--
-- Indices de la tabla `ponencias`
--
ALTER TABLE `ponencias`
  ADD PRIMARY KEY (`idponencias`),
  ADD KEY `fk_ponencias_evento1_idx` (`evento_idevento`);

--
-- Indices de la tabla `ponencias_has_investigador`
--
ALTER TABLE `ponencias_has_investigador`
  ADD PRIMARY KEY (`ponencias_idponencias`,`investigador_cedula`),
  ADD KEY `fk_ponencias_has_investigador_investigador1_idx` (`investigador_cedula`),
  ADD KEY `fk_ponencias_has_investigador_ponencias1_idx` (`ponencias_idponencias`);

--
-- Indices de la tabla `revista`
--
ALTER TABLE `revista`
  ADD PRIMARY KEY (`idrevista`);

--
-- Indices de la tabla `tipo_categoria`
--
ALTER TABLE `tipo_categoria`
  ADD PRIMARY KEY (`idtipo_categoria`);

--
-- Indices de la tabla `tipo_evento`
--
ALTER TABLE `tipo_evento`
  ADD PRIMARY KEY (`idtipo_evento`);

--
-- Indices de la tabla `user_`
--
ALTER TABLE `user_`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `idarticulo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `editorial`
--
ALTER TABLE `editorial`
  MODIFY `ideditorial` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `estdo_investigador`
--
ALTER TABLE `estdo_investigador`
  MODIFY `idestdo_Investigador` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `evento`
--
ALTER TABLE `evento`
  MODIFY `idevento` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `formacion_academica`
--
ALTER TABLE `formacion_academica`
  MODIFY `idformacion_academica` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `grupos_investigacion`
--
ALTER TABLE `grupos_investigacion`
  MODIFY `idgrupos_investigacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `investigador`
--
ALTER TABLE `investigador`
  MODIFY `cedula` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idlibros` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ponencias`
--
ALTER TABLE `ponencias`
  MODIFY `idponencias` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_categoria`
--
ALTER TABLE `tipo_categoria`
  MODIFY `idtipo_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `tipo_evento`
--
ALTER TABLE `tipo_evento`
  MODIFY `idtipo_evento` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `fk_articulo_revista1` FOREIGN KEY (`revista_idrevista`) REFERENCES `revista` (`idrevista`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `fk_evento_tipo_evento` FOREIGN KEY (`tipo_evento_idtipo_evento`) REFERENCES `tipo_evento` (`idtipo_evento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `grupos_investigacion`
--
ALTER TABLE `grupos_investigacion`
  ADD CONSTRAINT `fk_grupos_investigacion_tipo_categoria1` FOREIGN KEY (`tipo_categoria_idtipo_categoria`) REFERENCES `tipo_categoria` (`idtipo_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `investigador`
--
ALTER TABLE `investigador`
  ADD CONSTRAINT `fk_investigador_estdo_investigador1` FOREIGN KEY (`estdo_investigador_idestdo_Investigador`) REFERENCES `estdo_investigador` (`idestdo_Investigador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_investigador_formacion_academica1` FOREIGN KEY (`formacion_academica_idformacion_academica`) REFERENCES `formacion_academica` (`idformacion_academica`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `investigador_has_articulo`
--
ALTER TABLE `investigador_has_articulo`
  ADD CONSTRAINT `fk_investigador_has_articulo_articulo1` FOREIGN KEY (`articulo_idarticulo`) REFERENCES `articulo` (`idarticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_investigador_has_articulo_investigador1` FOREIGN KEY (`investigador_cedula`) REFERENCES `investigador` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `investigador_has_grupos_investigacion`
--
ALTER TABLE `investigador_has_grupos_investigacion`
  ADD CONSTRAINT `fk_investigador_has_grupos_investigacion_grupos_investigacion1` FOREIGN KEY (`grupos_investigacion_idgrupos_investigacion`) REFERENCES `grupos_investigacion` (`idgrupos_investigacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_investigador_has_grupos_investigacion_investigador1` FOREIGN KEY (`investigador_cedula`) REFERENCES `investigador` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `fk_libro_editorial1` FOREIGN KEY (`editorial_ideditorial`) REFERENCES `editorial` (`ideditorial`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro_has_investigador`
--
ALTER TABLE `libro_has_investigador`
  ADD CONSTRAINT `fk_libro_has_investigador_investigador1` FOREIGN KEY (`investigador_cedula`) REFERENCES `investigador` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_libro_has_investigador_libro1` FOREIGN KEY (`libro_idlibros`) REFERENCES `libro` (`idlibros`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ponencias`
--
ALTER TABLE `ponencias`
  ADD CONSTRAINT `fk_ponencias_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ponencias_has_investigador`
--
ALTER TABLE `ponencias_has_investigador`
  ADD CONSTRAINT `fk_ponencias_has_investigador_investigador1` FOREIGN KEY (`investigador_cedula`) REFERENCES `investigador` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ponencias_has_investigador_ponencias1` FOREIGN KEY (`ponencias_idponencias`) REFERENCES `ponencias` (`idponencias`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
