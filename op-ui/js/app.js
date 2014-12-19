angular.module('dynamicFormApp', ['ui.router', 'ngResource', 'dynamicFormApp.controllers', 'dynamicFormApp.services'])

angular.module('dynamicFormApp').config(function($stateProvider) {
  $stateProvider.state('contents', { // state for showing all contents
    url: '/contents',
    templateUrl: 'partials/contents.html',
    controller: 'ContentListController'
  }).state('viewContent', { //state for showing single content
    url: '/contents/:id/view',
    templateUrl: 'partials/content-view.html',
    controller: 'ContentViewController'
  }).state('newContent', { //state for adding a new Content
    url: '/contents/new',
    templateUrl: 'partials/content-add.html',
    controller: 'ContentCreateController'
  }).state('editContent', { //state for updating a movie
    url: '/contents/:id/edit',
    templateUrl: 'partials/content-edit.html',
    controller: 'ContentEditController'
  });
}).run(function($state) {
  $state.go('contents'); //make a transition to movies state when app starts
});
