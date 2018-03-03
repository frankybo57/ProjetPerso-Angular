/**
 * 
 */
package recettes.service;

import java.util.List;

import recettes.model.LigneConseil;
import recettes.model.PossedeLignes;

/**
 * Service de gestion des LigneConseil.
 * @author frankybo57
 *
 */
@SuppressWarnings("rawtypes")
public interface LigneConseilService {
	
	/**
	 * Renvoie la List des LigneConseil de l'entit� dont l'identifiant est pass� en param�tre.
	 * @param id l'indentifiant de l'entit�
	 * @return List des LigneConseil de l'entit�
	 */
	List<LigneConseil> findListLigneConseilByEntite(final Long id, final Class classe);
	
	/**
	 * Renvoie les LigneConseil de l'entit� dont l'identifiant est pass� en param�tre concat�n�es en une seule String avec renvoi � la ligne.
	 * @param id l'indentifiant de l'entit�
	 * @return les LigneConseil de l'entit�
	 */
	String findTextLigneConseilByEntite(final Long id, final Class classe);
	
}
