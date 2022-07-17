package qa.free.tools.selenium.toolkit.exceptions;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class ElementNotSpecifiedException extends RuntimeException {

	private static final long serialVersionUID = 4208263002895288006L;

	public ElementNotSpecifiedException(String message) {
		super(message);
	}

	public ElementNotSpecifiedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ElementNotSpecifiedException(Throwable cause) {
		super(cause);
	}
	
}
