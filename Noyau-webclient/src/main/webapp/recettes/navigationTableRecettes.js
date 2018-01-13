(function(){
	
	var nav = angular.module('navigationTableRecettes',[])
	
	nav.directive('navigationTableRecettes', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/navigationTableRecettes.html'
		}
	});	
})();