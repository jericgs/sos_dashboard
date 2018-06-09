<%-- 
    Document   : areaTarm
    Created on : 30/05/2018, 19:20:39
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="Resources/node_modules/font-awe/font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons" rel='stylesheet'>
    </head>

    <body>

        <c:if test="${sessionScope.status == null}">
            <jsp:forward page="controle?logica=Login&usuario=L&senha=S"></jsp:forward>                
        </c:if>       

        <div class="wrapper">
            <!--../assets/img/sidebar-1.jpg -->
            <div class="sidebar" data-color="red" data-image="">
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
                        <li class="active">
                            <a href="./areaTarm.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Painel</p>
                            </a>
                        </li>                                                
                        <li>
                            <a href="./chamado.jsp">
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
                            <a class="navbar-brand"> Ocorrências </a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">                                                        
                                <li>
                                    <a href="controle?logica=Logout&status=${sessionScope.status}">
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
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="orange">
                                        <i class="material-icons">content_copy</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Used Space</p>
                                        <h3 class="title">49/50
                                            <small>GB</small>
                                        </h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons text-danger">warning</i>
                                            <a href="#pablo">Get More Space...</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="green">
                                        <i class="material-icons">store</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Revenue</p>
                                        <h3 class="title">$34,245</h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">date_range</i> Last 24 Hours
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="red">
                                        <i class="material-icons">info_outline</i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Fixed Issues</p>
                                        <h3 class="title">75</h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">local_offer</i> Tracked from Github
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="card card-stats">
                                    <div class="card-header" data-background-color="blue">
                                        <i class="fa fa-twitter"></i>
                                    </div>
                                    <div class="card-content">
                                        <p class="category">Followers</p>
                                        <h3 class="title">+245</h3>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">update</i> Just Updated
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-header card-chart" data-background-color="green">
                                        <div class="ct-chart" id="dailySalesChart"></div>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="title">Daily Sales</h4>
                                        <p class="category">
                                            <span class="text-success"><i class="fa fa-long-arrow-up"></i> 55% </span> increase in today sales.</p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">access_time</i> updated 4 minutes ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-header card-chart" data-background-color="orange">
                                        <div class="ct-chart" id="emailsSubscriptionChart"></div>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="title">Email Subscriptions</h4>
                                        <p class="category">Last Campaign Performance</p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">access_time</i> campaign sent 2 days ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-header card-chart" data-background-color="red">
                                        <div class="ct-chart" id="completedTasksChart"></div>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="title">Completed Tasks</h4>
                                        <p class="category">Last Campaign Performance</p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="material-icons">access_time</i> campaign sent 2 days ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 col-md-12">
                                <div class="card card-nav-tabs">
                                    <div class="card-header" data-background-color="purple">
                                        <div class="nav-tabs-navigation">
                                            <div class="nav-tabs-wrapper">
                                                <span class="nav-tabs-title">Tasks:</span>
                                                <ul class="nav nav-tabs" data-tabs="tabs">
                                                    <li class="active">
                                                        <a href="#profile" data-toggle="tab">
                                                            <i class="material-icons">bug_report</i> Bugs
                                                            <div class="ripple-container"></div>
                                                        </a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#messages" data-toggle="tab">
                                                            <i class="material-icons">code</i> Website
                                                            <div class="ripple-container"></div>
                                                        </a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#settings" data-toggle="tab">
                                                            <i class="material-icons">cloud</i> Server
                                                            <div class="ripple-container"></div>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-content">
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="profile">
                                                <table class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes" checked>
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Sign contract for "What are conference organizers afraid of?"</td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Lines From Great Russian Literature? Or E-mails From My Boss?</td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit
                                                            </td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes" checked>
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Create 4 Invisible User Experiences you Never Knew About</td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="tab-pane" id="messages">
                                                <table class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes" checked>
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit
                                                            </td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Sign contract for "What are conference organizers afraid of?"</td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="tab-pane" id="settings">
                                                <table class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Lines From Great Russian Literature? Or E-mails From My Boss?</td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes" checked>
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit
                                                            </td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox" name="optionsCheckboxes">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                            <td>Sign contract for "What are conference organizers afraid of?"</td>
                                                            <td class="td-actions text-right">
                                                                <button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs">
                                                                    <i class="material-icons">edit</i>
                                                                </button>
                                                                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                                                    <i class="material-icons">close</i>
                                                                </button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12">
                                <div class="card">
                                    <div class="card-header" data-background-color="orange">
                                        <h4 class="title">Employees Stats</h4>
                                        <p class="category">New employees on 15th September, 2016</p>
                                    </div>
                                    <div class="card-content table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-warning">
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Salary</th>
                                            <th>Country</th>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Dakota Rice</td>
                                                    <td>$36,738</td>
                                                    <td>Niger</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Minerva Hooper</td>
                                                    <td>$23,789</td>
                                                    <td>Curaçao</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Sage Rodriguez</td>
                                                    <td>$56,142</td>
                                                    <td>Netherlands</td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Philip Chaney</td>
                                                    <td>$38,735</td>
                                                    <td>Korea, South</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="container-fluid">
                        <!--<nav class="pull-left">
                            <ul>
                                <li>
                                    <a href="controle?logica=Index">
                                        Home
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        Company
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        Portfolio
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        Blog
                                    </a>
                                </li>
                            </ul>
                        </nav>-->
                        <p class="copyright pull-right">
                            &copy;
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            , Coded by
                            <a href="http://lattes.cnpq.br/1048245272218464">Erick Gomes</a>
                        </p>
                    </div>
                </footer>
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
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/disp-dasboard/bootstrap-notify.js"></script>
    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8kJ3p081G1hbsHQLkydJg8AtpVUznejw"async defer></script>
    <!-- Material Dashboard javascript methods -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/material-dashboard.js?v=1.2.0"></script>
    <!-- Material Dashboard DEMO methods, don't include it in your project! -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/demo.js"></script>
    <script type="text/javascript">
                                $(document).ready(function () {

                                    // Javascript method's body can be found in assets/js/demos.js
                                    demo.initDashboardPageCharts();

                                });
    </script>
</html>