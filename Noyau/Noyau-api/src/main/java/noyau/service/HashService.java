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
	 * M�thode de hashage d'un mot de passe en SHA-512.
	 * @param password
	 * 				le mot de passe � hasher en SHA-512.
	 * @return
	 * 				le mot de passe hash�.
	 */
	String cryptage(final String password);
	
	/**
	 * M�thode de hashage d'un mot de passe avec un TypeHashage pass� en param�tre.
	 * @param password
	 * 				le mot de passe � hasher.
	 * @param type
	 * 				le TypeHashage � employer pour hasher le mot de passe.
	 * @return
	 * 				le mot de passe hash�.
	 */
	String cryptage(final String password, final TypeHashage type);
	
}
