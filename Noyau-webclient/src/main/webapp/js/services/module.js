(function(){
	angular.module('ModuleService',[])
	/**
	 * Service module
	 */
	.factory('ModuleFactory', serviceModuleFactory);

	function serviceModuleFactory($http){
		return{
			findAll : function(){
				return $http({method:"GET", url:'api/modules'})
			},
			findOne : function(id){
				return $http({method:"GET", url:'api/modules/' + id})
			},
			findAllActifs : function(){
				return $http({method:"GET", url:'api/modules/actifs'})
			},
			findAllOrderById : function(){
				return $http({method:"GET", url:'api/modulesbyid'})
			},
			create : function(module){
				return $http({method:"POST", url:'api/modules', data: module})
			},
			update : function(module){
				return $http({method:"PUT", url:'api/modules', data: module})
			},
			remove : function(id){
				return $http({method:"DELETE", url:'api/modules/' + id})
			},
			findAllEtats : function(){
				return $http({method:"GET", url:'api/modules/etats'})
			},
		};
	}

})();
