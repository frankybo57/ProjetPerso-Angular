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
import recettes.repository.IngredientRepository;
import recettes.repository.RecetteIngredientRepository;
import recettes.repository.TypeIngredientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class TypeIngredientServiceTest {
	
	@Autowired
	private TypeIngredientRepository tiRepo;
	@Autowired
	private TypeIngredientService tiService;
	@Autowired
	private IngredientRepository ingRepo;
	@Autowired
	private RecetteIngredientRepository riRepo;
	
	private final Set<TypeIngredient> expected = new HashSet<TypeIngredient>();
	private final Set<TypeIngredient> auxiliaire = new HashSet<TypeIngredient>();
	private final List<TypeIngredient> temp = new LinkedList<TypeIngredient>();
	private int expectedNbNiveauZero;
	
	
	@Before
	public void deleteAll() {
		if(riRepo.count()>0) {
			riRepo.deleteAll();
		}
		if(ingRepo.count()>0) {
			ingRepo.deleteAll();
		}
		if(tiRepo.count()>0) {
			tiRepo.deleteAll();
		}
		tiService.effacer();
		expected.removeAll(expected);
		auxiliaire.removeAll(auxiliaire);
		temp.removeAll(temp);
	}
	
	public void preparation() {	
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tp = new TypeIngredient("Viande");
		tp.setNiveau((short) 0);
		tp = tiRepo.save(tp);
		expected.add(tp);
		auxiliaire.add(tp);
		ti = new TypeIngredient("Féculent");
		ti.setNiveau((short) 0);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tf = new TypeIngredient("Volaille");
		tf.setNiveau((short) 1);
		tf.setTypePere(tp);
		tf = tiRepo.save(tf);
		expected.add(tf);
		auxiliaire.add(tf);
		ti = new TypeIngredient("Légume");
		ti.setNiveau((short) 0);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tpf = new TypeIngredient("Poulet");
		tpf.setNiveau((short) 2);
		tpf.setTypePere(tf);
		tpf = tiRepo.save(tpf);
		expected.add(tpf);
		auxiliaire.add(tpf);
		ti = new TypeIngredient("Boeuf");
		ti.setNiveau((short) 1);
		ti.setTypePere(tp);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		
		expectedNbNiveauZero = 4;
	}
	
	public void preparationPourNettoyage() {
		TypeIngredient ti = new TypeIngredient("type");
		ti = tiRepo.save(ti);
		auxiliaire.add(ti);
		ti = new TypeIngredient("autretype");
		ti.setNiveau((short)2);
		ti = tiRepo.save(ti);
		auxiliaire.add(ti);
	}
	
	@Test
	public void testListeNiveauZero() {
		// PREPARE
		preparation();	
		// WHEN
		tiService.remplirNiveauZero(temp, auxiliaire);
		final int result = temp.size();
		// ASSERT
		Assert.assertEquals(expectedNbNiveauZero, result);
	}
	
	@Test
	public void testListeNiveauInferieurs() {
		// PREPARE
		preparation();
		// WHEN
		tiService.remplirNiveauZero(temp, auxiliaire);
		tiService.remplirNiveauxInferieurs(temp, auxiliaire);
		Set<TypeIngredient> result = new HashSet<TypeIngredient>(temp);
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testListeNiveauInferieursDeuxNiveaux() {	
		// PREPARATION
		preparation();
		// WHEN
		tiService.remplirNiveauZero(temp, auxiliaire);
		tiService.remplirNiveauxInferieurs(temp, auxiliaire);
		Set<TypeIngredient> result = new HashSet<TypeIngredient>(temp);
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testNettoyageNonNecessaire() {	
		// PREPARATION
		preparation();
		// WHEN
		tiService.nettoyage(auxiliaire);
		Set<TypeIngredient> result = new HashSet<TypeIngredient>(auxiliaire);
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testNettoyageNecessaire() {	
		// PREPARATION
		preparation();
		preparationPourNettoyage();
		// WHEN
		tiService.nettoyage(auxiliaire);
		Set<TypeIngredient> result = new HashSet<TypeIngredient>(auxiliaire);
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testgetListe() {	
		// PREPARATION
		preparation();
		preparationPourNettoyage();
		// WHEN
		Set<TypeIngredient> result = new HashSet<TypeIngredient>(tiService.getListe());
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testgetListeAppelsMultiples() {	
		// PREPARATION
		preparation();
		preparationPourNettoyage();
		List<TypeIngredient> expected = tiService.getListe();
		// WHEN
		List<TypeIngredient> result = tiService.getListe();	
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testgetListeBaseVide() {	
		// PREPARATION
		// WHEN
		List<TypeIngredient> result = tiService.getListe();	
		// ASSERT
		Assert.assertEquals(0, result.size());
	}
	
	@Test
	public void testgetListeBaseInappropriee() {	
		// PREPARATION
		preparationPourNettoyage();
		// WHEN
		List<TypeIngredient> result = tiService.getListe();	
		// ASSERT
		Assert.assertEquals(0, result.size());
	}
	
	@Test
	public void testChangementDeBaseSansActualiser() {	
		// PREPARATION
		preparation();
		preparationPourNettoyage();
		List<TypeIngredient> expected = tiService.getListe();
		
		TypeIngredient ti = new TypeIngredient("autre");
		ti.setNiveau((short) 0);
		tiRepo.save(ti);
		// WHEN
		List<TypeIngredient> result = tiService.getListe();	
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testChangementDeBaseAvecActualiser() {	
		// PREPARATION
		preparation();
		preparationPourNettoyage();
		Set<TypeIngredient> expected = new HashSet<TypeIngredient>(tiService.getListe());
		TypeIngredient ti = new TypeIngredient("autre");
		ti.setNiveau((short) 0);
		tiRepo.save(ti);
		expected.add(ti);
		// WHEN
		tiService.actualiser();
		Set<TypeIngredient> result = new HashSet<TypeIngredient>(tiService.getListe());	
		// ASSERT
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testFindAll() {
		// PREPARE
		preparation();
		preparationPourNettoyage();
		// WHEN
		List<TypeIngredient> result = tiService.findAll();
		// ASSERT
		Assert.assertEquals(9, result.size());
	}
	
}
