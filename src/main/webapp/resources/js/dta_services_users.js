angular.module("dta_services_users",[]);

angular.module("dta_services_users").controller("UsersController",['UsersService',function(UsersService){
	var usersController = this;
	
	UsersService.getAll().then(function(data){
		usersController.users = data;
	});
	
	
	
}]);

angular.module("dta_services_users").factory("UsersService",['$http',function($http){
		var usersService = this;
		
		usersService.getAll = function(){
			return $http.get("/DTA-Services/API/users").then(function(response){
				return response.data;
			});
		}
		
		
		return usersService;
}]);