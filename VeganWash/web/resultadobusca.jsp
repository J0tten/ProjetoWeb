<%-- 
    Document   : listaprodutos
    Created on : 03/12/2019, 02:05:47
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Lista" type="java.util.List" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.: Resultado Busca :.</title>
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">
        <%
            String name = request.getParameter("txtEmail");

            session.setAttribute("user", name);
        %>
    </head>
   
  <body>
     <!-- row dos produtos -->
            <c:forEach var="produto" items="${Lista}">
                <div class="row">
                    <div class="col-md-8">
                        <h3>
                            <a href="detalheProduto?id=${produto.id}">${produto.titulo}</a>
                        </h3>
                        <p>
                            ${produto.descricao}
                        <h4> ${produto.nomeproduto} </h4>
                        <h4> R$ ${produto.valorM2} </h4>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <div class="carousel slide" id="carousel-${produto.id}">
                                <ol class="carousel-indicators">
                                        <li data-slide-to="0" data-target="#carousel-${produto.id}" class="active">
                                        </li>
                                        <li data-slide-to="1" data-target="#carousel-${produto.id}">
                                        </li>
                                        <li data-slide-to="2" data-target="#carousel-${produto.id}">
                                        </li>
                                </ol>
                               
                                </div> <a class="carousel-control-prev" href="#carousel-${produto.id}" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-${produto.id}" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
                        </div>

                    </div>

                </div>
            </c:forEach> 
    
    </body>
</html>
