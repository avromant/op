angular.module('dynamicFormApp.services', []).factory('Content', function($resource) {
  return $resource('http://localhost:8080/api/contents/:id', { id: '@_id' }, {
    update: {
    	method: 'PUT'
    }
  })
 }).factory('ContentFormService', function(Content) {
    var contentFormService = {
          deleteField : function(content, field) {
        	  delete content.content[field];
           },
          addNewField : function(content) {
        	  var size = Object.keys(content.content).length + 1;
        	  content.content["_newField" + size] = "value" + size;
           },
           initContent : function() {
             var content = new Content();
             content.content = new Map();
             content.content["titre"] = "value1";
             content.content["description"] = "value2";
             content.content["imageUrl"] = "img/";
             return content;
           }
    };
    return contentFormService;
 }).factory('Param', function($resource) {
     return $resource('http://localhost:8080/api/params/:id', { id: '@_id' }, {
       update: {
       	method: 'PUT'
       }
     })
 }).factory('ParamFormService', function(Param) {
      var paramFormService = {
            deleteParam : function(param) {
          	  //delete content.content[field];
             },
            addNewParam : function(param) {
          	  //content.content["_newField" + size] = "value" + size;
             }
      };
      return paramFormService;
   });