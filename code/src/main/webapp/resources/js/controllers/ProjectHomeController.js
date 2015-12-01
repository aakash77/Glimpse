glimpse.controller('ProjectHomeController', function($scope, $routeParams, DataService, NgTableParams, $window,$uibModal) {

	var phc = this;
	console.log($routeParams.id);
	/**ng init for fetching all projects of an user**/
	phc.getProjectDetails = function() {
		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};
		console.log($routeParams.id);
		// get users project details
		DataService.getData("/glimpse/project/"+$routeParams.id,[])
		.success(function(data) {
			$scope.projectDetails = data;
			console.log(data);
		}).error(function(err){
			console.log(err);
		});	
	};
});
