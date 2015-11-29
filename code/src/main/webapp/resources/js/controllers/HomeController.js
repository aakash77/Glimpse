glimpse.controller('HomeController', function($scope,$location, $rootScope, Auth, $window) {
	
	$scope.getUserDetails = function() {
		
		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};

		// TODO : get users project details

		$scope.templateView = "glimpse/partials/projectboard";

	};





	$scope.logout = function() {
		$scope.currentUser = null;
		Auth.logout();
	};

});
