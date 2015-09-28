angular.module("dta-services").controller("UsersController",['UsersService','$window',function(UsersService,$window){
	var usersController = this;
	
	UsersService.getAll().then(function(data){
		usersController.users = data;
	});
	
	usersController.predicate ='login';
	
	usersController.setPredicate = function(predicate){
		if(usersController.predicate===predicate)
			usersController.predicate = '-' + predicate;
		else
			usersController.predicate = predicate;
	}
	
	usersController.redirectTo = function(id){
		$window.location.assign('/DTA-Services/user/' + id);
	}
	
	
}]);