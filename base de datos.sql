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

INSERT INTO templeado(cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, usuario, clave, rol, id_area_funcional) 
VALUES('117180829', 'Christhian', 'Steven', 'Montes', 'Aguilar', 'cmontesa@ucenfotec.ac.cr', 'stevenmontes', 'steven08', 'Administrador', 1)

INSERT INTO tarea_funcional(codigo, nombre, descripcion) 
VALUES ('AD01','Administracion','Se encarga de administrar todo lo que sucede en la empresa.')

CREATE TABLE tpasos_x_empleados(
	id INT NOT NULL CONSTRAINT PK_pasos_x_empleados PRIMARY KEY IDENTITY (1,1),
	fecha_inicio  DATE NOT NULL,
	fecha_fin DATE NULL CONSTRAINT DF_fecha_fin_tipe DEFAULT '0000-00-00',
	duracion TIME NULL, 
	id_paso INT NOT NULL CONSTRAINT FK_paso_tipe FOREIGN KEY REFERENCES tpaso(id),
	id_empleado INT NOT NULL CONSTRAINT FK_empleado_tipe FOREIGN KEY REFERENCES templeado(id)
)

CREATE PROCEDURE pa_inIciar_sesion 
@usuario VARCHAR(25),
@clave VARCHAR(25)
AS
	BEGIN TRY
		BEGIN TRANSACTION
			SELECT cedula, primer_nombre, primer_apellido, id_area_funcional 
			FROM templeado 
			WHERE @usuario = usuario
			AND @clave = clave
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
	END CATCH

CREATE PROCEDURE pa_registrar_proceso
@codigo VARCHAR(50),
@nombre VARCHAR(50),
@descripcion VARCHAR(300)
AS
INSERT INTO tproceso (codigo, nombre, descripcion)
VALUES (@codigo, @nombre, @descripcion)

CREATE PROCEDURE pa_registrar_tarea
	@codigo VARCHAR(50),
	@nombre VARCHAR(50),
	@descripcion VARCHAR(300),
	@codigo_area VARCHAR(50),
	@codigo_proceso VARCHAR(50)
	AS
		DECLARE @id_area_funcional INT
		DECLARE @id_proceso INT

		SELECT @id_area_funcional = id 
		FROM tarea_funcional 
		WHERE codigo = @codigo_area

		SELECT @id_proceso = id
		FROM tproceso
		WHERE codigo = @codigo_proceso

		INSERT INTO ttarea (codigo, nombre, descripcion, id_area_funcional, id_proceso)
		VALUES (@codigo, @nombre, @descripcion, @id_area_funcional, @id_proceso)

CREATE PROCEDURE pa_registrar_paso
	@descripcion VARCHAR(300),
	@codigo_tarea VARCHAR(50)
	AS
		DECLARE @id_tarea INT

		SELECT @id_tarea = id 
		FROM ttarea
		WHERE codigo = @codigo_tarea

		INSERT INTO tpaso (descripcion, id_tarea)
		VALUES (@descripcion, @id_tarea)

CREATE PROCEDURE pa_registrar_empleado
	@cedula VARCHAR(20),
	@nom1 VARCHAR(50),
	@nom2 VARCHAR(50),
	@ape1 VARCHAR(50),
	@ape2 VARCHAR(50),
	@correo VARCHAR(50),
	@nomU VARCHAR(25),
	@clave VARCHAR(25),
	@rol VARCHAR(50),
	@codigo_area VARCHAR(50)
	AS
		DECLARE @id_area INT

		SELECT @id_area = id
		FROM tarea_funcional
		WHERE @codigo_area = codigo

		INSERT INTO templeado (cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, 
													  correo, usuario, clave, rol, id_area_funcional)
		VALUES (@cedula, @nom1, @nom2, @ape1, @ape2, @correo, @nomU, @clave, @rol, @id_area)

CREATE PROCEDURE pa_registrar_departamento
	@nombre VARCHAR(50),
	@codigo VARCHAR(50),
	@descripcion VARCHAR(300)
	AS
		INSERT INTO tarea_funcional (nombre, codigo, descripcion)
		VALUES (@nombre, @codigo, @descripcion)


CREATE PROCEDURE pa_obtener_codigos_area_funcional
AS
SELECT codigo FROM tarea_funcional

CREATE PROCEDURE pa_obtener_codigos_procesos
AS
SELECT codigo FROM tproceso

CREATE PROCEDURE pa_obtener_cedulas_empleados
AS
SELECT cedula FROM templeado

CREATE PROCEDURE pa_obtener_codigos_tareas
AS
SELECT codigo FROM ttarea