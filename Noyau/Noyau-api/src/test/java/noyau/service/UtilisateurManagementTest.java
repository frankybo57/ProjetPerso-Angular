package noyau.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class UtilisateurManagementTest {

	@Autowired
	private UtilisateurService utiSer;
	
	@Test
	public void test() {
		Assert.assertNotNull(utiSer);
	}

}
