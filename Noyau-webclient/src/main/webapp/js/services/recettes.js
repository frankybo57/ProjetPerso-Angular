/**
Service recettes
*/

(function(){
	angular.module('RecetteService',[])
	.factory('RecetteFactory', serviceRecetteFactory);
	
	function serviceRecetteFactory($http){
		return{
			findAll : function(){
				return $http({method:"GET", url:'api/recettes/liste/'})
			},
			findAllByTypePlat : function(typePlat){
				return $http({method:"GET", url:'api/recettes/', data: typePlat})
			},
			findAllByIngredient : function(ingredient){
				return $http({method:"GET", url:'api/recettes/', data: ingredient})
			},
			findAllByDifficulte : function(difficulte){
				return $http({method:"GET", url:'api/recettes/' + difficulte})
			},
			create : function(recette){
				return $http({method:"POST", url:'api/recette', data: utilisateur})
			}
		};
	};

})();