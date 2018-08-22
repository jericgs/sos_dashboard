<%-- 
    Document   : atualizacaoCadastro
    Created on : 16/08/2018, 11:57:21
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Admin - Atualização</title>

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
                        <li>
                            <a href="controle?logica=CadastroUnidadeMovel&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">add</i>
                                <p>Ambulância</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="controle?logica=Alteracao&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">cached</i>
                                <p>Alteração</p>
                            </a>
                        </li>                        
                        <li>
                            <a href="controle?logica=Monitoramento&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">location_on</i>
                                <p>Monitoramento</p>
                            </a>
                        </li>
                        <li>
                            <a href="controle?logica=Conta&nomeUsuario=${sessionScope.admin.nomeUsuario}">
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
                            <a class="navbar-brand"> Alteração de Dados </a>
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
                    <div class="container-fluid">
                        <div class="row">
                            <div>
                                <div class="card wizard-card">
                                    <div class="card-header" data-background-color="red">
                                        <h4 class="title">Retificação de Cadastro</h4>
                                        <p class="category">Atualização - 1/1</p>
                                    </div>
                                    <div class="card-content">
                                        <form id="formRetificacao" action="controle" method="post">                                                                                        

                                            <div class="row">
                                                <div class="col-md-4">                                                   
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group label-floating" style="text-align: left;">
                                                        <label class="control-label">CPF</label>
                                                        <input id="cpf" name="cpf" style="text-align: center;" type="text" maxlength="14" value="" class="form-control">                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-2">                                                    
                                                    <button type="button" onclick="getDadosAtualizacao();" class="btn btn-primary btn-round btn-just-icon">
                                                        <i class="material-icons">search</i>
                                                        <div class="ripple-container"></div>
                                                    </button>
                                                </div>
                                                <div class="col-md-3">                                                   
                                                </div>
                                            </div>                                                   
                                            <hr>
                                            <div id="secao"></div>                                            
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
        function mcep(v) {
            v = v.replace(/\D/g, ""); //Remove tudo o que não é dígito
            v = v.replace(/^(\d{2})(\d)/, "$1.$2");
            v = v.replace(/(\d{3})(\d)/, "$1-$2"); //Esse é tão fácil que não merece explicações
            return v;
        }
        function cpfInnert(id){
              var valor = document.getElementById(id);
              var novoTexto = valor.value.replace(/\D/g, "");
              novoTexto = novoTexto.replace(/(\d{3})(\d)/, "$1.$2");
              novoTexto = novoTexto.replace(/(\d{3})(\d)/, "$1.$2");
              novoTexto = novoTexto.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
              valor.value = novoTexto;
        }
        function rgInnert(id) {
            var valor = document.getElementById(id);
            var novoTexto = valor.value.replace(/\D/g, "");
            novoTexto = novoTexto.replace(/(\d{3})(\d)/, "$1.$2");
            novoTexto = novoTexto.replace(/(\d{3})(\d)/, "$1.$2");
            valor.value = novoTexto;
        }
        function dataInnert(id) {
            var valor = document.getElementById(id);
            var novoTexto = valor.value.replace(/\D/g, "");
            novoTexto = novoTexto.replace(/(\d{2})(\d)/, "$1/$2");
            novoTexto = novoTexto.replace(/(\d{2})(\d)/, "$1/$2");
            valor.value = novoTexto;
        }
        function mcepInnert(id) {
            var valor = document.getElementById(id);
            var novoTexto = valor.value.replace(/\D/g, "");
            novoTexto = novoTexto.replace(/^(\d{2})(\d)/, "$1.$2");
            novoTexto = novoTexto.replace(/(\d{3})(\d)/, "$1-$2");
            valor.value = novoTexto;
        }
        function mtelInnert(id) {
            var valor = document.getElementById(id);
            var novoTexto = valor.value.replace(/\D/g, "");
            novoTexto = novoTexto.replace(/^(\d{2})(\d)/g, "($1) $2");
            novoTexto = novoTexto.replace(/(\d)(\d{4})$/, "$1-$2");
            valor.value = novoTexto;
        }
        function id(el) {
            return document.getElementById(el);
        }
        function next(el, next){
            if (el.value.length >= el.maxLength)
                id(next).focus();
        }
        window.onload = function () {
            id('cpf').onkeyup = function () {
                mascara(this, cpf);
            };            
        };
    </script>

    <script>
        function getDadosAtualizacao() {
            
            var valorCpfBusca = document.getElementById("cpf").value;
            var secaoBox = document.getElementById("secao");
            
            $.post("AjaxControle", {logicaAjax: "AjaxDadosAtualizar", cpf: valorCpfBusca}, function (data, status) {
                
                var objDados = JSON.parse(data);
                
                if(objDados === null){
                    secaoBox.innerHTML = "<div class='row'>"
                                       + "  <div class='col-md-12'>"
                                       + "      <h3><center>Nenhum registro!</center></h3>"
                                       + "  </div>"
                                       + "</div>";
                }else{
                    
                    if(objDados[0].cargo === "Auxiliar"){
                    
                        secaoBox.innerHTML = "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CPF</label>"
                                       + "          <input id='cpfI' name='cpfI' maxlength='14' onkeyup= cpfInnert('cpfI') type='text' value='"+ objDados[0].cpf +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>RG</label>"
                                       + "          <input id='rg' name='rg' maxlength='11' onkeyup= rgInnert('rg') type='text' value='"+ objDados[0].rg +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Data de Nascimento</label>"
                                       + "          <input id='nascimento' name='nascimento' maxlength='10' onkeyup= dataInnert('nascimento') type='text' value='"+ objDados[0].nascimento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-8'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nome</label>"
                                       + "          <input id='nome' name='nome' type='text' onkeyup= maiuscula('nome') value='"+ objDados[0].nome +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Genero</label>"
                                       + "          <input id='genero' name='genero' type='text' onkeyup= maiuscula('genero') value='"+ objDados[0].genero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nº Coren</label>"
                                       + "          <input id='coren' onkeyup= maiusculaSigla('coren') maxlength='14' name='coren' type='text' value='"+ objDados[0].numCoren +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cargo</label>"
                                       + "          <input id='cargo' name='cargo' type='text' onkeyup= maiuscula('cargo') value='"+ objDados[0].cargo +"' class='form-control' disabled>"
                                       + "          <input name='cargo' type='hidden' value='"+ objDados[0].cargo +"'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group'  style='margin-top: 0px'>"
                                       + "          <label class='control-label' style='margin-top: 12px'>Situação</label>"
                                       + "              <select id='situacao' name='situacao' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>"
                                       + "                  <option name='ativo' value='Ativo'>Ativo</option>"
                                       + "                  <option name='inativo' value='Inativo'>Inativo</option>"
                                       + "              </select>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idC' type='hidden' value='"+ objDados[0].idC +"'>"
                                       + "          <label class='control-label'>Telefone</label>"
                                       + "          <input id='telefone' name='telefone' type='text' maxlength='14' onkeyup= mtelInnert('telefone') value='"+ objDados[0].telefone +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Celular</label>"
                                       + "          <input id='celular' name='celular' type='text' maxlength='15' onkeyup= mtelInnert('celular') value='"+ objDados[0].cel +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>E-mail</label>"
                                       + "          <input id='email' name='email' type='email' value='"+ objDados[0].email +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idE' type='hidden' value='"+ objDados[0].idE +"'>"
                                       + "          <label class='control-label'>Logradouro</label>"
                                       + "          <input id='logradouro' name='logradouro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('logradouro') value='"+ objDados[0].logradouro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Bairro</label>"
                                       + "          <input id='bairro' name='bairro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('bairro') value='"+ objDados[0].bairro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Número</label>"
                                       + "          <input id='numero' name='numero' type='text' maxlength='11' onblur= setSEP() onkeyup= apenasNumeros('numero') value='"+ objDados[0].numero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Complemento</label>"
                                       + "          <input id='complemento' name='complemento' type='text' maxlength='144' onblur= setSEP() onkeyup= maiuscula('complemento') value='"+ objDados[0].complemento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cidade</label>"
                                       + "          <input id='cidade' name='cidade' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('cidade') value='"+ objDados[0].cidade +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CEP</label>"
                                       + "          <input id='cep' name='cep' type='text' maxlength='10' onblur= setSEP() onkeyup= mcepInnert('cep') value='"+ objDados[0].cep +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Estado</label>"
                                       + "          <input id='estado' name='estado' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('estado') value='"+ objDados[0].estado +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>País</label>"
                                       + "          <input id='pais' name='pais' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('pais') value='"+ objDados[0].pais +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<button type='submit' style='text-transform: uppercase;' class='btn btn-primary pull-right' name='logica' value='GravarRetificacao'>Gravar</button>"
                                       + "<div class='clearfix'></div>";     
                                    
                    }
                
                    if(objDados[0].cargo === "Enfermeiro"){
                    
                        secaoBox.innerHTML = "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CPF</label>"
                                       + "          <input id='cpfI' name='cpfI' maxlength='14' onkeyup= cpfInnert('cpfI') type='text' value='"+ objDados[0].cpf +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>RG</label>"
                                       + "          <input id='rg' name='rg' maxlength='11' onkeyup= rgInnert('rg') type='text' value='"+ objDados[0].rg +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Data de Nascimento</label>"
                                       + "          <input id='nascimento' name='nascimento' maxlength='10' onkeyup= dataInnert('nascimento') type='text' value='"+ objDados[0].nascimento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-8'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nome</label>"
                                       + "          <input id='nome' name='nome' type='text' onkeyup= maiuscula('nome') value='"+ objDados[0].nome +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Genero</label>"
                                       + "          <input id='genero' name='genero' type='text' onkeyup= maiuscula('genero') value='"+ objDados[0].genero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nº Coren</label>"
                                       + "          <input id='coren' onkeyup= maiusculaSigla('coren') maxlength='14' name='coren' type='text' value='"+ objDados[0].numCoren +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cargo</label>"
                                       + "          <input id='cargo' name='cargo' type='text' onkeyup= maiuscula('cargo') value='"+ objDados[0].cargo +"' class='form-control' disabled>"
                                       + "          <input name='cargo' type='hidden' value='"+ objDados[0].cargo +"'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group'  style='margin-top: 0px'>"
                                       + "          <label class='control-label' style='margin-top: 12px'>Situação</label>"
                                       + "              <select id='situacao' name='situacao' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>"
                                       + "                  <option name='ativo' value='Ativo'>Ativo</option>"
                                       + "                  <option name='inativo' value='Inativo'>Inativo</option>"
                                       + "              </select>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idC' type='hidden' value='"+ objDados[0].idC +"'>"
                                       + "          <label class='control-label'>Telefone</label>"
                                       + "          <input id='telefone' name='telefone' type='text' maxlength='14' onkeyup= mtelInnert('telefone') value='"+ objDados[0].telefone +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Celular</label>"
                                       + "          <input id='celular' name='celular' type='text' maxlength='15' onkeyup= mtelInnert('celular') value='"+ objDados[0].cel +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>E-mail</label>"
                                       + "          <input id='email' name='email' type='email' value='"+ objDados[0].email +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idE' type='hidden' value='"+ objDados[0].idE +"'>"
                                       + "          <label class='control-label'>Logradouro</label>"
                                       + "          <input id='logradouro' name='logradouro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('logradouro') value='"+ objDados[0].logradouro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Bairro</label>"
                                       + "          <input id='bairro' name='bairro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('bairro') value='"+ objDados[0].bairro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Número</label>"
                                       + "          <input id='numero' name='numero' type='text' maxlength='11' onblur= setSEP() onkeyup= apenasNumeros('numero') value='"+ objDados[0].numero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Complemento</label>"
                                       + "          <input id='complemento' name='complemento' type='text' maxlength='144' onblur= setSEP() onkeyup= maiuscula('complemento') value='"+ objDados[0].complemento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cidade</label>"
                                       + "          <input id='cidade' name='cidade' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('cidade') value='"+ objDados[0].cidade +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CEP</label>"
                                       + "          <input id='cep' name='cep' type='text' maxlength='10' onblur= setSEP() onkeyup= mcepInnert('cep') value='"+ objDados[0].cep +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Estado</label>"
                                       + "          <input id='estado' name='estado' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('estado') value='"+ objDados[0].estado +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>País</label>"
                                       + "          <input id='pais' name='pais' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('pais') value='"+ objDados[0].pais +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<button type='submit' style='text-transform: uppercase;' class='btn btn-primary pull-right' name='logica' value='GravarRetificacao'>Gravar</button>"
                                       + "<div class='clearfix'></div>";
                    
                    }
                
                    if(objDados[0].cargo === "Medico Regulador"){
                        
                        var estadoCrm = objDados[0].crm.split("/", 2);
                        
                        secaoBox.innerHTML = "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CPF</label>"
                                       + "          <input id='cpfI' name='cpfI' maxlength='14' onkeyup= cpfInnert('cpfI') type='text' value='"+ objDados[0].cpf +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>RG</label>"
                                       + "          <input id='rg' name='rg' maxlength='11' onkeyup= rgInnert('rg') type='text' value='"+ objDados[0].rg +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Data de Nascimento</label>"
                                       + "          <input id='nascimento' name='nascimento' maxlength='10' onkeyup= dataInnert('nascimento') type='text' value='"+ objDados[0].nascimento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-8'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nome</label>"
                                       + "          <input id='nome' name='nome' type='text' onkeyup= maiuscula('nome') value='"+ objDados[0].nome +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Genero</label>"
                                       + "          <input id='genero' name='genero' type='text' onkeyup= maiuscula('genero') value='"+ objDados[0].genero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>UF do CRM</label>"
                                       + "          <input id='uf' name='uf' onkeyup= maiusculaSigla('uf') maxlength='2' type='text' value='"+ estadoCrm[0] +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nº Crm</label>"
                                       + "          <input id='crm' name='crm' onkeyup= apenasNumeros('crm') maxlength='10' type='text' value='"+ estadoCrm[1] +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cargo</label>"
                                       + "          <input id='cargo' name='cargo' type='text' onkeyup= maiuscula('cargo') value='"+ objDados[0].cargo +"' class='form-control' disabled>"
                                       + "          <input name='cargo' type='hidden' value='"+ objDados[0].cargo +"'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group'  style='margin-top: 0px'>"
                                       + "          <label class='control-label' style='margin-top: 12px'>Situação</label>"
                                       + "              <select id='situacao' name='situacao' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>"
                                       + "                  <option name='ativo' value='Ativo'>Ativo</option>"
                                       + "                  <option name='inativo' value='Inativo'>Inativo</option>"
                                       + "              </select>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idC' type='hidden' value='"+ objDados[0].idC +"'>"
                                       + "          <label class='control-label'>Telefone</label>"
                                       + "          <input id='telefone' name='telefone' type='text' maxlength='14' onkeyup= mtelInnert('telefone') value='"+ objDados[0].telefone +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Celular</label>"
                                       + "          <input id='celular' name='celular' type='text' maxlength='15' onkeyup= mtelInnert('celular') value='"+ objDados[0].cel +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>E-mail</label>"
                                       + "          <input id='email' name='email' type='email' value='"+ objDados[0].email +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idE' type='hidden' value='"+ objDados[0].idE +"'>"
                                       + "          <label class='control-label'>Logradouro</label>"
                                       + "          <input id='logradouro' name='logradouro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('logradouro') value='"+ objDados[0].logradouro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Bairro</label>"
                                       + "          <input id='bairro' name='bairro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('bairro') value='"+ objDados[0].bairro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Número</label>"
                                       + "          <input id='numero' name='numero' type='text' maxlength='11' onblur= setSEP() onkeyup= apenasNumeros('numero') value='"+ objDados[0].numero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Complemento</label>"
                                       + "          <input id='complemento' name='complemento' type='text' maxlength='144' onblur= setSEP() onkeyup= maiuscula('complemento') value='"+ objDados[0].complemento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cidade</label>"
                                       + "          <input id='cidade' name='cidade' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('cidade') value='"+ objDados[0].cidade +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CEP</label>"
                                       + "          <input id='cep' name='cep' type='text' maxlength='10' onblur= setSEP() onkeyup= mcepInnert('cep') value='"+ objDados[0].cep +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Estado</label>"
                                       + "          <input id='estado' name='estado' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('estado') value='"+ objDados[0].estado +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>País</label>"
                                       + "          <input id='pais' name='pais' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('pais') value='"+ objDados[0].pais +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<button type='submit' style='text-transform: uppercase;' class='btn btn-primary pull-right' name='logica' value='GravarRetificacao'>Gravar</button>"
                                       + "<div class='clearfix'></div>";
                           
                    }
                
                    if(objDados[0].cargo === "Motorista"){
                        
                        secaoBox.innerHTML = "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CPF</label>"
                                       + "          <input id='cpfI' name='cpfI' maxlength='14' onkeyup= cpfInnert('cpfI') type='text' value='"+ objDados[0].cpf +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>RG</label>"
                                       + "          <input id='rg' name='rg' maxlength='11' onkeyup= rgInnert('rg') type='text' value='"+ objDados[0].rg +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Data de Nascimento</label>"
                                       + "          <input id='nascimento' name='nascimento' maxlength='10' onkeyup= dataInnert('nascimento') type='text' value='"+ objDados[0].nascimento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-8'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nome</label>"
                                       + "          <input id='nome' name='nome' type='text' onkeyup= maiuscula('nome') value='"+ objDados[0].nome +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Genero</label>"
                                       + "          <input id='genero' name='genero' type='text' onkeyup= maiuscula('genero') value='"+ objDados[0].genero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nº CNH</label>"
                                       + "          <input id='cnh' onkeyup= apenasNumeros('cnh') maxlength='11' name='cnh' type='text' value='"+ objDados[0].cnh +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"                                       
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cargo</label>"
                                       + "          <input id='cargo' name='cargo' type='text' onkeyup= maiuscula('cargo') value='"+ objDados[0].cargo +"' class='form-control' disabled>"
                                       + "          <input name='cargo' type='hidden' value='"+ objDados[0].cargo +"'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group'  style='margin-top: 0px'>"
                                       + "          <label class='control-label' style='margin-top: 12px'>Situação</label>"
                                       + "              <select id='situacao' name='situacao' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>"
                                       + "                  <option name='ativo' value='Ativo'>Ativo</option>"
                                       + "                  <option name='inativo' value='Inativo'>Inativo</option>"
                                       + "              </select>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idC' type='hidden' value='"+ objDados[0].idC +"'>"
                                       + "          <label class='control-label'>Telefone</label>"
                                       + "          <input id='telefone' name='telefone' type='text' maxlength='14' onkeyup= mtelInnert('telefone') value='"+ objDados[0].telefone +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Celular</label>"
                                       + "          <input id='celular' name='celular' type='text' maxlength='15' onkeyup= mtelInnert('celular') value='"+ objDados[0].cel +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>E-mail</label>"
                                       + "          <input id='email' name='email' type='email' value='"+ objDados[0].email +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idE' type='hidden' value='"+ objDados[0].idE +"'>"
                                       + "          <label class='control-label'>Logradouro</label>"
                                       + "          <input id='logradouro' name='logradouro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('logradouro') value='"+ objDados[0].logradouro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Bairro</label>"
                                       + "          <input id='bairro' name='bairro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('bairro') value='"+ objDados[0].bairro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Número</label>"
                                       + "          <input id='numero' name='numero' type='text' maxlength='11' onblur= setSEP() onkeyup= apenasNumeros('numero') value='"+ objDados[0].numero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Complemento</label>"
                                       + "          <input id='complemento' name='complemento' type='text' maxlength='144' onblur= setSEP() onkeyup= maiuscula('complemento') value='"+ objDados[0].complemento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cidade</label>"
                                       + "          <input id='cidade' name='cidade' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('cidade') value='"+ objDados[0].cidade +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CEP</label>"
                                       + "          <input id='cep' name='cep' type='text' maxlength='10' onblur= setSEP() onkeyup= mcepInnert('cep') value='"+ objDados[0].cep +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Estado</label>"
                                       + "          <input id='estado' name='estado' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('estado') value='"+ objDados[0].estado +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>País</label>"
                                       + "          <input id='pais' name='pais' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('pais') value='"+ objDados[0].pais +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<button type='submit' style='text-transform: uppercase;' class='btn btn-primary pull-right' name='logica' value='GravarRetificacao'>Gravar</button>"
                                       + "<div class='clearfix'></div>";
                        
                    }
                
                    if(objDados[0].cargo === "Tarm"){
                        
                        secaoBox.innerHTML = "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CPF</label>"
                                       + "          <input id='cpfI' name='cpfI' maxlength='14' onkeyup= cpfInnert('cpfI') type='text' value='"+ objDados[0].cpf +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>RG</label>"
                                       + "          <input id='rg' name='rg' maxlength='11' onkeyup= rgInnert('rg') type='text' value='"+ objDados[0].rg +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Data de Nascimento</label>"
                                       + "          <input id='nascimento' name='nascimento' maxlength='10' onkeyup= dataInnert('nascimento') type='text' value='"+ objDados[0].nascimento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Nome</label>"
                                       + "          <input id='nome' name='nome' type='text' onkeyup= maiuscula('nome') value='"+ objDados[0].nome +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Genero</label>"
                                       + "          <input id='genero' name='genero' type='text' onkeyup= maiuscula('genero') value='"+ objDados[0].genero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cargo</label>"
                                       + "          <input id='cargo' name='cargo' type='text' onkeyup= maiuscula('cargo') value='"+ objDados[0].cargo +"' class='form-control' disabled>"
                                       + "          <input name='cargo' type='hidden' value='"+ objDados[0].cargo +"'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group'  style='margin-top: 0px'>"
                                       + "          <label class='control-label' style='margin-top: 12px'>Situação</label>"
                                       + "              <select id='situacao' name='situacao' class='form-control selectpicker' data-style='select-with-transition' data-size='2'>"
                                       + "                  <option name='ativo' value='Ativo'>Ativo</option>"
                                       + "                  <option name='inativo' value='Inativo'>Inativo</option>"
                                       + "              </select>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"                                       
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idC' type='hidden' value='"+ objDados[0].idC +"'>"
                                       + "          <label class='control-label'>Telefone</label>"
                                       + "          <input id='telefone' name='telefone' type='text' maxlength='14' onkeyup= mtelInnert('telefone') value='"+ objDados[0].telefone +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Celular</label>"
                                       + "          <input id='celular' name='celular' type='text' maxlength='15' onkeyup= mtelInnert('celular') value='"+ objDados[0].cel +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>E-mail</label>"
                                       + "          <input id='email' name='email' type='email' value='"+ objDados[0].email +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <input name='idE' type='hidden' value='"+ objDados[0].idE +"'>"
                                       + "          <label class='control-label'>Logradouro</label>"
                                       + "          <input id='logradouro' name='logradouro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('logradouro') value='"+ objDados[0].logradouro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Bairro</label>"
                                       + "          <input id='bairro' name='bairro' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('bairro') value='"+ objDados[0].bairro +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Número</label>"
                                       + "          <input id='numero' name='numero' type='text' maxlength='11' onblur= setSEP() onkeyup= apenasNumeros('numero') value='"+ objDados[0].numero +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<div class='row'>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Complemento</label>"
                                       + "          <input id='complemento' name='complemento' type='text' maxlength='144' onblur= setSEP() onkeyup= maiuscula('complemento') value='"+ objDados[0].complemento +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-4'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Cidade</label>"
                                       + "          <input id='cidade' name='cidade' type='text' maxlength='50' onblur= setSEP() onkeyup= maiuscula('cidade') value='"+ objDados[0].cidade +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-2'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>CEP</label>"
                                       + "          <input id='cep' name='cep' type='text' maxlength='10' onblur= setSEP() onkeyup= mcepInnert('cep') value='"+ objDados[0].cep +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>Estado</label>"
                                       + "          <input id='estado' name='estado' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('estado') value='"+ objDados[0].estado +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "  <div class='col-md-1'>"
                                       + "      <div class='form-group label-floating'>"
                                       + "          <label class='control-label'>País</label>"
                                       + "          <input id='pais' name='pais' type='text' maxlength='2' onblur= setSEP() onkeyup= maiusculaSigla('pais') value='"+ objDados[0].pais +"' class='form-control'>"
                                       + "      </div>"
                                       + "  </div>"
                                       + "</div>"
                                       + "<button type='submit' style='text-transform: uppercase;' class='btn btn-primary pull-right' name='logica' value='GravarRetificacao'>Gravar</button>"
                                       + "<div class='clearfix'></div>";
                        
                    }
                    
                }                                
                
                $('.selectpicker').selectpicker('refresh');
                
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
        function maiusculaSigla(id){
            
            var x = document.getElementById(id);
            x.value = x.value.toUpperCase();
                       
        }
    </script>
    
    <script>
        <c:if test="${not empty alerta.tipoAlerta}">
        swal({type: '${alerta.tipoAlerta}', title: 'Hey...', text: '${alerta.msnAlerta}', showConfirmButton: false, timer: 2500}).then((value) => {
            location.href="controle?logica=Alteracao&nomeUsuario=${sessionScope.admin.nomeUsuario}";
        });
        </c:if>
    </script>

</html>
