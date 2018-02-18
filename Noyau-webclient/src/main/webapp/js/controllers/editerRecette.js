(function(){

	angular.module('ControllerEditerRecette',[])

	.controller('ControllerEditerRecette',ControllerEditerRecette);

	function ControllerEditerRecette(TypePlatFactory,RecetteFactory,UtilitaireFactory){
		var ctrl = this;

		ctrl.typesPlats = [];
		ctrl.recetteTemp = {};
		ctrl.editionTab = 'introduction';

		ctrl.addRecette = addRecette;
		ctrl.calculTempsTotal = RecetteFactory.calculTempsTotal;
		ctrl.creerCollection = UtilitaireFactory.creerCollection;
		ctrl.isOngletEdition = isOngletEdition;
		ctrl.listeTypesPlats = listeTypesPlats;
		ctrl.setOngletEdition = setOngletEdition;

		function addRecette(){
			ctrl.recetteTemp = {};
		}

		function isOngletEdition(tab){return ctrl.editionTab===tab;}

		function listeTypesPlats() {
			TypePlatFactory.findAll()
			.then(function success(response) {
				ctrl.typesPlats = response.data;
			}, function error(response) {

			});
		}

		function setOngletEdition(tab){ctrl.editionTab=tab;}

		ctrl.listeTypesPlats();
	}
})();
