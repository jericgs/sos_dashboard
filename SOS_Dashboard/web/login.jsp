<%-- 
    Document   : index
    Created on : 22/05/2018, 21:32:00
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Login</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.css">        
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/style.css">

        <!-- Icone -->        
        <link rel="icon" type="image/png" href="Resources/imagens/icons/icon.ico">

        <!-- CSS Style-->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/style-page2.css">

        <!-- Navbar Fixo no Top -->
        <link href="navbar-top-fixed.css" rel="stylesheet">

        <!-- Alertas Sweetalert -->
        <link rel="stylesheet" href="Resources/node_modules/sweetalert2/css/sweetalert2.min.css">
        <script src="Resources/node_modules/sweetalert2/dist/sweetalert2.min.js"></script>


        <!-- Font -->
        <link href= "https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel='stylesheet' type='text/css'>         

        <!-- Awesome  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body class="login-page">

        <div class="page-header" filter-color="orange">
            <div class="page-header-image" style="background-image:url(Resources/imagens/body/login.jpg)"></div>
            <div class="content">
                <div class="container">
                    <div class="col-md-5 ml-auto mr-auto">
                        <div class="card card-login card-plain">                            
                            <div class="card-header text-center">
                                <div class="logo-container">
                                    <img src="Resources/imagens/icons/now-logo.png" alt="">
                                </div>
                            </div>

                            <form action="login" method="post">
                                <div class="card-body"> 
                                    <div class="input-group form-group-no-border input-lg">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-user-circle"></i></span>
                                        </div>
                                        <input type="text" size="30" maxlength="30" class="form-control" name="usuario" value="" placeholder="Login">
                                    </div>
                                    <div class="input-group form-group-no-border input-lg">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-keyboard-o"></i></span>
                                        </div>
                                        <input type="password" size="8" maxlength="8" class="form-control" name="senha" value="" placeholder="Senha">
                                    </div> 
                                </div>               
                                <div class="card-footer text-center">
                                    <input type="submit" class="btn btn-login btn-round btn-lg btn-block" onclick="this.blur();" value="Entrar">
                                </div>
                            </form>                                                                                                                                                        

                            <div class="pull-right">
                                <h6><a href="#pablo1" class="link footer-link">Preciso de Ajuda?</a></h6>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>

            <footer class="footer " >


                <div class="container">                  
                    <div class="copyright">
                        &copy; <script>document.write(new Date().getFullYear())</script>, Coded by <a href="http://lattes.cnpq.br/1048245272218464" target="_blank">Erick Gomes</a>.
                    </div>
                </div>


            </footer>

        </div>

        <div>

        </div>

    </body>
</html>
