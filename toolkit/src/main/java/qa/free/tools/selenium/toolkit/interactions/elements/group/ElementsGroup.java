package qa.free.tools.selenium.toolkit.interactions.elements.group;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickSelenium;
import qa.free.tools.selenium.toolkit.utilities.PredicateHelper;

public abstract class ElementsGroup extends SeleniumCore {

	public void set(By by, String value) {
		Optional<WebElement> matchingWebElement = new PredicateHelper().getMatchingElement(by, value);
		if (matchingWebElement.isPresent()) {
			new ClickSelenium().click(matchingWebElement.get());
		}
	}
	
}
