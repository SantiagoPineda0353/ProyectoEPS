CREATE DATABASE eps;

\c eps;

CREATE TABLE medico(
licencia_medica VARCHAR(60) NOT NULL,
nombre VARCHAR(60) NOT NULL,
direccion VARCHAR(60) NOT NULL,
fecha_nac DATE NOT NULL,
PRIMARY KEY (licencia_medica)
);

CREATE TABLE telefono_medico(
telefono INT,
licencia_medica VARCHAR(60),
PRIMARY KEY (licencia_medica,telefono),
FOREIGN KEY (licencia_medica)
    REFERENCES medico(licencia_medica)
);

CREATE TABLE medico_titular(
fecha_ingreso DATE
) INHERITS (medico);

<<<<<<< HEAD
ALTER TABLE medico_titular 
    ADD CONSTRAINT medico_tit_pk
    PRIMARY KEY (licencia_medica);
=======
>>>>>>> Steven

CREATE TABLE medico_sustituto(
) INHERITS (medico);


ALTER TABLE medico_sustituto 
    ADD CONSTRAINT medico_sus_pk
    PRIMARY KEY (licencia_medica);

ALTER TABLE medico_sustituto
    ADD CONSTRAINT med_un UNIQUE (licencia_medica);

CREATE OR REPLACE FUNCTION insertar_en_medico()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO medico (licencia_medica, nombre, direccion, fecha_nac) VALUES (NEW.licencia_medica, NEW.nombre, NEW.direccion, NEW.fecha_nac);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insertar_en_medico_trigger
AFTER INSERT ON medico_titular
FOR EACH ROW
EXECUTE FUNCTION insertar_en_medico();

CREATE TRIGGER insertar_en_medico_trigger
AFTER INSERT ON medico_sustituto
FOR EACH ROW
EXECUTE FUNCTION insertar_en_medico();

CREATE TABLE periodo(
licencia_medica VARCHAR(60),
fecha_de_ingreso DATE,
fecha_de_salida DATE,
PRIMARY KEY (licencia_medica,fecha_de_ingreso,fecha_de_salida),
FOREIGN KEY (licencia_medica)
    REFERENCES medico_sustituto(licencia_medica)
);

CREATE TABLE dia(
id_dia INT,
nombre VARCHAR(10),
PRIMARY KEY (id_dia)
);

CREATE TABLE horario(
id_horario INT,
hora_fin TIME NOT NULL,
hora_inicio TIME NOT NULL,
id_dia INT NOT NULL,
PRIMARY KEY (id_horario),
FOREIGN KEY (id_dia)
    REFERENCES dia(id_dia)
);

CREATE TABLE medico_horario(
licencia_medica VARCHAR(60),
id_horario INT,
PRIMARY KEY (licencia_medica,id_horario),
FOREIGN KEY (licencia_medica)
    REFERENCES medico(licencia_medica),
FOREIGN KEY (id_horario)
    REFERENCES horario(id_horario)
);

CREATE TABLE estrato(
id_estrato INT,
PRIMARY KEY(id_estrato)
);

CREATE TABLE sede(
id_sede SERIAL,
nombre VARCHAR(60) NOT NULL,
PRIMARY KEY(id_sede)
);

CREATE TABLE paciente(
id_paciente INT,
nombre VARCHAR(60) NOT NULL,
direccion VARCHAR(60) NOT NULL,
fecha_nac DATE NOT NULL,
lugar_nac VARCHAR (60) NOT NULL,
id_estrato INT,
id_sede INT,
PRIMARY KEY (id_paciente),
FOREIGN KEY (id_estrato)
    REFERENCES estrato(id_estrato),
FOREIGN KEY (id_sede)
    REFERENCES sede(id_sede)
);

CREATE TABLE programa_especial(
id_programa SERIAL,
nombre VARCHAR(60) NOT NULL,
PRIMARY KEY(id_programa)
);

CREATE TABLE programa_especial_adulto(
id_paciente INT,
id_programa INT,
asistencia BOOLEAN,
PRIMARY KEY (id_paciente,id_programa),
FOREIGN KEY (id_paciente)
    REFERENCES paciente(id_paciente),
FOREIGN KEY (id_programa)
    REFERENCES programa_especial(id_programa)
);

CREATE TABLE telefono_paciente(
telefono INT,
id_paciente INT,
PRIMARY KEY (id_paciente,telefono),
FOREIGN KEY (id_paciente)
    REFERENCES paciente(id_paciente)    
);

CREATE TABLE correo_electronico(
correo_electronico VARCHAR(60),
id_paciente INT,
PRIMARY KEY (id_paciente,correo_electronico),
FOREIGN KEY (id_paciente)
    REFERENCES paciente(id_paciente)
);

CREATE TABLE modalidad(
id_modalidad SERIAL,
nombre VARCHAR(60) NOT NULL,
PRIMARY KEY (id_modalidad)
);

CREATE TABLE cita(
id_cita SERIAL UNIQUE,
id_paciente INT,
diagnostico VARCHAR(400) NULL,
fecha_hora TIMESTAMP NOT NULL,
id_modalidad INT NOT NULL,
id_sede INT NOT NULL,
id_medico VARCHAR(60) NOT NULL,
PRIMARY KEY(id_cita,id_paciente),
FOREIGN KEY (id_paciente)
    REFERENCES paciente(id_paciente),
FOREIGN KEY (id_modalidad)
    REFERENCES modalidad(id_modalidad),
FOREIGN KEY (id_sede)
    REFERENCES sede(id_sede),
FOREIGN KEY (id_medico)
    REFERENCES medico(licencia_medica)
);

CREATE TABLE examen(
id_examen SERIAL,
nombre VARCHAR(60) NOT NULL,
PRIMARY KEY (id_examen)
);

CREATE TABLE solicitar_examen(
id_cita INT NOT NULL,
id_paciente INT NOT NULL,
id_examen INT NOT NULL,
PRIMARY KEY(id_cita,id_paciente,id_examen),
FOREIGN KEY (id_paciente)
    REFERENCES paciente(id_paciente),
FOREIGN KEY (id_cita)
    REFERENCES cita(id_cita),
FOREIGN KEY (id_examen)
    REFERENCES examen(id_examen)
);


