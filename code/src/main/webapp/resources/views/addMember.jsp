<div ng-init="amc.initAddMember()">
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
								name="searchBox" ng-model="amc.selectedMember"
								uib-typeahead="name as name.name for name in amc.nonProjectUsers | filter:$viewValue | limitTo:8">
						</div>
						<button class="btn btn-primary" ng-click="amc.addMemberBtn()">Add</button>
					</form>
				</div>
			</div>

			<div class="row" style="margin-left: auto;">
				<div class="col-xs-6">
					<h4>Project Members</h4>
					<div class="row" ng-repeat="members in amc.projectUsers">
						<div class="col-xs-12">
							<b>{{members.name}}</b> <{{members.email}}>
						</div>
					</div>
				</div>
				<div class="col-xs-6">
					<h4>Send Invitations To</h4>
					<div class="row" ng-repeat="members in amc.addedMembers">
						<div class="col-xs-12">
							<b>{{members.name}}</b> <{{members.email}}>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<div class="modal-footer">
		<div class="pull-left text-danger">{{formError}}</div>
		<button class="btn btn-primary" ng-click="amc.okay()">Done</button>
		<button class="btn btn-warning" ng-click="amc.cancel()">Cancel</button>
	</div>
</div>