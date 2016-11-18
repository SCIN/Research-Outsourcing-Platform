/*global define */
define([], function() {
	'use strict';
	function dashController($scope, $http, $location, $rootScope){
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);
        $scope.providerinfo = {
            username : "",
            credential: "",
            researchAreas:"",
            publications:"",
            professionalServices:""
        };

        $scope.userinfo = {
            keywords:""
        };

        $scope.getUserInfo = function() {
            $http({
                method : 'GET',
                url : '/users/'+ $scope.userName + '/serviceuserinfo',
            }).success(function(data, status, headers, config) {
                    $scope.userinfo = data;
                     console.log(data);
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }

        $scope.getProviderInfo = function() {
            $http({
                method : 'GET',
                url : '/users/'+ $scope.userName + '/providerinfo'
            }).success(function(data, status, headers, config) {
                    $scope.providerinfo = data;
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }



        if($scope.role == 'serviceUser'){
             $scope.getUserInfo();
        }
        else{
            $scope.getProviderInfo();
        }
	}
	dashController.$inject=['$scope', '$http', '$location', '$rootScope'];

	return dashController;
});