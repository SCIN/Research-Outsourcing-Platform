/*global define */
define([], function() {
    'use strict';
    function editProfileController($scope, $http, $location, $rootScope){
        console.log("publish Project.......");
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

        $scope.updateExpertise = function() {
            $scope.projectInfo.requiredExpertise = "";
        }

        $scope.publishProject = function() {
            console.log($scope.userName);
            console.log($scope.projectInfo);
            $http({
                method : 'POST',
                url : '/users/'+ $scope.userName + '/publishProject',
                data: $scope.projectInfo
            }).success(function(data, status, headers, config) {
                console.log(data);
                $location.path('/showProject');
                }
            ).error(function (data, status, headers, config) {
                console.log(data);
            });
        }
    }
    editProfileController.$inject=['$scope', '$http', '$location', '$rootScope'];

    return editProfileController;
});