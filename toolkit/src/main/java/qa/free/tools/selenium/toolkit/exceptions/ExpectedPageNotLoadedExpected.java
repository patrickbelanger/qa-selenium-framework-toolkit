package qa.free.tools.selenium.toolkit.exceptions;

public class ExpectedPageNotLoadedExpected extends RuntimeException {

	private static final long serialVersionUID = -641663771897510561L;

	public ExpectedPageNotLoadedExpected(String message) {
		super(message);
	}

	public ExpectedPageNotLoadedExpected(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExpectedPageNotLoadedExpected(Throwable cause) {
		super(cause);
	}
	
}
