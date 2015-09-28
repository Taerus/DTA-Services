angular.module("dta-services").factory("UsersService",['$http',function($http){
	var usersService = this;
	
	usersService.getAll = function(){
		return $http.get("/DTA-Services/API/users").then(function(response){
			return response.data;
		});
	}
	
	return usersService;
}]);