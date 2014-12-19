angular.module('dynamicFormApp.services', []).factory('Content', function($resource) {
  return $resource('http://localhost:8080/api/contents/:id', { id: '@_id' }, {
    update: { 
    	method: 'PUT'
    }
  });
});