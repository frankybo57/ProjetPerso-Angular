(function() {
	
	var nav = angular.module("navigation", []);
	
	var modulesActifs = [
		{
			"id" : 1,
			"nom" : "Noyau",
			"header" : "Accueil",
			"etat" : "Actif"
		},
		{
			"id" : 2,
			"nom" : "Admin",
			"header" : "Admin",
			"etat" : "Actif"
		},
		{
			"id" : 3,
			"nom" : "ModuleStock",
			"header" : "Stock",
			"etat" : "Actif"
		},
		{
			"id" : 4,
			"nom" : "ModuleRecette",
			"header" : "Recettes",
			"etat" : "Actif"
		},
		{
			"id" : 5,
			"nom" : "ModuleCourse",
			"header" : "Courses",
			"etat" : "Actif"
		},
		{
			"id" : 6,
			"nom" : "ModuleMenu",
			"header" : "Menus",
			"etat" : "Actif"
		},
		{
			"id" : 7,
			"nom" : "ModuleCalculatrice",
			"header" : "Calculatrice",
			"etat" : "Actif"
		}
	];
	
	nav.directive("header",function(){
		return {
			restrict:'E',
			templateUrl:"header.html"
		};
	});
	
	nav.controller("headerController",function(){
		this.onglet = accueil;
		
		this.setOnglet = function(onglet){
			this.onglet = onglet;
		};
		
		this.isOnglet = function(onglet){
			return this.onglet === onglet;
		};
		
//		this.initialisation = function(){
//			
//		};	
		
//		var ouvrirCalculatrice = function(){
//			var position = screen.width - 200;
//			window.open("../../ModuleCalculatriceView/WebContent/calculatriceView.html","newwindow","width=500,height=620,left="+position);
//		};
		
	});
				
})();