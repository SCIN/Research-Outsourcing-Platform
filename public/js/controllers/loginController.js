/*global define */
define([], function() {
	'use strict';
	function loginController($scope, $http, $location){
		$scope.loginTitle = "Login";
		$scope.user = {
        			username: '',
        			password:''
        		};

        // Login Function
		$scope.login = function() {

            console.log($scope.user.username);
            console.log($scope.user.password);

            $http({
                method : 'POST',
                url : '/users/login',
                data : $scope.user
            }).success(function(data, status, headers, config) {
                console.log(data);
//                $location.path('/login');
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }

	}
	loginController.$inject=['$scope', '$http', '$location'];

	return loginController;
});