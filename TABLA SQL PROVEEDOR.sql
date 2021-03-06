DROP DATABASE if exists proveedor;
CREATE DATABASE proveedor;
USE proveedor;

-- CREACION DE LA TABLA TARIFA_ESTANDAR
create table Tarifa_Estandar(
	Cod_Tarifa int auto_increment NOT NULL,
    Cuadrilla float NOT NULL,
    Flete float NOT NULL,
    Materia_Prima varchar(10) NOT NULL,
    Fecha_Inicio datetime,
    Fecha_Final datetime default '0000-00-00',
    Estado varchar(12) default 'VIGENTE', -- VIGENTE O NO VIGENTE
    primary key(Cod_Tarifa)
);

INSERT INTO Tarifa_Estandar(Cod_Tarifa, Cuadrilla, Flete, Materia_Prima, Fecha_Inicio) values(0,1,2,"TABLA",'2021-06-16');
UPDATE Tarifa_Estandar set Cod_Tarifa = 0 where Cod_Tarifa = 1;
UPDATE Tarifa_Estandar set Estado = "NO VIGENTE" where Cod_Tarifa = 0;
INSERT INTO Tarifa_Estandar(Cuadrilla, Flete, Materia_Prima, Fecha_Inicio) values(1,2,"TABLA",'2021-06-17');
-- select * from Tarifa_Estandar;

-- CREACION DE LA TABLA PROVEEDOR
create table proveedor(
	Codigo int NOT NULL, 
    Identificacion varchar(15) UNIQUE NOT NULL,
    Razon_Social varchar(50) NOT NULL,
    Direccion varchar(50),
    Municipio varchar(20),
    Telefono varchar(11),
    Email varchar(40),
    -- PAGOS DE PROVEEDOR
    Cuadrilla float NOT NULL,
    Flete float NOT NULL,
    Peaje int NOT NULL,
    Materia_Prima varchar(10) NOT NULL,
    MP_acordado float,
    -- LLAVES FORANEAS
    Cod_Tarifa int,
    -- ESTADO DEL PROVEEDOR EN EL SISTEMA
    Estado_Actividad varchar(10) DEFAULT 'Activo',
    primary key(Codigo),
    foreign key(Cod_Tarifa) references Tarifa_Estandar(Cod_Tarifa)
);

-- UPDATE proveedor set Cod_Tarifa = 5;
/*
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(1, 'V29517648', 'Daniel Vetencourt', 78,48,48, 'TABLA');
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(2, 'V28216052', 'Gabriel Antuarez', 78,48,48, 'TABLA');
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(3, 'V27578138', 'Jennifer Sucre', 78,48,48, 'TABLA');
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(4, 'V22111589', 'MasterGAP', 78,48,48, 'TABLA');
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(5, 'V7383981', 'Carlos Vetencourt', 78,48,48, 'TABLA');
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(6, 'V7418673', 'Dorys Alvarez', 78,48,48, 'TABLA');
*/
-- SELECT * from proveedor order by Codigo desc;
-- CREACION DE LA TABLA BENEFICIARIOS
create table beneficiarios(
	Cod_Beneficiario int auto_increment NOT NULL,
    Name_Beneficiario varchar(50) NOT NULL,
    ID_Beneficiario varchar(15) UNIQUE NOT NULL,
    Mail_Beneficiario varchar(40),
    Banco varchar(40) NOT NULL,
    Num_cuenta varchar(21) NOT NULL,
    Tipo_cuenta varchar(30) NOT NULL,
    MOD_Cuenta varchar(20) NOT NULL,
    Nombre_Autorizado varchar(30),
    ID_Autorizado varchar(15),
	PRIMARY KEY(Cod_Beneficiario)
);

	SELECT * FROM beneficiarios;
-- SELECT count(1) as total from beneficiarios;


create table Tasa_USD(
	Cod_Tasa int auto_increment NOT NULL,
    Semana varchar(10),
    Monto double not null,
    Primary Key(Cod_Tasa)
);

-- DROP TABLE Tasa_USD;
INSERT INTO Tasa_USD(Semana, Monto) values('25-2021',3182893.37);
-- SELECT * from Tasa_USD;

create table anticipos(
	Num_Anticipo int NOT NULL auto_increment, 
    Motivo_Anticipo varchar(40) NOT NULL,
    Fecha datetime NOT NULL,
    Semana varchar(10) NOT NULL,
    Monto_BS double NOT NULL,
    Monto_DS double NOT NULL,
    Aprobacion varchar(40),
    Observaciones varchar(150), -- LAS OBSERVACIONES SON INFORMACION ADICIONAL
    DescontarODP varchar(2),
    Codigo_Proveedor int,
    Codigo_Tasa int,
    foreign key(Codigo_Proveedor) REFERENCES proveedor(Codigo),
    foreign key(Codigo_Tasa) REFERENCES Tasa_USD(Cod_Tasa),
    PRIMARY KEY(Num_Anticipo)
);

-- SELECT * from anticipos;

-- CREACION DE LA TABLA BOLETO
create table boleto(
	Codigo_Boleto varchar(10) not null,
    Nombre varchar(40) not null,
    Fecha datetime not null,
    Semana varchar(10) not null,
    Kg_Brutos float not null,			-- ESTO ES FLOAT
    Kg_Netos float not null,			-- ESTO ES FLOAT
    Materia_S int not null,				-- ESTO ES INT
    Impurezas int not null,				-- ESTO ES INT
    Cantidad_Transacciones int not null,-- PARA SABER HASTA CUANTO TIENE CUPO, VA DE 0 MINIMO HASTA 4 MAXIMO
    Observaciones varchar(150),
    primary key(Codigo_Boleto)
);
-- SELECT * from boleto;
create table Tasa_Precios(
	Cod_Tarifa int auto_increment NOT NULL,
    Materia_Seca int not null UNIQUE,
    En_Planta float not null,
    En_Corte float not null,
    primary key(Cod_Tarifa)
);

insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(0,0,0);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(21,0.03840,0.02340);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(22,0.04160,0.02660);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(23,0.04480,0.02980);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(24,0.04800,0.03300);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(25,0.05120,0.03620);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(26,0.05440,0.03940);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(27,0.05760,0.04260);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(28,0.06080,0.04580);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(29,0.06400,0.04900);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(30,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(31,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(32,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(33,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(34,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(35,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(36,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(37,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(38,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(39,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(40,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(41,0.06720,0.05220);
insert into Tasa_Precios (Materia_Seca, En_Planta, En_Corte) values(42,0.06720,0.05220);

-- CREACION DE LA TABLA TRANSACCIONES
create table transacciones(
	ID_Transaccion int auto_increment NOT NULL,
    -- ESTA ES LA INFORMACION DEL BOLETO
	Num_Boleto varchar(10) not null,
    Semana varchar(10) not null,
    -- ESTAS SON LOS TIPOS DE TRANSACCIONES
    Materia_Prima varchar(3) NOT NULL,
    Cuadrilla varchar(3) NOT NULL,
    Flete varchar(3) NOT NULL,
    Peaje varchar(3) NOT NULL,
    -- Estado de la transaccion.
    Estado_Transaccion varchar(15),
	-- Informacion adicional de la transaccion
    Observaciones varchar(150),
    -- Foreign Key referente al proveedor
    Codigo_Proveedor int,
    foreign key(Codigo_Proveedor) references proveedor(Codigo),
    foreign key(Num_Boleto) references boleto(Codigo_Boleto),
    primary key(ID_Transaccion)
);

-- SELECT transacciones.Num_Boleto, transacciones.ID_Transaccion, transacciones.Codigo_Proveedor, transacciones.Semana, boleto.Codigo_Boleto, boleto.Kg_Brutos, boleto.Kg_Netos, proveedor.Codigo FROM transacciones, boleto, proveedor WHERE transacciones.Num_Boleto = boleto.Codigo_Boleto AND transacciones.Codigo_Proveedor = proveedor.Codigo AND transacciones.Semana = '26-2021';
-- SELECT * from transacciones;
-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Codigo_Proveedor, transacciones.Semana, transacciones.Peaje, boleto.Codigo_Boleto, proveedor.Codigo FROM transacciones, boleto, proveedor WHERE transacciones.Num_Boleto = boleto.Codigo_Boleto AND transacciones.Codigo_Proveedor = proveedor.Codigo AND transacciones.Peaje = 'SI' AND transacciones.Semana = '26-2021' AND proveedor.Codigo = 1;


-- SELECT Codigo_Proveedor FROM transacciones WHERE Semana = '26-2021' GROUP BY Codigo_Proveedor;
-- SELECT Semana FROM transacciones GROUP BY Semana;
-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Materia_Prima, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, boleto.Kg_Netos, boleto.Materia_S, Tasa_Precios.En_Planta, Tasa_Precios.Materia_Seca, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Materia_Prima FROM proveedor, boleto, transacciones, Tasa_Precios WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND (transacciones.Semana = '26-2021' OR transacciones.Semana = '27-2021') AND proveedor.Materia_Prima = 'TABLA' AND Tasa_Precios.Materia_Seca = boleto.Materia_S AND transacciones.Materia_Prima = 'SI' AND transacciones.Estado_Transaccion = 'No Procesada' AND transacciones.Num_Boleto = boleto.Codigo_Boleto ORDER BY proveedor.Codigo;
-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Materia_Prima, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, boleto.Kg_Netos, boleto.Materia_S, Tasa_Precios.En_Planta, Tasa_Precios.Materia_Seca, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Materia_Prima FROM proveedor, boleto, transacciones, Tasa_Precios WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND (transacciones.Semana = '26-2021' OR transacciones.Semana = '27-2021') AND proveedor.Materia_Prima = 'TABLA' AND Tasa_Precios.Materia_Seca = boleto.Materia_S AND transacciones.Materia_Prima = 'SI' AND transacciones.Estado_Transaccion = 'No Procesada' AND transacciones.Num_Boleto = boleto.Codigo_Boleto GROUP BY proveedor.Codigo;


-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Materia_Prima, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, boleto.Kg_Netos, boleto.Materia_S, Tasa_Precios.En_Planta, Tasa_Precios.Materia_Seca, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Materia_Prima 
--                        FROM proveedor, boleto, transacciones, Tasa_Precios 
--                        WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND 
--                        proveedor.Codigo = '1' AND transacciones.Semana = '26-2021' AND 
--                        proveedor.Materia_Prima = 'TABLA' AND 
--                        Tasa_Precios.Materia_Seca = boleto.Materia_S AND 
--                        transacciones.Materia_Prima = 'SI' AND 
--                        transacciones.Estado_Transaccion = 'No Procesada' AND 
--                        transacciones.Num_Boleto = boleto.Codigo_Boleto 
--                        ORDER BY proveedor.Codigo;

-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Cuadrilla, boleto.Codigo_Boleto, boleto.Kg_Netos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Cuadrilla as Cuadrilla_Proveedor 
--                       FROM proveedor, boleto, transacciones 
--                        WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND 
--                        transacciones.Semana = '26-2021' AND 
--                        transacciones.Cuadrilla = 'SI' AND 
--                        transacciones.Estado_Transaccion = 'No Procesada' AND 
--                        transacciones.Num_Boleto = boleto.Codigo_Boleto
--                        ORDER BY proveedor.Codigo;

-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Cuadrilla, boleto.Codigo_Boleto, boleto.Kg_Netos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Cuadrilla as Cuadrilla_Proveedor 
--                        FROM proveedor, boleto, transacciones 
--                        WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND 
--                        transacciones.Semana = '26-2021' AND 
--                        transacciones.Cuadrilla = 'SI' AND 
--                        transacciones.Estado_Transaccion = 'No Procesada' AND 
--                        transacciones.Num_Boleto = boleto.Codigo_Boleto
--                        GROUP BY proveedor.Codigo ORDER BY proveedor.Codigo ASC;

-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Flete, boleto.Codigo_Boleto, boleto.Kg_Brutos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Flete as Flete_Proveedor 
--                        FROM proveedor, boleto, transacciones 
--                        WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND 
--                        proveedor.Codigo = 5 AND transacciones.Semana = '26-2021' AND 
--                        transacciones.Flete = 'SI' AND 
--                        transacciones.Estado_Transaccion = 'No Procesada' AND 
--                        transacciones.Num_Boleto = boleto.Codigo_Boleto 
--                        ORDER BY proveedor.Codigo;

-- SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Peaje, boleto.Codigo_Boleto, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Peaje as Peaje_Proveedor
--						  -- FROM proveedor, boleto, transacciones
--                        WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND
--                        transacciones.Semana = '26-2021' AND
--                        transacciones.Peaje = 'SI' AND
--                        transacciones.Estado_Transaccion = 'No Procesada' AND
--                        transacciones.Num_Boleto = boleto.Codigo_Boleto
--                        GROUP BY proveedor.Codigo ORDER BY proveedor.Codigo ASC;


-- select * from Tasa_Precios;


create table Relacion_Proveedor_Beneficiario(
    Cod_Bnf int,
    Cod_Proveedor int,
    foreign key(Cod_Bnf) references beneficiarios(Cod_Beneficiario),
    foreign key(Cod_Proveedor) references proveedor(Codigo)
);

-- SELECT * from Relacion_Proveedor_Beneficiario;

create table ODP(
	Cod_ODP int auto_increment NOT NULL,
    Cod_DelProveedor int NOT NULL,
    Fecha datetime,
    Semana varchar(10),
    Acumulado_MP_BS double,
    Acumulado_MP_Ds double,
    Acumulado_Cuadrilla_BS double,
    Acumulado_Cuadrilla_DS double,
    Acumulado_Flete_BS double,
    Acumulado_Flete_DS double,
    Acumulado_Peaje_BS double,
    Acumulado_Peaje_DS double,
    Acumulado_Anticipo_BS double,
    Acumulado_Anticipo_DS double,
    Total_BS double,
    Total_DS double,
    primary key(Cod_ODP),
    foreign key(Cod_DelProveedor) references proveedor(Codigo)
);

SELECT Semana from ODP group by Semana;
SELECT * FROM ODP Where Semana = '26-2021' ORDER BY Cod_ODP DESC;
SELECT Codigo_Proveedor FROM transacciones WHERE Semana = '26-2021' GROUP BY Codigo_Proveedor;
SELECT * from ODP;

create table Pago_Transaccion(
	Codigo_ODP int NOT NULL,
    Codigo_Transaccion int NOT NULL,
    foreign key(Codigo_ODP) references ODP(Cod_ODP),
    foreign key(Codigo_Transaccion) references transacciones(ID_Transaccion)
);
/*
create table reportes(
	Cod_Reporte int auto_increment NOT NULL,
    Motivo_Reporte varchar(20) NOT NULL,
    primary key(Cod_reporte)
);
*/
