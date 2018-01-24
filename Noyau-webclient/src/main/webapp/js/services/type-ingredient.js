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
		};
	};

})();