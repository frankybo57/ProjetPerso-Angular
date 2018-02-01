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
@ContextConfiguration("/applicationtestContext.xml")
public class TypePlatTest {

	@Test
	public void testTypePlatConstructeurSimple() {
		TypePlat typePlat = new TypePlat();
		
		Assert.assertNotNull(typePlat);
	}
	
	@Test
	public void testTypePlatConstructeurParametres() {
		TypePlat typePlat = new TypePlat("type plat","type");
		
		Assert.assertNotNull(typePlat);
		Assert.assertEquals("type plat", typePlat.getLabel());
		Assert.assertEquals("type", typePlat.getAncre());
	}
	
	@Test
	public void testAccesseursId() {
		
		TypePlat typePlat = new TypePlat();
		Long id = 5L;
		typePlat.setId(id);
		
		Assert.assertEquals(id, typePlat.getId());
	}
	
	@Test
	public void testAccesseursVersion() {
		TypePlat typePlat = new TypePlat();
		typePlat.setVersion(57);
		int version = typePlat.getVersion();
		
		Assert.assertEquals(57,version);
	}
	
	@Test
	public void testAccesseursLabel() {
		TypePlat typePlat = new TypePlat();
		typePlat.setLabel("label_choisi_au_hasard");
		String label = typePlat.getLabel();
		
		Assert.assertEquals("label_choisi_au_hasard",label);
	}
	
	@Test
	public void testAccesseursAncre() {
		TypePlat typePlat = new TypePlat();
		typePlat.setAncre("ancre_choisi_au_hasard");
		String ancre = typePlat.getAncre();
		
		Assert.assertEquals("ancre_choisi_au_hasard",ancre);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAccesseursRecette() {
		TypePlat typePlat = new TypePlat();
		List liste = new ArrayList();
		Recette recette = new Recette();
		recette.setLabel("Compote");
		liste.add(recette);
		recette = new Recette();
		recette.setLabel("terrine");
		liste.add(recette);
		
		typePlat.setListeRecettes(liste);
		
		List<Recette> resultat = typePlat.getListeRecettes();
		
		Assert.assertNotNull(resultat);
		Assert.assertEquals(2, liste.size());
		Assert.assertEquals("Compote", resultat.get(0).getLabel());
		Assert.assertEquals("terrine", resultat.get(1).getLabel());
	}
	
	@Test
	public void testHashCode() {
		TypePlat typePlat = new TypePlat();
		
		Assert.assertEquals((Integer)(31*31*31), (Integer)typePlat.hashCode());
	}
	
}
