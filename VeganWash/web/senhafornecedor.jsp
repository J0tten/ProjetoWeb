<%-- 
    Document   : esqueciUsuario
    Created on : Dec 5, 2019, 1:31:00 PM
    Author     : GUILHERME
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

        <title>.: Esqueci a senha - Usuario :.</title>
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row" id="titulo">

                <div class="col-md-8">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link active" href='index.html'>Home</a>
                        </li>
                    </ul>
                    <h1 class="text-center">
                        Mude sua senha	
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="senhafornecedor" method="post">
                        <div class="form-group">
                            <label for="email">
                                Email
                            </label>
                            <input type="email" class="form-control" id="email" name="txtEmail"/>
                        </div>
                        <div class="form-group">
                            <label for="senha">
                                Senha
                            </label>
                            <input type="password" class="form-control" id="senha" name="txtNewSenha"/>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Enviar
                        </button>
                        <hr>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </div>
    </body>
</html>
