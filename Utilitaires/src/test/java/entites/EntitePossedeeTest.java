package entites;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class EntitePossedeeTest {

	@Test
	public void testConstructeur() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		
		Assert.assertNotNull(entite);
	}
	
	@Test
	public void testConstructeur2() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl("module");
		
		Assert.assertNotNull(entite);
		Assert.assertNotNull(entite.getLabel());
		Assert.assertEquals("module", entite.getLabel());
	}
	
	@Test
	public void testConstructeur3() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl("module",3);
		
		Assert.assertNotNull(entite);
		Assert.assertNotNull(entite.getLabel());
		Assert.assertEquals("module", entite.getLabel());
		Assert.assertNotNull(entite.getUtilisateur());
		Assert.assertEquals((Integer)3, entite.getUtilisateur());
	}
	
	@Test
	public void testConstructeur4() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl("module",3,true);
		
		Assert.assertNotNull(entite);
		Assert.assertNotNull(entite.getLabel());
		Assert.assertEquals("module", entite.getLabel());
		Assert.assertNotNull(entite.getUtilisateur());
		Assert.assertEquals((Integer)3, entite.getUtilisateur());
		Assert.assertNotNull(entite.getPrive());
		Assert.assertTrue(entite.getPrive());
		Assert.assertFalse(entite.isVisible());
	}
	
	@Test
	public void testAccesseursLabel() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setLabel("nom");
		Assert.assertNotNull(entite.getLabel());
		Assert.assertEquals("nom", entite.getLabel());
	}
	
	@Test
	public void testAccesseursUtilisateur() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setUtilisateur(45);
		Assert.assertEquals((Integer) 45, (Integer)entite.getUtilisateur());
	}
	
	@Test
	public void testAccesseursVisibilite() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setPrive(false);
		Assert.assertEquals(Boolean.FALSE, entite.getPrive());
		Assert.assertTrue(entite.isVisible());
	}
	
	@Test
	public void testHashToutNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		Assert.assertEquals((Integer) (31*31*31), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNonNullVersionNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(48L);
		Assert.assertEquals((Integer) (31*(31+48)*31), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNullVersionNonNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setVersion(2);
		Assert.assertEquals((Integer) ((31*31+2)*31), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNonNullVersionNonNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(5L);
		entite.setVersion(2);
		Assert.assertEquals((Integer) (((31+5)*31+2)*31), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNonNullVersionNonNullLabelNonNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(5L);
		entite.setVersion(2);
		entite.setLabel("nom");
		Assert.assertEquals((Integer) (((31+5)*31+2)*31+"nom".hashCode()), (Integer)entite.hashCode());
	}
	
	@Test
	public void testEqualsMemePointeur() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		EntitePossedeeImpl entite2 = entite;
		Assert.assertEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsObjNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		EntitePossedeeImpl entite2 = null;
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsObjAutreClasse() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		Object entite2 = new Object();
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsDeuxIdNullLabelsNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		Assert.assertEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdNullIdAutreNonNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(1L);
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsDifferents() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(2L);
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(1L);
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionDifferentes() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(2L);
		entite.setVersion(1);
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(2L);
		entite2.setVersion(2);
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionEgales() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(2L);
		entite.setVersion(0);
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(2L);
		entite2.setVersion(0);
		Assert.assertEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionEgalesLabelNullAutreNonNull() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(2L);
		entite.setVersion(0);
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(2L);
		entite2.setVersion(0);
		entite2.setLabel("nom");
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionEgalesLabelsInegaux() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(2L);
		entite.setVersion(0);
		entite.setLabel("prenom");
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(2L);
		entite2.setVersion(0);
		entite2.setLabel("nom");
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionEgalesLabelsEgaux() {
		EntitePossedeeImpl entite = new EntitePossedeeImpl();
		entite.setId(2L);
		entite.setVersion(0);
		entite.setLabel("nom");
		EntitePossedeeImpl entite2 = new EntitePossedeeImpl();
		entite2.setId(2L);
		entite2.setVersion(0);
		entite2.setLabel("nom");
		Assert.assertEquals(entite, entite2);
	}
}
