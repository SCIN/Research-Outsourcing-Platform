/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope,$timeout){
        console.log("show Project for this controller");
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);

        // Mock Data: Test for all projects

         $scope.allProjects =[];


        $scope.getAllProjects = function() {
            $http({
                method : 'GET',
                url : '/users/showProjects'
            }).success(function(data, status, headers, config) {
                $timeout(function () {
                    $scope.allProjects = data;
                });
                }
            ).error(function (data, status, headers, config) {
                 console.log(data);
            });
        }

        $scope.provideProject = function(project){
            $http({
                method : 'POST',
                url : '/projects/provide/'+$scope.userName,
                data: {project:project}
            }).success(function(data, status, headers, config) {
                    $scope.getAllProjects();
                    console.log(data);
                }
            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }

        $scope.deleteProject = function(project){
            $http({
                method : 'POST',
                url : '/projects/delete',
                data: {project:project}
            }).success(function(data, status, headers, config) {
                    $scope.getAllProjects();
                }
            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }

            $scope.getAllProjects();
    }
    editProfileController.$inject=['$scope', '$http', '$location', '$rootScope','$timeout'];

    return editProfileController;
});