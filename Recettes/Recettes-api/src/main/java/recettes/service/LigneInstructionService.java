/**
 * 
 */
package recettes.service;

import java.util.List;

import recettes.model.LigneInstruction;

/**
 * Service de gestion des LigneInstruction.
 * @author frankybo57
 *
 */
public interface LigneInstructionService {
	
	/**
	 * Renvoie la List des LigneInstruction de la Recette dont l'identifiant est pass� en param�tre.
	 * @param id l'indentifiant de la Recette
	 * @return List des LigneInstruction de la Recette
	 */
	List<LigneInstruction> findListLigneInstructionByRecette(Long id);
	
	/**
	 * Renvoie les LigneInstruction de la Recette dont l'identifiant est pass� en param�tre concat�n�es en une seule String avec renvoi � la ligne.
	 * @param id l'indentifiant de la Recette
	 * @return les LigneInstruction de la Recette
	 */
	String findTextLigneInstructionByRecette(Long id);
	
}
