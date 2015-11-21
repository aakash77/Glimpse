glimpse.controller('SignUpController', function($scope, Auth) {
	
	$scope.signup = function() {
		var params = {
	        name: $scope.displayName,
	        email: $scope.email,
	        password: $scope.password
      };
		Auth.signup(urlConstants.SIGNUP, params);
	};    
 });