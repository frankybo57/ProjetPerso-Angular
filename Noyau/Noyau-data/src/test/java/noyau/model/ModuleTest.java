package noyau.model;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;;



/**
 * @see
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class ModuleTest {
	
	/**
	 * Test des accesseurs de l'attribut "id" de Module.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursId(){
		Module module = new Module();
		
		module.setId(1L);	
		Assert.assertEquals((Long)1L, module.getId());
	}
	
	/**
	 * Test des accesseurs de l'attribut "version" de Module.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursVersion(){
		Module module = new Module();
		
		module.setVersion(0);
		Assert.assertEquals(0, module.getVersion());
	}
	
	/**
	 * Test des accesseurs de l'attribut "nom" de Module.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursHeader(){
		Module module = new Module();
		
		module.setHeader("nom");	
		Assert.assertEquals("nom", module.getHeader());
	}
	
	/**
	 * Test des accesseurs de l'attribut "nom" de Module.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursNom(){
		Module module = new Module();
		
		module.setNom("nom");	
		Assert.assertEquals("nom", module.getNom());
	}
	
	/**
	 * Test des accesseurs de l'attribut "etat" de Module.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursEtat(){
		Module module = new Module();
		
		module.setEtat(Etat.INACTIF);
		Assert.assertEquals(Etat.INACTIF, module.getEtat());
	}
	
	/**
	 * Test de la fonction "equals" de Module.class en cas d'égalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsEgaux(){
		Module module1 = new Module("module1");
		Module module2 = new Module("module1");
		
		Assert.assertEquals(true, module1.equals(module2));
	}
	
	/**
	 * Test de la fonction equals de Module.class en cas d'inégalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsInegaux(){
		Module module1 = new Module("module1");
		Module module2 = new Module("module2");
		
		Assert.assertEquals(false, module1.equals(module2));
	}
	
	/**
	 * Test de la fonction equals de Module.class en cas d'inégalité (deuxième objet null)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsObjetNull(){
		Module module1 = new Module("module1");
		Module module2 = null;
		
		Assert.assertEquals(false, module1.equals(module2));
	}
	
	/**
	 * Test de la fonction equals de Module.class en cas d'inégalité (deuxième objet null)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualsClasseDifferente(){
		Module module1 = new Module("module1");
		String module2 = "module2";
		
		Assert.assertNotEquals(true, module1.equals(module2));
	}
	
	/**
	 * Test de la fonction equals de Module.class en cas d'inégalité (un des deux noms nul)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsNomNull(){
		Module module1 = new Module("module1","module1",Etat.ACTIF);
		Module module2 = new Module();
		
		Assert.assertEquals(false, module2.equals(module1));
	}
	
	/**
	 * Test de la fonction equals de Module.class en cas d'inégalité (deux noms nuls)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsDeuxNomsNull(){
		Module module1 = new Module();
		Module module2 = new Module();
		
		Assert.assertEquals(true, module2.equals(module1));
	}
	
	/**
	 * Test de la fonction hashcode de Module.class en cas d'égalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testHashCodeEgaux(){
		Module module1 = new Module("module1","module1",Etat.ACTIF);
		Module module2 = new Module("module1");
		
		Assert.assertEquals(module2.hashCode(), module1.hashCode());
	}
	
	/**
	 * Test de la fonction hashcode de Module.class en cas d'inégalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testHashCodeInegaux(){
		Module module1 = new Module("module1","module1",Etat.ACTIF);
		Module module2 = new Module("module2");
		
		Assert.assertNotEquals(module2.hashCode(), module1.hashCode());
	}
	
	/**
	 * Test de la fonction hashcode de Module.class en cas d'égalité (noms nuls)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testHashCodeEgauxNomsNull(){
		Module module1 = new Module();
		Module module2 = new Module();
		
		Assert.assertEquals(module2.hashCode(), module1.hashCode());
	}
	
	/**
	 * Test de la fonction hashcode de Module.class en cas d'inégalité (un des noms nul)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testHashCodeInegauxNomNull(){
		Module module1 = new Module("module1","module1",Etat.ACTIF);
		Module module2 = new Module();
		
		Assert.assertNotEquals(module2.hashCode(), module1.hashCode());
	}
}
