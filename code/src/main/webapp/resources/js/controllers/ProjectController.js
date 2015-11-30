glimpse.controller('ProjectController', function($scope,$location, $rootScope, DataService, $window) {

	/**ng init for fetching all projects of an user**/
	$scope.getProjectDetails = function() {

		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};

		// get users project details
		DataService.getData("/glimpse/api/"+$scope.currentUser.user_id+"/projects",[])
		.success(function(data) {
			console.log(data);
			$scope.userProjects = data;

		}).error(function(err){
			console.log(err);
		});	

	};

});
