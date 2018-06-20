<%-- 
    Document   : chamado
    Created on : 08/06/2018, 20:24:29
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Tarm</title>       

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
        <link href="Resources/node_modules/font-awe/font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons" rel='stylesheet'>
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
                            <a href="controle?logica=ChamadoSolicitante&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
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
                                        <p class="category">Solicitante - 1/2</p>
                                    </div>
                                    <div class="card-content">
                                        <form action="controle">
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">N°. Chamado</label>
                                                        <input id="numChamado" type="text" name="numChamado" value="null" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Data</label>
                                                        <input id="setData" type="text" name="data" value="null" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Hora</label>
                                                        <input id="setHora" type="text" name="hora" value="null" class="form-control">
                                                    </div>                                                    
                                                </div>
                                            </div>                                                                                     
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Solicitante</label>
                                                        <input type="text" name="solicitante" value="" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group label-floating">
                                                        <label class="control-label">Telefone</label>
                                                        <input id="telefone" type="text" name="telefone" maxlength="15" value="" class="form-control">
                                                    </div>
                                                </div>                                                
                                            </div>
                                            <div class="row ">
                                                <div class="col-md-6">                                                     
                                                    <div class="form-group"  style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">Médico Regulador</label>                                                        
                                                        <select autofocus id="combobox" name="medico" class="form-control selectpicker" data-style="select-with-transition" data-size="7">                                                                                                                        
                                                            <!--                                                             <option class="form-control" value="nenhum">Nenhum</option>-->
                                                            <option value="nenhum"></option>
                                                        </select>                                                        
                                                    </div>                                                                                                                                                     
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group label-floating" style="margin-top: 0px">
                                                        <label class="control-label" style="position: static">TARM</label>
                                                        <input type="text" name="nomeTarm" value="${sessionScope.dadosTarm.nome}" class="form-control ">
                                                    </div>
                                                </div>
                                            </div>   
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="motivo" value="Socorro" checked="true">
                                                            <p style="color: #AAAAAA;">Socorro</p>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="motivo" value="Transporte">
                                                            <p style="color: #AAAAAA;">Transporte</p>
                                                        </label>
                                                    </div>
                                                </div>      
                                                <div class="col-md-4">
                                                    <div class="radio">
                                                        <label> 
                                                            <input type="radio" name="motivo" value="Informacao">
                                                            <p style="color: #AAAAAA;">Informação</p>
                                                        </label>
                                                    </div>
                                                </div>      
                                            </div>                                            
                                            <button type="submit" style="text-transform: uppercase;" class="btn btn-primary pull-right" name="logica" value="ChamadoPaciente">Próximo</button>
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
        $(function () {
            setNumChamado();
            function setNumChamado() {
                setTimeout(setNumChamado, 1000);

                dataMomento = moment().format("DD/MM/YYYY");

                $.post("AjaxControle", {logicaAjax: "ChamadoSolicitanteAjax", data: dataMomento}, function (data, status) {

                    var objDados = JSON.parse(data);
                    $('#numChamado').val(objDados[0].numChamadoAtual);

                });
            }
        });
    </script>

    <script type="text/javascript">
        $(function () {
            setHora();
            function setHora() {
                setTimeout(setHora, 1000);
                $('#setHora').val(moment().format("hh:mm:ss a"));
                //            console.log(moment().format("hh:mm:ss a"));
            }
        });
    </script>

    <script type="text/javascript">
        $(function () {
            setData();
            function setData() {

                setTimeout(setData, 1000);
                $('#setData').val(moment().format("DD/MM/YYYY"));
//                                console.log(moment().format("DD/MM/YYYY"));
            }
        });
    </script>

    <script>

        $(document).ready(function () {

            setMedicos();

            function setMedicos() {

                console.log("Atualizou 1");

                combobox.innerHTML = "<option value='nenhum'>Nenhum</option>";

                $.get("AjaxControle?logicaAjax=ChamadoSolicitanteAjax&data=nenhum", function (data, status) {

                    //NATIVO
                    //var dados = '{"clientes": [{"id":"1", "nome":"Erick", "email":"jerick.gs@gmail.com"}, {"id":"2", "nome":"Marcos", "email":"marcos.gs@gmail.com"}, {"id":"3", "nome":"José", "email":"jose.gs@gmail.com"}]}';
                    var objDados = JSON.parse(data);

                    combobox = document.getElementById("combobox");

                    for (i = 0; i < objDados.length; i++) {
                        //conteudo.innerHTML += objDados.clientes[i].id + "| " + objDados.clientes[i].nome + " | " + objDados.clientes[i].email + "<br>";
                        //combobox.innerHTML += "<option value='" + objDados[i].cpfm + "'>" + objDados.clientes[i].nome + "</option>";

                        combobox.innerHTML += "<option value='" + objDados[i].cpfm + "'>" + objDados[i].nome + "</option>";
                    }

                    $('.selectpicker').selectpicker('refresh');

                });
            }

            $("#telefone").click(function () {
                console.log("Atualizou 2");

                combobox.innerHTML = "<option value='nenhum'>Nenhum</option>";

                $.get("AjaxControle?logicaAjax=ChamadoSolicitanteAjax&data=nenhum", function (data, status) {

                    //NATIVO
                    //var dados = '{"clientes": [{"id":"1", "nome":"Erick", "email":"jerick.gs@gmail.com"}, {"id":"2", "nome":"Marcos", "email":"marcos.gs@gmail.com"}, {"id":"3", "nome":"José", "email":"jose.gs@gmail.com"}]}';
                    var objDados = JSON.parse(data);

                    combobox = document.getElementById("combobox");

                    for (i = 0; i < objDados.length; i++) {
                        //combobox.innerHTML += objDados.clientes[i].id + "| " + objDados.clientes[i].nome + " | " + objDados.clientes[i].email + "<br>";
                        //combobox.innerHTML += "<option value='" + objDados[i].cpfm + "'>" + objDados.clientes[i].nome + "</option>";

                        combobox.innerHTML += "<option value='" + objDados[i].cpfm + "'>" + objDados[i].nome + "</option>";
                    }

                    $('.selectpicker').selectpicker('refresh');

                });

            });

        });

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
        function id(el) {
            return document.getElementById(el);
        }
        window.onload = function () {
            id('telefone').onkeyup = function () {
                mascara(this, mtel);
            };
        };
    </script>


</html>