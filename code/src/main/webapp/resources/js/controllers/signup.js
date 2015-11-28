glimpse.controller('SignUpController', function($scope, Auth) {
	
	$scope.signUp = function() {
		var params = {
	        name: $scope.displayName,
	        email: $scope.email,
	        password: $scope.password
      };
		Auth.signUp(urlConstants.SIGNUP, params);
	};    
 });