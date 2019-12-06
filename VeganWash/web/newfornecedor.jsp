<%-- 
    Document   : newfornecedor
    Created on : 03/12/2019, 00:42:56
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

        <title>.: Novo Fornecedor :.</title>
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
                        Seja um fornecedor!	
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="newfornecedor" method="post">
                        <div class="form-group">
                            <label for="nome">
                                Seu Nome
                            </label>
                            <input type="text" class="form-control" id="nome" name="txtNome" />
                        </div>
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
                        <div class="form-group">
                            <label for="Telefone">
                                Digite seu Telefone (Número)
                            </label>
                            <input type="text" class="form-control" id="telefone" name="txtTelefone"/>
                        </div>
                        <div class="form-group">
                            <label for="cep">
                                Digite o CPF
                            </label>
                            <input type="text" class="form-control" id="cpf" name="txtCpf"/>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Enviar Dados
                        </button>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
            </div>

    </body>
</html>
