(function(){
	
	var edi = angular.module('editionIngredient',[])
	
	edi.directive('editionIngredient', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredient.html'
		};
	});	
	
	edi.directive('editionIngredientIntroduction',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientIntroduction.html'
		};
	});
	
	edi.directive('editionIngredientIntitule',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientIntitule.html'
		};
	});
	
	edi.directive('editionIngredientTypePlat',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientTypeIngredient.html'
		};
	});
	
	edi.directive('editionIngredientCout',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientCout.html'
		};
	});
	
	edi.directive('editionIngredientImage',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientImage.html'
		};
	});
	
	edi.directive('editionIngredientConseils',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientConseils.html'
		};
	});
	
	edi.directive('editionIngredientFinalisation',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionIngredient/editionIngredientFinalisation.html'
		};
	});
})();