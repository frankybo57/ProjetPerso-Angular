(function(){
	
	angular.module('ControllerEditerRecette',[])
	
	.controller('ControllerEditerRecette',ControllerEditerRecette);
	
	function ControllerEditerRecette(TypePlatFactory){
		var ctrl = this;
		
		ctrl.typesPlats = [];
		
		ctrl.recetteTemp = {};
		ctrl.editionTab = 'introduction';
		
		
		ctrl.listeTypesPlats = function() {
			TypePlatFactory.findAll()
			.then(function success(response) {
				ctrl.typesPlats = response.data; 
			}, function error(response) {

			});
		};
		
		ctrl.setOngletEdition=function(tab){ctrl.editionTab=tab;};
		ctrl.isOngletEdition=function(tab){return ctrl.editionTab===tab;};
		ctrl.calculTempsTotal=function(recette){
			var retour="";var min=0;var h=0;var j=0;var temp="";
			if(recette.tempsPreparation){temp=recette.tempsPreparation.substring(recette.tempsPreparation.search("<unite>")+7,recette.tempsPreparation.search("</unite>"));
			if(temp==="min"){min=min+parseInt(recette.tempsPreparation.substring(recette.tempsPreparation.search("<nombre>")+8,recette.tempsPreparation.search("</nombre>")));}
			else if(temp==="h"){h=h+parseInt(recette.tempsPreparation.substring(recette.tempsPreparation.search("<nombre>")+8,recette.tempsPreparation.search("</nombre>")));}
			else if(temp==="j"){j=j+parseInt(recette.tempsPreparation.substring(recette.tempsPreparation.search("<nombre>")+8,recette.tempsPreparation.search("</nombre>")));}}
			if(recette.tempsCuisson){temp=recette.tempsCuisson.substring(recette.tempsCuisson.search("<unite>")+7,recette.tempsCuisson.search("</unite>"));
			if(temp==="min"){min=min+parseInt(recette.tempsCuisson.substring(recette.tempsCuisson.search("<nombre>")+8,recette.tempsCuisson.search("</nombre>")));}
			else if(temp==="h"){h=h+parseInt(recette.tempsCuisson.substring(recette.tempsCuisson.search("<nombre>")+8,recette.tempsCuisson.search("</nombre>")));}
			else if(temp==="j"){j=j+parseInt(recette.tempsCuisson.substring(recette.tempsCuisson.search("<nombre>")+8,recette.tempsCuisson.search("</nombre>")));}}
			if(recette.tempsRepos){temp=recette.tempsRepos.substring(recette.tempsRepos.search("<unite>")+7,recette.tempsRepos.search("</unite>"));
			if(temp==="min"){min=min+parseInt(recette.tempsRepos.substring(recette.tempsRepos.search("<nombre>")+8,recette.tempsRepos.search("</nombre>")));}
			else if(temp==="h"){h=h+parseInt(recette.tempsRepos.substring(recette.tempsRepos.search("<nombre>")+8,recette.tempsRepos.search("</nombre>")));}
			else if(temp==="j"){j=j+parseInt(recette.tempsRepos.substring(recette.tempsRepos.search("<nombre>")+8,recette.tempsRepos.search("</nombre>")));}}
			if(j>0){retour=retour+j+" j ";}if(h>0){retour=retour+h+" h ";}if(min>0){retour=retour+min+" min";}return retour;
		};
		
		ctrl.addRecette = function(){
			ctrl.recetteTemp = {};
		};
		
		ctrl.creerCollection=function(entier){var collection=[];for(var i=1;i<=entier;i++){collection.push(i);}return collection;};
		
		ctrl.listeTypesPlats();
	};
})();