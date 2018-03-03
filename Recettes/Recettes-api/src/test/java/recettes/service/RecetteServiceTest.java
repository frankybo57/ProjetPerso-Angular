package recettes.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
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
	
	@Before
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
	
	@Test
	public void testFindOne() {
		// PREPARE
		Recette recette = new Recette();
		recette.setLabel("recette1");
		recRepo.save(recette);
		recette = new Recette();
		recette.setLabel("recette2");
		final long id = (recRepo.save(recette)).getId();
		recette = new Recette();
		recette.setLabel("recette3");
		recRepo.save(recette);
		// WHEN
		final Recette result = recService.findOne(id);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals("recette2", result.getLabel());
	}
	
	@Test
	public void testFindOneBaseVide() {
		// WHEN
		final Recette result = recService.findOne(3L);
		// ASSERT
		Assert.assertNull(result);
	}
	
	@Test
	public void testDelete() {
		// PREPARE
		Recette recette = new Recette();
		recette.setLabel("recette1");
		recRepo.save(recette);
		recette = new Recette();
		recette.setLabel("recette2");
		final long id = (recRepo.save(recette)).getId();
		recette = new Recette();
		recette.setLabel("recette3");
		recRepo.save(recette);
		// WHEN
		recService.delete(id);
		// ASSERT
		Assert.assertNull(recService.findOne(id));
		Assert.assertEquals(2, recRepo.count());
	}
	
	@Test
	public void testFindAllByIngredient() {
		// PREPARE
		TypeIngredient typeIngredient1 = new TypeIngredient("ty");
		typeIngredient1 = tiRepo.save(typeIngredient1);
		TypeIngredient typeIngredient2 = new TypeIngredient("ty2");
		typeIngredient1 = tiRepo.save(typeIngredient2);
		Ingredient ingredient1 = new Ingredient("ingredient1",typeIngredient1);
		ingredient1 = ingRepo.save(ingredient1);
		Ingredient ingredient2 = new Ingredient("ingredient2",typeIngredient2);
		ingredient2 = ingRepo.save(ingredient2);
		Recette recette1 = new Recette();
		recette1.setLabel("recette1");
		recette1 = recRepo.save(recette1);
		Recette recette2 = new Recette();
		recette2.setLabel("recette2");
		recette2 = recRepo.save(recette2);
		Recette recette3 = new Recette();
		recette3.setLabel("recette3");
		recette3 = recRepo.save(recette3);
		final Recette recette4 = new Recette();
		recette4.setLabel("recette4");
		recRepo.save(recette4);
		final RecetteIngredient recetteIngredient11 = new RecetteIngredient();
		recetteIngredient11.setRecette(recette1);
		recetteIngredient11.setIngredient(ingredient1);
		riRepo.save(recetteIngredient11);
		final RecetteIngredient recetteIngredient21 = new RecetteIngredient();
		recetteIngredient21.setRecette(recette2);
		recetteIngredient21.setIngredient(ingredient1);
		riRepo.save(recetteIngredient21);
		final RecetteIngredient recetteIngredient22 = new RecetteIngredient();
		recetteIngredient22.setRecette(recette2);
		recetteIngredient22.setIngredient(ingredient2);
		riRepo.save(recetteIngredient22);
		final RecetteIngredient recetteIngredient32 = new RecetteIngredient();
		recetteIngredient32.setRecette(recette3);
		recetteIngredient32.setIngredient(ingredient2);
		riRepo.save(recetteIngredient32);
		// WHEN
		final List<Recette> result = recService.findAllByIngredient(ingredient1);
		// ASSERT
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void testFindAllByDifficulte() {
		// PREPARE
		Recette recette;
		for(int i=0; i<15; i++) {
			recette = new Recette();
			recette.setLabel("recette "+i);
			recette.setDifficulte((short) (i%5+1));
			recRepo.save(recette);
		}
		// WHEN
		final List<Recette> liste = recService.findAllByDifficulte((short) 1);
		// ASSERT
		Assert.assertEquals(3, liste.size());
	}
	
}
