<%-- 
    Document   : index
    Created on : 22/05/2018, 21:32:00
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>SAMU</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.css">        
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/style.css">

        <!-- Ícone -->        
        <link rel="icon" type="image/png" href="Resources/imagens/icons/icon.ico">

        <!-- CSS Style-->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/style-page1.css">        

        <!-- Navbar Fixo no Top -->
        <link href="navbar-top-fixed.css" rel="stylesheet">

        <!-- Font -->
        <link href= "https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel='stylesheet' type='text/css'>         

        <!-- Awesome  -->
        <link rel="stylesheet" type='text/css' href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



    </head>
    <body class="body" data-container="home"> 

        <!-- NAVEGAÇÃO -->
        <nav class="navbar fixed-top navbar-expand-lg navbar-light navbarSombra"style="background-color: #1B2B5E;" data-container="menu">

            <div class="container">

                <a class="navbar-brand mb-0" href="#"><img alt="Brand" src="Resources/imagens/icons/favicon.png"></a>                
                <button class="navbar-toggler custom-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSite">

                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-container="link" data-link="home">HOME</a>                                                    
                        </li>
                        <li class="nav-item">                            
                            <a class="nav-link" href="#" data-container="link" data-link="sobre">SOBRE</a>                            
                        </li>
                        <li class="nav-item">                            
                            <a class="nav-link" href="#" data-container="link" data-link="protocolos">PROTOCOLOS</a>                            
                        </li>                         
                        <li class="nav-item">                            
                            <a class="nav-link" href="#" data-container="link" data-link="local">LOCAL</a>                            
                        </li>
                        <li class="nav-item">                            
                            <a class="nav-link" href="#" data-container="link" data-link="contato">CONTATO</a>                            
                        </li>
                        <li class="nav-item">                              
                            <a class="nav-link" href="controle?logica=Login&usuario=L&senha=S">LOGIN</a>                            
                        </li> 
                    </ul>

                </div>

            </div>

        </nav>             

        <!-- HOME -->
        <div id="carouselSite" class="carousel slide" data-ride="carousel">

            <ol class="carousel-indicators">
                <li data-target="#carouselSite" data-slide-to="0" class="active"></li>
                <li data-target="#carouselSite" data-slide-to="1"></li>
                <li data-target="#carouselSite" data-slide-to="2"></li>
            </ol>

            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="Resources/imagens/carousel/slide-01.png" class="img-fluid d-block">                     
                </div>
                <div class="carousel-item">
                    <img src="Resources/imagens/carousel/slide-02.png" class="img-fluid d-block">
                </div>
                <div class="carousel-item">
                    <img src="Resources/imagens/carousel/slide-03.png" class="img-fluid d-block">                
                </div>  
            </div>

            <a class="carousel-control-prev" href="#carouselSite" role="button" data-slide="prev">

                <span class="carousel-control-prev-icon"></span>
                <span class="sr-only">Anterior</span>

            </a>
            <a class="carousel-control-next" href="#carouselSite" role="button" data-slide="next">

                <span class="carousel-control-next-icon"></span>
                <span class="sr-only">Avançar</span>

            </a>

        </div>

        <!-- SOBRE -->
        <div data-container="sobre" class="section section-gray section-clients">
            <div class="container text-center">                    
                <h4 class="header-text">SAMU 192 - MOSSORÓ</h4>
                <hr>
                <p>
                    O Serviço de Atendimento Móvel de Urgência (SAMU), acessado por chamada gratuita pelo número 192 é o principal componente da Política Nacional de Atenção às Urgências, criada em 2003, que tem como finalidade proteger a vida das pessoas e garantir a qualidade no atendimento no SUS. O serviço funciona 24 horas por dia com equipes de profissionais de saúde e realiza o atendimento de urgência e emergência em qualquer lugar: residências, locais de trabalho e vias públicas. Na cidade de Mossoró, o serviço foi iniciado em 3 de março de 2005 e atualmente são cinco ambulâncias, sendo duas Alfas e três Bravos, distribuídos estrategicamente.<br>
                </p>
                <div class="logos">
                    <ul class="list-unstyled">
                        <li ><img class="mb-5" src="Resources/imagens/body/rn.png"/></li>                        
                        <li ><img class="mb-5" src="Resources/imagens/body/mossoro.png"/></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- PROTOCOLOS -->
        <div class="section section-features" data-container="protocolos">
            <div class="container">
                <h4 class="header-text text-center">Protocolos</h4>
                <hr>

                <div class="row row justify-content-sm-center">

                    <div class="col-sm-6 col-md-4">

                        <div class="card card-member mb-5">

                            <img class="card-img-top" src="Resources/imagens/body/SBV.png">
                            <div class="card-body">
                                <h5 class="card-title">Ministério da Saúde</h5>                                
                                <h6 class="card-text">Protocolos de Intervenção para o SAMU 192 - Serviço de Atendimento Móvel de Urgência. Brasília: Ministério da Saúde, 2016.</h6>                                
                            </div>                          
                            <div class="card-body">                                
                                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#acessoSBV">Acesso</a>
                                <a href="#" class="btn btn-secondary ml-2" href="http://portalarquivos.saude.gov.br/images/pdf/2016/outubro/26/livro-basico-2016.pdf" download="livro-basico-2016.pdf">Baixar</a>                                                                                              
                            </div>                            
                        </div>

                    </div>

                    <div class="col-sm-6 col-md-4">

                        <div class="card card-member mb-5">

                            <img class="card-img-top" src="Resources/imagens/body/SAV.png">
                            <div class="card-body">
                                <h5 class="card-title">Ministério da Saúde</h5>                                
                                <h6 class="card-text">Protocolos de Intervenção para o SAMU 192 - Serviço de Atendimento Móvel de Urgência. Brasília: Ministério da Saúde, 2a edição, 2016.</h6>

                            </div>                           
                            <div class="card-body">                                
                                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#acessoSAV">Acesso</a>
                                <a href="#" class="btn btn-secondary ml-2" href="http://portalarquivos.saude.gov.br/images/pdf/2016/outubro/26/livro-avancado-2016.pdf" download="livro-avancado-2016.pdf">Baixar</a>
                            </div>
                        </div>

                    </div>

                    <div class="col-sm-6 col-md-4">

                        <div class="card card-member mb-5">

                            <img class="card-img-top" src="Resources/imagens/body/RM.png">
                            <div class="card-body">
                                <h5 class="card-title">Ministério da Saúde</h5>                                
                                <h6 class="card-text">Protocolo de Regulação médica das urgências, Secretaria de Atenção à Saúde. Série A. Normas e Manuais Técnicos, 2006.</h6>

                            </div>                         
                            <div class="card-body">
                                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#acessoRM">Acesso</a>
                                <a href="#" class="btn btn-secondary ml-2" href="http://bvsms.saude.gov.br/bvs/publicacoes/regulacao_medica_urgencias.pdf" download="regulacao_medica_urgencias.pdf">Baixar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>               

        <!-- LOCALIZAÇÃO -->
        <section class="contact" data-container="local">
            <div id="map"></div>
            <div class="text-center">
                <div class="container form-holder">
                    <header>
                        <h4>ENDEREÇO</h4>
                        <h5>R. Seis de Janeiro, SN - Bom Jardim, Mossoró - RN, 59611-030</h5>
                    </header>                    
                </div>
            </div>
        </section>

        <!-- CONTATO -->
        <footer class="footer text-center" data-container="contato">
            <div class="container">
                <h4 class="textBranco">CONTATOS</h4>
                <hr color="#fff">
                <div class="row">
                    <div class="col-md-6 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Telefones:</h4>
                        <p class="lead mb-0"><span class="fa fa-phone-square"></span> (84) 3315-4917<br><span class="fa fa-phone-square"></span> (84) 3315-4883</p>
                    </div>
                    <div class="col-md-6 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Nós encontre</h4>
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="https://www.facebook.com/SAMU-192-RN-Mossor%C3%B3-DJ-199721106877265/">
                                    <i class="fa fa-fw fa-facebook"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="https://www.instagram.com/explore/locations/287502268/samu-192-rn-mossoro-dj/">
                                    <i class="fa fa-fw fa-instagram"></i>
                                </a>
                            </li>
                            <!--<li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-twitter"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa fa-youtube-play"></i>
                                </a>
                            </li>-->                           
                        </ul>
                    </div>                    
                </div>
            </div>
        </footer>

        <!-- RODAPÉ -->        
        <div class="copyright py-4 text-center text-white">
            <div class="container">
                <small herf="http://lattes.cnpq.br/1048245272218464">&copy; Copyright · 2018 · <a class="styleLink" href="http://lattes.cnpq.br/1048245272218464">Erick Gomes</a></small>
            </div>
        </div>



        <!-- Modal SBV -->
        <div class="modal fade" id="acessoSBV" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Protocolo de Suporte Básico de Vida</h5>
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>                                
                        </button>
                    </div>

                    <div class="modal-body">
                        <embed src="http://portalarquivos.saude.gov.br/images/pdf/2016/outubro/26/livro-basico-2016.pdf" frameborder="0" width="100%" height="500" type='application/pdf'>
                    </div>                    
                </div>

            </div>

        </div>

        <!-- Modal SAV -->
        <div class="modal fade" id="acessoSAV" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Protocolo de Suporte Básico de Vida</h5>
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>                                
                        </button>
                    </div>

                    <div class="modal-body">
                        <embed src="http://portalarquivos.saude.gov.br/images/pdf/2016/outubro/26/livro-avancado-2016.pdf" frameborder="0" width="100%" height="500" type='application/pdf'>
                    </div>                    
                </div>

            </div>

        </div>

        <!-- Modal RM -->
        <div class="modal fade" id="acessoRM" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Protocolo de Suporte Básico de Vida</h5>
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>                                
                        </button>
                    </div>

                    <div class="modal-body">
                        <embed src="http://bvsms.saude.gov.br/bvs/publicacoes/regulacao_medica_urgencias.pdf" frameborder="0" width="100%" height="500" type='application/pdf'>
                    </div>                    
                </div>

            </div>            

        </div>

        <!-- Optional JavaScript CSS -->
        <!-- JQuery primeiro, depois popper.js, depois Bootstrap JS -->
        <script src="Resources/node_modules/jquery/dist/jquery.js"></script>
        <script src="Resources/node_modules/popper.js/dist/umd/popper.js"></script>
        <script src="Resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>                
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8kJ3p081G1hbsHQLkydJg8AtpVUznejw&callback=initMap"async defer></script>

        <!-- SCRIPTS -->
        <script>
            var map;
            function initMap() {
                var myLatLng = {lat: -5.181558, lng: -37.345571};
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -5.186966, lng: -37.345682},
                    zoom: 15
                });

                var markerImage = 'Resources/imagens/icons/marker.png';

                var marker = new google.maps.Marker({
                    position: myLatLng,
                    map: map,
                    title: 'SAMU MOSSORÓ',
                    icon: markerImage
                });

                marker.addListener('click', function () {
                    infowindow.open(map, marker);
                });

            }
        </script>       
    </body>
</html>
