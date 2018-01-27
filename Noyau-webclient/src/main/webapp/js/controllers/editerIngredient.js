(function(){
	
	angular.module('ControllerEditerIngredient',[])
	
	.controller('ControllerEditerIngredient', ControllerEditerIngredient);
	
	function ControllerEditerIngredient(TypeIngredientFactory,IngredientFactory,$routeParams){
		var ctrl = this;
		
		// Variables d'instance
		ctrl.types = [];
		ctrl.temp = {};
		ctrl.editionTab;
		
		// Méthodes
		ctrl.creer = creer;
		ctrl.creerCollection=function(entier){var collection=[];for(var i=1;i<=entier;i++){collection.push(i);}return collection;};
		ctrl.initialisation = initialisation;
		ctrl.isOngletEdition=function(tab){return ctrl.editionTab===tab;};
		ctrl.listeTypesIngredients = listeTypesIngredients;
		ctrl.save = save;
		ctrl.setOngletEdition=function(tab){ctrl.editionTab=tab;};
		

		
		function creer(){
			ctrl.temp = {};
		};
		
		function initialisation(){
			ctrl.listeTypesIngredients();
			ctrl.editionTab = 'introduction';
			if($routeParams.id === null){
				ctrl.temp = {};
			}
			else{
				IngredientFactory.find($routeParams.id)
				.then(function success(response) {
					ctrl.temp = response.data; 
				}, function error(response) {

				});
			}
			
		};
		
		function listeTypesIngredients() {
			TypeIngredientFactory.findAll()
			.then(function success(response) {
				ctrl.types = response.data; 
			}, function error(response) {

			});
		};
		
		function save(){
			
		};
		
		// Initialisation
		ctrl.listeTypesIngredients();
	};
})();