package noyau.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class ModuleRepositoryTest {
	@Autowired
	public ModuleRepository modRepo;
	
	@Test
	public void testfindSaveEtFind(){
		Module module = new Module("test");	
		long id = modRepo.save(module).getId();
		
		Module test = modRepo.findOne(id);
		
		Assert.assertEquals("test", test.getNom());
		
		modRepo.deleteAll();
	}
	
	@Test
	public void testfindAllByEtat(){
		modRepo.save(new Module("mod1",null, Etat.ACTIF));
		modRepo.save(new Module("mod2", null, Etat.ACTIF));
		modRepo.save(new Module("mod3",null, Etat.INACTIF));
		int size = modRepo.findAllByEtat(Etat.ACTIF).size();
		
		modRepo.save(new Module("mod4", null, Etat.ACTIF));
		
		size = modRepo.findAllByEtat(Etat.ACTIF).size() - size;
		
		Assert.assertEquals(1, size);
		
		modRepo.deleteAll();
	}
	
	@Test
	public void testFindByNom(){
		modRepo.save(new Module("module"));
		modRepo.save(new Module("Noyau"));
		modRepo.save(new Module("test"));
		
		Module module = modRepo.findByNom("Noyau");	
		
		Assert.assertNotNull(module);
		
		modRepo.deleteAll();
	}
	
	@Test
	public void testFindByNomInexistant(){
		modRepo.save(new Module("module"));
		modRepo.save(new Module("Noyau"));
		modRepo.save(new Module("test"));
		Module module = modRepo.findByNom("Noya");	
		Assert.assertNull(module);
		
		modRepo.deleteAll();
	}
}
