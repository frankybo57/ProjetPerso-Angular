(function(){
	
	angular.module('utilisateurs', [])
	
	.controller("UtilisateurController", UtilisateurController);
	
	function UtilisateurController(){
		var ctrl = this;
		
		ctrl.utilisateurs = [];
		ctrl.isUser = isUser;
		ctrl.getUserByLogin = getUserByLogin;
		
		function isUser(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return true;
			}
			return false;
		};

		function getUserByLogin(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return utilisateur;
			}
			return null;
		};
	};
		
})();