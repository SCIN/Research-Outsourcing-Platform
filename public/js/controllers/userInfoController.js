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

        $scope.rating ={
            provider:'',
            user:'',
            project:'',
            projectrate:5,
            providerrate:5,
            comment:''
        };

        $scope.checkedUser.userName = projectService.getUserInfo().userName;
        console.log($scope.checkedUser.userName);
//        $scope.rating.user = projectService.getRatingProject().user;
//        $scope.rating.project = projectService.getRatingProject().project;
//
//        $http({
//            method: 'GET',
//            url: '/ratings/project/' + $scope.rating.project
//        }).success(function (data, status, headers, config) {
//           $scope.rating = data;
//        }
//        ).error(function (data, status, headers, config) {
//            console.log(data);
//        });

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
    }
    userInfoController.$inject=['$scope', '$http', '$location', '$rootScope', 'projectService'];

    return userInfoController;
});