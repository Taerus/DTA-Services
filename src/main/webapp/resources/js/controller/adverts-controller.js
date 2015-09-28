angular.module("dta-services").controller("AdvertsController",['AdvertsService',function(AdvertsService){
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