drop database veganwasher;
create database veganwasher;
use veganwasher;
create table Usuario(
	idUsuario int unique not null auto_increment primary key,
    nome varchar(255),
    email varchar(255) unique,
    senha char(40),
    telefone int
    )
;
create table Endereco(
	idEndereco int unique not null primary key auto_increment,
    logradouro varchar(255),
    numeroEndereco int,
    complemento varchar(255),
    cidade varchar(255),
    bairro varchar(255),
    estado varchar(255),
    cep int,
    idUsuario int,
    foreign key (idUsuario) REFERENCES Usuario(idUsuario)
);

create table Limpeza(
	idLimpeza int unique not null primary key auto_increment,
    nome varchar(50) unique,
    descLimpeza varchar(255)
);
create table Fornecedor(
	idFornecedor int unique not null primary key auto_increment,
    nome varchar(255),
    cpf int unique,
    telefone int,
    email varchar(255) unique,
    senha char(40)
);

create table Produto(
	idProduto int unique not null primary key auto_increment,
    idFornecedor int,
	idLimpeza int,
    valorM2 double,
    foreign key (idFornecedor) REFERENCES Fornecedor(idFornecedor),
    foreign key (idLimpeza) REFERENCES Limpeza(idLimpeza)
);
create table Pedido(
	idPedido int primary key unique not null auto_increment,
    idUsuario int,
    status varchar(255),
    data date,
    valorPedido float,    
    foreign key (idProduto) REFERENCES Produto(idProduto),
    foreign key (idUsuario) REFERENCES Usuario(idUsuario)
    )
;
create table ItemPedido(
	idItem int primary key unique not null,
    idProduto int,
    m2 float
);
