(function(){

	angular.module('ControllerAfficherListeIngredient',['ingredientsScroll'])

	.controller('ControllerAfficherListeIngredient',ControllerAfficherListeIngredient);

	function ControllerAfficherListeIngredient(TypeIngredientFactory,IngredientFactory,ingredientEdite,UtilitaireFactory){
		var ctrl = this;

		ctrl.initialise = false;
		ctrl.types = [];
		ctrl.liste = [];

		ctrl.creer = creer;
		ctrl.creerCollection = UtilitaireFactory.creerCollection;
		ctrl.editer = editer;
		ctrl.initialisation = initialisation;
		ctrl.listeTypesIngredients = listeTypesIngredients;
		ctrl.listeIngredients = listeIngredients;
		ctrl.supprimer = supprimer;


		function creer(){

		}

		function editer(ingredient){
			ingredientEdite.id = ingredient.id;
			ingredientEdite.version = ingredient.version;
			ingredientEdite.label = ingredient.label;
			ingredientEdite.utilisateur = ingredient.utilisateur;
			ingredientEdite.prive = ingredient.prive;
			ingredientEdite.cout = ingredient.cout;
			ingredientEdite.typeIngredient.id = ingredient.typeIngredient.id;
		}

		function initialisation() {
			if(!ctrl.initialise){
				ctrl.listeTypesIngredients();
				ctrl.listeIngredients();
			}
		}

		function listeTypesIngredients() {
			TypeIngredientFactory.findAllHierarchie()
			.then(
				function success(response) {
					ctrl.types = response.data
				},
				function error(response) {

				}
			);
		}

		function listeIngredients(){

			IngredientFactory.findAll()
			.then(
				function success(response) {
					ctrl.liste = response.data;
				},
				function error(response) {

				}
			);
		}

		function supprimer(id){
			IngredientFactory.supprimer(id)
			.then(
				function success(response) {
					ctrl.listeIngredients();
				},
				function error(response) {

				}
			);

		}

		ctrl.initialisation();

	}
})();
