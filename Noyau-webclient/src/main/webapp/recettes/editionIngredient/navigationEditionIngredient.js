(function(){
	
	var nav = angular.module('navigationEditionIngredient',[])
	
	nav.directive('navigationEditionIngredient', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/navigationEditionIngredient.html'
		}
	});	
})();