/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope){
        console.log("show Project for this controller");
        $scope.userName = $rootScope.user.userName;
        $scope.role = $rootScope.user.role;
        // console.log($rootScope.user.role);
        $scope.projectInfo = {
                    projectName: "mock",
                    projectDescription:"mock",
                    requiredExpertise:"mock",
                    begintime:"mock",
                    endtime: "mock",
                    price:"mock",
                    status:"new"
        };

        // Test for all projects


        $scope.getAllProjects = function() {
            $http({
                method : 'GET',
                url : '/users/showProjects'
            }).success(function(data, status, headers, config) {
//                    $scope.providerinfo = data;
                    console.log(data);
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