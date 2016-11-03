/*global define */
define([], function() {
	'use strict';
	function dashController($scope, $http, $location, $rootScope){
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;

        // $scope.getUserInfo = function() {
        //     $http({
        //         method : 'GET',
        //         url : '/users/'+ $scope.userName + '/userInfo',
        //     }).success(function(data, status, headers, config) {
        //             $scope.loginResult = data;
        //             console.log(data);
        //             $location.path('/dashboard');
        //         }
        //
        //     ).error(function (data, status, headers, config) {
        //         console.log(data);
        //     });
        // }

        $scope.getProviderInfo = function() {
            $http({
                method : 'GET',
                url : '/users/'+ $scope.userName + '/providerInfo',
            }).success(function(data, status, headers, config) {
                    $scope.loginResult = data;
                    console.log(data);
                    $location.path('/dashboard');
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }

        if($scope.role == 'serviceUser'){
            // getUserInfo();
        }
        else{
            getProviderInfo();
        }
	}
	dashController.$inject=['$scope', '$http', '$location', '$rootScope'];

	return dashController;
});