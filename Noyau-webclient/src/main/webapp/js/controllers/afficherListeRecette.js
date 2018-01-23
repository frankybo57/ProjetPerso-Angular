(function(){
	
	angular.module('ControllerAfficherListeRecette',[])
	
	.controller('ControllerAfficherListeRecette',ControllerAfficherListeRecette);
	
	function ControllerAfficherListeRecette(RecetteFactory,TypePlatFactory){
		var ctrl = this;
		
		ctrl.listeRecettesComplete = [];
		ctrl.typesPlats = [];
		
		ctrl.listeTypesPlats = function() {
			TypePlatFactory.findAll()
			.then(
				function success(response) {
					ctrl.typesPlats = response.data; 
				}, 
				function error(response) {

				}
			);
		};
		
		ctrl.listeRecettes = function(){
			
			RecetteFactory.findAll()
			.then(
				function success(response) {
					ctrl.listeRecettesComplete = response.data; 
				}, 
				function error(response) {

				}
			);
		}
		
		ctrl.listeTypesPlats();
		ctrl.listeRecettes();
	};
	
})();