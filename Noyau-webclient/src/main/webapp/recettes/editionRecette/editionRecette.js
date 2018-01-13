(function(){
	
	var edi = angular.module('editionRecette',[])
	
	edi.directive('editionRecette', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecette.html'
		};
	});	
	
	edi.directive('editionRecetteIntroduction',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteIntroduction.html'
		};
	});
	
	edi.directive('editionRecetteIntitule',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteIntitule.html'
		};
	});
	
	edi.directive('editionRecetteTypePlat',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteTypePlat.html'
		};
	});
	
	edi.directive('editionRecetteDifficulte',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteDifficulte.html'
		};
	});
	
	edi.directive('editionRecetteTempsPreparation',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteTempsPreparation.html'
		};
	});
	
	edi.directive('editionRecetteTempsRepos',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteTempsRepos.html'
		};
	});
	
	edi.directive('editionRecetteTempsCuisson',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteTempsCuisson.html'
		};
	});
	
	edi.directive('editionRecetteNombreCouverts',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteNombreCouverts.html'
		};
	});
	
	edi.directive('editionRecetteCout',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteCout.html'
		};
	});
	
	edi.directive('editionRecetteImage',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteImage.html'
		};
	});
	
	edi.directive('editionRecetteVideo',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteVideo.html'
		};
	});
	
	edi.directive('editionRecetteIngredients',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteIngredients.html'
		};
	});
	
	edi.directive('editionRecetteInstructions',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteInstructions.html'
		};
	});
	
	edi.directive('editionRecetteConseils',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteConseils.html'
		};
	});
	
	edi.directive('editionRecetteFinalisation',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette/editionRecetteFinalisation.html'
		};
	});
})();