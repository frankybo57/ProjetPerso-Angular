package modulerecettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import modulerecettes.model.Ingredient;
import modulerecettes.model.Recette;
import modulerecettes.model.TypeIngredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	@Query("select distinct i from Ingredient i left join fetch i.listeRecetteIngredient r where r.recette = :recette")
	public List<Ingredient> findAllIngredientByRecette(@Param("recette") Recette recette);
	
	public List<Ingredient> findAllIngredientByTypeIngredient(TypeIngredient ti);
}
