package recettes.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import recettes.model.TypePlat;
import recettes.repository.TypePlatRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class TypePlatServiceTest {

	@Autowired
	private TypePlatRepository tpRepo;
	@Autowired
	private TypePlatService tpService;
	
	private int expectedNbTypePlat = 10;

	
	@After
	public void deleteAll() {
		if(!tpRepo.findAll().isEmpty()) {
			tpRepo.deleteAll();
		}
	}
	
	public void preparation() {
		
		for(int i=0; i<expectedNbTypePlat;i++) {
			TypePlat typePlat = new TypePlat("typeplat"+i,"typeplat"+i);
			tpRepo.save(typePlat);
		}
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(tpRepo);
		Assert.assertNotNull(tpService);
	}
	
	@Test
	public void testFindAll() {
		// PREPARE
		preparation();
		// WHEN
		List<TypePlat> resultListe = tpService.findAll();
		// ASSERT
		Assert.assertEquals(expectedNbTypePlat, resultListe.size());
	}
	
	@Test
	public void testFindAllBaseVide() {
		// PREPARE
		// WHEN
		List<TypePlat> resultListe = tpService.findAll();
		// ASSERT
		Assert.assertNotNull(resultListe);
		Assert.assertTrue(resultListe.isEmpty());
	}

}
