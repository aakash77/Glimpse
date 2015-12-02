<div id="middle" ng-controller="ProjectHomeController as phc"
	ng-init="phc.getProjectDetails()">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="page-header">
					<div class="row">
						<div class="col-md-1">
							<h1>
								<span class="glyphicon glyphicon-off" style="color: green;">
							</h1>
						</div>
						<div class="col-md-11">
							<h1>
								<span>{{projectDetails.title}}</span><br /> <small>{{projectDetails.description}}</small>
							</h1>
							<div class="team_members">
								Team Members: <br /> <span
									ng-repeat="tm in projectDetails.team">{{tm.name}}, </span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-2 newTasks">
				<h4>New Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft" ng-model="newTasks">
			      <div class="app" ng-repeat="app in newTasks"><span class="id">{{app.task_id}}</span>{{app.title}}</div>
			    </div>
			</div>

			<div class="col-md-2 assignedTasks">
				<h4>Assigned Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft" ng-model="assignedTasks">
			      <div class="app" ng-repeat="app in assignedTasks"><span class="id">{{app.id}}</span><span class="asignee_id">{{app.assignee.id}}</span> {{app.title}}</div>
			    </div>
			</div>

			<div class="col-md-2 startedTasks">
				<h4>Started Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft" ng-model="startedTasks">
			      <div class="app" ng-repeat="app in startedTasks"><span class="id">{{app.id}}</span><span class="asignee_id">{{app.assignee.id}}</span> {{app.title}}</div>
			    </div>
			</div>
			
			<div class="col-md-2 finishedTasks">
				<h4>Finished Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft" ng-model="finishedTasks">
			      <div class="app" ng-repeat="app in finishedTasks"><span class="id">{{app.id}}</span>{{app.title}}</div>
			    </div>
			</div>
			
			<div class="col-md-2 canceledTasks">
				<h4>Canceled Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft" ng-model="canceledTasks">
			      <div class="app" ng-repeat="app in canceledTasks"><span class="id">{{app.id}}</span> {{app.title}}</div>
			    </div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</div>