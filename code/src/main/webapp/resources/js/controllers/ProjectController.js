glimpse.controller('ProjectController', function($scope, DataService, NgTableParams, $window,$uibModal) {

	var pc = this;

	/**ng init for fetching all projects of an user**/
	pc.getProjectDetails = function() {
		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};

		// get users project details
		DataService.getData("/glimpse/api/"+$scope.currentUser.user_id+"/projects",[])
		.success(function(data) {
			$scope.userProjects = data;
			pc.tableParams = new NgTableParams({}, { dataset: data});
		}).error(function(err){
			console.log(err);
		});	
	};

	pc.checkOwner = function(user){
		return user.owner.id == $scope.currentUser.user_id;
	};

	pc.addMember = function(project){
		var modalInstance = $uibModal.open({
			templateUrl : 'glimpse/partials/addMember',
			controller : 'AddMemberCtrl',
			controllerAs : 'amc',
			resolve : {
				project : function() {
					return project;
				},
				user : function(){
					return $scope.currentUser;
				}
			}
		});

		modalInstance.result.then(function(data) {
			//modal closed success
		}, function(err) {
			//modal exited
		});
	}

});
