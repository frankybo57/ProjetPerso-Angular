package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
