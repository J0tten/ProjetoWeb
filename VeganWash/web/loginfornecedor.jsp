<%-- 
    Document   : login
    Created on : 03/12/2019, 02:05:35
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.: Login Fornecedor :.</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row" id="titulo">

                <div class="col-md-8">
                    <h1 class="text-center">
                        Login de Fornecedor	
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="loginfornecedor" method="post">
                        <div class="form-group">
                            <label for="email">
                                Email
                            </label>
                            <input type="email" class="form-control" id="email" name="emailForn"/>
                        </div>
                        <div class="form-group">
                            <label for="senha">
                                Senha
                            </label>
                            <input type="password" class="form-control" id="senha" name="senhaForn"/>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Enviar
                        </button>
                        <div class="col-md-8">
                            <h1 class="text-center">
                                <a href="senhafornecedor.jsp">Esqueci a senha</a>	
                            </h1>
                        </div>
                        <hr>

                        <div class="col-md-8">
                            <h1 class="text-center">
                                Não é um de nossos fornecedores cadastrados? Cadastre-se <a href="newfornecedor.jsp">AQUI</a>	
                            </h1>
                        </div>
                        <hr>
                        <div class="col-md-8">
                            <h1 class="text-center">
                                <a href="loginusuario.jsp">Área do Cliente</a>	
                            </h1>
                        </div>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </div>
    </body>
</html>
