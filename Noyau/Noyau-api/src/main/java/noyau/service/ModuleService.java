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
	 * M�thode de recherche de tous les Module en base.
	 * @author frankybo57
	 * @return la List de tous les Module en base.
	 */
	public List<Module> findAll();

	/**
	 * M�thode de recherche de tous les Module en base tri�s par identifiant croissant.
	 * @author frankybo57
	 * @return la List des Module tri�s par ordre d'identifiant croissant.
	 */
	public List<Module> findAllOrderByIdAsc();

	/**
	 * M�thode de recherche de tous les Module en base par leur Etat.
	 * @author frankybo57
	 * @param etat l'Etat des Module � chercher en base.
	 * @return la List des Module trouv�s.
	 */
	public List<Module> findAllByEtat(final Etat etat);

	/**
	 * M�thode de recherche d'un Module en base par son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du Module � chercher en base.
	 * @return le Module renvoy�.
	 */
	public Module findOne(final Long id);

	/**
	 * M�thode de sauvegarde d'un Module en base.
	 * @author frankybo57
	 * @param module le Module � sauvegarder en base.
	 * @return le Module sauvegard�.
	 * @throws ModuleException
	 */
	public Module save(final Module module) throws ModuleException;

	/**
	 * M�thode de mise � jour d'un Module en base.
	 * @author frankybo57
	 * @param module la version � jour du Module.
	 * @return le Module � jour.
	 * @throws ModuleException
	 */
	public Module update(final Module module) throws ModuleException;

	/**
	 * M�thode de suppression d'un Module en base � partir de son identifiant.
	 * @author frankybo57
	 * @param id l'identifiant du Module � supprimer.
	 */
	public void delete(final Long id);
}
