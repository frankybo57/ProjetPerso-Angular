package noyau;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Verrou {
	
	private static final Logger logger = LogManager.getLogger(Verrou.class);
	
	private static final String SEL = "sel";
	
	
	private Verrou() {
		
	}
	
	public static String cryptage(String password) {
		return sha512(password,SEL);
	}
	
	private static String sha512(String password, String salt){
		String generatedPassword = null;
	    try {
	         MessageDigest md = MessageDigest.getInstance("SHA-512");
	         md.update(salt.getBytes("UTF-8"));
	         byte[] bytes = md.digest(password.getBytes("UTF-8"));
	         StringBuilder sb = new StringBuilder();
	         for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	         }
	         generatedPassword = sb.toString();
	    } 
	    catch (NoSuchAlgorithmException e) {
	    	if(logger.isErrorEnabled()) {
	    		logger.error("Erreur lors de la tentative de hashage : le hashage SHA-512 n'est pas disponible dans l'environnement");
	    	}
	    	if(logger.isDebugEnabled()) {
	    		logger.debug(e);
	    	}
	    }
	    catch (UnsupportedEncodingException e){
	    	if(logger.isErrorEnabled()) {
	    		logger.error("Erreur lors de la tentative de hashage : l'encodage en UTF-8 n'est pas supporté");
	    	}
	    	if(logger.isDebugEnabled()) {
	    		logger.debug(e);
	    	}
	    }
	    
	    return generatedPassword;
	}
	
	private static String md5(String password) {
		return password;
	}
	
}
