package recettes.service;

import java.util.List;

import exception.IngredientException;
import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypeIngredient;

/**
 * Service de gestion des Ingredient.
 * @author frankybo57
 *
 */
public interface IngredientService {
	
	/**
	 * Renvoie la liste de tous les Ingredient en base.
	 * @return liste des Ingredient en base.
	 */
	List<Ingredient> findAll();
	
	/**
	 * Renvoie la liste de tous les Ingredient d'un TypeIngredient en base.
	 * @param type le TypeIngredient des Ingredient renvoyés.
	 * @return liste des Ingredient du type TypeIngredient en base.
	 */
	List<Ingredient> findAllByTypeIngredient(final TypeIngredient type);
	
	/**
	 * Renvoie la liste de tous les Ingredient utilisés dans une Recette en base.
	 * @param recette la Recette employant les Ingredient renvoyés.
	 * @return liste des Ingredient en base utilisés dans la Recette.
	 */
	List<Ingredient> findAllByRecette(final Recette recette);
	
	/**
	 * Renvoie la liste de tous les Ingredient d'un certain niveau de prix en base.
	 * @param cout le niveau de prix des Ingredient recherchés.
	 * @return liste des Ingredient en base utilisés dans la Recette.
	 */
	List<Ingredient> findAllByPrix(final Short cout);
	
	/**
	 * Supprime un Ingredient par son identifiant.
	 * @param id identifiant de l'Ingredient à supprimer en base.
	 * @throws IngredientException 
	 */
	void delete(final Long id) throws IngredientException;
	
	/**
	 * Renvoie un Ingredient caractérisé par son identifiant.
	 * @param id identifiant de l'Ingredient à supprimer en base.
	 */
	Ingredient find(final Long id);
}
