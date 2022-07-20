package qa.free.tools.selenium.toolkit.interactions;

import org.openqa.selenium.By;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetText;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetTextJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetTextSelenium;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Get {

	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private String attributeName;
	private GetText getText;
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private GetTextMethods method = GetTextMethods.TEXT;
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private Using using = Using.SELENIUM;

	public Get() {
		this.getText = getUsing().equals(Using.JAVASCRIPT) ?
				new GetTextJavascript() : new GetTextSelenium();
	}
	
	public Get text() {
		setMethod(GetTextMethods.TEXT);
		return this;
	}
	
	public Get attribute(String attributeName) {
		setMethod(GetTextMethods.ATTRIBUTE);
		setAttributeName(attributeName);
		return this;
	}
	
	public Get value() {
		setMethod(GetTextMethods.VALUE);
		return this;
	}
	
	public String from(By by) {
		if (getMethod().equals(GetTextMethods.ATTRIBUTE)) {
			return this.getText.getAttribute(by, getAttributeName());
		} else if (getMethod().equals(GetTextMethods.VALUE)) {
			return this.getText.getValue(by);
		}
		return this.getText.getText(by);
	}
	
	private enum GetTextMethods {
		ATTRIBUTE,
		TEXT,
		VALUE,
	}
	
}
