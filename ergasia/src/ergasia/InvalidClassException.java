package ergasia;


public class InvalidClassException extends Exception {
	private static final long serialVersionUID = 1L;

	
	public InvalidClassException() {
	}

	
	public InvalidClassException(String message) {
		super(message);
	}

	
	public InvalidClassException(Throwable cause) {
		super(cause);
	}

	
	public InvalidClassException(String message, Throwable cause) {
		super(message, cause);
	}

	
	public InvalidClassException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
