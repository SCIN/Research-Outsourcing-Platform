/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope,$timeout){
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);
        $scope.allProjects =[];
        $scope.search = {
            keywords:"",
            searchBy:""
        }


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

        $scope.searchProject = function(project){
            if ($scope.search.searchBy == "keywords") {
                $http({
                    method : 'POST',
                    url : '/search/keywords',
                    data: $scope.search
                }).success(function(data, status, headers, config) {
                        $scope.allProjects = data;
                        console.log($scope.allProjects);
                    }
                ).error(function (data, status, headers, config) {
                    console.log(data);
                });
            } else if ($scope.search.searchBy == "university") {
                $http({
                    method : 'POST',
                    url : '/search/university',
                    data: $scope.search
                }).success(function(data, status, headers, config) {
                        $scope.allProjects = data;
                        console.log($scope.allProjects);
                    }
                ).error(function (data, status, headers, config) {
                    console.log(data);
                });
            } else {
                //TODO
            }

        }

        $scope.getAllProjects();
    }
    editProfileController.$inject=['$scope', '$http', '$location', '$rootScope','$timeout'];

    return editProfileController;
});