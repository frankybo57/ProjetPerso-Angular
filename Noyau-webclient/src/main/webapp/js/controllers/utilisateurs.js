(function(){

	angular.module('utilisateurs', ['ValueUtilisateurConnecte'])

	.controller("UtilisateurController", UtilisateurController);

	function UtilisateurController(utilisateurConnecte){
		var ctrl = this;

		ctrl.changerLogin = null;
		ctrl.changerPassword = null;

		ctrl.loginForm;
		ctrl.passwordForm;

		ctrl.fermerOngletChangerLogin = fermerOngletChangerLogin;
		ctrl.fermerOngletChangerMdP =fermerOngletChangerMdP;
		ctrl.getDroits = getDroits;
		ctrl.getLogin = getLogin;
		ctrl.initialisation = initialisation;
		ctrl.isUser = isUser;
		ctrl.getUserByLogin = getUserByLogin;
		ctrl.ouvrirOngletChangerLogin = ouvrirOngletChangerLogin;
		ctrl.ouvrirOngletChangerMdP = ouvrirOngletChangerMdP;
		ctrl.toogleLogin = toogleLogin;
		ctrl.tooglePassword = tooglePassword;

		function getDroits(){return utilisateurConnecte.droits;}
		function getLogin(){return utilisateurConnecte.login;}

		function fermerOngletChangerLogin(){
			ctrl.changerLogin = false;
		}

		function fermerOngletChangerMdP(){
			ctrl.changerPassword = false;
		}

		function initialisation(){
			ctrl.fermerOngletChangerLogin();
			ctrl.fermerOngletChangerMdP();
		}

		function isUser(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return true;
			}
			return false;
		}

		function getUserByLogin(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return utilisateur;
			}
			return null;
		}

		function ouvrirOngletChangerLogin(){
			if(ctrl.changerLogin)fermerOngletChangerLogin();
			else{
				if(ctrl.changerPassword) ctrl.fermerOngletChangerMdP();
				ctrl.changerLogin = true;
				ctrl.loginForm.utilisateur = utilisateurConnecte;
			}
		}

		function ouvrirOngletChangerMdP(){
			if(ctrl.changerPassword) ctrl.fermerOngletChangerMdP();
			else{
				if(ctrl.changerLogin) ctrl.fermerOngletChangerLogin();
				ctrl.changerPassword = true;
			}
		}

		function toogleLogin(){
			ctrl.changerLogin = !ctrl.changerLogin;
			ctrl.loginForm.$setPristine;
		}

		function tooglePassword(){
			ctrl.changerPassword = !ctrl.changerPassword;
			ctrl.passwordForm.$setPristine;
		}

		ctrl.initialisation();
	}

})();
