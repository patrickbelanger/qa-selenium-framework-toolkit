package qa.free.tools.selenium.toolkit.mock.page.object;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;

public class InvalidPageObject extends PageObject<InvalidPageObject>{

	@Override
	public InvalidPageObject goTo() {
		navigate().goTo("https://www.google.com");
		return this;
	}

	@Override
	public InvalidPageObject isPageLoaded() {
		isPageLoaded(getBy());
		return this;
	}

}
