(function() {
	
	var nav = angular.module("navigation", []);
	
	nav.directive("barreNavigation",function(){
		return {
			restrict:'E',
			templateUrl:'header.html',
		};
	});
				
})();