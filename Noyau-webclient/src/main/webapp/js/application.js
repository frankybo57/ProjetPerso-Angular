(function(){

	angular.module('application',
			[
				/* Librairies */
				'ngRoute',

				/* Constantes */

				/* Controllers */
				'ControllerAfficherListeIngredient',
				'ControllerAfficherListeModules',
				'ControllerAfficherListeRecette',
				'ControllerAfficherListeUtilisateurs',
				'ControllerEditerIngredient',
				'ControllerEditerRecette',
				'ControllerNavigation',
				'sessionController',

				/* Directives */
				'ingredientsDirective',
				'navigationDirective',
				'recettesDirective',
				'sessionDirective',

				/* Services */
				'IngredientService',
				'ModuleService',
				'RecetteService',
				'TypeIngredientService',
				'TypePlatService',
				'UtilisateurService',
				'UtilitaireService',

				/* Values */
				'ValueIngredientEdite',
				'ValueUtilisateurConnecte',

				'utilisateurs',
				]);

})();





