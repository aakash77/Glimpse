glimpse.controller('AddMemberCtrl', function($scope,$uibModalInstance,project,user,DataService, $window) {
	var amc = this;
	amc.initAddMember = function(){
		amc.addedMembers=[];
		amc.selectedMember = "";
		amc.nonProjectUsers = [];
		DataService.getData(urlConstants.GET_ALL_USERS,{}).success(function(response){
			amc.allUsers = response;
			console.log(response);
			amc.projectUsers = project.team;
			var loopLength = amc.allUsers.length - amc.projectUsers.length;
			for(var i=0;i<loopLength;i++){
				var j=0;
				while(j<amc.projectUsers.length && amc.projectUsers[j].id != amc.allUsers[i].id)
					j++;
				if(j>=amc.projectUsers.length)
					amc.nonProjectUsers.push(amc.allUsers[i]);
			}
		}).error(function(err){
			console.log("Error while getting all users");
		});
	};

	amc.addMemberBtn = function(){
		if(!amc.selectedMember || amc.selectedMember=="")
			$scope.formError="Select a member before adding";
		else{
			$scope.formError="";
			amc.addedMembers.push(amc.selectedMember);
			var i = 0;
			while(amc.nonProjectUsers[i].id != amc.selectedMember.id)
				i++;
			amc.nonProjectUsers.splice(i,1);
			amc.selectedMember="";
			console.log(amc.addedMembers);
		}

	};

	amc.okay = function(){
		//Call Add member api
		var emailList = amc.addedMembers.map(function(member){
			return member.email;
		});
		
		var queryParams = "?sendTo="+emailList+"&currentUser="+user.email+"&projectId="+project.project_id;
		DataService.postData(urlConstants.SEND_EMAILS_INVITATIONS+queryParams,{})
		.success(function(data) {
			console.log("before modal close");
			console.log(data);
			$uibModalInstance.close();
		}).error(function(err){
			$scope.formError = "Error while sending invitation.";
		});	
	};

	amc.cancel = function(){
		$uibModalInstance.dismiss();
	};

});
