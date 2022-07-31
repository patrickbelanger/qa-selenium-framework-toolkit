package qa.free.tools.selenium.toolkit.mock.page.object;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.enums.Locator;

public class ValidPageObject extends PageObject<ValidPageObject>{

	@Override
	public ValidPageObject goTo() {
		navigate().goTo("https://www.google.com");
		return this;
	}

	@FindElement(locator = Locator.NAME, element = "q")
	@Override
	public ValidPageObject isPageLoaded() {
		isPageLoaded(getBy());
		return this;
	}

}
