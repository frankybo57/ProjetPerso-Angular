(function(){

	angular.module('ValueUtilisateurConnecte',[])

	/**
	 * Valeur contenant l'Utilisateur connecté.
	 * @author frankybo57
	 */
	.value('utilisateurConnecte',{
		id:null,
		version:null,
		login:null,
		password:null,
		droits:null,
	});

})();
