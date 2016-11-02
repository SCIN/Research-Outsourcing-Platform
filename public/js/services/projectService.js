/*global define */

define([], function() {
  'use strict';
/* Services */

// Demonstrate how to register services
// In this case it is a simple value service.
  function projectService() {
      function createProject() {
          var Project = {
              name : 'p1',
              descri: ''
          };
          return Project;
      }

      return {
          createProject : createProject
      };
  }

  return projectService;
});