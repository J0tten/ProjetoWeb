show tables from veganwasher;
insert into usuario (nome)
values ("Victor");
insert into fornecedor (nome)
values ("Pedro");
insert into limpeza (nome, descLimpeza)
values 
	("Vegana", "Limpeza com produtos sem nenhuma origem animal"),
    ("Vegetariana","Limpeza com produtos sem o uso de Carne");
insert into produto(idFornecedor, idLimpeza, valorM2)
values ((SELECT idFornecedor from fornecedor where fornecedor.Nome = "Pedro"),(SELECT idLimpeza from Limpeza where Limpeza.Nome = "Vegana"),30);
Select * from usuario;
Select * from limpeza;
select * from produto;
insert into pedido(idUsuario, idProduto, status, m2, data, periodo)
Values ((SELECT idUsuario from Usuario where usuario.Nome = "Victor"),(select idProduto from produto,limpeza where produto.idLimpeza=Limpeza.idLimpeza and limpeza.nome = "Vegana"),"Pronto",20,"1994-10-13 00:00:00","Tarde");
select * from pedido;
SELECT idFornecedor from fornecedor where fornecedor.Nome = "Pedro";
select idProduto from produto,limpeza where produto.idLimpeza=Limpeza.idLimpeza and limpeza.nome = "Vegana";
delete from fornecedor where idFornecedor=2;
