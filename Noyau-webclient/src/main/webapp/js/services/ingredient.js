/**
Service ingredient
*/

(function(){
	angular.module('IngredientService',[])
	.factory('IngredientFactory', serviceIngredientFactory);

	function serviceIngredientFactory($http){
		return{
			findAll : function(){
				return $http({method:"GET", url:'api/ingredients/liste/'})
			},
			find : function(id){
				return $http({method:"GET", url:'api/ingredients/' + id})
			},
			findAllByTypeIngredient : function(typeIngredient){
				return $http({method:"GET", url:'api/ingredients/', data: typeIngredient})
			},
			findAllByTypeRecette : function(recette){
				return $http({method:"GET", url:'api/ingredients/', data: recette})
			},
			findAllByPrix : function(cout){
				return $http({method:"GET", url:'api/ingredients/' + cout})
			},
			create : function(recette){
				return $http({method:"POST", url:'api/ingredient', data: utilisateur})
			},
			update : function(recette){
				return $http({method:"PUT", url:'api/ingredient', data: utilisateur})
			},
			supprimer : function(id){
				return $http({method:"DELETE", url:'api/ingredients/' + id})
			},
		};
	}

})();
