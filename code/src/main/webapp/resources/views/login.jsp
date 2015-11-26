<div class="container login" ng-controller="LoginController">
	<div class="row navbar-inner">
		<div class="col-lg-6 col-md-6 col-xs-12">
			<h3 class="add-on"><strong>Glimpse</strong></h3>
			<p><small>A Project Manager</small></p>
		</div>
		<div class="col-lg-6 col-md-6 col-xs-12"
			style="padding-top: 1.5%; left: 13%;">
			<form name="loginForm" class="form-horizontal" ng-submit="login()"
				novalidate>
				<div class="col-xs-4">
					<div class="row form-group"
						ng-class="{ 'has-error' : loginForm.email.$invalid && !loginForm.email.$pristine }">
						<span class="add-on glyphicon glyphicon-user"></span> 
						<input name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email" ng-model="email"
							placeholder="Email" required />
					</div>
					
					<div class="row">
						<div class="col-xs-12">
							<div ng-show="loginForm.email.$invalid && loginForm.email.$dirty"
								class="help-block login-error">Enter a valid email.</div>
						</div>
					</div>
				</div>
				
				<div class="col-xs-4">
					<div class="row form-group"
						ng-class="{ 'has-error' : loginForm.password.$invalid && !loginForm.password.$pristine }">
						<span class="add-on glyphicon glyphicon-lock"></span>
						<input name="password" type="password" 
							ng-model="password"	placeholder="Password" required />
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div ng-show="loginForm.password.$invalid && !loginForm.password.$pristine"
								class="help-block login-error">Password required.</div>
						</div>
					</div>
				</div>
				
				<div class="col-xs-2" style="padding-left: 10px; padding-top: 18px;">
					<button type="submit" class="btn btn-primary btn-sm"
						ng-disabled="loginForm.$invalid">Log In</button>
				</div>
			</form>

		</div>
	</div>
</div>

<div id="middle" ng-controller="SignUpController">	
	<div class="row" style="padding-top: 3%;">
		<div class="col-lg-6 col-md-6 col-s-12" style="padding-top: 5%;margin-left: 2%;">
										
		</div>

		<div class="col-lg-4 col-md-4 col-s-12 background-seashell" style="margin-left: 12%;">
			<h2><strong>Sign Up</strong></h2>
			<p style="padding-top: 20px;"></p>
			<form name="signUpForm" ng-submit="signUp()" novalidate>
				<div class="form-group" style="padding-top: 10px;"
					ng-class="{ 'has-error' : signUpForm.displayName.$invalid && !signUpForm.displayName.$pristine }">
					<input type="text" pattern="[A-Za-z]*" class="form-control input-lg"
						name="displayName" ng-model="displayName" placeholder="Full Name"
						required>
					<div class="help-block text-danger" ng-if="signupForm.displayName.$dirty" ng-messages="signupForm.displayName.$error">
             				<div ng-message="required">Your name is required.</div>
           			</div>	
				</div>

				<div class="form-group" style="padding-top: 10px;"
					ng-class="{ 'has-error' : signUpForm.email.$invalid && !signUpForm.email.$pristine }">
					<input unique-email type="email" id="email"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
						class="form-control input-lg" name="email" ng-model="email"
						placeholder="Email address" required>	
					<div class="help-block text-danger" ng-if="signupForm.email.$dirty" ng-messages="signupForm.email.$error">
              			<div ng-message="required">Your email address is required.</div>
              			<div ng-message="email">Your email address is invalid.</div>
              			<div ng-message="unique"><span class="ion-looping"></span> Email is already taken.</div>
            		</div>	
						
				</div>
				
				<div class="form-group" style="padding-top: 10px;"
					ng-class="{ 'has-error' : signUpForm.password.$invalid && !signUpForm.password.$pristine }">
					<input password-strength type="password" class="form-control input-lg"
						name="password" ng-model="password"
						placeholder="Password" required>
					<div class="help-block text-danger" ng-if="signupForm.password.$dirty" ng-messages="signupForm.password.$error">
              			<div ng-message="required">Password is required.</div>
            		</div>							
				</div>
				
				<div class="form-group" style="padding-top: 30px;">
					<div class="col-xs-6" style="padding-left: 0; padding-right: 1;">
						<button type="submit" class="btn btn-lg btn-primary btn-block"
							ng-disabled="signUpForm.$invalid">Sign Up</button>
					</div>
				</div>

			</form>
		</div>
	</div>
					
</div>			