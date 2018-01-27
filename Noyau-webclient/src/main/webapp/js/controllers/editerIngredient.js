(function(){
	
	angular.module('ControllerEditerIngredient',[])
	
	.controller('ControllerEditerIngredient', ControllerEditerIngredient);
	
	function ControllerEditerIngredient(TypeIngredientFactory){
		var ctrl = this;
		
		// Variables d'instance
		ctrl.types = [];
		ctrl.temp = {};
		ctrl.editionTab = 'introduction';
		
		// Méthodes
		ctrl.listeTypesIngredients = function() {
			TypeIngredientFactory.findAll()
			.then(function success(response) {
				ctrl.types = response.data; 
			}, function error(response) {

			});
		};
		
		ctrl.initialistialisation = function(){
			ctrl.listeTypesIngredients();
			ctrl.editionTab = 'introduction';
			ctrl.temp = {};
		};
		
		ctrl.creer = function(){
			
		};
		
		ctrl.save = function(){
			
		};
		
		ctrl.setOngletEdition=function(tab){ctrl.editionTab=tab;};
		ctrl.isOngletEdition=function(tab){return ctrl.editionTab===tab;};
		ctrl.creerCollection=function(entier){var collection=[];for(var i=1;i<=entier;i++){collection.push(i);}return collection;};
		
		// Initialisation
		ctrl.listeTypesIngredients();
	};
})();