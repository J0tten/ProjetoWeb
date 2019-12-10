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
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">

        <meta name="description" content="x">
        <meta name="author" content="WashiWash">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
            <ul class="nav">
                <li class="nav-item">
                    <a href="javascript:history.go(-1)"> Voltar para a Vitrine</a>
                </li>
            </ul>
            <div class="row">
				<div class="col-md-3">
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
                                M<sup>2</sup> à adicionar
                            </label>
                            
                                <input type="number" class="form-control" id="quantM2" name="quantm2" min="1" value="1">
                           
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Adicionar ao Carrinho
                        </button>
                    </form>
                </div>
            </div>
                </div>
                    <div class="col-md-1">
				</div>
                    
            </div>
        </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
