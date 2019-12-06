<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>VeganClean - LoginUser</title>
    <link rel="icon" href="https://png.pngtree.com/element_pic/17/03/03/7aaa411575b231bb11a9dae2798450b4.jpg">

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
						Login Cliente
					</h3>
					<form role="form" action="loginusuario" method="post">
						<div class="form-group">
							 
							<label for="email">
								Email
							</label>
							<input type="email" class="form-control" id="email" name='txtEmail'/>
						</div>
						<div class="form-group">
							 
							<label for="senha">
								Senha
							</label>
							<input type="password" class="form-control" id="senha" name="txtSenha"/>
						</div>
						<button type="submit" class="btn btn-primary">
							Entrar
						</button>
                                            <p class="text-center">
                                                <a href="senhausuario.jsp">Esqueceu a senha?!</a>	
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
						Você ainda não tem uma conta conosco?!
                                                Faça seu cadastro aqui e junte -se a uma comunidade mais conciente e satisfeita com os serviços de limpeza.
                                        </p> 
                                        <a class="btn btn-primary btn-large" href='newuser.jsp'>Criar</a>
				</div>
				<div class="col-md-1">
				</div>
				<div class="col-md-3">
					<h3>
						Fornecedor?
					</h3>
					<p>
						Você por acaso é um fornecedor e esta tentando logar?
                                                Entre por aqui para poder acessar sua área exclusiva!
					</p>
                                        <a class="btn btn-primary btn-large" href='loginfornecedor.jsp'>Logar</a>
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
  </body>
</html>
