<div id="middle" ng-controller="ProjectController as pc" ng-init="pc.getProjectDetails()">

<div ng-if="userProjects.length==0">
	<span class='h1'>&nbsp;</span> <span class='h1'>&nbsp;</span>
	<h3 class="text-center">
		<strong>You do not have any projects yet. Click the button
			below to add a project.</strong>
	</h3>
	<span class='h1'>&nbsp;<br>&nbsp;<br>&nbsp;
	</span>
	<button class="btn btn-success btn-lg center-block">
		<span class='glyphicon glyphicon-plus'></span> Add a Project
	</button>
</div>

<div ng-if="userProjects.length!=0">
	<div class="row" style="padding-top: 2%;">
		<div class="col-xs-10 col-xs-offset-1">
			<div class="span8 panel panel-primary">
				<div class="panel-heading">
					Projects
					<button class="btn btn-success btn-sm pull-right">
						<span class='glyphicon glyphicon-plus'></span> Add a Project
					</button>
				</div>
				<div class="panel-body">
					<table ng-table="pc.tableParams" class="table table-bordered"
						show-filter="true">
						<tr ng-repeat="project in $data">
							<td title="'Title'" filter="{ title: 'text'}" sortable="'title'">
								{{project.title}}</td>
							<td title="'Owner'" filter="{ owner: 'text'}" sortable="'owner'">
								{{project.owner.name}}</td>
							<td title="'Project State'" filter="{ state: 'text'}" sortable="'state'">
								{{project.state.value}}</td>
							<td title="'Action'">
								<button ng-if="pc.checkOwner(project)"
									class="btn btn-sm btn-primary" ng-click="pc.addMember(project)">Add Members</button>
								<button class="btn btn-sm btn-warning" ng-click="pc.openProjectHome(project)">View</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>