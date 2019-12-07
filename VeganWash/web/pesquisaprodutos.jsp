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
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">
        <%
            String name = request.getParameter("nomeBusca");

            session.setAttribute("nomeBusca", name);
        %>
    </head>
   
  <body>
      
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<ul class="nav">
				<li class="nav-item">
					<a class="nav-link active" href='index.html'>Home</a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-3">

					<form role="form" action="pesquisaprodutos" method="post">
						<div class="form-group">
							<label for="busca">
								Produto
							</label>
							<input type="text" class="form-control" id="email" name='nomeBusca'/>
						</div>
						<button type="submit" class="btn btn-primary">
							Pesquisar
						</button>
              
					</form>
				</div>
	
    </body>
</html>
