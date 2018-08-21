<%-- 
    Document   : areaTarm
    Created on : 30/05/2018, 19:20:39
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Tarm</title>

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
                        <li class="active">
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
                        <li>
                            <a href="controle?logica=Encaminhamento&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
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
                        <li>
                            <a href="controle?logica=Conta&nomeUsuario=${sessionScope.tarm.nomeUsuario}">
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
                            <a class="navbar-brand"> Ocorrências </a>
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
                <div class="content" style="padding-left: 15px; padding-right: 15px;">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="red">
                                        <i class="material-icons">favorite_border</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Socorro</p>
                                        <h3 id="numSocorro" class="title"></h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">update</i> Total no Dia
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="orange">
                                        <i class="material-icons">airport_shuttle</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Transporte</p>
                                        <h3 id="numTransporte" class="title"></h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">update</i> Total no Dia
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="blue">
                                        <i class="material-icons">info_outline</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Informação</p>
                                        <h3 id="numInformacao" class="title"></h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">update</i> Total no Dia
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="green">
                                        <i class="material-icons">check_circle</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Chamados</p>
                                        <h3 id="numMes" class="title"></h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">date_range</i> Total no Mês
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header card-chart" data-background-color="red">
                                        <div class="ct-chart" id="dailyCallsChart"></div>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="title">Chamados Diários</h4>
                                        <p class="category">Número de chamados dos últimos dias</p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">access_time</i> atualizado em tempo real
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header card-chart" data-background-color="green">
                                        <div class="ct-chart" id="monthlyCallsChart"></div>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="title">Chamados Mensais</h4>
                                        <p class="category">Número de chamados dos últimos meses</p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">access_time</i> atualizado em tempo real
                                        </div>
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

    <script type="text/javascript">
        $(function () {
            setNumChamadoSocorro();
            function setNumChamadoSocorro() {
                setTimeout(setNumChamadoSocorro, 1000);

                dataMomento = moment().format("DD/MM/YYYY");

                $.post("AjaxControle", {logicaAjax: "AreaAjaxSocorro", dataSocorro: dataMomento}, function (data, status) {

                    var objDados = JSON.parse(data);
                    numSocorro.innerHTML = objDados[0].numChamadoSocorro;

                });
            }
        });

    </script>

    <script type="text/javascript">
        $(function () {
            setNumChamadoTransporte();
            function setNumChamadoTransporte() {
                setTimeout(setNumChamadoTransporte, 1000);

                dataMomento = moment().format("DD/MM/YYYY");

                $.post("AjaxControle", {logicaAjax: "AreaAjaxTransporte", dataTransporte: dataMomento}, function (data, status) {

                    var objDados = JSON.parse(data);
                    numTransporte.innerHTML = objDados[0].numChamadoTransporte;

                });
            }
        });

    </script>

    <script type="text/javascript">
        $(function () {
            setNumChamadoInformacao();
            function setNumChamadoInformacao() {
                setTimeout(setNumChamadoInformacao, 1000);

                dataMomento = moment().format("DD/MM/YYYY");

                $.post("AjaxControle", {logicaAjax: "AreaAjaxInformacao", dataInformacao: dataMomento}, function (data, status) {

                    var objDados = JSON.parse(data);
                    numInformacao.innerHTML = objDados[0].numChamadoInformacao;

                });
            }
        });

    </script>

    <script type="text/javascript">
        $(function () {
            setNumChamadoMes();
            function setNumChamadoMes() {
                setTimeout(setNumChamadoMes, 1000);

                dataMomento = moment().format("MM/YYYY");

                $.post("AjaxControle", {logicaAjax: "AreaAjaxMes", dataMes: dataMomento}, function (data, status) {

                    var objDados = JSON.parse(data);
                    numMes.innerHTML = objDados[0].numChamadoMes;

                });
            }
        });

    </script>

    <script type="text/javascript">
        $(document).ready(function () {

            // O corpo do método Javascript pode ser encontrado em Resources/node_modules/bootstrap/js/disp-dasboard/demo.js            

            $.post("AjaxControle", {logicaAjax: "AreaAjaxGraficoCD"}, function (data, status) {

                var objDadosSemana = JSON.parse(data);
                demo.initDashboardPageChartsGraficoSemana(objDadosSemana);

            });

        });
    </script>

    <script type="text/javascript">
        $(document).ready(function () {

            // O corpo do método Javascript pode ser encontrado em Resources/node_modules/bootstrap/js/disp-dasboard/demo.js            

            $.post("AjaxControle", {logicaAjax: "AreaAjaxGraficoCM"}, function (data, status) {

                var objDadosMes = JSON.parse(data);
                demo.initDashboardPageChartsGraficoMes(objDadosMes);

            });

        });
    </script>

</html>