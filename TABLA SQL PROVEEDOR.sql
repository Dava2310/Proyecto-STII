CREATE DATABASE proveedor;
USE proveedor;

-- CREACION DE LA TABLA PROVEEDOR
create table proveedor(
	Codigo varchar(15) NOT NULL,
    Identificacion varchar(20) UNIQUE NOT NULL,
    Razon_Social varchar(30) NOT NULL,
    Direccion varchar(30),
    Telefono varchar(11),
    Email varchar(30),
    Name_Beneficiario varchar(30),
    ID_Beneficiario varchar(15),
    Mail_Beneficiario varchar(30),
    Banco varchar(40),
    Num_cuenta varchar(25),
    Tipo_cuenta varchar(20),
    MOD_Cuenta varchar(20),
    Moneda varchar(2) Default 'BS',
    Nombre_Autorizado varchar(30),
    ID_Autorizado varchar(15),
    Estado_Actividad varchar(10) DEFAULT 'Activo',
	PRIMARY KEY(Codigo)
);
-- COMANDOS PARA LA TABLA PROVEEDOR

SELECT * from proveedor;	-- MOSTRAR TODOS LOS DATOS DE LA TABLA PROVEEDOR
DROP TABLE proveedor; 		-- ELIMINAR LA TABLA PROVEEDOR
-- EJEMPLO DE CREACION DE UN PROVEEDOR
INSERT INTO proveedor VALUES('00029517648','V29517648','Daniel','Trinitarias','04167902535','dv@gmail.com','Daniel Vetencourt',
							 '29517648','dvetencourt23@gmail.com','Mercantil','0000088888','Corriente','Cta. Propia','BS','','');

INSERT INTO proveedor VALUES('00027578138','V27578138','Jennifer','Floresta','04167902535','dv@gmail.com','Daniel Vetencourt',
							 '29517648','dvetencourt23@gmail.com','Mercantil','0000088888','Corriente','Cta. Propia','BS','','', 'Inactivo');
DELETE FROM proveedor where Estado_Actividad = 'Inactivo';
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

-- CREACION DE LA TABLA TRANSACCIONES
create table transacciones(
	ID_Transaccion int auto_increment,
	Num_Transaccion varchar(10) not null,
    Fecha varchar(10) not null,
    Semana varchar(10) not null,
    Kg_Brutos int not null, 		-- ESTE CAMPO NO PUEDE SER DECIMAL
	Kg_Netos  int not null,			-- ESTE CAMPO NO PUEDE SER DECIMAL
    Materia_S float not null,
    Impurezas float not null,
    Materia_Prima varchar(3),
    Cuadrilla varchar(3),
    Flete varchar(3),
    Peaje varchar(3),
	-- Informacion adicional de la transaccion
    Dias_Trabajados int,
    Ha_Ubicacion int, 
    USD_DIA varchar(3), 
    USD_HA varchar(3),
    Observaciones varchar(150),
    -- Foreign Key referente al proveedor
    Codigo_Proveedor varchar(15),
    foreign key(Codigo_Proveedor) references proveedor(Codigo),
    primary key(ID_Transaccion)
);

-- COMANDOS PARA LA TABLA TRANSACCIONES

SELECT * from transacciones; -- MOSTRAR TODOS LOS DATOS DE LAS TRANSACCIONES
DROP TABLE transacciones; 	 -- ELIMINAR LA TABLA DE TRANSACCIONES









