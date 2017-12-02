/**
 * 
 */
(function(){
	
	var rec = angular.module('recettes', ['navigationTableRecettes','tableRecettes','recettesScroll','navigationEditionRecette','editionRecette']);
	
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
		
		self.setOngletEdition = function(tab){
			self.editionTab = tab;
		}
		
		self.isOngletEdition = function(tab){
			return self.editionTab === tab;
		}
		
		self.addRecette = function(){
			self.recetteTemp = {};
		}
		
		self.recettes = [
			{
				"id" : 1,
				"version" : 0,
				"label" : "Escargots de bourgogne",
				"typePlat" : 2,
				"difficulte" : 1,
				"tempsPreparation" : "50 min",
				"tempsCuisson" : "5 min",
				"nombreCouverts" : 6,
				"cout" : 3,
				"listeRecetteIngredients" : [],
				"instructions" : "",
				"conseils" : "",
				"image" : "",
				"video" : ""
			},
			{
				"id" : 2,
				"version" : 0,
				"label" : "Flammiche des corons",
				"typePlat" : 16,
				"difficulte" : 1,
				"tempsPreparation" : "20 min",
				"tempsCuisson" : "35 min",
				"nombreCouverts" : 8,
				"cout" : 1,
				"listeRecetteIngredients" : "",
				"instructions" : "",
				"conseils" : "",
				"image" : "",
				"video" : ""
			}
		];
		
		self.champsRecette = [
			{
				"id" : 1,
				"nom" : "identifiant"
			},
			{
				"id" : 2,
				"nom" : "typePlat"
			},
			{
				"id" : 3,
				"nom" : "Ingrédients"
			},
			{
				"id" : 4,
				"nom" : "Instructions"
			},
			{
				"id" : 5,
				"nom" : "Temps de cuisson"
			},
			{
				"id" : 6,
				"nom" : "Conseils"
			},
			{
				"id" : 7,
				"nom" : "Image"
			},
			{
				"id" : 8,
				"nom" : "Label"
			},
			{
				"id" : 9,
				"nom" : "Difficulté"
			},
			{
				"id" : 10,
				"nom" : "Temps de préparation"
			},
			{
				"id" : 11,
				"nom" : "Nombre de couverts"
			},
			{
				"id" : 12,
				"nom" : "Coût"
			}
		];
		
		self.creerCollection = function(entier){
			var collection = [];
			for(var i=1;i<=entier;i++){
				collection.push(i);
			}
			return collection;
		}
		
		self.listeTypesPlats();
	});
		
})();





