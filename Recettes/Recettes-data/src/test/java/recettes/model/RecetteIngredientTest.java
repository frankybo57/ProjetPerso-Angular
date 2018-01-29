package recettes.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @see
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RecetteIngredientTest {
	
	@Test
	public void testConstructeur() {
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		
		Assert.assertNotNull(recetteIngredient);
	}
	
	@Test
	public void testAccesseursId() {
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		recetteIngredient.setId((long) 75);
		Long id = recetteIngredient.getId();
		
		Assert.assertEquals(75L,id.longValue());
	}
	
	@Test
	public void testAccesseursVersion() {
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		recetteIngredient.setVersion(57);
		int version = recetteIngredient.getVersion();
		
		Assert.assertEquals(57,version);
	}
	
	@Test
	public void testAccesseurRecette() {
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		Recette recette = new Recette();
		recette.setLabel("compote");
		recetteIngredient.setRecette(recette);
		
		Assert.assertEquals("compote", recetteIngredient.getRecette().getLabel());
	}
	
	@Test
	public void testAccesseurIngredient() {
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		Ingredient ingredient = new Ingredient("pomme");
		recetteIngredient.setIngredient(ingredient);
		
		Assert.assertEquals("pomme", recetteIngredient.getIngredient().getLabel());
	}
	
	@Test
	public void testAccesseurQuantie() {
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		recetteIngredient.setQuantite("10 kilos");
		
		Assert.assertEquals("10 kilos", recetteIngredient.getQuantite());
	}
}
