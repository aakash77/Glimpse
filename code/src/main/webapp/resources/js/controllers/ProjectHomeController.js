glimpse.controller('ProjectHomeController', function($scope, DataService, NgTableParams, $window,$uibModal) {

	var phc = this;
	var tmpList = [];
	
	// set fallback arrays
	var beforeUpdatenewTasks = [];
	var beforeUpdateassignedTasks = [];
	var beforeUpdatestartedTasks = [];
	var beforeUpdatefinishedTasks = [];
	var beforeUpdatecanceledTasks = [];
	$scope.revert = false;
	
	$scope.newTasks = [];
	$scope.assignedTasks = [];
	$scope.startedTasks = [];
	$scope.finishedTasks = [];
	$scope.canceledTasks = [];
	
	
	/**ng init for fetching all projects of an user**/
	phc.getProjectDetails = function() {
		$scope.currentUser = {
				name : $window.localStorage.currentUserName,
				email : $window.localStorage.currentUserEmail,
				user_id : $window.localStorage.currentUserId
				};
		
		phc.project_id = $window.localStorage.project_id;
		
		delete $window.localStorage.project_id;
		
		// get users project details
		DataService.getData("/glimpse/project/"+phc.project_id,[])
		.success(function(data) {
			$scope.projectDetails = data;
			// get project tasks
			
			$scope.ownerId =  data.owner.id
			DataService.getData("/glimpse/project/"+phc.project_id+"/tasks")
			.success(function(data) {
				console.log("tasks",data);
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
					else if(data[i].state.value=="cancelled")
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
	
	function handleTransfer(startList, endList, taskId, taskCard){
		console.log(startList, endList, taskId, taskCard);
		// Cancel and Finished are terminal states
			if(startList == "canceledTasks" || startList == "finishedTasks"){
				$scope.revert = true;
				return;
			}
		// reorder the list
			if(startList == endList){
				return;
			}
		if($scope.ownerId == $scope.currentUser.user_id){
			// owner related transitions
			$scope.revert = false;
			if(endList == "canceledTasks"){
				//fire task update query
				return;
			}else if(startList == "newTasks" && endList == "assignedTasks"){
				// open modal
				var modalInstance = $uibModal.open({
					templateUrl : '/glimpse/partials/assignAssignee',
					controller : 'TaskController',
					controllerAs : 'tc',
					resolve : {
						task : function() {
							return taskId;
						},
						team : function(){
							return $scope.projectDetails.team;
						}
					}
				});
				modalInstance.result.then(function(data) {
					//modal closed success
					console.log(data);
					if(data == "done"){
						//call refresh function
						$scope.revert = false;
						return;
					}else{
						$scope.revert = true;
						revert();
					}
				}, function(err) {
					$scope.revert = true;
					revert();
				});
				
				return;
			}else if(startList == "startedTasks" && endList == "finishedTasks"){
				var assigneeId = taskCard.children[1].innerHTML;
				
				if(assigneeId == $scope.currentUser.user_id){
					completeStartedTask();
					$scope.revert = false;
				}
				return;
			}else{
				$scope.revert = true;
			}
		}else{
			// project member related transitions
			console.log("else");
			var assigneeId = taskCard.children[1].innerHTML;
			if(assigneeId == $scope.currentUser.user_id){
				if(startList == "assignedTasks" && endList == "startedTasks"){
					$scope.revert = false;
					return;
				}else if(startList == "startedTasks" && endList == "finishedTasks"){
					
					completeStartedTask();
					$scope.revert = false;
					return;
				}
			}
			//if above conditions are not meet, revert!
			$scope.revert = true;
			return;
		}
	}
	
	function completeStartedTask(){
		
		var modalInstance = $uibModal.open({
			templateUrl : '/glimpse/partials/actualDays',
			controller : 'ActualDaysController',
			controllerAs : 'ad',
			resolve : {
				task : function() {
					return "";
				}
			}
		});
		modalInstance.result.then(function(data) {
			//modal closed success
			console.log(data);
			if(data == "done"){
				//call refresh function
				$scope.revert = false;
				return;
			}else{
				$scope.revert = true;
				revert();
			}
		}, function(err) {
			$scope.revert = true;
			revert();
		});
	}
	
	function revert(){
		if($scope.revert){
			$scope.newTasks = beforeUpdatenewTasks;
			$scope.assignedTasks = beforeUpdateassignedTasks;
			$scope.startedTasks = beforeUpdatestartedTasks;
			$scope.finishedTasks = beforeUpdatefinishedTasks;
			$scope.canceledTasks = beforeUpdatecanceledTasks;
			$scope.revert = false;
		}
	}
	
    // Draggable Task board
	$scope.sortableOptions = {
		    placeholder: "app",
		    start: function(){
		    	beforeUpdatenewTasks = $scope.newTasks.slice();
		    	beforeUpdateassignedTasks = $scope.assignedTasks.slice();
		    	beforeUpdatestartedTasks = $scope.startedTasks.slice();
		    	beforeUpdatefinishedTasks = $scope.finishedTasks.slice();
		    	beforeUpdatecanceledTasks = $scope.canceledTasks.slice();
		    },
		    beforeStop: function(event,ui){
		    	var startList = event.target.parentElement.classList[1];
		    	var endList = event.toElement.offsetParent.classList[1];
		    	var taskId = ui.item[0].children[0].innerHTML;
		    	handleTransfer(startList, endList, taskId, ui.item[0]);
		    },
		    connectWith: ".tasklane",
		    stop: function (){
		    	revert();
		    }
		  };
});
