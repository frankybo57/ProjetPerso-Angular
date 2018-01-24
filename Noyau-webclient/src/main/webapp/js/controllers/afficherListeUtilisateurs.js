(function(){

	angular.module('ControllerAfficherListeUtilisateurs', [])

	.controller("ControllerAfficherListeUtilisateurs", ControllerAfficherListeUtilisateurs);

	function ControllerAfficherListeUtilisateurs(UtilisateurFactory){
		var ctrl = this;

		ctrl.listeUtilisateurs = [];

		ctrl.liste = function(){
			UtilisateurFactory.findAll()
			.then(
					function success(response) {
						ctrl.listeUtilisateurs = response.data; 
					}, 
					function error(response) {

					}
			);
		};
		
		ctrl.liste();

	};

})();