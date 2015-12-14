glimpse.service('ProjectProgressService', function($http) {
	
	this.transform_data = function(finishedTasks,remainingTasks,callback){
		
			var resultData = [];
			/*var remainingTasksLength = allTasks.length - finishedTasks.length;*/
			console.log(finishedTasks);
			console.log(remainingTasks);
			resultData.push({key:"Finished Tasks",value:finishedTasks});
			resultData.push({key:"Remaining Tasks",value:remainingTasks});
			callback(resultData);
	};
});