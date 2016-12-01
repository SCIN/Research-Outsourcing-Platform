    /*global define */

'use strict';

define([
    'controllers/loginController','controllers/registerController','controllers/dashController', 'controllers/editProfileController', 'controllers/publishProjectController', 'controllers/showProjectController', 'controllers/ratingController', 'controllers/allProvidersController'
], function(loginController, registerController,dashController, editProfileController, publishProjectController, showProjectController, ratingController, allProvidersController) {

/* Controllers */

    var controllers = {};

    controllers.registerController = registerController;

    controllers.loginController = loginController;

    controllers.dashController = dashController;

    controllers.editProfileController = editProfileController;

    controllers.publishProjectController = publishProjectController;

    controllers.showProjectController = showProjectController;

    controllers.ratingController = ratingController;

    controllers.allProvidersController = allProvidersController;

    return controllers;

});