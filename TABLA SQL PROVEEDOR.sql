DROP DATABASE if exists proveedor;
CREATE DATABASE proveedor;
USE proveedor;

-- CREACION DE LA TABLA TARIFA_ESTANDAR
create table Tarifa_Estandar(
	Cod_Tarifa int auto_increment NOT NULL,
    Cuadrilla float NOT NULL,
    Flete float NOT NULL,
    Peaje int NOT NULL,
    Materia_Prima varchar(10) NOT NULL,
    Fecha_Inicio datetime,
    Fecha_Final datetime default '0000-00-00',
    Estado varchar(12) default 'VIGENTE', -- VIGENTE O NO VIGENTE
    primary key(Cod_Tarifa)
);

INSERT INTO Tarifa_Estandar(Cuadrilla, Flete, Peaje, Materia_Prima, Fecha_Inicio) values(1,2,3,"TABLA",'2021-06-17');
select * from Tarifa_Estandar;

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
    -- LLAVES FORANEAS
    Cod_Tarifa int,
    -- ESTADO DEL PROVEEDOR EN EL SISTEMA
    Estado_Actividad varchar(10) DEFAULT 'Activo',
    primary key(Codigo),
    foreign key(Cod_Tarifa) references Tarifa_Estandar(Cod_Tarifa)
);

INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Cuadrilla, Flete, Peaje, Materia_Prima) values(1, 'V29517648', 'Daniel Vetencourt', 78,48,48, 'TABLA');
SELECT * from proveedor;
-- CREACION DE LA TABLA BENEFICIARIOS
create table beneficiarios(
	Cod_Beneficiario int auto_increment NOT NULL,
    Name_Beneficiario varchar(50) NOT NULL,
    ID_Beneficiario varchar(15) NOT NULL,
    Mail_Beneficiario varchar(40),
    Banco varchar(40) NOT NULL,
    Num_cuenta varchar(21) NOT NULL,
    Tipo_cuenta varchar(30) NOT NULL,
    MOD_Cuenta varchar(20) NOT NULL,
    Nombre_Autorizado varchar(30),
    ID_Autorizado varchar(15),
    Cod_Proveedor int NOT NULL,
	PRIMARY KEY(Cod_Beneficiario),
    foreign key(Cod_Proveedor) references proveedor(Codigo)
);

SELECT * FROM beneficiarios;

-- CREACION DE LA TABLA ANTICIPO
create table anticipos(
	Num_Anticipo int NOT NULL auto_increment, 
    Motivo_Anticipo varchar(40) NOT NULL,
    Fecha varchar(10) NOT NULL,
    Semana varchar(10) NOT NULL,
    Monto_BS varchar(20) NOT NULL,
    Monto_DS varchar(20) NOT NULL,
    Aprobacion varchar(40),
    Observaciones varchar(150), -- LAS OBSERVACIONES SON INFORMACION ADICIONAL
    DescontarODP varchar(2),
    Codigo_Proveedor int,
    foreign key(Codigo_Proveedor) REFERENCES proveedor(Codigo),
    PRIMARY KEY(Num_Anticipo)
);

-- CREACION DE LA TABLA BOLETO
create table boleto(
	Codigo_Boleto varchar(10) not null,
    Nombre varchar(40) not null,
    Fecha varchar(10) not null,
    Semana varchar(10) not null,
    Kg_Brutos float not null,			-- ESTO ES FLOAT
    Kg_Netos float not null,			-- ESTO ES FLOAT
    Materia_S int not null,				-- ESTO ES INT
    Impurezas int not null,				-- ESTO ES INT
    Cantidad_Transacciones int not null,-- PARA SABER HASTA CUANTO TIENE CUPO, VA DE 0 MINIMO HASTA 4 MAXIMO
    Observaciones varchar(150),
    primary key(Codigo_Boleto)
);

-- CREACION DE LA TABLA TRANSACCIONES
create table transacciones(
	ID_Transaccion int auto_increment,
    -- ESTA ES LA INFORMACION DEL BOLETO
	Num_Boleto varchar(10) not null,
    Semana varchar(10) not null,
    -- ESTAS SON LOS TIPOS DE TRANSACCIONES
    Materia_Prima varchar(3),
    Cuadrilla varchar(3),
    Flete varchar(3),
    Peaje varchar(3),
    -- Estado de la transaccion.
    Estado_Transaccion varchar(2),
	-- Informacion adicional de la transaccion
    Observaciones varchar(150),
    -- Foreign Key referente al proveedor
    Codigo_Proveedor int,
    foreign key(Codigo_Proveedor) references proveedor(Codigo),
    foreign key(Num_Boleto) references boleto(Codigo_Boleto),
    primary key(ID_Transaccion)
);

create table Tasa_USD(
	Cod_Tasa int auto_increment NOT NULL,
    Fecha_I varchar(11),
    Fecha_F varchar(11),
    Semana varchar(10),
    Monto float not null,
    Primary Key(Cod_Tasa)
);

create table Variables(
	Cod_Tarifa int auto_increment NOT NULL,
    Materia_Seca int not null,
    En_Planta float not null,
    En_Corte float not null,
    primary key(Cod_Tarifa)
);

create table Relacion_Proveedor_Beneficiario(
    Cod_Bnf int,
    Cod_Proveedor int,
    foreign key(Cod_Bnf) references beneficiarios(Cod_Beneficiario),
    foreign key(Cod_Proveedor) references proveedor(Codigo)
);

create table ODP(
	Cod_ODP int auto_increment NOT NULL,
    Fecha varchar(11),
    Moneda varchar(2), 
    Observaciones varchar(150),
    Acumulado_MP float,
    Acumulado_Cuadrilla float,
    Acumulado_Flete float,
    Acumulado_Peaje int,
    primary key(Cod_ODP)
);

create table Pago_Transacciones(
	COD_Trans int NOT NULL,
    COD_ODP int NOT NULL,
    Semana varchar(10),
    foreign key (COD_Trans) references transacciones(ID_Transaccion),
    foreign key (COD_ODP) references ODP(Cod_ODP)
);
/*
create table reportes(
	Cod_Reporte int auto_increment NOT NULL,
    Motivo_Reporte varchar(20) NOT NULL,
    primary key(Cod_reporte)
);
*/
