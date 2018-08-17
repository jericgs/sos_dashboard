<%-- 
    Document   : cadastroUnidadeMovel
    Created on : 14/08/2018, 09:24:05
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
                        <li>
                            <a href="controle?logica=Cadastro&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">person_add</i>
                                <p>Cadastro</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="controle?logica=CadastroUnidadeMovel&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">add</i>
                                <p>Ambul�ncia</p>
                            </a>
                        </li>
                        <li>
                            <a href="controle?logica=Alteracao&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">cached</i>
                                <p>Altera��o</p>
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
                            <a class="navbar-brand"> Cadastro Ambul�ncia </a>
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
                        <form id="formCadastro" action="controle" method="post">
                            <!--        You can switch " data-color="orange" "  with one of the next bright colors: "blue", "green", "orange", "red", "azure"          -->

                            <div class="wizard-header text-center">
                                <h3 class="wizard-title">Novo Registro</h3>                                
                            </div>

                            <div class="wizard-navigation">
                                <div class="progress-with-circle">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 21%;"></div>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#sobre" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-truck"></i>
                                            </div>
                                            Sobre
                                        </a>
                                    </li>                                     
                                    <li>
                                        <a href="#credenciar" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-key"></i>
                                            </div>
                                            Credenciar
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="sobre">
                                    <h5 class="info-text"> Por favor, informe os dados do ve�culo. </h5>
                                    <div class="row">                                        
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">Placa</label>                                                            
                                                <input id="placa" name="placa" maxlength="7" onblur="verificandoPlaca()" onkeyup="maiusculaSigla('placa')" type="text" value="" class="form-control">
                                            </div>                                                            
                                        </div>
                                        <div class='col-md-4'>
                                            <div class='form-group'  style='margin-top: 0px'>
                                                <label class='control-label' style='margin-top: 12px'>Tipo de Ambul�ncia</label>
                                                <select id='tipoAmbulancia' name='tipoAmbulancia' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>                                                    
                                                    <option name='alfa' value='Alfa'>Alfa</option>
                                                    <option name='bravo' value='Bravo'>Bravo</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating">
                                                <label class="control-label">N� da Unidade</label>
                                                <input id="numeroAmbulancia" name="numeroAmbulancia" onblur="verificandoNomeAmbulancia()" onkeyup="apenasNumeros('numeroAmbulancia')" maxlength="4" type="text" value="" class="form-control">
                                            </div>
                                        </div>
                                    </div>                                                                       
                                </div>
                                <div class="tab-pane" id="credenciar">
                                    <h5 class="info-text"> Senha para ativar a unidade m�vel no sistame. </h5>                                                                       
                                    <div class="row">
                                        <div class='col-md-4'>
                                            <div class='form-group label-floating'>
                                                <label class='control-label'>Senha</label>
                                                <input id='senha' type='password' name='senha' value='' maxlength='8' class='form-control'>
                                            </div>
                                        </div>
                                        <div class='col-md-4'>
                                            <div class='form-group label-floating'>
                                                <label class='control-label'>Repita a senha</label>
                                                <input id='senhaR' type='password' name='senhaR'  maxlength='8' value='' class='form-control'>
                                            </div>
                                        </div>
                                        <div class='col-md-4'>
                                            <div class='form-group'  style='margin-top: 0px'>
                                                <label class='control-label' style='margin-top: 12px'>Status</label>
                                                <select id='tipoStatus' name='tipoStatus' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>                                                    
                                                    <option name='ativo' value='Ativo'>Ativo</option>
                                                    <option name='inativo' value='Inativo'>Inativo</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>                                                                        
                                </div>
                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <button type="button" style="text-transform: uppercase;" class="btn btn-next btn-fill btn-primary" name="logica" value="Next">Pr�ximo</button>                                    
                                    <button type="submit" style="text-transform: uppercase;" class="btn btn-finish btn-fill btn-primary" name="logica" value="GravarCadastroAmbulancia">Gravar</button>                                    
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

    <script>
        function maiusculaSigla(id) {

            var x = document.getElementById(id);
            x.value = x.value.toUpperCase();

        }
    </script>
    
    <script>
        
        function verificandoNomeAmbulancia() {
            
            var valorTipoAmbulancia = document.getElementById("tipoAmbulancia").value;
            var valorNumeroAmbulancia = document.getElementById("numeroAmbulancia").value;
            
            $.post("AjaxControle", {logicaAjax: "AjaxValidacaoNomeAmbulancia", tipoAmbulancia: valorTipoAmbulancia, numeroAmbulancia: valorNumeroAmbulancia}, function (data, status) {
                
                var objDados = JSON.parse(data);
                
                if(objDados[0].confirmacaoNomeAmbulancia === 'false'){
                    
                    swal({type: 'info', title: 'Oops...', text: 'J� existe cadastro com o n�mero: '+ valorNumeroAmbulancia +'.', showConfirmButton: false, timer: 4000});
                    document.getElementById("numeroAmbulancia").value = "";            
                    
                }
                
            });
            
        }
        
    </script>
    
    <script>
        
        function verificandoPlaca() {
            
            var valorPlaca = document.getElementById("placa").value;
            
            $.post("AjaxControle", {logicaAjax: "AjaxValidacaoPlaca", placa: valorPlaca}, function (data, status) {
                
                var objDados = JSON.parse(data);
                
                if(objDados[0].confirmacaoPlaca === 'false'){
                    
                    swal({type: 'info', title: 'Oops...', text: 'J� existe cadastro com essa placa: '+ valorPlaca +'.', showConfirmButton: false, timer: 4000});
                    document.getElementById("placa").value = "";            
                    
                }
                
            });
            
        }
        
    </script>
    
    <script type="text/javascript">
        
        function apenasNumeros(id){
                        
            var valor = document.getElementById(id);
            var novoTexto = valor.value.replace(/[^0-9]/g,'');
            valor.value = novoTexto;
            
        }
    
    </script>
    
    <script>
        <c:if test="${not empty alertaM.tipoAlerta}">
        swal({type: '${alertaM.tipoAlerta}', title: 'Hey...', text: '${alertaM.msnAlerta}', showConfirmButton: false, timer: 2500}).then((value) => {
            location.href = "controle?logica=CadastroUnidadeMovel&nomeUsuario=${sessionScope.admin.nomeUsuario}";
        });
        </c:if>
    </script>

</html>
