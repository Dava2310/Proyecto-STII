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
INSERT INTO proveedor VALUES('00029517648','29517648','Daniel','Trinitarias','04167902535','dv@gmail.com','Daniel Vetencourt',
							 '29517648','dvetencourt23@gmail.com','Mercantil','0000088888','Corriente','Cta. Propia','BS',null,null);


-- CREACION DE LA TABLA ANTICIPO
create table anticipos(
	Num_Anticipo int NOT NULL auto_increment, 
    Motivo_Anticipo varchar(40) NOT NULL,
    Fecha varchar(10) NOT NULL,
    Monto_BS varchar(20) NOT NULL,
    Monto_DS varchar(20) NOT NULL,
    Aprobacion varchar(40),
    Observaciones varchar(150),
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












