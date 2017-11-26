(function() {
	
	nav = angular.module("navigation", []);
	
	nav.directive("barreNavigation",function(){
		return {
			restrict:'E',
			templateUrl:'header.html',
			controller:function(){
				this.onglet = "Accueil";
				
				this.modulesActifs = [
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
				
				this.setOnglet = function(onglet){
					this.onglet = onglet;
				};
				
				this.isOnglet = function(onglet){
					return this.onglet === onglet;
				};
			},
			controllerAs:'header'
		};
	});
				
})();