package ergasia;

/**
 * diaxeirizetai to lathos apo ton xrhsth
 */
public class InvalidYearException extends Exception {
	private static final long serialVersionUID = 1L;

	
	public InvalidYearException() {
	}

	
	public InvalidYearException(String message) {
		super(message);
	}

	
	public InvalidYearException(Throwable cause) {
		super(cause);
	}

	
	public InvalidYearException(String message, Throwable cause) {
		super(message, cause);
	}

	
	public InvalidYearException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
