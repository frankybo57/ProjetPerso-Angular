(function(){
	
	angular.module('recettesDirective',[])
	
	.directive('vueRecette', directiveVueRecette)
	.directive('navigationTableRecettes', directiveNavigationTableRecettes)
	.directive('navigationEditionRecette', directiveNavigationEditionRecette)	
	.directive('editionRecetteIntroduction', directiveEditionRecetteIntroduction)
	.directive('editionRecetteIntitule', directiveEditionRecetteIntitule)
	.directive('editionRecetteTypePlat', directiveEditionRecetteTypePlat)
	.directive('editionRecetteDifficulte', directiveEditionRecetteDifficulte)
	.directive('editionRecetteTempsPreparation', directiveEditionRecetteTempsPreparation)
	.directive('editionRecetteTempsRepos', directiveEditionRecetteTempsRepos)
	.directive('editionRecetteTempsCuisson', directiveEditionRecetteTempsCuisson)
	.directive('editionRecetteNombreCouverts', directiveEditionRecetteNombreCouverts)
	.directive('editionRecetteCout', directiveEditionRecetteCout)
	.directive('editionRecetteImage', directiveEditionRecetteImage)
	.directive('editionRecetteVideo', directiveEditionRecetteVideo)
	.directive('editionRecetteIngredients', directiveEditionRecetteIngredients)
	.directive('editionRecetteInstructions', directiveEditionRecetteInstructions)
	.directive('editionRecetteConseils', directiveEditionRecetteConseils)
	.directive('editionRecetteFinalisation', directiveEditionRecetteFinalisation);
	
	function directiveVueRecette(){return{restrict:'E',templateUrl:'templates/pages/recettes/vueRecette.html'};};
	function directiveNavigationTableRecettes(){return{restrict:'E',templateUrl:'templates/pages/recettes/liste-recettes/navigation.html'};};
	function directiveNavigationEditionRecette(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/navigation.html'};};
	function directiveEditionRecetteIntroduction(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteIntroduction.html'};};
	function directiveEditionRecetteIntitule(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteIntitule.html'};};
	function directiveEditionRecetteTypePlat(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteTypePlat.html'};};
	function directiveEditionRecetteDifficulte(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteDifficulte.html'};};
	function directiveEditionRecetteTempsPreparation(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteTempsPreparation.html'};};
	function directiveEditionRecetteTempsRepos(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteTempsRepos.html'};};
	function directiveEditionRecetteTempsCuisson(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteTempsCuisson.html'};};
	function directiveEditionRecetteNombreCouverts(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteNombreCouverts.html'};};
	function directiveEditionRecetteCout(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteCout.html'};};
	function directiveEditionRecetteImage(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteImage.html'};};
	function directiveEditionRecetteVideo(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteVideo.html'};};
	function directiveEditionRecetteIngredients(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteIngredients.html'};};
	function directiveEditionRecetteInstructions(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteInstructions.html'};};
	function directiveEditionRecetteConseils(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteConseils.html'};};
	function directiveEditionRecetteFinalisation(){return{restrict:'E',templateUrl:'templates/pages/recettes/edition-recette/editionRecetteFinalisation.html'};};
		
})();





