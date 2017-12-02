package noyau.generation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import modulerecettes.repository.IngredientRepository;
import modulerecettes.repository.RecetteIngredientRepository;
import modulerecettes.repository.RecetteRepository;
import modulerecettes.repository.TypePlatRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class GenerationRecettes {
	@Autowired
	private RecetteRepository recRepo;
	
	@Autowired
	private IngredientRepository ingRepo;
	
	@Autowired
	private TypePlatRepository tpRepo;
	
	@Autowired
	private RecetteIngredientRepository riRepo;
	
	@Test
	public void generationTypePlat() {
		
	}
}
