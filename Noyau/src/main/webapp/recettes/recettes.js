/**
 * 
 */
(function(){
	
	var rec = angular.module('recettes', []);
	
	rec.directive('pageRecettes',function(){
		return {
			restrict:'E',
			templateUrl:'recettes/recettes.html',
		};
	});
	
	rec.controller('RecetteController', function($http){
		var self = this;
		
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
				"Difficulté" : 1,
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
		
		var typePlats = [
			{
				"id" : 1,
				"label" : "Entrée froide",
				"ancre" : "entree_foide"
			},
			{
				"id" : 2,
				"label" : "Entrée chaude",
				"ancre" : "entree_chaude"
			},
			{
				"id" : 3,
				"label" : "Soupe",
				"ancre" : "soupe"
			},
			{
				"id" : 4,
				"label" : "Cake / Terrine",
				"ancre" : "cake_terrine"
			},
			{
				"id" : 5,
				"label" : "Légumes / Gratin",
				"ancre" : "legumes_gratins"
			},
			{
				"id" : 6,
				"label" : "Oeufs / Fromage",
				"ancre" : "oeufs_fromage"
			},
			{
				"id" : 7,
				"label" : "Pâtes / Riz / Pommes de terre",
				"ancre" : "pates_riz_pommes_de_terre"
			},
			{
				"id" : 8,
				"label" : "Poisson / Fruits de mer",
				"ancre" : "poisson_fruit_de_mer"
			},
			{
				"id" : 9,
				"label" : "Tartes / Quiches",
				"ancre" : "tartes_quiches"
			},
			{
				"id" : 10,
				"label" : "Boeuf",
				"ancre" : "boeuf"
			},
			{
				"id" : 11,
				"label" : "Porc",
				"ancre" : "porc"
			},
			{
				"id" : 12,
				"label" : "Volaille",
				"ancre" : "volaille"
			},
			{
				"id" : 13,
				"label" : "Gibier",
				"ancre" : "gibier"
			},
			{
				"id" : 14,
				"label" : "Crème / Flanc / Glace",
				"ancre" : "creme_flanc_glace"
			},
			{
				"id" : 15,
				"label" : "Fruits",
				"ancre" : "fruits"
			},
			{
				"id" : 16,
				"label" : "Gâteau / Tarte",
				"ancre" : "gateau_tarte"
			},
			{
				"id" : 17,
				"label" : "Biscuit",
				"ancre" : "biscuit"
			},
			{
				"id" : 19,
				"label" : "Boisson froide",
				"ancre" : "boisson_froide"
			},
			{
				"id" : 20,
				"label" : "Confiture",
				"ancre" : "confiture"
			},
			{
				"id" : 21,
				"label" : "Pain",
				"ancre" : "pain"
			},
			{
				"id" : 22,
				"label" : "Recette de base / Pâte",
				"ancre" : "recette_de_base_pate"
			},
			{
				"id" : 23,
				"label" : "Sauce",
				"ancre" : "sauce"
			}
		];
	});
		
})();





