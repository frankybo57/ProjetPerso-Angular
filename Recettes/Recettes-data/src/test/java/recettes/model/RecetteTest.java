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
@ContextConfiguration("/applicationtestContext.xml")
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
		List<LigneInstruction> instructions = new ArrayList<LigneInstruction>();
		LigneInstruction ligneInstruction = new LigneInstruction("consigne");
		instructions.add(ligneInstruction);
		
		Recette recette = new Recette();
		recette.setInstructions(instructions);
		
		Assert.assertEquals(instructions,recette.getInstructions());
	}
	
	@Test
	public void testAjouterInstruction() {
		List<LigneInstruction> instructions = new ArrayList<LigneInstruction>();
		LigneInstruction ligneInstruction = new LigneInstruction("consigne");
		instructions.add(ligneInstruction);
		ligneInstruction.setInstruction("consigne2");
		instructions.add(ligneInstruction);
	
		Recette recette = new Recette();
		recette.setInstructions(instructions);
		
		LigneInstruction instruction = new LigneInstruction("autre consigne");
		recette.ajouterLigneInstruction(instruction);
		
		Assert.assertNotNull(recette.getInstructions());
		Assert.assertEquals(3, recette.getInstructions().size());
	}
	
	@Test
	public void testAccesseursConseils() {
		String conseil = "conseil";
		LigneConseil ligne = new LigneConseil(conseil);
		List<LigneConseil> conseils = new ArrayList<LigneConseil>();
		conseils.add(ligne);
		Recette recette = new Recette();
		recette.setConseils(conseils);
		
		Assert.assertEquals(conseils,recette.getConseils());
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
		Assert.assertFalse(recette.isVisible());
	}
	
	@Test
	public void testHash() {
		Recette recette = new Recette();
		
		Assert.assertEquals((Integer) (31*31*31), (Integer)recette.hashCode());
	}
	
	@Test
	public void testEquals() {
		Recette recette1 = new Recette();
		recette1.setId(1L);
		recette1.setVersion(0);
		recette1.setLabel("marecette");
		recette1.setTypePlat(new TypePlat("type1", null));
		
		Recette recette2 = new Recette();
		recette2.setId(1L);
		recette2.setVersion(0);
		recette2.setLabel("marecette");
		recette2.setTypePlat(new TypePlat("type2", null));
		
		Assert.assertEquals(recette1, recette2);
	}
}
