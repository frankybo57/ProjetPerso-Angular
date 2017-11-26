(function(){
	
	var admin = angular.module("admin", []);
	
	admin.directive("pageAdmin",function(){
		return{
			restrict:'E',
			templateUrl:'admin/page-admin.html',
			controller:'ModuleController',
			controllerAs:'moduleCtrl'
		};
	});
	
	
})();
