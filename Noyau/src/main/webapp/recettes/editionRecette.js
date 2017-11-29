(function(){
	
	var edi = angular.module('editionRecette',[])
	
	edi.directive('editionRecette', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/editionRecette.html'
		}
	});	
})();