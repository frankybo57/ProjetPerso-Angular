/**
Service typePlat
*/

(function(){
	angular.module('TypeIngredientService',[])
	.factory('TypeIngredientFactory', serviceTypeIngredientFactory);
	
	function serviceTypeIngredientFactory($http){
		return{
			findAll : function(){
				return $http({method:"GET", url:'api/type-ingredient/liste/'})
			},
			findAllHierarchie : function(){
				return $http({method:"GET", url:'api/type-ingredient/liste/hierarchisee/'})
			},
			remove : function(id){
				return $http({method:"DELETE", url:'api/type-ingredient/' + id})
			},
		};
	};

})();