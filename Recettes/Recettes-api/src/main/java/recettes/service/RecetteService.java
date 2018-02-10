package recettes.service;

import java.util.List;

import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypePlat;

/**
 * Service de gestion des Recette.
 * @author frankybo57
 *
 */
public interface RecetteService {
	
	Recette findOne(final Long id);
	
	List<Recette> findAll();
	
	List<Recette> findAllByTypePlat(final TypePlat type);
	
	List<Recette> findAllByIngredient(final Ingredient ingredient);
	
	List<Recette> findAllByDifficulte(final Short difficulte);

	List<Recette> findAllSansTypePlat();
	
	void delete(final Long id);
}
