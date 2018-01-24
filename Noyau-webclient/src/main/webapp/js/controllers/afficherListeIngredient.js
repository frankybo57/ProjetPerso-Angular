(function(){
	
	angular.module('ControllerAfficherListeIngredient',['ingredientsScroll'])
	
	.controller('ControllerAfficherListeIngredient',ControllerAfficherListeIngredient);
	
	function ControllerAfficherListeIngredient(TypeIngredientFactory,IngredientFactory){
		var ctrl = this;
		
		ctrl.types = [];
		ctrl.liste = [];
		
		ctrl.listeTypesIngredients = function() {
			TypeIngredientFactory.findAll()
			.then(
				function success(response) {
					ctrl.types = response.data; 
				}, 
				function error(response) {

				}
			);
		};
		
		ctrl.listeIngredients = function(){
			
			IngredientFactory.findAll()
			.then(
				function success(response) {
					ctrl.liste = response.data; 
				}, 
				function error(response) {

				}
			);
		}
		
		ctrl.creerCollection=function(entier){var collection=[];for(var i=1;i<=entier;i++){collection.push(i);}return collection;};
		
		ctrl.listeTypesIngredients();
		ctrl.listeIngredients();
		
		
	};
})();