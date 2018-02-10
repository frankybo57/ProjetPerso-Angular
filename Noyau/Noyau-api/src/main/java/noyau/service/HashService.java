package noyau.service;

import noyau.service.implementation.TypeHashage;

/**
 * Interface contractualisant le hashage des mots de passe.
 * 
 * @author frankybo57
 * @since 1.0
 * @version 1.0
 *
 */
public interface HashService {

	/**
	 * Méthode de hashage d'un mot de passe en SHA-512.
	 * @param password
	 * 				le mot de passe à hasher en SHA-512.
	 * @return
	 * 				le mot de passe hashé.
	 */
	String cryptage(final String password);
	
	/**
	 * Méthode de hashage d'un mot de passe avec un TypeHashage passé en paramètre.
	 * @param password
	 * 				le mot de passe à hasher.
	 * @param type
	 * 				le TypeHashage à employer pour hasher le mot de passe.
	 * @return
	 * 				le mot de passe hashé.
	 */
	String cryptage(final String password, final TypeHashage type);
	
}
