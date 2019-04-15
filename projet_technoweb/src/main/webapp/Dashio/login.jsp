<%-- 
    Document   : login
    Created on : 5 avr. 2019, 15:21:47
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
        <title>Authentification</title>

        <!-- Favicons -->
        <link href="Dashio/img/login.png" rel="icon">

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
        <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
        <div id="login-page">
            <div class="container">
                <form class="form-login" action="LoginController" method = "post">
                    <h2 class="form-login-heading">Bienvenue</h2>
                    <div class="login-wrap">
                        <input name="loginParam" type="text" class="form-control" placeholder="Identifiant" autofocus>
                        <br>
                        <input name="passwordParam" type="password" class="form-control" placeholder="Mot de passe">
                        <button class="btn btn-theme btn-block signInButton" name="connexion" value="connexion"  type="submit" ><i class="fa fa-lock"></i> CONNEXION</button>
                    </div>
                    <!-- Modal -->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                    </div>
            </div>
            <!-- modal -->
        </form>
    </div>
</div>
<!-- js placed at the end of the document so the pages load faster -->
<script src="Dashio/lib/jquery/jquery.min.js"></script>
<script src="Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="Dashio/lib/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("Dashio/img/login-back.jpg", {
        speed: 500
    });
</script>
</body>

</html>
