package recettes.service;

import java.util.List;
import java.util.Set;

import recettes.model.TypeIngredient;

/**
 * Service de gestion des TypeIngredient.
 * @author frankybo57
 *
 */
public interface TypeIngredientService {
	
	/**
	 * Méthode renvoyant la liste de tous les TypeIngredient en base.
	 * @return liste de tous les TypeIngredient en base.
	 */
	List<TypeIngredient> findAll();
	
	/**
	 * Méthode de sauvegarde d'un typeingredient.
	 */
	TypeIngredient save(TypeIngredient typeIngredient);
	
	
	
	
	// Début méthodes de construction de la liste hiérarchisée des types d'ingrédient.
	/**
	 * Méthode renvoyant la liste hiérarchisée des TypeIngredient en base en l'initialisant si besoin.
	 * @return liste hiérarchisée des TypeIngredient.
	 */
	List<TypeIngredient> getListe();
	
	/**
	 * Méthode d'initialisation de la liste hiérarchisée des TypeIngredient en base.
	 */
	void initialisation();
	
	/**
	 * Méthode supprimant du Set de TypeIngredient les TypeIngredient avec niveau à null puis ceux de niveau inférieur sans type père.
	 */
	void nettoyage(final Set<TypeIngredient> source);
	
	/**
	 * Méthode transférant vers la liste target les TypeIngredient de niveau zéro contenus dans le set source en les en supprimant.
	 * @param source Set contenant des TypeIngredient.
	 * @param target Liste contenant les TypeIngredient de source de niveau zéro.
	 */
	void remplirNiveauZero(final List<TypeIngredient> target, final Set<TypeIngredient> source);
	
	/**
	 * Méthode transférant vers la liste target les TypeIngredient de niveau inférieurs contenus dans le set source en les en supprimant et en les affectants à leur type père.
	 * @param source Set contenant des TypeIngredient.
	 * @param target Liste contenant les TypeIngredient hiérarchisés.
	 */
	void remplirNiveauxInferieurs(final List<TypeIngredient> target, final Set<TypeIngredient> source);
	
	/**
	 * Méthode d'actualisaton de la liste des TypeIngredient hiérarchisée.
	 */
	void actualiser();
	
	/**
	 * Méthode de remise à null de la liste des TypeIngredient hiérarchisée.
	 */
	void effacer();
}
