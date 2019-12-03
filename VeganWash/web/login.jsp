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

        <title>.: Login Usuario :.</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row" id="titulo">

                <div class="col-md-8">
                    <h1 class="text-center">
                        Crie sua conta	
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="login" method="post">
                        <div class="form-group">
                            <label for="email">
                                Seu Email
                            </label>
                            <input type="email" class="form-control" id="email" name="txtEmail"/>
                        </div>
                        <div class="form-group">
                            <label for="senha">
                                Digite sua Senha
                            </label>
                            <input type="password" class="form-control" id="senha" name="txtSenha"/>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Enviar Dados
                        </button>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </div>
    </body>
</html>
