package qa.free.tools.selenium.toolkit.utilities.mock;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;

public class DummyPageObjectClassWithNoFindElements extends PageObject<DummyPageObjectClassWithNoFindElements> {

	@Override
	public DummyPageObjectClassWithNoFindElements goTo() {
		return this;
	}

	@Override
	public DummyPageObjectClassWithNoFindElements isPageLoaded() {
		isPageLoaded(getBy());
		return this;
	}
	
}
