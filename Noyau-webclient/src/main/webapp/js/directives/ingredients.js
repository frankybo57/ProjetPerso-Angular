(function(){
	
	angular.module('ingredientsDirective',[])
	.directive('navigationEditionIngredient', directiveNavigationEditionIngredient)
	.directive('editionIngredient', directiveEditionIngredient)
	.directive('editionIngredientIntroduction', directiveEditionIngredientIntroduction)
	.directive('editionIngredientIntitule', directiveEditionIngredientIntitule)
	.directive('editionIngredientTypePlat', directiveEditionIngredientTypePlat)
	.directive('editionIngredientCout', directiveEditionIngredientCout)
	.directive('editionIngredientImage', directiveEditionIngredientImage)
	.directive('editionIngredientConseils', directiveEditionIngredientConseils)
	.directive('editionIngredientFinalisation', directiveEditionIngredientFinalisation)
	
	function directiveNavigationEditionIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/navigation.html'};};
	function directiveEditionIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredient.html'};};
	function directiveEditionIngredientIntroduction(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientIntroduction.html'};};
	function directiveEditionIngredientIntitule(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientIntitule.html'};};
	function directiveEditionIngredientTypePlat(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientTypeIngredient.html'};};	
	function directiveEditionIngredientCout(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientCout.html'};};	
	function directiveEditionIngredientImage(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientImage.html'};};	
	function directiveEditionIngredientConseils(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientConseils.html'};};	
	function directiveEditionIngredientFinalisation(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientFinalisation.html'};};

})();