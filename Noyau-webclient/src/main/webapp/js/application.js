(function(){
	
	angular.module('application', 
			[	
				'ngRoute',
				
				/* Controllers */
				'ControllerAfficherListeRecette',
				'recettesController',
				'sessionController',
				
				/* Directives */
				'ingredientsDirective',
				'navigationDirective',
				'recettesDirective',
				'sessionDirective',
				
				/* Services */
				'RecetteService',
				'TypePlatService',
				'UtilisateurService',
				
				'modules',
				'utilisateurs',
				]);
		
})();





