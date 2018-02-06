package recettes.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import recettes.model.TypeIngredient;
import recettes.repository.TypeIngredientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class ListeTypeIngredientTest {
	
	@Autowired
	private TypeIngredientRepository tiRepo;
	
	@Before
	public void init() {
		tiRepo.save(new TypeIngredient("ty"));
		tiRepo.deleteAll();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testListeNiveauZero() {
		final Set expected = new HashSet();
		final Set auxiliaire = new HashSet();
		final List temp = new LinkedList();
		
		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
		
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Viande");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Féculent");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Légume");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		
		lTI.remplirNiveauZero(temp, auxiliaire);
		
		final Set result = new HashSet(temp);
		
		Assert.assertEquals(expected, result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testListeNiveauZeroTypesIngredientsNonNiveauxZero() {
		final Set expected = new HashSet();
		final Set auxiliaire = new HashSet();
		final List temp = new LinkedList();
		
		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
		
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Viande");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Féculent");
		ti.setNiveau((short) 1);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Légume");
		auxiliaire.add(ti);
		
		lTI.remplirNiveauZero(temp, auxiliaire);
		
		final Set result = new HashSet(temp);
		
		Assert.assertEquals(expected, result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testListeNiveauInferieurs() {
		final Set expected = new HashSet();
		final Set auxiliaire = new HashSet();
		final List temp = new LinkedList();
		
		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
		
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tp = new TypeIngredient("Epice");
		tp = new TypeIngredient("Viande");
		tp.setNiveau((short) 0);
		expected.add(tp);
		auxiliaire.add(tp);
		ti = new TypeIngredient("Volaille");
		ti.setNiveau((short) 1);
		ti.setTypePere(tp);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Féculent");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("Légume");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		
		lTI.remplirNiveauZero(temp, auxiliaire);
		
		
		
		lTI.remplirNiveauxInferieurs(temp, auxiliaire);
		
		Set result = new HashSet(temp);
		
		Assert.assertEquals(expected, result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testListeNiveauInferieursDeuxNiveau() {
		final Set expected = new HashSet();
		final Set auxiliaire = new HashSet();
		final List temp = new LinkedList();
		
		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
		
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tp = new TypeIngredient("Epice");
		tp = new TypeIngredient("Viande");
		tp.setNiveau((short) 0);
		expected.add(tp);
		auxiliaire.add(tp);
		ti = new TypeIngredient("Volaille");
		ti.setNiveau((short) 1);
		ti.setTypePere(tp);
		expected.add(ti);
		auxiliaire.add(ti);
		tp = new TypeIngredient("Féculent");
		tp.setNiveau((short) 0);
		auxiliaire.add(tp);
		TypeIngredient tpf = new TypeIngredient("Poulet");
		tpf.setNiveau((short) 2);
		tpf.setTypePere(ti);
		expected.add(tpf);
		auxiliaire.add(tpf);
		expected.add(tp);
		ti = new TypeIngredient("Légume");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		
		lTI.remplirNiveauZero(temp, auxiliaire);
		
		
		
		lTI.remplirNiveauxInferieurs(temp, auxiliaire);
		
		Set result = new HashSet(temp);
		
		Assert.assertEquals(expected, result);
	}
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Test
//	public void testInitialisation() {
//		final Set expected = new HashSet();
//		final Set auxiliaire = new HashSet();
//		
//		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
//		
//		TypeIngredient ti = new TypeIngredient("Epice");
//		ti.setNiveau((short) 0);
//		expected.add(ti);
//		auxiliaire.add(ti);
//		TypeIngredient tp = new TypeIngredient("Epice");
//		tp = new TypeIngredient("Viande");
//		tp.setNiveau((short) 0);
//		expected.add(tp);
//		auxiliaire.add(tp);
//		ti = new TypeIngredient("Volaille");
//		ti.setNiveau((short) 1);
//		ti.setTypePere(tp);
//		expected.add(ti);
//		auxiliaire.add(ti);
//		tp = new TypeIngredient("Féculent");
//		tp.setNiveau((short) 0);
//		auxiliaire.add(tp);
//		TypeIngredient tpf = new TypeIngredient("Poulet");
//		tpf.setNiveau((short) 2);
//		tpf.setTypePere(ti);
//		expected.add(tpf);
//		auxiliaire.add(tpf);
//		expected.add(tp);
//		ti = new TypeIngredient("Légume");
//		ti.setNiveau((short) 0);
//		expected.add(ti);
//		auxiliaire.add(ti);
//		
//		tiRepo.save(auxiliaire);
//		
//		final Set result = new HashSet(lTI.getListe());
//		
//		Assert.assertEquals(result, new HashSet(lTI.getListe()));
//		Assert.assertEquals(expected.size(),result.size());
//		for(int i=0; i<expected.size(); i++) {
//			Iterator it1 = expected.iterator();
//			Iterator it2 = result.iterator();
//			Assert.assertEquals(expected., result);
//		}
//		
//		
//	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Test
	public void testActualiser() {
		final Set expected = new HashSet();
		final Set auxiliaire = new HashSet();
		
		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
		
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tp = new TypeIngredient("Epice");
		tp = new TypeIngredient("Viande");
		tp.setNiveau((short) 0);
		expected.add(tp);
		auxiliaire.add(tp);
		ti = new TypeIngredient("Volaille");
		ti.setNiveau((short) 1);
		ti.setTypePere(tp);
		expected.add(ti);
		auxiliaire.add(ti);
		tp = new TypeIngredient("Féculent");
		tp.setNiveau((short) 0);
		auxiliaire.add(tp);
		TypeIngredient tpf = new TypeIngredient("Poulet");
		tpf.setNiveau((short) 2);
		tpf.setTypePere(ti);
		expected.add(tpf);
		auxiliaire.add(tpf);
		expected.add(tp);
		ti = new TypeIngredient("Légume");
		ti.setNiveau((short) 0);
		expected.add(ti);
		auxiliaire.add(ti);
		
//		tiRepo.save(auxiliaire);
//		
//		final List resultat1 = lTI.getListe();
//		lTI.actualiser();
//		final List resultat2 = lTI.getListe();
//		
//		Assert.assertEquals(resultat1, resultat2);
		
	}
	
}
