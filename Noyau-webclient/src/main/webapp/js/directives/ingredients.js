(function(){
	
	angular.module('ingredientsDirective',[])
	.directive('tableIngredients', directiveTableIngredients)
	.directive('navigationEditionIngredient', directiveNavigationEditionIngredient)
	.directive('editionIngredient', directiveEditionIngredient)
	.directive('editionIngredientIntroduction', directiveEditionIngredientIntroduction)
	.directive('editionIngredientIntitule', directiveEditionIngredientIntitule)
	.directive('editionIngredientTypePlat', directiveEditionIngredientTypePlat)
	.directive('editionIngredientCout', directiveEditionIngredientCout)
	.directive('editionIngredientImage', directiveEditionIngredientImage)
	.directive('editionIngredientConseils', directiveEditionIngredientConseils)
	.directive('editionIngredientFinalisation', directiveEditionIngredientFinalisation)
	
	function directiveTableIngredients(){return{restrict:'E',templateUrl:'templates/pages/recettes/ingredients/tableIngredients.html'};};
	function directiveNavigationEditionIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/navigationEditionIngredient.html'};};
	function directiveEditionIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredient.html'};};
	function directiveEditionIngredientIntroduction(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientIntroduction.html'};};
	function directiveEditionIngredientIntitule(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientIntitule.html'};};
	function directiveEditionIngredientTypePlat(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientTypeIngredient.html'};};	
	function directiveEditionIngredientCout(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientCout.html'};};	
	function directiveEditionIngredientImage(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientImage.html'};};	
	function directiveEditionIngredientConseils(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientConseils.html'};};	
	function directiveEditionIngredientFinalisation(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionIngredient/editionIngredientFinalisation.html'};};

})();