package recettes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import recettes.model.RecetteIngredient;

public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Long> {

}
