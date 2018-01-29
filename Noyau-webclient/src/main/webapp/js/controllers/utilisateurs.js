(function(){
	
	angular.module('utilisateurs', [])
	
	.controller("UtilisateurController", UtilisateurController);
	
	function UtilisateurController(utilisateurConnecte){
		var ctrl = this;
		
		ctrl.changerLogin = null;
		ctrl.changerPassword = null;
		
		ctrl.loginForm;
		ctrl.passwordForm;
		
		ctrl.getDroits = getDroits;
		ctrl.getLogin = getLogin;
		ctrl.initialisation = initialisation;
		ctrl.isUser = isUser;
		ctrl.getUserByLogin = getUserByLogin;
		ctrl.toogleLogin = toogleLogin;
		ctrl.tooglePassword = tooglePassword;
		
		
		function getDroits(){return utilisateurConnecte.droits;};
		function getLogin(){return utilisateurConnecte.login;};
		
		function initialisation(){
			ctrl.changerLogin = false;
			ctrl.changerPassword = false;
		};
		
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
		
		function toogleLogin(){
			ctrl.changerLogin = !ctrl.changerLogin;
			ctrl.loginForm.$setPristine;
		};
		
		function tooglePassword(){
			ctrl.changerPassword = !ctrl.changerPassword;
			ctrl.passwordForm.$setPristine;
		};
		
		ctrl.initialisation();
	};
		
})();