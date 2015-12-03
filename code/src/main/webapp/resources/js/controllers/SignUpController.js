glimpse.controller('SignUpController',['$scope','Auth','$uibModal', function($scope, Auth,$uibModal) {
	
	$scope.signup = function() {
		var params = {
	        name: $scope.displayName,
	        email: $scope.email,
	        password: $scope.password
		};
		Auth.signup(urlConstants.SIGNUP, params).success(function(data){
		}).error(function(err){			
		});

		var modalInstance = $uibModal.open({
			templateUrl : 'glimpse/partials/signUpNotification',
			controller : 'SignUpNotificationCtrl',
			controllerAs : 'sunc',
		});

		modalInstance.result.then(function() {
			//modal success
		}, function() {
			$scope.displayName = "";
			$scope.email = "";
	        $scope.password = "";
	        $scope.signUpForm.$setPristine();
		});	
	};    
 }]);