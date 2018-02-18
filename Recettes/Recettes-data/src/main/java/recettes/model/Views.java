package recettes.model;

import jsonviews.Common;

/**
 * Classe conteneur des vues Json sp�cifiques � ce module.
 * 
 * @author frankybo57
 *
 */
public class Views {
	
	private Views() {
		
	}
	
	/**
	 * Vue donnant acc�s au attributs objets complexes de l'entit� Recette.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class Recette extends Common {

	}
	
	/**
	 * Vue donnant acc�s au attributs objets complexes de l'entit� TypePlat.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class TypePlat extends Common{
		
	}
	
	/**
	 * Vue donnant acc�s au attributs objets complexes de l'entit� Ingredient.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class Ingredient extends Common {

	}
	
	/**
	 * Vue donnant acc�s au attributs objets complexes de l'entit� TypeIngredient.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class TypeIngredient extends Common {

	}
	
	/**
	 * Vue donnant acc�s au attributs objets complexes de l'entit� LigneInstruction.
	 * 
	 * @author frankybo57
	 *
	 */
	public static class LigneInstruction extends Recette {
		
	}
}
