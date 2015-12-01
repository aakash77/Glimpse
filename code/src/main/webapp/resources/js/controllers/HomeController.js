glimpse.controller('HomeController', function($scope,$location, $rootScope, $routeParams, Auth, DataService, $window) {

	/**ng init for rendering templateView**/
	$scope.getUserDetails = function() {

		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};
		
		if(!$routeParams.id){
			$scope.templateView = "/glimpse/partials/projectboard";
		}else{
			console.log("Redirect to project home");
			$scope.templateView = "/glimpse/partials/projecthome";
		}
		

	};

	$scope.logout = function() {
		$scope.currentUser = null;
		Auth.logout();
	};

});
