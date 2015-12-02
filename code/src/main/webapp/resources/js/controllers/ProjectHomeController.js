glimpse.controller('ProjectHomeController', function($scope, $routeParams, DataService, NgTableParams, $window,$uibModal) {

	var phc = this;
	var tmpList = [];
	$scope.newTasks = [{
		id:"1",
		title:"New Task"
	}];
	$scope.assignedTasks = [{
		id:"2",
		title:"Assigned Task"
	}];
	$scope.startedTasks = [{
		id:"3",
		title:"startedTasks Task"
	}];
	$scope.finishedTasks = [{
		id:"4",
		title:"finishedTasks Task"
	}];
	$scope.canceledTasks = [{
		id:"5",
		title:"canceledTasks Task"
	}];
	console.log($routeParams.id);
	/**ng init for fetching all projects of an user**/
	phc.getProjectDetails = function() {
		$scope.currentUser = {name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId};
		console.log($routeParams.id);
		// get users project details
		DataService.getData("/glimpse/project/"+$routeParams.id,[])
		.success(function(data) {
			$scope.projectDetails = data;
			// get project tasks
			DataService.getData("/glimpse/project/"+$routeParams.id+"/tasks")
			.success(function(data) {
				console.log(data);
				//assign tasks by task state
				
				for(var i=0;i<data.length;i++){
					if(data[i].state.value=="new")
						$scope.newTasks.push(data[i]);
					else if(data[i].state.value=="assigned")
						$scope.assignedTasks.push(data[i]);
					else if(data[i].state.value=="started")
						$scope.startedTasks.push(data[i]);
					else if(data[i].state.value=="finished")
						$scope.finishedTasks.push(data[i]);
					else if(data[i].state.value=="canceled")
						$scope.canceledTasks.push(data[i]);
				}				
			})
			.error(function(err){
				console.log("Error while getting all tasks of the project");
			});	
		}).error(function(err){
			console.log("Error getting the project details");
		});	
	};

    // Draggable Task board
	$scope.sortableOptions = {
		    placeholder: "app",
		    beforeStop: function(event,ui){
		    	log(event.toElement.offsetParent.classList[1]);
		    	log(event.target.parentElement.classList[1]);
			      log(ui.item[0]);
		    },
		    connectWith: ".tasklane",
		  };
		function log(data){
			console.log(data);
		}

});
