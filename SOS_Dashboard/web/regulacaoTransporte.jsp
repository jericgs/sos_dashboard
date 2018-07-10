<%-- 
    Document   : regulacaoTransporte
    Created on : 03/07/2018, 16:58:50
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Médico - Transporte</title>       

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.min.css">

        <!--  Material Dashboard CSS -->
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
                        <a class="simple-text textLogo">
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
                        <li class="active">
                            <a href="controle?logica=RegulacaoTransporte&nomeUsuario=${sessionScope.medico.nomeUsuario}&idR=${sessionScope.dadosPacienteTrans.idR}">
                                <i class="material-icons">library_books</i>
                                <p>Regulações</p>
                            </a>
                        </li>
                        <li>
                            <a href="./icons.html">
                                <i class="material-icons">bubble_chart</i>
                                <p>Andamento</p>
                            </a>
                        </li>                        
                        <li>
                            <a href="./table.html">
                                <i class="material-icons">content_paste</i>
                                <p>Arquivados</p>
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
                            <a class="navbar-brand"> Regulação Transporte </a>
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
                                <div class="card">
                                    <div class="card-header" data-background-color="red">
                                        <h4 class="title">Registro de Regulação</h4>
                                        <p class="category">Paciente - 1/1</p>
                                    </div>
                                    <div class="card-content">
                                        <form id="formRegulacao" action="controle" method="post">

                                            <!-- CAMPOS DA TELA ANTERIOR -->
                                            <input type="hidden" name="idR" value="${sessionScope.dadosPacienteTrans.idR}">
                                            <input type="hidden" name="motivo" value="Transporte">

                                            <div class="row">
                                                <div class="col-md-7">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Paciente</label>
                                                        <input id="paciente" type="text" name="nomePaciente" maxlength="50" value="${sessionScope.dadosPacienteTrans.nomePaciente}" onkeyup="maiuscula('paciente')" class="form-control" disabled>
                                                    </div>
                                                </div>                                                
                                                <div class="col-md-2">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Idade</label>
                                                        <input id="idade" type="text" name="idadePaciente" maxlength="3" value="${sessionScope.dadosPacienteTrans.idade}" class="form-control" disabled>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Motivo</label>
                                                        <input id="motivoD" type="text" name="motivoD" maxlength="20" value="${sessionScope.dadosPacienteTrans.motivo}" onkeyup="maiuscula('paciente')" class="form-control" disabled>
                                                    </div>
                                                </div>  
                                            </div>                                                                                   
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">                                                       
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Queixa</label>
                                                            <textarea id="queixa" class="form-control" maxlength="144" name="queixa" rows="3" disabled>${sessionScope.dadosPacienteTrans.queixa}</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                            
                                            <hr>                                            
                                            <div class="row ">
                                                <div class="col-md-6">                                                     
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Parecer do Médico</label>                                                        
                                                        <select autofocus id="comboboxParecer" name="parecer" onChange="setSuport();" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="2">                                                                                                                                                                                    
                                                            <option name="aprovado" value="Aprovado">Aprovado</option>                                                            
                                                            <option name="negado" value="Negado">Negado</option>
                                                        </select>                                                        
                                                    </div>                                                                                                                                                     
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Tipo de Suporte</label>                                                        
                                                        <select autofocus id="comboboxSuporte" name="suporte" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="20">                                                                                                                                                                                    
                                                            
                                                        </select>                                                        
                                                    </div> 
                                                </div>
                                            </div>
                                            <label class="control-label" style="position: static">Tipo de Caso</label>
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Clínico" checked="true">
                                                            <p style="color: #7f7f7f;">Clínico</p>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Traumático">
                                                            <p style="color: #7f7f7f;">Traumático</p>
                                                        </label>
                                                    </div>
                                                </div>      
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Psiquiátrico">
                                                            <p style="color: #7f7f7f;">Psiquiátrico</p>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Obstétrico">
                                                            <p style="color: #7f7f7f;">Obstétrico</p>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">                                                        
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Justificativa</label>
                                                            <textarea id="justificativa" class="form-control" maxlength="144" name="justificativa" form="formRegulacao" rows="3"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                            
                                            <button type="submit" style="text-transform: uppercase;" class="btn btn-primary pull-right" name="logica" value="GravarRegulacao">Gravar</button>
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

    <!--  Charts Plugin -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/chartist.min.js"></script>
    <!--  Dynamic Elements plugin -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/arrive.min.js"></script>
    <!--  PerfectScrollbar Library -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/perfect-scrollbar.jquery.min.js"></script>
    <!--  Notifications Plugin    -->
    <!-- <script src="Resources/node_modules/bootstrap/js/disp-dasboard/disp-dasboard/bootstrap-notify.js"></script>-->
    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8kJ3p081G1hbsHQLkydJg8AtpVUznejw"></script>
    <!-- Material Dashboard javascript methods -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/material-dashboard.js?v=1.2.0"></script>
    <!-- Material Dashboard DEMO methods, don't include it in your project! -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/demo.js"></script>    
    <!-- momentjs.com -->        
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/moment-with-locales.js"></script> 

    <script>
        
        setSuport();

        function setSuport() {
                                              
            $.post("AjaxControle", {logicaAjax: "AreaAjaxSuport"}, function (data, status) {
                
                var objDados = JSON.parse(data);

                comboboxSuporte = document.getElementById("comboboxSuporte");
                comboboxSuporte.innerHTML = "";
                
                for (i = 0; i < objDados.length; i++) {                    
                    comboboxSuporte.innerHTML += "<option value='" + objDados[i].placa + "'>" + objDados[i].nome + "</option>";
                }

                $('.selectpicker').selectpicker('refresh');

            });
        }

    </script>
    
    <script>
        $("#formRegulacao").submit(function () {
            if ($("#justificativa").val() === "" || $("#comboboxParecer").val() === "" || $("#comboboxSuporte").val() === "") {
                swal({type: 'info', title: 'Oops...', text: 'Campos em Branco!', showConfirmButton: false, timer: 2000});
                return false;
            }
        });
    </script>
    
</html>
