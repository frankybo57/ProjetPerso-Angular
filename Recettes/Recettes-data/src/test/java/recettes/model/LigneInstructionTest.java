package recettes.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import constantes.Constantes;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class LigneInstructionTest {

	@Test
	public void testConstructeur() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		Assert.assertNotNull(ligneInstruction);
	}
	
	@Test
	public void testConstructeurAvecParametre() {
		LigneInstruction ligneInstruction = new LigneInstruction("instruction");
		Assert.assertNotNull(ligneInstruction);
		Assert.assertNotNull(ligneInstruction.getInstruction());
		Assert.assertEquals("instruction", ligneInstruction.getInstruction());
	}
	
	@Test
	public void testAccesseursLabel() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		ligneInstruction.setInstruction("instruction");
		Assert.assertEquals("instruction", ligneInstruction.getInstruction());
	}
	
	@Test
	public void testAccesseursRecette() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		Recette recette = new Recette();
		recette.setLabel("recettetest");
		ligneInstruction.setRecette(recette);
		Assert.assertNotNull(ligneInstruction.getRecette());
		Assert.assertEquals("recettetest", ligneInstruction.getRecette().getLabel());
	}
	
	@Test
	public void testEqualsEgalite() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		ligneInstruction.setInstruction("instruction");
		LigneInstruction ligneInstruction2 = new LigneInstruction();
		ligneInstruction2.setInstruction("instruction");
		Assert.assertTrue(ligneInstruction.equals(ligneInstruction2));
	}
	
	@Test
	public void testEqualsIdDifferents() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		ligneInstruction.setInstruction("instruction");
		ligneInstruction.setId(1L);
		LigneInstruction ligneInstruction2 = new LigneInstruction();
		ligneInstruction2.setInstruction("instruction");
		ligneInstruction2.setId(2L);
		Assert.assertFalse(ligneInstruction.equals(ligneInstruction2));
	}
	
	@Test
	public void testEqualsInstructionsNulles() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		LigneInstruction ligneInstruction2 = new LigneInstruction();
		Assert.assertTrue(ligneInstruction.equals(ligneInstruction2));
	}
	
	@Test
	public void testEqualsInstructionsNulleEtNonNulle() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		LigneInstruction ligneInstruction2 = new LigneInstruction();
		ligneInstruction2.setInstruction("instruction");
		Assert.assertFalse(ligneInstruction.equals(ligneInstruction2));
	}
	
	@Test
	public void testHashCodeVide() {
		LigneInstruction ligneInstruction = new LigneInstruction();
		Assert.assertEquals(31*31*31*31, ligneInstruction.hashCode());
	}
	
	@Test
	public void testHashCodePlein() {
		String instruction = "instruction";
		Recette recette = new Recette();
		LigneInstruction ligneInstruction = new LigneInstruction();
		ligneInstruction.setInstruction(instruction);
		ligneInstruction.setRecette(recette);
		final int expected = ((((31*31)*Constantes.PRIME)+recette.hashCode())*Constantes.PRIME)+instruction.hashCode();
		Assert.assertEquals(expected, ligneInstruction.hashCode());
	}
}
