package noyau.service;

import java.util.List;

import noyau.model.Etat;
import noyau.model.Module;

/**
 * Service de gestion des modules.
 * @author frankybo57
 *
 */
public interface ModuleService {
	
	/**
	 * M�thode de recherche de tous les modules en base.
	 * @author frankybo57
	 * @return la liste de tous les modules en base.
	 */
	@SuppressWarnings("rawtypes")
	public List findAll();

	/**
	 * M�thode de recherche de tous les modules en base tri�s par identifiant croissant.
	 * @author frankybo57
	 * @return la liste des modules tri�s par ordre d'identifiant croissant.
	 */
	@SuppressWarnings("rawtypes")
	public List findAllOrderByIdAsc();

	/**
	 * M�thode de recherche de tous les modules en base par leur etat.
	 * @author frankybo57
	 * @param etat l'�tat des modules � chercher en base.
	 * @return la liste des modules trouv�s.
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByEtat(final Etat etat);

	/**
	 * M�thode de recherche d'un module en base par son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du module � chercher en base.
	 * @return le module sauvegard�.
	 */
	public Module findOne(final Long id);

	/**
	 * M�thode de sauvegarde d'un module en base.
	 * @author frankybo57
	 * @param module le module � sauvegarder en base.
	 * @return le module sauvegard�.
	 */
	public Module save(final Module module);

	/**
	 * M�thode de mise � jour d'un module en base.
	 * @author frankybo57
	 * @param module la version � jour du module.
	 * @return le module � jour.
	 */
	public Module update(final Module module);

	/**
	 * M�thode de suppression d'un module en base � partir de son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du module � supprimer.
	 */
	public void delete(final Long id);
}
