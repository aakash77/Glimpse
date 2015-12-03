<div class="login" ng-controller="HomeController"
	ng-init="getUserDetails()">
	<div class="row navbar-inner"
		style="margin-bottom: -5px; margin-top: -16px;">
		<div class="col-lg-8 col-md-8 col-xs-8">
			<h3 class="add-on" style="padding-left: 100px">
				<strong>Glimpse</strong>
			</h3>
			<p style="padding-left: 100px">
				<small>A Project Manager</small>
			</p>
		</div>

		<ul class="nav navbar-nav navbar-right"
			style="padding-top: 1.5%; margin-right: 0px;">
			<li><p style="padding-top: 15px;">{{currentUser.name}}
				<p></li>
			<li class="dropdown "><a href="#" class="dropdown-toggle"
				style="color: white;" data-toggle="dropdown" role="button"
				aria-expanded="false"> <span class="caret"></span> <span
					class="glyphicon glyphicon-user" aria-hidden="true"></span>
			</a>

				<ul class="dropdown-menu" role="menu">
					<li class="cursor"><a href="javascript:void(0)"
						ng-click="logout()">Logout</a></li>
				</ul></li>
		</ul>


	</div>

	<div ng-include="templateView.template"><</div>

</div>
