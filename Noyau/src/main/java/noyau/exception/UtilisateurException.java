package noyau.exception;

public class UtilisateurException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4367739297874857677L;
	
	public UtilisateurException() {
		super();
	}

	public UtilisateurException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UtilisateurException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilisateurException(String message) {
		super(message);
	}

	public UtilisateurException(Throwable cause) {
		super(cause);
	}
}
