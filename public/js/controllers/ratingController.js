/*global define */
define([], function() {
    'use strict';
    function ratingController($scope, $http, $location, $rootScope, projectService){
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);

        $scope.rating ={
            provider:'',
            user:'',
            project:'',
            projectrate:5,
            providerrate:5,
            comment:''
        };

        $scope.rating.provider = projectService.getRatingProject().provider;
        $scope.rating.user = projectService.getRatingProject().user;
        $scope.rating.project = projectService.getRatingProject().project;

        $http({
            method: 'GET',
            url: '/ratings/project' + $scope.rating.project
        }).success(function (data, status, headers, config) {
                $scope.rating = data;
        }
        ).error(function (data, status, headers, config) {
            console.log(data);
        });

        $scope.submit = function () {
            $http({
                method : 'POST',
                url : '/projects/projectname/',
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
    ratingController.$inject=['$scope', '$http', '$location', '$rootScope', 'projectService'];

    return ratingController;
});