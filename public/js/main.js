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

require(['angular', 'controllers', 'angular-route'],
  function(angular, controllers) {
    // Declare app level module which depends on filters, and services

    var app = angular.module('myApp', ['ngRoute']).
      config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/register', {templateUrl: 'partials/register.html', controller: controllers.registerController});
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: controllers.loginController});
        $routeProvider.when('/dashboard', {templateUrl: 'partials/dashboard.html', controller: controllers.loginController});
        $routeProvider.otherwise({redirectTo: '/login'});
      }]);

    angular.bootstrap(document, ['myApp']);
    app.controller("registerController", controllers.registerController);
    app.controller("loginController", controllers.loginController);
});
