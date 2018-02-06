package recettes.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import recettes.model.TypeIngredient;
import recettes.repository.TypeIngredientRepository;

@Component
public class ListeTypeIngredient {
	
	private static ListeTypeIngredient instance;
	@SuppressWarnings("rawtypes")
	private List liste;
	
	@Autowired
	private TypeIngredientRepository tiRepo;
	
	private ListeTypeIngredient() {

	}
	
	@SuppressWarnings("rawtypes")
	public List getListe() {
		if(liste==null)initialisation();
		return liste;
	}
	
	public static ListeTypeIngredient getInstance() {
		if(instance == null) {instance = new ListeTypeIngredient();}
		return instance;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialisation() {
		liste = new LinkedList();
		List temp = tiRepo.findAll();
		if(temp != null) {
			Set set = new HashSet(temp);
			
			remplirNiveauZero(liste, set);
			
			remplirNiveauxInferieurs(liste, set);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void remplirNiveauxInferieurs(final List target, final Set source) {
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void remplirNiveauZero(final List target, final Set source) {
		TypeIngredient tmp;
		Iterator<TypeIngredient> it = source.iterator();
		while(it.hasNext()) {
			tmp = it.next();

			if(tmp.getNiveau() != null &&tmp.getNiveau()==0) {
				target.add(tmp);
				it.remove();
			}
		}
	}
	
	public void actualiser() {
		initialisation();	
	}

}
