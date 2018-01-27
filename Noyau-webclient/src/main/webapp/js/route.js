/**
 * 
 */
(function(){
	
	angular.module('application')
	.config(function($routeProvider,$locationProvider){
		
		$routeProvider.when('/',{
			templateUrl:'templates/pages/acceuil/index.html',
		})
		
		.when('/acceuil',{
			templateUrl:'templates/pages/acceuil/index.html',
		})
		
		.when('/administration',{
			templateUrl:'templates/pages/admin/index.html',
		})
		
		.when('/compte-utilisateur',{
			templateUrl:'templates/pages/compte-utilisateur/index.html',
		})
		
		.when('/recettes',{
			redirectTo:'/recettes/liste'
		})
		
		.when('/recettes/liste',{
			templateUrl:'templates/pages/recettes/liste-recettes/index.html',
			controller:'ControllerAfficherListeRecette',
			controllerAs:'recetteCtrl',
		})
		
		.when('/recettes/edition',{
			templateUrl:'templates/pages/recettes/edition-recette/index.html',
			controller:'ControllerEditerRecette',
			controllerAs:'recetteCtrl',
		})
		
		.when('/recettes/ingredients/liste',{
			templateUrl:'templates/pages/recettes/liste-ingredients/index.html',
			controller:'ControllerAfficherListeIngredient',
			controllerAs:'listeIngredientsCtrl',
		})
		
		.when('/recettes/ingredients/edition',{
			templateUrl:'templates/pages/recettes/edition-ingredient/index.html',
			controller:'ControllerEditerIngredient',
			controllerAs:'editionIngredientsCtrl',
		})
		
		.when('/recettes/ingredients/edition/:id',{
			templateUrl:'templates/pages/recettes/edition-ingredient/index.html',
			controller:'ControllerEditerIngredient',
			controllerAs:'editionIngredientsCtrl',
		})
		
		
		
		.otherwise({redirectTo:'/'});
		
		$locationProvider.html5Mode(true)
		.hashPrefix('');
		
	});
	
})();
