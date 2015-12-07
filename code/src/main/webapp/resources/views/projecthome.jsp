<div id="middle" ng-controller="ProjectHomeController as phc"
	ng-init="phc.getProjectDetails()">
	<div class="container whitebackground">
		<div class="row" style="margin-top: 1%;">
			<div class="col-md-3">
				<button class="btn btn-default" ng-click="phc.backToProjects()">
					<span class="glyphicon glyphicon-menu-left"></span> Projects
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="page-header">
					<div class="row" style="margin-top:-7%;">
						<div class="col-md-1">
							<h1>
								<span ng-click="phc.updateProjectStatus()"
									class="glyphicon glyphicon-off glyphicon-info pointer"
									style="color: {{phc.statusColor}}"
									ng-attr-title="{{projectDetails.state.value}}">
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
			<div class="col-md-6">
				<!--  project progress -->
			</div>
		</div>


		<div class="row taskboard">
			<div class="col-md-1" style="margin-top: 20px;">
				<button class="btn btn-primary" ng-click="phc.addTaskBtn()">
					<span class='glyphicon glyphicon-plus'></span> Task
				</button>
			</div>
			<div class="col-md-2 newTasks">
				<h4>New Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft"
					ng-model="newTasks">
					<div class="app" ng-repeat="app in newTasks">
						<span class="id hidden">{{app.task_id}}</span>
						<div class="panel panel-warning" id="task_panel_{{app.task_id}}">
							<button ng-show="phc.inPlanning" type="button" class="close"
								data-target="#task_panel_{{app.task_id}}" data-dismiss="alert"
								ng-click="phc.deleteTask($index,app.task_id)">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<div class="panel-heading">
								<h3 class="panel-title">{{app.title}}</h3>
							</div>
							<div class="panel-body">
								{{app.description}} <br /> <br /> <small> <span
									ng-show="app.assignee != null">Assignee:
										{{app.assignee.name}} <span
										ng-click="phc.editAssignee(newTasks,$index,app.task_id,1)"
										class="glyphicon glyphicon-pencil pointer" aria-hidden="true"></span>
								</span> <br /> <span>Estimate TOC: {{app.estimate}}</span>
								</small>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-2 assignedTasks">
				<h4>Assigned Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft"
					ng-model="assignedTasks">
					<div class="app" ng-repeat="app in assignedTasks">
						<span class="id hidden">{{app.task_id}}</span><span
							class="assignee hidden">{{app.assignee.id}}</span>
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">{{app.title}}</h3>
							</div>
							<div class="panel-body">
								{{app.description}} <br /> <br /> <small> <span
									ng-show="app.assignee != null">Assignee:
										{{app.assignee.name}} <span
										ng-click="phc.editAssignee(assignedTasks,$index,app.task_id,2)"
										class="glyphicon glyphicon-pencil pointer" aria-hidden="true"></span>
								</span> <br /> <span>Estimate TOC: {{app.estimate}}</span>
								</small>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-2 startedTasks">
				<h4>Started Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft"
					ng-model="startedTasks">
					<div class="app" ng-repeat="app in startedTasks">
						<span class="id hidden">{{app.task_id}}</span><span
							class="assignee hidden">{{app.assignee.id}}</span>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">{{app.title}}</h3>
							</div>
							<div class="panel-body">
								{{app.description}} <br /> <br /> <small> <span
									ng-show="app.assignee != null">Assignee:
										{{app.assignee.name}} <span
										ng-click="phc.editAssignee(startedTasks,$index,app.task_id,3)"
										class="glyphicon glyphicon-pencil pointer" aria-hidden="true"></span>
								</span> <br /> <span>Estimate TOC: {{app.estimate}}</span>
								</small>
							</div>
						</div>
					</div>
					<div style="height: 100px;"></div>
				</div>
			</div>

			<div class="col-md-2 finishedTasks">
				<h4>Finished Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft"
					ng-model="finishedTasks">
					<div class="app" ng-repeat="app in finishedTasks">
						<span class="id hidden">{{app.task_id}}</span><span
							class="assignee hidden">{{app.assignee.id}}</span>
						<div class="panel panel-success">
							<div class="panel-heading">
								<h3 class="panel-title">{{app.title}}</h3>
							</div>
							<div class="panel-body">
								{{app.description}} <br /> <br /> <small>Assignee:
									{{app.assignee.name}} <br /> Estimate TOC: {{app.estimate}} <br />
									Actual TOC: {{app.actual}}
								</small>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-2 canceledTasks">
				<h4>Canceled Tasks</h4>
				<div ui-sortable="sortableOptions" class="tasklane screen floatleft"
					ng-model="canceledTasks">
					<div class="app" ng-repeat="app in canceledTasks">
						<span class="id hidden">{{app.task_id}}</span>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">{{app.title}}</h3>
							</div>
							<div class="panel-body">
								{{app.description}} <br /> <br /> <small>Assignee:
									{{app.assignee.name}} <br /> Estimate TOC: {{app.estimate}}
								</small>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>

	</div>
</div>