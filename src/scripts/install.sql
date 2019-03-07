create table persona(
id integer auto_increment primary key,
nombres varchar(64) not null,
apellidos varchar(64) not null,
fecha_nacimiento date not null
);