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
@ContextConfiguration("/applicationContext.xml")
public class ModuleRepositoryTest {
	@Autowired
	public ModuleRepository modRepo;
	
	@Test
	public void testfindSaveEtFind(){
		Module module = new Module("test");
		
		int id = modRepo.save(module).getId();
		
		Module test = modRepo.findOne(id);
		
		Assert.assertEquals("test", test.getNom());
		
		modRepo.delete(id);
	}
	
	@Test
	public void testfindAllByEtat(){
		int size = modRepo.findAllByEtat(Etat.ACTIF).size();
		
		int id = modRepo.save(new Module("test","test",Etat.ACTIF)).getId();
		
		size = modRepo.findAllByEtat(Etat.ACTIF).size() - size;
		
		Assert.assertEquals(1, size);
		
		modRepo.delete(id);
	}
	
	@Test
	public void testFindByNom(){
		Module module = modRepo.findByNom("Noyau");	
		Assert.assertNotNull(module);
	}
	
	@Test
	public void testFindByNomInexistant(){
		Module module = modRepo.findByNom("Noya");	
		Assert.assertNull(module);
	}
}
