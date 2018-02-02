(function(){

	angular.module('ControllerAfficherListeRecette', ['recettesScroll'])

	.controller('ControllerAfficherListeRecette', ControllerAfficherListeRecette);

	function ControllerAfficherListeRecette(RecetteFactory,TypePlatFactory){
		var ctrl = this;

		ctrl.liste = [];
		ctrl.types = [];

		ctrl.listeTypesPlats = function() {
			TypePlatFactory.findAll()
			.then(
				function success(response) {
					ctrl.types = response.data;
				},
				function error(response) {

				}
			);
		};

		ctrl.listeRecettes = function(){

			RecetteFactory.findAll()
			.then(
				function success(response) {
					ctrl.liste = response.data;
				},
				function error(response) {

				}
			);
		}

		ctrl.creerCollection=function(entier){
			var collection=[];
			for(var i=1;i<=entier;i++){
				collection.push(i);}
			return collection;};

		ctrl.listeTypesPlats();
		ctrl.listeRecettes();
	}

})();
