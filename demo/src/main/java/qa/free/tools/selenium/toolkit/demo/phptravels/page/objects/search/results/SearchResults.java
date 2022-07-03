package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.search.results;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;

public abstract class SearchResults<T extends PageObject<T>> extends PageObject<SearchResults<T>> {

	@Override
	public SearchResults<T> goTo() {
		return null;
	}

	@Override
	public SearchResults<T> isPageLoaded() {
		isPageLoaded(By.xpath(""));
		return this;
	}

}
