package noyau;

import noyau.model.Utilisateur;

public abstract class Verrou {
	
	private static final int increment = 16;
	private static final String sel = "sel";
	
	
	private Verrou() {
		
	}
	
	public static String cryptage(String password) {
		return fonctionCryptage(password);
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
