<%-- 
    Document   : chamadoPaciente
    Created on : 12/06/2018, 14:19:49
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>

        <title>Tarm - Chamado</title>

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
                <!--
            Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"
    
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
                            <a href="./areaTarm.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Painel</p>
                            </a>
                        </li>                                                
                        <li class="active">
                            <a href="./chamadoSolicitante.jsp">
                                <i class="material-icons">library_books</i>
                                <p>Chamado</p>
                            </a>
                        </li>
                        <li>
                            <a href="./icons.html">
                                <i class="material-icons">bubble_chart</i>
                                <p>Andamento</p>
                            </a>
                        </li>
                        <li>
                            <a href="./mapa.jsp">
                                <i class="material-icons">location_on</i>
                                <p>Mapa</p>
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
                            <a class="navbar-brand"> Novo Chamado </a>
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
                                <div class="card">
                                    <div class="card-header" data-background-color="red">
                                        <h4 class="title">Registro de Chamado</h4>
                                        <p class="category">Paciente - 2/2</p>
                                    </div>
                                    <div class="card-content">
                                        <form id="formSolicitante" action="controle" method="post">

                                            <!-- CAMPOS DA TELA ANTERIOR -->
                                            <input type="hidden" name="tarmCPF" value="${sessionScope.dadosTarm.CPFT}">
                                            <input type="hidden" name="numChamado" value="${sessionScope.dadosChamadoP1.numChamado}">
                                            <input type="hidden" name="data" value="${sessionScope.dadosChamadoP1.data}">
                                            <input type="hidden" name="hora" value="${sessionScope.dadosChamadoP1.hora}">
                                            <input type="hidden" name="nomeSolicitante" value="${sessionScope.dadosChamadoP1.nome}">
                                            <input type="hidden" name="telefoneSolicitante" value="${sessionScope.dadosChamadoP1.tel}"> 
                                            <input type="hidden" name="medicoCPF" value="${sessionScope.dadosChamadoP1.medicoCPF}">
                                            <input type="hidden" name="motivo" value="${sessionScope.dadosChamadoP1.motivo}">

                                            <div class="row">
                                                <div class="col-md-10">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Paciente</label>
                                                        <input id="paciente" type="text" name="nomePaciente" maxlength="50" value="" onkeyup="maiuscula('paciente')" class="form-control">
                                                    </div>
                                                </div>                                                
                                                <div class="col-md-2">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Idade</label>
                                                        <input id="idade" type="text" name="idadePaciente" maxlength="3" value="" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="form-group label-floating">Queixa</label>
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Enredo resumido do fato.</label>
                                                            <textarea id="queixa" class="form-control" maxlength="144" name="queixa" form="formSolicitante" rows="5"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <c:if test="${(sessionScope.dadosChamadoP1.motivo == 'Socorro') || (sessionScope.dadosChamadoP1.motivo == 'Informação')}">
                                                <div class="row ">
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Logradouro</label>
                                                            <input id="logradouro" type="text" name="logradouro" maxlength="50" onblur="setSEP()" value="" onkeyup="maiuscula('logradouro')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Bairro</label>
                                                            <input id="bairro" type="text" name="bairro" value="" maxlength="50" onblur="setSEP()" onkeyup="maiuscula('bairro')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Número</label>
                                                            <input id="numero" type="text" name="numero" maxlength="11" value="" onblur="setSEP()" class="form-control ">
                                                        </div>
                                                    </div>                                                    
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Complemento</label>
                                                            <input id="complemento" type="text" name="complemento" maxlength="144" value="" onblur="setSEP()" onkeyup="maiuscula('complemento')" class="form-control ">
                                                        </div>
                                                    </div>                                                                                                                                                            
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Cidade</label>
                                                            <input id="cidade" type="text" name="cidade" maxlength="50" value="Mossoró" onblur="setSEP()" onkeyup="maiuscula('cidade')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">CEP</label>
                                                            <input id="cep" type="text" name="cep"  maxlength="10" value="59.600-190" onblur="setSEP()" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Estado</label>
                                                            <input id="estado" type="text" name="estado"  maxlength="2" value="RN" onblur="setSEP()" onkeyup="maiusculaSigla('estado')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">País</label>
                                                            <input id="pais" type="text" name="pais"  maxlength="2" value="BR" onblur="setSEP()" onkeyup="maiusculaSigla('pais')" class="form-control ">
                                                        </div>
                                                    </div>  
                                                </div>  
                                            </c:if>

                                            <c:if test="${sessionScope.dadosChamadoP1.motivo == 'Transporte'}">
                                                <div class="row ">
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Logradouro(origem)</label>
                                                            <input id="logradouro" type="text" name="logradouro" maxlength="50" value="" onblur="setSEP()" onkeyup="maiuscula('logradouro')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Bairro(origem)</label>
                                                            <input id="bairro" type="text" name="bairro" maxlength="50" value="" onblur="setSEP()" onkeyup="maiuscula('bairro')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Número(origem)</label>
                                                            <input id="numero" type="text" name="numero" maxlength="11" value="" onblur="setSEP()" class="form-control ">
                                                        </div>
                                                    </div>                                                    
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Complemento(origem)</label>
                                                            <input id="complemento" type="text" name="complemento" maxlength="144" value="" onblur="setSEP()" onkeyup="maiuscula('complemento')" class="form-control ">
                                                        </div>
                                                    </div>                                                                                                        
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Cidade(origem)</label>
                                                            <input id="cidade" type="text" name="cidade" maxlength="50" value="" onblur="setSEP()" onkeyup="maiuscula('cidade')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">CEP(origem)</label>
                                                            <input id="cep" type="text" name="cep"  maxlength="10" value="00.000-000" onblur="setSEP()" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Estado(origem)</label>
                                                            <input id="estado" type="text" name="estado" value="RN" maxlength="2" onblur="setSEP()" onkeyup="maiusculaSigla('estado')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">País(origem)</label>
                                                            <input id="pais" type="text" name="pais" value="BR" maxlength="2" onblur="setSEP()" onkeyup="maiusculaSigla('pais')" class="form-control ">
                                                        </div>
                                                    </div>  
                                                </div>

                                                <div class="row ">
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Logradouro(destino)</label>
                                                            <input id="logradouroD" type="text" name="logradouroD" maxlength="50" value="" onblur="setSEPD()" onkeyup="maiuscula('logradouroD')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Bairro(destino)</label>
                                                            <input id="bairroD" type="text" name="bairroD" maxlength="50" value="" onblur="setSEPD()" onkeyup="maiuscula('bairroD')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Número(destino)</label>
                                                            <input id="numeroD" type="text" name="numeroD" maxlength="11" value="" onblur="setSEPD()" class="form-control ">
                                                        </div>
                                                    </div>                                                    
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Complemento(destino)</label>
                                                            <input id="complementoD" type="text" name="complementoD" maxlength="144" value="" onblur="setSEPD()" onkeyup="maiuscula('complementoD')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Cidade(destino)</label>
                                                            <input id="cidadeD" type="text" name="cidadeD" maxlength="50" value="" onblur="setSEPD()" onkeyup="maiuscula('cidadeD')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">CEP(destino)</label>
                                                            <input id="cepD" type="text" name="cepD"  maxlength="10" value="00.000-000" onblur="setSEPD()" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Estado(destino)</label>
                                                            <input id="estadoD" type="text" name="estadoD" value="RN" maxlength="2" onblur="setSEPD()" onkeyup="maiusculaSigla('estadoD')" class="form-control ">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">País(destino)</label>
                                                            <input id="paisD" type="text" name="paisD" value="BR" maxlength="2" onblur="setSEPD()" onkeyup="maiusculaSigla('paisD')" class="form-control ">
                                                        </div>
                                                    </div>  
                                                </div>  
                                            </c:if>

                                            <button type="button" onclick='history.go(-1)' style="text-transform: uppercase;" class="btn btn-primary pull-left">Voltar</button>                                            
                                            <button type="submit" style="text-transform: uppercase;" name="logica" value="GravarChamado" class="btn btn-primary pull-right">Gravar</button>
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

    <script>
        $("#formSolicitante").submit(function () {
            if ($("#paciente").val() === "" || $("#idade").val() === "" ||
                $("#queixa").val() === "" || $("#logradouro").val() === "" ||
                $("#numero").val() === "" || $("#complemento").val() === "" ||
                $("#bairro").val() === "" || $("#cidade").val() === "" ||
                $("#cep").val() === "" || $("#cepD").val() === "" ||
                $("#logradouroD").val() === "" || $("#numeroD").val() === "" ||
                $("#complementoD").val() === "" || $("#bairroD").val() === "" ||
                $("#cidadeD").val() === "") {
                    swal({type: 'info', title: 'Oops...', text: 'Campos em Branco!', showConfirmButton: false, timer: 2000});
                    return false;
                }
            });
    </script>
    
    <script>
        function setSEP() {
            
            var logradouro = document.getElementById('logradouro').value;
            var cidade = document.getElementById('cidade').value;
            var estado = document.getElementById('estado').value;
            var url = "https://viacep.com.br/ws/" + estado + "/" + cidade + "/" + logradouro + "/json/";                        
            
            $.get(url, function (data, status) {

                var objDados = data;
                var bairro = document.getElementById('bairro').value;                
                
                for (i = 0; i < objDados.length; i++) {

                    if (bairro.toUpperCase() === objDados[i].bairro.toUpperCase()) {
                        $('#cep').val(mcep(objDados[i].cep));
                    }
                                       
                }

            });                                                         
        };
        
    </script>
    
    <script>
        function setSEPD() {
                                                     
            var logradouroD = document.getElementById('logradouroD').value;
            var cidadeD = document.getElementById('cidadeD').value;
            var estadoD = document.getElementById('estadoD').value;
            var urlD = "https://viacep.com.br/ws/" + estadoD + "/" + cidadeD + "/" + logradouroD + "/json/";
            
            $.get(urlD, function (data, status) {

                var objDadosD = data;                
                var bairroD = document.getElementById('bairroD').value;
                
                for (i = 0; i < objDadosD.length; i++) {                    
                    
                    if (bairroD.toUpperCase() === objDadosD[i].bairro.toUpperCase()) {
                        $('#cepD').val(mcep(objDadosD[i].cep));
                    }
                    
                }

            });
            
        };
        
    </script>

    <script>

        /* Máscaras ER */
        function mascara(o, f) {
            v_obj = o;
            v_fun = f;
            setTimeout("execmascara()", 1);
        }
        
        function execmascara() {
            v_obj.value = v_fun(v_obj.value);
        }
        
        function mcep(v) {
            v = v.replace(/\D/g, ""); //Remove tudo o que não é dígito
            v = v.replace(/^(\d{2})(\d)/, "$1.$2");
            v = v.replace(/(\d{3})(\d)/, "$1-$2"); //Esse é tão fácil que não merece explicações
            return v;
        }

        function id(el) {
            return document.getElementById(el);
        }
        
        function next(el, next){
            if (el.value.length >= el.maxLength)
                id(next).focus();
        }

        window.onload = function () {
            id('cep').onkeyup = function () {
                mascara(this, mcep);
            };
            
            id('cepD').onkeyup = function () {
                mascara(this, mcep);
            };
        };
                      
    </script>
    
    <script>
        function maiuscula(id){

            var letra=document.getElementById(id).value;
            letra=letra.split("");
            var tmp="";
            for(i=0;i<letra.length;i++){
                if(letra[i-1]){
                    if(letra[i-1]===" "){letra[i]=letra[i].replace(letra[i],letra[i].toUpperCase());}
                }else{letra[i]=letra[i].replace(letra[i],letra[i].toUpperCase());}
                tmp+=letra[i];
            }
            document.getElementById(id).value=tmp;
        }
    </script>
    
    <script>
        function maiusculaSigla(id){
            
            var x = document.getElementById(id);
            x.value = x.value.toUpperCase();
                       
        }
    </script>
    
     <script type = "text/javascript" >

            function preventBack() {
                window.history.forward();
            }

            setTimeout("preventBack()", 0);

            window.onunload = function () {
                null;
            };
        </script>

</html>
