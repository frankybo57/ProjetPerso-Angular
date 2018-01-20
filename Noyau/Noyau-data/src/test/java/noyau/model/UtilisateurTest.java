package noyau.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UtilisateurTest {
	
	/**
	 * Test des accesseurs Id de Utilisateur.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursId() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(0);
		
		Assert.assertEquals((Integer)0, utilisateur.getId());
	}
	
	/**
	 * Test des accesseurs de l'attribut "version" de Utilisateur.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursVersion(){
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setVersion(0);
		Assert.assertEquals(0, utilisateur.getVersion());
	}
	
	/**
	 * Test des accesseurs de l'attribut "login" de Utilisateur.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursLogin(){
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setLogin("nom");	
		Assert.assertEquals("nom", utilisateur.getLogin());
	}
	
	/**
	 * Test des accesseurs de l'attribut "password" de Utilisateur.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursPassword(){
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setPassword("nom");	
		Assert.assertEquals("nom", utilisateur.getPassword());
	}
	
	/**
	 * Test des accesseurs de l'attribut "droit" de Utilisateur.class
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testAccesseursDroit(){
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setDroits(Droit.UTILISATEUR);
		Assert.assertEquals(Droit.UTILISATEUR, utilisateur.getDroits());
	}
	
	/**
	 * Test de la fonction "equals" de Utilisateur.class en cas d'égalité des adresses
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsEgauxMemeAdresse(){
		Utilisateur utilisateur = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		Utilisateur utilisateur2 = utilisateur;
		
		Assert.assertEquals(true, utilisateur.equals(utilisateur2));
	}
	
	/**
	 * Test de la fonction "equals" de Utilisateur.class en cas d'égalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsEgaux(){
		Utilisateur utilisateur = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		Utilisateur utilisateur2 = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		
		Assert.assertEquals(true, utilisateur.equals(utilisateur2));
	}
	
	/**
	 * Test de la fonction equals de Utilisateur.class en cas d'inégalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsInegaux(){
		Utilisateur utilisateur1 = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		Utilisateur utilisateur2 = new Utilisateur("module2", "mdp", Droit.ADMINISTRATEUR);
		
		Assert.assertEquals(false, utilisateur1.equals(utilisateur2));
	}
	
	/**
	 * Test de la fonction equals de Utilisateur.class en cas d'inégalité (deuxième objet null)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsObjetNull(){
		Utilisateur utilisateur1 = new Utilisateur();
		Utilisateur utilisateur2 = null;
		
		Assert.assertEquals(false, utilisateur1.equals(utilisateur2));
	}
	
	/**
	 * Test de la fonction equals de Module.class en cas d'inégalité (classe différente)
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualsClasseDifferente(){
		Utilisateur utilisateur1 = new Utilisateur();
		Module module2 = new Module("module2");
		
		Assert.assertNotEquals(true, utilisateur1.equals(module2));
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
	
	@Test
	public void testDroits() {
		Assert.assertEquals("Droit.Administrateur", Droit.ADMINISTRATEUR.getLabel());
	}
	
	/**
	 * Test de la fonction "equals" de Utilisateur.class en cas d'égalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsDroitsDifferents(){
		Utilisateur utilisateur = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		Utilisateur utilisateur2 = new Utilisateur("module1", "mdp");
		
		Assert.assertEquals(false, utilisateur.equals(utilisateur2));
	}
	
	/**
	 * Test de la fonction "equals" de Utilisateur.class en cas d'égalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsIdNull(){
		Utilisateur utilisateur = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		Utilisateur utilisateur2 = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		utilisateur2.setId(1);
		
		Assert.assertEquals(false, utilisateur.equals(utilisateur2));
	}
	
	/**
	 * Test de la fonction "equals" de Utilisateur.class en cas d'égalité
	 * @author Francois 2
	 * @version 0.0.1-Snapshot
	 */
	@Test
	public void testEqualsIdInegaux(){
		Utilisateur utilisateur = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		utilisateur.setId(0);
		Utilisateur utilisateur2 = new Utilisateur("module1", "mdp", Droit.ADMINISTRATEUR);
		utilisateur2.setId(1);
		
		Assert.assertEquals(false, utilisateur.equals(utilisateur2));
	}
	
}
