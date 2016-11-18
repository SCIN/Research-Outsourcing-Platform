/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope){
        console.log("show Project for this controller");
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;

         $scope.allProjects =[];

        $scope.getAllProjects = function() {
            $http({
                method : 'GET',
                url : '/users/showProjects'
            }).success(function(data, status, headers, config) {
                    $scope.allProjects = data;
                    console.log($scope.allProjects);
                }

            ).error(function (data, status, headers, config) {
                 console.log(data);
            });
        }

        // TODO: Check role of users
        if($scope.role == 'serviceUser'){
            // getUserInfo();
            $scope.getAllProjects()
        }
        else{
            $scope.getAllProjects();
        }
    }
    editProfileController.$inject=['$scope', '$http', '$location', '$rootScope'];

    return editProfileController;
});