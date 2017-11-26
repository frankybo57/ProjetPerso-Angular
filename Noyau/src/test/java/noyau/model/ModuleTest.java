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
@ContextConfiguration("/applicationContext.xml")
public class ModuleTest {
	
	
	/**
	 * Test des accesseurs de Module.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseurs(){
		Module module = new Module();
		
		//Assert.assertEquals((Integer)1, module.getId());
		
		module.setNom("nom");
		module.setEtat(Etat.Inactif);
		
		Assert.assertEquals("nom", module.getNom());
		Assert.assertEquals(Etat.Inactif, module.getEtat());
	}
}
