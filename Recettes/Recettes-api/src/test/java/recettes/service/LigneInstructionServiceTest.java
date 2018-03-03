package recettes.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import recettes.model.LigneInstruction;
import recettes.model.Recette;
import recettes.repository.LigneInstructionRepository;
import recettes.repository.RecetteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class LigneInstructionServiceTest {

	@Autowired
	LigneInstructionRepository liRepo;
	
	@Autowired
	RecetteRepository recRepo;
	
	@Autowired
	LigneInstructionService liService;

	@Before
	public void setup() {
		if(liRepo.count()!=0) {
			liRepo.deleteAll();
		}
		if(recRepo.count()!=0) {
			recRepo.deleteAll();
		}
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(liRepo);
		Assert.assertNotNull(liService);
		Assert.assertNotNull(recRepo);
	}
	
	@Test
	public void testFindListLigneInstructionByRecetteId() {
		// PREPARE
		final Recette recette = new Recette();
		recette.setLabel("recette");
		recRepo.save(recette);
		final List<LigneInstruction> instructions = new ArrayList<LigneInstruction>();
		LigneInstruction ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneInstruction(Integer.toString(i));
			ligne.setRecette(recette);
			instructions.add(ligne);
		}
		liRepo.save(instructions);
		// WHEN
		List<LigneInstruction> result = liService.findListLigneInstructionByRecette(recette.getId());
		// ASSERT
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(20, result.size());
	}
	
	@Test
	public void testFindTextLigneInstructionByRecetteId() {
		// PREPARE
		StringBuffer expected = new StringBuffer();
		final Recette recette = new Recette();
		recette.setLabel("recette");
		recRepo.save(recette);
		final List<LigneInstruction> instructions = new ArrayList<LigneInstruction>();
		LigneInstruction ligne;
		for(int i = 0 ; i < 20; i++) {
			ligne = new LigneInstruction(Integer.toString(i));
			ligne.setRecette(recette);
			instructions.add(ligne);
			expected.append(i);
			expected.append(String.format("%n", ""));
		}
		liRepo.save(instructions);
		// WHEN
		String result = liService.findTextLigneInstructionByRecette(recette.getId());
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals(expected.toString(), result);
	}
	
	@Test
	public void testFindTextLigneInstructionByRecetteIdSansInstructions() {
		// PREPARE
		final Recette recette = new Recette();
		recette.setLabel("recette");
		recRepo.save(recette);
		// WHEN
		String result = liService.findTextLigneInstructionByRecette(recette.getId());
		// ASSERT
		Assert.assertNotNull(result);
		Assert.assertEquals("Cette recette n'a pas encore d'instructions.", result);
	}
}
