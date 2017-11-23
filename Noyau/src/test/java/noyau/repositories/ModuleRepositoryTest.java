package noyau.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ModuleRepositoryTest {
	@Autowired
	private static ModuleRepository modRepo;
	
	@Test
	public void testfindAllByEtat(){
		
	}
	
	@Test
	public void testFindByNom(){
		
	}
}
