(function(){
	
	var rec = angular.module('recettes', ['navigationTableRecettes','tableRecettes','recettesScroll','navigationEditionRecette','editionRecette','navigationEditionIngredient','editionIngredient']);
	
	rec.directive('pageRecettes',function(){
		return {
			restrict:'E',
			templateUrl:'recettes/recettes.html',
			controller:'RecetteController',
			controllerAs:'recetteCtrl'
		};
	});
	
	rec.directive('vueRecette',function(){
		return {
			restrict:'E',
			templateUrl:'recettes/vueRecette.html'
		};
	});
	
	rec.controller('RecetteController', function($http){
		var self = this;
		
		self.mode = "table";
		self.typesPlats = [];
		self.listeRecettesComplete = [];
		
		self.editionTab = null;
		
		self.recetteTemp = {};
		
		self.listeTypesPlats = function() {
			$http({
				method : 'GET',
				url : 'api/typesPlats/'
			}).then(function success(response) {
				self.typesPlats = response.data; 
			}, function error(response) {

			});
		};
		
		self.listerRecettes = function(){
			$http({
				method : 'GET',
				url : 'api/recettes/'
			}).then(function success(response) {
				self.listeRecettesComplete = response.data; 
			}, function error(response) {

			});
		}
		
		self.calculTempsTotal=function(recette){
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
		
		self.setOngletEdition=function(tab){self.editionTab=tab;};
		self.isOngletEdition=function(tab){return self.editionTab===tab;};
		
		self.addRecette = function(){
			self.recetteTemp = {};
		};
		
		self.creerCollection=function(entier){var collection=[];for(var i=1;i<=entier;i++){collection.push(i);}return collection;};
		
		self.listeTypesPlats();
		self.listerRecettes();
	});
		
})();





