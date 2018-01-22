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
			redirectTo:'/Recettes/liste'
		})
		
		.when('/recettes/liste',{
			templateUrl:'templates/pages/recettes/index.html',
			controller:'RecetteController',
			controllerAs:'recetteCtrl',
		})
		
		.when('/recettes/ingredients/liste',{
			templateUrl:'templates/pages/recettes/ingredients/index.html',
			controller:'ListeIngredientsController',
			controllerAs:'listeIngredientsCtrl',
		})
		
		
		
		
		
		.otherwise({redirectTo:'/'});
		
		$locationProvider.html5Mode(true)
		.hashPrefix('');
		
	});
	
})();
