glimpse.controller('LoginController', function($scope, $rootScope, Auth) {

	$scope.login = function() {
    	var params = {
				email : $scope.email,
				password : $scope.password
		};
    	
      Auth.login(urlConstants.LOGIN, params);
    };
  });
