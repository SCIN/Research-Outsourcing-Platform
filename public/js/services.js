/*global define */

'use strict';

define([
    'services/projectService'
], function(projectService) {

    /* Controllers */

    var services = {};

    services.projectService = projectService;

    return services;

});