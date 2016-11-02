    /*global define */

'use strict';

define([
    'controllers/loginController','controllers/registerController'
], function(loginController, registerController) {

/* Controllers */

    var controllers = {};

    controllers.registerController = registerController;

    controllers.loginController = loginController;

    return controllers;

});