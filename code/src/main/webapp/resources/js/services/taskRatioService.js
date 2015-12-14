glimpse.service('TaskRatioService', function($http) {
	
	this.transform_data = function(cancelled,uncancelled,callback){
		
			var resultData = [];
			resultData.push({key:"Cancelled Tasks",value:cancelled});
			resultData.push({key:"Non-Cancelled Tasks",value:uncancelled});
			callback(resultData);
	};
});