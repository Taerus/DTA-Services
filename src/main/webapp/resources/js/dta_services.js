angular.module("dta_services", []);


angular.module("dta_services").controller("AdvertsController",['AdvertsService',function(AdvertsService){
	var advertsController = this;
	
	AdvertsService.getAll().then(function(data){
		advertsController.adverts = data;
	});
	
	advertsController.setPredicate = function(predicate){
		if(advertsController.predicate === predicate){
			advertsController.predicate = '-'+predicate;
		}
		else {
			advertsController.predicate = predicate;
		}
	}
	
}]);

angular.module("dta_services").factory("AdvertsService",['$http',function ($http) {
	"use strict";
	
	var advertsService = this;
	
	
	advertsService.getAll = function() {
		return $http.get('/DTA-Services/API/adverts').then(function(response){
			return response.data;
		});
	}
	
	return advertsService;
}]);
