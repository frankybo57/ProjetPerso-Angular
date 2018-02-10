package noyau.service.implementation;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import noyau.service.HashService;

/**
 * Classe implémentant l'interface HashService.
 * 
 * @author frankybo57
 * @since 1.0
 * @version 1.0
 *
 */
@Service
public class HashServiceImpl implements HashService {
	
	private static final String SEL = "sel";
	private static final String UTF_8 = "UTF-8";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String cryptage(final String password) {
		return cryptage(password,SEL,TypeHashage.SHA512.toString());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String cryptage(final String password, final TypeHashage type) {
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
	
	private String cryptage(final String password, final String salt, final String algorithme) {
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
	    	
	    }
	    catch (final UnsupportedEncodingException e){
	    	
	    }
	    
	    return generatedPassword;
	}
	
}
