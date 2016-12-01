    /*global define */

'use strict';

define([
    'controllers/loginController','controllers/registerController','controllers/dashController', 'controllers/editProfileController', 'controllers/publishProjectController', 'controllers/showProjectController', 'controllers/ratingController'
], function(loginController, registerController,dashController, editProfileController, publishProjectController, showProjectController, ratingController) {

/* Controllers */

    var controllers = {};

    controllers.registerController = registerController;

    controllers.loginController = loginController;

    controllers.dashController = dashController;

    controllers.editProfileController = editProfileController;

    controllers.publishProjectController = publishProjectController;

    controllers.showProjectController = showProjectController;

    controllers.ratingController = ratingController;

    return controllers;

});