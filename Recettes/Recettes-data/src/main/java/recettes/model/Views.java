package recettes.model;

import jsonviews.Common;

/**
 * Classe conteneur des vues Json spécifiques à ce module.
 * 
 * @author frankybo57
 *
 */
public class Views {
	
	private Views() {
		
	}
	
	/**
	 * Vue donnant accès au attributs objets complexes de l'entité Recette.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class Recette extends Common {

	}
	
	/**
	 * Vue donnant accès au attributs objets complexes de l'entité TypePlat.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class TypePlat extends Common{
		
	}
	
	/**
	 * Vue donnant accès au attributs objets complexes de l'entité Ingredient.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class Ingredient extends Common {

	}
	
	/**
	 * Vue donnant accès au attributs objets complexes de l'entité TypeIngredient.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class TypeIngredient extends Common {

	}
	
	/**
	 * Vue donnant accès au attributs objets complexes de l'entité LigneInstruction.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class LigneInstruction extends Recette {
		
	}
}
