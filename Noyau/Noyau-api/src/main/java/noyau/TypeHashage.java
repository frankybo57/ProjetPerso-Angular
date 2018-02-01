package noyau;

/**
 * Enumération des différents types de hashages disponibles.
 * 
 * @author frankybo57
 * @since 0.0.0
 * @version 1.0
 *
 */
public enum TypeHashage {
	MD5 ("MD5"), SHA1 ("SHA-1"), SHA256 ("SHA-256"), SHA512 ("SHA-512");
	
	private String label;
	
	private TypeHashage(final String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
