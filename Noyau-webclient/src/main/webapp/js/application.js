(function(){
	
	angular.module('application', 
			[	
				'ngRoute',
				
				/* Controllers */
				'recettesController',
				'sessionController',
				
				/* Directives */
				'ingredientsDirective',
				'navigationDirective',
				'recettesDirective',
				'sessionDirective',
				
				
				'modules',
				'utilisateurs',
				]);
		
})();





