glimpse.controller('HomeController', function($scope,$location, $rootScope, Auth, DataService, $window) {

	/**ng init for rendering templateView**/
	$scope.getUserDetails = function() {

		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};

		$scope.templateView = "glimpse/partials/projectboard";

	};

	$scope.logout = function() {
		$scope.currentUser = null;
		Auth.logout();
	};

});
