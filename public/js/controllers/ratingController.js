/*global define */
define([], function() {
    'use strict';
    function ratingController($scope, $http, $location, $rootScope){
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
        
        if ($scope.role == 'serviceProvider'){
            $scope.getAllProjects();
        }
    }
    ratingController.$inject=['$scope', '$http', '$location', '$rootScope'];

    return ratingController;
});