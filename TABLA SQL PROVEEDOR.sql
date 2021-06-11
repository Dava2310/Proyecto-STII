CREATE DATABASE proveedor;
USE proveedor;

-- CREACION DE LA TABLA PROVEEDOR
create table proveedor(
	-- INFORMACION DE PROVEEDOR
	Codigo int NOT NULL,
    Identificacion varchar(15) UNIQUE NOT NULL,
    Razon_Social varchar(50) NOT NULL,
    Direccion varchar(50),
    Municipio varchar(20),
    Telefono varchar(11),
    Email varchar(40),
    -- INFORMANCION BANCARIA
    Name_Beneficiario varchar(50),
    ID_Beneficiario varchar(15),
    Mail_Beneficiario varchar(40),
    Banco varchar(40),
    Num_cuenta varchar(21),
    Tipo_cuenta varchar(30),
    MOD_Cuenta varchar(20),
    Nombre_Autorizado varchar(30),
    ID_Autorizado varchar(15),
    -- TASAS DE PAGO
    Materia_Prima varchar(10) NOT NULL,
    Cuadrilla float NOT NULL,
    Flete float NOT NULL,
    Peaje int NOT NULL,
    -- ESTADO DEL PROVEEDOR EN EL SISTEMA
    Estado_Actividad varchar(10) DEFAULT 'Activo',
	PRIMARY KEY(Codigo)
);
-- COMANDOS PARA LA TABLA PROVEEDOR

SELECT * from proveedor;	-- MOSTRAR TODOS LOS DATOS DE LA TABLA PROVEEDOR
DROP TABLE proveedor; 		-- ELIMINAR LA TABLA PROVEEDOR
SELECT count(1) as total FROM proveedor;
SELECT Codigo from proveedor Order By Codigo;
-- EJEMPLO DE CREACION DE UN PROVEEDOR
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Materia_Prima, Cuadrilla, Flete, Peaje) VALUES (1, 'V29517648', 'Daniel Vetencourt', 'TABLA', 50,50,50);
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Materia_Prima, Cuadrilla, Flete, Peaje) VALUES (2, 'V29517648', 'Daniel Vetencourt', 'TABLA', 50,50,50);
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Materia_Prima, Cuadrilla, Flete, Peaje) VALUES (3, 'V29517648', 'Daniel Vetencourt', 'TABLA', 50,50,50);
INSERT INTO proveedor(Codigo, Identificacion, Razon_Social, Materia_Prima, Cuadrilla, Flete, Peaje) VALUES (4, 'V29517648', 'Daniel Vetencourt', 'TABLA', 50,50,50);
INSERT INTO proveedor(Identificacion, Razon_Social, Materia_Prima, Cuadrilla, Flete, Peaje) VALUES ('V29517648', 'Daniel Vetencourt', 'TABLA', 50,50,50);

INSERT INTO proveedor VALUES('00029517648','V29517648','Daniel','Trinitarias','04167902535','dv@gmail.com','Daniel Vetencourt',
							 '29517648','dvetencourt23@gmail.com','Mercantil','0000088888','Corriente','Cta. Propia','BS','','');

INSERT INTO proveedor VALUES('00027578138','V27578138','Jennifer','Floresta','04167902535','dv@gmail.com','Daniel Vetencourt',
							 '29517648','dvetencourt23@gmail.com','Mercantil','0000088888','Corriente','Cta. Propia','BS','','', 'Inactivo');
DELETE FROM proveedor where Estado_Actividad = 'Inactivo';
DELETE FROM proveedor where Estado_Actividad = 'Activo';
UPDATE proveedor set Identificacion = 'V27578138' where Razon_Social = 'Jennifer';
SELECT * from proveedor where Identificacion = 'V29517648' and Codigo = '00029517648' and Razon_Social = 'Daniel Vetencourt';
-- CREACION DE LA TABLA ANTICIPO
create table anticipos(
	Num_Anticipo int NOT NULL auto_increment, 
    Motivo_Anticipo varchar(40) NOT NULL,
    Fecha varchar(10) NOT NULL,
    Monto_BS varchar(20) NOT NULL,
    Monto_DS varchar(20) NOT NULL,
    Aprobacion varchar(40),
    Observaciones varchar(150), -- LAS OBSERVACIONES SON INFORMACION ADICIONAL
    DescontarODP varchar(2),
    Codigo_Proveedor varchar(15),
    Recien_Creado varchar(2) DEFAULT 'NO',
    foreign key(Codigo_Proveedor) REFERENCES proveedor(Codigo),
    PRIMARY KEY(Num_Anticipo)
);

-- COMANDOS PARA LA TABLA ANTICIPO

SELECT * from anticipos;	-- MOSTRAR TODOS LOS DATOS DE LA TABLA ANTICIPOS
DROP TABLE anticipos;		-- ELIMINAR LA TABLA ANTICIPOS
-- EJEMPLO DE CREACION DE UN ANTICIPO
INSERT INTO anticipos(Motivo_Anticipo, Fecha, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP) values('F','B','C','D','E','F','G');

-- CREACION DE LA TABLA BOLETO
create table boleto(
	Codigo varchar(10) not null,
    Fecha varchar(10) not null,
    Semana varchar(10) not null,
    Kg_Brutos float not null,			-- ESTO ES FLOAT
    Kg_Netos float not null,			-- ESTO ES FLOAT
    Materia_S int not null,		-- ESTO ES INT
    Impurezas int not null,		-- ESTO ES INT
    Cantidad_Transacciones int not null,
    Observaciones varchar(150),
    primary key(Codigo)
);

INSERT into boleto values('20','06/08/2021','23-2021',30.5,30.3,30,30,0);

SELECT * from boleto;
SELECT Cantidad_Transacciones from boleto where Codigo = '2021112';
UPDATE boleto set Cantidad_Transacciones = 4 where Codigo = '20211110';
DROP TABLE boleto;

-- CREACION DE LA TABLA TRANSACCIONES
create table transacciones(
	ID_Transaccion int auto_increment,
    -- ESTA ES LA INFORMACION DEL BOLETO
	Num_Boleto varchar(10) not null,
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
    Codigo_Proveedor varchar(15),
    foreign key(Codigo_Proveedor) references proveedor(Codigo),
    foreign key(Num_Boleto) references boleto(Codigo),
    primary key(ID_Transaccion)
);

-- COMANDOS PARA LA TABLA TRANSACCIONES

INSERT INTO transacciones (Num_Boleto, Materia_Prima, Cuadrilla, Flete, Peaje, Observaciones, Codigo_Proveedor) values('20','NO','NO','NO','SI',' ','00029517648');
INSERT INTO transacciones (Num_Boleto, Materia_Prima, Cuadrilla, Flete, Peaje, Observaciones, Codigo_Proveedor) values('20','SI','NO','NO','NO',' ','00029517648');
INSERT INTO transacciones (Num_Boleto, Materia_Prima, Cuadrilla, Flete, Peaje, Observaciones, Codigo_Proveedor) values('20','NO','SI','NO','NO',' ','00029517648');
INSERT INTO transacciones (Num_Boleto, Materia_Prima, Cuadrilla, Flete, Peaje, Observaciones, Codigo_Proveedor) values('20','NO','NO','SI','NO',' ','00029517648');

SELECT * from transacciones; -- MOSTRAR TODOS LOS DATOS DE LAS TRANSACCIONES
DROP TABLE transacciones; 	 -- ELIMINAR LA TABLA DE TRANSACCIONES
SELECT transacciones.Materia_Prima FROM transacciones where transacciones.Num_Boleto = '30';
SELECT transacciones.Cuadrilla FROM transacciones where transacciones.Num_Boleto = '20';
UPDATE transacciones set Materia_Prima = 'NO' where Materia_Prima = 'SI' and Num_Boleto = '20';








