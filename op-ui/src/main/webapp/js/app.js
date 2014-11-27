angular.module('dynamicFormApp', [])

.controller('mainController', function($scope, $http) {

  $http.get('http://localhost:8080/content/123457').
  		success(function(data) {
  			$scope.formDataOne = {};
  			$scope.formDataOne.product = data;
  		});	
	
});

