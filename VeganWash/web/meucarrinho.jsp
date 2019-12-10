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
        <title>Carrinho!</title>
        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/style.css" rel="stylesheet">
        <meta name="description" content="x">
        <meta name="author" content="WashiWash">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
       
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link active" href="index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="javascript:history.go(-2)">Voltar para a Vitrine</a>
                        </li>
                    </ul>

                    <div>
                        Carrinho do usuário: ${user.nome}            
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <strong><h6>Excluir</h6></strong>
                        </div>
                        <div class="col-md-8">
                            <strong><h4>Produto</h4></strong>
                        </div>
                        <div class="col-md-2">
                            <h5>Qtde</h5>
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
                                    <h7><a class="btn-danger" href='./removerProduto?item=${item.produto.idProduto}&'>X</a></h7>
                                </div>
                                <div class="col-md-8">
                                    <h7>${item.produto.nomeProduto}</h7>
                                </div>
                                <div class="col-md-2">
                                    <h7>${item.m2} M<sup>2</sup</h7>
                                </div>
                                <br>
                            </div>

                        </c:forEach>
                        <c:if test="${Carrinho.itens.size() gt 0}">
                            <form role="form" action="finalizarCarrinho" method="post">
                                <br>
                                <button type="submit" class="btn btn-primary">
                                    Finalizar Compra
                                </button>
                            </form>                
                        </c:if>

                        <div class="row">

                            <div class="col-md-2">
                                &nbsp;
                            </div>
                            <div class="col-md-8">
                                <h5>Total R$ ${Carrinho.total}</h5>
                            </div>
                            <div class="col-md-2">
                                &nbsp;
                            </div>

                        </div>
                    </c:if>
             
    </body>
</html>
