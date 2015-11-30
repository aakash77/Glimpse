glimpse.controller('HomeController', function($scope,$location, $rootScope, Auth, DataService, $window) {

	/**ng init for fetching all projects of an user**/
	$scope.getUserDetails = function() {

		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};

		// get users project details
		DataService.getData("/glimpse/api/"+$scope.currentUser.user_id+"/projects",[])
		.success(function(data) {
			$scope.userProjects = data;	
		}).error(function(err){
			console.log(err);
		});	

		$scope.templateView = "glimpse/partials/projectboard";

	};





	$scope.logout = function() {
		$scope.currentUser = null;
		Auth.logout();
	};

});
