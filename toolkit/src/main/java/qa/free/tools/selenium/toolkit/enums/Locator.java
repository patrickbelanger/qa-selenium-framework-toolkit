package qa.free.tools.selenium.toolkit.enums;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public enum Locator {
	CLASS_NAME("className"),
	CSS_SELECTOR("cssSelector"),
	NAME("name"),
	ID("id"),
	LINK_TEXT("linkText"),
	PARTIAL_LINK_TEXT("partialLinkTest"),
	TAG_NAME("tagName"),
	XPATH("xpath")
	;
	
	private String description;
	
	private Locator(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
	
}
