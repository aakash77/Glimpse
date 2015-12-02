<div>
	<div class="modal-header">
		<h3 class="modal-title">Add Project</h3>
	</div>

	<div class="modal-body" ng-init="apc.initAddProject()">
		<form method="post" name="addProjectForm" ng-submit="apc.add()"
			novalidate>
			<div class="row">
				<div class="col-xs-3">Title</div>
				<div class="col-xs-1">:</div>
				<div class="col-xs-8 form-group has-feedback"
					ng-class="{'has-error' : addProjectForm.title.$invalid && addProjectForm.title.$dirty }">
					<input class=form-control type="text" name="title"
						style="width: 70%" ng-model="projectTitle" required></input>
				</div>

				<div class="col-xs-3"></div>
				<div class="col-xs-1"></div>
				<div class="col-xs-8 help-block text-danger"
					ng-messages="addProjectForm.title.$error" role="alert"
					ng-if="addProjectForm.title.$dirty">
					<div ng-message="required">Your must enter the project title
						name.</div>
				</div>

				<div class="col-xs-12"separator">&nbsp;</div>

				<div class="col-xs-3">Description</div>
				<div class="col-xs-1">:</div>
				<div class="col-xs-8 form-group has-feedback"
					ng-class="{'has-error' : addProjectForm.description.$invalid && addProjectForm.description.$dirty }">
					<textarea class=form-control name="description" ng-maxlength="500"
						ng-model="projectDescription" style="width: 70%" required></textarea>
				</div>

				<div class="col-xs-3"></div>
				<div class="col-xs-1"></div>
				<div class="col-xs-8 help-block text-danger"
					ng-messages="addProjectForm.description.$error" role="alert"
					ng-if="addProjectForm.description.$dirty">
					<div ng-message="required">Description of the project is
						required</div>
					<div ng-message="maxlength">The project description exceeds
						the max limit of 500 characters.</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-primary"
					ng-disabled="addProjectForm.$invalid">Add</button>
				<button class="btn btn-warning" ng-click="apc.cancel()">Cancel</button>
			</div>
		</form>
	</div>

	<div>
		<!-- Show validation here. -->
	</div>


</div>