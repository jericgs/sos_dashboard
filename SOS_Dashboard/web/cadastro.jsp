<%-- 
    Document   : cadastro
    Created on : 02/08/2018, 12:43:44
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Admin - Cadastro</title>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.min.css"> 
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/paper-bootstrap-wizard.css"/>


        <!--  Material Dashboard CSS  -->
        <link href="Resources/node_modules/bootstrap/compiler/style-page3.css" rel="stylesheet" />

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="Resources/node_modules/bootstrap/compiler/demo.css" rel="stylesheet" />        

        <!-- Icone -->        
        <link rel="icon" type="image/png" href="Resources/imagens/icons/icon.ico">

        <!-- Alertas Sweetalert -->
        <link rel="stylesheet" href="Resources/node_modules/sweetalert2/css/sweetalert2.min.css">
        <script src="Resources/node_modules/sweetalert2/dist/sweetalert2.min.js"></script>       

        <!--     Fonts and icons     -->               
        <link rel="stylesheet" href="Resources/font-awe/material-icons.min.css">
        <link rel="stylesheet" href="Resources/font-awe/themify-icons.css">
        <link rel="stylesheet" href="Resources/font-awe/roboto.min.css">

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
                        <a class="simple-text textLogo">
                            SOS Dashboard
                        </a>                        
                    </a>                        
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li>
                            <a href="./areaAdmin.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Painel</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="controle?logica=Cadastro&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">person_add</i>
                                <p>Cadastro</p>
                            </a>
                        </li>
                        <li>
                            <a href="controle?logica=Monitoramento&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">location_on</i>
                                <p>Monitoramento</p>
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
                            <a class="navbar-brand"> Cadastro De Pessoa </a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">                                                        
                                <li>
                                    <a href="controle?logica=Logout&status=${sessionScope.status}&nomeUsuario=${sessionScope.admin.nomeUsuario}">
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

                    <div class="card wizard-card" data-color="red" id="wizardProfile">
                        <form action="" method="">
                            <!--        You can switch " data-color="orange" "  with one of the next bright colors: "blue", "green", "orange", "red", "azure"          -->

                            <div class="wizard-header text-center">
                                <h3 class="wizard-title">Novo Registro</h3>
                                <p class="category">Essas informações serão de uso exclusivo do SAMU.</p>
                            </div>

                            <div class="wizard-navigation">
                                <div class="progress-with-circle">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 21%;"></div>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#about" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-user"></i>
                                            </div>
                                            Sobre
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#account" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-settings"></i>
                                            </div>
                                            Work
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#address" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-map"></i>
                                            </div>
                                            Address
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="about">
                                    <h5 class="info-text"> Por favor, conte-nos mais. </h5>
                                    <div class="row">                                        
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">CPF</label>                                                            
                                                <input id="cpf" name="cpf" maxlength="14" type="text" value="" class="form-control">
                                            </div>                                                            
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">RG</label>
                                                <input id="rg" name="rg" maxlength="11" type="text" value="" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Data de Nascimento</label>
                                                <input id="nascimento" name="nascimento" maxlength="10" type="text" value="" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Nome</label>
                                                <input id="nome" name="nome" type="text" onkeyup="maiuscula('nome')"  class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-4">                                                     
                                            <div class="form-group"  style="margin-top: 0px">
                                                <label class="control-label" style="margin-top: 12px">Genero</label>                                                        
                                                <select id="combobox" name="genero" class="form-control selectpicker required" data-style="select-with-transition" data-size="2">                                                                                                           
                                                    <option name="feminino" value="feminino">Feminino</option>
                                                    <option name="masculino" value="masculino">Masculino</option>                                                    
                                                </select>                                                        
                                            </div>                                                                                                                                                     
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="account">
                                    <h5 class="info-text"> What are you doing? (checkboxes) </h5>
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-2">
                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="jobb" value="Design">
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="ti-paint-roller"></i>
                                                        <p>Design</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="jobb" value="Code">
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="ti-pencil-alt"></i>
                                                        <p>Code</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="jobb" value="Develop">
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="ti-star"></i>
                                                        <p>Develop</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="address">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text"> Are you living in a nice area? </h5>
                                        </div>
                                        <div class="col-sm-7 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Street Name</label>
                                                <input type="text" class="form-control" placeholder="5h Avenue">
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Street Number</label>
                                                <input type="text" class="form-control" placeholder="242">
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>City</label>
                                                <input type="text" class="form-control" placeholder="New York...">
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>Country</label><br>
                                                <select name="country" class="form-control">
                                                    <option value="Afghanistan"> Afghanistan </option>
                                                    <option value="Albania"> Albania </option>
                                                    <option value="Algeria"> Algeria </option>
                                                    <option value="American Samoa"> American Samoa </option>
                                                    <option value="Andorra"> Andorra </option>
                                                    <option value="Angola"> Angola </option>
                                                    <option value="Anguilla"> Anguilla </option>
                                                    <option value="Antarctica"> Antarctica </option>
                                                    <option value="...">...</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <button type="button" style="text-transform: uppercase;" class="btn btn-next btn-fill btn-primary" name="logica" value="Next">Próximo</button>                                    
                                    <button type="submit" style="text-transform: uppercase;" class="btn btn-finish btn-fill btn-primary" name="logica" value="">Gravar</button>                                    
                                </div>

                                <div class="pull-left">
                                    <button type="button" style="text-transform: uppercase;" class="btn btn-previous btn-fill btn-primary" name="logica" value="Previous">Voltar</button>                                   
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </form>
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

    <script type="text/javascript">
        /* Máscaras ER */
        function mascara(o, f) {
            v_obj = o;
            v_fun = f;
            setTimeout("execmascara()", 1);
        }
        function execmascara() {
            v_obj.value = v_fun(v_obj.value);
        }
        function cpf(v) {
            v = v.replace(/\D/g, "");
            v = v.replace(/(\d{3})(\d)/, "$1.$2");
            v = v.replace(/(\d{3})(\d)/, "$1.$2");
            v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
            return v;
        }
        function rg(v) {
            v = v.replace(/\D/g, "");
            v = v.replace(/(\d{3})(\d)/, "$1.$2");
            v = v.replace(/(\d{3})(\d)/, "$1.$2");            
            return v;
        }
        function data(v) {
            v = v.replace(/\D/g, "");
            v = v.replace(/(\d{2})(\d)/, "$1/$2");
            v = v.replace(/(\d{2})(\d)/, "$1/$2");           
            return v;
        }
        function id(el) {
            return document.getElementById(el);
        }
        window.onload = function () {
            id('cpf').onkeyup = function () {
                mascara(this, cpf);
            };
            id('rg').onkeyup = function () {
                mascara(this, rg);
            };
            id('nascimento').onkeyup = function () {
                mascara(this, data);
            };
        };
    </script>

    <script>
        function maiuscula(id) {

            var letra = document.getElementById(id).value;
            letra = letra.split("");
            var tmp = "";
            for (i = 0; i < letra.length; i++) {
                if (letra[i - 1]) {
                    if (letra[i - 1] === " ") {
                        letra[i] = letra[i].replace(letra[i], letra[i].toUpperCase());
                    }
                } else {
                    letra[i] = letra[i].replace(letra[i], letra[i].toUpperCase());
                }
                tmp += letra[i];
            }
            document.getElementById(id).value = tmp;
        }
    </script>

</html>
