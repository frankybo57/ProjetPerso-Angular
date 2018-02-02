/**
Service utilisateur
*/

(function(){
	angular.module('UtilisateurService',[])
	.factory('UtilisateurFactory', serviceUtilisateurFactory);

	function serviceUtilisateurFactory($http){
		return{
			findAll : function(){
				return $http({method:"GET", url:"api/utilisateur/liste"});
			},
			findOne : function(login, password){
				return $http({method:"GET", url:"api/utilisateur/"+login+":"+password});
			},
			findOneCode : function(login, password){
				return $http({method:"GET", url:"api/utilisateur/code/"+login+":"+password});
			},
			create : function(utilisateur){
				return $http({method:"POST", url:"api/utilisateur", data: utilisateur});
			},
			createCode : function(utilisateur){
				return $http({method:"POST", url:"api/utilisateur/code/", data: utilisateur});
			},
			update : function(utilisateur){
				return $http({method:"PUT", url:"api/utilisateur", data: utilisateur});
			},
			updateCode : function(utilisateur){
				return $http({method:"PUT", url:"api/utilisateur/code/", data: utilisateur});
			},
			supprimer : function(id){
				return $http({method:"DELETE", url:"api/utilisateur/"+id});
			},
		};
	}

})();
