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
        $routeProvider.when('/editService', {templateUrl: 'partials/editService.html', controller: controllers.editProfileController});
        $routeProvider.when('/publishProject', {templateUrl: 'partials/publishProject.html', controller: controllers.publishProjectController});
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
    app.service('projectService', services.projectService);

});
