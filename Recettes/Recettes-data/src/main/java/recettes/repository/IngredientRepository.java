package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypeIngredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	@Transactional(readOnly = true)
	@Query("select distinct i from Ingredient i left join fetch i.listeRecetteIngredient r where r.recette = :recette")
	public List<Ingredient> findAllIngredientByRecette(@Param("recette") Recette recette);
	
	@Transactional(readOnly = true)
	public List<Ingredient> findAllIngredientByTypeIngredient(TypeIngredient ti);

	@Transactional(readOnly = true)
	public List<Ingredient> findAllByTypeIngredient(TypeIngredient typeIngredient);

	@Transactional(readOnly = true)
	public List<Ingredient> findAllByCout(Short cout);
	
	@Transactional(readOnly = true)
	public List<Ingredient> findAllByCoutLessThan(Short cout);
	
	@Transactional(readOnly = true)
	public List<Ingredient> findAllByCoutGreaterThan(Short cout);
}
