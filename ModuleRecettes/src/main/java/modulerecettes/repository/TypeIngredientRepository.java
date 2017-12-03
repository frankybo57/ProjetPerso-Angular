package modulerecettes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modulerecettes.model.TypeIngredient;


public interface TypeIngredientRepository extends JpaRepository<TypeIngredient, Short>{

}
