-- Postgres
CREATE DATABASE Tutorias;


CREATE TABLE prueba (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    edad INTEGER,
    correo VARCHAR(255),
    fecha_nacimiento Date
);
