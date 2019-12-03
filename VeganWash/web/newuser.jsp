<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.: Novo Usuário :.</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script type="text/javascript">
            function buscaEndereco() {
                var cep = document.getElementById("cep").value;
                var xmlhttp = new XMLHttpRequest();
                var url = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=json";
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.status === 200) {
                        if (xmlhttp.readyState === 4) {
                            var endereco = JSON.parse(xmlhttp.responseText);
                            if (endereco.resultado == "1") {
                                document.getElementById("tipo").value = endereco.tipo_logradouro;
                                document.getElementById("logradouro").value = endereco.logradouro;
                                document.getElementById("bairro").value = endereco.bairro;
                                document.getElementById("cidade").value = endereco.cidade;
                                document.getElementById("estado").value = endereco.uf;
                            } else {
                                alert("Endereco nao encontrado pelo CEP informado");
                            }
                        }
                    }
                };
                xmlhttp.open("GET", url, true);
                xmlhttp.send();

            }
        </script>
    </head>
    <body>

        <div class="container-fluid">
            <div class="row" id="titulo">

                <div class="col-md-8">
                    <h1 class="text-center">
                        Seja um Fornecedor	
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="newuser" method="post">
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
                                Digite o CEP
                            </label>
                            <input type="text" class="form-control" id="cep" name="txtCep" onblur="buscaEndereco();"/>                            
                        </div>

                        <div class="form-group">
                            <label for="tipo">
                                Tipo do Logradouro
                            </label>
                            <input type="text" readonly="true" class="form-control" id="tipo" name="txtTipo" />
                        </div>
                        <div class="form-group">
                            <label for="logradouro">
                                Logradouro
                            </label>
                            <input type="text" readonly="true" class="form-control" id="logradouro" name="txtLogradouro" />
                        </div>
                        <div class="form-group">
                            <label for="numero">
                                Numero
                            </label>
                            <input type="text" class="form-control" id="numero" name="txtNumero" />
                        </div>
                        <div class="form-group">
                            <label for="complemento">
                                Complemento
                            </label>
                            <input type="text" class="form-control" id="complemento" name="txtComplemento" />
                        </div>
                        <div class="form-group">
                            <label for="bairro">
                                Bairro
                            </label>
                            <input type="text" readonly="true" class="form-control" id="bairro" name="txtBairro" />
                        </div>
                        <div class="form-group">
                            <label for="cidade">
                                Cidade
                            </label>
                            <input type="text" readonly="true"  class="form-control" id="cidade" name="txtCidade" />
                        </div>
                        <div class="form-group">
                            <label for="estado">
                                Estado
                            </label>
                            <input type="text" readonly="true" class="form-control" id="estado" name="txtEstado" />
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