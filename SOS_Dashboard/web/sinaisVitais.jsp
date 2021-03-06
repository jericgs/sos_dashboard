<%-- 
    Document   : sinaisVitais
    Created on : 28/07/2018, 20:36:57
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>M�dico - S.Vitais</title>

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
                            <a href="./areaMedico.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Painel</p>
                            </a>
                        </li>                                                
                        <li>
                            <a href="controle?logica=ListaRegulacoes&nomeUsuario=${sessionScope.medico.nomeUsuario}">
                                <i class="material-icons">library_books</i>
                                <p>Regula��es</p>
                            </a>
                        </li>
                        <li class="active">
                            <a>
                                <i class="material-icons">bubble_chart</i>
                                <p>Andamento</p>
                            </a>
                        </li>
                        <li>
                            <a href="controle?logica=Conta&nomeUsuario=${sessionScope.medico.nomeUsuario}">
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
                            <a class="navbar-brand"> Adicionar Sinais Vitais </a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">                                                        
                                <li>
                                    <a href="controle?logica=Logout&status=${sessionScope.status}&nomeUsuario=${sessionScope.medico.nomeUsuario}">
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
                                        <h4 class="title">Registro de Sinais Vitais</h4>
                                        <p class="category">Sinais - 1/1</p>
                                    </div>
                                    <div class="card-content">
                                        <form id="formRegulacao" action="controle" method="post">  

                                            <!-- CAMPOS DA TELA ANTERIOR -->
                                            <input type="hidden" name="idR" value="${sessionScope.dadosSinaisVitais.idR}">                                            

                                            <div class="row">
                                                <div class="col-md-7">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Paciente</label>
                                                        <input id="paciente" type="text" name="nomePaciente" maxlength="50" value="${sessionScope.dadosSinaisVitais.nomePaciente}" onkeyup="maiuscula('paciente')" class="form-control" disabled>
                                                    </div>
                                                </div>                                                
                                                <div class="col-md-2">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Idade</label>
                                                        <input id="idade" type="text" name="idadePaciente" maxlength="3" value="${sessionScope.dadosSinaisVitais.idade}" class="form-control" disabled>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Motivo</label>
                                                        <input id="tipoDeCaso" type="text" name="tipoDeCaso" maxlength="20" value="${sessionScope.dadosSinaisVitais.tipoDeCaso}" onkeyup="maiuscula('paciente')" class="form-control" disabled>
                                                    </div>
                                                </div>  
                                            </div>                                                                                   
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">                                                       
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Queixa</label>
                                                            <textarea id="queixa" class="form-control" maxlength="144" name="queixa" rows="3" disabled>${sessionScope.dadosSinaisVitais.queixa}</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                            
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">PA(MmHg)</label>
                                                        <input id="pa" type="text" name="PA" maxlength="6" value="" class="form-control">
                                                    </div>
                                                </div>                                                
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">FC(Bpm)</label>
                                                        <input id="fc" type="text" name="FC" maxlength="3" value="" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">FR(Mrpm)</label>
                                                        <input id="fr" type="text" name="FR" maxlength="3" value="" class="form-control">
                                                    </div>
                                                </div>                                                 
                                            </div>
                                            <div class="row"> 
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">SAT. O2 - Sem Suporte(%)</label>
                                                        <input id="sats" type="text" name="SATS" maxlength="3" value="" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">SAT. O2 - Com Suporte(%)</label>
                                                        <input id="satc" type="text" name="SATC" maxlength="3" value="" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">T. Axilar(�C)</label>
                                                        <input id="temperatura" type="text" name="temperatura" maxlength="2" value="" class="form-control">
                                                    </div>
                                                </div>                                                                                                                                                
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Escala de Glasgow</label>
                                                        <input id="glasgow" type="text" name="glasgow" maxlength="2" value="" class="form-control">
                                                    </div>                                                                                                                                                                                                        
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">HGT</label>
                                                        <input id="hgt" type="text" name="HGT" maxlength="4" value="" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group" style="margin-top: 0px">
                                                        <label class="control-label" style="margin-top: 12px">Gravidade Comprovada</label>                                                        
                                                        <select id="combobox" name="gravidadeComprovada" class="form-control selectpicker" data-style="select-with-transition" data-size="4">                                                                                                                        
                                                            <option value="Pequena">Pequena</option>
                                                            <option value="M�dia">M�dia</option>
                                                            <option value="Severa">Severa</option>
                                                            <option value="Morte">Morte</option>
                                                        </select>                                                        
                                                    </div> 
                                                </div>                                                
                                            </div>
                                            <button type="button" onclick="history.go(-1)" style="text-transform: uppercase;" class="btn btn-primary pull-left">Voltar</button>
                                            <button type="submit" style="text-transform: uppercase;" class="btn btn-primary pull-right" name="logica" value="GravarSinaisVitais">Gravar</button>
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
    <script src="Resources/node_modules/popper.js/dist/umd/popper.js"></script>

    <!-- JS Select -->        
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/bootstrap-material-design.min.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/bootstrap-selectpicker.js" type="text/javascript"></script>

    <!--  Plugin for the Wizard -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/paper-bootstrap-wizard.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/jquery.bootstrap.wizard.js" type="text/javascript"></script> 

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

<!--    <script>
        $("#formRegulacao").submit(function () {
            if ($("#pa").val() === "" || $("#fc").val() === "" || $("#fr").val() === "" ||
                    $("#sats").val() === "" || $("#satc").val() === "" || $("#temperatura").val() === "" ||
                    $("#glasgow").val() === "" || $("#hgt").val() === "" || $("#combobox").val() === "") {
                swal({type: 'info', title: 'Oops...', text: 'Campos em Branco!', showConfirmButton: false, timer: 2000});
                return false;
            }
        });
    </script>-->

    <script type="text/javascript">
        /* M�scaras ER */
        function mascara(o, f) {
            v_obj = o;
            v_fun = f;
            setTimeout("execmascara()", 1);
        }
        function execmascara() {
            v_obj.value = v_fun(v_obj.value);
        }
        function mtel(v) {
            v = v.replace(/\D/g, "");             //Remove tudo o que n�o � d�gito            
            v = v.replace(/(\d)(\d{2})$/, "$1/$2");    //Coloca h�fen entre o quarto e o quinto d�gitos
            return v;
        }
        function removerDigitos(v) {
            v = v.replace(/\D/g, "");             //Remove tudo o que n�o � d�gito            
            return v;
        }        
        function id(el) {
            return document.getElementById(el);
        }
        window.onload = function () {
            id('pa').onkeyup = function () {
                mascara(this, mtel);
            };

            id('fc').onkeyup = function () {
                mascara(this, removerDigitos);
            };
            
            id('fr').onkeyup = function () {
                mascara(this, removerDigitos);
            };
            
            id('sats').onkeyup = function () {
                mascara(this, removerDigitos);
            };
            
            id('satc').onkeyup = function () {
                mascara(this, removerDigitos);
            };
            
            id('temperatura').onkeyup = function () {
                mascara(this, removerDigitos);
            };
            
            id('glasgow').onkeyup = function () {
                mascara(this, removerDigitos);
            };
            
            id('hgt').onkeyup = function () {
                mascara(this, removerDigitos);
            };
        };
    </script>

</html>
