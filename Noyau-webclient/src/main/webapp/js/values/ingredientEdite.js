(function(){

	angular.module('ValueIngredientEdite',[])

	/**
	 * Valeur contenant l'ingrédient en cours d'édition.
	 * @author frankybo57
	 */
	.value('ingredientEdite',{
		id:null,
		version:null,
		label:null,
		utilisateur:null,
		prive:null,
		cout:null,
		typeIngredient:null
	});

})();
