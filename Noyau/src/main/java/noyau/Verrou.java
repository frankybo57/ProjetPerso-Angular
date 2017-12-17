package noyau;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Verrou {
	
	final static Logger logger = LogManager.getLogger(Verrou.class);
	
	private static final String sel = "sel";
	
	
	private Verrou() {
		
	}
	
	public static String cryptage(String password) {
		return sha512(password,sel);
	}
	
	private static String fonctionCryptage(String password) {
		StringBuilder temp = new StringBuilder(password);
		
		while (temp.length() < 255) {
			int length = temp.length();
			
			for (int i = 0; i < length; i++) {
				temp.insert(i, i+1);
				temp.insert(i+1, (char) i);
			}
		}
		
		temp.setLength(255);
		
		return temp.toString();
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
	
	private static String fonctionCryptageOld(String password) {
		StringBuilder temp = new StringBuilder(password);
		for(int i = 0; i < password.length(); i++) {
			temp.append(i+1);
			temp.append(password.charAt(i));
		}
		return temp.toString();
	}
	
}
