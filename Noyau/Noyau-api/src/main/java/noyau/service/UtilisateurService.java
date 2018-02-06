package noyau.service;

import java.util.List;
import java.util.Map;

import exception.UtilisateurException;
import noyau.model.Utilisateur;

public interface UtilisateurService {

	public static final String UTILISATEUR = "utilisateur";
	public static final String LOGIN = "login";
	public static final String MOT_DE_PASSE = "password";
	
	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * Si l'utilisateur est créé il reçoit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @param hash
	 * 		Si true alors hashage du mot de passe.
	 * @return
	 * 		Utilisateur créé.
	 * 		
	 */
	public Utilisateur createOne(Utilisateur obj, final boolean hash) throws UtilisateurException;
	
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	/**
	 * Méthode de récupération d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @throws UtilisateurException
	 * @param propriete
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
	 * Méthode d'update d'un utilisateur avec ou sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return
	 * 		Utilisateur mis à jour.
	 * 		
	 */
	public Utilisateur update(final Utilisateur obj, final Object propriete, final String typePropriete, final boolean hash) throws UtilisateurException;
	
}
