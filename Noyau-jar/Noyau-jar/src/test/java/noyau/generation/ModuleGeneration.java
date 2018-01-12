package noyau.generation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ModuleGeneration {
	@Autowired
	public ModuleRepository modRepo;
	
	@Test
	public void generation() {
		modRepo.save(new Module("Noyau","Accueil",Etat.ACTIF));
		modRepo.save(new Module("Administration","Administration",Etat.ACTIF));
		modRepo.save(new Module("Stock","Stock",Etat.INACTIF));
		modRepo.save(new Module("Recettes","Recettes",Etat.INACTIF));
		modRepo.save(new Module("Courses","Courses",Etat.INACTIF));
		modRepo.save(new Module("Menus","Menus",Etat.INACTIF));
		modRepo.save(new Module("Comptes","Comptes",Etat.INACTIF));
		modRepo.save(new Module("Contacts","Contacts",Etat.INACTIF));
		modRepo.save(new Module("Agenda","Agenda",Etat.INACTIF));
		modRepo.save(new Module("Calculatrice","Calculatrice",Etat.INACTIF));
		
		Assert.assertEquals(10, modRepo.findAll().size());
	}
	
	
	
}
