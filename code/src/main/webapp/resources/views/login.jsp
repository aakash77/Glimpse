<div class="login" ng-controller="LoginController">
	<div class="row navbar-inner">
		<div class="col-lg-6 col-md-6 col-xs-12">
			<h2 class="add-on" style="padding-left: 100px">
				<strong>Glimpse</strong>
			</h2>
			<p style="padding-left: 100px">
				<small>A Project Manager</small>
			</p>
		</div>
		<div class="col-lg-6 col-md-6 col-xs-12"
			style="padding-top: 1.5%; left: 13%;">
			<form name="loginForm" class="form-horizontal" ng-submit="login()"
				novalidate>
				<div class="col-xs-4">
					<div class="row form-group"
						ng-class="{ 'has-error' : loginForm.email.$invalid && loginForm.email.$dirty }">
						<span class="add-on glyphicon glyphicon-user"></span> <input
							name="email" type="email" ng-model="email" placeholder="Email"
							required />
					</div>

					<div class="row">
						<div class="col-xs-12">
							<div class="help-block text-danger"
								ng-messages="loginForm.email.$error" role="alert"
								ng-if="loginForm.email.$dirty">
								<div ng-message="required">Email is required.</div>
								<div ng-message="email">Invalid email address.</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-4">
					<div class="row form-group"
						ng-class="{ 'has-error' : loginForm.password.$invalid && loginForm.password.$dirty }">
						<span class="add-on glyphicon glyphicon-lock"></span> <input
							name="password" ng-minlength="6" type="password"
							ng-model="password" placeholder="Password" required />
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="help-block text-danger"
								ng-messages="loginForm.password.$error" role="alert"
								ng-if="loginForm.password.$dirty">
								<div ng-message="required">Password is required.</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-1" style="padding-left: inherit;">
					<button type="submit" ng-disabled="loginForm.$invalid"
						class="btn btn-info btn-sm">Log In</button>
				</div>
			</form>

		</div>
	</div>
</div>

<div id="middle" ng-controller="SignUpController">
	<div class="row" style="padding-top: 3%;">
		<div class="col-lg-6 col-md-6 col-s-12"
			style="padding-top: 5%; margin-left: 2%;"></div>

		<div class="col-lg-4 col-md-4 col-s-12 background-seashell"
			style="margin-left: 12%;">
			<form method="post" name="signUpForm" ng-submit="signup()" novalidate>
				<h2>
					<strong>Sign Up</strong>
				</h2>
				<p style="padding-top: 20px;"></p>

				<div class="form-group has-feedback" style="padding-top: 10px;"
					ng-class="{ 'has-error' : signUpForm.displayName.$invalid && signUpForm.displayName.$dirty }">
					<input class="form-control input-lg" type="text"
						ng-model="displayName" name="displayName" placeholder="Full Name"
						required> <span class="ion-person form-control-feedback"></span>
					<div class="help-block text-danger"
						ng-messages="signUpForm.displayName.$error" role="alert"
						ng-if="signUpForm.displayName.$dirty">
						<div ng-message="required">Your must enter your name.</div>
					</div>
				</div>

				<div class="form-group has-feedback" style="padding-top: 10px;"
					ng-class="{ 'has-error' : signUpForm.email.$invalid && signUpForm.email.$dirty }">
					<input unique-email type="email" class="form-control input-lg"
						name="email" ng-model="email" placeholder="Email address" required>
					<span class="ion-at form-control-feedback"></span>
					<div class="help-block text-danger"
						ng-messages="signUpForm.email.$error" role="alert"
						ng-if="signUpForm.email.$dirty">
						<div ng-message="required">Your email address is required.</div>
						<div ng-message="email">Your email address is invalid.</div>
						<div ng-message="unique">
							<span class="ion-looping"></span> Email is already taken.
						</div>
					</div>

				</div>

				<div class="form-group has-feedback" style="padding-top: 10px;"
					ng-class="{ 'has-error' : signUpForm.password.$invalid && signUpForm.password.$dirty }">
					<input type="password" ng-minlength="6"
						class="form-control input-lg" name="password" ng-model="password"
						placeholder="Password (6 or more characters)" required> <span
						class="ion-key form-control-feedback"></span>
					<div class="help-block text-danger"
						ng-messages="signUpForm.password.$error" role="alert"
						ng-if="signUpForm.password.$dirty">
						<div ng-message="required">Password is required.</div>
						<div ng-message="minlength">Password is too short.</div>
					</div>
				</div>

				<div class="form-group" style="padding-top: 30px;">
					<div class="col-xs-6" style="padding-left: 0; padding-right: 1;">
						<button type="submit" ng-disabled="signUpForm.$invalid"
							class="btn btn-success btn-lg btn-block btn-primary">Sign
							Up</button>
					</div>
				</div>

			</form>
		</div>
	</div>

</div>
