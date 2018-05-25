--CREATE DATABASE bd_sistema_patrones_v1
--USE bd_sistema_patrones_v1

CREATE TABLE tproceso(
	id INT NOT NULL CONSTRAINT PK_proceso PRIMARY KEY IDENTITY (1,1),
	codigo VARCHAR(50) NOT NULL CONSTRAINT UNQ_codigo_proceso UNIQUE,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(300) NOT NULL,
	fecha_inicio DATE NULL CONSTRAINT DF_fecha_inicio_proceso DEFAULT '0000-00-00',
	fecha_fin DATE NULL CONSTRAINT DF_fecha_fin_proceso DEFAULT '0000-00-00',
	estado VARCHAR(15) NOT NULL CONSTRAINT DF_estado_proceso DEFAULT 'Inactivo',
	CONSTRAINT CHK_estado_proceso CHECK (estado IN ('Inactivo', 'En proceso', 'Completado'))
)

CREATE TABLE	tarea_funcional(
	id INT NOT NULL CONSTRAINT PK_area_funcional PRIMARY KEY IDENTITY (1,1),
	codigo VARCHAR(50) NOT NULL CONSTRAINT UNQ_codigo_area_funcional UNIQUE,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(300) NOT NULL
)

CREATE TABLE ttarea(
	id INT NOT NULL CONSTRAINT PK_tarea PRIMARY KEY IDENTITY (1,1),
	codigo VARCHAR(50) NOT NULL CONSTRAINT UNQ_codigo_tarea UNIQUE,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(300) NOT NULL,
	estado VARCHAR(15) NOT NULL CONSTRAINT DF_estado_tarea DEFAULT 'Inactivo',
	id_proceso INT NOT NULL CONSTRAINT FK_proceso_tarea FOREIGN KEY REFERENCES tproceso(id),
	id_area_funcional INT NOT NULL CONSTRAINT FK_area_tarea FOREIGN KEY REFERENCES tarea_funcional(id),
	CONSTRAINT CHK_estado_tarea CHECK (estado IN ('Inactivo', 'En proceso', 'Completado'))
)

CREATE TABLE tpaso (
	id INT NOT NULL CONSTRAINT PK_paso PRIMARY KEY IDENTITY (1,1),
	descripcion VARCHAR(300) NOT NULL,
	estado VARCHAR(15) NOT NULL CONSTRAINT DF_estado_paso DEFAULT 'Inactivo',
	id_tarea INT NOT NULL CONSTRAINT FK_tarea_paso FOREIGN KEY REFERENCES ttarea(id),
	CONSTRAINT CHK_estado_paso CHECK (estado IN ('Inactivo', 'En proceso', 'Completado'))
)

CREATE TABLE templeado (
	id INT NOT NULL CONSTRAINT PK_empleado PRIMARY KEY IDENTITY (1,1),
	cedula VARCHAR(20) NOT NULL,
	primer_nombre VARCHAR(50) NOT NULL,
	segundo_nombre VARCHAR(50) NULL,
	primer_apellido VARCHAR(50) NOT NULL,
	segundo_apellido VARCHAR(50) NULL,
	correo VARCHAR(50) NOT NULL,
	usuario VARCHAR(25) NOT NULL,
	clave VARCHAR(25) NOT NULL,
	rol VARCHAR(50) NOT NULL,
	id_area_funcional INT NOT NULL CONSTRAINT FK_area_empleado FOREIGN KEY REFERENCES tarea_funcional(id)
)

CREATE TABLE tpasos_x_empleados(
	id INT NOT NULL CONSTRAINT PK_pasos_x_empleados PRIMARY KEY IDENTITY (1,1),
	fecha_inicio  DATE NOT NULL,
	fecha_fin DATE NULL CONSTRAINT DF_fecha_fin_tipe DEFAULT '0000-00-00',
	duracion TIME NULL, 
	id_paso INT NOT NULL CONSTRAINT FK_paso_tipe FOREIGN KEY REFERENCES tpaso(id),
	id_empleado INT NOT NULL CONSTRAINT FK_empleado_tipe FOREIGN KEY REFERENCES templeado(id)
)
