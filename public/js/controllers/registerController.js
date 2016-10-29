define([], function() {
	'use strict';
	function registerController($scope){
		$scope.test = "test";
	}
	registerController.$inject=['$scope'];

	return registerController;
});
