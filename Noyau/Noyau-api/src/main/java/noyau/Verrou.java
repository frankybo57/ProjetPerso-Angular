package noyau;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe permettant le hashage des mots de passe.
 * 
 * @author frankybo57
 * @since 1.0
 * @version 1.0
 *
 */
public abstract class Verrou {
	
	//	private static final Logger logger = LogManager.getLogger(Verrou.class);
	
	private static final String SEL = "sel";
	private static final String UTF_8 = "UTF-8";
	
	
	protected Verrou() {
		
	}
	
	public static String cryptage(final String password) {
		return cryptage(password,SEL,TypeHashage.SHA512.toString());
	}
	
	public static String cryptage(final String password, final TypeHashage type) {
		switch(type) {
		case MD5 :
			return cryptage(password,SEL,TypeHashage.MD5.toString());
		case SHA1 :
			return cryptage(password,SEL,TypeHashage.SHA1.toString());
		case SHA256 :
			return cryptage(password,SEL,TypeHashage.SHA256.toString());
		case SHA512 :
			return cryptage(password,SEL,TypeHashage.SHA512.toString());
		default:
			return password;
		}
	}
	
	private static String cryptage(final String password, final String salt, final String algorithme) {
		String generatedPassword = null;
	    try {
	         final MessageDigest md = MessageDigest.getInstance(algorithme);
	         md.update(salt.getBytes(UTF_8));
	         final byte[] bytes = md.digest(password.getBytes(UTF_8));
	         StringBuilder sb = new StringBuilder();
	         for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	         }
	         generatedPassword = sb.toString();
	    } 
	    catch (final NoSuchAlgorithmException e) {
//	    	if(logger.isErrorEnabled()) {
//	    		logger.error("Erreur lors de la tentative de hashage : le hashage SHA-512 n'est pas disponible dans l'environnement");
//	    	}
//	    	if(logger.isDebugEnabled()) {
//	    		logger.debug(e);
//	    	}
	    }
	    catch (final UnsupportedEncodingException e){
//	    	if(logger.isErrorEnabled()) {
//	    		logger.error("Erreur lors de la tentative de hashage : l'encodage en UTF-8 n'est pas supporté");
//	    	}
//	    	if(logger.isDebugEnabled()) {
//	    		logger.debug(e);
//	    	}
	    }
	    
	    return generatedPassword;
	}
	
}
