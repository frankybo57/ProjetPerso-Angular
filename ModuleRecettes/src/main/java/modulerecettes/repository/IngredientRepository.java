package modulerecettes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modulerecettes.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
