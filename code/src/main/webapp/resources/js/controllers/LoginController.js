glimpse.controller('LoginController', function($scope,$location, $rootScope, Auth) {

	$scope.login = function() {
		var params = {
				email : $scope.email,
				password : $scope.password
		};
		Auth.login(urlConstants.LOGIN, params);
	};

	$scope.$on('event:google-plus-signin-success', function (event,authResult) {
		gapi.client.load('plus', 'v1', apiClientLoaded);
	});

	function apiClientLoaded() {
		gapi.client.plus.people.get({userId: 'me'}).execute(handleResponse);
	}

	function handleResponse(resp) {
		var profile = {email : resp.emails[0].value,
				name : resp.displayName};
		Auth.googleLogin(urlConstants.GOOGLE_AUTH,profile);
	}

	$scope.$on('event:google-plus-signin-failure', function (event,authResult) {
		// Auth failure or signout detected
		$location.path('/');	
	});

});
