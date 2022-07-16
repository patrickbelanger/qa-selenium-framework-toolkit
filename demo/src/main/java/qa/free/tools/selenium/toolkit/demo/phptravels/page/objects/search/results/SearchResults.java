package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.search.results;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;

public abstract class SearchResults<T extends SearchResults<T>> extends PageObject<T>  {

	public abstract int getNumberTotalOfFlights();
	
	@Override
	public T goTo() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T isPageLoaded() {
		isPageLoaded(By.xpath("//section[contains(@class,'breadcrumb-area')]"));
		return (T) this;
	}
	
}
