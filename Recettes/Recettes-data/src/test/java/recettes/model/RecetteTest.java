package recettes.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
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
public class RecetteTest {

	@Test
	public void testConstructeur() {
		Recette recette = new Recette();
		
		Assert.assertNotNull(recette);
	}
	
	@Test
	public void testAccesseursId() {
		Recette recette = new Recette();
		recette.setId(75L);
		Long id = recette.getId();
		
		Assert.assertEquals(75,id.intValue());
	}
	
	@Test
	public void testAccesseursVersion() {
		Recette recette = new Recette();
		recette.setVersion(57);
		int version = recette.getVersion();
		
		Assert.assertEquals(57,version);
	}
	
	@Test
	public void testAccesseursLabel() {
		Recette recette = new Recette();
		recette.setLabel("label_choisi_au_hasard");
		String label = recette.getLabel();
		
		Assert.assertEquals("label_choisi_au_hasard",label);
	}
	
	@Test
	public void testAccesseursTypePlat() {
		TypePlat typePlat = new TypePlat();
		
		Recette recette = new Recette();
		recette.setTypePlat(typePlat);
		
		Assert.assertEquals(typePlat,recette.getTypePlat());
	}
	
	@Test
	public void testAccesseursDifficulte() {
		Short difficulte = Short.valueOf("5");
		
		Recette recette = new Recette();
		recette.setDifficulte(difficulte);
		
		Assert.assertEquals(difficulte,recette.getDifficulte());
	}
	
	@Test
	public void testAccesseursTempsPreparation() {
		String tempsPreparation = "trop_long";
		Recette recette = new Recette();
		recette.setTempsPreparation(tempsPreparation);
		
		Assert.assertEquals(tempsPreparation,recette.getTempsPreparation());
	}
	
	@Test
	public void testAccesseursTempsRepos() {
		String tempsRepos = "trop_court";
		Recette recette = new Recette();
		recette.setTempsRepos(tempsRepos);
		
		Assert.assertEquals(tempsRepos,recette.getTempsRepos());
	}
	
	@Test
	public void testAccesseursTempsCuisson() {
		String tempsCuisson = "moyen";
		Recette recette = new Recette();
		recette.setTempsCuisson(tempsCuisson);
		
		Assert.assertEquals(tempsCuisson,recette.getTempsCuisson());
	}
	
	@Test
	public void testAccesseursCout() {
		Short Cout = Short.valueOf("3");
		
		Recette recette = new Recette();
		recette.setCout(Cout);
		
		Assert.assertEquals(Cout,recette.getCout());
	}
	
	@Test
	public void testAccesseursNombreCouverts() {
		Short NombreCouverts = Short.valueOf("8");
		
		Recette recette = new Recette();
		recette.setNombreCouverts(NombreCouverts);
		
		Assert.assertEquals(NombreCouverts,recette.getNombreCouverts());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAccesseursRecetteIngredient() {
		RecetteIngredient recetteIngredient1 = new RecetteIngredient();
		RecetteIngredient recetteIngredient2 = new RecetteIngredient();
		List listeRecetteIngredient = new ArrayList();
		listeRecetteIngredient.add(recetteIngredient1);
		listeRecetteIngredient.add(recetteIngredient2);
		Recette recette = new Recette();
		
		recette.setListeRecetteIngredient(listeRecetteIngredient);
		
		List resultat = recette.getListeRecetteIngredient();
		
		Assert.assertEquals(listeRecetteIngredient.size(),resultat.size());
		
		for(int i=0; i<resultat.size(); i++) {
			Assert.assertEquals(listeRecetteIngredient.get(i), resultat.get(i));
		}
	}
	
	@Test
	public void testAccesseursInstructions() {
		String instruction = "consigne";
		Recette recette = new Recette();
		recette.setInstructions(instruction);
		
		Assert.assertEquals(instruction,recette.getInstructions());
	}
	
	@Test
	public void testAccesseursConseils() {
		String conseil = "conseil";
		Recette recette = new Recette();
		recette.setConseils(conseil);
		
		Assert.assertEquals(conseil,recette.getConseils());
	}
	
	@Test
	public void testAccesseursImage() {
		byte[] image = {0,1,0,1,1,1,0};
		Recette recette = new Recette();
		recette.setImage(image);
		
		Assert.assertEquals(image,recette.getImage());
	}
	
	@Test
	public void testAccesseursVideo() {
		byte[] video = {0,1,0,1,1,1,0};
		Recette recette = new Recette();
		recette.setVideo(video);
		
		Assert.assertEquals(video,recette.getVideo());
	}
	
	@Test
	public void testAccesseursUtilisateur() {
		Recette recette = new Recette();
		recette.setUtilisateur(453);
		
		Assert.assertEquals(453,recette.getUtilisateur().intValue());
	}
	
	@Test
	public void testAccesseursPrive() {
		Recette recette = new Recette();
		recette.setPrive(Boolean.TRUE);
		
		Assert.assertEquals(Boolean.TRUE,recette.getPrive());
		Assert.assertEquals(true,recette.isVisible());
	}
}
