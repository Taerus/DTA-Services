angular.module("dta_services", []); //API for adverts control

/*Definition of the advert controller for listing adverts*/
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

/*Definition of the advertservice to handdle hhtp request*/
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
