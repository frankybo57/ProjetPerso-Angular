/**
 * 
 */
package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import recettes.model.Ingredient;
import recettes.model.LigneConseil;
import recettes.model.Recette;

/**
 * @author frankybo57
 *
 */
public interface LigneConseilRepository extends JpaRepository<LigneConseil, Long> {

	/**
	 * Renvoie la List des LigneConseil de la Recette dont l'identifiant est passé en paramètre.
	 * 
	 * @param id l'identifiant de la Recette.
	 * @return List de LigneConseil.
	 */
	@Transactional(readOnly = true)
	@Query("from LigneConseil li where li.recette.id =:id")
	public List<LigneConseil> findAllByRecette(@Param("id") Long id);
	
	/**
	 * Renvoie la List des LigneConseil de la Recette passée en paramètre.
	 * 
	 * @param recette.
	 * @return List de LigneConseil.
	 */
	@Transactional(readOnly = true)
	@Query("from LigneConseil li where li.recette =:recette")
	public List<LigneConseil> findAllByRecette(@Param("recette") Recette recette);
	
	/**
	 * Renvoie la List des LigneConseil de l'Ingredient dont l'identifiant est passé en paramètre.
	 * 
	 * @param id l'identifiant de l'Ingredient.
	 * @return List de LigneConseil.
	 */
	@Transactional(readOnly = true)
	@Query("from LigneConseil li where li.ingredient.id =:id")
	public List<LigneConseil> findAllByIngredient(@Param("id") Long id);
	
	/**
	 * Renvoie la List des LigneConseil de l'Ingredient passée en paramètre.
	 * 
	 * @param ingredient.
	 * @return List de LigneConseil.
	 */
	@Transactional(readOnly = true)
	@Query("from LigneConseil li where li.ingredient =:ingredient")
	public List<LigneConseil> findAllByIngredient(@Param("ingredient") Ingredient ingredient);
}
