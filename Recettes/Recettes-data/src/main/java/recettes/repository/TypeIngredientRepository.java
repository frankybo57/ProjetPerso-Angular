package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import recettes.model.TypeIngredient;


public interface TypeIngredientRepository extends JpaRepository<TypeIngredient, Long>{
	@Query("from TypeIngredient ti where ti.typePere = :typePere")
	public List<TypeIngredient> findAllTypeIngredientFils(@Param("typePere") TypeIngredient typePere);
}
