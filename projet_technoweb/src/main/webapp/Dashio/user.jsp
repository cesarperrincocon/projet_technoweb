<%-- 
    Document   : user
    Created on : 12 avr. 2019, 10:45:54
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
        <title>Commandes</title>

        <!-- Favicons -->
        <link href="Dashio/img/order.png" rel="icon">
        <!-- Bootstrap core CSS -->
        <link href="Dashio/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="Dashio/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
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
                MAIN SIDEBAR MENU .
                *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <p class="centered">
                            <a><img src="Dashio/img/hqdefault.jpg" class="img-circle" width="150"></a>
                        </p>
                        <h3 class="centered">${userName}</h3>
                        <li class="mt">
                            <div class="centered">
                                <h5><i class="fa fa-money"></i> SOLDE</h5>							
                                <h4>${solde}$</h4>
                            </div>						
                        </li>
                        <li class="mt">
                            <div class="centered">
                                <form method='POST' action="customerController">
                                    <div class="centered">
                                        <div class="form-group">
                                            <label>Somme à verser</label>
                                            <input type="text" class="form-control" placeholder="montant" name="montant">
                                            <input type="hidden" name="action" value="DO_VIREMENT">
                                        </div>
                                    </div>
                                    <div class="centered">
                                        <div class="form-group">

                                            <button type="submit" class="btn btn-theme boutonArgent">Effectuer le virement</button>
                                        </div>
                                    </div>
                                </form>
                        </li>
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
                    <h3><i class="fa fa-angle-right"></i> Commandes</h3>
                    <div class="row mt">
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form action="#" class="form-horizontal style-form">
                                    <div class="form-inline">
                                        <label class="control-label col-md-3">Réaliser une nouvelle commande</label>
                                        <div class="col-md-3 col-xs-11">
                                            <select name="produit" class="select-custom selectpicker selecteurProduits">

                                                <c:forEach var="item" items="${listeProduits}">
                                                    <option value="${items}">${item}</option>
                                                </c:forEach>

                                            </select>
                                        </div>
                                        <input type="text" class="form-control" placeholder="Quantité">
                                        <button type="button" class="btn btn-theme"><i class="fa fa-check"></i> Valider</button>
                                    </div>
                                </form>
                            </div>
                            <!-- /form-panel -->
                        </div>
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <table class="table table-striped table-advance table-hover">
                                    <h4><i class="fa fa-angle-right"></i> Vos commandes</h4>
                                    <hr>
                                    <thead>
                                        <tr>
                                            <th><i class="fa fa-bookmark"> Numéro de commande</th>
                                            <th>Produit</th>
                                            <th>Prix</th>
                                            <th>Quantité</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <a href="basic_table.html#">Company Ltd</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>12000.00$ </td>
                                            <td>2</td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="basic_table.html#">
                                                    Dashio co
                                                </a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>17900.00$ </td>
                                            <td>3</td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="basic_table.html#">
                                                    Another Co
                                                </a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>14400.00$ </td>
                                            <td>25</td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="basic_table.html#">Dashio ext</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>22000.50$ </td>
                                            <td>52</td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="basic_table.html#">Total Ltd</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>12120.00$ </td>
                                            <td>2</td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /content-panel -->
                        </div>
                        <!-- /col-md-12 -->
                    </div>
                    <!-- /row -->
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
        <!--common script for all pages-->
        <script src="Dashio/lib/common-scripts.js"></script>
        <!--script for this page-->

    </body>

</html>
