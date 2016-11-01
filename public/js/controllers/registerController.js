define([], function() {
	'use strict';
	function registerController($scope, $http, $location){
		$scope.user = {
			question: 'When is your birthday? (mm:dd)',
			anwser: '',
			email:'',
			username: '',
			password:''
		};
		$scope.questions = ['What is the last name of the teacher who gave you your first failing grade?',
							'What was the name of your elementary / primary school?',
							'When is your birthday? (mm:dd)'];
		$scope.register = function () {
			$http({
				method : 'POST',
				url : '/users/register',
				data : $scope.user
			}).success(function(data, status, headers, config) {
				console.log(data);
				$location.path('/login');
				}

			).error(function (data, status, headers, config) {
				console.log(data);
			});
		}
	}
	registerController.$inject=['$scope', '$http', '$location'];

	return registerController;
});
