package noyau.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UtilisateurRepositoryTest {
	@Autowired
	private static UtilisateurRepository utiRepo;
	
	@Test
	public void testfindAllByDroit(){
		
	}
	
	@Test
	public void testFindByLogin(){
		
	}
}
