package qa.free.tools.selenium.toolkit.exceptions;

public class MissingClosingMethodInBuilderException extends RuntimeException {

	private static final long serialVersionUID = 8499406976658519796L;

	public MissingClosingMethodInBuilderException(String message) {
		super(message);
	}

	public MissingClosingMethodInBuilderException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MissingClosingMethodInBuilderException(Throwable cause) {
		super(cause);
	}
	
}
