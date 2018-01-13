(function(){
	
	var tab = angular.module('tableRecettes',[])
	
	tab.directive('tableRecettes', function(){
		return{
			restrict:'E',
			templateUrl:'recettes/tableRecettes.html'
		}
	});	
})();