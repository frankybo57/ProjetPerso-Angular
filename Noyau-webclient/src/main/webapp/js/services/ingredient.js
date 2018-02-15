(function(){
	angular.module('IngredientService',[])
	/**
	 * Service ingredient
	 */
	.factory('IngredientFactory', serviceIngredientFactory);

	function serviceIngredientFactory($http){
		return{
			/**
			 * Renvoie la liste de tous les ingrédients en base.
			 * @return liste des ingredients.
			 */
			findAll : function(){
				return $http({method:"GET", url:'api/ingredients/liste/'})
			},
			/**
			 * Renvoie un ingrédient recherché par son identifiant.
			 * @param id
			 * @return ingredient.
			 */
			find : function(id){
				return $http({method:"GET", url:'api/ingredients/' + id})
			},
			/**
			 * Renvoie la liste de tous les ingrédients d'un type d'ingrédient passé en paramètre.
			 * @param typeIngredient.
			 * @return liste des ingredients.
			 */
			findAllByTypeIngredient : function(typeIngredient){
				return $http({method:"GET", url:'api/ingredients/', data: typeIngredient})
			},
			/**
			 * Renvoie la liste de tous les ingrédients nécessaires à la réalisation d'une recette passée en paramètre.
			 * @param recette.
			 * @return liste des ingredients.
			 */
			findAllByRecette : function(recette){
				return $http({method:"GET", url:'api/ingredients/', data: recette})
			},
			/**
			 * Renvoie la liste de tous les ingrédients nécessaires d'un niveau de prix passé en paramètre.
			 * @param cout.
			 * @return liste des ingredients.
			 */
			findAllByPrix : function(cout){
				return $http({method:"GET", url:'api/ingredients/' + cout})
			},
			/**
			 * Crée une recette passée en paramètre.
			 * @param recette.
			 * @return recette sauvegardée.
			 */
			create : function(recette){
				return $http({method:"POST", url:'api/ingredient', data: utilisateur})
			},
			/**
			 * Modifie une recette passée en paramètre qui est déjà sauvegardée en base.
			 * @param recette.
			 * @return recette mise à jour.
			 */
			update : function(recette){
				return $http({method:"PUT", url:'api/ingredient', data: utilisateur})
			},
			/**
			 * Supprime une recette dont l'identifiant est passé en paramètre.
			 * @param id.
			 */
			supprimer : function(id){
				return $http({method:"DELETE", url:'api/ingredients/' + id})
			},
		};
	}

})();
