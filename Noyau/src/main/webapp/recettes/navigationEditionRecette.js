(function(){
	
	var nav = angular.module('navigationEditionRecette',[])
	
	nav.directive('navigationEditionRecette', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/navigationEditionRecette.html'
		}
	});	
})();