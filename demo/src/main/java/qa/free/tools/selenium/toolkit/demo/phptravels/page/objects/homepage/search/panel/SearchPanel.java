package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.enums.Using;

public abstract class SearchPanel<T extends SearchPanel<T>> extends PageObject<T> {
	
	private static final String BUTTON_TAB_TARGET = "//button[@data-bs-target='%s']";
	
	public abstract void setSearchCriterias(Customer customer);
	
	@FindElement(element = BUTTON_TAB_TARGET)
	public SearchPanel<T> clickTabHotels() {
		return clickTab(getBy("#hotels"));
	}
	
	@FindElement(element = BUTTON_TAB_TARGET)
	public SearchPanel<T> clickTabFlights() {
		return clickTab(getBy("#flights"));
	}
	
	@FindElement(element = BUTTON_TAB_TARGET)
	public SearchPanel<T> clickTabTours() {
		return clickTab(getBy("#tours"));
	}
	
	@FindElement(element = BUTTON_TAB_TARGET)
	public SearchPanel<T> clickTabVisa() {
		return clickTab(getBy("#visa"));
	}
	
	private SearchPanel<T> clickTab(By by) {
		perform()
			.click()
			.against(by)
			.using(Using.JAVASCRIPT)
			.execute();
		return this;
	}
	
}
