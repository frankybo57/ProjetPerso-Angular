package noyau.generation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import noyau.model.Etat;
import noyau.model.Module;
import noyau.repositories.ModuleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ModuleGeneration {
	@Autowired
	public ModuleRepository modRepo;
	
	@Test
	public void generation() {
		// TODO Auto-generated method stub
		modRepo.save(new Module("Noyau","Accueil",Etat.Actif));
		modRepo.save(new Module("Administration","Administration",Etat.Inactif));
		modRepo.save(new Module("Stock","Stock",Etat.Inactif));
		modRepo.save(new Module("Recettes","Recettes",Etat.Inactif));
		modRepo.save(new Module("Courses","Courses",Etat.Inactif));
		modRepo.save(new Module("Menus","Menus",Etat.Inactif));
		modRepo.save(new Module("Comptes","Comptes",Etat.Inactif));
		modRepo.save(new Module("Contacts","Contacts",Etat.Inactif));
		modRepo.save(new Module("Agenda","Agenda",Etat.Inactif));
		modRepo.save(new Module("Calculatrice","Calculatrice",Etat.Inactif));
		
		Assert.assertEquals(10, modRepo.findAll().size());
	}
	
	
	
}
