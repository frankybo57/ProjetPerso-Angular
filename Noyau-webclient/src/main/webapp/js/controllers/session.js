(function(){

	angular.module('sessionController',[])
	.controller('SessionController', SessionController);

	function SessionController(UtilisateurFactory,SessionFactory){
		var ctrl = this;

		// Variables
		ctrl.creation = false;
		ctrl.droits = null;
		ctrl.utilisateur = {};
		ctrl.utilisateurTemporaireLogin = null;
		ctrl.utilisateurTemporaireCreation = null;
		ctrl.utilisateurNonTrouve = false;

		// Méthodes
		ctrl.connexion = connexion;
		ctrl.creerUtilisateur = creerUtilisateur;
		ctrl.deconnexion = deconnexion;
		ctrl.effacer = effacer;
		ctrl.getDroits = SessionFactory.getDroits;
		ctrl.retourConnexion = retourConnexion;
		ctrl.saveUtilisateur = saveUtilisateur;

		// Implémentation
		function connexion(){
			UtilisateurFactory.findOneCode(ctrl.utilisateurTemporaireLogin.login,ctrl.utilisateurTemporaireLogin.password)
			.then(function success(response) {
				ctrl.utilisateur = response.data;

				SessionFactory.setUtilisateur(response.data);

				ctrl.droits = ctrl.utilisateur.droits;
				ctrl.utilisateurNonTrouve = false;
				ctrl.utilisateurTemporaireLogin = null;
			}, function error(response) {
				ctrl.utilisateurNonTrouve = true;
			});
		}

		function creerUtilisateur(){
			if(!ctrl.creation){
				ctrl.creation = true;
				ctrl.utilisateurTemporaireCreation = {};
				ctrl.utilisateurCreationForm.$setPristine();
			}
			else{
				ctrl.creation = false;
			}
		}

		function deconnexion(){
			ctrl.utilisateur = null;

			SessionFactory.clearUtilisateur();

			ctrl.utilisateurTemporaireCreation = null;
			ctrl.utilisateurTemporaireLogin = null;
			ctrl.droits = null;
			ctrl.utilisateurForm.$setPristine();
			ctrl.utilisateurCreationForm.$setPristine();
		}

		function effacer(){
			ctrl.utilisateurTemporaireLogin = {};
			ctrl.utilisateurForm.$setPristine();
			ctrl.utilisateurNonTrouve = false;
		}

		function retourConnexion(){
			ctrl.creation = false;
			ctrl.utilisateurTemporaireCreation = null;
			ctrl.utilisateurTemporaireCreation = {};
			ctrl.utilisateurForm.$setPristine();
			ctrl.utilisateurCreationForm.$setPristine();
		}

		function saveUtilisateur(){
			UtilisateurFactory.createCode(ctrl.utilisateurTemporaireCreation)
			.then(function success(response) {
				ctrl.utilisateur = response.data;

				SessionFactory.setUtilisateur();

				ctrl.droits = ctrl.utilisateur.droits;
				ctrl.utilisateurTemporaireCreation = null;
				ctrl.utilisateurNonTrouve = false;
			}, function error(response) {
				ctrl.utilisateurNonTrouve = true;
			});
		}
	}
})();
