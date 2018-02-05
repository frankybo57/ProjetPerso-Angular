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
	 * 		
	 */
	public Utilisateur createOne(Utilisateur obj, final boolean hash) throws UtilisateurException;
	
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
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
	 * @param obj
	 * 		Utilisateur �cr�er.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return
	 * 		Utilisateur mis �jour.
	 * 		
	 */
	public Utilisateur update(final Utilisateur obj, final boolean hash) throws UtilisateurException;
	
	/**
	 * M�thode d'update d'un utilisateur avec ou sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur �cr�er.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return
	 * 		Utilisateur mis �jour.
	 * 		
	 */
	public Utilisateur updateLogin(final Utilisateur obj, final String login, final boolean hash) throws UtilisateurException;
}
