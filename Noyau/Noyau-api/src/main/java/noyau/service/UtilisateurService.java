package noyau.service;

import java.util.List;
import java.util.Map;

import exception.UtilisateurException;
import noyau.model.Utilisateur;

public interface UtilisateurService {

	/**
	 * M�thode de cr�ation d'un utilisateur �partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * Si l'utilisateur est cr�� il re�oit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur �cr�er.
	 * @param hash
	 * 		Si true alors hashage du mot de passe.
	 * @return
	 * 		Utilisateur cr��.
	 * @throws UtilisateurException
	 * 		
	 */
	public Utilisateur createOne(Utilisateur obj, final boolean hash) throws UtilisateurException;
	
	/**
	 * M�thode renvoyant la liste de tous les Utilisateur en base.
	 * @return List de tous les Utilisateur en base.
	 */
	public List<Utilisateur> findAll();
	
	/**
	 * M�thode de r�cup�ration d'un utilisateur �partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @throws UtilisateurException
	 * @param login
	 * 		Nom d'utilisateur.
	 * @param password
	 * 		Mot de passe.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return Utilisateur
	 * @throws UtilisateurException
	 * 		
	 */
	public Utilisateur findOne(final String login, final String password, final boolean hash) throws UtilisateurException;
	
	@SuppressWarnings("rawtypes")
	public Utilisateur getUtilisateurFromJson(final Map map);
	
	/**
	 * M�thode d'update d'un utilisateur avec ou sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param utilisateur
	 * 		Utilisateur �mettre � jour.
	 * @param propriete
	 * 		Propri�t� � mettre � jour.
	 * @param typePropriete
	 * 		Le type de la propri�t� � mettre � jour.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return
	 * 		Utilisateur mis �jour.
	 * @throws UtilisateurException
	 * 		
	 */
	public Utilisateur update(final Utilisateur utilisateur, final Object propriete, final String typePropriete, final boolean hash) throws UtilisateurException;
	
}
