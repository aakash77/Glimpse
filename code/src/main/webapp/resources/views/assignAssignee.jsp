<div ng-init="tc.initAddMember()">
	<div class="modal-header">
		<h3 class="modal-title">Add Team Members</h3>
	</div>

	<div class="modal-body">
		<form>
			<div class="row">
				<div class="col-xs-12">
					<form class="navbar-form" role="search">
						<label>Search</label>

						<div class="input-group" style="width: 50%;">
							<input type="text" class="form-control" placeholder="Search"
								name="searchBox" ng-model="tc.selectedMember"
								uib-typeahead="name as name.name for name in tc.projectUsers | filter:$viewValue | limitTo:8">
						</div>
					</form>
				</div>
			</div>
		</form>
	</div>

	<div class="modal-footer">
		<div class="pull-left text-danger">{{formError}}</div>
		<button class="btn btn-primary" ng-click="tc.okay()">Add</button>
		<button class="btn btn-warning" ng-click="tc.cancel()">Cancel</button>
	</div>
</div>