<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html data-ng-app="Glimpse">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Glimpse</title>
  <link rel="icon" type="image/png" href="img/icon.png"/>

  <!--Application CSS-->
  <link rel="stylesheet" type="text/css" href="webapp/css/main.css">

  <!--Bootstrap CSS-->
  <link rel="stylesheet" type="text/css" href="webapp/css/bootstrap/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="webapp/css/bootstrap/bootstrap-theme.css">

  <!--Bootstrap-->
  <script type="text/javascript" src="webapp/vendor/bootstrap/ui-bootstrap-0.12.0.js"></script>	

  <!-- Angular -->  
  <script src="webapp/vendor/angular/angular.js"></script>
  <script src="webapp/vendor/angular/angular-messages.js"></script>
  <script src="webapp/vendor/angular/angular-route.js"></script>
  <script src="webapp/vendor/angular-animate.js"></script>
  <script src="webapp/vendor/angular/moment.min.js"></script>

</head>

<body>

	<div class="main">
	    <div class="container">
	        <div data-ng-view></div>        
	    </div>
	</div>
	
	<!-- Modules -->
    <script src="webapp/js/app.js"></script>

	<!-- Controllers -->

	<!-- Services -->


</body>
</html>