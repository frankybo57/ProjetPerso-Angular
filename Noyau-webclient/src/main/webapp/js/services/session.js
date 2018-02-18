/**
* Service session
*/

(function(){
	angular.module('SessionService',[])
	.factory('SessionFactory', serviceSessionFactory);

	function serviceSessionFactory(){
		var serv = this;

		serv.utilisateur = {
				id:null,
				version:null,
				login:null,
				password:null,
				droits:null,
		}

		return{
			setUtilisateur : function(utilisateur){
				serv.utilisateur.id = utilisateur.id;
				serv.utilisateur.version = utilisateur.version;
				serv.utilisateur.login = utilisateur.login;
				serv.utilisateur.password = utilisateur.password;
				serv.utilisateur.droits = utilisateur.droits;
			},
			clearUtilisateur : function(){
				serv.utilisateur.id = null;
				serv.utilisateur.version = null;
				serv.utilisateur.login = null;
				serv.utilisateur.password = null;
				serv.utilisateur.droits = null;
			},
			getUtilisateur : function(){
				return serv.utilisateur;
			},
			getLogin : function(){
				return serv.utilisateur.login;
			},
			getDroits : function(){
				return serv.utilisateur.droits;
			}
		};
	}

})();

