<%-- 
    Document   : listaRegulacao
    Created on : 01/07/2018, 11:44:35
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Médico</title>

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
                        <li>
                            <a href="./areaMedico.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Painel</p>
                            </a>
                        </li>                                                
                        <li class="active">
                            <a href="controle?logica=ListaRegulacoes&nomeUsuario=${sessionScope.medico.nomeUsuario}">
                                <i class="material-icons">library_books</i>
                                <p>Regulação</p>
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
                            <a class="navbar-brand">Chamados</a>
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
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header" data-background-color="red">
                                        <h4 class="title">Esperando Regulação</h4>
                                        <p class="category">Regulação - 1/N</p>
                                    </div>
                                    <div class="card-content table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-primary">
                                            <th>ID Regulação</th>
                                            <th>Paciente</th>
                                            <th>Idade</th>
                                            <th>Motivo</th>
                                            <th>Queixa</th>
                                            </thead>
                                            <tbody>
                                                <tr style='cursor:pointer' onclick="document.location='http://lattes.cnpq.br/1048245272218464'">
                                                    <td>Dakota Rice</td>
                                                    <td>Niger</td>
                                                    <td>Niger</td>
                                                    <td>Oud-Turnhout</td>
                                                    <td>$36,738</td>
                                                </tr>                                                                                                                                           
                                            </tbody>
                                        </table>
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
            setChamadosEmRegulacao();
            function setChamadosEmRegulacao() {

                setTimeout(setChamadosEmRegulacao, 1000);
                
                //combobox.innerHTML = "";

               $.post("AjaxControle", {logicaAjax: "AreaAjaxListaRegulacao", cpfm: "${sessionScope.dadosMedicoRegulador.CPFM}"}, function (data, status) {

                    //NATIVO
                    //var dados = '{"clientes": [{"id":"1", "nome":"Erick", "email":"jerick.gs@gmail.com"}, {"id":"2", "nome":"Marcos", "email":"marcos.gs@gmail.com"}, {"id":"3", "nome":"José", "email":"jose.gs@gmail.com"}]}';
                    var objDados = JSON.parse(data);

//                    combobox = document.getElementById("combobox");
//
//                    for (i = 0; i < objDados.length; i++) {
//                        //conteudo.innerHTML += objDados.clientes[i].id + "| " + objDados.clientes[i].nome + " | " + objDados.clientes[i].email + "<br>";
//                        //combobox.innerHTML += "<option value='" + objDados[i].cpfm + "'>" + objDados.clientes[i].nome + "</option>";
//
//                        combobox.innerHTML += "<option value='" + objDados[i].cpfm + "'>" + objDados[i].nome + "</option>";
//                    }
//
//                    $('.selectpicker').selectpicker('refresh');

               });
                
            }
        });
    </script>
    
</html>
