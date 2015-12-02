glimpse.controller('TaskController', function($scope,$uibModalInstance,task,team, DataService, $window) {
	var tc = this;
	tc.initAddMember = function(){
		tc.selectedMember = "";
		tc.projectUsers = team;
	};


	tc.okay = function(){
		
//		var queryParams = "?sendTo="+emailList+"&currentUser="+user.email+"&projectId="+project.project_id;
//		DataService.postData(urlConstants.SEND_EMAILS_INVITATIONS+queryParams,{})
//		.success(function(data) {
//			console.log("before modal close");
//			console.log(data);
			$uibModalInstance.close('done');
//		}).error(function(err){
//			$scope.formError = "Error while sending invitation.";
//		});	
	};

	tc.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	};

});
