package recettes.generation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import recettes.model.TypePlat;
import recettes.repository.IngredientRepository;
import recettes.repository.RecetteIngredientRepository;
import recettes.repository.RecetteRepository;
import recettes.repository.TypePlatRepository;

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
		TypePlat typePlat = new TypePlat("Entrée froide","entree_froide");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Entrée chaude","entree_chaude");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Soupe","soupe");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Cake / Terrine","cake_terrine");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Légumes / Gratin","legumes_gratin");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Oeufs / Fromage","oeufs_fromage");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Pâtes / Riz / Pommes de terre","pates_riz_pdt");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Poisson / Fruits de mer","poisson_fdm");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Tarte / Quiche","tarte_quiche");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Boeuf","boeuf");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Porc","porc");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Volaille","volaille");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Gibier","gibier");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Crême / Flanc / Glace","creme_flanc_glace");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Fruits","fruits");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Gâteau","gateau");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Tarte","tarte");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Biscuit","biscuit");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Boisson froide","boisson_froide");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Confiture","confiture");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Pain","pain");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Recette de base / Pâte","recette_base_pate");
		tpRepo.save(typePlat);
		typePlat = new TypePlat("Sauce","sauce");
		tpRepo.save(typePlat);
		
		Assert.assertEquals((Integer) 23, (Integer)tpRepo.findAll().size());
	}
}
