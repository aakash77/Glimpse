glimpse.controller('ProjectHomeController', function($scope, $routeParams, DataService, NgTableParams, $window,$uibModal) {

	var phc = this;
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
				phc.newTasks = [];
				phc.assignedTasks = [];
				phc.startedTasks = [];
				phc.finishedTasks = [];
				phc.canceledTasks = [];
				for(var i=0;i<data.length;i++){
					if(data[i].state.value=="new")
						phc.newTasks.push(data[i]);
					else if(data[i].state.value=="assigned")
						phc.assignedTasks.push(data[i]);
					else if(data[i].state.value=="started")
						phc.startedTasks.push(data[i]);
					else if(data[i].state.value=="finished")
						phc.finishedTasks.push(data[i]);
					else if(data[i].state.value=="canceled")
						phc.canceledTasks.push(data[i]);
				}				
			})
			.error(function(err){
				console.log("Error while getting all tasks of the project");
			});	
		}).error(function(err){
			console.log("Error getting the project details");
		});	
	};

	    // new imple
	    $( ".tasklane" ).sortable({
	        connectWith: ".tasklane",
	        handle: ".portlet-header",
	        cancel: ".portlet-toggle",
	        start: function (event, ui) {
	            ui.item.addClass('tilt');
	            tilt_direction(ui.item);
	        },
	        stop: function (event, ui) {
	            ui.item.removeClass("tilt");
	            $("html").unbind('mousemove', ui.item.data("move_handler"));
	            ui.item.removeData("move_handler");
	        }
	    });
	    
	    function tilt_direction(item) {
	        var left_pos = item.position().left,
	            move_handler = function (e) {
	                if (e.pageX >= left_pos) {
	                    item.addClass("right");
	                    item.removeClass("left");
	                } else {
	                    item.addClass("left");
	                    item.removeClass("right");
	                }
	                left_pos = e.pageX;
	            };
	        $("html").bind("mousemove", move_handler);
	        item.data("move_handler", move_handler);
	    }  

	    $( ".portlet" )
	        .addClass( "ui-widget ui-widget-content ui-helper-clearfix ui-corner-all" )
	        .find( ".portlet-header" )
	        .addClass( "ui-widget-header ui-corner-all" )
	        .prepend( "<span class='ui-icon ui-icon-minusthick portlet-toggle'></span>");

	    $( ".portlet-toggle" ).click(function() {
	        var icon = $( this );
	        icon.toggleClass( "ui-icon-minusthick ui-icon-plusthick" );
	        icon.closest( ".portlet" ).find( ".portlet-content" ).toggle();
	    });
	    //
});
