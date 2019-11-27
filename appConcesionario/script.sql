create table Administradores(
    id varchar(20) primary key,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    username varchar(30) not null,
    password varchar(30) not null
);
create table Vehiculos(
    matricula varchar(10) primary key,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    precio int not null,
    imagen blob not null
);
create table Clientes(
    id varchar(20) primary key,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    email varchar(50) not null,
    tel varchar(20) not null
);
create table Ventas (
    idVenta int primary key auto_increment,
    idAdmin varchar(20) not null,
    idCliente varchar(20) not null,
    matriculaCoche varchar(10) not null,
    precio int not null,
    foreign key (idAdmin) references Administradores(id), 
    foreign key (idCliente) references Clientes(id),
    foreign key (matriculaCoche) references Vehiculos(matricula)
);
