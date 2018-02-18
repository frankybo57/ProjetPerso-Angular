package noyau.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.UtilisateurException;
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.repository.UtilisateurRepository;
import noyau.service.implementation.UtilisateurServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class UtilisateurServiceTest {

	@Autowired
	private UtilisateurRepository utiRepo;
	@Autowired
	private UtilisateurService utiSer;
	@Autowired
	private HashService hService;
	

	@Before
	public void setup() {
		if(utiRepo.count()>0) {
			utiRepo.deleteAll();
		}
	}

	@Test
	public void test() {
		Assert.assertNotNull(utiRepo);
		Assert.assertNotNull(utiSer);
		Assert.assertNotNull(hService);
	}

	@Test
	public void creerUtilisateurTest() throws UtilisateurException {
		final Utilisateur utilisateur = new Utilisateur("login","password",Droit.ADMINISTRATEUR);


		final Long id = (utiSer.createOne(utilisateur,false)).getId();
		final Utilisateur result = utiRepo.findOne(id);
		Assert.assertNotNull(result);
		Assert.assertEquals("login", result.getLogin());
		utiRepo.delete(id);

	}



	@Test
	public void creerUtilisateurHashTest() throws UtilisateurException {
		final Utilisateur utilisateur = new Utilisateur("login","password",Droit.ADMINISTRATEUR);


		final Long id = (utiSer.createOne(utilisateur,true)).getId();
		final Utilisateur result = utiRepo.findOne(id);
		Assert.assertNotNull(result);
		Assert.assertEquals("login", result.getLogin());
		Assert.assertEquals(hService.cryptage("password"), result.getPassword());
		utiRepo.delete(id);


	}

	@Test(expected=UtilisateurException.class)
	public void creerUtilisateurExistantTest() throws UtilisateurException {
		// PREPARE
		final Utilisateur utilisateur = new Utilisateur("login","password",Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);
		final Utilisateur utilisateur2 = new Utilisateur("login","password2",Droit.UTILISATEUR);
		// WHEN
		utiSer.createOne(utilisateur2,false);

	}

	@Test(expected=UtilisateurException.class)
	public void creerUtilisateurAvecIdTest() throws UtilisateurException {
		// PREPARE
		final Utilisateur utilisateur = new Utilisateur("login","password",Droit.ADMINISTRATEUR);
		utilisateur.setId(3L);
		// WHEN
		utiSer.createOne(utilisateur,false);
	}
	
	@Test
	public void messageNonMaJTest() {
		UtilisateurServiceImpl utiSerImpl = new UtilisateurServiceImpl();
		Assert.assertEquals("L'utilisateur lulu938 n'a pas pu être mis à jour.", utiSerImpl.messageNonMaJ("lulu938"));
	}
	
	public Utilisateur preparationPourTestUpdate(boolean hash) {
		Utilisateur utilisateur = new Utilisateur("ancienlogin","ancienpassword",Droit.ADMINISTRATEUR);
		if(hash) {
			utilisateur.setPassword(hService.cryptage("ancienpassword"));
			utilisateur = utiRepo.save(utilisateur);
			utilisateur.setPassword("ancienpassword");
		} else {
			utilisateur = utiRepo.save(utilisateur);
		}
		return utilisateur;
	}
	
	@Test
	public void testUpdateLoginAvecHash() throws UtilisateurException {
		// PREPARE
		final Utilisateur utilisateur = preparationPourTestUpdate(true);
		final String propriete = "nouveaulogin";
		final String typePropriete = "login";
		final boolean hash = true;
		// WHEN
		final Utilisateur result = utiSer.update(utilisateur, propriete, typePropriete, hash);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
		Assert.assertNotNull(result.getVersion());
		Assert.assertEquals(1, result.getVersion());
		Assert.assertNotNull(result.getLogin());
		Assert.assertEquals("nouveaulogin", result.getLogin());
		Assert.assertNotNull(result.getPassword());
		Assert.assertEquals("", result.getPassword());
		Assert.assertNotNull(result.getDroits());
		Assert.assertEquals(Droit.ADMINISTRATEUR, result.getDroits());
	}
	
	@Test
	public void testUpdateLoginSansHash() throws UtilisateurException {
		// PREPARE
		final Utilisateur utilisateur = preparationPourTestUpdate(false);
		final String propriete = "nouveaulogin";
		final String typePropriete = "login";
		final boolean hash = false;
		// WHEN
		final Utilisateur result = utiSer.update(utilisateur, propriete, typePropriete, hash);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
		Assert.assertNotNull(result.getVersion());
		Assert.assertEquals(1, result.getVersion());
		Assert.assertNotNull(result.getLogin());
		Assert.assertEquals("nouveaulogin", result.getLogin());
		Assert.assertNotNull(result.getPassword());
		Assert.assertEquals("", result.getPassword());
		Assert.assertNotNull(result.getDroits());
		Assert.assertEquals(Droit.ADMINISTRATEUR, result.getDroits());
	}
	
	@Test
	public void testUpdatePasswordAvecHash() throws UtilisateurException {
		// PREPARE
		final Utilisateur utilisateur = preparationPourTestUpdate(true);
		final String propriete = "nouveaupassword";
		final String typePropriete = "password";
		final boolean hash = true;
		// WHEN
		final Utilisateur result = utiSer.update(utilisateur, propriete, typePropriete, hash);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
		Assert.assertNotNull(result.getVersion());
		Assert.assertEquals(1, result.getVersion());
		Assert.assertNotNull(result.getLogin());
		Assert.assertEquals("ancienlogin", result.getLogin());
		Assert.assertNotNull(result.getPassword());
		Assert.assertEquals("", result.getPassword());
		Assert.assertNotNull(result.getDroits());
		Assert.assertEquals(Droit.ADMINISTRATEUR, result.getDroits());
	}
	
	@Test
	public void testUpdatePasswordSansHash() throws UtilisateurException {
		// PREPARE
		final Utilisateur utilisateur = preparationPourTestUpdate(false);
		final String propriete = "nouveaupassword";
		final String typePropriete = "password";
		final boolean hash = false;
		// WHEN
		final Utilisateur result = utiSer.update(utilisateur, propriete, typePropriete, hash);
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
		Assert.assertNotNull(result.getVersion());
		Assert.assertEquals(1, result.getVersion());
		Assert.assertNotNull(result.getLogin());
		Assert.assertEquals("ancienlogin", result.getLogin());
		Assert.assertNotNull(result.getPassword());
		Assert.assertEquals("", result.getPassword());
		Assert.assertNotNull(result.getDroits());
		Assert.assertEquals(Droit.ADMINISTRATEUR, result.getDroits());
	}
}
