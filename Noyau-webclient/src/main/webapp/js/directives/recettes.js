(function(){
	
	angular.module('recettesDirective',[])
	
	.directive('tableRecettes', directiveTableRecettes)
	.directive('vueRecette', directiveVueRecette)
	.directive('navigationTableRecettes', directiveNavigationTableRecettes)
	.directive('navigationEditionRecette', directiveNavigationEditionRecette)	
	.directive('editionRecette', directiveEditionRecette)
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
	
	function directiveTableRecettes(){return{restrict:'E',templateUrl:'templates/pages/recettes/tableRecettes.html'};};
	function directiveVueRecette(){return{restrict:'E',templateUrl:'templates/pages/recettes/vueRecette.html'};};
	function directiveNavigationTableRecettes(){return{restrict:'E',templateUrl:'templates/pages/recettes/navigationTableRecettes.html'};};
	function directiveNavigationEditionRecette(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/navigationEditionRecette.html'};};
	function directiveEditionRecette(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecette.html'};};
	function directiveEditionRecetteIntroduction(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteIntroduction.html'};};
	function directiveEditionRecetteIntitule(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteIntitule.html'};};
	function directiveEditionRecetteTypePlat(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteTypePlat.html'};};
	function directiveEditionRecetteDifficulte(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteDifficulte.html'};};
	function directiveEditionRecetteTempsPreparation(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteTempsPreparation.html'};};
	function directiveEditionRecetteTempsRepos(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteTempsRepos.html'};};
	function directiveEditionRecetteTempsCuisson(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteTempsCuisson.html'};};
	function directiveEditionRecetteNombreCouverts(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteNombreCouverts.html'};};
	function directiveEditionRecetteCout(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteCout.html'};};
	function directiveEditionRecetteImage(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteImage.html'};};
	function directiveEditionRecetteVideo(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteVideo.html'};};
	function directiveEditionRecetteIngredients(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteIngredients.html'};};
	function directiveEditionRecetteInstructions(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteInstructions.html'};};
	function directiveEditionRecetteConseils(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteConseils.html'};};
	function directiveEditionRecetteFinalisation(){return{restrict:'E',templateUrl:'templates/pages/recettes/editionRecette/editionRecetteFinalisation.html'};};
		
})();





