<div class="login" ng-controller="HomeController"
	ng-init="getUserDetails()">
	<div class="row navbar-inner">
		<div class="col-lg-8 col-md-8 col-xs-8">
			<h2 class="add-on" style="padding-left: 100px">
				<strong>Glimpse</strong>
			</h2>
			<p style="padding-left: 100px">
				<small>A Project Manager</small>
			</p>
		</div>
		<div class="col-lg-4 col-md-4 col-xs-4" 
			style="padding-top: 1.5%; left: 10%;">
			<div class="col-xs-4">
				<h4 class="add-on">
					<span class="add-on glyphicon glyphicon-user"></span>Welcome
					{{currentUser.name}}
				</h4>
			</div>

			<div class="col-xs-6">
				<a href="javascript:void(0)" ng-click="logout()"><h4
						class="add-on">Logout</h4></a>
			</div>
		</div>
	</div>

	<div ng-include="templateView"><</div>

</div>



