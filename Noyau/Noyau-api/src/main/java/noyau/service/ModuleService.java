package noyau.service;

import java.util.List;

import exception.ModuleException;
import noyau.model.Etat;
import noyau.model.Module;

/**
 * Service de gestion des modules.
 * @author frankybo57
 *
 */
public interface ModuleService {
	
	/**
	 * Méthode de recherche de tous les Module en base.
	 * @author frankybo57
	 * @return la List de tous les Module en base.
	 */
	public List<Module> findAll();

	/**
	 * Méthode de recherche de tous les Module en base triés par identifiant croissant.
	 * @author frankybo57
	 * @return la List des Module triés par ordre d'identifiant croissant.
	 */
	public List<Module> findAllOrderByIdAsc();

	/**
	 * Méthode de recherche de tous les Module en base par leur Etat.
	 * @author frankybo57
	 * @param etat l'Etat des Module à chercher en base.
	 * @return la List des Module trouvés.
	 */
	public List<Module> findAllByEtat(final Etat etat);

	/**
	 * Méthode de recherche d'un Module en base par son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du Module à chercher en base.
	 * @return le Module renvoyé.
	 */
	public Module findOne(final Long id);

	/**
	 * Méthode de sauvegarde d'un Module en base.
	 * @author frankybo57
	 * @param module le Module à sauvegarder en base.
	 * @return le Module sauvegardé.
	 * @throws ModuleException
	 */
	public Module save(final Module module) throws ModuleException;

	/**
	 * Méthode de mise à jour d'un Module en base.
	 * @author frankybo57
	 * @param module la version à jour du Module.
	 * @return le Module à jour.
	 * @throws ModuleException
	 */
	public Module update(final Module module) throws ModuleException;

	/**
	 * Méthode de suppression d'un Module en base à partir de son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du Module à supprimer.
	 */
	public void delete(final Long id);
}
