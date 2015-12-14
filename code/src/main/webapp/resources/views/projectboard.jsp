<div id="middle" ng-controller="ProjectController as pc"
	ng-init="pc.getProjectDetails()">
	<div class="container whitebackground">
		<div ng-if="pc.userProjects.length==0">
			<span class='h1'>&nbsp;</span> <span class='h1'>&nbsp;</span>
			<h3 class="text-center">
				<strong>You do not have any projects yet. Click the button
					below to add a project.</strong>
			</h3>
			<span class='h1'>&nbsp;<br>&nbsp;<br>&nbsp;
			</span>
			<button class="btn btn-success btn-lg center-block"
				ng-click="pc.addProject()">
				<span class='glyphicon glyphicon-plus'></span> Add a Project
			</button>
		</div>

		<div ng-if="pc.userProjects.length!=0" style="padding-top: 2%;">
			<!-- For Projects as an Owner  -->
			<div class="row">
				<div class="col-xs-10" style="margin-left: 10%;">
					<div class="row panel">
						<div class="panel-heading"
							style="background: darkcyan; color: white;">
							Owned Projects <span class='glyphicon glyphicon-plus pull-right'
								style="cursor: pointer;" title="Add new Project"
								ng-click="pc.addProject()"></span>
						</div>
					</div>
					<div class="row">
						<div ng-if="pc.ownedProjects.length==0" align="center"
							style="margin-bottom: 2%;">No Projects as Owner</div>
						<div ng-if="pc.ownedProjects.length!=0">
							<div class="panel col-xs-3"
								ng-repeat="ownerProjects in pc.ownedProjects"
								>
								<div class="panel-heading" align="center"
									style="background: mediumseagreen; color: aliceblue;">
									<strong ng-if="ownerProjects.state.value=='cancelled'"
										style="color: aliceblue;">{{ownerProjects.title}}</strong>
									<a style="color: aliceblue; cursor: pointer;"
										ng-click="pc.openProjectHome(ownerProjects)"
										ng-if="ownerProjects.state.value!='cancelled'"><strong>{{ownerProjects.title}}</strong></a>
									<div
										ng-if="ownerProjects.state.value=='planning'||ownerProjects.state.value=='ongoing'"
										class="text-danger pull-right">
										<span class="glyphicon glyphicon-remove"
											style="cursor: pointer;" title="Cancel Project"
											ng-click="pc.removeProject(ownerProjects)"></span>
									</div>
								</div>
								<div class="panel-body graybackground">
									{{ownerProjects.description}}
									<uib-progressbar class="progress-striped"
										ng-class="{'active': ownerProjects.state.value=='ongoing'}"
										value="pc.getPercent(ownerProjects)"
										type="{{ownerProjects.color}}">{{ownerProjects.state.value
									| uppercase}}</uib-progressbar>
								</div>
								<div class="panel-footer" align="center">
									<button
										ng-if="ownerProjects.state.value=='planning'||ownerProjects.state.value=='ongoing'"
										class="btn btn-sm btn-warning"
										ng-click="pc.addMember(ownerProjects)">Add Members</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- For Projects as a Member  -->

			<div class="row">
				<div class="col-xs-10" style="margin-left: 10%;">
					<div class="row panel">
						<div class="panel-heading"
							style="background: darkcyan; color: white;">Participated
							Projects</div>
					</div>
					<div class="row">
						<div ng-if="pc.memberProjects.length==0" align="center">No
							Projects as Participant</div>
						<div ng-if="pc.memberProjects.length!=0">
							<div class="panel col-xs-3"
								ng-repeat="memberProjects in pc.memberProjects"
								>
								<div class="panel-heading" align="center"
									style="background: mediumseagreen; color: aliceblue;">
									<div class="row">
										<a style="color: aliceblue; cursor: pointer;"
											ng-click="pc.openProjectHome(memberProjects)"><strong>{{memberProjects.title}}</strong></a>
									</div>
									<div class="row">Owner : {{memberProjects.owner.name}}</div>
								</div>
								<div class="panel-body graybackground">
									{{memberProjects.description}}
									<uib-progressbar class="progress-striped"
										ng-class="{'active': memberProjects.state.value=='ongoing'}"
										value="pc.getPercent(memberProjects)"
										type="{{memberProjects.color}}">{{memberProjects.state.value
									| uppercase}}</uib-progressbar>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>