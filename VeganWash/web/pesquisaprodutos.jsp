<%-- 
    Document   : listaprodutos
    Created on : 03/12/2019, 02:05:47
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link active" href='index.html'>Home</a>
            </li>
        </ul>
        <h1>Funcionou Login!</h1>
        <%
            String name = request.getParameter("txtEmail");
            out.print("Welcome " + name);

            session.setAttribute("user", name);
        %>
    </body>
</html>
