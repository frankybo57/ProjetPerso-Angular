/**
 * 
 */
package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import recettes.model.LigneInstruction;
import recettes.model.Recette;

/**
 * @author frankybo57
 *
 */
public interface LigneInstructionRepository extends JpaRepository<LigneInstruction, Long> {

	/**
	 * Renvoie la List des LigneInstruction de la Recette dont l'identifiant est passé en paramètre.
	 * 
	 * @param id l'identifiant de la Recette.
	 * @return List de LigneInstruction.
	 */
	@Transactional(readOnly = true)
	@Query("from LigneInstruction li where li.recette.id =:id")
	public List<LigneInstruction> findAllByRecette(@Param("id") Long id);
	
	/**
	 * Renvoie la List des LigneInstruction de la Recette passée en paramètre.
	 * 
	 * @param recette.
	 * @return List de LigneInstruction.
	 */
	@Transactional(readOnly = true)
	@Query("from LigneInstruction li where li.recette =:recette")
	public List<LigneInstruction> findAllByRecette(@Param("recette") Recette recette);
}
