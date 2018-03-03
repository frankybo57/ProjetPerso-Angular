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
	 * Renvoie la List des LigneConseil de l'entité dont l'identifiant est passé en paramètre.
	 * @param id l'indentifiant de l'entité
	 * @return List des LigneConseil de l'entité
	 */
	List<LigneConseil> findListLigneConseilByEntite(final Long id, final Class classe);
	
	/**
	 * Renvoie les LigneConseil de l'entité dont l'identifiant est passé en paramètre concaténées en une seule String avec renvoi à la ligne.
	 * @param id l'indentifiant de l'entité
	 * @return les LigneConseil de l'entité
	 */
	String findTextLigneConseilByEntite(final Long id, final Class classe);
	
}
