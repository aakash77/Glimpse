glimpse.factory('Auth', function($http, $location, $alert, $window) {
	return {
		googleLogin : function(dataURI, profile) {
			return $http({
				method : 'POST',
				url : dataURI,
				data : profile
			})
			.success(function(data) {            
				$location.path('/home');
				$alert({
					title: 'Cheers!',
					content: 'You have successfully signed-in with Google.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 5
				});	
			})
		},

		login : function(dataURI, params) {
			return $http({
				method : 'POST',
				url : dataURI,
				data : params
			})
			.success(function(data) {            
				$location.path('/home');
				$alert({
					title: 'Cheers!',
					content: 'You have successfully logged in.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 5
				});
			})
			.error(function() {
				$alert({
					title: 'Error!',
					content: 'Invalid username or password.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 5
				});
			});
		},

		signup : function(dataURI, params) {
			return $http({
				method : 'POST',
				url : dataURI,
				data : params
			})
			.success(function() {
				$location.path('/');
				$alert({
					title: 'Congratulations!',
					content: 'Your account has been created. Log In to Continue.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 5
				});
			})
			.error(function(response) {
				$alert({
					title: 'Error!',
					content: response.data,
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 5
				});
			});
		}
	};
});