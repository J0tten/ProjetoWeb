<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.: Vitrine :.</title>
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link active" href='index.html'>Home</a>
                        </li>
                                                <li class="nav-item">
                            <a class="nav-link active" href='./meucarrinho'>Carrinho</a>
                        </li>
                    </ul>
                    <h3>
                        Todos Produtos:
                    </h3>

                    <c:forEach var="Produto" items="${Lista}">
                        <div class="card">
                            <h5 class="card-header">
                                <a href="detalheProduto?idProduto=${Produto.idProduto}&nomeProduto=${Produto.nomeProduto}">${Produto.nomeProduto}</a>
                            </h5>
                            <div class="card-body">
                                <p class="card-text">
                                    Descrição do produto Bla bla bla mais imagem
                                </p>
                            </div>
                            <div class="card-footer">
                                R$ ${Produto.valorM2} /m²
                            </div>
                        </div> 
                    </c:forEach>    
                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
