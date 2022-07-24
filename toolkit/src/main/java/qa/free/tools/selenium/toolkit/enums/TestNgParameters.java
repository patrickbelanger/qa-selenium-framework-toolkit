package qa.free.tools.selenium.toolkit.enums;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public enum TestNgParameters {
	WEBDRIVER("webDriver", true),
	GRID_THIRD_PARTY("gridThirdParty", false),
	REMOTE("remote", false)
	;
	
	private String name;
	private boolean required;
	
	private TestNgParameters(String name, boolean required) {
		this.name = name;
		this.required = required;
	}

	public String getName() {
		return name;
	}

	public boolean isRequired() {
		return required;
	}
	
}
