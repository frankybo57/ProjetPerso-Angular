package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import recettes.model.Recette;
import recettes.model.TypePlat;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {
	@Transactional(readOnly = true)
	public List<Recette> findAllByTypePlat(TypePlat typePlat);
	

}
