<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>VeganClean - LoginForn</title>
    <link rel="icon" href="./Imagens/Icon-folinha.jpg">

    <meta name="description" content="x">
    <meta name="author" content="WashiWash">

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
			</ul>
			<div class="row">
				<div class="col-md-3">
					<h3>
						Login Fornecedor
					</h3>
					<form role="form" action="loginfornecedor" method="post">
						<div class="form-group">
							 
							<label for="email">
								Email
							</label>
							<input type="email" class="form-control" id="email" name='emailForn'/>
						</div>
						<div class="form-group">
							 
							<label for="senha">
								Senha
							</label>
							<input type="password" class="form-control" id="senha" name="senhaForn"/>
						</div>
						<button type="submit" class="btn btn-primary">
							Entrar
						</button>
                                            <p class="text-center">
                                                <a href="senhafornecedor.jsp">Esqueceu a senha?!</a>	
                                            </p>
					</form>
				</div>
				<div class="col-md-1">
				</div>
				<div class="col-md-3">
					<h3>
						Crie sua Conta!
					</h3>
					<p>
                                                Não é um de nossos fornecedores cadastrados?
                                                Faça seu cadastro aqui e junte -se a uma comunidade mais conciente!
                                                Seja nosso parceiro!
                                        </p> 
                                        <a class="btn btn-primary btn-large" href='newfornecedor.jsp'>Criar</a>
				</div>
				<div class="col-md-1">
				</div>
				<div class="col-md-3">
					<h3>
						Cliente?
					</h3>
					<p>
						Você por acaso é um Cliente e esta tentando logar?
                                                Esta no lugar errado! Entre aqui para logar em sua conta.
                                         </p>       
                                        <a class="btn btn-primary btn-large" href='loginusuario.jsp'>Logar</a>
				</div>
				<div class="col-md-1">
				</div>
			</div>
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    
    <%
        session.setAttribute("user", request.getParameter("emailForn"));
        %>
  </body>
</html>
