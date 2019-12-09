<%-- 
    Document   : meucarrinho
    Created on : 09/12/2019, 20:28:33
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean id="Carrinho" type="br.edu.ufabc.VeganWash.model.Carrinho" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>
        <div class="row">
            <div class="col-md-2">
                <strong><h4>Excluir</h4></strong>
            </div>
            <div class="col-md-8">
                <strong><h4>Produto</h4></strong>
            </div>
            <div class="col-md-2">
                <strong><h4>Qtde</h4></strong>
            </div>
        </div>
        <c:if test="${Carrinho.itens.size() eq 0}">
            <div class="row">
                <div class="col-md-12">
                    <h3 align="center">Carrinho Vazio </h3>
                </div>
            </div>
        </c:if>

        <c:if test="${Carrinho.itens.size() gt 0}">
            <c:forEach var="item" items="${Carrinho.itens}">
                <div class="row">
                    <div class="col-md-2">
                        <h4><a href="./removerProduto?item=${item.produto.idProduto}&">x</a></h4>
                    </div>
                    <div class="col-md-8">
                        <h4>${item.produto.nomeProduto}</h4>
                    </div>
                    <div class="col-md-2">
                        <h4>${item.m2}</h4>
                    </div>
                </div>
                <form role="form" action="finalizarCompra" method="post">
                    <button type="submit" class="btn btn-primary">
                        Finalizar Compra
                    </button>
                </form>
            </c:forEach>

            <div class="row">

                <div class="col-md-2">
                    &nbsp;
                </div>
                <div class="col-md-8">
                    <h3>Total R$ ${Carrinho.total}</h3>
                </div>
                <div class="col-md-2">
                    &nbsp;
                </div>

            </div>
        </c:if>
    </body>
</html>
