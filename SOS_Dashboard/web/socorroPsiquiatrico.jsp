<%-- 
    Document   : socorroPsiquiatrico
    Created on : 07/07/2018, 12:41:56
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
                                                            <input type="radio" name="tipoCaso" value="Traumático" disabled>
                                                            <p style="color: #AAAAAA;">Traumático</p>
                                                        </label>
                                                    </div>
                                                </div>      
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="tipoCaso" checked="true" value="Psiquiátrico" disabled>
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
                                            <div class='hr-middle'><h4 style='color: #7f7f7f;'><center>Patologia Psiquiátrica: Surto<center></h4></div>
                                            <div class='row'>
                                                 <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Já faz tratamento?</label>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='tratamento' value='4'>
                                                            <p style='color: #7f7f7f;'>Sim</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='tratamento' checked='true' value='3'>
                                                            <p style='color: #7f7f7f;'>Não</p>
                                                        </label>
                                                    </div>                                                    
                                                </div>
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Toma medicação?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='tomaMedicacao' value='4'>
                                                            <p style='color: #7f7f7f;'>Sim</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='tomaMedicacao' checked='true' value='3'>
                                                            <p style='color: #7f7f7f;'>Não</p>
                                                        </label>                                 
                                                    </div>                                                    
                                                </div>                                                                                
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Primeiro surto?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='primeiroSurto' value='2'>
                                                            <p style='color: #7f7f7f;'>Sim</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='primeiroSurto' checked='true' value='3'>
                                                            <p style='color: #7f7f7f;'>Não</p>
                                                        </label>
                                                    </div>                                                    
                                                </div>                                                                                                                                                       
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>A vítima está em via pública?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='vitimaViaPublica' checked='true' checked='true' value='2'>
                                                            <p style='color: #7f7f7f;'>Sim</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='vitimaViaPublica' value='3'>
                                                            <p style='color: #7f7f7f;'>Não</p>
                                                        </label>
                                                    </div>                                                   
                                                </div>
                                            </div>
                                            <div class='row'>
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Sintomas associados?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='sintomasAssociados' checked='true' value='2'>
                                                            <p style='color: #7f7f7f;'>Confusão Mental</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='sintomasAssociados' value='2'>
                                                            <p style='color: #7f7f7f;'>Delírio</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='sintomasAssociados' value='2'>
                                                            <p style='color: #7f7f7f;'>Alucinações</p>
                                                        </label>
                                                    </div> 
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='sintomasAssociados' value='2'>
                                                            <p style='color: #7f7f7f;'>Distúrbio de Comportamento</p>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Como se encontra a vítima?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='comoEncontraVitima' checked='true' value='3'>
                                                            <p style='color: #7f7f7f;'>Controlada</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='comoEncontraVitima' value='2'>
                                                            <p style='color: #7f7f7f;'>Descontrolada</p>
                                                        </label>
                                                    </div>                                                    
                                                </div> 
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Vítima está agressiva?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='vitimaAgressiva' value='2'>
                                                            <p style='color: #7f7f7f;'>Sim</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='vitimaAgressiva' checked='true' value='3'>
                                                            <p style='color: #7f7f7f;'>Não</p>
                                                        </label>
                                                    </div>                                                    
                                                </div>
                                                <div class='col-md-3'>
                                                    <label class='control' style='color: #7f7f7f;'>Possui algum ferimento visível?</label>
                                                    <div class='radio'>
                                                        <label> 
                                                            <input type='radio' name='ferimentoVisivel' value='2'>
                                                            <p style='color: #7f7f7f;'>Sim</p>
                                                        </label>
                                                    </div>
                                                    <div class='radio'>
                                                        <label>
                                                            <input type='radio' name='ferimentoVisivel' checked='true' value='3'>
                                                            <p style='color: #7f7f7f;'>Não</p>
                                                        </label>
                                                    </div>                                                    
                                                </div>
                                            </div>
                                            <div class="row ">
                                                <div class="col-md-4">                                                     
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Gravidade do Caso</label>                                                        
                                                        <select id="comboboxGravidade" name="gravidadeCaso" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="3">                                                                                                                                                                                    
                                                            <option name="baixo" value="4">Baixo</option>                                                            
                                                            <option name="moderado" value="3">Moderado</option>
                                                            <option name="absoluto" value="0">Absoluto</option>
                                                        </select>                                                        
                                                    </div>                                                                                                                                                     
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Valor Social</label>                                                        
                                                        <select id="comboboxSocial" name="valorSocial" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="3">                                                                                                                                                                                    
                                                            <option name="minimo" value="4">Mínimo</option>                                                            
                                                            <option name="baixo" value="3">Baixo</option>
                                                            <option name="alto" value="0">Alto</option>
                                                        </select>                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Recursos Necessários</label>                                                        
                                                        <select id="comboboxRecursos" name="recursos" onChange="setSuport();" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="2">                                                                                                                                                                                    
                                                            <option name="possui" value="4">Possui</option>                                                            
                                                            <option name="naoPossui" value="0">Não Possui</option>
                                                        </select>                                                        
                                                    </div>
                                                </div>                                                                                              
                                            </div>
                                            <div class="row ">                                                                                                                                               
                                                <div class="col-md-6">
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Tempo para Atendimento</label>                                                        
                                                        <select id="comboboxTempo" name="tempo" onChange="setSuport();" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="3">                                                                                                                                                                                    
                                                            <option name="15min" value="4">Até 15 min</option>                                                            
                                                            <option name="40min" value="3">Até 40 min</option>
                                                            <option name="1h/M" value="0">1h ou Mais</option>
                                                        </select>                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Tipo de Suporte</label>                                                        
                                                        <select id="comboboxSuporte" name="suporte" class="form-control selectpicker" data-style="select-with-transition" title="Nenhum" data-size="20">                                                                                                                                                                                    

                                                        </select>                                                        
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <!--<label class="form-group label-floating">Queixa</label>-->
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Enredo e OBS</label>
                                                            <textarea id="mensagem" onfocus="limpandoCampo('mensagem');" onblur="preenchendoCampo('mensagem')" class="form-control" maxlength="144" name="mensagem" form="" rows="5">Nenhum</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
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

    <script type="text/javascript">
        //const toast = swal.mixin({toast: true, background: '#ffffff', position: 'top-end', showConfirmButton: false, timer: 25000});
        //toast({type: 'success', title: 'Sugestão: Suporte Avançado', color: '#fff'});
              
        //demo.showNotification('top','right','Sugestão: Suporte Avançado','2');
            
    </script>
    
    <script>
        $("#formRegulacao").submit(function () {
            if ($("#mensagem").val() === "" || $("#comboboxGravidade").val() === "" || $("#comboboxSocial").val() === "" ||
                $("#comboboxRecursos").val() === "" || $("#comboboxTempo").val() === "" || $("#comboboxSuporte").val() === "") {
                swal({type: 'info', title: 'Oops...', text: 'Campos em Branco!', showConfirmButton: false, timer: 2000});
                return false;
            }
        });
    </script>
    
    <script>        
        function limpandoCampo(id){                         
            
            if(id === "mensagem"){
                
                document.getElementById("mensagem").value = "";                
                
            }
             
        }        
    </script>
    
    <script>        
        function preenchendoCampo(id){                        
            
            if(id === "mensagem" && document.getElementById("mensagem").value === ""){
                
                document.getElementById("mensagem").value = "Nenhum";
                
            }
             
        }        
    </script>
    
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
    
</html>
