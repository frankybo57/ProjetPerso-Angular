package recettes.service.implementation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recettes.model.TypeIngredient;
import recettes.repository.TypeIngredientRepository;
import recettes.service.TypeIngredientService;

/**
 * Implémentation du service de gestion des TypeIngredient.
 * @author frankybo57
 *
 */
@Service
public class TypeIngredientServiceImpl implements TypeIngredientService {

	@Autowired
	private TypeIngredientRepository tiRepo;

	/** Liste hiérarchisée des TypeIngredient. */
	private List<TypeIngredient> liste;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TypeIngredient> findAll() {
		return tiRepo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeIngredient save(TypeIngredient typeIngredient) {
		return tiRepo.save(typeIngredient);
	}
	

	// Début méthodes de construction de la liste hiérarchisée des types d'ingrédient.
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TypeIngredient> getListe() {
		if(liste==null)initialisation();
		return liste;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialisation() {
		liste = new LinkedList<>();
		List<TypeIngredient> temp = tiRepo.findAll();
		if(!temp.isEmpty()) {
			Set<TypeIngredient> set = new HashSet<>(temp);
			nettoyage(set);
			remplirNiveauZero(liste, set);
			remplirNiveauxInferieurs(liste, set);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void nettoyage(final Set<TypeIngredient> source) {
		TypeIngredient tmp;
		Iterator<TypeIngredient> it = source.iterator();
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp.getNiveau() == null) it.remove();
		}
		it = source.iterator();
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp.getNiveau() >= 1 && tmp.getTypePere() == null) it.remove();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remplirNiveauxInferieurs(final List<TypeIngredient> target, final Set<TypeIngredient> source) {
		int niveau = 0;
		TypeIngredient tmp;
		TypeIngredient tmp2;
		Long id;
		Iterator<TypeIngredient> it;
		ListIterator<TypeIngredient> lIt;
		while(!source.isEmpty()) {
			niveau++;
			lIt = target.listIterator();
			while(lIt.hasNext()) {
				tmp = lIt.next();
				id = tmp.getId();
				if(tmp.getNiveau()==niveau-1) {
					it = source.iterator();
					while(it.hasNext()) {
						tmp2 = it.next();
						if(tmp2.getTypePere().getId()==id) {
							lIt.add(tmp2);
							it.remove();
						}
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remplirNiveauZero(final List<TypeIngredient> target, final Set<TypeIngredient> source) {
		TypeIngredient tmp;
		Iterator<TypeIngredient> it = source.iterator();
		while(it.hasNext()) {
			tmp = it.next();

			if(tmp.getNiveau()==0) {
				target.add(tmp);
				it.remove();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualiser() {
		initialisation();	
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void effacer() {
		this.liste = null;
	}
}
