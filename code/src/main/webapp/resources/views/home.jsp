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

		<ul class="nav navbar-nav navbar-right" style="padding-top: 1.5%;">
			<li><a href="#">{{currentUser.name}}</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false"> <span
					class="caret"></span> <span class="glyphicon glyphicon-user"
					aria-hidden="true"></span>
			</a>

				<ul class="dropdown-menu" role="menu">
					<li class="cursor"><a href="#" ng-click="userProfile()">Profile</a></li>

					<li class="divider"></li>
					<li class="cursor"><a href="javascript:void(0)"
						ng-click="logout()">Logout</a></li>
				</ul></li>
		</ul>


	</div>

	<div ng-include="templateView"><</div>

</div>
