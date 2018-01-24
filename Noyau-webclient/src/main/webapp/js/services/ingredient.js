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
			create : function(recette){
				return $http({method:"POST", url:'api/ingredient', data: utilisateur})
			}
		};
	};

})();