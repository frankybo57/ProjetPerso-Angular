(function(){

	angular.module('ControllerEditerRecette',[])

	.controller('ControllerEditerRecette',ControllerEditerRecette);

	function ControllerEditerRecette(TypePlatFactory,UtilitaireFactory){
		var ctrl = this;

		ctrl.typesPlats = [];
		ctrl.recetteTemp = {};
		ctrl.editionTab = 'introduction';

		ctrl.addRecette = addRecette;
		ctrl.calculTempsTotal = calculTempsTotal;
		ctrl.creerCollection = UtilitaireFactory.creerCollection;
		ctrl.isOngletEdition = isOngletEdition;
		ctrl.gestionTempsCuisson = gestionTempsCuisson;
		ctrl.gestionTempsPreparation = gestionTempsPreparation;
		ctrl.gestionTempsRepos = gestionTempsRepos;
		ctrl.listeTypesPlats = listeTypesPlats;
		ctrl.setOngletEdition = setOngletEdition;

		function addRecette(){
			ctrl.recetteTemp = {};
		}

		function calculTempsTotal(recette){
			var retour={
					'min': "",
					'h' : "",
					'j' : ""
			};

			ctrl.gestionTempsPreparation(recette, retour)

			ctrl.gestionTempsCuisson(recette, retour);

			ctrl.gestionTempsRepos(recette, retour);

			return retour.min + 'min' + retour.h + 'h' + retour.j + 'j';
		}

		function isOngletEdition(tab){return ctrl.editionTab===tab;}

		function gestionTempsCuisson(recette, retour){
			var temp = "";
			if(recette.tempsCuisson){
				temp=recette.tempsCuisson.substring(recette.tempsCuisson.search("<unite>")+7,recette.tempsCuisson.search("</unite>"));
			if(temp==="min"){
				retour.min=retour.min+parseInt(recette.tempsCuisson.substring(recette.tempsCuisson.search("<nombre>")+8,recette.tempsCuisson.search("</nombre>")));}
			else if(temp==="h"){
				retour.h=retour.h+parseInt(recette.tempsCuisson.substring(recette.tempsCuisson.search("<nombre>")+8,recette.tempsCuisson.search("</nombre>")));}
			else if(temp==="j"){
				retour.j=retour.j+parseInt(recette.tempsCuisson.substring(recette.tempsCuisson.search("<nombre>")+8,recette.tempsCuisson.search("</nombre>")));}}
		}

		function gestionTempsPreparation(recette, retour){
			var temp = "";
			if(recette.tempsPreparation){
				temp=recette.tempsPreparation.substring(recette.tempsPreparation.search("<unite>")+7,recette.tempsPreparation.search("</unite>"));
				if(temp==="min"){
					retour.min=retour.min+parseInt(recette.tempsPreparation.substring(recette.tempsPreparation.search("<nombre>")+8,recette.tempsPreparation.search("</nombre>")));}
			else if(temp==="h"){
				retour.h=retour.h+parseInt(recette.tempsPreparation.substring(recette.tempsPreparation.search("<nombre>")+8,recette.tempsPreparation.search("</nombre>")));}
			else if(temp==="j"){
				retour.j=retour.j+parseInt(recette.tempsPreparation.substring(recette.tempsPreparation.search("<nombre>")+8,recette.tempsPreparation.search("</nombre>")));}}
		}

		function gestionTempsRepos(recette, retour){
			var temp = "";
			if(recette.tempsRepos){
				temp=recette.tempsRepos.substring(recette.tempsRepos.search("<unite>")+7,recette.tempsRepos.search("</unite>"));
			if(temp==="min"){
				retour.min=retour.min+parseInt(recette.tempsRepos.substring(recette.tempsRepos.search("<nombre>")+8,recette.tempsRepos.search("</nombre>")));}
			else if(temp==="h"){
				retour.h=retour.h+parseInt(recette.tempsRepos.substring(recette.tempsRepos.search("<nombre>")+8,recette.tempsRepos.search("</nombre>")));}
			else if(temp==="j"){
				retour.j=retour.j+parseInt(recette.tempsRepos.substring(recette.tempsRepos.search("<nombre>")+8,recette.tempsRepos.search("</nombre>")));}}
		}

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
