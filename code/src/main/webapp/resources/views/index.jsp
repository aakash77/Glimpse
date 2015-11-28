<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html data-ng-app="Glimpse">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Glimpse</title>


<!-- Angular -->
<script
	src="${pageContext.request.contextPath}/resources/vendor/angular/angular.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/angular/angular-messages.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/angular/angular-route.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/angular/angular-animate.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/angular/angular-strap.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/angular/angular-strap.tpl.js"></script>

<!-- Include the jQuery library -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!--Bootstrap CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-theme.css">

<!--Bootstrap-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/ui-bootstrap-0.12.0.js"></script>

<!-- Google Auth -->
<script
	src="${pageContext.request.contextPath}/resources/js/directives/google-plus-signin.js"></script>

<!--Application CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>

	<div class="main">
		<div data-ng-view></div>
	</div>

	<!-- Modules -->
	<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>

	<!-- Controllers -->
	<script
		src="${pageContext.request.contextPath}/resources/js/controllers/LoginController.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/controllers/SignUpController.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/controllers/HomeController.js"></script>

	<!-- Directives -->
	<script
		src="${pageContext.request.contextPath}/resources/js/directives/uniqueEmail.js"></script>

	<!-- Services -->
	<script
		src="${pageContext.request.contextPath}/resources/js/services/auth.js"></script>

	<!-- Utility -->
	<script
		src="${pageContext.request.contextPath}/resources/js/utility/constants.js"></script>

</body>
</html>