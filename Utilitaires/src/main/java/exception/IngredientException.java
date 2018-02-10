/**
 * 
 */
package exception;

/**
 * @author frankybo57
 *
 */
public class IngredientException extends FonctionnelleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9125129254023822098L;

	/**
	 * 
	 */
	public IngredientException() {
		
	}

	/**
	 * @param message
	 */
	public IngredientException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public IngredientException(Throwable cause) {
		super(cause);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public IngredientException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IngredientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
