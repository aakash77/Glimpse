var glimpse = angular.module("Glimpse", [ 'ngRoute', 'ngMessages', 'ui.bootstrap' ])
	.config(function($routeProvider, $locationProvider) {
		 $locationProvider.html5Mode(true);
	
		 $routeProvider
	     .when('/', {
	       templateUrl: 'views/login.jsp',
	       controller: 'LoginController'
	     })
	     .when('/home', {
	       templateUrl: 'views/home.jsp',
	       controller: 'UserHomeController'
	      })
	     .otherwise({
		   redirectTo : '/'
		});
	})	 
	 