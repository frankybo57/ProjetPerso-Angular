(function() {

	angular.module("ControllerNavigation", [])

	.controller('ControllerNavigation', ControllerNavigation);

	function ControllerNavigation(ModuleFactory,utilisateurConnecte){

		var ctrl = this;

		// Variables d'instance
		ctrl.onglet = null;
		ctrl.sousonglet = null;
		ctrl.modulesActifs = [];

		// Méthodes de classe
		ctrl.getDroitsUtilisateur = getDroitsUtilisateur;
		ctrl.initialisation = initialisation;
		ctrl.isActif = isActif;
		ctrl.isOnglet = isOnglet;
		ctrl.isSousOnglet = isSousOnglet;
		ctrl.listeActifs = listeActifs;
		ctrl.setOnglet = setOnglet;
		ctrl.setSousOnglet = setSousOnglet;

		// Implémentation
		function getDroitsUtilisateur(){
			return utilisateurConnecte.droits;
		}

		function initialisation(){
			ctrl.listeActifs();
			ctrl.onglet = "Accueil";
			ctrl.sousonglet = null;
		}

		function listeActifs() {
			ModuleFactory.findAllActifs()
			.then(
					function success(response) {
						ctrl.modulesActifs = response.data;
					},
					function error(response) {

					}
			);
		}

		function isActif(header){
			for(module of ctrl.modulesActifs){
				if(module.header === header)return true;
			}
			return false;
		}

		function isOnglet(onglet){
			return ctrl.onglet === onglet;
		}

		function isSousOnglet(sousonglet){
			return ctrl.sousonglet === sousonglet;
		}

		function setOnglet(onglet){
			ctrl.onglet = onglet;
			ctrl.sousonglet = null;
		}

		function setSousOnglet(onglet,sousonglet){
			ctrl.onglet = onglet;
			ctrl.sousonglet = sousonglet;
		}

		ctrl.initialisation();
	}

})();
