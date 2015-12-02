<div ng-init="ad.initAddMember()">
	<div class="modal-header">
		<h3 class="modal-title">Enter Actual Number of Days</h3>
	</div>

	<div class="modal-body">
		<form>
			<div class="row">
				<div class="col-xs-12">
					<form class="navbar-form" role="search">
						<label>Days</label>

						<div class="input-group" style="width: 50%;">
							<input type="text" class="form-control" placeholder="Days"
								name="actualDays" ng-model="ad.actualDays">
						</div>
					</form>
				</div>
			</div>
		</form>
	</div>

	<div class="modal-footer">
		<div class="pull-left text-danger">{{formError}}</div>
		<button class="btn btn-primary" ng-click="ad.okay()">Finish</button>
		<button class="btn btn-warning" ng-click="ad.cancel()">Cancel</button>
	</div>
</div>