/*global define */
define([], function() {
	'use strict';
	function loginController($scope, $http, $location){
		$scope.loginTitle = "dash bord";
		$scope.user = {
        			userName: '',
        			password:''
        };

        $scope.loginResult = "Please use your username and password to login";
        // Login Function
		$scope.login = function() {
            $http({
                method : 'POST',
                url : '/users/login',
                data : $scope.user
            }).success(function(data, status, headers, config) {
                $scope.loginResult = data;
                console.log(data);
                $location.path('/dashboard');
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }
	}
	loginController.$inject=['$scope', '$http', '$location'];

	return loginController;
});