package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypePlat;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
	@Transactional(readOnly = true)
	public List<Recette> findAllByTypePlat(final TypePlat typePlat);

	@Transactional(readOnly = true)
	public List<Recette> findAllByDifficulte(final Short difficulte);
	
	@Transactional(readOnly = true)
	@Query("select distinct r from Recette r left join fetch r.listeRecetteIngredient i where i.ingredient = :ingredient")
	public List<Recette> findAllRecetteByIngredient(@Param("ingredient") Ingredient ingredient);

	@Transactional(readOnly = true)
	@Query("select r from Recette r where r.typePlat=null")
	public List<Recette> findAllSansTypePlat();

}
