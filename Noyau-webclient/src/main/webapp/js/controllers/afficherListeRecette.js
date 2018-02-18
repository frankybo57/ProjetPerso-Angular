(function(){

	angular.module('ControllerAfficherListeRecette', ['recettesScroll'])

	.controller('ControllerAfficherListeRecette', ControllerAfficherListeRecette);

	function ControllerAfficherListeRecette(RecetteHttpFactory,RecetteFactory,TypePlatFactory,UtilitaireFactory){
		var ctrl = this;

		ctrl.liste = [];
		ctrl.types = [];

		ctrl.calculTempsTotal = RecetteFactory.calculTempsTotal;
		ctrl.creerCollection = UtilitaireFactory.creerCollection;
		ctrl.listeRecettes = listeRecettes;
		ctrl.listeTypesPlats = listeTypesPlats;

		function listeTypesPlats() {
			TypePlatFactory.findAll()
			.then(
				function success(response) {
					ctrl.types = response.data;
				},
				function error(response) {

				}
			);
		}

		function listeRecettes(){

			RecetteHttpFactory.findAll()
			.then(
				function success(response) {
					ctrl.liste = response.data;
				},
				function error(response) {

				}
			);
		}

		ctrl.listeTypesPlats();
		ctrl.listeRecettes();
	}

})();
