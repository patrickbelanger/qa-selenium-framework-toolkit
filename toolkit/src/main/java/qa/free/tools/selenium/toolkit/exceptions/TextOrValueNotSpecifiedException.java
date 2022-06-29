package qa.free.tools.selenium.toolkit.exceptions;

public class TextOrValueNotSpecifiedException extends RuntimeException {

	private static final long serialVersionUID = -3952889718163075510L;

	public TextOrValueNotSpecifiedException(String message) {
		super(message);
	}

	public TextOrValueNotSpecifiedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TextOrValueNotSpecifiedException(Throwable cause) {
		super(cause);
	}
	
}
