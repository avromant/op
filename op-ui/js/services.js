angular.module('dynamicFormApp.services', []).factory('Content', function($resource) {
  return $resource('http://localhost:8080/api/contents/:id', { id: '@_id' }, {
    update: { 
    	method: 'PUT'
    }
  })
 })
  .service('ContentFormService', function() {
  deleteField = function(field) {
	  delete $scope.content.content[field];
   };
  addNewField = function() {
	  var size = Object.keys($scope.content.content).length + 1;
	  $scope.content.content["_newField" + size] = "value" + size;
   };

    });

