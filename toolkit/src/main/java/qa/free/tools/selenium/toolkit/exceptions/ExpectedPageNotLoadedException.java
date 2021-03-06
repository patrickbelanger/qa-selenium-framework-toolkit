package qa.free.tools.selenium.toolkit.exceptions;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class ExpectedPageNotLoadedException extends RuntimeException {

	private static final long serialVersionUID = -641663771897510561L;

	public ExpectedPageNotLoadedException(String message) {
		super(message);
	}

	public ExpectedPageNotLoadedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExpectedPageNotLoadedException(Throwable cause) {
		super(cause);
	}
	
}
