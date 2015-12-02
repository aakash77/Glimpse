glimpse.factory('Auth', function($http, $location, $rootScope, $window) {
	// Asynchronously load Google+ SDK
	(function() {
		var po = document.createElement('script');
		po.type = 'text/javascript';
		po.async = true;
		po.src = 'https://apis.google.com/js/client:plusone.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(po, s);
	})();

	return {
		googleLogin : function() {
			gapi.auth.authorize({
				client_id: '22120033347-040ennvk81plparsps706okbkh1rp210.apps.googleusercontent.com',
				scope: 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read',
				immediate: false
			}, function() {
				gapi.client.load('plus', 'v1', function() {
					var request = gapi.client.plus.people.get({
						userId: 'me'
					});
					request.execute(function(authData) {
						var profile = {email : authData.emails[0].value,
								name : authData.displayName};
						console.log(profile);
						$http({
							method : 'POST',
							url : urlConstants.GOOGLE_AUTH,
							data : profile
						}).success(function(data) {
							$window.localStorage.currentUserEmail = data.email;
							$window.localStorage.currentUserId = data.id;
							$window.localStorage.currentUserName = data.name;
							$location.path('/home');	
						});
					});
				});
			});
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
			})
			.error(function() {
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
			})
			.error(function(response) {
			});
		},
		logout: function() {
			delete $window.localStorage.currentUserEmail;
			delete $window.localStorage.currentUserId;
			delete $window.localStorage.currentUserName;

			$location.path('/');
		}
	};
});