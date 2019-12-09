<%-- 
    Document   : detalheProduto
    Created on : 08/12/2019, 19:12:25
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="DetalheProduto" type="br.edu.ufabc.VeganWash.model.Produto" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe Produto</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-12">
                <h3>
                    ${DetalheProduto.nomeProduto}
                </h3>
                <p>
                    ${DetalheProduto.fornecedor.nome}
                </p>
                <h4> R$ ${DetalheProduto.valorM2}</h4>
                <form role="form" action="./adicionarCarrinho" method="post">
                    <div class="form-group">

                        <label for="quantidade">
                            Quantidade
                        </label>
                        <input type="number" class="form-control" id="txtQuandidade" name="txtQtde" min="1" value="1">
                    </div>
                    <button type="submit" class="btn btn-primary">
                        Adicionar ao Carrinho
                    </button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
