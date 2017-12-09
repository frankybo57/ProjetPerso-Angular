(function(){
	
	var edi = angular.module('editionIngredient',[])
	
	edi.directive('editionIngredient', function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredient.html'
		};
	});	
	
	edi.directive('editionIngredientIntroduction',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientIntroduction.html'
		};
	});
	
	edi.directive('editionIngredientIntitule',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientIntitule.html'
		};
	});
	
	edi.directive('editionIngredientTypePlat',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientTypeIngredient.html'
		};
	});
	
	edi.directive('editionIngredientCout',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientCout.html'
		};
	});
	
	edi.directive('editionIngredientImage',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientImage.html'
		};
	});
	
	edi.directive('editionIngredientConseils',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientConseils.html'
		};
	});
	
	edi.directive('editionIngredientFinalisation',function(){
		return{
			restrict:'E',
			templateUrl:'Ingredients/editionIngredient/editionIngredientFinalisation.html'
		};
	});
})();