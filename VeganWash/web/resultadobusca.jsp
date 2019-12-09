<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.: Resultado Busca :.</title>
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
        <h1>
            Todos os Produtos:
        </h1>
        <div class="col-md-2">
            <a href="./meucarrinho">Carrinho</a>  
        </div>
        <!-- row dos produtos -->

        <c:forEach var="Produto" items="${Lista}">
            <div class="row">
                <div class="col-md-8">
                    <a href="detalheProduto?idProduto=${Produto.idProduto}&nomeProduto=${Produto.nomeProduto}">${Produto.nomeProduto}</a>
                    <h3>
                        ${Produto.nomeProduto}
                    </h3>
                    <h4> 
                        R$/m2 ${Produto.valorM2} 
                    </h4>
                </div>
            </div>
        </c:forEach> 

    </body>
</html>
