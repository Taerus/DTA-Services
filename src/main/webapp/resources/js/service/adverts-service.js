angular.module("dta-services").factory("AdvertsService",['$http',function ($http) {
	"use strict";
	
	var advertsService = this;
	
	
	advertsService.getAll = function() {
		return $http.get('/DTA-Services/API/adverts').then(function(response){
			return response.data;
		});
	}
	
	return advertsService;
}]);