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

        // Mock Data: Test for all projects
//        $scope.allProjects = {
//            project: [{
//              projectName: "apple",
//              projectDescription:"mock1",
//              requiredExpertise:"mock1",
//              begintime:"mock1",
//              endtime: "mock1",
//              price:"mock1",
//              status:"new1"
//            },{
//              projectName: "jacab",
//              projectDescription:"mock2",
//              requiredExpertise:"mock2",
//              begintime:"mock2",
//              endtime: "mock",
//              price:"mock2",
//              status:"new2"
//            },{
//              projectName: "Banana",
//                projectDescription:"mock3",
//                requiredExpertise:"mock3",
//                begintime:"mock3",
//                endtime: "mock3",
//                price:"mock3",
//                status:"new3"
//            }]
//          };

         $scope.allProjects =[
//                    {
//                      projectName: "apple",
//                      projectDescription:"mock1",
//                      requiredExpertise:"mock1",
//                      begintime:"mock1",
//                      endtime: "mock1",
//                      price:"mock1",
//                      status:"new1"
//                    },{
//                      projectName: "jacab",
//                      projectDescription:"mock2",
//                      requiredExpertise:"mock2",
//                      begintime:"mock2",
//                      endtime: "mock",
//                      price:"mock2",
//                      status:"new2"
//                    },{
//                      projectName: "Banana",
//                        projectDescription:"mock3",
//                        requiredExpertise:"mock3",
//                        begintime:"mock3",
//                        endtime: "mock3",
//                        price:"mock3",
//                        status:"new3"
//                    }
                    ];



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