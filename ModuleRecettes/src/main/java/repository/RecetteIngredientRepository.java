package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.RecetteIngredient;

public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Long> {

}
