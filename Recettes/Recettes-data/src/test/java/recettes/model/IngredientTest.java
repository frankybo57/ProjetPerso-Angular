package recettes.model;

import java.util.ArrayList;
import java.util.List;

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
public class IngredientTest {

	@Test
	public void testConstructeur() {
		Ingredient ingredient = new Ingredient();
		
		Assert.assertNotNull(ingredient);
	}
	
	@Test
	public void testConstructeur2() {
		Ingredient ingredient = new Ingredient("pomme");
		
		Assert.assertNotNull(ingredient);
		Assert.assertEquals("pomme", ingredient.getLabel());
	}
	
	@Test
	public void testConstructeur3() {
		TypeIngredient typeIngredient = new TypeIngredient("fruit");
		Ingredient ingredient = new Ingredient("pomme",typeIngredient);
		
		Assert.assertNotNull(ingredient);
		Assert.assertEquals("pomme", ingredient.getLabel());
		Assert.assertEquals("fruit", ingredient.getTypeIngredient().getLabel());
	}
	
	@Test
	public void testAccesseursId() {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(75L);
		Long id = ingredient.getId();
		
		Assert.assertEquals(75L,id.longValue());
	}
	
	@Test
	public void testAccesseursVersion() {
		Ingredient ingredient = new Ingredient();
		ingredient.setVersion(57);
		int version = ingredient.getVersion();
		
		Assert.assertEquals(57,version);
	}
	
	@Test
	public void testAccesseursLabel() {
		Ingredient ingredient = new Ingredient();
		ingredient.setLabel("label_choisi_au_hasard");
		String label = ingredient.getLabel();
		
		Assert.assertEquals("label_choisi_au_hasard",label);
	}
	
	@Test
	public void testAccesseursTypeIngredient() {
		TypeIngredient typeIngredient = new TypeIngredient();
		
		Ingredient ingredient = new Ingredient();
		ingredient.setTypeIngredient(typeIngredient);
		
		Assert.assertEquals(typeIngredient,ingredient.getTypeIngredient());
	}
	
	@Test
	public void testAccesseursCout() {
		Short Cout = Short.valueOf("3");
		
		Ingredient ingredient = new Ingredient();
		ingredient.setCout(Cout);
		
		Assert.assertEquals(Cout,ingredient.getCout());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAccesseursRecetteIngredient() {
		RecetteIngredient recetteIngredient1 = new RecetteIngredient();
		RecetteIngredient recetteIngredient2 = new RecetteIngredient();
		List listeRecetteIngredient = new ArrayList();
		listeRecetteIngredient.add(recetteIngredient1);
		listeRecetteIngredient.add(recetteIngredient2);
		Ingredient ingredient = new Ingredient();
		
		ingredient.setListeRecetteIngredient(listeRecetteIngredient);
		
		List resultat = ingredient.getListeRecetteIngredient();
		
		Assert.assertNotNull(listeRecetteIngredient);
		Assert.assertEquals(listeRecetteIngredient.size(),resultat.size());
		
		for(int i=0; i<resultat.size(); i++) {
			Assert.assertEquals(listeRecetteIngredient.get(i), resultat.get(i));
		}
	}
	
	@Test
	public void testAccesseursUtilisateur() {
		Ingredient ingredient = new Ingredient();
		ingredient.setUtilisateur(453);
		
		Assert.assertEquals(453,ingredient.getUtilisateur().intValue());
	}
	
	@Test
	public void testAccesseursPrive() {
		Ingredient ingredient = new Ingredient();
		ingredient.setPrive(Boolean.TRUE);
		
		Assert.assertEquals(Boolean.TRUE,ingredient.getPrive());
		Assert.assertEquals(true,ingredient.isVisible());
	}
	
	@Test
	public void testAccesseursConseils() {
		String conseil = "conseil";
		Ingredient ingredient = new Ingredient();
		ingredient.setConseils(conseil);
		
		Assert.assertEquals(conseil,ingredient.getConseils());
	}
	
	@Test
	public void testAccesseursImage() {
		byte[] image = {0,1,0,1,1,1,0};
		Ingredient ingredient = new Ingredient();
		ingredient.setImage(image);
		
		Assert.assertEquals(image,ingredient.getImage());
	}
	
	@Test
	public void testHashCodeInegaux() {
		Ingredient ingredient1 = new Ingredient("ingredient1");
		Ingredient ingredient2 = new Ingredient();
		
		Assert.assertNotEquals(ingredient1.hashCode(), ingredient2.hashCode());
	}
	
	@Test
	public void testHashCodeEgaux() {
		Ingredient ingredient1 = new Ingredient("ingredient1");
		Ingredient ingredient2 = new Ingredient("ingredient1");
		
		Assert.assertEquals(ingredient1.hashCode(), ingredient2.hashCode());
	}
}
