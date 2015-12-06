glimpse.controller('TaskController', function($scope,$uibModalInstance,task,team, newState, DataService, $window) {
	var tc = this;
	tc.initAddMember = function(){
		tc.selectedMember = "";
		tc.projectUsers = team;
	};


	tc.okay = function(){
		console.log(tc.selectedMember,task);
		console.log("newState",newState);
		var queryParams = "/"+task.task_id+"?project_id="+task.project.project_id+"&title="+task.title+"&description="+task.description+"&estimate="+task.estimate+"&actual=0&task_state_id="+newState+"&id="+tc.selectedMember.id;
		console.log(queryParams);
		DataService.postData(urlConstants.TASK+queryParams,{})
		.success(function(data) {
			console.log("before modal close");
			console.log(task);
			$uibModalInstance.close('done');
		}).error(function(err){
			$scope.formError = "Error while assigning Task to Member";
		});	
	};

	tc.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	};

});
