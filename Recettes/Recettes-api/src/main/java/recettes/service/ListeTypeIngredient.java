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
		Set set = new HashSet(tiRepo.findAll());
		List list = new LinkedList();
		
		remplirNiveauZero(list, set);
		
		remplirNiveauxInferieurs(list, set);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void remplirNiveauxInferieurs(final List list, final Set set) {
		int niveau = 0;
		TypeIngredient tmp;
		TypeIngredient tmp2;
		Short id;
		Iterator<TypeIngredient> it;
		ListIterator<TypeIngredient> lIt;
		while(!set.isEmpty()) {
			niveau++;
			lIt = list.listIterator();
			while(lIt.hasNext()) {
				tmp = lIt.next();
				id = tmp.getId();
				if(tmp.getNiveau()==niveau-1) {
					it = set.iterator();
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
		
		liste = list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void remplirNiveauZero(final List list, final Set set) {
		TypeIngredient tmp;
		Iterator<TypeIngredient> it = set.iterator();
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp.getNiveau()==0) {
				list.add(tmp);
				it.remove();
			}
		}
	}
	
	public void actualiser() {
		initialisation();	
	}

}
