/**
 * 
 */
package exception;

/**
 * Exception fonctionnelle.
 * 
 * @author frankybo57
 *
 */
public class FonctionnelleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4693806004065514476L;

	/**
	 * 
	 */
	public FonctionnelleException() {

	}

	/**
	 * @param message
	 */
	public FonctionnelleException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public FonctionnelleException(Throwable cause) {
		super(cause);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public FonctionnelleException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FonctionnelleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
