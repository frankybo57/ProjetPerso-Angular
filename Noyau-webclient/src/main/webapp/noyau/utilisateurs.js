(function(){
	
	var uti = angular.module('utilisateurs', []);
	
	uti.controller("UtilisateurController",function(){
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
	});
		
})();