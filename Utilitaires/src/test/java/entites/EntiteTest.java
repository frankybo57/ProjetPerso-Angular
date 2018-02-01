package entites;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class EntiteTest {
	
	@Test
	public void testConstructeur() {
		EntiteImpl entite = new EntiteImpl();
		
		Assert.assertNotNull(entite);
	}
	
	@Test
	public void testAccesseursId() {
		EntiteImpl entite = new EntiteImpl();
		entite.setId(78L);
		Assert.assertNotNull(entite.getId());
		Assert.assertEquals((Long)78L, entite.getId());
	}
	
	@Test
	public void testAccesseursVersion() {
		EntiteImpl entite = new EntiteImpl();
		entite.setVersion(45);
		Assert.assertEquals((Integer) 45, (Integer)entite.getVersion());
	}
	
	@Test
	public void testHashToutNull() {
		EntiteImpl entite = new EntiteImpl();
		Assert.assertEquals((Integer) (31*31), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNonNullVersionNull() {
		EntiteImpl entite = new EntiteImpl();
		entite.setId(48L);
		Assert.assertEquals((Integer) (31*(31+48)), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNullVersionNonNull() {
		EntiteImpl entite = new EntiteImpl();
		entite.setVersion(2);
		Assert.assertEquals((Integer) (31*31+2), (Integer)entite.hashCode());
	}
	
	@Test
	public void testHashIdNonNullVersionNonNull() {
		EntiteImpl entite = new EntiteImpl();
		entite.setId(5L);
		entite.setVersion(2);
		Assert.assertEquals((Integer) ((31+5)*31+2), (Integer)entite.hashCode());
	}
	
	@Test
	public void testEqualsMemePointeur() {
		EntiteImpl entite = new EntiteImpl();
		EntiteImpl entite2 = entite;
		Assert.assertEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsObjNull() {
		EntiteImpl entite = new EntiteImpl();
		EntiteImpl entite2 = null;
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsObjAutreClasse() {
		EntiteImpl entite = new EntiteImpl();
		Object entite2 = new Object();
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsDeuxIdNull() {
		EntiteImpl entite = new EntiteImpl();
		EntiteImpl entite2 = new EntiteImpl();
		Assert.assertEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdNullIdAutreNonNull() {
		EntiteImpl entite = new EntiteImpl();
		EntiteImpl entite2 = new EntiteImpl();
		entite2.setId(1L);
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsDifferents() {
		EntiteImpl entite = new EntiteImpl();
		entite.setId(2L);
		EntiteImpl entite2 = new EntiteImpl();
		entite2.setId(1L);
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionDifferentes() {
		EntiteImpl entite = new EntiteImpl();
		entite.setId(2L);
		entite.setVersion(1);
		EntiteImpl entite2 = new EntiteImpl();
		entite2.setId(2L);
		entite2.setVersion(2);
		Assert.assertNotEquals(entite, entite2);
	}
	
	@Test
	public void testEqualsIdsEgauxVersionEgales() {
		EntiteImpl entite = new EntiteImpl();
		entite.setId(2L);
		entite.setVersion(0);
		EntiteImpl entite2 = new EntiteImpl();
		entite2.setId(2L);
		entite2.setVersion(0);
		Assert.assertEquals(entite, entite2);
	}
}
