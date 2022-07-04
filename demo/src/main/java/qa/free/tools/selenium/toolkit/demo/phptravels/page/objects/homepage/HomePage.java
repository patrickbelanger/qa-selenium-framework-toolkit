package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.SearchType;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel.SearchPanel;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel.SearchPanelFlights;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel.SearchPanelHotels;

public class HomePage extends PageObject<HomePage> {
	
	@Override
	public HomePage goTo() {
		navigate().goTo("https://www.phptravels.net/");
		return this;
	}

	@Override
	public HomePage isPageLoaded() {
		isPageLoaded(By.id("select2-hotels_city-container"));
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SearchPanel searchPanel(SearchType searchType) {
		if (searchType.equals(SearchType.HOTELS)) {
			return new SearchPanelHotels();
		}
		return new SearchPanelFlights();
	}
	
}
