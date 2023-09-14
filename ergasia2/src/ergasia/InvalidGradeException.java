package ergasia;


public class InvalidGradeException extends Exception {
	private static final long serialVersionUID = 1L;

	
	public InvalidGradeException() {
	}

	
	public InvalidGradeException(String message) {
		super(message);
	}

	
	public InvalidGradeException(Throwable cause) {
		super(cause);
	}

	
	public InvalidGradeException(String message, Throwable cause) {
		super(message, cause);
	}

	
	public InvalidGradeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
