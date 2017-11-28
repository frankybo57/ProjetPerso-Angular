(function(){
	
	admin = angular.module("pageAdmin", []);
	
	admin.directive("pageAdmin",function(){
		return{
			restrict:'E',
			templateUrl:'admin/page-admin.html',
		};
	});
	
	
	
	
})();
