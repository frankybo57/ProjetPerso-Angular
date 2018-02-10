package recettes.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.IngredientException;
import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.RecetteIngredient;
import recettes.model.TypeIngredient;
import recettes.repository.IngredientRepository;
import recettes.repository.RecetteIngredientRepository;
import recettes.repository.RecetteRepository;
import recettes.repository.TypeIngredientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class IngredientServiceTest {

	@Autowired
	IngredientRepository ingRepo;
	@Autowired
	IngredientService ingService;	
	@Autowired
	TypeIngredientRepository tiRepo;
	@Autowired
	RecetteIngredientRepository riRepo;
	@Autowired
	RecetteRepository recRepo;
	
	Long id;
	TypeIngredient typeIngredientReference;
	Recette recette;
	
	@After
	public void deleteAll() {
		if(!riRepo.findAll().isEmpty()) {
			riRepo.deleteAll();
		}
		if(!recRepo.findAll().isEmpty()) {
			recRepo.deleteAll();
		}
		if(!ingRepo.findAll().isEmpty()) {
			ingRepo.deleteAll();
		}
		if(!tiRepo.findAll().isEmpty()) {
			tiRepo.deleteAll();
		}
		typeIngredientReference = null;
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(ingRepo);
		Assert.assertNotNull(tiRepo);
		Assert.assertNotNull(recRepo);
		Assert.assertNotNull(riRepo);
	}
	
	public void preparation() {
		recette = new Recette();
		recette.setLabel("Fondue Savoyarde");
		recette = recRepo.save(recette);
		
		TypeIngredient typeIngredient = new TypeIngredient("Fromage");
		typeIngredient = tiRepo.saveAndFlush(typeIngredient);
		Ingredient ingredient = new Ingredient("Comté", typeIngredient);
		ingredient.setCout((short) 4);
		ingredient = ingRepo.save(ingredient);
		
		RecetteIngredient recing = new RecetteIngredient();
		recing.setIngredient(ingredient);
		recing.setRecette(recette);
		riRepo.save(recing);
		
		typeIngredientReference = new TypeIngredient("Boeuf");
		typeIngredientReference = tiRepo.saveAndFlush(typeIngredientReference);
		ingredient = new Ingredient("Côte de boeuf", typeIngredientReference);
		ingredient.setCout((short) 3);
		ingRepo.save(ingredient);
		typeIngredient = new TypeIngredient("Volaille");
		typeIngredient = tiRepo.saveAndFlush(typeIngredient);
		ingredient = new Ingredient("Aile de poulet", typeIngredient);
		ingredient.setCout((short) 2);
		ingredient = ingRepo.save(ingredient);
		id = ingredient.getId();
		typeIngredient = new TypeIngredient("Céréale");
		typeIngredient = tiRepo.saveAndFlush(typeIngredient);
		ingredient = new Ingredient("Blé", typeIngredient);
		ingredient.setCout((short) 4);
		ingRepo.save(ingredient);
		typeIngredient = new TypeIngredient("Laitage");
		typeIngredient = tiRepo.saveAndFlush(typeIngredient);
		ingredient = new Ingredient("Yaourt", typeIngredient);
		ingredient.setCout((short) 5);
		ingRepo.save(ingredient);
		ingredient = new Ingredient("Paleron", typeIngredientReference);
		ingredient.setCout((short) 4);
		ingRepo.save(ingredient);
		ingredient = new Ingredient("Beaufort");
		ingredient = ingRepo.save(ingredient);
		
		recing = new RecetteIngredient();
		recing.setIngredient(ingredient);
		recing.setRecette(recette);
		riRepo.save(recing);
	}
	
	@Test
	public void testFindAll() {
		// PREPARE
		preparation();
		final int expected = 7;
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAll());
		final int result = ingService.findAll().size();
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testFindAllBaseVide() {
		// PREPARE
		final int expected = 0;
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAll());
		final int result = ingService.findAll().size();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testFindAllByTypeIngredient() {
		// PREPARE
		preparation();
		final int expected = 2;
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAllByTypeIngredient(typeIngredientReference));
		final int result = ingService.findAllByTypeIngredient(typeIngredientReference).size();
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testFindAllByTypeIngredientBaseVide() {
		// PREPARE
		preparation();
		final int expected = 0;
		TypeIngredient typeIngredient = new TypeIngredient("inexistant");
		typeIngredient = tiRepo.saveAndFlush(typeIngredient);
		// WHEN
		// ASSERT
		Assert.assertNotNull(ingService.findAllByTypeIngredient(typeIngredient));
		final int result = ingService.findAllByTypeIngredient(typeIngredient).size();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testFindAllByTypeIngredientSansIngredientCorrespondant() {
		// PREPARE
		final int expected = 0;
		TypeIngredient typeIngredient = new TypeIngredient("Porc");
		typeIngredient = tiRepo.saveAndFlush(typeIngredient);
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAllByTypeIngredient(typeIngredient));
		final int result = ingService.findAllByTypeIngredient(typeIngredient).size();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testFindAllByPrix() {
		// PREPARE
		preparation();
		final int expected = 3;
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAllByPrix((short) 4));
		final int result = ingService.findAllByPrix((short) 4).size();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testFindAllByPrixInexistant() {
		// PREPARE
		preparation();
		final int expected = 0;
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAllByPrix((short) 1));
		final int result = ingService.findAllByPrix((short) 1).size();
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testFindAllByPrixBaseVide() {
		// PREPARE
		final int expected = 0;
		// WHEN		
		// ASSERT
		Assert.assertNotNull(ingService.findAllByPrix((short) 5));
		final int result = ingService.findAllByPrix((short) 5).size();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testDelete() throws IngredientException {
		// PREPARE
		preparation();
		List<Ingredient> liste = ingRepo.findAll();
		// WHEN
		ingService.delete(liste.get(2).getId());
		// ASSERT
		Assert.assertEquals(liste.size()-1, ingRepo.findAll().size());
	}
	
	@Test(expected=IngredientException.class)
	public void testDeleteInexistant() throws IngredientException {
		ingService.delete((long) 975);
	}
	
	@Test
	public void testFind() {
		// PREPARE
		preparation();
		// WHEN
		Ingredient ingredient = ingService.find(id);
		// ASSERT
		Assert.assertNotNull(ingredient);
		Assert.assertEquals("Aile de poulet", ingredient.getLabel());
	}
	
	@Test
	public void testFindAllByRecette() {
		// PREPARE
		preparation();
		// WHEN
		final List<Ingredient> resultList = ingService.findAllByRecette(recette);
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(2, resultList.size());
	}
	
	@Test
	public void testFindAllByRecetteSansIngredient() {
		// PREPARE
		preparation();
		Recette recette2 = new Recette();
		recette2.setLabel("recettevide");
		recette2 = recRepo.save(recette2);
		// WHEN
		final List<Ingredient> resultList = ingService.findAllByRecette(recette2);
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(0, resultList.size());
	}
}
