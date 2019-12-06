drop database veganwasher;
create database veganwasher;
use veganwasher;
create table Usuario(
	idUsuario int unique not null auto_increment primary key,
    nome varchar(255),
    email varchar(255) unique,
    senha char(40),
    telefone varchar(255)
    );
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
    idProduto int,
    idUsuario int,
    status varchar(255),
    m2 double,
    data date,
    periodo varchar(255), 
    foreign key (idProduto) REFERENCES Produto(idProduto),
    foreign key (idUsuario) REFERENCES Usuario(idUsuario)
    );


INSERT INTO limpeza VALUES(null, 'Limpeza Simples', 'Limpeza simples, remoção de poeira');
INSERT INTO limpeza VALUES(null, 'Lavagem Completa', 'Lavagem completa, com lavagem de pisos frios e banheiros');
INSERT INTO limpeza VALUES(null, 'Lavagem Super Extreme Vegana', 'Nosso carro-chefe, utilizamos produtos orgânicos e veganos para deixar seu ambiente ecologicamente limpo');