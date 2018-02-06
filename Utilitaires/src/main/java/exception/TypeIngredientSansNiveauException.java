/**
 * 
 */
package exception;

/**
 * Exception levée lorsqu'un typed'ingrédient n'a pas de niveau.
 * @author Dev
 *
 */
public class TypeIngredientSansNiveauException extends FonctionnelleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6758784407210807307L;

	/**
	 * 
	 */
	public TypeIngredientSansNiveauException() {

	}

	/**
	 * @param message
	 */
	public TypeIngredientSansNiveauException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public TypeIngredientSansNiveauException(Throwable cause) {
		super(cause);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public TypeIngredientSansNiveauException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TypeIngredientSansNiveauException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
