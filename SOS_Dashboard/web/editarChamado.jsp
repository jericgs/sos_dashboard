<%-- 
    Document   : editarChamado
    Created on : 31/07/2018, 21:47:17
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>TARM - Andamento</title>

        <!-- Required meta tags -->                    
        <meta charset="utf-8">                     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.min.css">                


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
                            <li class="active">
                                <a>
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
                                <a class="navbar-brand"> Atualizar Ocorrência </a>
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
                                            <h4 class="title">Atualizar Registro</h4>
                                            <p class="category">Atualizar - 1/1</p>
                                        </div>
                                        <div class="card-content">
                                            <form id="formSolicitante" action="controle" method="post">

                                                <!-- CAMPOS DA TELA ANTERIOR -->
                                                <input type="hidden" name="idS" value="${sessionScope.dadosOcorrencia.idS}">
                                                <input type="hidden" name="idP" value="${sessionScope.dadosOcorrencia.idP}">
                                                <input type="hidden" name="idRC" value="${sessionScope.dadosOcorrencia.idRC}">
                                                <input type="hidden" name="quantEndereco" value="${sessionScope.dadosOcorrencia.quantEndereco}">
                                                                                                
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Solicitante</label>
                                                            <input id="solicitante" type="text" name="solicitante" maxlength="50" value="${sessionScope.dadosOcorrencia.nomeSolicitante}" onkeyup="maiuscula('solicitante')" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Telefone</label>
                                                            <input id="telefone" type="text" name="telefone" maxlength="15" value="${sessionScope.dadosOcorrencia.telSolicitante}" class="form-control">
                                                        </div>
                                                    </div>                                                
                                                </div>                                                
                                                <div class="row">
                                                    <div class="col-md-10">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Paciente</label>
                                                            <input id="paciente" type="text" name="nomePaciente" maxlength="50" value="${sessionScope.dadosOcorrencia.nomePaciente}" onkeyup="maiuscula('paciente')" class="form-control">
                                                        </div>
                                                    </div>                                                
                                                    <div class="col-md-2">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Idade</label>
                                                            <input id="idade" type="text" name="idadePaciente" maxlength="3" value="${sessionScope.dadosOcorrencia.idadePaciente}" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group">                                                            
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Queixa (Enredo resumido do fato).</label>
                                                                <textarea id="queixa" class="form-control" maxlength="144" name="queixa" form="formSolicitante" rows="5">${sessionScope.dadosOcorrencia.queixa}</textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                
                                                <c:if test="${sessionScope.dadosOcorrencia.quantEndereco == '1'}">
                                                    
                                                    <!-- CAMPOS DA TELA ANTERIOR -->
                                                    <input type="hidden" name="idE1" value="${sessionScope.dadosOcorrencia.endereco1.idE}">
                                                    
                                                    <div class="row ">
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Logradouro</label>
                                                                <input id="logradouro" type="text" name="logradouro" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco1.logradouro}" onkeyup="maiuscula('logradouro')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Bairro</label>
                                                                <input id="bairro" type="text" name="bairro" value="${sessionScope.dadosOcorrencia.endereco1.bairro}" maxlength="50" onkeyup="maiuscula('bairro')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Número</label>
                                                                <input id="numero" type="text" name="numero" maxlength="11" value="${sessionScope.dadosOcorrencia.endereco1.numero}" class="form-control">
                                                            </div>
                                                        </div>                                                    
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Complemento</label>
                                                                <input id="complemento" type="text" name="complemento" maxlength="144" value="${sessionScope.dadosOcorrencia.endereco1.complemento}" onkeyup="maiuscula('complemento')" class="form-control">
                                                            </div>
                                                        </div>                                                                                                                                                            
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Cidade</label>
                                                                <input id="cidade" type="text" name="cidade" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco1.cidade}" onkeyup="maiuscula('cidade')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">CEP</label>
                                                                <input id="cep" type="text" name="cep"  maxlength="10" value="${sessionScope.dadosOcorrencia.endereco1.cep}" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Estado</label>
                                                                <input id="estado" type="text" name="estado"  maxlength="2" value="${sessionScope.dadosOcorrencia.endereco1.estado}" onkeyup="maiusculaSigla('estado')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">País</label>
                                                                <input id="pais" type="text" name="pais"  maxlength="2" value="${sessionScope.dadosOcorrencia.endereco1.pais}" onkeyup="maiusculaSigla('pais')" class="form-control">
                                                            </div>
                                                        </div>  
                                                    </div>  
                                                </c:if>
                                                <c:if test="${sessionScope.dadosOcorrencia.quantEndereco == '2'}">
                                                    
                                                    <!-- CAMPOS DA TELA ANTERIOR -->
                                                    <input type="hidden" name="idE1" value="${sessionScope.dadosOcorrencia.endereco1.idE}">
                                                    
                                                    <div class="row ">
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Logradouro(origem)</label>
                                                                <input id="logradouro" type="text" name="logradouro" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco1.logradouro}" onkeyup="maiuscula('logradouro')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Bairro(origem)</label>
                                                                <input id="bairro" type="text" name="bairro" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco1.bairro}" onkeyup="maiuscula('bairro')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Número(origem)</label>
                                                                <input id="numero" type="text" name="numero" maxlength="11" value="${sessionScope.dadosOcorrencia.endereco1.numero}" class="form-control">
                                                            </div>
                                                        </div>                                                    
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Complemento(origem)</label>
                                                                <input id="complemento" type="text" name="complemento" maxlength="144" value="${sessionScope.dadosOcorrencia.endereco1.complemento}" onkeyup="maiuscula('complemento')" class="form-control">
                                                            </div>
                                                        </div>                                                                                                        
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Cidade(origem)</label>
                                                                <input id="cidade" type="text" name="cidade" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco1.cidade}" onkeyup="maiuscula('cidade')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">CEP(origem)</label>
                                                                <input id="cep" type="text" name="cep"  maxlength="10" value="${sessionScope.dadosOcorrencia.endereco1.cep}" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Estado(origem)</label>
                                                                <input id="estado" type="text" name="estado" value="${sessionScope.dadosOcorrencia.endereco1.estado}" maxlength="2" onkeyup="maiusculaSigla('estado')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">País(origem)</label>
                                                                <input id="pais" type="text" name="pais" value="${sessionScope.dadosOcorrencia.endereco1.pais}" maxlength="2" onkeyup="maiusculaSigla('pais')" class="form-control">
                                                            </div>
                                                        </div>  
                                                    </div>

                                                    <!-- CAMPOS DA TELA ANTERIOR -->
                                                    <input type="hidden" name="idE2" value="${sessionScope.dadosOcorrencia.endereco2.idE}">
                                                            
                                                    <div class="row ">
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Logradouro(destino)</label>
                                                                <input id="logradouroD" type="text" name="logradouroD" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco2.logradouro}" onkeyup="maiuscula('logradouroD')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Bairro(destino)</label>
                                                                <input id="bairroD" type="text" name="bairroD" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco2.bairro}" onkeyup="maiuscula('bairroD')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Número(destino)</label>
                                                                <input id="numeroD" type="text" name="numeroD" maxlength="11" value="${sessionScope.dadosOcorrencia.endereco2.numero}" class="form-control">
                                                            </div>
                                                        </div>                                                    
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Complemento(destino)</label>
                                                                <input id="complementoD" type="text" name="complementoD" maxlength="144" value="${sessionScope.dadosOcorrencia.endereco2.complemento}" onkeyup="maiuscula('complementoD')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Cidade(destino)</label>
                                                                <input id="cidadeD" type="text" name="cidadeD" maxlength="50" value="${sessionScope.dadosOcorrencia.endereco2.cidade}" onkeyup="maiuscula('cidadeD')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">CEP(destino)</label>
                                                                <input id="cepD" type="text" name="cepD"  maxlength="10" value="${sessionScope.dadosOcorrencia.endereco2.cep}" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Estado(destino)</label>
                                                                <input id="estadoD" type="text" name="estadoD" value="${sessionScope.dadosOcorrencia.endereco2.estado}" maxlength="2" onkeyup="maiusculaSigla('estadoD')" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">País(destino)</label>
                                                                <input id="paisD" type="text" name="paisD" value="${sessionScope.dadosOcorrencia.endereco2.pais}" maxlength="2" onkeyup="maiusculaSigla('paisD')" class="form-control">
                                                            </div>
                                                        </div>  
                                                    </div>  
                                                </c:if>

                                                <button type="button" onclick='history.go(-1)' style="text-transform: uppercase;" class="btn btn-primary pull-left">Voltar</button>                                            
                                                <button type="submit" style="text-transform: uppercase;" name="logica" value="GravarAtualizacao" class="btn btn-primary pull-right">Atualizar</button>
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
        function mtel(v) {
            v = v.replace(/\D/g, "");             //Remove tudo o que não é dígito
            v = v.replace(/^(\d{2})(\d)/g, "($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
            v = v.replace(/(\d)(\d{4})$/, "$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
            return v;
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
        window.onload = function () {
            id('telefone').onkeyup = function () {
                mascara(this, mtel);
            };
            
            id('cep').onkeyup = function () {
                mascara(this, mcep);
            };
            
            id('cepD').onkeyup = function () {
                mascara(this, mcep);
            };            
        };
    </script>
    
    <script>
        $("#formSolicitante").submit(function () {
            if ($("#paciente").val() === "" || $("#idade").val() === "" ||
                $("#queixa").val() === "" || $("#logradouro").val() === "" ||
                $("#numero").val() === "" || $("#complemento").val() === "" ||
                $("#bairro").val() === "" || $("#cidade").val() === "" ||
                $("#cep").val() === "" || $("#cepD").val() === "" ||
                $("#logradouroD").val() === "" || $("#numeroD").val() === "" ||
                $("#complementoD").val() === "" || $("#bairroD").val() === "" ||
                $("#cidadeD").val() === "" || $("#solicitante").val() === "" ||
                $("#telefone").val() === "") {
                    swal({type: 'info', title: 'Oops...', text: 'Campos em Branco!', showConfirmButton: false, timer: 2000});
                    return false;
                }
            });
    </script>
    
</html>
