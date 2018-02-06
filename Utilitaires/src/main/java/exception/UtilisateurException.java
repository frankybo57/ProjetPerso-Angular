package exception;

public class UtilisateurException extends FonctionnelleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4367739297874857677L;
	
	public UtilisateurException() {
		super();
	}

	public UtilisateurException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UtilisateurException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UtilisateurException(final String message) {
		super(message);
	}

	public UtilisateurException(final Throwable cause) {
		super(cause);
	}
}
