/**
Service authentification
*/

(function(){
	angular.module('AuthentificationService',[])
	.factory('AuthentificationFactory', serviceAuthentificationFactory);
	
	function serviceAuthentificationFactory($http){
		var utilisateurAuthentifie = null;
		
		return{
			estAuthentifie : function(utilisateur){
				return (utilisateur === utilisateurAuthentifie);
			},
			authentification : function(login, password){
				return $http({method : 'GET', url : 'api/utilisateur/code/' + login + ':' + password})
			},
		};
	};

})();