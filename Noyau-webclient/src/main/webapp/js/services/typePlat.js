/**
Service typePlat
*/

(function(){
	angular.module('TypePlatService',[])
	.factory('TypePlatFactory', serviceTypePlatFactory);
	
	function serviceTypePlatFactory($http){
		return{
			findAll : function(){
				return $http({method:"GET", url:'api/typesPlats/'})
			},
		};
	};

})();