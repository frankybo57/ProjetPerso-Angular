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
	 * Méthode de recherche de tous les modules en base.
	 * @author frankybo57
	 * @return la liste de tous les modules en base.
	 */
	@SuppressWarnings("rawtypes")
	public List findAll();

	/**
	 * Méthode de recherche de tous les modules en base triés par identifiant croissant.
	 * @author frankybo57
	 * @return la liste des modules triés par ordre d'identifiant croissant.
	 */
	@SuppressWarnings("rawtypes")
	public List findAllOrderByIdAsc();

	/**
	 * Méthode de recherche de tous les modules en base par leur etat.
	 * @author frankybo57
	 * @param etat l'état des modules à chercher en base.
	 * @return la liste des modules trouvés.
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByEtat(final Etat etat);

	/**
	 * Méthode de recherche d'un module en base par son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du module à chercher en base.
	 * @return le module sauvegardé.
	 */
	public Module findOne(final Long id);

	/**
	 * Méthode de sauvegarde d'un module en base.
	 * @author frankybo57
	 * @param module le module à sauvegarder en base.
	 * @return le module sauvegardé.
	 */
	public Module save(final Module module);

	/**
	 * Méthode de mise à jour d'un module en base.
	 * @author frankybo57
	 * @param module la version à jour du module.
	 * @return le module à jour.
	 */
	public Module update(final Module module);

	/**
	 * Méthode de suppression d'un module en base à partir de son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du module à supprimer.
	 */
	public void delete(final Long id);
}
