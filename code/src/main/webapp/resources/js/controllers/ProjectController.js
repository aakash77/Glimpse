glimpse.controller('ProjectController', function($scope, $location, DataService, NgTableParams, $window,$uibModal) {

	var pc = this;

	/**ng init for fetching all projects of an user**/
	pc.getProjectDetails = function() {
		$scope.currentUser = {
				name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId
		};
		pc.getUserProjects();
	};

	/**
	 * Get users project details
	 */
	pc.getUserProjects = function(){

		DataService.getData("/glimpse/api/"+$scope.currentUser.user_id+"/projects",[])
		.success(function(data) {
			pc.ownedProjects = [];
			pc.memberProjects = [];
			data.map(function(project){

				project.color = COLOR[project.state.value];
				if(project.owner.id==$scope.currentUser.user_id)
					pc.ownedProjects.push(project);
				else
					pc.memberProjects.push(project);
			});
		}).error(function(err){
			console.log(err);
		});
	};

	/**
	 * Get Percent value for progress bar
	 */
	pc.getPercent = function(project){
		return PERCENT[project.state.value];
	};

	pc.checkOwner = function(project){
		return project.owner.id == $scope.currentUser.user_id;
	};

	pc.openProjectHome = function(project){
		$location.path("/home/"+project.project_id);
	};

	/**
	 * Add Member Handler
	 */
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

		modalInstance.result.then(function() {
			//modal success
		}, function() {
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

	/**
	 * Remove Project Handler
	 */
	pc.removeProject=function(project){
		var modalInstance = $uibModal.open({
			templateUrl : 'glimpse/partials/deleteProject',
			controller : 'DeleteProjectCtrl',
			controllerAs : 'dpc',
			size : 'sm',
			resolve : {
				project : function() {
					return project;
				}
			}
		});
		modalInstance.result.then(function() {
			//update user projects on dashboard
			pc.getUserProjects();
			//modal closed success
		}, function() {
			//modal exited
		});
	};
});