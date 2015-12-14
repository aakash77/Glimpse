glimpse.service('UserProgressService', function($http) {
	
	this.transform_data = function(finishedTasks,callback){
		
		var hist = {};
		finishedTasks.map( function (a) { 
		  var id = a.assignee.id;
		  if (id in hist){
		      hist[id].value++; 
		  } 
		  else {
		   hist[id] ={value:1,key:a.assignee.name}; 
		  }
		});
		var resultdata = [];
		for(var key in hist){
			resultdata.push(hist[key]);
		}
		console.log(resultdata);
		callback(resultdata)
	};
});