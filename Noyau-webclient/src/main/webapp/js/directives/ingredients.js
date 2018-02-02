(function(){

	angular.module('ingredientsDirective',[])
	.directive('vueIngredient', directiveVueIngredient)
	.directive('navigationTableIngredients', directiveNavigationTableIngredients)
	.directive('navigationEditionIngredient', directiveNavigationEditionIngredient)
	.directive('editionIngredientIntroduction', directiveEditionIngredientIntroduction)
	.directive('editionIngredientIntitule', directiveEditionIngredientIntitule)
	.directive('editionIngredientTypeIngredient', directiveEditionIngredientTypeIngredient)
	.directive('editionIngredientCout', directiveEditionIngredientCout)
	.directive('editionIngredientImage', directiveEditionIngredientImage)
	.directive('editionIngredientConseils', directiveEditionIngredientConseils)
	.directive('editionIngredientFinalisation', directiveEditionIngredientFinalisation)

	function directiveVueIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/vue-ingredient.html'};}
	function directiveNavigationTableIngredients(){return{restrict:'E',templateUrl:'templates/pages/recettes/liste-ingredients/navigation.html'};}
	function directiveNavigationEditionIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/navigation.html'};}
	function directiveEditionIngredientIntroduction(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientIntroduction.html'};}
	function directiveEditionIngredientIntitule(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientIntitule.html'};}
	function directiveEditionIngredientTypeIngredient(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientTypeIngredient.html'};}
	function directiveEditionIngredientCout(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientCout.html'};}
	function directiveEditionIngredientImage(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientImage.html'};}
	function directiveEditionIngredientConseils(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientConseils.html'};}
	function directiveEditionIngredientFinalisation(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-ingredient/editionIngredientFinalisation.html'};}

})();
