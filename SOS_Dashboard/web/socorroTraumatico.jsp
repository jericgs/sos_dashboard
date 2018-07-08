<%-- 
    Document   : socorroTraumatico
    Created on : 07/07/2018, 12:41:40
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>

        <title>Médico - Socorro</title>

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
                            <a>
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
                            <a class="navbar-brand"> Regulação Socorro </a>
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
                                        <p class="category">Paciente - 2/N</p>
                                    </div>
                                    <div class="card-content">
                                        <form id="formRegulacao" action="controle" method="post">

                                            <!-- CAMPOS DA TELA ANTERIOR -->
                                            <input type="hidden" name="idR" value="${sessionScope.dadosPaciente.idR}">
                                            <input type="hidden" name="tipoDeCaso" value="${sessionScope.dadosPaciente.tipoDeCaso}">

                                            <div class="row">
                                                <div class="col-md-7">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Paciente</label>
                                                        <input type="text" maxlength="50" value="${sessionScope.dadosPaciente.nomePaciente}" onkeyup="maiuscula('paciente')" class="form-control" disabled>                                                        
                                                    </div>
                                                </div>                                                
                                                <div class="col-md-2">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Idade</label>
                                                        <input type="text" maxlength="3" value="${sessionScope.dadosPaciente.idade}" class="form-control" disabled>                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Motivo</label>
                                                        <input type="text" maxlength="20" value="${sessionScope.dadosPaciente.motivo}" onkeyup="maiuscula('paciente')" class="form-control" disabled>                                                        
                                                    </div>
                                                </div>  
                                            </div>                                                                                   
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">                                                       
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Queixa</label>
                                                            <textarea id="queixa" class="form-control" maxlength="144" name="queixa" rows="3" disabled>${sessionScope.dadosPacienteSocorro.queixa}</textarea>                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="control-label" style="position: static">Tipo de Caso</label>
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Clínico" disabled>
                                                            <p style="color: #AAAAAA;">Clínico</p>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" checked="true" value="Traumático" disabled>
                                                            <p style="color: #AAAAAA;">Traumático</p>
                                                        </label>
                                                    </div>
                                                </div>      
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Psiquiátrico" disabled>
                                                            <p style="color: #AAAAAA;">Psiquiátrico</p>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" value="Obstétrico" disabled>
                                                            <p style="color: #AAAAAA;">Obstétrico</p>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>      
                                            <hr>
                                            <label class="control" style="color: #7f7f7f;">Qual o tipo de acidente/incidente?</label>                                            
                                            <div class="row">
                                                <div class="col-md-3">

                                                    <div class="radio">
                                                        <label> 
                                                            <input id="transito" type="radio" name="tipoTraumatico" onclick="secao('transito')" value="Trânsito">
                                                            <p style="color: #7f7f7f;">Trânsito</p>
                                                        </label>
                                                    </div>

                                                    <div class="radio">
                                                        <label> 
                                                            <input id="queda" type="radio" name="tipoTraumatico" onclick="secao('queda')" value="Queda">
                                                            <p style="color: #7f7f7f;">Queda</p>
                                                        </label>
                                                    </div>                                                   

                                                </div>

                                                <div class="col-md-3">

                                                    <div class="radio">
                                                        <label> 
                                                            <input id="queimaduras" type="radio" name="tipoTraumatico" onclick="secao('queimaduras')" value="Queimaduras">
                                                            <p style="color: #7f7f7f;">Queimaduras</p>
                                                        </label>
                                                    </div>                                                                                                         

                                                    <div class="radio">
                                                        <label> 
                                                            <input id="F.A.F/F.A.B" type="radio" name="tipoTraumatico" onclick="secao('F.A.F/F.A.B')" value="F.A.F/F.A.B">
                                                            <p style="color: #7f7f7f;">F.A.F/F.A.B</p>
                                                        </label>
                                                    </div>

                                                </div>

                                                <div class="col-md-3">

                                                    <div class="radio">
                                                        <label> 
                                                            <input id="desabamento/soterramento" type="radio" name="tipoTraumatico" onclick="secao('desabamento/soterramento')" value="Desabamento/Soterramento">
                                                            <p style="color: #7f7f7f;">Desabamento/Soterramento</p>
                                                        </label>
                                                    </div>

                                                    <div class="radio">
                                                        <label> 
                                                            <input id="agressoesInterpessoais" type="radio" name="tipoTraumatico" onclick="secao('agressoesInterpessoais')" value="Agressões Interpessoais">
                                                            <p style="color: #7f7f7f;">Agressões Interpessoais</p>
                                                        </label>
                                                    </div>

                                                </div>

                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input id="outrosTraumatismos" type="radio" name="tipoTraumatico" onclick="secao('outrosTraumatismos')" value="Outros Traumatismos">
                                                            <p style="color: #7f7f7f;">Outros Traumatismos</p>
                                                        </label>
                                                    </div>
                                                </div>

                                            </div>
                                            <div id="secao"></div>
                                            <button type="button" onclick='history.go(-1)' style="text-transform: uppercase;" class="btn btn-primary pull-left">Voltar</button>
                                            <button type="submit" style="text-transform: uppercase;" class="btn btn-primary pull-right" name="logica" value="">Próximo</button>
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
        function secao(id){
                                        
            secaoBox = document.getElementById("secao");  
                                    
            if(id === "transito"){
                console.log("É NOS>>>>>> " + id);                                
                                                                              
                secaoBox.innerHTML ="<div class='hr-middle'><h4 style='color: #7f7f7f;'><center>Patologias Traumáticas: Acidente de Trânsito<center></h4></div>"
                                   +"<div class='row'>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Local?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='local' value='BR'>"
                                   +"                <p style='color: #7f7f7f;'>BR</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='local' checked='true' value='Cidade'>"
                                   +"                <p style='color: #7f7f7f;'>Cidade</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Usava equipamentos de segurança?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='equipamentoSeguranca' checked='true' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='equipamentoSeguranca' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Vítima se move?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='vitimaMove' checked='true' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='vitimaMove' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Está acordado(a)?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='acordado' checked='true' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='acordado' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"</div>"
                                   +"<div class='row'>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Está falando?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='falando' checked='true' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='falando' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Tem sangramento?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='sangramento' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='sangramento' checked='true' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Ejetada do veículo?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='ejetadaDoVeiculo' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='ejetadaDoVeiculo' checked='true' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Presa nas ferragens?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='presaFerragens' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='presaFerragens' checked='true' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"</div>"
                                   +"<div class='row'>"
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Como respira?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='respiracao' checked='true' value='Normalmente'>"
                                   +"                <p style='color: #7f7f7f;'>Normalmente</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='respiracao' value='Respiração Alterada'>"
                                   +"                <p style='color: #7f7f7f;'>Respiração Alterada</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='respiracao' value='Não Respira'>"
                                   +"                <p style='color: #7f7f7f;'>Não Respira</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"                                                                                  
                                   +"    <div class='col-md-3'>"
                                   +"        <label class='control' style='color: #7f7f7f;'>Morte de algum ocupante?</label>"
                                   +"        <div class='radio'>"
                                   +"            <label> "
                                   +"                <input type='radio' name='morte' value='Sim'>"
                                   +"                <p style='color: #7f7f7f;'>Sim</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"        <div class='radio'>"
                                   +"            <label>"
                                   +"                <input type='radio' name='morte' checked='true' value='Não'>"
                                   +"                <p style='color: #7f7f7f;'>Não</p>"
                                   +"            </label>"
                                   +"        </div>"
                                   +"    </div>"
                                   +"</div>";
            }
            
            if(id === "queda"){
                 console.log("É NOS>>>>>> " + id);
                                  
            }
            
            if(id === "queimaduras"){
                 console.log("É NOS>>>>>> " + id);
            }
            
            if(id === "F.A.F/F.A.B"){
                 console.log("É NOS>>>>>> " + id);
            }
            
            if(id === "desabamento/soterramento"){
                 console.log("É NOS>>>>>> " + id);
            }
            
            if(id === "agressoesInterpessoais"){
                 console.log("É NOS>>>>>> " + id);
            }
            
            if(id === "outrosTraumatismos"){
                 console.log("É NOS>>>>>> " + id);
            }
            
        }
    </script>
    
</html>
