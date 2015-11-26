var glimpse = angular.module("Glimpse", [ 'ngRoute', 'ngMessages', 'ngAnimate', 'ui.bootstrap', 'mgcrea.ngStrap' ])
	.config(function($routeProvider, $locationProvider) {
		 $locationProvider.html5Mode(true);
	
		 $routeProvider
	     .when('/', {
	       templateUrl: 'glimpse/login',
	       controller: 'LoginController'
	     })
	     .when('/home', {
	       templateUrl: 'glimpse/home',
	       controller: 'UserHomeController'
	      })
	     .otherwise({
		   redirectTo : '/'
		});
	})	 
	 