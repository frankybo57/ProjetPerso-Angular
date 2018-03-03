/**
 * 
 */
package recettes.service.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recettes.model.Ingredient;
import recettes.model.LigneConseil;
import recettes.model.Recette;
import recettes.repository.LigneConseilRepository;
import recettes.service.LigneConseilService;

/**
 * Implémentation de l'interface LigneConseilService
 * 
 * @author Dev
 *
 */
@Service
@SuppressWarnings("rawtypes")
public class LigneConseilServiceImpl implements LigneConseilService {
	@Autowired
	private LigneConseilRepository lcRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LigneConseil> findListLigneConseilByEntite(final Long id, final Class classe) {
		if(classe == Recette.class) {
			return lcRepo.findAllByRecette(id);
		}
		else if(classe == Ingredient.class) {
			return lcRepo.findAllByIngredient(id);
		}
		else return new ArrayList<>();		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String findTextLigneConseilByEntite(final Long id, final Class classe) {
		List<LigneConseil> liste;
		if(classe == Recette.class) {
			liste = lcRepo.findAllByRecette(id);
		}
		else if(classe == Ingredient.class) {
			liste = lcRepo.findAllByIngredient(id);
		}
		else liste = new ArrayList<>();
		
		if(!liste.isEmpty()) {
			StringBuilder conseils = new StringBuilder();
			Iterator<LigneConseil> it = liste.iterator();
			LigneConseil ligne;
			while(it.hasNext()) {
				ligne = it.next();
				conseils.append(ligne.getConseil());
				conseils.append(String.format("%n", ""));
			}
			return conseils.toString();
		}
		else {
			if(classe == Recette.class) {
				return "Cette recette n'a pas encore de conseils associés.";
			}
			else if(classe == Ingredient.class) {
				return "Cet ingrédient n'a pas encore de conseils associés.";
			}
			else return "";
			
		}
	}
}
