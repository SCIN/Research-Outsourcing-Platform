    /*global define */

'use strict';

define([
    'controllers/loginController','controllers/registerController','controllers/dashController', 'controllers/editProfileController', 'controllers/publishProjectController'
], function(loginController, registerController,dashController, editProfileController, publishProjectController) {

/* Controllers */

    var controllers = {};

    controllers.registerController = registerController;

    controllers.loginController = loginController;

    controllers.dashController = dashController;

    controllers.editProfileController = editProfileController;

    controllers.publishProjectController = publishProjectController;

    return controllers;

});