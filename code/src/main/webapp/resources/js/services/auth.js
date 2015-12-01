glimpse.factory('Auth', function($http, $location, $rootScope, $alert, $window) {
	return {
		googleLogin : function(dataURI, profile) {
			return $http({
				method : 'POST',
				url : dataURI,
				data : profile
			})
			.success(function(data) {
				$window.localStorage.currentUserEmail = data.email;
				$window.localStorage.currentUserId = data.id;
				$window.localStorage.currentUserName = data.name;
				$location.path('/home');
				$alert({
					title: 'Cheers!',
					content: 'You have successfully signed-in with Google.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 3
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
				$window.localStorage.currentUserEmail = data.email;
				$window.localStorage.currentUserId = data.id;
				$window.localStorage.currentUserName = data.name;
				$location.path('/home');
				$alert({
					title: 'Cheers!',
					content: 'You have successfully logged in.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 3
				});
			})
			.error(function() {
				$alert({
					title: 'Error!',
					content: 'Invalid username or password.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 3
				});
			});
		},

		signup : function(dataURI, params) {
			return $http({
				method : 'POST',
				url : dataURI,
				data : params
			})
			.success(function(data) {
				$window.localStorage.currentUserEmail = data.email;
				$window.localStorage.currentUserId = data.id;
				$window.localStorage.currentUserName = data.name;
				$location.path('/home');
				$alert({
					title: 'Congratulations!',
					content: 'Your account has been created and successfully logged in.',
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 3
				});
			})
			.error(function(response) {
				$alert({
					title: 'Error!',
					content: response.data,
					animation: 'fadeZoomFadeDown',
					type: 'material',
					duration: 3
				});
			});
		},
		logout: function() {
			delete $window.localStorage.currentUserEmail;
			delete $window.localStorage.currentUserId;
			delete $window.localStorage.currentUserName;
			
			$location.path('/');
			$alert({
				content: 'You have been logged out.',
				animation: 'fadeZoomFadeDown',
				type: 'material',
				duration: 3
			});
		}
	};
});