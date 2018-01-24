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
			create : function(recette){
				return $http({method:"POST", url:'api/recette', data: utilisateur})
			}
		};
	};

})();