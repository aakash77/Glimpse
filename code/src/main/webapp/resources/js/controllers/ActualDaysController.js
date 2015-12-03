glimpse.controller('ActualDaysController', function($scope,$uibModalInstance,task,DataService, $window) {
	var ad = this;
	ad.initAddMember = function(){
		ad.actualDays = "";
	};


	ad.okay = function(){
		var queryParams = "/"+task.task_id+"?project_id="+task.project.project_id+"&title="+task.title+"&description="+task.description+"&estimate="+task.estimate+"&actual="+ad.actualDays+"&task_state_id=4";
		DataService.postData(urlConstants.TASK+queryParams,{})
		.success(function(data) {
			console.log("before modal close");
			console.log(data);
			$uibModalInstance.close('done');
		}).error(function(err){
			$scope.formError = "Error while adding actual days.";
		});	
	};

	ad.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	};

});
