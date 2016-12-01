/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope){
        console.log("All Providers controller");
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);

        // Mock Data: Test for all projects
         $scope.allProviders =[];


        $scope.getAllProviders = function() {
            $http({
                method : 'GET',
                url : '/users/showProjects'
            }).success(function(data, status, headers, config) {
                    $scope.allProviders = data;
                    console.log($scope.allProjects);
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
        if ($scope.role == 'serviceProvider'){
            $scope.getAllProviders();
        } else {
            $scope.getAllProviders();
        }
    }
    editProfileController.$inject=['$scope', '$http', '$location', '$rootScope'];

    return editProfileController;
});