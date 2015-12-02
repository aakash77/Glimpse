glimpse.controller('DeleteProjectCtrl', function($scope,$uibModalInstance,project,DataService) {
	var dpc = this;

	dpc.okay = function(){
		var urlParams = "/"+project.project_id;
		DataService.deleteData(urlConstants.PROJECTS+urlParams,{}).success(function(data){
			console.log("delete project succesfull");
			console.log(data);
			$uibModalInstance.close();
		}).error(function(err){
			console.log("Error while deleting project");
		});
	};

	dpc.cancel = function(){
		$uibModalInstance.dismiss();
	};

});
