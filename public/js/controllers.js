    /*global define */

'use strict';

define([
    'controllers/loginController','controllers/registerController','controllers/dashController'
], function(loginController, registerController,dashController) {

/* Controllers */

    var controllers = {};

    controllers.registerController = registerController;

    controllers.loginController = loginController;

    controllers.dashController = dashController;

    return controllers;

});