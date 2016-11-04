/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope){
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
                url : '/users/'+ $scope.userName + '/providerInfo'
            }).success(function(data, status, headers, config) {
                    $scope.providerInfo = data;
                    console.log(data);
                }

            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }

        $scope.updateProviderInfo = function() {
            console.log(".......");
            $http({
                method : 'POST',
                url : '/users/'+ $scope.userName + '/providerInfo',
                params: providerInfo
            }).success(function(data, status, headers, config) {
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
            // $scope.getProviderInfo();
        }
    }
    editProfileController.$inject=['$scope', '$http', '$location', '$rootScope'];

    return editProfileController;
});