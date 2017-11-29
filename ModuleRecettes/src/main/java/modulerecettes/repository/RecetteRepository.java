package modulerecettes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modulerecettes.model.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {

}
