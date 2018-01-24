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
			create : function(utilisateur){
				return $http({method:"POST", url:"api/utilisateur", data: utilisateur});
			}
		};
	};

})();