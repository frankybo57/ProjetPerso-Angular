(function(){
	
	admin = angular.module("pageAdmin", []);
	
	admin.directive("pageAdmin",function(){
		return{
			restrict:'E',
			templateUrl:'admin/page-admin.html',
			controller:'ModuleController',
			controllerAs:'moduleCtrl'
		};
	});
	
	admin.controller("UtilisateurController",function(){
		this.utilisateurs = [
			{
				"id" : 1,
				"login" : "Admin",
				"password" : "Passwort",
				"droits" : "admin"
			}
		];
		
		this.isUser = function(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return true;
			}
			return false;
		};

		this.getUserByLogin = function(login){
			for(var utilisateur of utilisateurs){
				if(utilisateur.login === login)return utilisateur;
			}
			return null;
		};
	});
	
	
})();
