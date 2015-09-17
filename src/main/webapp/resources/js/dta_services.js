angular.module("dta_services", [])
.controller("AdvertController", ['$scope','$http',function ($scope, $http) {
	"use strict";
	var advert = this;
	
	advert.getAll = function() {
		return $http.get('/DTA-Services/API/advert').then(function(response){
			return response.data;
		});
	};
	
	advert.getAll().then(function(adverts){
		advert.list = adverts;
	});
	
}]);
