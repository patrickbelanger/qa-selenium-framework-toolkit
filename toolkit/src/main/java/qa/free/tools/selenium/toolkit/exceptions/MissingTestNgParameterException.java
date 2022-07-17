package qa.free.tools.selenium.toolkit.exceptions;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class MissingTestNgParameterException extends RuntimeException {

	private static final long serialVersionUID = -7747712555400778464L;

	public MissingTestNgParameterException(String message) {
		super(message);
	}

	public MissingTestNgParameterException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MissingTestNgParameterException(Throwable cause) {
		super(cause);
	}
	
}
