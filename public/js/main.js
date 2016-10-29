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

require(['angular', 'controllers/registerController','angular-route'],
  function(angular, registerController) {

    // Declare app level module which depends on filters, and services

    var app = angular.module('myApp', ['ngRoute']).
      config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/register', {templateUrl: 'partials/register.html', controller: registerController});
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: registerController});
        $routeProvider.otherwise({redirectTo: '/register'});
      }]);

    angular.bootstrap(document, ['myApp']);
    app.controller("registerController", registerController);
});
