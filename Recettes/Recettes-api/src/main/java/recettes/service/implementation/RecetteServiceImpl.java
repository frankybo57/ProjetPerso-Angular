package recettes.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypePlat;
import recettes.repository.RecetteRepository;
import recettes.service.RecetteService;

/**
 * Implémentation du service de gestion des Recette.
 * @author frankybo57
 *
 */
@Service
public class RecetteServiceImpl implements RecetteService {

	@Autowired
	RecetteRepository recRepo;

	/**
	 * {@inheritDoc}
	 */
	public Recette findOne(final Long id) {
		return recRepo.findOne(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recette> findAll() {
		return recRepo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recette> findAllByTypePlat(final TypePlat type) {
		return recRepo.findAllByTypePlat(type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recette> findAllByIngredient(final Ingredient ingredient) {
		return recRepo.findAllRecetteByIngredient(ingredient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recette> findAllByDifficulte(final Short difficulte) {
		return recRepo.findAllByDifficulte(difficulte);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Recette> findAllSansTypePlat(){
		return recRepo.findAllSansTypePlat();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void delete(final Long id) {
		recRepo.delete(id);
	}

}
