(function(){
	
	var edi = angular.module('editionRecette',[])
	
	edi.directive('editionRecette', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette.html'
		};
	});	
	
	edi.directive('editionRecetteIntroduction',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteIntroduction.html'
		};
	});
	
	edi.directive('editionRecetteIntitule',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteIntitule.html'
		};
	});
	
	edi.directive('editionRecetteTypePlat',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteTypePlat.html'
		};
	});
	
	edi.directive('editionRecetteDifficulte',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteDifficulte.html'
		};
	});
	
	edi.directive('editionRecetteTempsPreparation',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteTempsPreparation.html'
		};
	});
	
	edi.directive('editionRecetteTempsCuisson',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteTempsCuisson.html'
		};
	});
	
	edi.directive('editionRecetteNombreCouverts',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteNombreCouverts.html'
		};
	});
	
	edi.directive('editionRecetteCout',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteCout.html'
		};
	});
	
	edi.directive('editionRecetteImage',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteImage.html'
		};
	});
	
	edi.directive('editionRecetteVideo',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteVideo.html'
		};
	});
	
	edi.directive('editionRecetteIngredients',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteIngredients.html'
		};
	});
	
	edi.directive('editionRecetteInstructions',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteInstructions.html'
		};
	});
	
	edi.directive('editionRecetteConseils',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteConseils.html'
		};
	});
	
	edi.directive('editionRecetteFinalisation',function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecetteFinalisation.html'
		};
	});
})();