angular.module('dynamicFormApp.controllers', []).controller('ContentListController', function($scope, $state, popupService, $window, Content) {
  $scope.contents = Content.query(); //Issues a GET to /api/content
 
  $scope.deleteContent = function(content) { // Issues a DELETE to /api/content/:id
    if (popupService.showPopup('Really delete this?')) {
      content.$delete(function() {
        $window.location.href = ''; //redirect to home
      });
    }
  };
}).controller('ContentViewController', function($scope, $stateParams, Content) {
  $scope.content = Content.get({ id: $stateParams.id }); //Issues a GET to /api/content/:id
}).controller('ContentCreateController', function($scope, $state, $stateParams, Content) {
  $scope.content = new Content();  
 
  $scope.addContent = function() { //Issues a POST to /api/content
    $scope.content.$save(function() {
      $state.go('contents'); // on success go back to home 
    });
  };
}).controller('ContentEditController', function($scope, $state, $stateParams, Content) {
  $scope.updateContent = function() { //Issues a PUT to /api/content/:id
    $scope.content.$update(function() {
      $state.go('contents'); // on success go back to home 
    });
  };
 
  $scope.loadContent = function() { //Issues a GET request to /api/content/:id to get a content to update
    $scope.content = Content.get({ id: $stateParams.id });
  };
 
  $scope.loadContent(); // Load a content which can be edited on UI
});