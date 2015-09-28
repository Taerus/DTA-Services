angular.module("dta-services").controller("ProfileController",["ProfileService",function(ProfileService){
	var profileController = this;
	
	ProfileService.getBalance().then(function(data){
		profileController.balance = data;
	});
}]);