<div id="middle" ng-controller="ProjectHomeController as phc" ng-init="phc.getProjectDetails()">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="page-header">
				<div class="row">
					<div class="col-md-1"><h1><span class="glyphicon glyphicon-off" style="color:green;"></h1></div>
					<div class="col-md-11">
						<h1><span>{{projectDetails.title}}</span><br />
						  	<small>{{projectDetails.description}}</small>
						 </h1>
						 <div class="team_members">
							Team Members: <br /><span ng-repeat="tm in projectDetails.team">{{tm.name}}, </span>
						</div>
					</div>
				</div>
				</div>	
			</div>
			<div class="col-md-6">
			</div>
		</div>
		<div class="row">
		</div>
	</div>
</div>