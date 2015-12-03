glimpse.controller('AddTaskCtrl', function($scope,$uibModalInstance,user,project,DataService, $window) {

	var atc = this;

	atc.initTaskModal = function(){
		atc.user = user;
		console.log(project);
		atc.teamMembers = project.team;
	};

	atc.add = function(){
		var queryParams = "?project_id="+project.project_id+"&title="+atc.title+"&description="+atc.titleDescription+"&actual=0&estimate="+atc.estimate+"&task_state_id=1&id="+atc.assignee.id;
		DataService.postData(urlConstants.TASK+queryParams,[]).success(function(data){
			$uibModalInstance.close('closed');
		}).error(function(err){
			$uibModalInstance.dismiss();
		});
	};

	atc.cancel = function(){
		$uibModalInstance.dismiss();
	};

});