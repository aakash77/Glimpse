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
			<div class="col-md-2 tasklane">
				<h4>New Tasks</h4>
				<div class="portlet">
					<div class="portlet-header">Feeds</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
				<div class="portlet">
					<div class="portlet-header">News</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
			</div>

			<div class="col-md-2 tasklane">
				<h4>Assigned Tasks</h4>
				<div class="portlet">
					<div class="portlet-header">Shopping</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
			</div>

			<div class="col-md-2 tasklane">
				<h4>Started Tasks</h4>
				<div class="portlet">
					<div class="portlet-header">Links</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
				<div class="portlet">
					<div class="portlet-header">Images</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
			</div>
			
			<div class="col-md-2 tasklane">
				<h4>Finished Tasks</h4>
				<div class="portlet">
					<div class="portlet-header">Links</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
				<div class="portlet">
					<div class="portlet-header">Images</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
			</div>
			
			<div class="col-md-2 tasklane">
				<h4>Canceled Tasks</h4>
				<div class="portlet">
					<div class="portlet-header">Links</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
				<div class="portlet">
					<div class="portlet-header">Images</div>
					<div class="portlet-content">Lorem ipsum dolor sit amet,
						consectetuer adipiscing elit</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</div>