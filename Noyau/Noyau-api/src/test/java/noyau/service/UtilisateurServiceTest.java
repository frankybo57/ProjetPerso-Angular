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
		utiRepo.save(new Utilisateur("loginSetup","passwordSetup",Droit.ADMINISTRATEUR));
		utiRepo.deleteAll();
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
		final Utilisateur utilisateur = new Utilisateur("login","password",Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);

		final Utilisateur utilisateur2 = new Utilisateur("login","password2",Droit.UTILISATEUR);

		utiSer.createOne(utilisateur2,false);

	}

	@Test(expected=UtilisateurException.class)
	public void creerUtilisateurAvecIdTest() throws UtilisateurException {
		final Utilisateur utilisateur = new Utilisateur("login","password",Droit.ADMINISTRATEUR);
		utilisateur.setId(3L);

		utiSer.createOne(utilisateur,false);

	}
	
	@Test
	public void messageNonMaJTest() {
		UtilisateurServiceImpl utiSerImpl = new UtilisateurServiceImpl();
		Assert.assertEquals("L'utilisateur lulu938 n'a pas pu être mis à jour.", utiSerImpl.messageNonMaJ("lulu938"));
	}

}
