drop database veganwasher;
create database veganwasher;
use veganwasher;
create table Usuario(
	idUsuario int unique not null auto_increment primary key,
    nome varchar(255),
    email varchar(255),
    senha char(40),
    idTipo int,
    
    telefone int,
    logradouro varchar(255),
    numeroEndereco int,
    complemento varchar(255),
    cidade varchar(255),
    bairro varchar(255),
    estado varchar(255),
    cep int
    )
;
create table Limpeza(
	idLimpeza int unique not null primary key auto_increment,
    descLimpeza varchar(255)
);
create table Produto(
	idProduto int unique not null primary key auto_increment,
    idUsuario int,
	idLimpeza int,
    valorM2 double,
    foreign key (idUsuario) REFERENCES Usuario(idUsuario),
    foreign key (idLimpeza) REFERENCES Limpeza(idLimpeza)
);
create table Pedido(
	idPedido int primary key unique not null auto_increment,
    idProduto int,
    idUsuario int,
    status varchar(255),
    m2 double,
    data datetime,
    periodo varchar(255),
    foreign key (idProduto) REFERENCES Produto(idProduto),
    foreign key (idUsuario) REFERENCES Usuario(idUsuario)
    )
;
show tables from veganwasher;