<%-- 
    Document   : admin
    Created on : 12 avr. 2019, 10:46:53
    Author     : cperrinc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="img/stat.png" rel="icon">

        <!-- Bootstrap core CSS -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="lib/bootstrap-datetimepicker/datertimepicker.css" />
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">

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
                        <li><a class="logout" href="login.html">Logout</a></li>
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
                            <a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle" width="80"></a>
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
                                <form action="#" class="form-horizontal style-form">
                                    <h4><i class="fa fa-angle-right"></i> Par catégorie d'article</h4>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Choix de la période</label>
                                        <div class="col-md-4">
                                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                                                <input type="text" class="form-control dpd1" name="from">
                                                <span class="input-group-addon">Au</span>
                                                <input type="text" class="form-control dpd2" name="to">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-inline">
                                        <label class="control-label col-md-3">Catégorie :</label>
                                        <div class="col-md-3 col-xs-11">
                                            <select class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                        <button type="button" class="btn btn-theme"><i class="fa fa-check"></i> Valider</button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Doughnut</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="doughnut" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Line</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="line" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt">
                            <div class="form-panel">
                                <form action="#" class="form-horizontal style-form">
                                    <h4><i class="fa fa-angle-right"></i> Par zone géographique</h4>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Choix de la période</label>
                                        <div class="col-md-4">
                                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                                                <input type="text" class="form-control dpd1" name="from">
                                                <span class="input-group-addon">Au</span>
                                                <input type="text" class="form-control dpd2" name="to">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-inline">
                                        <label class="control-label col-md-3">Zone géographique :</label>
                                        <div class="col-md-3 col-xs-11">
                                            <select class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                        <button type="button" class="btn btn-theme"><i class="fa fa-check"></i> Valider</button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Radar</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="radar" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Polar Area</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="polarArea" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt">
                            <div class="form-panel">
                                <form action="#" class="form-horizontal style-form">
                                    <h4><i class="fa fa-angle-right"></i> Par client</h4>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Choix de la période</label>
                                        <div class="col-md-4">
                                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                                                <input type="text" class="form-control dpd1" name="from">
                                                <span class="input-group-addon">Au</span>
                                                <input type="text" class="form-control dpd2" name="to">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-inline">
                                        <label class="control-label col-md-3">Client :</label>
                                        <div class="col-md-3 col-xs-11">
                                            <select class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                        <button type="button" class="btn btn-theme"><i class="fa fa-check"></i> Valider</button>
                                    </div>					
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Bar</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="bar" height="300" width="400"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="content-panel">
                                    <h4><i class="fa fa-angle-right"></i> Pie</h4>
                                    <div class="panel-body text-center">
                                        <canvas id="pie" height="300" width="400"></canvas>
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
        <script src="lib/jquery/jquery.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
        <script src="lib/jquery.scrollTo.min.js"></script>
        <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
        <!--common script for all pages-->
        <script src="lib/common-scripts.js"></script>
        <!--script for this page-->
        <script src="lib/chart-master/Chart.js"></script>
        <script src="lib/chartjs-conf.js"></script>
        <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="lib/bootstrap-daterangepicker/date.js"></script>
        <script type="text/javascript" src="lib/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="lib/bootstrap-daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
        <script src="lib/advanced-form-components.js"></script>
    </body>

</html>
