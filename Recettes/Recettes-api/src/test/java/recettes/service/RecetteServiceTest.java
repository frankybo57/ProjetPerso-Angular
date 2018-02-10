package recettes.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.RecetteIngredient;
import recettes.model.TypeIngredient;
import recettes.model.TypePlat;
import recettes.repository.IngredientRepository;
import recettes.repository.RecetteIngredientRepository;
import recettes.repository.RecetteRepository;
import recettes.repository.TypeIngredientRepository;
import recettes.repository.TypePlatRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class RecetteServiceTest {

	@Autowired
	IngredientRepository ingRepo;
	@Autowired
	IngredientService ingService;	
	@Autowired
	TypeIngredientRepository tiRepo;
	@Autowired
	TypePlatRepository tpRepo;
	@Autowired
	RecetteIngredientRepository riRepo;
	@Autowired
	RecetteRepository recRepo;
	@Autowired
	RecetteService recService;
	
	TypePlat typePlatRef;
	
	@After
	public void deleteAll() {
		if(!riRepo.findAll().isEmpty()) {
			riRepo.deleteAll();
		}
		if(!recRepo.findAll().isEmpty()) {
			recRepo.deleteAll();
		}
		if(!tpRepo.findAll().isEmpty()) {
			tpRepo.deleteAll();
		}
		if(!ingRepo.findAll().isEmpty()) {
			ingRepo.deleteAll();
		}
		if(!tiRepo.findAll().isEmpty()) {
			tiRepo.deleteAll();
		}
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(ingRepo);
		Assert.assertNotNull(tiRepo);
		Assert.assertNotNull(recRepo);
		Assert.assertNotNull(riRepo);
		Assert.assertNotNull(tpRepo);
	}
	
	public void preparation() {
		typePlatRef = new TypePlat("Fromage", "fromage");
		typePlatRef = tpRepo.save(typePlatRef);
		Recette recette = new Recette();
		recette.setLabel("Fondue Savoyarde");
		recette.setTypePlat(typePlatRef);
		recette = recRepo.save(recette);
		
		TypeIngredient typeIngredient = new TypeIngredient("Fromage");
		typeIngredient = tiRepo.save(typeIngredient);
		Ingredient ingredient = new Ingredient("Comté",typeIngredient);
		ingredient = ingRepo.save(ingredient);
		
		RecetteIngredient recing = new RecetteIngredient();
		recing.setIngredient(ingredient);
		recing.setRecette(recette);
		riRepo.save(recing);
		
		TypePlat typePlat = new TypePlat("Soupe","soupe");
		typePlat = tpRepo.save(typePlat);
		recette = new Recette();
		recette.setLabel("Soupe à l'oignon");
		recette.setTypePlat(typePlat);
		recRepo.save(recette);
		
		recette = new Recette();
		recette.setLabel("Soufflé au fromage");
		recette.setTypePlat(typePlatRef);
		recRepo.save(recette);
		
		recing = new RecetteIngredient();
		recing.setIngredient(ingredient);
		recing.setRecette(recette);
		recing = riRepo.save(recing);
		
		recette = new Recette();
		recette.setLabel("Autre recette");
		recRepo.save(recette);
		
	}
	
	@Test
	public void testFindAll() {
		// PREPARE
		preparation();
		final int expected = 4;
		// WHEN
		final List<Recette> resultList = recService.findAll();
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(expected ,resultList.size());
	}
	
	@Test
	public void testFindAllBaseVide() {
		// PREPARE
		final int expected = 0;
		// WHEN
		final List<Recette> resultList = recService.findAll();
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(expected ,resultList.size());
	}
	
	@Test
	public void testFindAllByTypePlat() {
		// PREPARE
		preparation();
		final int expected = 2;
		// WHEN
		final List<Recette> resultList = recService.findAllByTypePlat(typePlatRef);
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(expected ,resultList.size());
	}
	
	@Test
	public void testFindAllByTypePlatBaseVide() {
		// PREPARE
		final int expected = 0;
		// WHEN
		final List<Recette> resultList = recService.findAllByTypePlat(typePlatRef);
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(expected ,resultList.size());
	}
	
	@Test
	public void testFindAllByTypePlatSansRecette() {
		// PREPARE
		preparation();
		final int expected = 0;
		TypePlat typePlat = new TypePlat("typePlat","ancre");
		typePlat = tpRepo.save(typePlat);
		// WHEN
		final List<Recette> resultList = recService.findAllByTypePlat(typePlat);
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(expected ,resultList.size());
	}
	
	@Test
	public void testFindAllSansTypePlat() {
		// PREPARE
		preparation();
		final int expected = 1;
		// WHEN
		final List<Recette> resultList = recService.findAllSansTypePlat();
		// ASSERT
		Assert.assertNotNull(resultList);
		Assert.assertEquals(expected ,resultList.size());
	}
	
}
