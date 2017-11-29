package modulerecettes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modulerecettes.model.RecetteIngredient;

public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Long> {

}
