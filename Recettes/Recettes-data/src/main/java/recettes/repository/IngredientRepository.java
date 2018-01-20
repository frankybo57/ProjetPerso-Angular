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
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	@Query("select distinct i from Ingredient i left join fetch i.listeRecetteIngredient r where r.recette = :recette")
	public List findAllIngredientByRecette(@Param("recette") Recette recette);
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List findAllIngredientByTypeIngredient(TypeIngredient ti);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List findAllByTypeIngredient(TypeIngredient typeIngredient);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List findAllByCout(Short cout);
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List findAllByCoutLessThan(Short cout);
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List findAllByCoutGreaterThan(Short cout);
}
