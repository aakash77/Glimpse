glimpse.controller('ActualDaysController', function($scope,$uibModalInstance,task,DataService, $window) {
	var ad = this;
	ad.initAddMember = function(){
		ad.actualDays = "";
	};


	ad.okay = function(){
		
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

	ad.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	};

});
