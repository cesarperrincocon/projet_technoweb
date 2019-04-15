<%-- 
    Document   : admin
    Created on : 12 avr. 2019, 10:46:53
    Author     : cperrinc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>Statistiques administrateur</title>

        <!-- Favicons -->
        <link href="Dashio/img/stat.png" rel="icon">

        <!-- Bootstrap core CSS -->
        <link href="Dashio/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="Dashio/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="Dashio/lib/bootstrap-datetimepicker/datertimepicker.css" />
        <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">	
        <!-- Custom styles for this template -->
        <link href="Dashio/css/style.css" rel="stylesheet">
        <link href="Dashio/css/style-responsive.css" rel="stylesheet">
        <link href="Dashio/css/custom.css" rel="stylesheet">

        <!-- =======================================================
          Template Name: Dashio
          Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
          Author: TemplateMag.com
          License: https://templatemag.com/license/
        ======================================================= -->
    </head>

    <body>
        <section id="container">
            <!-- **********************************************************************************************************************************************************
                TOP BAR CONTENT & NOTIFICATIONS
                *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a class="logo"><b><span>IO</span>N</b><b><span> IO</span>N</b><b><span> IO</span>N</b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <form class="logout" action="LoginController" method="POST">
                            <input class="form-control " type='submit' name='connexion' value='DECONNEXION'>
                        </form>
                    </ul>
                </div>
            </header>
            <!--header end-->
            <!-- **********************************************************************************************************************************************************
                MAIN SIDEBAR MENU
                *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <p class="centered">
                            <a href="profile.html"><img src="Dashio/img/hqdefault.jpg" class="img-circle" width="150" height="150"></a>
                        </p>
                        <h3 class="centered">Administrateur</h3>
                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->
            <!-- **********************************************************************************************************************************************************
                MAIN CONTENT
                *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i> Statistiques sur les commandes</h3>
                    <!-- page start-->
                    <div class="tab-pane" id="chartjs">
                        <div class="row mt">
                            <div class="form-panel">
                                <form method='POST' action="AdminController" class="form-horizontal style-form">
                                    <h4><i class="fa fa-angle-right"></i> Par catégorie d'article</h4>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Choix de la période</label>
                                        <div class="col-md-4">
                                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                                                <input type="text" class="form-control dpd1" name="date_debut_cat">
                                                <span class="input-group-addon">Au</span>
                                                <input type="text" class="form-control dpd2" name="date_fin_cat">
                                            </div>
                                        </div>
                                        <input type="hidden" name="action" value="caByProductCode">
                                        <input type="submit" class="btn btn-theme">
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Chiffre d'affaire par Catégorie d'article</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="doughnut1" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Chiffre d'affaire par Catégorie d'article</h4>
                                    <div class="panel-body">
                                        <div id="hero-bar1" class="graph"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt">
                            <div class="form-panel">
                                <form method='POST' action="AdminController" class="form-horizontal style-form">
                                    <h4><i class="fa fa-angle-right"></i> Par zone géographique</h4>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Choix de la période</label>
                                        <div class="col-md-4">
                                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                                                <input type="text" class="form-control dpd1" name="date_debut_geo">
                                                <span class="input-group-addon">Au</span>
                                                <input type="text" class="form-control dpd2" name="date_fin_geo">
                                            </div>
                                        </div>
                                        <input type="hidden" name="action" value="caByGeo">
                                        <input type="submit" class="btn btn-theme">						
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Chiffre d'affaire par Zone Géographique</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="doughnut2" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Chiffre d'affaire par Zone Géographique</h4>
                                    <div class="panel-body">
                                        <div id="hero-bar2" class="graph"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt">
                            <div class="form-panel">
                                <form method='POST' action="AdminController" class="form-horizontal style-form">
                                    <h4><i class="fa fa-angle-right"></i> Par client</h4>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Choix de la période</label>
                                        <div class="col-md-4">
                                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                                                <input type="text" class="form-control dpd1" name="date_debut_cli">
                                                <span class="input-group-addon">Au</span>
                                                <input type="text" class="form-control dpd2" name="date_fin_cli">
                                            </div>
                                        </div>
                                        <input type="hidden" name="action" value="caByCli">
                                        <input type="submit" class="btn btn-theme">						
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Chiffre d'affaire par Client</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="doughnut3" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Chiffre d'affaire par Client</h4>
                                    <div class="panel-body">
                                        <div id="hero-bar3" class="graph"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
            <!-- /MAIN CONTENT -->
            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    <p>
                        &copy; Copyrights <strong>Promotion 2021</strong> Année 2018-2019
                    </p>
                    <div class="credits">
                        <!--
                          You are NOT allowed to delete the credit link to TemplateMag with free version.
                          You can delete the credit link only if you bought the pro version.
                          Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
                          Licensing information: https://templatemag.com/license/
                        -->
                        Créé par Erwan JAFFRÉ, Paul SANDRÉ & César PERRIN-COCON
                    </div>
                    <a href="basic_table.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="Dashio/lib/jquery/jquery.min.js"></script>
        <script src="Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="Dashio/lib/jquery.dcjqaccordion.2.7.js"></script>
        <script src="Dashio/lib/jquery.scrollTo.min.js"></script>
        <script src="Dashio/lib/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="Dashio/lib/raphael/raphael.min.js"></script>
        <script src="Dashio/lib/morris/morris.min.js"></script>	
        <!--common script for all pages-->
        <script src="Dashio/lib/common-scripts.js"></script>
        <!--script for this page-->
        <script src="Dashio/lib/chart-master/Chart.js"></script>
        <script src="Dashio/lib/chartjs-conf.js"></script>
        <script type="text/javascript" src="Dashio/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="Dashio/lib/bootstrap-daterangepicker/date.js"></script>
        <script type="text/javascript" src="Dashio/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="Dashio/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="Dashio/lib/bootstrap-daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="Dashio/lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
        <script src="Dashio/lib/advanced-form-components.js"></script>
        <script src="Dashio/lib/morris-conf.js"></script>
    </body>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script>
        google.charts.load('current', {packages: ['corechart', 'bar']});

        google.charts.setOnLoadCallback(graphique_bar);

        function graphique_bar() {
            var donnees = [];
            donnees.push(['Type de produit', "Chiffre d'affaire"]);
        <c:forEach items="${productCodeCA}" var="item" >
            donnees.push(['${item.key}',${item.value}]);
        </c:forEach>
            console.log(donnees);
            var data = google.visualization.arrayToDataTable(donnees);
            var options = {
                title: 'CA par type de produit',
                chartArea: {width: '50%'},
                isStacked: true,
                hAxis: {
                    title: "CHIFFRE D'AFFAIRE en $",
                    minValue: 0
                },
                vAxis: {
                    title: 'CATEGORIE'
                }
            };
            var chart = new google.visualization.BarChart(document.getElementById("hero-bar1"));
            chart.draw(data, options);
        }
    </script>

    <script>
        google.charts.load('current', {packages: ['corechart', 'bar']});

        google.charts.setOnLoadCallback(graphique_bar);

        function graphique_bar() {
            var donnees = [];
            donnees.push(['Type de produit', "Chiffre d'affaire"]);
        <c:forEach items="${geoCA}" var="item" >
            donnees.push(['${item.key}',${item.value}]);
        </c:forEach>
            console.log(donnees);
            var data = google.visualization.arrayToDataTable(donnees);
            var options = {
                title: 'CA par zone géographique',
                chartArea: {width: '50%'},
                isStacked: true,
                hAxis: {
                    title: "CHIFFRE D'AFFAIRE en $",
                    minValue: 0
                },
                vAxis: {
                    title: 'ZONE GEO'
                }
            };
            var chart = new google.visualization.BarChart(document.getElementById("hero-bar2"));
            chart.draw(data, options);
        }
    </script>

    <script>
        google.charts.load('current', {packages: ['corechart', 'bar']});

        google.charts.setOnLoadCallback(graphique_bar);

        function graphique_bar() {
            var donnees = [];
            donnees.push(['Type de produit', "Chiffre d'affaire"]);
        <c:forEach items="${cliCA}" var="item" >
                donnees.push(['${item.key}',${item.value}]);
        </c:forEach>
            console.log(donnees);
            var data = google.visualization.arrayToDataTable(donnees);
            var options = {
                title: 'CA par Client',
                chartArea: {width: '50%'},
                isStacked: true,
                hAxis: {
                    title: "CHIFFRE D'AFFAIRE en $",
                    minValue: 0
                },
                vAxis: {
                    title: 'CLIENT'
                }
            };
            var chart = new google.visualization.BarChart(document.getElementById("hero-bar3"));
            chart.draw(data, options);
        }
    </script>

</html>
