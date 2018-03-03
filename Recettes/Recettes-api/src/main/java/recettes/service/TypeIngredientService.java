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
	 * M�thode renvoyant la liste de tous les TypeIngredient en base.
	 * @return liste de tous les TypeIngredient en base.
	 */
	List<TypeIngredient> findAll();
	
	/**
	 * M�thode de sauvegarde d'un typeingredient.
	 */
	TypeIngredient save(TypeIngredient typeIngredient);
	
	
	
	
	// D�but m�thodes de construction de la liste hi�rarchis�e des types d'ingr�dient.
	/**
	 * M�thode renvoyant la liste hi�rarchis�e des TypeIngredient en base en l'initialisant si besoin.
	 * @return liste hi�rarchis�e des TypeIngredient.
	 */
	List<TypeIngredient> getListe();
	
	/**
	 * M�thode d'initialisation de la liste hi�rarchis�e des TypeIngredient en base.
	 */
	void initialisation();
	
	/**
	 * M�thode supprimant du Set de TypeIngredient les TypeIngredient avec niveau � null puis ceux de niveau inf�rieur sans type p�re.
	 */
	void nettoyage(final Set<TypeIngredient> source);
	
	/**
	 * M�thode transf�rant vers la liste target les TypeIngredient de niveau z�ro contenus dans le set source en les en supprimant.
	 * @param source Set contenant des TypeIngredient.
	 * @param target Liste contenant les TypeIngredient de source de niveau z�ro.
	 */
	void remplirNiveauZero(final List<TypeIngredient> target, final Set<TypeIngredient> source);
	
	/**
	 * M�thode transf�rant vers la liste target les TypeIngredient de niveau inf�rieurs contenus dans le set source en les en supprimant et en les affectants � leur type p�re.
	 * @param source Set contenant des TypeIngredient.
	 * @param target Liste contenant les TypeIngredient hi�rarchis�s.
	 */
	void remplirNiveauxInferieurs(final List<TypeIngredient> target, final Set<TypeIngredient> source);
	
	/**
	 * M�thode d'actualisaton de la liste des TypeIngredient hi�rarchis�e.
	 */
	void actualiser();
	
	/**
	 * M�thode de remise � null de la liste des TypeIngredient hi�rarchis�e.
	 */
	void effacer();
}
