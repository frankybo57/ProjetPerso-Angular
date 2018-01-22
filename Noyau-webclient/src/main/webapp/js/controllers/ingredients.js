/**
 * ListeIngredientController
 */

(function(){
	
	angular.module('listeIngredientsController',[])
	
	.controller('ListeIngredientsController', ListeIngredientsController);
	
	function ListeIngredientsController($http){
		var self = this;
		
		self.listeIngredients = [];
		
		self.liste = function() {
			$http({
				method : 'GET',
				url : 'api/ingredients/'
			}).then(function success(response) {
				self.listeIngredients = response.data; 
			}, function error(response) {

			});
		};
		
		self.liste();
	}
		
})();





