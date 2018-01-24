(function() {

	angular.module("ControllerNavigation", [])

	.controller('ControllerNavigation', ControllerNavigation);

	function ControllerNavigation(ModuleFactory){

		var ctrl = this;

		ctrl.onglet = "Accueil";
		ctrl.sousonglet = null;
		ctrl.modulesActifs = [];

		ctrl.listeActifs = function() {
			ModuleFactory.findAllActifs()
			.then(
					function success(response) {
						ctrl.modulesActifs = response.data; 
					}, 
					function error(response) {

					}
			);
		};

		ctrl.setOnglet = function(onglet){
			ctrl.onglet = onglet;
			ctrl.sousonglet = null;
		};

		ctrl.isOnglet = function(onglet){
			return ctrl.onglet === onglet;
		};

		ctrl.setSousOnglet = function(onglet,sousonglet){
			ctrl.onglet = onglet;
			ctrl.sousonglet = sousonglet;
		};

		ctrl.isSousOnglet = function(sousonglet){
			return ctrl.sousonglet === sousonglet;
		};

		ctrl.isActif = function(header){
			for(module of ctrl.modulesActifs){
				if(module.header === header)return true;
			}
			return false;
		}

		ctrl.listeActifs();
	};

})();