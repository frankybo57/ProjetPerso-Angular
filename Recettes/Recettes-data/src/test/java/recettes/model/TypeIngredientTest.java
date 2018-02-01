package recettes.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @see
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class TypeIngredientTest {

	@Test
	public void testTypeIngredientConstructeur1() {
		TypeIngredient typeIngredient = new TypeIngredient();
		
		Assert.assertNotNull(typeIngredient);
	}
	
	@Test
	public void testTypeIngredientConstructeur2() {
		String label = "légume";
		TypeIngredient typeIngredient = new TypeIngredient(label);
		
		Assert.assertNotNull(typeIngredient);
		Assert.assertEquals(label, typeIngredient.getLabel());
	}
	
	@Test
	public void testTypeIngredientConstructeur3() {
		String label = "légume";
		TypeIngredient typePere = new TypeIngredient();
		TypeIngredient typeIngredient = new TypeIngredient(label,typePere);
		
		Assert.assertNotNull(typeIngredient);
		Assert.assertEquals(label, typeIngredient.getLabel());
		Assert.assertEquals(typePere, typeIngredient.getTypePere());
	}
	
	@Test
	public void testAccesseursId() {
		
		TypeIngredient typeIngredient = new TypeIngredient();
		Long id = 5L;
		typeIngredient.setId(id);
		
		Assert.assertEquals(id, typeIngredient.getId());
	}
	
	@Test
	public void testAccesseursVersion() {
		TypeIngredient typeIngredient = new TypeIngredient();
		typeIngredient.setVersion(57);
		int version = typeIngredient.getVersion();
		
		Assert.assertEquals(57,version);
	}
	
	@Test
	public void testAccesseursNiveau() {
		
		TypeIngredient typeIngredient = new TypeIngredient();
		Short niveau = Short.valueOf((short) 5);
		typeIngredient.setNiveau(niveau);
		
		Assert.assertEquals(niveau, typeIngredient.getNiveau());
	}
	
	@Test
	public void testAccesseursLabel() {
		TypeIngredient typeIngredient = new TypeIngredient();
		typeIngredient.setLabel("label_choisi_au_hasard");
		String label = typeIngredient.getLabel();
		
		Assert.assertEquals("label_choisi_au_hasard",label);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAccesseursIngredient() {
		TypeIngredient typeIngredient = new TypeIngredient();
		List liste = new ArrayList();
		Ingredient ingredient = new Ingredient();
		ingredient.setLabel("pomme");
		liste.add(ingredient);
		ingredient = new Ingredient();
		ingredient.setLabel("riz");
		liste.add(ingredient);
		
		typeIngredient.setListeIngredients(liste);
		
		List<Ingredient> resultat = typeIngredient.getListeIngredients();
		
		Assert.assertNotNull(resultat);
		Assert.assertEquals(2, liste.size());
		Assert.assertEquals("pomme", resultat.get(0).getLabel());
		Assert.assertEquals("riz", resultat.get(1).getLabel());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAccesseursTypesFils() {
		TypeIngredient typeIngredientPere = new TypeIngredient("fruit et légume");
		List liste = new ArrayList();
		TypeIngredient typeingredient = new TypeIngredient("fruit");
		liste.add(typeingredient);
		typeingredient = new TypeIngredient("légume");
		liste.add(typeingredient);
		
		typeIngredientPere.setTypesFils(liste);
		
		List<TypeIngredient> resultat = typeIngredientPere.getTypesFils();
		
		Assert.assertNotNull(resultat);
		Assert.assertEquals(2, liste.size());
		Assert.assertEquals("fruit", resultat.get(0).getLabel());
		Assert.assertEquals("légume", resultat.get(1).getLabel());
	}
	
	@Test
	public void testAccesseursTypePere() {
		TypeIngredient typeIngredient = new TypeIngredient("fruit");
		TypeIngredient typeIngredientPere = new TypeIngredient("fruit et légume");
		typeIngredient.setTypePere(typeIngredientPere);
		
		TypeIngredient resultat = typeIngredient.getTypePere();
		Assert.assertNotNull(resultat);
		Assert.assertEquals("fruit et légume", resultat.getLabel());
	}
	
	@Test
	public void testHashCode() {
		TypeIngredient typeIngredient = new TypeIngredient();
		
		Assert.assertEquals((Integer)(31*31*31), (Integer)typeIngredient.hashCode());
	}
}
