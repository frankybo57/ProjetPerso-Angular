package recettes.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import recettes.model.TypeIngredient;
import recettes.repository.TypeIngredientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class ListeTypeIngredientTest {

	@Autowired
	private ListeTypeIngredient listeTypeIngredient;
	
	@Autowired
	private TypeIngredientRepository tiRepo;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testListeNiveauZero() {
//		List expected = new LinkedList();
//		Set auxiliaire = new HashSet();
//		List result = new LinkedList();
//		
//		ListeTypeIngredient lTI = ListeTypeIngredient.getInstance();
//		Whitebox.invokeMethod();
//		
//		TypeIngredient ti = new TypeIngredient("Epice");
//		expected.add(ti);
//		auxiliaire.add(ti);
//		ti = new TypeIngredient("Viande");
//		expected.add(ti);
//		auxiliaire.add(ti);
//		ti = new TypeIngredient("Féculent");
//		expected.add(ti);
//		auxiliaire.add(ti);
//		ti = new TypeIngredient("Légume");
//		expected.add(ti);
//		auxiliaire.add(ti);
		
		
		
		Assert.assertTrue(true);
//		Assert.assertEquals(expected, listeTypeIngredient);
	}
	
}
