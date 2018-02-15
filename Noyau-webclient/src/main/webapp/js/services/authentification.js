(function(){
	angular.module('AuthentificationService',[])
	/**
	 *	Service authentification
	 */
	.factory('AuthentificationFactory', serviceAuthentificationFactory);

	function serviceAuthentificationFactory($http){
		var utilisateurAuthentifie = null;

		return{
			/**
			 * Teste si l'utilisateur passé en paramètre est authentifié.
			 * @param utilisateur
			 * @return boolean
			 */
			estAuthentifie : function(utilisateur){
				return (utilisateur === utilisateurAuthentifie);
			},
			/**
			 * Essai d'authentification à partir du login et du mot de passe d'un utilisateur.
			 * @param login
			 * @param password
			 * @return utilisateurConnecte
			 */
			authentification : function(login, password){
				return $http({method : 'GET', url : 'api/utilisateur/code/' + login + ':' + password})
			},
		};
	}

})();
