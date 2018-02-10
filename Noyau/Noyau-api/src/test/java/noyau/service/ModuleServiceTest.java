package noyau.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class ModuleServiceTest {

	@Autowired
	private ModuleRepository modRepo;

	@Autowired
	private ModuleService modSer;

	@Before
	public void setup() {
		modRepo.save(new Module("loginSetup","passwordSetup",Etat.ACTIF));
		modRepo.deleteAll();
	}

	@Test
	public void test() {
		Assert.assertNotNull(modRepo);
		Assert.assertNotNull(modSer);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testFindAll() {
		Module module = new Module("module1", "module1", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module2", "module2", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module3", "module3", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module4", "module4", Etat.ACTIF);
		modRepo.save(module);

		List liste = modSer.findAll();

		Assert.assertNotNull(liste);
		Assert.assertEquals(4, liste.size());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testFindAllByEtat() {
		Module module = new Module("module1", "module1", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module2", "module2", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module3", "module3", Etat.INACTIF);
		modRepo.save(module);
		module = new Module("module4", "module4", Etat.ACTIF);
		modRepo.save(module);

		List liste = modSer.findAllByEtat(Etat.INACTIF);

		Assert.assertNotNull(liste);
		Assert.assertEquals(1, liste.size());
		final Module result = (Module) liste.get(0);
		Assert.assertEquals("module3", result.getNom());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testFindAllOrderByIdAsc() {
		Module module = new Module("module1", "module1", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module2", "module2", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module3", "module3", Etat.INACTIF);
		modRepo.save(module);
		module = new Module("module4", "module4", Etat.ACTIF);
		modRepo.save(module);

		List liste = modSer.findAllOrderByIdAsc();

		Assert.assertNotNull(liste);
		Assert.assertEquals(4, liste.size());

		final Iterator<Module> it = liste.iterator();
		Module moduleTemp;
		Long id = null;

		while(it.hasNext()) {
			moduleTemp = it.next();
			if(id != null) {
				Assert.assertTrue(id < moduleTemp.getId());
			}
			id = moduleTemp.getId();
		}
	}

	@Test
	public void testFindOne() {
		Module module = new Module("module1", "module1", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module2", "module2", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module3", "module3", Etat.INACTIF);
		Long id = (modRepo.save(module)).getId();
		module = new Module("module4", "module4", Etat.ACTIF);
		modRepo.save(module);

		final Module resultat = modSer.findOne(id);

		Assert.assertNotNull(resultat);
		Assert.assertEquals("module3", resultat.getNom());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testDelete() {
		Module module = new Module("module1", "module1", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module2", "module2", Etat.ACTIF);
		modRepo.save(module);
		module = new Module("module3", "module3", Etat.INACTIF);
		Long id = (modRepo.save(module)).getId();
		module = new Module("module4", "module4", Etat.ACTIF);
		modRepo.save(module);

		modSer.delete(id);

		List liste = modSer.findAllOrderByIdAsc();

		Assert.assertNotNull(liste);
		Assert.assertEquals(3, liste.size());
	}
}
