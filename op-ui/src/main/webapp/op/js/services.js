angular.module('dynamicFormApp.services', []).factory('Content', function($resource) {
  return $resource('http://localhost:8080/content/:id', { id: '@_id' }, {
    update: {
      method: 'PUT'
    }
  });
});