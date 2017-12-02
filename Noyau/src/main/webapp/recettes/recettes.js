/**
 * 
 */
(function(){
	
	var rec = angular.module('recettes', ['navigationTableRecettes','tableRecettes','recettesScroll']);
	
	rec.directive('pageRecettes',function(){
		return {
			restrict:'E',
			templateUrl:'recettes/recettes.html',
			controller:'RecetteController',
			controllerAs:'recetteCtrl'
		};
	});
	
	rec.controller('RecetteController', function($http){
		var self = this;
		
		self.mode = "table";
		self.typesPlats = [];
		
		self.listeTypesPlats = function() {
			console.log("listeTypesPlats()");
			$http({
				method : 'GET',
				url : 'api/typesPlats/'
			}).then(function success(response) {
				console.log(response.data);
				self.typesPlats = response.data; 
			}, function error(response) {

			});
		};
		
		self.recettes = [
			{
				"identifiant" : 1,
				"Label" : "Escargots de bourgogne",
				"typePlat" : 2,
				"Difficulté" : 1,
				"Temps de préparation" : "50 min",
				"Temps de cuisson" : "5 min",
				"Nombre de couverts" : 6,
				"Coût" : 3,
				"Ingrédients" : "",
				"Instructions" : "",
				"Conseils" : "",
				"Image" : ""
			},
			{
				"identifiant" : 2,
				"Label" : "Flammiche des corons",
				"typePlat" : 16,
				"Difficulté" : 2,
				"Temps de préparation" : "20 min",
				"Temps de cuisson" : "35 min",
				"Nombre de couverts" : 8,
				"Coût" : 1,
				"Ingrédients" : "",
				"Instructions" : "",
				"Conseils" : "",
				"Image" : ""
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
		
		self.listeTypesPlats();
	});
		
})();





