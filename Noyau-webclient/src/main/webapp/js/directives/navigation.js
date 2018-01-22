(function() {
	
	angular.module("navigationDirective", [])
	
	.directive("barreNavigation",directiveBarreNavigation);
	
	function directiveBarreNavigation(){return {restrict:'E',templateUrl:'templates/pages/header.html',};};
				
})();