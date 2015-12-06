<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html data-ng-app="Glimpse">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Glimpse</title>

<!-- Include the jQuery library -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<!-- Angular -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-messages.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-route.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-animate.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/vendor/bower_components/angular-ui-sortable/sortable.min.js"></script>

<!-- Angular ngTable -->
<script
	src="${pageContext.request.contextPath}/resources/vendor/ngtable/ng-table.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/ngtable/ng-table.min.css">

<!--Bootstrap CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-theme.css">

<!--Bootstrap-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/ui-bootstrap-tpls-0.14.3.min.js"></script>

<!-- Ionicons -->
<link rel="stylesheet"
	href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!--Application CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">


<!-- Modules -->
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>


<!-- Controllers -->
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/LoginController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/SignUpController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/HomeController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/ProjectController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/AddMemberCtrl.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/TaskController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/ProjectHomeController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/ActualDaysController.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/AddProjectCtrl.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/DeleteProjectCtrl.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/SignUpNotificationCtrl.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/controllers/AddTaskCtrl.js"></script>


<!-- Directives -->
<script
	src="${pageContext.request.contextPath}/resources/js/directives/uniqueEmail.js"></script>

<!-- Services -->
<script
	src="${pageContext.request.contextPath}/resources/js/services/auth.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/services/dataService.js"></script>

<!-- Utility -->
<script
	src="${pageContext.request.contextPath}/resources/js/utility/constants.js"></script>

</head>

<body>

	<div class="main">
		<div data-ng-view></div>
	</div>

</body>
</html>