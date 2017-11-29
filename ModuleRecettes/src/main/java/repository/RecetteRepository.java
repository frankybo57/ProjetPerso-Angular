package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {

}
