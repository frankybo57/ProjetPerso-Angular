package exception;

public class ModuleException extends FonctionnelleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7367738761565923891L;

	public ModuleException() {

	}

	public ModuleException(String message) {
		super(message);

	}

	public ModuleException(Throwable cause) {
		super(cause);

	}

	public ModuleException(String message, Throwable cause) {
		super(message, cause);

	}

	public ModuleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
