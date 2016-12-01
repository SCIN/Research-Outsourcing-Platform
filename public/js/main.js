/*global require, requirejs */

'use strict';

requirejs.config({
  paths: {
    'angular': ['../lib/angularjs/angular'],
    'angular-route': ['../lib/angularjs/angular-route']
  },
  shim: {
    'angular': {
      exports : 'angular'
    },
    'angular-route': {
      deps: ['angular'],
      exports : 'angular'
    }
  }
});

require(['angular', 'controllers', 'services','angular-route'],
  function(angular, controllers, services) {
    // Declare app level module which depends on filters, and services

    var app = angular.module('myApp', ['ngRoute']).
      config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/register', {templateUrl: 'partials/register.html', controller: controllers.registerController});
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: controllers.loginController});
        $routeProvider.when('/dashboard', {templateUrl: 'partials/dashboard.html', controller: controllers.dashController});
        $routeProvider.when('/editService', {templateUrl: 'partials/editInfo.html', controller: controllers.editProfileController});
        $routeProvider.when('/publishProject', {templateUrl: 'partials/publishProject.html', controller: controllers.publishProjectController});
        $routeProvider.when('/showProject', {templateUrl: 'partials/showProject.html', controller: controllers.showProjectController});
        $routeProvider.when('/rating', {templateUrl: 'partials/rating.html', controller: controllers.ratingController});
        $routeProvider.when('/allProviders', {templateUrl: 'partials/allProviders.html', controller: controllers.allProvidersController});
        $routeProvider.otherwise({redirectTo: '/login'});
      }]);

   // root scope
    app.run(function($rootScope) {
        $rootScope.user = {
                userName: '',
                password:'',
                role:''
        };
    });

    angular.bootstrap(document, ['myApp']);
    app.controller("registerController", controllers.registerController);
    app.controller("loginController", controllers.loginController);
    app.controller("dashController", controllers.dashController);
    app.controller("editProfileController", controllers.editProfileController);
    app.controller("publishProjectController", controllers.publishProjectController);
    app.controller("showProjectController", controllers.showProjectController);
    app.controller("ratingController", controllers.ratingController);
    app.controller("allProvidersController", controllers.allProvidersController);
    app.service('projectService', services.projectService);

});
