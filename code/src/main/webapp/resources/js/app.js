var glimpse = angular.module("Glimpse", [ 'ui.sortable','ui.bootstrap', 'ngMessages','ngRoute', 'ngTable', 'ngAnimate'])

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
}).run(['$rootScope','$window','$location','$templateCache',function($rootScope,$window, $location,$templateCache) {
	
	$rootScope.$on('$routeChangeStart', function(event,next, current) {
		
		if (typeof(current) !== 'undefined'){
            $templateCache.remove(current.templateUrl);
        }
		
		if($window.localStorage.currentUserId)
			$location.path('/home');
		else
			$location.path('/');
	});
}]);
