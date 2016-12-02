/*global define */
define([], function() {
    'use strict';
    function userInfoController($scope, $http, $location, $rootScope, projectService){
        console.log("user Info controller!");
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;

        $scope.checkedUser = {
            userName: ''
        };

        $scope.providerinfo = {
            userName:"NA",
            credential: "NA",
            researchAreas:"NA",
            publications:"NA",
            professionalServices:"NA",
            keyword:"",
            email:""
        };

        $scope.checkedUser.userName = projectService.getUserInfo().userName;
        console.log($scope.checkedUser.userName);

//        $scope.rating.user = projectService.getRatingProject().user;
//        $scope.rating.project = projectService.getRatingProject().project;

        $scope.getProviderInfo = function() {
            $http({
                method : 'GET',
                url : '/users/'+ $scope.checkedUser.userName + '/providerinfo'
            }).success(function(data, status, headers, config) {
                    $scope.providerinfo = data;
                    console.log(data);
                }

            ).error(function (data, status, headers, config) {
                // console.log(data);
            });
        }

        $scope.submit = function () {
            $http({
                method : 'POST',
                url : '/ratings/update',
                data: $scope.rating
            }).success(function(data, status, headers, config) {
                    console.log(data);
                }
            ).error(function (data, status, headers, config) {
                console.log(data);
            });
            console.log($scope.rating);
            $location.path('/dashboard');
        }

        $scope.getProviderInfo();
    }
    userInfoController.$inject=['$scope', '$http', '$location', '$rootScope', 'projectService'];

    return userInfoController;
});