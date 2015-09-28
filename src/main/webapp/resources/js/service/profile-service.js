angular.module("dta-services").factory("ProfileService",["$http",function($http){
	var profileService = this;
	
	profileService.getBalance = function(){
		return $http.get("/DTA-Services/API/user/balance").then(function(response){
			return response.data;
		});
	}	
	
	return profileService;
}]);