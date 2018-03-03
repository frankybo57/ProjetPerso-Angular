package recettes.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import constantes.Constantes;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class LigneConseilTest {

	@Test
	public void testConstructeur() {
		LigneConseil ligneConseil = new LigneConseil();
		Assert.assertNotNull(ligneConseil);
	}
	
	@Test
	public void testConstructeurAvecParametre() {
		LigneConseil ligneConseil = new LigneConseil("instruction");
		Assert.assertNotNull(ligneConseil);
		Assert.assertNotNull(ligneConseil.getConseil());
		Assert.assertEquals("instruction", ligneConseil.getConseil());
	}
	
	@Test
	public void testAccesseursLabel() {
		LigneConseil ligneConseil = new LigneConseil();
		ligneConseil.setConseil("instruction");
		Assert.assertEquals("instruction", ligneConseil.getConseil());
	}
	
	@Test
	public void testAccesseursRecette() {
		LigneConseil ligneConseil = new LigneConseil();
		Recette recette = new Recette();
		recette.setLabel("recettetest");
		ligneConseil.setEntite(recette);
		Recette retour = (Recette) ligneConseil.getEntite();
		Assert.assertNotNull(retour);
		Assert.assertEquals("recettetest", retour.getLabel());
	}
	
	@Test
	public void testEqualsEgalite() {
		LigneConseil ligneConseil = new LigneConseil();
		ligneConseil.setConseil("instruction");
		LigneConseil ligneConseil2 = new LigneConseil();
		ligneConseil2.setConseil("instruction");
		Assert.assertTrue(ligneConseil.equals(ligneConseil2));
	}
	
	@Test
	public void testEqualsIdDifferents() {
		LigneConseil ligneConseil = new LigneConseil();
		ligneConseil.setConseil("instruction");
		ligneConseil.setId(1L);
		LigneConseil ligneConseil2 = new LigneConseil();
		ligneConseil2.setConseil("instruction");
		ligneConseil2.setId(2L);
		Assert.assertFalse(ligneConseil.equals(ligneConseil2));
	}
	
	@Test
	public void testEqualsInstructionsNulles() {
		LigneConseil ligneConseil = new LigneConseil();
		LigneConseil ligneConseil2 = new LigneConseil();
		Assert.assertTrue(ligneConseil.equals(ligneConseil2));
	}
	
	@Test
	public void testEqualsInstructionsNulleEtNonNulle() {
		LigneConseil ligneConseil = new LigneConseil();
		LigneConseil ligneConseil2 = new LigneConseil();
		ligneConseil2.setConseil("instruction");
		Assert.assertFalse(ligneConseil.equals(ligneConseil2));
	}
	
	@Test
	public void testHashCodeVide() {
		LigneConseil ligneConseil = new LigneConseil();
		Assert.assertEquals(31*31*31*31, ligneConseil.hashCode());
	}
	
	@Test
	public void testHashCodePlein() {
		String instruction = "instruction";
		Recette recette = new Recette();
		LigneConseil ligneConseil = new LigneConseil();
		ligneConseil.setConseil(instruction);
		ligneConseil.setEntite(recette);
		final int expected = ((((31*31)*Constantes.PRIME)+recette.hashCode())*Constantes.PRIME)+instruction.hashCode();
		Assert.assertEquals(expected, ligneConseil.hashCode());
	}
	
	@Test
	public void testSetEntiteRecette() {
		// PREPARE
		LigneConseil conseil = new LigneConseil();
		Recette recette = new Recette();
		// WHEN
		conseil.setEntite(recette);
		// ASSERT
		Assert.assertNull(conseil.getIngredient());
		Assert.assertNotNull(conseil.getRecette());
	}
	
	@Test
	public void testSetEntiteIngredient() {
		// PREPARE
		LigneConseil conseil = new LigneConseil();
		Ingredient ingredient = new Ingredient();
		// WHEN
		conseil.setEntite(ingredient);
		// ASSERT
		Assert.assertNull(conseil.getRecette());
		Assert.assertNotNull(conseil.getIngredient());
	}
	
	@Test
	public void testGetEntiteRecette() {
		// PREPARE
		LigneConseil conseil = new LigneConseil();
		Recette recette = new Recette();
		// WHEN
		conseil.setRecette(recette);
		// ASSERT
		Assert.assertTrue(conseil.getEntite() instanceof Recette);
	}
	
	@Test
	public void testGetEntiteIngredient() {
		// PREPARE
		LigneConseil conseil = new LigneConseil();
		Ingredient ingredient = new Ingredient();
		// WHEN
		conseil.setIngredient(ingredient);
		// ASSERT
		Assert.assertTrue(conseil.getEntite() instanceof Ingredient);
	}
	
	@Test
	public void testGetEntiteNull() {
		// PREPARE
		LigneConseil conseil = new LigneConseil();
		// ASSERT
		Assert.assertNull(conseil.getEntite());
	}
	
	@Test
	public void testConstructeurComplexe() {
		// PREPARE
		Recette entite = new Recette();
		// WHEN
		LigneConseil ligne = new LigneConseil(entite);
		// ASSERT
		Assert.assertTrue(ligne.getEntite() instanceof Recette);
	}
	
	@Test
	public void testConstructeurComplexe2() {
		// PREPARE
		Ingredient entite = new Ingredient();
		// WHEN
		LigneConseil ligne = new LigneConseil(entite);
		// ASSERT
		Assert.assertTrue(ligne.getEntite() instanceof Ingredient);
	}
}
