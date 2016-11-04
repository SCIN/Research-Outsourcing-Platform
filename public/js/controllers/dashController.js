/*global define */
define([], function() {
	'use strict';
	function dashController($scope, $http, $location, $rootScope){
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);
        $scope.providerInfo = {
            credential: "",
            researchAreas:"",
            publications:"",
            professionalServices:""
        };

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
                url : '/users/'+ $scope.userName + '/providerinfo'
            }).success(function(data, status, headers, config) {
                    $scope.providerInfo = data;
                    console.log(data);
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }



        if($scope.role == 'serviceUser'){
            // getUserInfo();
        }
        else{
            $scope.getProviderInfo();
        }
	}
	dashController.$inject=['$scope', '$http', '$location', '$rootScope'];

	return dashController;
});