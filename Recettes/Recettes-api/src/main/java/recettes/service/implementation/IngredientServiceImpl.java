package recettes.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import constantes.Constantes;
import exception.IngredientException;
import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypeIngredient;
import recettes.repository.IngredientRepository;
import recettes.service.IngredientService;

/**
 * Implémentation du service de gestion des Ingredient.
 * @author frankybo57
 *
 */
@Service
public class IngredientServiceImpl implements IngredientService {
	
	@Autowired
	IngredientRepository ingRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ingredient> findAll() {
		return ingRepo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ingredient> findAllByTypeIngredient(final TypeIngredient type) {
		return ingRepo.findAllByTypeIngredient(type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ingredient> findAllByRecette(final Recette recette) {
		return ingRepo.findAllIngredientByRecette(recette);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ingredient> findAllByPrix(final Short cout) {
		return ingRepo.findAllByCout(cout);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final Long id) throws IngredientException{
		try {
			ingRepo.delete(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new IngredientException(Constantes.INGREDIENT_NON_TROUVE);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Ingredient find(final Long id) {
		return ingRepo.findOne(id);
	}

}
