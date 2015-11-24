var glimpse = angular.module("Glimpse", [ 'ui.bootstrap', 'ngMessages', 'ngRoute', 'ngAnimate', 'mgcrea.ngStrap' ])
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
		controller: 'UserHomeController'
	})
	.otherwise({
		redirectTo : '/'
	});
})	 
