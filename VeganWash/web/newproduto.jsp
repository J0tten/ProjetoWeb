<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.: Novo Produto :.</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="./Imagens/Icon-folinha.jpg">

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
                        Crie um produto:	
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="newproduto" method="post">
                        <div class="form-group">
                            <label for="nome">
                                Nome do seu produto
                            </label>
                            <input type="text" class="form-control" id="nome" name="prodNome" />
                        </div>
                        <div class="form-group">
                            <label for="valorM2">
                                Valor do Metro Quadrado
                            </label>
                            <input type="text" class="form-control" id="valorM2" name="valorm2"/>
                        </div>
                        <div class="form-group">
                            <select name="dropLavagem">
                                <option value="Limpeza Simples">Limpeza Simples</option>
                                <option value="Limpeza Completa">Limpeza Completa</option>
                                <option value="Limpeza Super Extreme Vegana">Limpeza Super Extreme Vegana</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Enviar Dados
                        </button>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
            </div>


            <div class="row" id="rodape">
                <div class="col-md-12" id="rodapetxt">
                    <h4> Conheça mais</h4>
                    <p> O que temos aqui?</p>
                    <p> Entre em contato pelo e-mail <a href="mailto:veganwash@gmail.com">veganwash@gmail.com</a></p> 
                </div>
            </div>
        </div>


    </body>
</html>
