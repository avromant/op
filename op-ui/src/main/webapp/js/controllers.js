angular.module('dynamicFormApp.controllers', []).controller('ContentListController', function($scope, $state, $window, Content) {
  $scope.contents = Content.query(); //Issues a GET to /api/content
  
  $scope.deleteContent = function(content) { // Issues a DELETE to /api/content/:id
	  content.$delete({ id: content.id }, function() {
	        $window.location.href = ''; //redirect to home
	  });
  };
}).controller('ContentViewController', function($scope, $stateParams, Content) {
  $scope.content = Content.get({ id: $stateParams.id }); //Issues a GET to /api/content/:id
}).controller('ContentCreateController', function($scope, $state, $stateParams, Content) {
  $scope.content = new Content();  
  // FIXME : Constructeur de Content ?
  $scope.content.content = new Map();
  $scope.content.content["field1"] = "value1";
  $scope.content.content["field2"] = "value2";
  $scope.content.content["field3"] = "value3";
  
  $scope.addContent = function() { //Issues a POST to /api/content
    $scope.content.$save(function() {
      $state.go('contents'); // on success go back to home 
    });
  };
  
  $scope.addNewField = function() {
	  //alert($scope.content.content.size);
	  //var newItemNo = $scope.choices.length+1;
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