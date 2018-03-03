package recettes.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entites.Entite;
import recettes.model.Ingredient;
import recettes.model.LigneConseil;
import recettes.model.Recette;
import recettes.repository.IngredientRepository;
import recettes.repository.LigneConseilRepository;
import recettes.repository.RecetteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class LigneConseilServiceTest {

	@Autowired
	LigneConseilRepository lcRepo;

	@Autowired
	RecetteRepository recRepo;

	@Autowired
	IngredientRepository ingRepo;

	@Autowired
	LigneConseilService lcService;

	@Before
	public void setup() {
		if(lcRepo.count()!=0) {
			lcRepo.deleteAll();
		}
		if(ingRepo.count()!=0) {
			ingRepo.deleteAll();
		}
		if(recRepo.count()!=0) {
			recRepo.deleteAll();
		}
	}

	@Test
	public void test() {
		Assert.assertNotNull(recRepo);
		Assert.assertNotNull(ingRepo);
		Assert.assertNotNull(lcRepo);
		Assert.assertNotNull(lcService);
	}

	@Test
	public void testFindListeConseilByEntiteRecette() {
		// PREPARE
		final Recette recette = new Recette();
		recette.setLabel("recette");
		recRepo.save(recette);
		final List<LigneConseil> instructions = new ArrayList<LigneConseil>();
		LigneConseil ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneConseil(Integer.toString(i));
			ligne.setEntite(recette);
			instructions.add(ligne);
		}
		lcRepo.save(instructions);
		// WHEN
		List<LigneConseil> result = lcService.findListLigneConseilByEntite(recette.getId(), Recette.class);
		// ASSERT
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(20, result.size());
	}
	
	@Test
	public void testFindListeConseilByEntiteIngredient() {
		// PREPARE
		final Ingredient ingredient = new Ingredient();
		ingredient.setLabel("ingredient");
		ingRepo.save(ingredient);
		final List<LigneConseil> instructions = new ArrayList<LigneConseil>();
		LigneConseil ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneConseil(Integer.toString(i));
			ligne.setEntite(ingredient);
			instructions.add(ligne);
		}
		lcRepo.save(instructions);
		// WHEN
		List<LigneConseil> result = lcService.findListLigneConseilByEntite(ingredient.getId(), Ingredient.class);
		// ASSERT
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(20, result.size());
	}
	
	@Test
	public void testFindListeConseilByEntiteSansClasse() {
		// PREPARE
		final Ingredient ingredient = new Ingredient();
		ingredient.setLabel("ingredient");
		ingRepo.save(ingredient);
		final List<LigneConseil> instructions = new ArrayList<LigneConseil>();
		LigneConseil ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneConseil(Integer.toString(i));
			ligne.setEntite(ingredient);
			instructions.add(ligne);
		}
		lcRepo.save(instructions);
		// WHEN
		List<LigneConseil> result = lcService.findListLigneConseilByEntite(ingredient.getId(), null);
		// ASSERT
		Assert.assertTrue(result.isEmpty());
	}
	
	@Test
	public void testFindTextLigneConseilByRecetteId() {
		// PREPARE
		StringBuffer expected = new StringBuffer();
		final Recette recette = new Recette();
		recette.setLabel("recette");
		recRepo.save(recette);
		final List<LigneConseil> conseils = new ArrayList<LigneConseil>();
		LigneConseil ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneConseil(Integer.toString(i));
			ligne.setEntite(recette);
			conseils.add(ligne);
			expected.append(i);
			expected.append(String.format("%n", ""));
		}
		lcRepo.save(conseils);
		// WHEN
		String result = lcService.findTextLigneConseilByEntite(recette.getId(), Recette.class);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals(expected.toString(), result);
	}
	
	@Test
	public void testFindTextLigneConseilByRecetteIdSansInstructions() {
		// PREPARE
		final Recette recette = new Recette();
		recette.setLabel("recette");
		recRepo.save(recette);
		// WHEN
		String result = lcService.findTextLigneConseilByEntite(recette.getId(), Recette.class);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals("Cette recette n'a pas encore de conseils associés.", result);
	}
	
	@Test
	public void testFindTextLigneConseilByIngredientId() {
		// PREPARE
		StringBuffer expected = new StringBuffer();
		final Ingredient ingredient = new Ingredient();
		ingredient.setLabel("ingredient");
		ingRepo.save(ingredient);
		final List<LigneConseil> instructions = new ArrayList<LigneConseil>();
		LigneConseil ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneConseil(Integer.toString(i));
			ligne.setEntite(ingredient);
			instructions.add(ligne);
			expected.append(i);
			expected.append(String.format("%n", ""));
		}
		lcRepo.save(instructions);
		// WHEN
		String result = lcService.findTextLigneConseilByEntite(ingredient.getId(),Ingredient.class);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals(expected.toString(), result);
	}
	
	@Test
	public void testFindTextLigneConseilByIngredientIdSansInstructions() {
		// PREPARE
		final Ingredient ingredient = new Ingredient();
		ingredient.setLabel("ingredient");
		ingRepo.save(ingredient);
		// WHEN
		String result = lcService.findTextLigneConseilByEntite(ingredient.getId(),Ingredient.class);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals("Cet ingrédient n'a pas encore de conseils associés.", result);
	}
	
	@Test
	public void testFindTextLigneConseilByEntiteMauvaiseClasse() {
		// WHEN
		String result = lcService.findTextLigneConseilByEntite(3L, Entite.class);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals("", result);
	}
}
