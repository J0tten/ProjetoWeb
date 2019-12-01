drop database veganwasher;
create database veganwasher;
use veganwasher;
create table Usuario(
	idUsuario int unique not null auto_increment primary key,
    nome varchar(255),
    email varchar(255),
    senha char(40),
    idTipo int
    )
;
create table Endereco(
	idEndereco int unique not null primary key auto_increment,
    telefone int,
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
    nome varchar(50),
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
    data date,
    periodo varchar(255), 
    foreign key (idProduto) REFERENCES Produto(idProduto),
    foreign key (idUsuario) REFERENCES Usuario(idUsuario)
    )
;
show tables from veganwasher;
insert into usuario (nome)
values ("Victor");
insert into usuario (nome)
values ("Pedro");
insert into limpeza (nome)
values ("Vegana");
insert into produto(idUsuario, idLimpeza, valorM2)
values (2,1,30);
Select * from usuario;
Select * from limpeza;
select * from produto;
insert into pedido(idUsuario, idProduto, status, m2, data, periodo)
Values ((SELECT idUsuario from usuario where usuario.Nome = "Victor"),(select idProduto from produto,limpeza where produto.idLimpeza=Limpeza.idLimpeza and limpeza.nome = "Vegana"),"Pronto",20,"1994-10-13 00:00:00","Tarde");
select * from pedido;