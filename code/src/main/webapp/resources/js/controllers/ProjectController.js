glimpse.controller('ProjectController', function($scope, $location, DataService, NgTableParams, $window,$uibModal) {

	var pc = this;

	/**ng init for fetching all projects of an user**/
	pc.getProjectDetails = function() {
		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};

		// get users project details
		pc.getUserProjects();
	};

	pc.checkOwner = function(project){
		return project.owner.id == $scope.currentUser.user_id;
	};

	pc.openProjectHome = function(project){
		$location.path("/home/"+project.project_id);
	};

	pc.getUserProjects = function(){
		DataService.getData("/glimpse/api/"+$scope.currentUser.user_id+"/projects",[])
		.success(function(data) {
			$scope.userProjects = data;
			pc.tableParams = new NgTableParams({}, { dataset: data});
		}).error(function(err){
			console.log(err);
		});
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
		}, function(err) {
			//modal exited
		});

	};

	pc.addProject = function (){
		console.log("inside addproject");
		var modalInstance1 = $uibModal.open({
			templateUrl : 'glimpse/partials/addProject',
			controller : 'AddProjectCtrl',
			controllerAs : 'apc',
			resolve : {
				user : function(){
					return $scope.currentUser;
				}
			}
		});
		
		modalInstance1.result.then(function() {
			pc.getUserProjects();
		}, function() {
			//modal exited 
		}); 
	};

});
