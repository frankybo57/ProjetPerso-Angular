(function(){
	
	angular.module('utilisateurs', [])
	
	.controller("UtilisateurController", UtilisateurController);
	
	function UtilisateurController(){
		var self = this;
		
		self.utilisateurs = [];
		
		self.isUser = function(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return true;
			}
			return false;
		};

		self.getUserByLogin = function(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return utilisateur;
			}
			return null;
		};
	};
		
})();