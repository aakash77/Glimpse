<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html data-ng-app="Glimpse">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Glimpse</title>

  <!--Application CSS-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

 <!-- Angular -->  
  <script src="${pageContext.request.contextPath}/resources/vendor/angular/angular.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/angular/angular-messages.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/angular/angular-route.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/angular/angular-animate.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/angular/angular-strap.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/angular/angular-strap.tpl.js"></script>
    
  <!-- Include the jQuery library --> 
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 

  <!--Bootstrap CSS-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-theme.css">

  <!--Bootstrap-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap/ui-bootstrap-0.12.0.js"></script>	

</head>

<body>

	<div class="main">
	    <div class="container">
	        <div data-ng-view></div>        
	    </div>
	</div>
	
	<!-- Modules -->
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>

	<!-- Controllers -->
    <script src="${pageContext.request.contextPath}/resources/js/controllers/login.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/controllers/signup.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/controllers/home.js"></script>

	<!-- Services -->
	<script src="${pageContext.request.contextPath}/resources/js/services/auth.js"></script>
	
	<!-- Utility -->
	<script src="${pageContext.request.contextPath}/resources/js/utility/constants.js"></script>

</body>
</html>