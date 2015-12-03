<div ng-init="atc.initTaskModal()">
	<div class="modal-header">
		<h3 class="modal-title">Add Task</h3>
	</div>
	<div class="modal-body">
		<div class="row" style="margin-left: 2%;">
			<form name="addTaskForm">
				<div class="row form-group">
					<div class="col-xs-2">Title</div>
					<div class="col-xs-6">
						<input type="text" ng-model="atc.title" class="form-control" />
					</div>
				</div>
				<div class="row form-group">
					<div class="col-xs-2">Description</div>
					<div class="col-xs-6">
						<textarea name="description" ng-maxlength="500"
							ng-model="atc.titleDescription" class="form-control"></textarea>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-xs-2">Assignee</div>
					<div class="col-xs-6">
						<input type="text" class="form-control" placeholder="Search Team Members"
							name="searchBox" ng-model="atc.assignee"
							uib-typeahead="name as name.name for name in atc.teamMembers | filter:$viewValue | limitTo:8">
					</div>
				</div>
				<div class="row form-group">
					<div class="col-xs-2">Estimate</div>
					<div class="col-xs-6">
						<input type="number" ng-model="atc.estimate" class="form-control" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="modal-footer">
		<div class="row pull-left">
			<button class="btn btn-primary" ng-click="atc.add()">Add</button>
			<button class="btn btn-warning" ng-click="atc.cancel()">Cancel</button>
		</div>
	</div>
</div>