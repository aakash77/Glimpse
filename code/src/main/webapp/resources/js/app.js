var glimpse = angular.module("Glimpse", [ 'ui.bootstrap', 'ngMessages','ngRoute', 'ngTable', 'ngAnimate', 'mgcrea.ngStrap','directive.g+signin'])
.config(function($routeProvider, $locationProvider) {

	/**to remove hash in the URL**/
	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});

	$routeProvider
	.when('/', {
		templateUrl: 'glimpse/login',
		controller: 'LoginController'
	})
	.when('/home', {
		templateUrl: 'glimpse/home',
		controller: 'HomeController'
	})
	.when('/home/:id', {
		templateUrl: 'glimpse/home',
		controller: 'HomeController'
	})
	.otherwise({
		redirectTo : '/'
	});
})	 
