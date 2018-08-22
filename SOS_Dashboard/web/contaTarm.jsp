<%-- 
    Document   : conta
    Created on : 20/08/2018, 13:44:46
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Tarm - Conta</title>

        <!-- Required meta tags -->                    
        <meta charset="utf-8">                     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.min.css">                
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/paper-bootstrap-wizard.css"/>

        <!--  Material Dashboard CSS    -->
        <link href="Resources/node_modules/bootstrap/compiler/style-page3.css" rel="stylesheet" />

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="Resources/node_modules/bootstrap/compiler/demo.css" rel="stylesheet" />        

        <!-- Icone -->        
        <link rel="icon" type="image/png" href="Resources/imagens/icons/icon.ico">

        <!-- Alertas Sweetalert -->
        <link rel="stylesheet" href="Resources/node_modules/sweetalert2/css/sweetalert2.min.css">
        <script src="Resources/node_modules/sweetalert2/dist/sweetalert2.min.js"></script>       

        <!--     Fonts and icons     -->       
        <link rel="stylesheet" href="Resources/font-awe/roboto.min.css">
        <link rel="stylesheet" href="Resources/font-awe/material-icons.min.css">

    </head>

    <body>

        <c:if test="${sessionScope.status == null}">
            <jsp:forward page="controle?logica=Login&usuario=L&senha=S"></jsp:forward>                
        </c:if>

        <div class="wrapper">
            <div class="sidebar" data-color="red" data-image="Resources/imagens/body/sidebar.png">
                <!-- Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"
    
                    Tip 2: you can also add an image using data-image tag
                -->
                <div class="logo">

                    <a class="simple-text logo-tim">
                        <div>
                            <img src="Resources/imagens/icons/dashboard-logo.png">       
                        </div> 
                        <a class="simple-text textLogo" style="padding-top: 12px;">
                            SOS Dashboard
                        </a>                        
                    </a>                        
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li>
                            <a href="./areaTarm.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Painel</p>
                            </a>
                        </li>                                                
                        <li>
                            <a href="controle?logica=ChamadoSolicitante&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
                                <i class="material-icons">library_books</i>
                                <p>Chamado</p>
                            </a>
                        </li>
                        <li>
                            <a href="controle?logica=Encaminhamento&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
                                <i class="material-icons">bubble_chart</i>
                                <p>Andamento</p>
                            </a>
                        </li>
                        <li>
                            <a href="controle?logica=Mapa&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
                                <i class="material-icons">location_on</i>
                                <p>Mapa</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="controle?logica=Conta&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
                                <i class="material-icons">settings</i>
                                <p>Conta</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <nav class="navbar navbar-transparent navbar-absolute">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand"> Configurações de Conta </a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">                                                        
                                <li>
                                    <a href="controle?logica=Logout&status=${sessionScope.status}&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
                                        <i class="material-icons">exit_to_app</i>
                                        <p class="hidden-lg hidden-md">Sair</p>
                                    </a>                                
                                </li>
                            </ul>
                            <form class="navbar-form navbar-right"></form>
                        </div>
                    </div>
                </nav>
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div>
                                <div class="card wizard-card">
                                    <div class="card-header" data-background-color="red">
                                        <h4 class="title">Alteraçao de Credencial</h4>
                                        <p class="category">Atualização - 1/1</p>
                                    </div>
                                    <div class="card-content">
                                        <form id="formCredencial" action="controle" method="post">
                                            
                                            <!-- CAMPOS DA TELA ANTERIOR -->
                                            <input type="hidden" name="nomeUsuario" value="${sessionScope.tarm.nomeUsuario}">
                                            
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class='control-label'>Login</label>
                                                        <input id='login' type='text' name='loginC' onblur="verificandoUserName()" maxlength='30' value='${sessionScope.tarm.nomeUsuario}' class='form-control' disabled>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class='control-label'>Senha</label>
                                                        <input id='senha' type='password' name='senha' value='' maxlength='8' class='form-control'>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class='control-label'>Repita a senha</label>
                                                        <input id='senhaR' type='password' name='senhaR'  maxlength='8' value='' class='form-control'>
                                                    </div>                                                    
                                                </div>
                                            </div>                                                                                                                                                                                                                                                                                                                
                                            <button type="submit" style="text-transform: uppercase;" class="btn btn-primary pull-right" name="logica" value="GravarCredenciamentoTarm">Atualizar</button>
                                            <div class="clearfix"></div>
                                        </form>
                                    </div>
                                </div>                            
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <!--   Core JS Files   -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/bootstrap.min.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/material.min.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/jquery.bootstrap.wizard.js" type="text/javascript"></script> 

    <!-- JS Select -->    
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/bootstrap-selectpicker.js" type="text/javascript"></script>

    <!--  Plugin for the Wizard -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/paper-bootstrap-wizard.js" type="text/javascript"></script>

    <!--  More information about jquery.validate here: http://jqueryvalidation.org/-->
    <script charset="UTF-8" src="Resources/node_modules/bootstrap/js/disp-dasboard/jquery.validate.min.js" type="text/javascript"></script>

    <!--  Charts Plugin -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/chartist.min.js"></script>
    <!--  Dynamic Elements plugin -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/arrive.min.js"></script>
    <!--  PerfectScrollbar Library -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/perfect-scrollbar.jquery.min.js"></script>
    <!--  Notifications Plugin    -->
    <!-- <script src="Resources/node_modules/bootstrap/js/disp-dasboard/disp-dasboard/bootstrap-notify.js"></script>-->
    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8kJ3p081G1hbsHQLkydJg8AtpVUznejw"async defer></script>
    <!-- Material Dashboard javascript methods -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/material-dashboard.js?v=1.2.0"></script>
    <!-- Material Dashboard DEMO methods, don't include it in your project! -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/demo.js"></script>
    <!-- momentjs.com -->        
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/moment-with-locales.js"></script>

    <script>

        function verificandoUserName() {

            var valorLogin = document.getElementById("login").value;

            $.post("AjaxControle", {logicaAjax: "AjaxValidacaoUserName", login: valorLogin}, function (data, status) {

                var objDados = JSON.parse(data);

                if (objDados[0].confirmacao === 'false') {

                    swal({type: 'info', title: 'Oops...', text: 'O usuário: ' + valorLogin + '. Já existe.', showConfirmButton: false, timer: 4000});
                    document.getElementById("login").value = "";
                }

            });

        }

    </script>
    
    <script>
        <c:if test="${not empty alerta.tipoAlerta}">
        swal({type: '${alerta.tipoAlerta}', title: 'Hey...', text: '${alerta.msnAlerta}', showConfirmButton: false, timer: 2500}).then((value) => {
            location.href = "controle?logica=Conta&nomeUsuario=${sessionScope.tarm.nomeUsuario}";
        });
        </c:if>
    </script>

</html>
